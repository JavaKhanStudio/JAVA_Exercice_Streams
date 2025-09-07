package sbp.lambda.correction;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class CorrectionKataExo1 {

    // ----- Exercice 1 ----- //
    static class Element implements Comparable<Element> {
        private final String texte;
        private final int valeur;

        public Element(String texte, int valeur) {
            this.texte = texte;
            this.valeur = valeur;
        }
        public String getTexte() { return texte; }
        public int getValeur() { return valeur; }

        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.valeur, other.valeur);
        }

        @Override
        public String toString() {
            return "Element{texte='" + texte + "', valeur=" + valeur + "}";
        }
    }

    public static void main(String[] args) {

        List<Element> liste = new ArrayList<>(Arrays.asList(
                new Element("Banane", 3),
                new Element("Pomme", 5),
                new Element("Abricot", 2),
                new Element("Cerise", 7)
        ));

        // ----- Exercice 2 ----- //

        // 1. Afficher tous les éléments de la liste avec une lambda
        System.out.println("Affichage (forEach + lambda) :");
        liste.forEach(System.out::println);

        // 2. Créer un grand String avec les String de chaque objet (builder + forEach)
        StringBuilder sb = new StringBuilder();
        liste.forEach(e -> sb.append(e.getTexte()).append(","));
        String grandString = sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
        System.out.println("\nGrand String : " + grandString);

        // 3. Ajouter un "compare" et trier en ordre croissant (Comparable<Element>)
        Collections.sort(liste); // utilise compareTo (valeur croissante)
        System.out.println("\nTri croissant (par valeur via compareTo) :");
        liste.forEach(System.out::println);

        // 4. Même chose en ordre décroissant
        liste.sort(Comparator.reverseOrder());
        // OU
        liste.sort(Comparator.comparingInt(Element::getValeur).reversed());

        System.out.println("\nTri décroissant (par valeur) :");
        liste.forEach(System.out::println);

        // 5. Utiliser une lambda pour organiser par ordre alphabétique basé sur le String
        liste.sort(Comparator.comparing(Element::getTexte));
        System.out.println("\nTri alphabétique (par texte) :");
        liste.forEach(System.out::println);

        // ----- Exercice 3 ----- //
        // 1. Predicate<Element> : valeur > 5
        Predicate<Element> valeurSup5 = e -> e.getValeur() > 5;
        System.out.println("Elements avec valeur > 5 :");
        for (Element e : liste) {
            if (valeurSup5.test(e)) {
                System.out.println(e);
            }
        }

        // 2. Function<Element, String> : texte en MAJUSCULES
        Function<Element, String> texteEnMaj = e -> e.getTexte().toUpperCase();
        System.out.println("\nTexte en MAJ pour chaque élément :");
        for (Element e : liste) {
            String res = texteEnMaj.apply(e);
            System.out.println(res);
        }

        // 3. Consumer<Element> : "Nom : <texte>, Valeur : <valeur>"
        Consumer<Element> afficherFormate = e ->
                System.out.println("Nom : " + e.getTexte() + ", Valeur : " + e.getValeur());

        System.out.println("\nAffichage formaté :");
        for (Element e : liste) {
            afficherFormate.accept(e);
        }

        // 4. OperationElement (interface maison) — 3 lambdas :
        OperationElement opValeur = Element::getValeur;
        OperationElement opLongueurTexte = e -> e.getTexte().length();
        OperationElement opDoubleValeur = e -> e.getValeur() * 2;

        System.out.println("\nOperationElement (tests) :");
        for (Element e : liste) {
            System.out.println(e + " | valeur=" + opValeur.appliquer(e)
                    + ", lenTexte=" + opLongueurTexte.appliquer(e)
                    + ", doubleValeur=" + opDoubleValeur.appliquer(e));
        }

        // 5.
        Random rnd = new Random();
        Supplier<Element> fournisseur = () ->
                new Element("Nouveau", 1 + rnd.nextInt(10));

        for (int i = 0; i < 5; i++) {
            liste.add(fournisseur.get());
        }

        System.out.println("\nListe après ajout de 5 éléments via Supplier :");
        for (Element e : liste) {
            System.out.println(e);
        }

    }

    @FunctionalInterface
    private interface OperationElement{
        int appliquer(Element e);
    }


}
