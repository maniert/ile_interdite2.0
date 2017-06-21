package PasDefaultPackage;

import java.util.ArrayList;
import java.util.Collections;

public class TasCartes {

    private ArrayList<Carte> cartesEnJeu;
    private ArrayList<Carte> cartesDefausse;

    public TasCartes() {
        cartesEnJeu = new ArrayList<>();
        cartesDefausse = new ArrayList<>();
    }

    public void defausserCarte(Carte cs, ArrayList<Carte> ac) {
        getCartesDefausse().add(ac.get(0));
        ac.remove(0);
    }

    /**
     * @return the cartesEnJeu
     */
    public ArrayList<Carte> getCartesEnJeu() {
        return cartesEnJeu;
    }

    /**
     * @return the cartesDefausse
     */
    public ArrayList<Carte> getCartesDefausse() {
        return cartesDefausse;
    }

    public void melangerCarteTresorDefausse() {
        Collections.shuffle(cartesDefausse);
    }
}
