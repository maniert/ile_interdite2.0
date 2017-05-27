package PasDefaultPackage;


import java.util.ArrayList;

public class Aventurier {

	private int typeRole;
	private int nbPA = 3;
	private int idaventurier;
        private Tuile t;
        private ArrayList<Carte> main;
        private ArrayList<Tuile> caseAtteignable;
        
         
	/**
	 * 
	 * @param tuile
	 */
	public void secher(Tuile tuile) {
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

	

	public void setNbPA() {
		// TODO - implement Aventurier.setNbPA
		throw new UnsupportedOperationException();
	}

	public void getRoleAventurier() {
		// TODO - implement Aventurier.getRoleAventurier
		throw new UnsupportedOperationException();
	}

	public void getPosXYJoueur() {
		// TODO - implement Aventurier.getPosXYJoueur
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param a
	 */
	public int getNbDeCartes(Aventurier a) {
		// TODO - implement Aventurier.getNbDeCartes
		throw new UnsupportedOperationException();
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
     * @return the typeRole
     */
    public int getTypeRole() {
        return typeRole;
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


      
    public void deplacementbasique(Aventurier a){
        int xPerso;
        int yPerso;
        xPerso = a.getTuile().getX();//récupére les coordonnées
        yPerso = a.getTuile().getY();//x et y du joueur de ce tour
        /*Haut   (xPerso)(yPerso-1)
        /*Bas   (xPerso)(yPerso+1) 
        /*gauche(xPerso-1)(yPerso)
        /*droite (xPerso+1)(yPerso)*/
        int i =0;
        getTuileAtteignable().add(getGrille().getLaTuile(xPerso, yPerso-1));
        getTuileAtteignable().add(getGrille().getLaTuile(xPerso, yPerso+1));
        getTuileAtteignable().add(getGrille().getLaTuile(xPerso-1, yPerso));
        getTuileAtteignable().add(getGrille().getLaTuile(xPerso+1, yPerso));
        
    }
    
    public void deplacementDiagonal(Aventurier a){
        int xPerso;
        int yPerso;
        xPerso = a.getTuile().getX();//récupére les coordonnées
        yPerso = a.getTuile().getY();//x et y du joueur de ce tour
        getTuileAtteignable().add(getGrille().getLaTuile(xPerso-1, yPerso-1));
        getTuileAtteignable().add(getGrille().getLaTuile(xPerso+1, yPerso-1));
        getTuileAtteignable().add(getGrille().getLaTuile(xPerso-1, yPerso+1));
        getTuileAtteignable().add(getGrille().getLaTuile(xPerso+1, yPerso+1));
    }
      
    public ArrayList<Tuile> getTuileAtteignable() {
        return caseAtteignable;
    }

    private Grille getGrille() {
         return grille;
       }
   
}