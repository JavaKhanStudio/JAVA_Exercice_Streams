package sbp.lambda.concepts;

public class CalculateurExemple {

    @FunctionalInterface
    interface Calculateur {
        int calculer(int a, int b);
    }

    public class Exemple {
        // Méthode qui reçoit une lambda en paramètre
        static int appliquerOperation(int x, int y, Calculateur op) {
            return op.calculer(x, y);
        }

        public static void main(String[] args) {
            // On passe des lambdas directement en paramètre
            Calculateur sommeLambda = (a, b) -> a+b;
            Calculateur produitLambda = (a, b) -> a*b;

            int somme = appliquerOperation(2, 3, sommeLambda);
            int produit = appliquerOperation(4, 5, produitLambda);

            System.out.println("Somme = " + somme);       // 5
            System.out.println("Produit = " + produit);   // 20
        }
    }

}