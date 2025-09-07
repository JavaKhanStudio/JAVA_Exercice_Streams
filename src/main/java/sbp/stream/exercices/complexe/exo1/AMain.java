package sbp.stream.exercices.complexe.exo1;


import sbp.stream.exercices.complexe.exo1.enums.SexeEnum;
import sbp.stream.exercices.complexe.exo1.model.Animal;
import sbp.stream.exercices.complexe.exo1.model.Personne;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static sbp.stream.exercices.complexe.exo1.BanqueDeDonnees.people;
import static sbp.stream.exercices.complexe.exo1.enums.AnimalTypeEnum.CHAT;
import static sbp.stream.exercices.complexe.exo1.enums.AnimalTypeEnum.CHIEN;

public class AMain {

    // Bienvenue dans ce puzzle
    // Chaque element de ce dernier peut être résolu en un seul stream
    // Il faut set la variable à l'aide de ce stream pour voir si votre réponse est juste
    public static void codePourPuzzle() {

        // Exemple Trouver le nombre de personnes majeur dans la liste
        long nombrePerssoneMajeur = -1 ;
        // nombrePerssoneMajeur = people.stream()


        // Retourner tous les d'homme
        List<Personne> listeHomme = Collections.emptyList();
        //listeHomme = people.stream()

        // Trouver le nombre d'inconnus mineur
        long nombreInconnuMineur = -1 ;
        //nombreInconnuMineur = people.stream()


        // Trouver La somme totale de l'argent gagné par les femmes majeures
        long argentFemmeMajeur = -1 ;
        // argentFemmeMajeur = people.stream()

        // Trouver la plus vieille personne dans la liste
        Personne vieux = null ;
        //vieux = people.stream()


        // En gardant uniquement les personnes majeures,
        // D'un sexe définit (pas d'inconnu)
        // diviser la liste par un map diviser par genre
        Map<SexeEnum, List<Personne>> persons = new HashMap<>() ;
        // persons = people.stream()

        // Organiser, en ordre croissant, les hommes de moins de 40 ans par salaire.
        // Retourner uniquement les salaires
        int[] salaireHommeOrdreCroissant = new int[0] ;
        // salaireHommeOrdreCroissant = people.stream()


        // Trouver tous les animaux de compagnie
        List<Animal> animaux = Collections.emptyList();
        // animaux = people.stream()


        // Trouver le total des lengths de tous les noms de tous les animaux
        // Appartement à des femmes majeures
        // Pour les animaux autres que des chats ou des chiens
        long animalNameLength = -1 ;
        // animalNameLength = people.stream()


        // Parfois une liste c'est plus simple
        AtomicReference<Integer> total = new AtomicReference<>(0);
        for(Personne person : people) {
            if(person.getAge() >= 18 && person.getSexe() == SexeEnum.FEMELLE) {
                person.getAnimaux().forEach(
                        animal -> {
                            if(animal.getAnimalType() != CHIEN && animal.getAnimalType() != CHAT) {
                                total.updateAndGet(v -> v + animal.getNom().length());
                            }
                        }
                );
            }
        }


        // Combiner le noms de tous les animaux unique en un seul string
        // En séparant chaque nom d'une ","
        String megaNom = people
                .stream()
                .flatMap(personne -> personne.getAnimaux().stream())
                .distinct()
                .map(Animal::getNom)
                .collect(Collectors.joining(",")) ;


        // Combiner le salaire de tous les hommes
        // en enlevant leurs impôts (De facon directe, aka, non réaliste)
        // Salaire < 30000 = 10%
        // Salaire < 60000 = 20 %
        // Salaire >= 60000 = 30 %
        double totalSalairesApresTaxes = people
                .stream()
                .filter(personne -> personne.getSexe() == SexeEnum.MALE)
                .mapToDouble(Personne::getSalaire)
                .map(s -> {
                    if (s < 30_000)    return s * 90 / 100;
                    if (s < 60_000)    return s * 80 / 100;
                    return s * 70 / 100;
                })
                .sum() ;


        // Difficile -> Faite la même chose, mais de facon réaliste
        double totalSalairesApresTaxesPropre = people
                .stream()
                .filter(personne -> personne.getSexe() == SexeEnum.MALE)
                .mapToDouble(personne -> appliquerImpots(personne.getSalaire()))
                .sum() ;


        moulinetteDeVerification(nombrePerssoneMajeur, listeHomme, nombreInconnuMineur, argentFemmeMajeur, vieux, animaux, animalNameLength,
                persons.size(),salaireHommeOrdreCroissant, megaNom, totalSalairesApresTaxes, totalSalairesApresTaxesPropre) ;
        
    }

