package data ;

public class Nain extends Guerrier {

    // Redéfinition de subirDegats
    public void subirDegats (int degats) {
        super.subirDegats(degats/2) ;
    }
}
