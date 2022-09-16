package test ;

import data.* ;

import java.util.logging.Level ;
import java.util.logging.Logger ;


public class TestEtape1 {

    // Logger et configuration
    private static Logger LOGGER = Logger.getLogger(TestEtape1.class.getPackageName());
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$s] %4$-10s | (%3$s) %2$-15s | %5$s\n");
        LOGGER.setLevel(Level.INFO);
    }

    // Main
    public static void main (String[] args) {

        // Initialisation des guerriers
        Guerrier guerrier1 = new Nain() ;
        Guerrier guerrier2 = new Elfe() ;

        // Combat des deux guerriers
        while (guerrier1.estVivant() && guerrier2.estVivant()) {

            // guerrier1 tape guerrier2
            LOGGER.log(Level.INFO, "Le guerrier 1 attaque") ;
            guerrier1.attaquer(guerrier2) ;


            // guerrier2 tape guerrier1
            if (guerrier2.estVivant()) {
                LOGGER.log(Level.INFO, "Le guerrier 2 attaque") ;
                guerrier2.attaquer(guerrier1) ;
            }
        }
    }
}
