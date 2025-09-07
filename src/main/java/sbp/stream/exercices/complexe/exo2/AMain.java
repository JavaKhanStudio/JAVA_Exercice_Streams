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
        // long nbJourVents = theList
        // Expected : 2487

        // Verifier si au moins une journée est au dessus de 50 degree
        // boolean jourTropChaud = theList
        // Expected : False

        // Trouver la moyenne une température en dessous de 0 en bretagne
        // long jourFroidBretagne = theList
        // Expected : 48

        // Grouper par region les jours ou la temperature fut de 22 degree
        // Map<RegionEnum, List<RapportClimatJournalier>> jourA22ParRegion = theList
        // Expected : Une longue liste {GRAND_EST=[RapportClimatJournalier(region=GRAND_EST, date=Fri Jun 24 00:00:00 CEST 2022, temperature=22, pluieEnMl=18, ventKmH=24)...

        // Trouver le rapport du jour le plus "actif" (total pluie + Temperature + Vent)
        // RapportClimatJournalier jourActif = theList
        // Expected : RapportClimatJournalier(region=BRETAGNE, date=Thu Oct 24 00:00:00 CEST 2024, temperature=19, pluieEnMl=46, ventKmH=89)

        // Trouver le jour le plus froid de la corse en 2022
        // RapportClimatJournalier jourFroid = theList
        // Expected : RapportClimatJournalier(region=CORSE, date=Fri Jan 14 00:00:00 CET 2022, temperature=-2, pluieEnMl=16, ventKmH=0)

        // Trouver la somme en ML des pluies de tous les jours avec une température au-dessus de 20 degrees en grand est
        // int pluie = theList
        // Expected : 1860

        // Trouver la région avec le jour le plus chaud de juillet des années pairs
        // RegionEnum jourChaud = theList
        // Expected : CENTRE_VAL_DE_LOIRE

        // Retourner le nombre de jours, grouper par region, où la temperature fut de 22 degree
        // Map<RegionEnum, Long> nombreJourA22ParRegion = theList
        // Expected : {OCCITANIE=44, CENTRE_VAL_DE_LOIRE=20, BOURGOGNE_FRANCHE_COMTE=15, GRAND_EST=17, BRETAGNE=17, ILE_DE_FRANCE=14, NORMANDIE=12, CORSE=53, HAUTS_DE_FRANCE=13}

        // Difficile //
        // Si vous avez besoin, allez trouver de l'aide

        // Trouver le jour en moyenne le plus chaud, toute région confondu
        // Date jourEnMoyenneChaud = theList
        // Expected : Mon Jul 24 00:00:00 CEST 2023

        // Trouver la somme des pluie en Occitanie pour les mois ayant une temperature moyenne au dessus de 20
        // int totalPluie = theList
        // Expected :  1425

    }

}
