package PasDefaultPackage;

import static PasDefaultPackage.Etat.immergé;
import static PasDefaultPackage.Etat.innondé;
import static PasDefaultPackage.Etat.sec;
import java.util.ArrayList;

public class Plongeur extends Aventurier {

    private ArrayList<Tuile> tuilessouslocean;

    public Plongeur(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(nomJoueur, typeRole, idaventurier, t, main);
        this.tuilessouslocean = new ArrayList<>();
    }

    public void setTuileAtteignable(Grille g) {
        getTuileAtteignable().clear();// vider l'arraylist avant de le remplir
        deplacementPossiblebasique(g); //rentre les déplacements propre à tout les role
        int i = 0;
        ArrayList<Tuile> mem = null;
        while (i != this.getTuileAtteignable().size() + 1) {
            if (this.getTuileAtteignable().get(i).getEtat() == innondé || this.getTuileAtteignable().get(i).getEtat() == immergé) {
                this.getTuilessouslocean().add(this.getTuileAtteignable().get(i));
            } else {
                i++;
            }
            while (tuilessouslocean != mem) {
                mem = tuilessouslocean;
                for (int j = 0; j < this.tuilessouslocean.size(); j++) {
                    for (int k = 0; k < this.tuilesAutour(sec, this.tuilessouslocean.get(j), g).size(); k++) {
                        if (!existedéjà(this.getTuileAtteignable(), this.tuilesAutour(sec, this.tuilessouslocean.get(j), g).get(k))) {
                            this.getTuileAtteignable().add(this.tuilesAutour(sec, this.tuilessouslocean.get(j), g).get(k));
                        } else if (!existedéjà(tuilessouslocean, this.tuilesAutour(innondé, this.tuilessouslocean.get(j), g).get(k))) {
                            this.tuilessouslocean.add(this.tuilesAutour(innondé, this.tuilessouslocean.get(j), g).get(k));
                        } else if (!existedéjà(tuilessouslocean, this.tuilesAutour(immergé, this.tuilessouslocean.get(j), g).get(k))) {
                            this.tuilessouslocean.add(this.tuilesAutour(immergé, this.tuilessouslocean.get(j), g).get(k));
                        }
                    }
                }
            }

        }

        filtrageDeplacementPlongeur(getTuileAtteignable(), g); //filtrage null+innondé,immergé 
    }

    public void filtrageDeplacementPlongeur(ArrayList<Tuile> tuileAtteignable, Grille g) {
        int i = 0;
        while (i != this.getTuileAtteignable().size()) {
            if (this.getTuileAtteignable().get(i) == null || this.getTuileAtteignable().get(i) == this.getTuile()) {
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
        return tuilessouslocean;
    }

}
