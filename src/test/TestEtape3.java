package test ;

import data.* ;

import java.util.ArrayList ;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestEtape3 {

    // Logger et configuration
    private static Logger LOGGER = Logger.getLogger(TestEtape3.class.getPackageName());
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$s] %4$-10s | (%3$s) %2$-15s | %5$s\n") ;
        LOGGER.setLevel(Level.INFO) ;
    }

    // Main
    public static void main (String[] args) {

        // ATTENTION : ici on ne teste que le déplacement, indépendemment de l'entrainement des guerriers
        // Pas besoin donc de créer un chateau et d'entrainer des guerriers : on crée des guerriers qu'on soumet directement au plateau

        // Initialisations
        int nbCarreauxTest = 20 ;
        Plateau plateauDeJeu = new Plateau (nbCarreauxTest) ;
        ArrayList<Guerrier> listeGuerriers = new ArrayList<>() ;
        Guerrier guerrier1 = new Elfe() ;     listeGuerriers.add(guerrier1) ;
        Guerrier guerrier2 = new Nain() ;     listeGuerriers.add(guerrier2) ;
        Guerrier guerrier3 = new ChefNain() ; listeGuerriers.add(guerrier3) ;
        Guerrier guerrier4 = new ChefElfe() ; listeGuerriers.add(guerrier4) ;

        ArrayList<Guerrier> listeGuerriersSuppl = new ArrayList<>() ;
        Guerrier guerrier5 = new Elfe() ;     listeGuerriersSuppl.add(guerrier5) ;
        Guerrier guerrier6 = new Nain() ;     listeGuerriersSuppl.add(guerrier6) ;
        Guerrier guerrier7 = new ChefNain() ; listeGuerriersSuppl.add(guerrier7) ;

        // Lancement du déplacement
        int tourDeJeu = 1 ;
        boolean dernierCarreauVide = plateauDeJeu.getCarreaux().get(nbCarreauxTest-1).getGuerriersBleus().isEmpty() ;
        while (dernierCarreauVide) {
            LOGGER.log(Level.INFO, "Tour de jeu n°" + tourDeJeu + ". Etat des carreaux :") ;
            if (tourDeJeu == 3) {
                listeGuerriers = listeGuerriersSuppl ;
            }
            plateauDeJeu.deplaceGuerriers(listeGuerriers) ;
            tourDeJeu++ ;
            dernierCarreauVide = plateauDeJeu.getCarreaux().get(nbCarreauxTest-1).getGuerriersBleus().isEmpty() ;
        }
    }
}
