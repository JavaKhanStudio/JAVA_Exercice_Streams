package sbp.stream.exercices.simple;

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

        // Q1 - Calculer la somme de testingListImbr
        int q1 = testingListImbr
                .stream()
                .flatMapToInt(stream -> stream.stream().mapToInt(Integer::intValue))
                .sum() ;

        // Q2 - Calculer la somme de tous les nombres plus grand que 50 dans la testingList
        int q2 = testingList
                .stream()
                .mapToInt(Integer::intValue)
                .filter(x -> x > 50)
                .sum() ;

        // Q3 - Calculer la moyenne de tous les nombres impaire de la testingListImbr
        double q3 = testingListImbr
                .stream()
                .flatMapToInt(stream -> stream.stream().mapToInt(Integer::intValue))
                .filter(x -> x%2 != 0)
                .average().orElse(0) ;

    }

}
