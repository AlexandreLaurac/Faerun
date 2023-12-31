package utilitaires ;

import java.util.Random ;

public class GuerrierUtilitaire {

    // Attribut de classe contenant un objet de type random
    private static final Random RANDOM = new Random();

    // Méthode de classe qui simule le lancement d’un dé de 3 faces et retourne le résultat
    public static int De3() {
        return RANDOM.nextInt(3) + 1;
    }

    // Méthode qui simule plusieurs lancés d’un dé et retourne le résultat
    public static int De3(int nombreDes) {
        int somme = 0;
        for (int i = 0; i < nombreDes; i++) {
            somme = somme + De3();
        }
        return somme;
    }
}