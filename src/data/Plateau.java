package data ;

import java.util.ArrayList ;
import java.util.logging.Level ;
import java.util.logging.Logger ;


public class Plateau {

    // Constantes
    public static final int NB_CARREAUX_DEFAUT = 5 ;

    // Logger et configuration
    private static Logger LOGGER = Logger.getLogger(Plateau.class.getPackageName()) ;
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$s] %4$-10s | (%3$s) %2$-15s | %5$s\n") ;
        LOGGER.setLevel(Level.INFO) ;
    }

    // Attributs
    int nbCarreaux ;
    int numCarreauCombat ;
    private ArrayList<Carreau> carreaux ;
    private ArrayList<Guerrier> guerriersBleusEnAttente, guerriersRougeEnAttente ;

    // Constructeurs
    public Plateau() {
        nbCarreaux = NB_CARREAUX_DEFAUT ;
        carreaux = new ArrayList<>(NB_CARREAUX_DEFAUT) ;
        setNumCarreauCombat(-1) ;
        instanciationCarreaux() ;
        instanciationGuerriersEnAttente() ;
    }

    public Plateau (int longueur) {
        nbCarreaux = longueur ;
        carreaux = new ArrayList<>(longueur) ;
        setNumCarreauCombat(-1) ;
        instanciationCarreaux() ;
        instanciationGuerriersEnAttente() ;
    }

    private void instanciationCarreaux () {
        for (int i=0 ; i<nbCarreaux ; i++) {
            carreaux.add(new Carreau()) ;
        }
    }

    private void instanciationGuerriersEnAttente() {
        guerriersBleusEnAttente = new ArrayList<>() ;
        guerriersRougeEnAttente = new ArrayList<>() ;
    }

    // Setters
    public void setNumCarreauCombat (int numCarreauCombat) {
        this.numCarreauCombat = numCarreauCombat ;
    }

    // Getters
    public int getNbCarreaux() {
        return nbCarreaux ;
    }

    public ArrayList<Carreau> getCarreaux() {
        return carreaux ;
    }

    // Méthodes concernant le déplacement des joueurs
    public void ajoutGuerriersEnAttente (Couleur couleur, ArrayList<Guerrier> guerriers) {
        if (couleur == Couleur.BLEU) {
            guerriersBleusEnAttente = guerriers ;
        } else if (couleur == Couleur.ROUGE) {
            guerriersRougeEnAttente = guerriers ;
        }
    }

    public void deplaceGuerriers () {

        //------------------------------------------ Déplacement des Bleus -------------------------------------------//

        ArrayList<Guerrier> listeAttenteEntree = guerriersBleusEnAttente ;
        ArrayList<Guerrier> listeAttenteSortie = new ArrayList<>() ;

        // Traitement des carreaux sans Rouges
        int i = 0 ;
        while (i < nbCarreaux && carreaux.get(i).getGuerriersRouges().isEmpty()) {

            // Initialisations
            ArrayList<Guerrier> guerriersBleus = carreaux.get(i).getGuerriersBleus() ;

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
                LOGGER.log(Level.INFO, "\tEtat du carreau " + i + " : présence de " + guerriersBleus.size() + " guerriers bleus") ;
            }

            i++ ;
        }

        // Traitement éventuel du carreau avec Rouges
        if (i<nbCarreaux) {  // on est sorti de la boucle parce qu'on a rencontré des guerriers rouges dans le parcours du plateau
            // S'il existe des guerriers en attente pour entrer sur le carreau, on les ajoute aux guerriers bleus déjà présents sans mettre ces derniers en attente de sortie
            if (!listeAttenteEntree.isEmpty()) {
                carreaux.get(i).getGuerriersBleus().addAll(listeAttenteEntree) ;
                listeAttenteEntree.clear() ;
            }
            // Affichage de l'état du carreau en fin de déplacement le concernant
            if (!carreaux.get(i).getGuerriersBleus().isEmpty()) {
                LOGGER.log(Level.INFO, "\tEtat du carreau " + i + " : présence de " + carreaux.get(i).getGuerriersBleus().size() + " guerriers bleus") ;
            }
        }

        //----------------------------------------- Déplacement des Rouges -------------------------------------------//

        // Déclarations
        Carreau carreauCourant, carreauSuivant ;
        ArrayList<Guerrier> guerriersRougeCourant, guerriersRougeSuivant ;

        // On récupère d'abord le carreau à partir duquel réaliser l'analyse (on pourrait reprendre le i précédent avec un test)
        i = nbCarreaux - 1 ;
        while (i>=0 && carreaux.get(i).getGuerriersBleus().isEmpty()) {
            i-- ;
        }

        // Traitement des carreaux jusqu'au carreau n°nbCarreaux-2
        for ( ; i < nbCarreaux-1 ; i++) {

            // Initialisations
            carreauCourant = carreaux.get(i) ;
            carreauSuivant = carreaux.get(i+1) ;
            guerriersRougeCourant = carreauCourant.getGuerriersRouges() ;
            guerriersRougeSuivant = carreauSuivant.getGuerriersRouges() ;

            // Si le carreau suivant contient des guerriers, on les déplace dans le carreau courant
            if (!guerriersRougeSuivant.isEmpty()) {
                guerriersRougeCourant.addAll(guerriersRougeSuivant) ;
                guerriersRougeSuivant.clear() ;
            }

            // Affichage de l'état du carreau en fin de déplacement le concernant
            if (!guerriersRougeCourant.isEmpty()) {
                LOGGER.log(Level.INFO, "\tEtat du carreau " + i + " : présence de " + guerriersRougeCourant.size() + " guerriers rouges") ;
            }
        }

        // Traitement du dernier carreau
        if (!guerriersRougeEnAttente.isEmpty()) {

            // Initialisations
            carreauCourant = carreaux.get(nbCarreaux-1) ;
            guerriersRougeCourant = carreauCourant.getGuerriersRouges() ;
            guerriersRougeCourant.addAll(guerriersRougeEnAttente) ;
            guerriersRougeEnAttente.clear() ;  // pas très propre...

            // Affichage de l'état du carreau en fin de déplacement le concernant
            if (!guerriersRougeCourant.isEmpty()) {
                LOGGER.log(Level.INFO, "\tEtat du carreau " + (nbCarreaux-1) + " : présence de " + guerriersRougeCourant.size() + " guerriers rouges") ;
            }
        }
    }

    // Méthodes concernant le combat
    public void lanceCombats() {
        int i = 0 ;
        while (i < nbCarreaux && !(!carreaux.get(i).getGuerriersBleus().isEmpty() && !carreaux.get(i).getGuerriersRouges().isEmpty())) {
            i++ ;
        }
        if (i < nbCarreaux) {
            LOGGER.log(Level.INFO, "Lancement d'un combat dans le carreau " + i + " !") ;
            carreaux.get(i).lanceCombat() ;
        }
    }

    // Méthodes concernant la fin du jeu
    public boolean guerriersBleusArrives() {
        return !carreaux.get(nbCarreaux-1).getGuerriersBleus().isEmpty() ;
    }

    public boolean guerriersRougesArrives() {
        return !carreaux.get(0).getGuerriersRouges().isEmpty() ;
    }

    public boolean estPartieTerminee() {
        return guerriersBleusArrives() || guerriersRougesArrives() ;
    }

    public Couleur getGagnant() {
        Couleur couleur ;
        if (guerriersBleusArrives()) {
            couleur = Couleur.BLEU ;
        } else if (guerriersRougesArrives()) {
            couleur = Couleur.ROUGE ;
        } else {
            couleur = Couleur.AUCUN ;
        }
        return couleur ;
    }

    public void afficheGagnant() {
        String couleurChateauGagnant = "" ;
        if (getGagnant() == Couleur.BLEU) {
            couleurChateauGagnant = "bleu" ;
        } else if (getGagnant() == Couleur.ROUGE) {
            couleurChateauGagnant = "rouge" ;
        }
        LOGGER.log(Level.INFO, "Le chateau " + couleurChateauGagnant + " a gagné !!!") ;
    }
}
