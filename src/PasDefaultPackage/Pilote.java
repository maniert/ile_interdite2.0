package PasDefaultPackage;

import java.util.ArrayList;

public class Pilote extends Aventurier{
    
    public Pilote(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(nomJoueur, typeRole, idaventurier, t, main);
    }
    
    public ArrayList<Tuile> getTuileAtteignable(Grille g) {
        int i = 0;
        getTuileAtteignable(g).clear();// vider l'arraylist avant de le remplir
        if (deplacementSpePilote) {
            while (i != 36 && this.t != g.getTuiles().get(i)) {       // tant que l'on a pas parcouru tout et 
                getTuileAtteignable(g).add(g.getTuiles().get(i)); // que l'on est pas à la tuile de l'aventurier
            }                                                      // on ajout aux tuiles atteingables
        } else {
            deplacementPossiblebasique(g); //rentre les déplacements propre à tout les roles
        }
        filtrageDeplacementpossible(tuilesAtteignable, g); //filtrage null+innondé,immergé 
        return tuilesAtteignable;
    }
    
}
 