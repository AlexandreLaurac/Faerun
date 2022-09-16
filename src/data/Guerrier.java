package data ;

import utilitaires.GuerrierUtilitaire ;

import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class Guerrier {

    // Constantes
    public static final int FORCE_BASE = 10 ;
    public static final int POINTS_DE_VIE_MAX = 100 ;
    public static final int COUT_BASE = 1 ;
    private static Logger LOGGER = Logger.getLogger(Guerrier.class.getPackageName());

    // Configuration du logger
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$s] %4$-10s | (%3$s) %2$-15s | %5$s\n");
        LOGGER.setLevel(Level.INFO);
    }

    // Attributs
    private int pointsDeVie ;
    private int cout ;
    private Chateau chateau ;

    // Constructeur
    public Guerrier() {
        pointsDeVie = POINTS_DE_VIE_MAX ;
        cout = COUT_BASE ;
    }

    // Getters
    public int getForce() {
        return FORCE_BASE ;
    }

    public int getPointsDeVie() {
        return pointsDeVie ;
    }

    public int getCout() {
        return cout ;
    }

    public Couleur getCouleur() {
        return chateau.getCouleur() ;
    }

    // Setters
    private void setPointsDeVie (int pointsDeVie) {
        this.pointsDeVie = pointsDeVie ;
    }

    public void setChateau (Chateau chateau) {
        this.chateau = chateau ;
    }

    // Méthodes de vérification
    public boolean estVivant() {
        return getPointsDeVie() > 0 ;
    }

    public boolean estRouge() {
        return chateau.estRouge() ;
    }

    public boolean estBleu() {
        return chateau.estBleu() ;
    }

    /**
     *
     * @param guerrier
     */
    public void attaquer (Guerrier guerrier) {

        // Calcul des degats
        int degats = GuerrierUtilitaire.De3(getForce()) ;
        LOGGER.log(Level.INFO, "Dégats d'attaque : " + degats) ;

        // Faire subir les dégats au guerrier fourni en paramètres
        guerrier.subirDegats(degats) ;
    }

    /**
     *
     * @param degats
     */
    public void subirDegats (int degats) {
        setPointsDeVie (getPointsDeVie()-degats) ;
        LOGGER.log(Level.INFO, "Dégats subits : " + degats) ;
        LOGGER.log(Level.INFO, "Nouveaux points de vie : " + pointsDeVie + "\n") ;
    }
}
