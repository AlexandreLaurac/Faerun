package data ;

import java.util.ArrayList ;
import java.util.logging.Level ;
import java.util.logging.Logger ;


public class Plateau {

    // Constantes
    public static final int NB_CARREAUX = 5 ;

    // Logger et configuration
    private static Logger LOGGER = Logger.getLogger(Plateau.class.getPackageName()) ;
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$s] %4$-10s | (%3$s) %2$-15s | %5$s\n") ;
        LOGGER.setLevel(Level.INFO) ;
    }

    // Attributs
    int nbCarreaux ;
    private ArrayList<Carreau> carreaux ;

    // Constructeurs
    public Plateau() {
        nbCarreaux = NB_CARREAUX ;
        carreaux = new ArrayList<Carreau> (NB_CARREAUX) ;
        instanciationCarreaux() ;
    }

    public Plateau (int longueur) {
        nbCarreaux = longueur ;
        carreaux = new ArrayList<Carreau> (longueur) ;
        instanciationCarreaux() ;
    }

    private void instanciationCarreaux () {
        for (int i=0 ; i<nbCarreaux ; i++) {
            carreaux.add(new Carreau()) ;
        }
    }

    // Getters
    public int getNbCarreaux() {
        return nbCarreaux ;
    }

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

    /*
    public void deplaceGuerriers (ArrayList<Guerrier> listeGuerriersEntraines) { // Première version : guerriers d'un seul chateau à déplacer (le bleu)
                                                                                 // présence de l'argument à revoir : utiliser plutôt la méthode ajoutGuerriers avec emploi éventuel d'attributs supplémentaires
            ArrayList<Guerrier> listeAttenteEntree = listeGuerriersEntraines ;
            ArrayList<Guerrier> listeAttenteSortie = new ArrayList<>() ;

            // Traitement des différents carreaux
            for (int i = 0 ; i < nbCarreaux ; i++) {

                // Initialisations
                Carreau carreauCourant = carreaux.get(i) ;
                ArrayList<Guerrier> guerriersBleus = carreauCourant.getGuerriersBleus() ;

                // Si le carreau contient des guerriers, on les met en attente (et on vide le carreau)
                if (!guerriersBleus.isEmpty()) {
                    listeAttenteSortie.addAll(guerriersBleus) ;
                    guerriersBleus.clear() ;
                }

                // S'il exite des guerriers en attente pour entrer sur le carreau, on les ajoute à celui-ci (et on vide la liste d'attente en entrée)
                if (!listeAttenteEntree.isEmpty()) {
                    guerriersBleus.addAll(listeAttenteEntree) ;
                    listeAttenteEntree.clear() ;
                }

                // Préparation pour la case suivante : on inverse les listes d'attente (la liste d'attente en sortie devient la liste d'attente en entrée du carreau suivant)
                if (!listeAttenteSortie.isEmpty()) {
                    listeAttenteEntree.addAll(listeAttenteSortie) ;
                    listeAttenteSortie.clear() ;
                }

                // Affichage de l'état du carreau en fin de déplacement le concernant
                if (!guerriersBleus.isEmpty()) {
                    LOGGER.log(Level.INFO, "\tEtat du carreau " + i + " : présence de " + guerriersBleus.size() + " guerriers") ;
                }
            }
        }
*/

    public void deplaceGuerriers (ArrayList<Guerrier> listeGuerriersEntraines) { // Deuxième version : guerriers du chateau rouge à déplacer
                                                                                 // présence de l'argument à revoir : utiliser plutôt la méthode ajoutGuerriers avec emploi éventuel d'attributs supplémentaires
        // Déclarations
        Carreau carreauCourant, carreauSuivant ;
        ArrayList<Guerrier> guerriersRougeCourant, guerriersRougeSuivant ;

        // Traitement des n-1 premiers carreaux
        for (int i = 0 ; i < nbCarreaux-1 ; i++) {

            // Initialisations
            carreauCourant = carreaux.get(i) ;
            carreauSuivant = carreaux.get(i+1) ;
            guerriersRougeCourant = carreauCourant.getGuerriersRouges() ;
            guerriersRougeSuivant = carreauSuivant.getGuerriersRouges() ;

            // Le carreau courant est vide, si le carreau suivant contient des guerriers on les déplace dans le carreau courant
            if (!guerriersRougeSuivant.isEmpty()) {
                guerriersRougeCourant.addAll(guerriersRougeSuivant) ;
                guerriersRougeSuivant.clear() ;
            }

            // Affichage de l'état du carreau en fin de déplacement le concernant
            if (!guerriersRougeCourant.isEmpty()) {
                LOGGER.log(Level.INFO, "\tEtat du carreau " + i + " : présence de " + guerriersRougeCourant.size() + " guerriers") ;
            }
        }

        // Traitement du dernier carreau
        if (!listeGuerriersEntraines.isEmpty()) {

            // Initialisations
            carreauCourant = carreaux.get(nbCarreaux-1) ;
            guerriersRougeCourant = carreauCourant.getGuerriersRouges() ;
            guerriersRougeCourant.addAll (listeGuerriersEntraines) ;
            listeGuerriersEntraines.clear() ;  // pas très propre...

            // Affichage de l'état du carreau en fin de déplacement le concernant
            if (!guerriersRougeCourant.isEmpty()) {
                LOGGER.log(Level.INFO, "\tEtat du carreau " + (nbCarreaux-1) + " : présence de " + guerriersRougeCourant.size() + " guerriers") ;
            }
        }
    }

    // Méthodes concernant le combat
    public void lanceCombats() {

    }

    public boolean estPartieTerminee() {
        return false ; // TEMPORAIRE
    }
}
