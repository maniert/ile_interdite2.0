package PasDefaultPackage;

import java.util.ArrayList;

public class Tuile {

    private int idTuile;
    private String nomTuile;
    private int x;
    private int y;
    private Etat etat;
    private ArrayList<Aventurier> aventuriers;

    public Tuile(int idTuile, String nomTuile, int x, int y) {
        this.idTuile = idTuile;
        this.nomTuile = nomTuile;
        this.x = x;
        this.y = y;
        this.etat = Etat.sec;
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
