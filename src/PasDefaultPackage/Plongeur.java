package PasDefaultPackage;

import java.util.ArrayList;

public class Plongeur extends Aventurier {

    public Plongeur(TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(typeRole, idaventurier, t, main);
    }

    @Override
    public ArrayList<Tuile> getTuileAtteignable(Grille g) {
        int xPerso;
        int yPerso;
        getTuileAtteignable(g).clear();// vider l'arraylist avant de le remplir
        xPerso = this.getTuile().getX();//récupére les coordonnées
        yPerso = this.getTuile().getY();//x et y du joueur de ce tour
        deplacementPossiblebasique(g); //rentre les déplacements propre à tout les roles  
        getTuileAtteignable(g).add(g.getLaTuile(xPerso - 1, yPerso - 1));//HG
        getTuileAtteignable(g).add(g.getLaTuile(xPerso + 1, yPerso - 1));//HD
        getTuileAtteignable(g).add(g.getLaTuile(xPerso - 1, yPerso + 1));//BG
        getTuileAtteignable(g).add(g.getLaTuile(xPerso + 1, yPerso + 1));//BD
        int i = 0;
        while (i != this.getTuileAtteignable(g).size() + 1) {
            if (this.getTuileAtteignable(g).get(i) == null) {
                this.getTuileAtteignable(g).remove(this.getTuileAtteignable(g).get(i));
            } else {
                i++;
            }
        }
        return tuilesAtteignable;
    }
}
