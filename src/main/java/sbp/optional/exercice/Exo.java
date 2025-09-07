package sbp.optional.exercice;

import java.util.List;
import java.util.Optional;

public class Exo {

    public static void main(String[] args) {
        Utilisateur u1 = new Utilisateur("Alice", "ALice@Mail.com");
        Utilisateur u2 = new Utilisateur("Bob", null);
        Utilisateur u3 = new Utilisateur(null, "Carlos@Mail.com");

        List<Utilisateur> utilisateurs = List.of(u1, u2, u3) ;

        // Changer les getters pour nom et email par des optionals
        System.out.println("Email de u1 : " + u1.getEmail());
        System.out.println("Email de u2 : " + u2.getEmail());
        System.out.println("Email de u3 : " + u3.getEmail());

        // Retourner le nom de chaque utilisateur, sinon nommer le John Doe

        // Retourner le nom de chaque utilisateur si ce dernier ne commence pas par B, si aucune valeur, retourner un nom vide

        // Retourner le email de chaque utilisateur en lower case, sinon retourner un vide

        // Si quelqu'un n'à pas de nom, lancer une exception

        // Difficile : Si quelqu'un s'appelle Alice, ou n'a pas de nom, lancer une exception.

    }

    static class Utilisateur {
        private String nom;
        private String email;

        public Utilisateur(String nom, String email) {
            this.nom = nom;
            this.email = email;
        }

        public String getNom() {
            return nom;
        }

        public String getEmail() {
            return email;
        }
    }
}


