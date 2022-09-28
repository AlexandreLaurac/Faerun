package data ;

public class ChefNain extends Nain {

    // METTRE LE 2 EN CONSTANTES DE CLASSE !

    // Redéfinition de subirDegats
    public void subirDegats (int degats) {
        super.subirDegats(degats/2) ;
    }

    // Redéfinition de getCout
    public int getCout() {
        return super.getCout() + 2 ;
    }
}
