package sbp.lambda.exercices;

import java.util.List;

public class Exo1_Correction {

    static List<String> fruits = List.of("Pomme", "Banane", "Cerise", "Orange");
    static List<Integer> nombres = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    static List<String> prenoms = List.of("Alice", "Bob", "Charlie", "David", "Emma");

    public static void main(String[] args) {

        System.out.println("=== EXERCICE 0 ===");
        // Remplacez la méthode suivante par une LAMBDA :
        fruits.forEach(f -> System.out.println(f));

        System.out.println("\n=== EXERCICE 1 ===");
        // Remplacez la référence de méthode par une EXPRESSION lambda :
        fruits.forEach(f -> afficherFruit(f));

        System.out.println("\n=== EXERCICE 2 ===");
        // Utilisez une lambda pour afficher chaque fruit en majuscules
        fruits.forEach(f -> System.out.println(f.toUpperCase()));

        System.out.println("\n=== EXERCICE 3 ===");
        // Utilisez une lambda pour afficher chaque nombre multiplié par 2
        nombres.forEach(n -> System.out.println(n * 2));

        System.out.println("\n=== EXERCICE 4 ===");
        // Utilisez une lambda pour afficher "Bonjour " + chaque prénom
        prenoms.forEach(p -> System.out.println("Bonjour " + p));

        System.out.println("\n=== EXERCICE 5 ===");
        // Utilisez une lambda pour afficher seulement les fruits qui commencent par 'C'
        fruits.forEach(f -> {
            if (f.startsWith("C")) {
                System.out.println(f);
            }
        });

        System.out.println("\n=== EXERCICE 6 ===");
        // Utilisez une lambda pour afficher seulement les nombres pairs
        nombres.forEach(n -> {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        });

        System.out.println("\n=== EXERCICE 7 ===");
        // Utilisez une lambda pour afficher la longueur du nom de chaque fruit
        fruits.forEach(f -> System.out.println(f + " -> " + f.length() + " lettres"));

        System.out.println("\n=== EXERCICE 8 ===");
        // Créez votre propre lambda pour afficher les prénoms de plus de 4 lettres avec un message personnalisé
        prenoms.forEach(p -> {
            if (p.length() > 4) {
                System.out.println("Le prénom " + p + " est assez long !");
            }
        });

        System.out.println("\n=== EXERCICE 9 ===");
        // Créez une méthode puis utilisez celle-ci en lambda pour dire la couleur de chaque fruit
        fruits.forEach(f -> System.out.println(f + " est de couleur " + donnerCouleur(f)));
    }

    public static void afficherFruit(String fruit) {
        System.out.println("J'ai le fruit : " + fruit);
    }

    public static String donnerCouleur(String fruit) {
        return switch (fruit) {
            case "Pomme" -> "rouge";
            case "Banane" -> "jaune";
            case "Cerise" -> "rouge";
            case "Orange" -> "orange";
            default -> "inconnue";
        };
    }
}