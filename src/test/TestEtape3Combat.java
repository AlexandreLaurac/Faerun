package test ;

import data.* ;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestEtape3Combat {

    // Logger et configuration
    private static Logger LOGGER = Logger.getLogger(TestEtape3Combat.class.getPackageName()) ;
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$s] %4$-10s | (%3$s) %2$-15s | %5$s\n");
        LOGGER.setLevel(Level.INFO);
    }

    // Main
    public static void main (String[] args) {

        //------------------------- Initialisations -------------------------

        Carreau carreau = new Carreau() ;

        // Ajout de guerriers bleus au carreau
        ArrayList<Guerrier> guerriersBleus = new ArrayList<>() ;
        Guerrier guerrier1 = new Elfe() ;     guerriersBleus.add(guerrier1) ;
        Guerrier guerrier2 = new Nain() ;     guerriersBleus.add(guerrier2) ;
        Guerrier guerrier3 = new ChefNain() ; guerriersBleus.add(guerrier3) ;
        Guerrier guerrier4 = new ChefElfe() ; guerriersBleus.add(guerrier4) ;
        carreau.ajoutGuerriersBleus(guerriersBleus) ;

        // Ajout de guerriers rouges au carreau
        ArrayList<Guerrier> guerriersRouges = new ArrayList<>() ;
        Guerrier guerrier5 = new Elfe() ; guerriersRouges.add(guerrier5) ;
        Guerrier guerrier6 = new Nain() ; guerriersRouges.add(guerrier6) ;
        carreau.ajoutGuerriersRouges(guerriersRouges) ;

        //------------------------- Lancement du combat -------------------------
        carreau.lanceCombat() ;
    }
}