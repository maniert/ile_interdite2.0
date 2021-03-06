package PasDefaultPackage;

import static PasDefaultPackage.Etat.sec;
import java.util.ArrayList;

public class Aventurier {

    /**
     * @return the nbmaxPa
     */
    public int getNbmaxPa() {
        return 3;
    }

    private String nomJoueur;
    private TypeRole typeRole;
    private int nbPA;
    private int idaventurier;
    private Tuile t;
    private ArrayList<Carte> main;
    private ArrayList<Tuile> tuilesAtteignable;
    private ArrayList<Tuile> tuilesAssechable;
    private int nbCarteATiré;

    public Aventurier(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t) {
        this.nomJoueur = nomJoueur;
        this.typeRole = typeRole;
        this.idaventurier = idaventurier;
        this.t = t;
        this.main = main;
        this.tuilesAtteignable = new ArrayList<Tuile>();
        this.tuilesAssechable = new ArrayList<Tuile>();
        this.main = new ArrayList<>();
        this.nbCarteATiré = 2;
        this.nbPA = 3;
    }

    public Aventurier() {

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
    public void gagnerFigurine(TypeCarte typefigurine) {
        // TODO - implement Aventurier.gagnerFigurine
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param carteTresor
     */
    public void donnerCarte() {
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
    public void defausserCarteTresor() {
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
        if (this.existedéjà(g.getTuiles(), g.getLaTuile(xPerso, yPerso - 1)) && g.getLaTuile(xPerso, yPerso - 1).getEtat() != Etat.vide) {
            at.add(g.getLaTuile(xPerso, yPerso - 1));//haut
        }
        if (this.existedéjà(g.getTuiles(), g.getLaTuile(xPerso, yPerso + 1)) && g.getLaTuile(xPerso, yPerso + 1).getEtat() != Etat.vide) {
            at.add(g.getLaTuile(xPerso, yPerso + 1));//bas
        }

        if (this.existedéjà(g.getTuiles(), g.getLaTuile(xPerso - 1, yPerso)) && g.getLaTuile(xPerso - 1, yPerso).getEtat() != Etat.vide) {
            at.add(g.getLaTuile(xPerso - 1, yPerso));//gauche
        }
        if (this.existedéjà(g.getTuiles(), g.getLaTuile(xPerso + 1, yPerso)) && g.getLaTuile(xPerso + 1, yPerso).getEtat() != Etat.vide) {
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
        while (i <= this.getTuileAtteignable().size() - 1) {
            if (this.getTuileAtteignable().get(i).getEtat() == Etat.vide || this.getTuileAtteignable().get(i) == this.getTuile() || this.getTuileAtteignable().get(i).getEtat() == Etat.immergé) {
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
        System.out.println(tuilesAssechable.size());
    }

    public void filtrageTuileAssechable(ArrayList<Tuile> tuileAssechable, Grille g) {
        int i = 0;
        while (i != this.getTuileAssechable().size()) {
            if (this.getTuileAssechable().get(i).getEtat() == Etat.selectionné || this.getTuileAssechable().get(i).getEtat() == Etat.vide || this.getTuileAssechable().get(i).getEtat() == Etat.sec || this.getTuileAssechable().get(i).getEtat() == Etat.immergé) {
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

    /**
     * @param nbPA the nbPA to set
     */
    public void setNbPA(int nbPA) {
        this.nbPA = nbPA;
    }

    public void setHelicoDispo(boolean b) {
        System.out.println("Aventurier: nothing happened #setHelicoDispo");
    }

    /**
     * @return the deplacementSpePilote
     */
    public boolean isHelicoDispo() {
        System.out.println("Aventurier: nothing happened #isHelicoDispo");
        return false;
    }

    /**
     * @return the deplSpePilote
     */
    public boolean isDeplSpePilote() {
        System.out.println("Aventurier: nothing happened #isDeplSpePilote");
        return false;
    }

    /**
     * @param deplSpePilote the deplSpePilote to set
     */
    public void setDeplSpePilote(boolean deplSpePilote) {
        System.out.println("Aventurier: nothing happened #setDeplSpePilote");
    }

    /**
     * @return the assechInge
     */
    public ArrayList<Integer> getAssechInge() {
        return null;
    }

    /**
     * @param assechInge the assechInge to set
     */
    public void setAssechInge(ArrayList<Integer> assechInge) {
    }

    public void assecherInge(Grille grille) {

    }

    public int getNbTuileAssech() {
        return 0;
    }

    /**
     * @param ingeasseche the nbTuileAssech to set
     */
    public void setNbTuileAssech(int ingeasseche) {
    }

    /**
     * @return the nbCarteATiré
     */
    public int getNbCarteTiré() {
        return nbCarteATiré;
    }

    /**
     * @param nbCarteTiré the nbCarteATiré to set
     */
    public void setNbCarteTiré(int nbCarteTiré) {
        this.nbCarteATiré = nbCarteTiré;
    }

    public boolean peutRecupeTresor(ArrayList<Carte> ac, TypeCarte typeCarte) {
        int nbCarteFigurinePareil = 0;
        for (int i = 0; i < ac.size(); i++) {
            if (ac.get(0).getTypeCarte() == typeCarte) {
                nbCarteFigurinePareil++;
                i++;
            } else {
                i++;
            }
            if (nbCarteFigurinePareil >= 4) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
