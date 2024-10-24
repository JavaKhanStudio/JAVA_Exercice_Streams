package sbp.streams.stream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sbp.streams.stream.enums.AnimalTypeEnum;
import sbp.streams.stream.enums.SexeEnum;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Animal {

    private String nom ;
    private AnimalTypeEnum animalType;
    private SexeEnum sexeEnum ;

}
