package sbp.record;

public class Expli {

    public static void main(String[] args) {
        PersonneRecord personne = new PersonneRecord("Robert",24) ;
        System.out.println(personne.nom() + " a " + personne.age() + " ans");
    }


}
