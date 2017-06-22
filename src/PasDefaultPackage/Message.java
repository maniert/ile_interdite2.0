/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PasDefaultPackage;

import java.util.ArrayList;

/**
 *
 * @author maniert
 */
public class Message {

    public TypesMessages type;  // type de message
    public Tuile t;
    private int indiceTuile;
    private int indiceMain;
    private int nbj;
    private ArrayList<String> nomsJoueurs;

    public Message() {
        nomsJoueurs = new ArrayList<>();
    }

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

    /**
     * @return the nomsJoueursBase
     */
    public ArrayList<String> getNomsJoueurs() {
        return nomsJoueurs;
    }

    /**
     * @return the indiceMain
     */
    public int getIndiceMain() {
        return indiceMain;
    }

    /**
     * @param indiceMain the indiceMain to set
     */
    public void setIndiceMain(int indiceMain) {
        this.indiceMain = indiceMain;
    }
}
