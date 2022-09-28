package test ;

import data.* ;

import java.util.logging.Level;
import java.util.logging.Logger;


public class TestEtape2 {

    // Logger et configuration
    private static Logger LOGGER = Logger.getLogger(TestEtape2.class.getPackageName());
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$s] %4$-10s | (%3$s) %2$-15s | %5$s\n");
        LOGGER.setLevel(Level.INFO);
    }

    // Main
    public static void main (String[] args) {

        // Initialisation du chateau
        Chateau chateau = new Chateau (Couleur.BLEU, null) ;  // null pour éviter l'erreur avec le nouvel argument de chateau créé à l'étape 3

        // Initialisations des guerriers
        Guerrier guerrier1 = new Nain() ; chateau.ajoutGuerrierNovice(guerrier1) ;
        Guerrier guerrier2 = new Nain() ; chateau.ajoutGuerrierNovice(guerrier2) ;
        Guerrier guerrier3 = new Elfe() ; chateau.ajoutGuerrierNovice(guerrier3) ;
        Guerrier guerrier4 = new Elfe() ; chateau.ajoutGuerrierNovice(guerrier4) ;

        // Entrainement des guerriers
        int tour_de_jeu = 1 ;
        while (!chateau.getGuerriersNovices().isEmpty()) {
            LOGGER.log(Level.INFO, "Tour de jeu n°" + tour_de_jeu) ;
            chateau.entrainer() ;
            tour_de_jeu++ ;
        }
    }
}