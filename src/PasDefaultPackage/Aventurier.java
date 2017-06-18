package PasDefaultPackage;

import static PasDefaultPackage.Etat.sec;
import static PasDefaultPackage.Etat.vide;
import java.util.ArrayList;

public class Aventurier {

    private String nomJoueur;
    private TypeRole typeRole;
    private int nbPA = 1;
    private int idaventurier;
    private Tuile t;
    private ArrayList<Carte> main;
    private ArrayList<Tuile> tuilesAtteignable;
    private ArrayList<Tuile> tuilesAssechable;
    boolean deplacementSpePilote;

    public Aventurier(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        this.nomJoueur = nomJoueur;
        this.typeRole = typeRole;
        this.idaventurier = idaventurier;
        this.t = t;
        this.main = main;
        this.tuilesAtteignable = new ArrayList<Tuile>();
        this.tuilesAssechable = new ArrayList<Tuile>();
        this.deplacementSpePilote = true;

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

    
    public void casePossiblebasique(Grille g, ArrayList<Tuile> at) {
        int xPerso;
        int yPerso;
        xPerso = this.getTuile().getX();//récupére les coordonnées
        yPerso = this.getTuile().getY();//x et y du joueur de ce tour
        if(this.existedéjà(g.getTuiles(), g.getLaTuile(xPerso, yPerso - 1))){
            at.add(g.getLaTuile(xPerso, yPerso - 1));//haut
        }
        if(this.existedéjà(g.getTuiles(), g.getLaTuile(xPerso, yPerso + 1))){
            at.add(g.getLaTuile(xPerso, yPerso + 1));//bas
        }
        
        if(this.existedéjà(g.getTuiles(), g.getLaTuile(xPerso - 1, yPerso))){
            at.add(g.getLaTuile(xPerso - 1, yPerso));//gauche
        }
        if(this.existedéjà(g.getTuiles(), g.getLaTuile(xPerso + 1, yPerso))){
           at.add(g.getLaTuile(xPerso + 1, yPerso));//droite
        }
        
    }
    //------------------------------------------------------------------
    //-------------------deplacement-------------------------------------
    public void setTuileAtteignable(Grille g) {
        getTuileAtteignable().clear();// vider l'arraylist avant de le remplir
        casePossiblebasique(g, tuilesAtteignable); //rentre les déplacements propre à tout les roles
        filtrageDeplacementpossible(getTuileAtteignable(), g); //filtrage null+innondé,immergé   
    }
    
    public ArrayList<Tuile> getTuileAtteignable() {
        return tuilesAtteignable;
    }

    public void filtrageDeplacementpossible(ArrayList<Tuile> tuileAtteignable, Grille g) {
        int i = 0;
        while (i != this.getTuileAtteignable().size()) {
            if (this.getTuileAtteignable().get(i).getEtat() == Etat.vide || this.getTuileAtteignable().get(i).getEtat() == Etat.immergé || this.getTuileAtteignable().get(i).getEtat() == Etat.innondé) {
                this.getTuileAtteignable().remove(this.getTuileAtteignable().get(i));
            } else {
                i++;
            }
        }
    }
    //-------------------------fin-deplacement-----------------------
    //----------------------------------------------------------------

    //---------------------------------------------------------------
    //----------------------debut-assecher---------------------------
   

    public ArrayList<Tuile> getTuileAssechable() {
        return tuilesAssechable;
    }
    
    public void setTuileAssechable(Grille g) {
        getTuileAssechable().clear();
        casePossiblebasique(g, tuilesAssechable);
        filtrageTuileAssechable(tuilesAssechable, g); //filtrage null+innondé,immergé 
    }
    
    public void filtrageTuileAssechable(ArrayList<Tuile> tuileAssechable, Grille g) {
        int i = 0;
        while (i != this.getTuileAssechable().size()) {
            if (this.getTuileAssechable().get(i).getEtat() == Etat.vide || this.getTuileAssechable().get(i).getEtat() == Etat.sec || this.getTuileAssechable().get(i).getEtat() == Etat.immergé) {
                this.getTuileAssechable().remove(this.getTuileAssechable().get(i));
            } else {
                i++;
            }
        }
    }
    
    public void assecher(Tuile tDest) {
        tDest.setEtat(sec);
        getTuileAssechable().clear();
    }
    //--------------------fin-assecher----------------------------------
    //-------------------------------------------------------------------

    /**
     * @param t the t to set
     */
    public void setT(Tuile t) {
        this.t = t;
    }

    public TypeRole getTypeRole() {
        return typeRole;
    }

    /**
     * @return the nomJoueur
     */
    public String getNomJoueur() {
        return nomJoueur;
    }

    /**
     * @param nomJoueur the nomJoueur to set
     */
    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }
    
    public boolean existedéjà(ArrayList<Tuile> at, Tuile t) {
        for (int i = 0; i < at.size(); i++) {
            if (at.get(i) == t) {
                return true;
            }
        }
        return false;
    }
    
     public void deplacement(Tuile tDest) {
        this.getTuile().getAventuriers().remove(this);
        this.setT(tDest);
        tDest.getAventuriers().add(this);
        this.tuilesAtteignable.clear();
    }

    
    

}
