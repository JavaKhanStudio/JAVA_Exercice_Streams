package sbp.correction;

import java.util.stream.IntStream;

public class FizzBuzzFunctional {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
                .mapToObj(FizzBuzzFunctional::fizzBuzz)
                .forEach(System.out::println);
    }

    private static String fizzBuzz(int i) {
        if (i % 15 == 0) return "FizzBuzz";
        if (i % 3 == 0) return "Fizz";
        if (i % 5 == 0) return "Buzz";
        return String.valueOf(i);
    }
}
