package data ;

public class ChefNain extends Nain {

    // Redéfinition de subirDegats
    public void subirDegats (int degats) {
        super.subirDegats(degats/2) ;
    }

    // Redéfinition de getCout
    public int getCout() {
        return super.getCout() + 2 ;
    }
}
