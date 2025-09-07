package sbp;

import lombok.Builder;

public class TestZone {

    @Builder
    private static class Personne {

        private String nom;
        private int age;
        private int salaire;

    }

    public static void main(String[] args) {
        Personne personne = Personne
                .builder()
                .nom("Juan")
                .age(20)
                .salaire(25)
                .build();
    }


}
