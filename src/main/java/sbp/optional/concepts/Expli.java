package sbp.optional.concepts;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Expli {

    static Optional<String> opt1 ;
    static Optional<String> opt2 ;

    public static void main(String[] args) {
        System.out.println("--- Explications Streams ---");
        initValues() ;
        //lesGet() ;
        //orElse() ;
        //orElseThrow() ;
        //lesMap() ;
        // lesFilter() ;
    }


    public static void initValues() {
        opt1 = Optional.of("Bonjour");
        opt2 = Optional.empty() ;
    }

    // le .get() retourne la valeur (attention si vide → exception)
    public static void lesGet() {
        System.out.println("-- Les Gets --");
        // Pas recommandé
        System.out.println(opt1.get());
        // Mieux
        if(opt1.isPresent()) {
            System.out.println(opt1.get());
        }
        // Dans notre cas optimal
        opt1.ifPresent(System.out::println);

        // Cas en erreur
        try {opt2.get();} catch (Exception e) {System.out.println("Petit probleme " + e.getClass());}

    }

    // Si la valeur n'existe pas, retourne quelque chose d'autre.
    public static void orElse() {
        System.out.println("-- Les OrElse --");

        System.out.println(opt1.orElse("Valeur"));
        System.out.println(opt2.orElse("Valeur"));
        System.out.println(opt2.orElseGet(() -> "Par défaut"));

    }

    // Si la valeur n'existe pas, lance exception
    public static void orElseThrow() {
        System.out.println("-- Les OrElse Throw --");

        try{System.out.println(opt1.orElseThrow());}
        catch (Exception e) {System.out.println("Oupsi 1");};

        try{System.out.println(opt2.orElseThrow());}
        catch (Exception e) {System.out.println("Oupsi 2");};

        try{System.out.println(opt2.orElseThrow(NullPointerException::new));}
        catch (NoSuchElementException e) {System.out.println("Oupsi 3");}
        catch (NullPointerException e) {System.out.println("Oupsi 4");};
    }

    public static void lesMap() {
        System.out.println("-- Les Map --");

        // map() transforme la valeur si elle existe
        Optional<String> resultat1 = opt1.map(s -> s.toUpperCase());
        System.out.println("opt1 en majuscules : " + resultat1.orElse("Vide"));

        Optional<String> resultat2 = opt2.map(String::toUpperCase);
        System.out.println("opt2 en majuscules : " + resultat2.orElse("Vide"));

        // Chaînage de transformations
        Optional<Integer> longueur = opt1.map(s -> s.length());
        System.out.println("Longueur de opt1 : " + longueur.orElse(0));
    }

    public static void lesFilter() {
        System.out.println("-- Les Filter --");

        // filter() garde la valeur seulement si la condition est vraie
        Optional<String> filtre1 = opt1.filter(s -> s.length() > 5);
        System.out.println("Check si longueur > 5 : " + filtre1.orElse("Trop court"));

        Optional<String> filtre2 = opt1.filter(s -> s.startsWith("C"));
        System.out.println("Check si commence par C : " + filtre2.orElse("Ne commence pas par C"));

        Optional<String> filtre3 = opt1.filter(s -> s.contains("Au revoir"));
        System.out.println("opt1 si contient 'Au revoir' : " + filtre3.orElse("Ne contient pas 'Au revoir'"));

        // Combinaison filter et map
        Optional<String> combo = opt1
                .filter(s -> s.length() > 3)
                .map(s -> s.toLowerCase());
        System.out.println("opt1 filtré puis en minuscules : " + combo.orElse("Filtré"));
    }

}
