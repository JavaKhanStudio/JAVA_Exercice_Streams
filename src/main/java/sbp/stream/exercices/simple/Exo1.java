package sbp.stream.exercices.simple;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exo1 {

    public static List<Integer> testingList = List.of(
            1, 1, 2, 3, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9, 9, 9, 9,
            12, 14, 16, 17, 19, 20, 23, 29, 30, 42,
            11, 33, 22, 22, 11, 22, 93, 12, 34, 40, 39) ;

    public static List<List<Integer>> testingListImbr = List.of(
            List.of(1,1,2),
            List.of(4,5,6),
            List.of(55,5,1),
            List.of(0,1,6),
            List.of(65,65,65)
    ) ;

    public static void main(String[] args) {

        // Q1 - Affiche le nombres de chiffre pairs de la liste testingList.
        // long valueQ1 =

        // Expected : 19

        // Q2 - Afficher le nombre de chiffre different dans la liste testingList
        // long valueQ2 =

        // Expected : 26

        // Q3 - Afficher le nombre de chiffre paire different dans la liste testingList
        // long valueQ3 =

        // Expected : 13

        // Q4 - Transformer la liste pour écrire paire ou Impaire à la place des nombres
        // List<String> valueQ4

        // Expected : [Impair, Impair, Pair, Impair, Impair, Pair, Pair, Impair, Pair, Pair, Impair, Pair, Pair, Impair, Impair, Impair, Impair, Pair, Pair, Pair, Impair, Impair, Pair, Impair, Impair, Pair, Pair, Impair, Impair, Pair, Pair, Impair, Pair, Impair, Pair, Pair, Pair, Impair]

        // Q5 - Compter le nombre de nombres dans la double liste de nombre (testingListImbr)
        //long valueQ5 =

        // Expected : 15

        // Q6 - Calculer la somme des nombres unique dans la double liste de nombre (testingListImbr)
        // long valueQ6 =

        // Expected : 8

        // Q7 Trouver le nombre de nombres unique pair et plus petit que 15 dans la double liste de nombre (testingListImbr)
        // long valueQ7 =

        // Expected : 4
    }

}
