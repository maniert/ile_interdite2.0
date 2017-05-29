package PasDefaultPackage;


import static PasDefaultPackage.TypeRole.pilote;
import static PasDefaultPackage.TypeRole.plongeur;
import java.util.ArrayList;

public class Aventurier {

	private int nbPA = 3;
	private int idaventurier;
        private Tuile t;
        private ArrayList<Carte> main;
        ArrayList<Tuile> tuilesAtteignable;
        private boolean deplacementSpePilote;
        private TypeRole typeRole;
    public Aventurier(TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        this.idaventurier = idaventurier;
        this.t = t;
        this.main = main;
        this.tuilesAtteignable = new ArrayList<Tuile>();
        this.deplacementSpePilote = true;
        
    }  public void deplacementPossiblePlongeur(Grille g){
        int xPerso;
        int yPerso;
        xPerso = this.getTuile().getX();//récupére les coordonnées
        yPerso = this.getTuile().getY();//x et y du joueur de ce tour
        deplacementPossiblebasique(g); //rentre les déplacements propre à tout les roles
        getTuileAtteignable(g).add(g.getLaTuile(xPerso-1, yPerso-1));//HG
        getTuileAtteignable(g).add(g.getLaTuile(xPerso+1, yPerso-1));//HD
        getTuileAtteignable(g).add(g.getLaTuile(xPerso-1, yPerso+1));//BG
        getTuileAtteignable(g).add(g.getLaTuile(xPerso+1, yPerso+1));//BD
    }
         
    public void filtrageDeplacementpossiblePlongeur(ArrayList<Tuile> tuileAtteignable,Grille g) {
        int i = 0;
        while (i != this.getTuileAtteignable(g).size()+1){
            if (this.getTuileAtteignable(g).get(i) == null ){
                this.getTuileAtteignable(g).remove(this.getTuileAtteignable(g).get(i));
            } else {
                i++;
            }
        }
    } 
        
        
        
	/**
	 * 
	 * @param tuile
	 */
	public void assecher(Tuile tuile) {
		// TODO - implement Aventurier.secher
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param typefigurine
	 */
	public void gagnerFigurine(TypeFigurine typefigurine) {
		// TODO - implement Aventurier.gagnerFigurine
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param carteTresor
	 */
	public void donnerCarte(Ctrésor carteTresor) {
		// TODO - implement Aventurier.donnerCarte
		throw new UnsupportedOperationException();
	}

	
	/**
	 * 
	 * @param a
     * @return 
	 */
	public int getNbDeCartes(Aventurier a) {
		// TODO - implement Aventurier.getNbDeCartes
                return main.size();
        }

	/**
	 * 
	 * @param carteTresor
	 */
	public void defausserCarteTresor(Ctrésor carteTresor) {
		// TODO - implement Aventurier.defausserCarteTresor
		throw new UnsupportedOperationException();
	}

	public void jouerCarteSpéciale() {
		// TODO - implement Aventurier.jouerCarteSpéciale
		throw new UnsupportedOperationException();
	}
        


    /**
     * @return the nbPA
     */
    public int getNbPA() {
        return nbPA;
    }

    /**
     * @return the t
     */
    public Tuile getTuile() {
        return t;
    }

    /**
     * @return the main
     */
    public ArrayList<Carte> getMain() {
        return main;
    }


      
    public void deplacementPossiblebasique(Grille g){
        int xPerso;
        int yPerso;
        xPerso = this.getTuile().getX();//récupére les coordonnées
        yPerso = this.getTuile().getY();//x et y du joueur de ce tour
        int i =0;
        getTuileAtteignable(g).add(g.getLaTuile(xPerso, yPerso-1));//haut
        getTuileAtteignable(g).add(g.getLaTuile(xPerso, yPerso+1));//bas
        getTuileAtteignable(g).add(g.getLaTuile(xPerso-1, yPerso));//gauche
        getTuileAtteignable(g).add(g.getLaTuile(xPerso+1, yPerso));//droite
        
    }
    
    public ArrayList<Tuile> getTuileAtteignable(Grille g) {
        getTuileAtteignable(g).clear(); // vider l'arraylist avant de le remplir
        deplacementPossiblePilote(g);   // ajout de toutes les tuiles possible sauf ça 
        filtrageDeplacementpossible(tuilesAtteignable, g); //filtrage null+innondé,immergé   
        return tuilesAtteignable;
    }

      
    public void setTuileAtteignable(Grille g) {
                  
    }                            
    
   
    public void filtrageDeplacementpossible(ArrayList<Tuile> tuileAtteignable, Grille g) {
        int i = 0;
        while (i != this.getTuileAtteignable(g).size()+1){
            if (this.getTuileAtteignable(g).get(i) == null || this.getTuileAtteignable(g).get(i).getEtat() == Etat.immergé || this.getTuileAtteignable(g).get(i).getEtat() == Etat.innondé){
                this.getTuileAtteignable(g).remove(this.getTuileAtteignable(g).get(i));
            } else {
                i++;
            }
        }
    }   
    
    //-------------------------------------------------------------------------------------
    //Déplacementspéciaux
    //-------------------------------------------------------------------------------------
    public void deplacementPossibleExplorateur(Grille g){
        int xPerso;
        int yPerso;
        xPerso = this.getTuile().getX();//récupére les coordonnées
        yPerso = this.getTuile().getY();//x et y du joueur de ce tour
        getTuileAtteignable(g).add(g.getLaTuile(xPerso-1, yPerso-1));//HG
        getTuileAtteignable(g).add(g.getLaTuile(xPerso+1, yPerso-1));//HD
        getTuileAtteignable(g).add(g.getLaTuile(xPerso-1, yPerso+1));//BG
        getTuileAtteignable(g).add(g.getLaTuile(xPerso+1, yPerso+1));//BD
    }
    
    public void deplacementPossiblePilote(Grille g){
        int xPerso;
        int yPerso;
        xPerso = this.getTuile().getX();//récupére les coordonnées
        yPerso = this.getTuile().getY();//x et y du joueur de ce tour
        int i = 0;
        if (deplacementSpePilote){
        while (i!=36 && this.t != g.getTuiles().get(i)){       // tant que l'on a pas parcouru tout et 
             getTuileAtteignable(g).add(g.getTuiles().get(i)); // que l'on est pas à la tuile de l'aventurier
        }                                                      // on ajout aux tuiles atteingables
        }else {
            deplacementPossiblebasique(g); //rentre les déplacements propre à tout les roles
        }
    }
    
        
        
    //-------------------------------------------------------------------------------------

    /**
     * @param t the t to set
     */
    public void setT(Tuile t) {
        this.t = t;
    }

    TypeRole getTypeRole() {
        return typeRole;
    }
  
    
}