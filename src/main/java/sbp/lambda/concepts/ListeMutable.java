package sbp.lambda.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListeMutable {

    public static void main(String[] args) {
        // Arrays.asList retourne une liste de taille fixe basée sur le tableau
        List<String> listeFixe = Arrays.asList("pomme", "banane", "cerise");

        // On peut modifier un élément existant
        listeFixe.set(1, "myrtille");
        System.out.println("Liste fixe modifiée : " + listeFixe);

        // Ceci provoquerait une UnsupportedOperationException :
        // listeFixe.add("datte");

        // Pour obtenir une liste modifiable
        List<String> listeMutable = new ArrayList<>(
                Arrays.asList("pomme", "banane", "cerise"));
        listeMutable.add("datte");
        listeMutable.remove("pomme");
        System.out.println("Liste mutable : " + listeMutable);
    }

}

