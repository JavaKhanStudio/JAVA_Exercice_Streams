package sbp.stream.exercices.simple;

import java.util.List;

public class Exo1_Correction {

    public static List<Integer> testingList = List.of(
            1, 1, 2, 3, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9, 9, 9, 9,
            12, 14, 16, 17, 19, 20, 23, 29, 30, 42,
            11, 33, 22, 22, 11, 22, 93, 12, 34, 40, 39);

    public static List<List<Integer>> testingListImbr = List.of(
            List.of(1, 1, 2),
            List.of(4, 5, 6),
            List.of(55, 5, 1),
            List.of(0, 1, 6),
            List.of(65, 65, 65)
    );


    public static void main(String[] args) {

        // Q1 - Affiche le nombre de chiffre pairs de la liste testingList.
        long valueQ1 =
                testingList
                        .stream()
                        .filter(n -> n % 2 == 0)
                        .count();

        System.out.println("valueQ1 = " + valueQ1);

        // Q2 - Afficher le nombre de chiffre different dans la liste testingList
        long valueQ2 =
                testingList
                        .stream()
                        .distinct()
                        .count();

        System.out.println("valueQ2 = " + valueQ2);

        // Q3 - Afficher le nombre de chiffre paire different dans la liste testingList
        long valueQ3 =
                testingList
                        .stream()
                        .distinct()
                        .filter(n -> n % 2 == 0)
                        .count();

        System.out.println("valueQ3 = " + valueQ3);

        // Q4 - Transformer la liste pour écrire paire ou Impaire à la place des nombres
        List<String> valueQ4 =
                testingList
                        .stream()
                        .map(valeur -> valeur % 2 == 0 ? "Pair" : "Impair")
                        .toList();

        System.out.println("valueQ4 = " + valueQ4);

        // Q5 - Compter le nombre de nombres dans la double liste de nombre (testingListImbr)
        long valueQ5 =
                testingListImbr
                        .stream()
                        .flatMap(List::stream)
                        .count();

        System.out.println("valueQ5 = " + valueQ5);

        // Q6 - Trouver le nombre de nombres unique dans la double liste de nombre (testingListImbr)
        long valueQ6 =
                testingListImbr
                        .stream()
                        .flatMap(List::stream)
                        .distinct()
                        .count();

        System.out.println("valueQ6 = " + valueQ6);

        // Q7 Trouver le nombre de nombres unique pair et plus petit que 15 dans la double liste de nombre (testingListImbr)
        long valueQ7 =
                testingListImbr
                        .stream()
                        .flatMap(List::stream)
                        .distinct()
                        .filter(n -> (n % 2 == 0))
                        .filter(n -> n < 15)
                        .count();

        System.out.println("valueQ7 = " + valueQ7);

    }

}
