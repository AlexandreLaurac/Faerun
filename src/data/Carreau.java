package data ;

import java.lang.reflect.Array;
import java.util.ArrayList ;


public class Carreau {

    // Attributs
    private ArrayList<Guerrier> guerriersBleus ;
    private ArrayList<Guerrier> guerriersRouges ;

    // Constructeur
    public Carreau() {
        guerriersBleus = new ArrayList<>() ;
        guerriersRouges = new ArrayList<>() ;
    }

    // Getters
    public ArrayList<Guerrier> getGuerriersBleus() {
        return guerriersBleus ;
    }

    public ArrayList<Guerrier> getGuerriersRouges() {
        return guerriersRouges ;
    }

    // Méthodes d'ajout de guerriers
    public void ajoutGuerriersBleus (ArrayList<Guerrier> guerriers) {
        guerriersBleus.addAll(guerriers) ;
    }

    public void ajoutGuerriersRouges (ArrayList<Guerrier> guerriers) {
        guerriersRouges.addAll(guerriers) ;
    }

    // Méthodes de retrait de guerriers
    public ArrayList<Guerrier> retirerGuerrierBleus() {
        return new ArrayList<Guerrier>() ; // TEMPORAIRE
    }

    public ArrayList<Guerrier> retirerGuerrierRouges() {
        return new ArrayList<Guerrier>() ; // TEMPORAIRE
    }

    public void supprimerGuerrier(Guerrier guerrier) {

    }

    // Méthodes de vérification de la couleur
    public boolean estBLEU() {
        return true ; // TEMPORAIRE
    }

    public boolean estRouge() {
        return false ; // TEMPORAIRE
    }

    public boolean estChampDeBataille() {
        return true ; // TEMPORAIRE
    }

    public void lanceCombat() {

    }
}
