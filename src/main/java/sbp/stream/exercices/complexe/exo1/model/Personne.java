package sbp.stream.exercices.complexe.exo1.model;


import lombok.*;
import sbp.stream.exercices.complexe.exo1.enums.SexeEnum;

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