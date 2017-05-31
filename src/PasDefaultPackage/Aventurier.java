package PasDefaultPackage;

import static PasDefaultPackage.TypeRole.pilote;
import static PasDefaultPackage.TypeRole.plongeur;
import java.util.ArrayList;

public class Aventurier {

    private String nomJoueur;
    private TypeRole typeRole;
    private int nbPA = 3;
    private int idaventurier;
    Tuile t;
    private ArrayList<Carte> main;
    ArrayList<Tuile> tuilesAtteignable;
    boolean deplacementSpePilote;

    public Aventurier(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        this.nomJoueur = nomJoueur;
        this.typeRole = typeRole;
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
     * @param tuile
     */
    //public void assecher(Tuile tuile) {
        // TODO - implement Aventurier.secher
    //    throw new UnsupportedOperationException();
    //}

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

    public void deplacementPossiblebasique(Grille g) {
        int xPerso;
        int yPerso;
        xPerso = this.getTuile().getX();//récupére les coordonnées
        yPerso = this.getTuile().getY();//x et y du joueur de ce tour
        int i = 0;
        getTuileAtteignable(g).add(g.getLaTuile(xPerso, yPerso - 1));//haut
        getTuileAtteignable(g).add(g.getLaTuile(xPerso, yPerso + 1));//bas
        getTuileAtteignable(g).add(g.getLaTuile(xPerso - 1, yPerso));//gauche
        getTuileAtteignable(g).add(g.getLaTuile(xPerso + 1, yPerso));//droite

    }

    public ArrayList<Tuile> getTuileAtteignable(Grille g) {
        return tuilesAtteignable;
    }

      
    public void setTuileAtteignable(Grille g) {
                  
    }                            
    
   
    public void filtrageDeplacementpossible(ArrayList<Tuile> tuileAtteignable, Grille g) {
        int i = 0;
        while (i != this.getTuileAtteignable(g).size() + 1) {
            if (this.getTuileAtteignable(g).get(i) == null || this.getTuileAtteignable(g).get(i).getEtat() == Etat.immergé || this.getTuileAtteignable(g).get(i).getEtat() == Etat.innondé) {
                this.getTuileAtteignable(g).remove(this.getTuileAtteignable(g).get(i));
            } else {
                i++;
            }
        }
    }

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
