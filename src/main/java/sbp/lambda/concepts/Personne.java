package sbp.lambda.concepts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Personne implements Comparable<Personne> {
    private String nom;
    private int age;
    private int salaire;

    // Compare par âge (Comparable par défaut)
    @Override
    public int compareTo(Personne autre) {
        return Integer.compare(this.age, autre.age);
    }

    public static void main(String[] args) {
        List<Personne> personnes = Arrays.asList(
                new Personne("Robert", 85, 45_000),
                new Personne("Alice", 30, 55_000),
                new Personne("Bob", 25, 40_000),
                new Personne("Charlie", 35, 65_000),
                new Personne("Iver", 100, 15_000)
        );

        // Trier par âge (Comparable)
        personnes.sort(null); // équivalent à Collections.sort(personnes)
        System.out.println("Trier par âge :");
        personnes.forEach(System.out::println);

        // Trier par salaire (Comparator)
        personnes.sort(Comparator.comparingInt(Personne::getSalaire));
        System.out.println("\nTrier par salaire :");
        personnes.forEach(System.out::println);

        // Trier par nom (Comparator)
        personnes.sort(Comparator.comparing(Personne::getNom));
        System.out.println("\nTrier par Nom :");
        personnes.forEach(System.out::println);

        // Trier par nom (Comparator inversé)
        personnes.sort(Comparator.comparing(Personne::getNom).reversed());
        System.out.println("\nTrier par Nom :");
        personnes.forEach(System.out::println);
    }
}
