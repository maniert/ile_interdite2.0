package PasDefaultPackage;

import static PasDefaultPackage.Etat.innondé;
import java.util.ArrayList;

public class Plongeur extends Aventurier {

    public Plongeur(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(nomJoueur, typeRole, idaventurier, t, main);
    }

    /**
     *
     * @param g
     * @return
     */
    @Override
    public ArrayList<Tuile> getTuileAtteignable(Grille g) {
        ArrayList<Tuile> tuilessouslocean;
        getTuileAtteignable(g).clear();// vider l'arraylist avant de le remplir
        deplacementPossiblebasique(g); //rentre les déplacements propre à tout les role
        int i = 0;
        while (i != this.getTuileAtteignable(g).size() + 1) {
            if (this.getTuileAtteignable(g).get(i).getEtat() == innondé) {
                this.getTuileAtteignable(g).add(this.getTuileAtteignable(g).get(i));
            } else {
                i++;
            }
        }

        filtrageDeplacementPlongeur(tuilesAtteignable, g); //filtrage null+innondé,immergé 
        return tuilesAtteignable;
    }

    public void filtrageDeplacementPlongeur(ArrayList<Tuile> tuileAtteignable, Grille g) {
        int i = 0;
        while (i != this.getTuileAtteignable(g).size() + 1) {
            if (this.getTuileAtteignable(g).get(i) == null) {
                this.getTuileAtteignable(g).remove(this.getTuileAtteignable(g).get(i));
            } else {
                i++;
            }
        }
    }
}
