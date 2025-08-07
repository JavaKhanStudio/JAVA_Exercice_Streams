package sbp.stream.exercice.model;


import lombok.*;
import sbp.stream.exercice.enums.SexeEnum;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Personne {
    private String nom;
    private int age;
    private String ville;
    private SexeEnum sexe;
    private int salaire;
    private List<Animal> animaux;
}