/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PasDefaultPackage;

/**
 *
 * @author maniert
 */
public class Message {

    public TypesMessages type;  // type de message
    public Tuile t;
    public int indiceTuile;
    private int nbj;

    /**
     * @return the indiceTuile
     */
    public int getIndiceTuile() {
        return indiceTuile;
    }

    /**
     * @param assechingeFrstTuile the indiceTuile to set
     */
    public void setIndiceTuile(int i) {
        this.indiceTuile = i;
    }

    /**
     * @return the nbj
     */
    public int getNbj() {
        return nbj;
    }

    /**
     * @param nbj the nbj to set
     */
    public void setNbj(int nbj) {
        this.nbj = nbj;
    }

}
