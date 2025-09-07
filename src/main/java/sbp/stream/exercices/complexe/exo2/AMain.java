package sbp.stream.exercices.complexe.exo2;

import sbp.stream.exercices.complexe.exo2.enums.RegionEnum;
import sbp.stream.exercices.complexe.exo2.model.RapportClimatJournalier;

import java.util.*;
import java.util.stream.Collectors;

public class AMain {

    public static void main(String[] args) {
        System.out.println("-- Debut des test des exercices sur les streams --");
        BanqueDeDonnees banque = new BanqueDeDonnees();

        List<RapportClimatJournalier> theList = banque.theList ;

        // Trouver le nombre de jour ayant eu des vents au dessus de 44 KM/H
        long nbJourVents = theList
                .stream()
                .filter(rapport -> rapport.getVentKmH() > 44)
                .count() ;

        // Verifier si au moins une journée est au dessus de 50 degree
        boolean jourTropChaud = theList
                .stream()
                .anyMatch(rapport -> rapport.getTemperature() > 50);

        // Trouver la moyenne une température en dessous de 0 en bretagne
        long jourFroidBretagne = theList
                .stream()
                .filter(rapport -> rapport.getRegion() == RegionEnum.BRETAGNE)
                .filter(rapport -> rapport.getTemperature() < 0)
                .count() ;

        // Grouper par region les jours ou la temperature fut de 22 degree
        Map<RegionEnum, List<RapportClimatJournalier>> jourA22ParRegion = theList
                .stream()
                .filter(rapport -> rapport.getTemperature() == 22)
                .collect(Collectors.groupingBy(RapportClimatJournalier::getRegion)) ;


        // Trouver le rapport du jour le plus "actif" (total pluie + Temperature + Vent)
        RapportClimatJournalier jourActif = theList
                .stream()
                .max(Comparator.comparingInt(rapport -> rapport.getVentKmH() + rapport.getTemperature() + rapport.getPluieEnMl()))
                .get() ;

        // Trouver le jour le plus froid de la corse en 2022
        RapportClimatJournalier jourFroid = theList
                .stream()
                .filter(rapport -> rapport.getRegion() == RegionEnum.CORSE)
                .min(Comparator.comparing(RapportClimatJournalier::getTemperature))
                .orElse(null) ;

        // Expected : RapportClimatJournalier(region=CORSE, date=Fri Jan 14 00:00:00 CET 2022, temperature=-2, pluieEnMl=16, ventKmH=0)

        // Trouver la somme en ML des pluies de tous les jours avec une température au-dessus de 20 degrees en grand est
        int pluie = theList
                .stream()
                .filter(rapport -> rapport.getRegion() == RegionEnum.GRAND_EST)
                .filter(rapport -> rapport.getTemperature() > 20)
                .mapToInt(RapportClimatJournalier::getPluieEnMl)
                .sum() ;


        // Trouver la région avec le jour le plus chaud de juillet des années pairs
        RegionEnum jourChaud = theList
                .stream()
                .filter(rapport -> rapport.getDate().getYear() % 2 == 0)
                .filter(rapport -> rapport.getDate().getMonth() == 06)
                .max(Comparator.comparing(RapportClimatJournalier::getTemperature))
                .map(x -> x.getRegion())
                .orElse(null) ;


        // Retourner le nombre de jours, grouper par region, où la temperature fut de 22 degree
        Map<RegionEnum, Long> nombreJourA22ParRegion = theList
                .stream()
                .filter(rapport -> rapport.getTemperature() == 22)
                .collect(Collectors.groupingBy(RapportClimatJournalier::getRegion,
                        Collectors.counting()))
                ;


        // Difficile - Si vous avez besoin, allez trouver de l'aide



        // Trouver le jour en moyenne le plus chaud, toute région confondu
        Date jourEnMoyenneChaud = theList
                .stream()
                .collect(Collectors.groupingBy(RapportClimatJournalier::getDate))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry
                        .getValue()
                        .stream()
                        .mapToInt(RapportClimatJournalier::getTemperature).average().orElse(0)))
                .map(Map.Entry::getKey)
                .orElse(null) ;

        // Trouver la somme des pluie en Occitanie pour les mois ayant une temperature moyenne au dessus de 20
        int totalPluie = theList
                .stream()
                .filter(rapport -> rapport.getRegion() == RegionEnum.OCCITANIE)
                .collect(Collectors.groupingBy(o -> o.getDate().getMonth() + "/" + o.getDate().getYear()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().stream()
                        .mapToInt(RapportClimatJournalier::getTemperature)
                        .average().orElse(0) > 20)
                .flatMapToInt(entry -> entry.getValue().stream().mapToInt(r -> r.getPluieEnMl()))
                .sum() ;

        System.out.println(jourFroid);
        System.out.println(jourChaud);
        System.out.println(pluie);

    }

}
