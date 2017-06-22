package PasDefaultPackage;

import java.awt.Image;
import javax.swing.ImageIcon;

public class CInnondation extends Carte {

    private Tuile tuile;
    private String nomCarte;

    public CInnondation(int numID, String nomCarte, Tuile t,ImageIcon img) {
        super(numID, TypeCarte.innondation, img);
        this.nomCarte = nomCarte;
        this.tuile = t;
    }

}
