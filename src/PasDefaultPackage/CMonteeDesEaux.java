package PasDefaultPackage;

import javax.swing.ImageIcon;
import view.VueNiveau;

public class CMonteeDesEaux extends Carte {

    private VueNiveau echelle;
    public CMonteeDesEaux(int numID, TypeCarte typeCarte, ImageIcon img) {
        super(numID, typeCarte, img);
        
        
        
        
        
        
        
        
        
//         echelle.setNiveau(2);
    }

    /* x2 Monte le marqueur d'un cran + Melange la pile des défausse innondation
   + défausser la carte dans la pile de défausse des cTrésors
    
    • Si vous tirez une carte Montée des eaux, vous ne recevez pas de carte de remplacement. 
    • Si vous tirez 2 cartes Montée des eaux, mélangez une seule fois la défausse des cartes Inondation mais montez le Marqueur de niveau de 2 crans. 
    • Si vous tirez une carte Montée des eaux mais qu’il n’y a pas de carte dans la pile de défausse des cartes Inondation, montez simplement le Marqueur de niveau d’1 cran
     */
}
