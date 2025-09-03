package sbp.lambda.exercices;

import java.util.List;

public class Exo1 {

        static List<String> fruits = List.of("Pomme", "Banane", "Cerise", "Orange");
        static List<Integer> nombres = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        static List<String> prenoms = List.of("Alice", "Bob", "Charlie", "David", "Emma");

        public static void main(String[] args) {

            System.out.println("=== EXERCICE 0 ===");
            // Remplacez la référence de méthode par une lambda
            for(int i = 0; i < fruits.size(); i++) {
                System.out.println(fruits.get(i));
            }

            System.out.println("=== EXERCICE 1 ===");
            // Remplacez la référence de méthode par une expression lambda
            for(int i = 0; i < fruits.size(); i++) {
                afficherFruit(fruits.get(i));
            }

            System.out.println("\n=== EXERCICE 2 ===");
            // Utilisez une lambda pour afficher chaque fruit en majuscules
            // fruits.forEach(...);

            System.out.println("\n=== EXERCICE 3 ===");
            // Utilisez une lambda pour afficher chaque nombre multiplié par 2
            // nombres.forEach(...);

            System.out.println("\n=== EXERCICE 4 ===");
            // Utilisez une lambda pour afficher "Bonjour " + chaque prénom
            // prenoms.forEach(...);

            System.out.println("\n=== EXERCICE 5 ===");
            // Utilisez une lambda pour afficher seulement les fruits qui commencent par 'C'
            // fruits.forEach(...);

            System.out.println("\n=== EXERCICE 6 ===");
            // Utilisez une lambda pour afficher seulement les nombres pairs
            // nombres.forEach(...);

            System.out.println("\n=== EXERCICE 7 ===");
            // Utilisez une lambda pour afficher la longueur du nom de chaque fruit
            // fruits.forEach(...);

            System.out.println("\n=== EXERCICE 8 ===");
            // Créez votre propre lambda pour afficher les prénoms de plus de 4 lettres
            // avec un message personnalisé
            // prenoms.forEach(...);

            System.out.println("\n=== EXERCICE 9 ===");
            // Créez une méthode puis utilisé celle-ci en lambda pour dire la couleur de chaque fruit dans votre liste
            // fruits.forEach(...);
        }

        public static void afficherFruit(String fruit) {
            System.out.println("J'ai le fruit : " + fruit);
        }
}
