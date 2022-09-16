package data;

public class Elfe extends Guerrier {

    // Redéfinition de getForce
    public int getForce() {
        return super.getForce() * 2 ;
    }

    // Redéfinition de getCout
    public int getCout() {
        return super.getCout() + 1 ;
    }
}
