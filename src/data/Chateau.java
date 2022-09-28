package data ;

import java.util.ArrayList ;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Chateau {

    // Constantes
    public static final int RESSOURCES_INITIALES = 3 ;
    public static final int RESSOURCES_AJOUTEES_PAR_TOUR = 1 ;

    // Configuration du logger
    private static Logger LOGGER = Logger.getLogger(Chateau.class.getPackageName());
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$s] %4$-10s | (%3$s) %2$-15s | %5$s\n");
        LOGGER.setLevel(Level.INFO);
    }

    // Attributs
    private int ressources ;
    private final Couleur couleur ;
    private Plateau plateau ;
    private ArrayList<Guerrier> guerriersNovices ;

    // Constructeur
    public Chateau (Couleur couleur, Plateau plateau) {  // A VERIFIER POUR LE PLATEAU
        ressources = RESSOURCES_INITIALES ;
        this.couleur = couleur ;
        this.plateau = plateau ;
        guerriersNovices = new ArrayList<> () ;
    }

    // Méthode d'ajout d'un guerrier novice à la liste de guerriers
    public void ajoutGuerrierNovice(Guerrier guerrier) {
        guerriersNovices.add(guerrier) ;
        guerrier.setChateau(this) ;
    }

    // Getter de la couleur
    public Couleur getCouleur() {
        return couleur ;
    }

    // Getter des guerriers
    public ArrayList<Guerrier> getGuerriersNovices () {
        return guerriersNovices ;
    }

    // Méthode estBleu
    public boolean estBleu() {
        return couleur == Couleur.BLEU ;
    }

    // Méthode estRouge
    public boolean estRouge() {
        return couleur == Couleur.ROUGE ;
    }

    // Méthode privée d'incrémentation des ressources
    private void incrementerRessources() {
        ressources += RESSOURCES_AJOUTEES_PAR_TOUR ;
    }

    // Méthode d'entrainement des guerriers
    public ArrayList<Guerrier> entrainer() {

        LOGGER.log(Level.INFO, "Nombre de guerriers restant à entrainer : " + guerriersNovices.size() + ", ressources disponibles : " + ressources) ;

        ArrayList<Guerrier> guerriersEntraines = new ArrayList<>() ;
        int numGuerrierCourant = 0 ;

        // Tant que l'on possède des guerriers et que l'on dispose de ressources pour les entrainer
        while (!guerriersNovices.isEmpty() && guerriersNovices.get(0).getCout() <= ressources) {

            // On récupère le premier guerrier de la liste
            Guerrier guerrierCourant = guerriersNovices.get(0) ;
            numGuerrierCourant++ ;

            // On soustrait son cout aux ressources
            int coutGuerrierCourant = guerrierCourant.getCout() ;
            ressources -= coutGuerrierCourant ;

            // On l'ajoute à la liste des guerriers entrainés et on l'enlève de la liste des guerriers novices
            guerriersEntraines.add(guerrierCourant) ;
            guerriersNovices.remove(guerrierCourant) ;

            // Rapport
            LOGGER.log(Level.INFO, "Entrainement du guerrier " + numGuerrierCourant + ", ressources prises : " + coutGuerrierCourant) ;
        }

        LOGGER.log(Level.INFO, "Nombre de guerriers entrainés : " + numGuerrierCourant + ", ressources restantes : " + ressources) ;
        incrementerRessources() ;
        return guerriersEntraines ;
    }
}
