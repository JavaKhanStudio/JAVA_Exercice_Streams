package sbp.stream.exercices.complexe.exo2.testing;

import sbp.stream.exercices.complexe.exo2.BanqueDeDonnees;
import sbp.stream.exercices.complexe.exo2.enums.RegionEnum;
import sbp.stream.exercices.complexe.exo2.model.RapportClimatJournalier;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.*;

public class ClimateAnalytics {

    // ---- Helpers ----
    private static LocalDate toLocalDate(Date d) {
        return d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private static int year(Date d) { return toLocalDate(d).getYear(); }
    private static int month(Date d) { return toLocalDate(d).getMonthValue(); }

    // Add some artificial CPU work per element to make parallelism pay off
    private static double cpuNoise(int seed) {
        // ~50k float ops — tweak 'loops' if you want more/less load
        int loops = 50_000;
        double x = seed * 0.01337;
        for (int i = 0; i < loops; i++) {
            x = Math.sin(x) * Math.cos(x) + Math.sqrt(Math.abs(x) + 1e-9);
        }
        return x;
    }

    // Risk flags
    private static boolean isHeatwave(RapportClimatJournalier r) { return r.getTemperature() >= 35; }
    private static boolean isFrost(RapportClimatJournalier r) { return r.getTemperature() <= 0; }
    private static boolean isHeavyRain(RapportClimatJournalier r) { return r.getPluieEnMl() >= 30; }
    private static boolean isWindy(RapportClimatJournalier r) { return r.getVentKmH() >= 70; }

    // ---- 1) Big concurrent regional stats (with CPU load) ----
    public static class RegionalStats {
        public final long countDays;
        public final double avgTemp;
        public final int maxWind;
        public final int totalRain;
        public final long heatwaveDays;
        public final long frostDays;
        public final long heavyRainDays;
        public final long windyDays;

        RegionalStats(long countDays, double avgTemp, int maxWind, int totalRain,
                      long heatwaveDays, long frostDays, long heavyRainDays, long windyDays) {
            this.countDays = countDays;
            this.avgTemp = avgTemp;
            this.maxWind = maxWind;
            this.totalRain = totalRain;
            this.heatwaveDays = heatwaveDays;
            this.frostDays = frostDays;
            this.heavyRainDays = heavyRainDays;
            this.windyDays = windyDays;
        }

        @Override public String toString() {
            return "days=" + countDays + ", avgTemp=" + String.format("%.2f", avgTemp)
                    + ", maxWind=" + maxWind + ", totalRain=" + totalRain
                    + ", heatwaveDays=" + heatwaveDays + ", frostDays=" + frostDays
                    + ", heavyRainDays=" + heavyRainDays + ", windyDays=" + windyDays;
        }
    }

    public static Map<RegionEnum, RegionalStats> computeRegionalStatsParallel(List<RapportClimatJournalier> data) {
        // Each element does a bit of CPU work + we use groupingByConcurrent to enable parallel reductions
        return data.parallelStream()
                .peek(r -> cpuNoise(r.getTemperature() * 31 + r.getVentKmH() * 7 + r.getPluieEnMl()))
                .collect(Collectors.groupingByConcurrent(
                        RapportClimatJournalier::getRegion,
                        Collectors.collectingAndThen(Collectors.toList(), list -> {
                            long count = list.size();
                            double avgTemp = list.stream().mapToInt(RapportClimatJournalier::getTemperature).average().orElse(0);
                            int maxWind = list.stream().mapToInt(RapportClimatJournalier::getVentKmH).max().orElse(0);
                            int totalRain = list.stream().mapToInt(RapportClimatJournalier::getPluieEnMl).sum();
                            long heat = list.stream().filter(ClimateAnalytics::isHeatwave).count();
                            long frost = list.stream().filter(ClimateAnalytics::isFrost).count();
                            long heavy = list.stream().filter(ClimateAnalytics::isHeavyRain).count();
                            long windy = list.stream().filter(ClimateAnalytics::isWindy).count();
                            return new RegionalStats(count, avgTemp, maxWind, totalRain, heat, frost, heavy, windy);
                        })
                ));
    }

    // ---- 2) Longest streaks (heatwave/frost) per region in parallel ----
    public static class Streaks {
        public final int longestHeatwaveStreak;
        public final int longestFrostStreak;
        Streaks(int h, int f) { longestHeatwaveStreak = h; longestFrostStreak = f; }
        @Override public String toString() { return "heatwave=" + longestHeatwaveStreak + ", frost=" + longestFrostStreak; }
    }

    public static Map<RegionEnum, Streaks> computeLongestStreaksParallel(List<RapportClimatJournalier> data) {
        // Group by region first (Concurrent), then compute streaks per region in parallel
        ConcurrentMap<RegionEnum, List<RapportClimatJournalier>> byRegion = data.parallelStream()
                .collect(Collectors.groupingByConcurrent(RapportClimatJournalier::getRegion));

        return byRegion.entrySet().parallelStream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> {
                    List<RapportClimatJournalier> days = e.getValue().stream()
                            .sorted(Comparator.comparing(RapportClimatJournalier::getDate))
                            .collect(Collectors.toList());
                    return new Streaks(
                            longestStreak(days, ClimateAnalytics::isHeatwave),
                            longestStreak(days, ClimateAnalytics::isFrost)
                    );
                }));
    }

    private static int longestStreak(List<RapportClimatJournalier> sortedDays, Function<RapportClimatJournalier, Boolean> predicate) {
        int best = 0, cur = 0;
        LocalDate prev = null;
        for (RapportClimatJournalier r : sortedDays) {
            LocalDate d = toLocalDate(r.getDate());
            boolean consecutive = (prev == null) || ChronoUnit.DAYS.between(prev, d) == 1;
            if (!consecutive) cur = 0;
            if (predicate.apply(r)) { cur++; best = Math.max(best, cur); }
            else cur = 0;
            prev = d;
        }
        return best;
    }

    // ---- 3) 90th percentile wind per (region, year, month) using multi-level concurrent grouping ----
    public static class KeyRYM {
        public final RegionEnum region;
        public final int year;
        public final int month;
        public KeyRYM(RegionEnum r, int y, int m) { region = r; year = y; month = m; }
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof KeyRYM)) return false;
            KeyRYM k = (KeyRYM) o; return year == k.year && month == k.month && region == k.region;
        }
        @Override public int hashCode() { return Objects.hash(region, year, month); }
        @Override public String toString() { return region + " " + year + "-" + String.format("%02d", month); }
    }

    public static Map<KeyRYM, Integer> windP90ByRegionYearMonthParallel(List<RapportClimatJournalier> data) {
        // Collect values into lists concurrently, then compute percentile
        Map<KeyRYM, List<Integer>> grouped = data.parallelStream()
                .collect(Collectors.groupingByConcurrent(
                        r -> new KeyRYM(r.getRegion(), year(r.getDate()), month(r.getDate())),
                        Collectors.mapping(RapportClimatJournalier::getVentKmH, Collectors.toList())
                ));
        return grouped.entrySet().parallelStream().collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> percentile(e.getValue(), 0.90)
        ));
    }

    private static int percentile(List<Integer> values, double p) {
        if (values.isEmpty()) return 0;
        List<Integer> v = new ArrayList<>(values);
        Collections.sort(v);
        int idx = (int) Math.ceil(p * v.size()) - 1;
        idx = Math.max(0, Math.min(idx, v.size() - 1));
        return v.get(idx);
    }

    // ---- 4) Rolling 7-day average temperature per (region, year) in parallel ----
    public static class RollingPoint {
        public final LocalDate date;
        public final double avg7;
        RollingPoint(LocalDate d, double a) { date = d; avg7 = a; }
        @Override public String toString() { return date + " -> " + String.format("%.2f", avg7); }
    }

    public static Map<String, List<RollingPoint>> rolling7AvgTempByRegionYearParallel(List<RapportClimatJournalier> data) {
        // Group by (region, year) concurrently
        Map<String, List<RapportClimatJournalier>> groups = data.parallelStream()
                .collect(Collectors.groupingByConcurrent(r -> r.getRegion() + "-" + year(r.getDate())));

        // Parallel compute rolling averages in each group
        return groups.entrySet().parallelStream().collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> {
                    List<RapportClimatJournalier> sorted = e.getValue().stream()
                            .sorted(Comparator.comparing(RapportClimatJournalier::getDate))
                            .collect(Collectors.toList());
                    ArrayDeque<Integer> window = new ArrayDeque<>();
                    List<RollingPoint> out = new ArrayList<>(sorted.size());
                    int sum = 0;
                    for (RapportClimatJournalier r : sorted) {
                        int t = r.getTemperature();
                        window.addLast(t);
                        sum += t;
                        if (window.size() > 7) sum -= window.removeFirst();
                        double avg = sum / (double) window.size();
                        out.add(new RollingPoint(toLocalDate(r.getDate()), avg));
                    }
                    return out;
                }
        ));
    }

    // ---- 5) One-stop “complex parallel” benchmark that calls everything ----
    public static void testComplexeParallel(BanqueDeDonnees banque) {
        long start = System.nanoTime();

        // 0) Keep your original quick count (forces parallel split)
        long nombreBretagne = banque.theList.parallelStream()
                .filter(rapport -> rapport.getRegion() == RegionEnum.BRETAGNE)
                .count();

        // 1) Regional stats (concurrent grouping + per-element CPU noise)
        Map<RegionEnum, RegionalStats> stats = computeRegionalStatsParallel(banque.theList);

        // 2) Longest heatwave/frost streaks per region
        Map<RegionEnum, Streaks> streaks = computeLongestStreaksParallel(banque.theList);

        // 3) 90th percentile wind per (region, year, month)
        Map<KeyRYM, Integer> p90Wind = windP90ByRegionYearMonthParallel(banque.theList);

        // 4) Rolling 7-day average temperature per (region, year)
        Map<String, List<RollingPoint>> rolling = rolling7AvgTempByRegionYearParallel(banque.theList);

        long end = System.nanoTime();
        System.out.println("Bretagne days: " + nombreBretagne);
        System.out.println("Regions stats: " + stats);
        System.out.println("Streaks: " + streaks);
        // Print a tiny sample to keep output readable
        System.out.println("Wind P90 sample: " + p90Wind.entrySet().stream().limit(8).collect(Collectors.toList()));
        System.out.println("Rolling sample: " + rolling.entrySet().stream().limit(2).collect(Collectors.toList()));
        System.out.println("Temps d'exécution: " + (end - start) / 1_000_000_000.0 + " secondes");
    }
}
