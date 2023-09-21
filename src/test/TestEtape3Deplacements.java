package test ;

import data.* ;

import java.util.ArrayList ;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestEtape3Deplacements {

    // Logger et configuration
    private static Logger LOGGER = Logger.getLogger(TestEtape3Deplacements.class.getPackageName());
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$s] %4$-10s | (%3$s) %2$-15s | %5$s\n") ;
        LOGGER.setLevel(Level.INFO) ;
    }

    // Main
    public static void main (String[] args) {

        // ATTENTION : ici on ne teste que le déplacement, indépendemment de l'entrainement des guerriers
        // Pas besoin donc de créer un chateau et d'entrainer des guerriers : on crée des guerriers qu'on soumet directement au plateau

        //---------------------------------------------- Initialisations ---------------------------------------------//

        // Plateau
        int nbCarreauxTest = 10 ;
        Plateau plateauDeJeu = new Plateau (nbCarreauxTest) ;

        // Guerriers bleus
          // Premier groupe
        ArrayList<Guerrier> listeGuerriers = new ArrayList<>() ;
        Guerrier guerrier1 = new Elfe() ;     listeGuerriers.add(guerrier1) ;
        Guerrier guerrier2 = new Nain() ;     listeGuerriers.add(guerrier2) ;
        Guerrier guerrier3 = new ChefNain() ; listeGuerriers.add(guerrier3) ;
        Guerrier guerrier4 = new ChefElfe() ; listeGuerriers.add(guerrier4) ;
          // Deuxième groupe
        ArrayList<Guerrier> listeGuerriersSuppl = new ArrayList<>() ;
        Guerrier guerrier5 = new Elfe() ;     listeGuerriersSuppl.add(guerrier5) ;
        Guerrier guerrier6 = new Nain() ;     listeGuerriersSuppl.add(guerrier6) ;
        Guerrier guerrier7 = new ChefNain() ; listeGuerriersSuppl.add(guerrier7) ;

        // Guerriers rouges
          // Premier groupe
        ArrayList<Guerrier> listeGuerriersAdverses = new ArrayList<>() ;
        Guerrier guerrier8 = new Elfe() ;      listeGuerriersAdverses.add(guerrier8) ;
        Guerrier guerrier9 = new Nain() ;      listeGuerriersAdverses.add(guerrier9) ;
        Guerrier guerrier10 = new ChefNain() ; listeGuerriersAdverses.add(guerrier10) ;
        Guerrier guerrier11 = new ChefElfe() ; listeGuerriersAdverses.add(guerrier11) ;
        Guerrier guerrier12 = new ChefElfe() ; listeGuerriersAdverses.add(guerrier12) ;
          // Deuxième groupe
        ArrayList<Guerrier> listeGuerriersAdversesSuppl = new ArrayList<>() ;
        Guerrier guerrier13 = new Elfe() ;     listeGuerriersAdversesSuppl.add(guerrier13) ;
        Guerrier guerrier14 = new Nain() ;     listeGuerriersAdversesSuppl.add(guerrier14) ;


        //------------------------------------------- Tests de déplacement -------------------------------------------//
        int tourDeJeu = 1 ;
        boolean dernierCarreauVide = plateauDeJeu.getCarreaux().get(nbCarreauxTest-1).getGuerriersBleus().isEmpty() ;
        while (tourDeJeu<2*nbCarreauxTest && dernierCarreauVide) {
            LOGGER.log(Level.INFO, "Tour de jeu n°" + tourDeJeu + ". Etat des carreaux :") ;
            switch (tourDeJeu) {
                case 1 -> plateauDeJeu.ajoutGuerriersEnAttente(Couleur.BLEU, listeGuerriers) ;
                case 2 -> plateauDeJeu.ajoutGuerriersEnAttente(Couleur.ROUGE, listeGuerriersAdverses) ;
                case 5 -> plateauDeJeu.ajoutGuerriersEnAttente(Couleur.BLEU, listeGuerriersSuppl) ;
                case 8 -> plateauDeJeu.ajoutGuerriersEnAttente(Couleur.ROUGE, listeGuerriersAdversesSuppl) ;
            }
            plateauDeJeu.deplaceGuerriers() ;
            tourDeJeu++ ;
            dernierCarreauVide = plateauDeJeu.getCarreaux().get(nbCarreauxTest-1).getGuerriersBleus().isEmpty() ;
        }
    }
}