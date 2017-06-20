package PasDefaultPackage;

import static PasDefaultPackage.Etat.immergé;
import static PasDefaultPackage.Etat.innondé;
import static PasDefaultPackage.Etat.sec;
import static PasDefaultPackage.Etat.vide;
import java.util.ArrayList;

public class Plongeur extends Aventurier {

    private ArrayList<Tuile> tuilessouslocean;

    public Plongeur(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(nomJoueur, typeRole, idaventurier, t, main);
        this.tuilessouslocean = new ArrayList<>();
    }

    /**
     *
     * @param grille
     */
    @Override
    public void setTuileAtteignable(Grille grille) {
        getTuilessouslocean().clear();
        getTuileAtteignable().clear();// vider l'arraylist avant de le remplir
        casePossiblebasique(grille, getTuileAtteignable()); //rentre les déplacements propre à tout les roles
        
        int i = 0;
        while (i < getTuileAtteignable().size()-1) {
            if (getTuileAtteignable().get(i).getEtat() == Etat.innondé || getTuileAtteignable().get(i).getEtat() == Etat.immergé) {
                getTuilessouslocean().add(getTuileAtteignable().get(i));
            }
                i++;
            }  
        
            ArrayList<Tuile> mem = new ArrayList<>();
                while (mem != this.getTuileAtteignable() ) {
                    mem = this.getTuileAtteignable();
                    int k = 0;
                    while (k <= getTuilessouslocean().size()-1) {
                    for (int j = 0; j <= tuilesAutour(sec, getTuilessouslocean().get(k), grille).size()-1; j++) {
                       System.out.println("sec");
                        if (!existedéjà(getTuileAtteignable(), tuilesAutour(sec, getTuilessouslocean().get(k), grille).get(j)) && existedéjà(grille.getTuiles(), this.tuilesAutour(sec, this.tuilessouslocean.get(k), grille).get(j))) {
                            getTuileAtteignable().add(this.tuilesAutour(sec, this.tuilessouslocean.get(k), grille).get(j));
                        } 
                    }
                    for (int j = 0; j <= tuilesAutour(innondé, getTuilessouslocean().get(k), grille).size()-1; j++) {
                        System.out.println("inondé");
                        if (!existedéjà(getTuilessouslocean(), tuilesAutour(innondé, getTuilessouslocean().get(k), grille).get(j))  && existedéjà(grille.getTuiles(), this.tuilesAutour(innondé, this.tuilessouslocean.get(k), grille).get(j))) {
                            getTuilessouslocean().add(this.tuilesAutour(innondé, this.tuilessouslocean.get(k), grille).get(j));
                        }
                    }
                    for (int j = 0; j <= tuilesAutour(immergé, getTuilessouslocean().get(k), grille).size()-1; j++) {
                        System.out.println("immergé");
                        if (!existedéjà(getTuilessouslocean(), tuilesAutour(immergé, getTuilessouslocean().get(k), grille).get(j)) && existedéjà(grille.getTuiles(), this.tuilesAutour(immergé, this.tuilessouslocean.get(k), grille).get(j))) {
                            getTuilessouslocean().add(this.tuilesAutour(immergé, this.tuilessouslocean.get(k), grille).get(j));
                        }
                    }
                    k++;
                }
                filtrageDeplacementPlongeur(getTuileAtteignable(), grille); //filtrage null+innondé,immergé
            }
        
    }

    public void filtrageDeplacementPlongeur(ArrayList<Tuile> tuileAtteignable, Grille g) {
        int i = 0;
        while (i != this.getTuileAtteignable().size()) {
            if (this.getTuileAtteignable().get(i).getEtat() == Etat.vide || this.getTuileAtteignable().get(i) == this.getTuile() || this.getTuileAtteignable().get(i).getEtat() == Etat.innondé || this.getTuileAtteignable().get(i).getEtat() == Etat.immergé){
                this.getTuileAtteignable().remove(this.getTuileAtteignable().get(i));
            } else {
                i++;
            }
        }
    }

    public ArrayList<Tuile> tuilesAutour(Etat e, Tuile t, Grille g) {
        int x, y;
        ArrayList<Tuile> at = null;
        x = t.getX();
        y = t.getY();
        if (g.getLaTuile(x, y - 1).getEtat() == e) {
            at.add(g.getLaTuile(x, y - 1));
        }

        if (g.getLaTuile(x, y + 1).getEtat() == e) {
            at.add(g.getLaTuile(x, y + 1));
        }

        if (g.getLaTuile(x - 1, y).getEtat() == e) {
            at.add(g.getLaTuile(x - 1, y));
        }

        if (g.getLaTuile(x + 1, y).getEtat() == e) {
            at.add(g.getLaTuile(x + 1, y));
        }
        return at;
    }

    public ArrayList<Tuile> getTuilessouslocean() {
        return this.tuilessouslocean;
    }

}
