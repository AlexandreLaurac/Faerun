package data;

public class ChefElfe extends Elfe {

    // METTRE LES 2 EN CONSTANTES DE CLASSE !

    // Redéfinition de getForce
    public int getForce() {
        return super.getForce() * 2 ;
    }

    // Redéfinition de getCout
    public int getCout() {
        return super.getCout() + 2 ;
    }
}
