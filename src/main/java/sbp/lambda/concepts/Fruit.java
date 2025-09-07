package sbp.lambda.concepts;

import java.util.ArrayList;
import java.util.List;

public class Fruit {

    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Pomme");
        fruits.add("Banane");
        fruits.add("Cerise");

        // Exemple de forEach
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }

        fruits.forEach(fruit -> System.out.println(fruit));
        fruits.forEach(System.out::println);

        // Exemple avec lambda
        StringBuilder builder = new StringBuilder();
        fruits.forEach(
                fruit -> {
                    builder.append(fruit.toUpperCase());
                }
        );

        // Attention ne fonctionne pas ca
        /*
        String builder = "";
        fruits.forEach(
                fruit -> {
                    builder += fruit.toUpperCase();
                }
        );
         */
        // Une lambda ne peut pas modifier une variable immuable
        // Elle capture les variables locales comme des constantes,
        // Cela garantit la sécurité et l'absence d'effets de bord.
    }

}
