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
        while (i < getTuileAtteignable().size()) {
            if(getTuileAtteignable().get(i).getEtat() == Etat.innondé || getTuileAtteignable().get(i).getEtat() == Etat.immergé){
                getTuilessouslocean().add(getTuileAtteignable().get(i));
            }
            i++;
            int k = 0;
                System.out.println("cc");
            while (k < getTuilessouslocean().size() ){
            int j = 0;
                while ((j < tuilesAutour(sec, getTuilessouslocean().get(k), grille).size()) || (j < tuilesAutour(innondé, getTuilessouslocean().get(k), grille).size()) || (j < tuilesAutour(immergé, getTuilessouslocean().get(k), grille).size())) {
                    if (existedéjà(getTuileAtteignable(), tuilesAutour(sec, getTuilessouslocean().get(k), grille).get(j))) {
                        getTuileAtteignable().add(getTuilessouslocean().get(k));
                    } else if (existedéjà(getTuilessouslocean(), tuilesAutour(innondé, getTuilessouslocean().get(k), grille).get(j))) {
                        getTuilessouslocean().add(getTuilessouslocean().get(k));
                     } else if (existedéjà(getTuilessouslocean(), tuilesAutour(immergé, getTuilessouslocean().get(k), grille).get(j))) {
                        getTuilessouslocean().add(getTuilessouslocean().get( k));
                    }
                }
                
               filtrageDeplacementPlongeur(getTuileAtteignable(), grille); //filtrage null+innondé,immergé
            }
        }
        
        /*int i = 0;
        ArrayList<Tuile> mem = null;
        while (i < this.getTuileAtteignable().size()) {
            System.out.println("abricot");
            if (this.getTuileAtteignable().get(i).getEtat() == innondé || this.getTuileAtteignable().get(i).getEtat() == immergé) {//ajout la tuile numéro i a tuilesouslocean
                this.tuilessouslocean.add(this.getTuileAtteignable().get(i));//si elle sont immergé ou innondé
                System.out.println("framboise");
                System.out.println(this.tuilessouslocean.size());
                i++;
            } else {
                i++;
            }
            while (this.tuilessouslocean != mem) {
             
                System.out.println("fraise");
                System.out.println(this.tuilessouslocean.size());
                for (int j = 0; j < this.tuilessouslocean.size(); j++) {
                    System.out.println("poire");
                    for (int k = 0; k < this.tuilesAutour(sec, this.tuilessouslocean.get(j), g).size(); k++) {
                        System.out.println("pèche");
                        if (!existedéjà(this.getTuileAtteignable(), this.tuilesAutour(sec, this.tuilessouslocean.get(j), g).get(k))) {
                            this.getTuileAtteignable().add(this.tuilesAutour(sec, this.tuilessouslocean.get(j), g).get(k));
                        } else if (!existedéjà(this.tuilessouslocean, this.tuilesAutour(innondé, this.tuilessouslocean.get(j), g).get(k))) {
                            this.tuilessouslocean.add(this.tuilesAutour(innondé, this.tuilessouslocean.get(j), g).get(k));
                        } else if (!existedéjà(this.tuilessouslocean, this.tuilesAutour(immergé, this.tuilessouslocean.get(j), g).get(k))) {
                            this.tuilessouslocean.add(this.tuilesAutour(immergé, this.tuilessouslocean.get(j), g).get(k));
                        }
                    }
                }
            }

        }
         */
    }

    public void filtrageDeplacementPlongeur(ArrayList<Tuile> tuileAtteignable, Grille g) {
        int i = 0;
        while (i != this.getTuileAtteignable().size()) {
            if (this.getTuileAtteignable().get(i).getEtat() == Etat.vide || this.getTuileAtteignable().get(i) == this.getTuile()) {
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
            at.add(g.getLaTuile(x, y -1));
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
