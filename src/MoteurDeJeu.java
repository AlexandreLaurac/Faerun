import data.* ;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MoteurDeJeu {

    public static final int NB_CASES_PLATEAU_DE_JEU = 10 ;
    public static int TOUR_DE_JEU ;
    private static Logger LOGGER = Logger.getLogger(MoteurDeJeu.class.getPackageName()) ;
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$s] %4$-10s | (%3$s) %2$-15s | %5$s\n") ;
        LOGGER.setLevel(Level.INFO) ;
    }

    public static void affichageDebutTour() {
        LOGGER.log(Level.INFO, "Tour de jeu n°" + TOUR_DE_JEU + " !") ;
    }

    public static void main (String[] args) {

        //------------------------------------------- Initialisation du jeu ------------------------------------------//

        // Plateau de jeu
        Plateau plateau = new Plateau (NB_CASES_PLATEAU_DE_JEU) ;

        // Chateaux
        Chateau chateauBleu =  new Chateau (Couleur.BLEU, plateau) ;
        Chateau chateauRouge = new Chateau (Couleur.ROUGE, plateau) ;

        // Guerriers
            // Guerriers bleus
        Guerrier guerrier1 = new Elfe() ;     chateauBleu.ajoutGuerrierNovice(guerrier1) ;
        Guerrier guerrier2 = new Nain() ;     chateauBleu.ajoutGuerrierNovice(guerrier2) ;
        Guerrier guerrier3 = new ChefNain() ; chateauBleu.ajoutGuerrierNovice(guerrier3) ;
        Guerrier guerrier4 = new ChefElfe() ; chateauBleu.ajoutGuerrierNovice(guerrier4) ;
        Guerrier guerrier5 = new Elfe() ;     chateauBleu.ajoutGuerrierNovice(guerrier5) ;
        Guerrier guerrier6 = new Nain() ;     chateauBleu.ajoutGuerrierNovice(guerrier6) ;
        Guerrier guerrier7 = new ChefNain() ; chateauBleu.ajoutGuerrierNovice(guerrier7) ;
            // Guerriers rouges
        Guerrier guerrier8 = new Elfe() ;      chateauRouge.ajoutGuerrierNovice(guerrier8) ;
        Guerrier guerrier9 = new Nain() ;      chateauRouge.ajoutGuerrierNovice(guerrier9) ;
//        Guerrier guerrier10 = new ChefNain() ; chateauRouge.ajoutGuerrierNovice(guerrier10) ;
//        Guerrier guerrier11 = new ChefElfe() ; chateauRouge.ajoutGuerrierNovice(guerrier11) ;
//        Guerrier guerrier12 = new ChefElfe() ; chateauRouge.ajoutGuerrierNovice(guerrier12) ;
//        Guerrier guerrier13 = new Elfe() ;     chateauRouge.ajoutGuerrierNovice(guerrier13) ;
//        Guerrier guerrier14 = new Nain() ;     chateauRouge.ajoutGuerrierNovice(guerrier14) ;


        //------------------------------------------------ Tours de jeu ----------------------------------------------//

        TOUR_DE_JEU = 1 ;

        while (!plateau.estPartieTerminee()) {

            // Affichage de début de tour
            affichageDebutTour() ;

            // Entrainement des guerriers
            chateauBleu.entrainer() ;
            chateauRouge.entrainer() ;

            // Déplacement des guerriers
            plateau.deplaceGuerriers() ;

            // Lancement des combats
            plateau.lanceCombats() ;

            TOUR_DE_JEU++ ;
        }

        // Fin du jeu
        plateau.afficheGagnant() ;
    }
}
