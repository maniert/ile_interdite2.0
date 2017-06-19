package PasDefaultPackage;

import java.util.ArrayList;

public class Ingenieur extends Aventurier {

    public Ingenieur(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(nomJoueur, typeRole, idaventurier, t, main);
    }

    public void setTuileAssechable(Grille g) { // devra pouvoir selectionner 2 cases
        getTuileAssechable().clear();
        casePossiblebasique(g, this.getTuileAtteignable());
        filtrageTuileAssechable(getTuileAssechable(), g); //filtrage null+innondé,immergé 
    }

}
