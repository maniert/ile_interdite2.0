package PasDefaultPackage;

import static PasDefaultPackage.Etat.innondé;
import static PasDefaultPackage.Etat.sec;
import static PasDefaultPackage.Etat.immergé;

public class Innondation extends Carte {

    Tuile tuile;

    public Innondation(int numID, String nomCarte) {
        super(numID, nomCarte);
    }    
        
        public void changeEtat(Tuile t){
            if (t.getEtat() == sec){
                t.setEtat(innondé);
            } else if( t.getEtat()==innondé) {
                t.setEtat(immergé);
                
            }
        }
}

    


