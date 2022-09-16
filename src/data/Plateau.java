package data ;

import java.util.ArrayList ;


public class Plateau {

    // Attribut
    private ArrayList<Carreau> carreaux ;

    // Constructeur
    public Plateau(int longueur) {
        carreaux = new ArrayList<Carreau> (longueur) ;
    }

    // Getters
    public Couleur getGagnant() {
        return Couleur.BLEU ; // TEMPORAIRE
    }

    public ArrayList<Carreau> getCarreaux() {
        return carreaux ;
    }

    private Carreau getDepartBleu() {
        return new Carreau() ; // TEMPORAIRE
    }

    private Carreau getDepartRouge() {
        return new Carreau() ; // TEMPORAIRE
    }

    // Méthodes concernant le déplacement des joueurs
    public void ajoutGuerriers (Chateau chateau, ArrayList<Guerrier> guerriers) {

    }

    public void deplaceGuerriers() {

    }

    // Méthodes concernant le combat
    public void lanceCombats() {

    }

    public boolean estPartieTerminee() {
        return false ; // TEMPORAIRE
    }
}
