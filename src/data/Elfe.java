package data;

public class Elfe extends Guerrier {

    // METTRE LES 2 et le 1 EN CONSTANTES DE CLASSE !

    // Redéfinition de getForce
    public int getForce() {
        return super.getForce() * 2 ;
    }

    // Redéfinition de getCout
    public int getCout() {
        return super.getCout() + 1 ;
    }
}
