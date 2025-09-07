package sbp.stream.exercices.complexe.exo2;

import sbp.stream.exercices.complexe.exo2.enums.RegionEnum;
import sbp.stream.exercices.complexe.exo2.model.RapportClimatJournalier;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class AMain {

    public static void main(String[] args) {
        System.out.println("-- Debut des test des exercices sur les streams --");
        BanqueDeDonnees banque = new BanqueDeDonnees();

        List<RapportClimatJournalier> theList = banque.theList ;

        // Trouver le jour le plus froid de la corse en 2022
        RapportClimatJournalier jourFroid = theList
                .stream()
                .filter(rapport -> rapport.getRegion() == RegionEnum.CORSE)
                .min(Comparator.comparing(RapportClimatJournalier::getTemperature))
                .orElse(null) ;

        // Expected : RapportClimatJournalier(region=CORSE, date=Fri Jan 14 00:00:00 CET 2022, temperature=-2, pluieEnMl=16, ventKmH=0)

        // Trouver le jour le plus chaud de juillet des années pairs
        RapportClimatJournalier jourChaud = theList
                .stream()
                .filter(rapport -> rapport.getDate().getYear() % 2 == 0)
                .filter(rapport -> rapport.getDate().getMonth() == 06)
                .max(Comparator.comparing(RapportClimatJournalier::getTemperature))
                        .orElse(null) ;


        System.out.println(jourFroid);
        System.out.println(jourChaud);

    }

}
