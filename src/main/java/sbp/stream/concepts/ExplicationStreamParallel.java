package sbp.stream.concepts;

import sbp.stream.exercices.complexe.exo2.BanqueDeDonnees;
import sbp.stream.exercices.complexe.exo2.enums.RegionEnum;

public class ExplicationStreamParallel {

    public static void main(String[] args) {

        System.out.println("-- Debut des test des Streams Parallel --");
        BanqueDeDonnees banque = new BanqueDeDonnees();

        testSimple(banque);
        testSimpleParallel(banque);
        testComplexeParallel(banque);
    }

    public static void testSimple(BanqueDeDonnees banque) {
        System.out.println("- Debut du test Simple -");

        long start = System.nanoTime();

        long nombreBretagne = banque.theList.stream()
                .filter(rapport -> rapport.getRegion() == RegionEnum.BRETAGNE)
                .count();

        long nombreIDF = banque.theList.stream()
                .filter(rapport -> rapport.getRegion() == RegionEnum.ILE_DE_FRANCE)
                .count();

        long end = System.nanoTime();

        System.out.println("Il y a " + nombreBretagne + " elements en " + RegionEnum.BRETAGNE);
        System.out.println("Il y a " + nombreIDF + " elements en " + RegionEnum.ILE_DE_FRANCE);
        System.out.println("Temps d'exécution: " + (end - start) / 1_000_000_000.0 + " secondes");
    }

    public static void testSimpleParallel(BanqueDeDonnees banque) {
        System.out.println("- Debut du test Simple Parallel -");

        long start = System.nanoTime();

        long nombreBretagne = banque.theList.stream()
                .parallel()
                .filter(rapport -> rapport.getRegion() == RegionEnum.BRETAGNE)
                .count();

        long nombreIDF = banque.theList.stream()
                .parallel()
                .filter(rapport -> rapport.getRegion() == RegionEnum.ILE_DE_FRANCE)
                .count();

        long end = System.nanoTime();

        System.out.println("Il y a " + nombreBretagne + " elements en " + RegionEnum.BRETAGNE);
        System.out.println("Il y a " + nombreIDF + " elements en " + RegionEnum.ILE_DE_FRANCE);
        System.out.println("Temps d'exécution: " + (end - start) / 1_000_000_000.0 + " secondes");
    }

    public static void testComplexeParallel(BanqueDeDonnees banque) {
        System.out.println("- Debut du test Complexe -");
        long start = System.nanoTime();

        banque.theList.stream()
                .forEach(rapport -> cpuNoise(rapport.getPluieEnMl()));

        long end = System.nanoTime();

        System.out.println("Temps d'exécution standard: " + (end - start) / 1_000_000_000.0 + " secondes");

        start = System.nanoTime();

        banque.theList.stream()
                .parallel()
                .forEach(rapport -> cpuNoise(rapport.getPluieEnMl()));

        end = System.nanoTime();

        System.out.println("Temps d'exécution parallel: " + (end - start) / 1_000_000_000.0 + " secondes");
    }

    private static long cpuNoise(int seed) {

        int loops = 50_000;
        double x = seed * 0.01337;
        for (int i = 0; i < loops; i++) {
            x = Math.sin(x) * Math.cos(x) + Math.sqrt(Math.abs(x) + 1e-9);
        }

        return (long) (loops * x);
    }

}
