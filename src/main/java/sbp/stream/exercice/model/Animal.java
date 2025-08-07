package sbp.stream.exercice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sbp.stream.exercice.enums.AnimalTypeEnum;
import sbp.stream.exercice.enums.SexeEnum;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Animal {

    private String nom ;
    private AnimalTypeEnum animalType;
    private SexeEnum sexeEnum ;

}
