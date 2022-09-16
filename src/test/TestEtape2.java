package test ;

import data.* ;


public class TestEtape2 {

    // Main
    public static void main (String[] args) {

        // Initialisation du chateau
        Chateau chateau = new Chateau (Couleur.BLEU) ;

        // Initialisations des guerriers
        Guerrier guerrier1 = new Nain() ; chateau.ajoutGuerrierNovice(guerrier1) ;
        Guerrier guerrier2 = new Nain() ; chateau.ajoutGuerrierNovice(guerrier2) ;
        Guerrier guerrier3 = new Elfe() ; chateau.ajoutGuerrierNovice(guerrier3) ;
        Guerrier guerrier4 = new Elfe() ; chateau.ajoutGuerrierNovice(guerrier4) ;

        // Entrainement des guerriers
        chateau.entrainer() ;
    }
}