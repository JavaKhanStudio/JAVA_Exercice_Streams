package sbp.stream.exercices.simple;

import java.util.IntSummaryStatistics;
import java.util.List;

public class Exo2 {

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

    public static List<Double> testingDoubleList = List.of(
            4.2,
            2.3,
            3., 6., 9.,
            5.3,
            9.9
    ) ;


    public static void main(String[] args) {

        // Q0 - Calculer la somme de testingList
        int q0 = testingList
                .stream()
                .mapToInt(Integer::intValue)
                .sum() ;

        System.out.println(q0);
        // Expected : 655

        // Q1 - Calculer la somme de testingListImbr
        int q1 = testingListImbr
                .stream()
                .flatMapToInt(stream -> stream.stream().mapToInt(Integer::intValue))
                .sum();

        System.out.println(q1);
        // Expected : 282

        // Q2 - Calculer la somme de tous les nombres plus grand que 50 dans la testingList
        int q2 = testingList
                .stream()
                .mapToInt(Integer::intValue)
                .filter(x -> x > 50)
                .sum() ;

        System.out.println(q2);
        // Expected : 93

        // Q3 - Calculer la moyenne de tous les nombres impaire de la testingListImbr
        double q3 = testingListImbr
                .stream()
                .flatMapToInt(stream -> stream.stream().mapToInt(Integer::intValue))
                .filter(x -> x%2 != 0)
                .average().orElse(0) ;

        System.out.println(q3);
        // Expected : 26.4

        // Q4 Trouver le plus grand nombre qui est un multiple de 5 dans la testingList
        int q4 = testingList
                .stream()
                .mapToInt(Integer::intValue)
                .filter(x -> x % 5 == 0)
                .max().orElse(0);

        System.out.println(q4);
        // Expected : 40

        // Q5 - Afficher la somme des élément de la testingDoubleList mise au carré
        double q5 = testingDoubleList
                .stream()
                .map(x -> x * x)
                .mapToDouble(Double::doubleValue)
                .sum();

        System.out.println(q5);
        // Expected : 275.03000000000003


        // Q6 - Afficher tous les stats, base sur les nombres unique de la testingList,
        // mise au carré,
        // en excluant tous les éléments plus grand que 50 une fois cette mise au carré effectué
        IntSummaryStatistics q6 = testingList
                .stream()
                .mapToInt(Integer::intValue)
                .distinct()
                .map(x -> x * x)
                .filter(y -> y < 50)
                .summaryStatistics();

        System.out.println(q6);
        // Expected : IntSummaryStatistics{count=7, sum=140, min=1, average=20,000000, max=49}
    }

}
