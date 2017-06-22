package PasDefaultPackage;

import javax.swing.ImageIcon;

public class CMonteeDesEaux extends Carte {

    public CMonteeDesEaux(int numID, TypeCarte typeCarte, ImageIcon img) {
        super(numID, typeCarte, img);
    }

    /* x3 Monte le marqueur d'un cran + Melange la pile des défausse innondation
   + défausser la carte dans la pile de défausse des cTrésors
     */
}
