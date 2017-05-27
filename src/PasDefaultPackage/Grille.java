package PasDefaultPackage;

import java.util.ArrayList;

public class Grille {

	private final int nbcolonne ;
	private final int nbligne;
        private ArrayList<Tuile> tuiles;

    public Grille() {
        this.nbligne = 6;
        this.nbcolonne = 6;
    }

    /**
     * @return the tuiles
     */
    public ArrayList<Tuile> getTuiles() {
        return tuiles;
    }
    
    public Tuile getLaTuile(int x, int y){
        int i = 0;
        while (i!=36){
            if(x==getTuiles().get(i).getX(i) && y==getTuiles().get(i).getY(i)){
                i++;
                return(getTuiles().get(i));
            } else {
                i++;
                
            }
        }
        return null;
    }

    /**
     * @param tuiles the tuiles to set
     */
    public void setTuiles(ArrayList<Tuile> tuiles) {
        this.tuiles = tuiles;
    }
    


}