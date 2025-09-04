package sbp.lambda.concepts;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class Expli {


    public static void main(String[] args) {

        exempleSimple() ;
        exempleComplexe() ;
        exempleListe() ;
        exempleMonoInterface() ;
        exempleInterfaceComplexe() ;

    }

    public static void exempleSimple() {
        Runnable r = () -> System.out.println("Hello !");
        r.run();
    }

    public static void exempleComplexe() {
        BiConsumer<String, String> r = (clef, valeur) -> {
            System.out.println("Ma clef " + clef);
            System.out.println("Ma valeur " + valeur);
        };

        r.accept("clé1", "valeur1");
    }

    public static void exempleListe() {
        List<String> noms = Arrays.asList("Simon", "Alice", "Bob");
        noms.forEach(n -> System.out.println(n));
        noms.forEach(System.out::println);
    }

    public static void exempleMonoInterface() {
        MonoInterface monoInterface = (nom -> System.out.println("Bonjour " + nom));
        monoInterface.dire("Simon");
    }

    public static void exempleInterfaceComplexe() {
        DuoInterface duoInterface = new DuoInterface() {

            @Override
            public void dire(String nom) {
                System.out.println("Bonjour " + nom) ;
            }

            @Override
            public String repondre() {
                return "J'ai déja dit bonjour";
            }
        } ;

        System.out.println(duoInterface.repondre()) ;

    }

    interface MonoInterface {
        void dire(String nom);
    }

    interface DuoInterface {
        void dire(String nom);
        String repondre() ;
    }

}