    private static double appliquerImpots(int salaire) {
        int net = 0;

        // Première tranche : jusqu’à 30k à 90%
        int tranche1 = Math.min(salaire, 30_000);
        net += tranche1 * 90 / 100;

        // Deuxième tranche : jusqu’à 60k à 80%
        if (salaire > 30_000) {
            int tranche2 = Math.min(salaire - 30_000, 30_000);
            net += tranche2 * 80 / 100;
        }

        // Troisième tranche : le reste à 70%
        if (salaire > 60_000) {
            int tranche3 = salaire - 60_000;
            net += tranche3 * 70 / 100;
        }

        return net;
    }


    public static void moulinetteDeVerification(long nombrePerssoneMajeur,List<Personne> listeHomme, long nombreInconnuMineur, long argentFemmeMajeur,Personne vieux,List<Animal> animaux,long animalNameLength,
                                                long persons,int[] salaireHommeOrdreCroissant, String megaNom, double totalSalairesApresTaxes,double totalSalairesApresTaxesPropre) {

        String fullMessage = "";

        fullMessage += "=== Résultat des streams ===\n";
        fullMessage += "- " + generateMessage("nombrePerssoneMajeur",
                nombrePerssoneMajeur,
                nombrePerssoneMajeur == 44,
                nombrePerssoneMajeur == -1 || nombrePerssoneMajeur == 0);
        fullMessage += "- " + generateMessage("listeHomme",
                listeHomme,
                listeHomme.size() == 18,
                listeHomme.isEmpty());
        fullMessage += "- " + generateMessage("nombreInconnuMineur",
                nombreInconnuMineur,
                nombreInconnuMineur == 14,
                nombreInconnuMineur == -1 || nombreInconnuMineur == 0);

        fullMessage += "- " + generateMessage("argentFemmeMajeur",
                argentFemmeMajeur,
                argentFemmeMajeur == 1196000,
                argentFemmeMajeur == -1 || argentFemmeMajeur == 0);

        fullMessage += "- " + generateMessage("vieux",
                vieux != null,
                vieux!= null && vieux.getNom().equals("George"),
                vieux == null);

        fullMessage += "- " + generateMessage("animaux",
                animaux,
                animaux.size() == 49,
                animaux.isEmpty());

        fullMessage += "- " + generateMessage("animalNameLength",
                animalNameLength,
                animalNameLength == 20,
                animalNameLength == -1 || animalNameLength == 0);

        fullMessage += "- " + generateMessage("persons",
                persons,
                persons == 2,
                persons == 0);

        fullMessage += "- " + generateMessage("salaireHommeOrdreCroissant",
                salaireHommeOrdreCroissant,
                salaireHommeOrdreCroissant.length == 15 && salaireHommeOrdreCroissant[0] == 0 && salaireHommeOrdreCroissant[14] == 72000,
                salaireHommeOrdreCroissant.length == 0);

        fullMessage += "- " + generateMessage("megaNom",
                megaNom,
                "Milo,Bella,Leo,Luna,Charlie,Chloe,Max,Sophie,Oscar,Daisy,Rex,Bailey,Buddy,Coco,Rocky,Molly,Duke,Syn,Buster,Sadie,Silly,Mindy,Shelly,Tank,Turbo,Speedy,Yoda,Ninja,Shere Khan,Tigra,Tiger,Snowball,Whiskers,Rusty,Simba,Patches".equals(megaNom),
                "".equals(megaNom)) ;

        fullMessage += "- " + generateMessage("totalSalairesApresTaxes",
                totalSalairesApresTaxes,
                totalSalairesApresTaxes == 684500.0,
                totalSalairesApresTaxes == 0) ;

        fullMessage += "- " + generateMessage("totalSalairesApresTaxes",
                totalSalairesApresTaxesPropre,
                totalSalairesApresTaxesPropre == 777500.0,
                totalSalairesApresTaxesPropre == 0) ;

        JOptionPane.showMessageDialog(null, fullMessage);
    }

    // Method to generate messages
    private static String generateMessage(String variableName, Object variableValue, boolean isCorrect, boolean isNotTried) {
        if(isNotTried) {
            return String.format("ℹ Vous n'avez pas encore essayé **%s**.\n", variableName) ;
        } else if (isCorrect) {
            return String.format("✔ Vous avez raison ! La réponse pour **%s** est correcte.\n", variableName) ;
        } else {
            return String.format("❌ Il semble que la réponse pour **%s** soit incorrecte, essayez encore.\n", variableName);
        }
    }


    public static void main(String[] args) {
        try {
            codePourPuzzle() ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Vous sembler avoir brisé quelque chose... allez voir la console !", "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}
