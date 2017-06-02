package PasDefaultPackage;

import java.util.ArrayList;

public class Pilote extends Aventurier {

    public Pilote(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(nomJoueur, typeRole, idaventurier, t, main);
    }

    public void setTuileAtteignable(Grille g) {
        int i = 0;
        getTuileAtteignable().clear();// vider l'arraylist avant de le remplir
        if (deplacementSpePilote) {
            while (i != 36 && this.getTuile() != g.getTuiles().get(i)) {       // tant que l'on a pas parcouru tout et 
                getTuileAtteignable().add(g.getTuiles().get(i)); // que l'on est pas à la tuile de l'aventurier
            }                                                      // on ajout aux tuiles atteingables
        } else {
            deplacementPossiblebasique(g); //rentre les déplacements propre à tout les roles
        }
        filtrageDeplacementpossible(getTuileAtteignable(), g); //filtrage null+innondé,immergé 

    }
    
    public void setTuileAssechable(Grille g) {
        int i = 0;
        getTuileAssechable(g).clear();   
        tuileAssechablebasique(g);
        filtrageTuileAssechable(getTuileAssechable(g), g); //filtrage null+innondé,immergé 
    }
    
}
