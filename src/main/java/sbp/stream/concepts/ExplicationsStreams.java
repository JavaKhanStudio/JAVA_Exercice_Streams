package sbp.stream.concepts;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExplicationsStreams {

    static class Personne {
        String nom;
        int age;

        public Personne(String nom, int age) {
            this.nom = nom;
            this.age = age;
        }

        @Override
        public String toString() {
            return nom + " (" + age + " ans)";
        }
    }

    public static void main(String[] args) {
        ExplicationsStreams demo = new ExplicationsStreams();

        lesFilter();
        System.out.println();

        lesMap();
        System.out.println();

        lesRecherches();
        System.out.println();

        lesTris();
        System.out.println();

        lesReductions();
        System.out.println();

        lesCollectes();
        System.out.println();

        chainageComplexe();
        System.out.println();

        creationStreams();
    }


    static List<Personne> personnes = List.of(
            new Personne("Jeune", 5),
            new Personne("Ado", 18),
            new Personne("Adulte", 25),
            new Personne("Vieux", 64));

    // Les opérations de filtrage
    public static void lesFilter() {
        System.out.println("-- Les Filter --");

        // Filtrer les adultes (>= 18 ans)
        System.out.println("Adultes :");
        personnes.stream()
                .filter(p -> p.age >= 18)
                .forEach(System.out::println);

        // Filtrer par nom
        System.out.println("\nPersonnes dont le nom contient 'du' :");
        personnes.stream()
                .filter(p -> p.nom.toLowerCase().contains("du"))
                .forEach(System.out::println);
    }

    // Les transformations avec map
    public static void lesMap() {
        System.out.println("-- Les Map --");

        // Transformer en noms seulement
        System.out.println("Tous les noms :");
        personnes.stream()
                .map(p -> p.nom)
                .forEach(System.out::println);

        // Transformer les âges
        System.out.println("\nÂges dans 10 ans :");
        personnes.stream()
                .map(p -> p.nom + " aura " + (p.age + 10) + " ans")
                .forEach(System.out::println);

        // Transformation en majuscules
        System.out.println("\nNoms en majuscules :");
        personnes.stream()
                .map(p -> p.nom.toUpperCase())
                .forEach(System.out::println);
    }

    // Les opérations de recherche
    public static void lesRecherches() {
        System.out.println("-- Les Recherches --");

        // Trouver le premier adulte
        Optional<Personne> premierAdulte = personnes.stream()
                .filter(p -> p.age >= 18)
                .findFirst();
        System.out.println("Premier adulte : " + premierAdulte.orElse(null));

        // Vérifier si tous sont majeurs
        boolean tousMajeurs = personnes.stream()
                .allMatch(p -> p.age >= 18);
        System.out.println("Tous majeurs : " + tousMajeurs);

        // Vérifier si au moins un est mineur
        boolean auMoinsUnMineur = personnes.stream()
                .anyMatch(p -> p.age < 18);
        System.out.println("Au moins un mineur : " + auMoinsUnMineur);
    }

    // Les opérations de tri
    public static void lesTris() {
        System.out.println("-- Les Tris --");

        // Tri par âge
        System.out.println("Tri par âge croissant :");
        personnes.stream()
                .sorted((p1, p2) -> Integer.compare(p1.age, p2.age))
                .forEach(System.out::println);

        // Tri par nom
        System.out.println("\nTri par nom :");
        personnes.stream()
                .sorted((p1, p2) -> p1.nom.compareTo(p2.nom))
                .forEach(System.out::println);

        // Tri inversé par âge
        System.out.println("\nTri par âge décroissant :");
        personnes.stream()
                .sorted((p1, p2) -> Integer.compare(p2.age, p1.age))
                .forEach(System.out::println);
    }

    // Les opérations de réduction
    public static void lesReductions() {
        System.out.println("-- Les Réductions --");

        // Compter
        long nombrePersonnes = personnes.stream().count();
        System.out.println("Nombre de personnes : " + nombrePersonnes);

        // Âge moyen
        double ageMoyen = personnes.stream()
                .mapToInt(p -> p.age)
                .average()
                .orElse(0.0);
        System.out.println("Âge moyen : " + ageMoyen);

        // Âge minimum et maximum
        int ageMin = personnes.stream()
                .mapToInt(p -> p.age)
                .min()
                .orElse(0);
        int ageMax = personnes.stream()
                .mapToInt(p -> p.age)
                .max()
                .orElse(0);
        System.out.println("Âge minimum : " + ageMin);
        System.out.println("Âge maximum : " + ageMax);

        // Somme des âges
        int sommeAges = personnes.stream()
                .mapToInt(p -> p.age)
                .sum();
        System.out.println("Somme des âges : " + sommeAges);
    }

    // Collecte en nouvelles collections
    public static void lesCollectes() {
        System.out.println("-- Les Collectes --");

        // Collecter en List
        List<String> nomsAdultes = personnes.stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.nom)
                .collect(Collectors.toList());
        System.out.println("Noms des adultes : " + nomsAdultes);

        // Collecter en Set
        Set<String> nomsUniques = personnes.stream()
                .map(p -> p.nom.substring(0, 1)) // Première lettre
                .collect(Collectors.toSet());
        System.out.println("Premières lettres uniques : " + nomsUniques);

        // Grouper par catégorie d'âge
        Map<String, List<Personne>> groupesAge = personnes.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.age < 18) return "Mineur";
                    else if (p.age < 60) return "Adulte";
                    else return "Senior";
                }));
        System.out.println("Groupes par âge :");
        groupesAge.forEach((categorie, liste) -> {
            System.out.println("  " + categorie + " : " + liste);
        });
    }

    // Chaînage complexe d'opérations
    public static void chainageComplexe() {
        System.out.println("-- Chaînage Complexe --");

        // Exemple : trouver les 2 plus jeunes adultes, en majuscules
        List<String> resultat = personnes.stream()
                .filter(p -> p.age >= 18)           // Filtrer les adultes
                .sorted((p1, p2) -> Integer.compare(p1.age, p2.age)) // Trier par âge
                .limit(2)                           // Prendre les 2 premiers
                .map(p -> p.nom.toUpperCase())      // Transformer en majuscules
                .collect(Collectors.toList());      // Collecter en liste

        System.out.println("Les 2 plus jeunes adultes : " + resultat);

        // Autre exemple : statistiques sur les adultes
        String statistiques = personnes.stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.nom + " (" + p.age + ")")
                .collect(Collectors.joining(", ", "Adultes: [", "]"));

        System.out.println(statistiques);
    }

    // Création de streams depuis différentes sources
    public static void creationStreams() {
        System.out.println("-- Création de Streams --");

        // Depuis un tableau
        String[] noms = {"Pierre", "Marie", "Jean"};
        System.out.println("Depuis un tableau :");
        Arrays.stream(noms).forEach(System.out::println);

        // Stream de nombres
        System.out.println("\nNombres de 1 à 5 :");
        IntStream.range(1, 6).forEach(System.out::println);

        // Stream infini (limité)
        System.out.println("\nNombres pairs :");
        Stream.iterate(2, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);
    }


}
