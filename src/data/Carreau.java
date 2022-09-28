package data ;

import test.TestEtape3Deplacements;

import java.lang.reflect.Array;
import java.util.ArrayList ;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Carreau {

    // Logger et configuration
    private static Logger LOGGER = Logger.getLogger(Carreau.class.getPackageName());
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$s] %4$-10s | (%3$s) %2$-15s | %5$s\n") ;
        LOGGER.setLevel(Level.INFO) ;
    }

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
    public void ajoutGuerriersBleus(ArrayList<Guerrier> guerriers) {
        guerriersBleus.addAll(guerriers) ;
    }

    public void ajoutGuerriersRouges(ArrayList<Guerrier> guerriers) {
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
        return true; // TEMPORAIRE
    }

    public boolean estRouge() {
        return false; // TEMPORAIRE
    }

    public boolean estChampDeBataille() {
        return true; // TEMPORAIRE
    }

    public void lanceCombat() {

        // Informations
        LOGGER.log(Level.INFO, "Guerriers en présence :") ;
        LOGGER.log(Level.INFO, "\t guerriers bleus : " + guerriersBleus.size() + " guerriers") ;
        LOGGER.log(Level.INFO, "\t CONTRE") ;
        LOGGER.log(Level.INFO, "\t guerriers rouges : " + guerriersRouges.size() + " guerriers\n") ;

        // Déclarations
        Guerrier guerrierBleuCourant ;
        Guerrier guerrierRougeCourant ;

        // Attaque par les bleus en premier
        LOGGER.log(Level.INFO, "Les bleus attaquent en premier\n") ;
        guerrierRougeCourant = guerriersRouges.get(0) ;
        int i = 0 ;
        while (i < guerriersBleus.size() && !guerriersRouges.isEmpty()) {
            // Attaque du guerrier rouge courant par le guerrier bleu courant
            LOGGER.log(Level.INFO, "Le guerrier bleu n°" + (i+1) + " attaque le guerrier rouge en tête") ;
            guerrierBleuCourant = guerriersBleus.get(i);
            guerrierBleuCourant.attaquer(guerrierRougeCourant);

            // Si le guerrier rouge est mort et qu'il reste des guerriers rouges, on met à jour le guerrier rouge courant
            if (!guerrierRougeCourant.estVivant()) {
                LOGGER.log(Level.INFO, "Le guerrier rouge de tête est mort !") ;
                guerriersRouges.remove(guerrierRougeCourant) ;
                if (!guerriersRouges.isEmpty()) {
                    LOGGER.log(Level.INFO, "Il est remplacé\n") ;
                    guerrierRougeCourant = guerriersRouges.get(0) ;
                }
                else {
                    LOGGER.log(Level.INFO, "Tous les rouges sont morts !!!") ;
                }
            }
            i++ ;
        }

        // Attaque par les rouges en second
        if (!guerriersRouges.isEmpty()) {  // on vérifie d'abord qu'on n'a pas tué tous les rouges

            // Informations mises à jour
            LOGGER.log(Level.INFO, "Les rouges attaquent en second") ;
            LOGGER.log(Level.INFO, "Il reste " + guerriersRouges.size() + " guerriers rouges") ;
            LOGGER.log(Level.INFO, "les bleus sont toujours " + guerriersBleus.size() + "guerriers\n") ;

            guerrierBleuCourant = guerriersBleus.get(0) ;
            i = 0 ;
            while (i<guerriersRouges.size() && !guerriersBleus.isEmpty()) {
                // Attaque du guerrier bleu courant par le guerrier rouge courant
                LOGGER.log(Level.INFO, "Le guerrier rouge n°" + (i+1) + " attaque le guerrier bleu en tête") ;
                guerrierRougeCourant = guerriersRouges.get(i) ;
                guerrierRougeCourant.attaquer(guerrierBleuCourant) ;

                // Si le guerrier bleu est mort et qu'il reste des guerriers bleus, on met à jour le guerrier bleu courant
                if (!guerrierBleuCourant.estVivant()) {
                    LOGGER.log(Level.INFO, "Le guerrier bleu de tête est mort !") ;
                    guerriersBleus.remove(guerrierBleuCourant) ;
                    if (!guerriersBleus.isEmpty()) {
                        LOGGER.log(Level.INFO, "Il est remplacé\n") ;
                        guerrierBleuCourant = guerriersBleus.get(0) ;
                    }
                    else {
                        LOGGER.log(Level.INFO, "Tous les bleus sont morts !!!") ;
                    }
                }
                i++ ;
            }
        }
    }
}