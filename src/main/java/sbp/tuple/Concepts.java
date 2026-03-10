package sbp.tuple;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import sbp.lambda.concepts.Personne;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Concepts {

    public static void main(String[] args) {

        List<Personne> personnes = Arrays.asList(
                new Personne("Alice", 30),
                new Personne("Bob", 25),
                new Personne("Charlie", 35)
        );

        // Version interne //
        InternalTuple2<String, Integer> t = InternalTuple2.of("Alice", 30);
        System.out.println(t._1()); // Alice
        System.out.println(t._2()); // 30

        List<InternalTuple2<String, Integer>> resultInternal = personnes.stream()
                .map(p -> InternalTuple2.of(p.getNom(), p.getAge()))
                .collect(Collectors.toList());

        // Version Lib //
        Tuple2<String, Integer> personne = Tuple.of("Alice", 30);

        System.out.println(personne._1); // Alice
        System.out.println(personne._2); // 30

        List<Tuple2<String, Integer>> resultTuple = personnes.stream()
                .map(p -> Tuple.of(p.getNom(), p.getAge()))
                .collect(Collectors.toList());


    }

}
