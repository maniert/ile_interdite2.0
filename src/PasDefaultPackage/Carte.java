package PasDefaultPackage;

import javax.swing.ImageIcon;

public class Carte {

    private int numID;
    private TypeCarte typeCarte;
    private ImageIcon img;

    public Carte(int numID, TypeCarte typeCarte, ImageIcon img) {
        this.numID = numID;
        this.typeCarte = typeCarte;
        this.img = img;
    }

    /**
     * @return the typeCarte
     */
    public TypeCarte getTypeCarte() {
        return typeCarte;
    }

    /**
     *
     * @param t cartesTresorEnJeu.remove(0);//TODO ihm
     */
}
