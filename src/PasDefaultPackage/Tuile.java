package PasDefaultPackage;

import static PasDefaultPackage.Etat.vide;
import java.util.ArrayList;

public class Tuile {

    /**
     * @return the figure
     */
    public TypeCarte getFigure() {
        return figure;
    }

    /**
     * @param figure the figure to set
     */
    public void setFigure(TypeCarte figure) {
        this.figure = figure;
    }

    /**
     * @return the tresor
     */
    public ArrayList<TypeRole> getTresor() {
        return tresor;
    }

    /**
     * @param tresor the tresor to set
     */
    public void setTresor(ArrayList<TypeRole> tresor) {
        this.tresor = tresor;
    }

    private int idTuile;
    private String nomTuile;
    private int x;
    private int y;
    private Etat etat;
    private ArrayList<Aventurier> aventuriers;
    private ArrayList<TypeRole> tresor;
    private TypeCarte figure;

    public Tuile(int idTuile, String nomTuile, int x, int y) {
        this.idTuile = idTuile;
        this.nomTuile = nomTuile;
        this.x = x;
        this.y = y;
        this.etat = Etat.sec;
        this.figure = TypeCarte.vide;
        this.aventuriers = new ArrayList<Aventurier>();
    }

    public Tuile() {

    }

    public Etat getEtat() {
        return etat;
    }

    /**
     * @return the nomTuile
     */
    public String getNomTuile() {
        return nomTuile;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    public int getX(int idTuile) {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * @param idTuile
     * @return the y
     */
    public int getY(int idTuile) {
        return y;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the aventuriers
     */
    public ArrayList<Aventurier> getAventuriers() {
        return aventuriers;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

}
