package sbp.stream.exercices.complexe.exo2;

import sbp.stream.exercices.complexe.exo2.model.RapportClimatJournalier;

import java.util.List;

public class AMain {

    public static void main(String[] args) {
        System.out.println("-- Debut des test des exercices sur les streams --");
        BanqueDeDonnees banque = new BanqueDeDonnees();

        List<RapportClimatJournalier> theList = banque.theList ;


        theList.stream() ;

    }

}
