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
        long valueQ1 =
                testingList
                        .stream()
                        .filter(n -> n % 2 == 0)
                        .count();

        // Expected :

        // Q2 - Afficher le nombre de chiffre different dans la liste testingList
        long valueQ2 =
                testingList
                        .stream()
                        .distinct()
                        .count();

        // Expected :

        // Q3 - Afficher le nombre de chiffre paire different dans la liste testingList
        long valueQ3 =
                testingList
                        .stream()
                        .distinct()
                        .filter(n -> n % 2 == 0)
                        .count();

        // Expected :

        // Q4 - Transformer la liste pour écrire paire ou Impaire à la place des nombres
        List<String> valueQ4 =
                testingList
                        .stream()
                        .map(valeur -> valeur % 2 == 0 ? "Paire" : "Impaire")
                        .toList();



        // Q4 - Compter le nombre de nombres dans la double liste de nombre (testingListImbr)
        long valueQ5 =
                testingListImbr
                        .stream()
                        .flatMap(List::stream)
                        .count();

        // Expected :

        // Q5 - Calculer la somme des nombres unique dans la double liste de nombre (testingListImbr)
        long valueQ6 =
                testingListImbr
                        .stream()
                        .flatMap(List::stream)
                        .distinct()
                        .count();


        Predicate<String> isEmpty = s -> s.isEmpty();

        System.out.println(isEmpty.test(""));      // true
        System.out.println(isEmpty.test("hello")); // false

    }

}
