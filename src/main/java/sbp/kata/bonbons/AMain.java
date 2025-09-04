package sbp.kata.bonbons;

import java.util.*;
import java.util.stream.Collectors;

public class AMain {


    public static void main(String[] args) {
        Map<EnumAliment, Integer> required = new HashMap<>();
        required.put(EnumAliment.JUJUBE, 10) ;
        required.put(EnumAliment.MARSHMALLOW, 5) ;
        required.put(EnumAliment.CHOCOLAT, 2) ;
        required.put(EnumAliment.CHOCOLAT_ARACHIDE, 1) ;

        List<Magasin> mesOptions = createData() ;


        int sucreTotal = required
                .entrySet()
                .stream()
                .mapToInt((entry) -> entry.getKey().getSucreParKilo() * entry.getValue())
                .sum();

        System.out.println("Total sucre: " + sucreTotal);

        int calorieTotal = required
                .entrySet()
                .stream()
                .filter(entry -> !entry.getKey().isAsArachide())
                .mapToInt((entry) -> entry.getKey().getCalorieParKilo() * entry.getValue())
                .sum();

        System.out.println("Total calorie: " + calorieTotal);

        Map<String, Integer> couts = mesOptions
                .stream()
                .collect(Collectors.toMap(
                            Magasin::getName,
                    magasin -> magasin.calculateCost(required)
                        )
                ) ;

        System.out.println("Couts par magasin: " + couts);

        Map<EnumAliment, Integer> chocolatRequired =
                required.entrySet().stream()
                        .filter(e -> e.getKey().isChocolat())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        Map<String, Integer> mesOptionsChocolat = mesOptions
                .stream()
                .collect(Collectors.toMap(
                                magasin -> magasin.name,
                                magasin -> magasin.calculateCost(chocolatRequired)
                        )
                ) ;

        System.out.println("Couts par magasin du chocolat: " + mesOptionsChocolat);


    }

    public static List<Magasin> createData() {
        // Magasin 1
        Map<EnumAliment, Integer> prixMagasin1 = new EnumMap<>(EnumAliment.class);
        prixMagasin1.put(EnumAliment.JUJUBE, 12);
        prixMagasin1.put(EnumAliment.MARSHMALLOW, 8);
        prixMagasin1.put(EnumAliment.CHOCOLAT, 20);
        prixMagasin1.put(EnumAliment.CHOCOLAT_ARACHIDE, 25);

        Magasin magasin1 = Magasin.builder()
                .name("Bonbonnerie Douceur")
                .coutParKilo(prixMagasin1)
                .build();

        // Magasin 2
        Map<EnumAliment, Integer> prixMagasin2 = new EnumMap<>(EnumAliment.class);
        prixMagasin2.put(EnumAliment.JUJUBE, 10);
        prixMagasin2.put(EnumAliment.MARSHMALLOW, 9);
        prixMagasin2.put(EnumAliment.CHOCOLAT, 22);
        prixMagasin2.put(EnumAliment.CHOCOLAT_ARACHIDE, 28);

        Magasin magasin2 = Magasin.builder()
                .name("Choco Palace")
                .coutParKilo(prixMagasin2)
                .build();

        // Magasin 3
        Map<EnumAliment, Integer> prixMagasin3 = new EnumMap<>(EnumAliment.class);
        prixMagasin3.put(EnumAliment.JUJUBE, 15);
        prixMagasin3.put(EnumAliment.MARSHMALLOW, 7);
        prixMagasin3.put(EnumAliment.CHOCOLAT, 18);
        prixMagasin3.put(EnumAliment.CHOCOLAT_ARACHIDE, 30);

        Magasin magasin3 = Magasin.builder()
                .name("Friandises Gourmandes")
                .coutParKilo(prixMagasin3)
                .build();

        return List.of(magasin1, magasin2, magasin3);
    }


}
