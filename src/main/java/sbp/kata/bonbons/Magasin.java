package sbp.kata.bonbons;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Magasin {

    String name;
    Map<EnumAliment, Integer> coutParKilo ;

    int calculateCost(Map<EnumAliment, Integer> achats) {

        if(!coutParKilo.keySet()
                .containsAll(achats.keySet())) {
            // Impossible de faire tous nos achats !
            return 0 ;
        }

        return achats
                .entrySet()
                .stream()
                .mapToInt(entry -> entry.getValue() * coutParKilo.get(entry.getKey()))
                .sum();
    }

}
