package PasDefaultPackage;

import java.util.ArrayList;

public class Pilote extends Aventurier {

    private boolean deplacementSpePilote;

    public Pilote(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(nomJoueur, typeRole, idaventurier, t, main);
        this.deplacementSpePilote = true;
    }

    @Override
    public void setTuileAtteignable(Grille g) {
        int i = 0;
        getTuileAtteignable().clear();// vider l'arraylist avant de le remplir
        if (isDeplacementSpePilote()) {
            while (i != 36) {       // tant que l'on a pas parcouru tout 
                getTuileAtteignable().add(g.getTuiles().get(i)); // que l'on est pas à la tuile de l'aventurier
                System.out.println(i);
                i++;
            }                                                      // on ajout aux tuiles atteingables
        } else {
            casePossiblebasique(g, this.getTuileAtteignable()); //rentre les déplacements propre à tout les roles
        }
        filtrageDeplacementpossible(getTuileAtteignable(), g); //filtrage null+innondé+immergé+case du joueur 
    }

    /**
     * @return the deplacementSpePilote
     */
    @Override
    public boolean isDeplacementSpePilote() {
        return deplacementSpePilote;
    }

    /**
     * @param deplacementSpePilote the deplacementSpePilote to set
     */
    @Override
    public void setDeplacementSpePilote(boolean deplacementSpePilote) {
        this.deplacementSpePilote = deplacementSpePilote;
    }

}
