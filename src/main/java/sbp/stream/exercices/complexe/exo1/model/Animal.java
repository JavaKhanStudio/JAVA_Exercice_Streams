package sbp.stream.exercices.complexe.exo1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sbp.stream.exercices.complexe.exo1.enums.AnimalTypeEnum;
import sbp.stream.exercices.complexe.exo1.enums.SexeEnum;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Animal {

    private String nom ;
    private AnimalTypeEnum animalType;
    private SexeEnum sexeEnum ;

}
