package PasDefaultPackage;

import java.util.ArrayList;

public class Ingenieur extends Aventurier {

    private ArrayList<Integer> assechInge;
    private int nbTuileAssech;

    public Ingenieur(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t) {
        super(nomJoueur, typeRole, idaventurier, t);
        assechInge = new ArrayList<>();
    }

    /**
     *
     * @param grille
     */
    @Override
    public void assecherInge(Grille grille) {
        for (int i = 0; i <= grille.getJoueurCourant().getAssechInge().size() - 1; i++) {
            if (grille.getTuiles().get(i).getEtat() == Etat.selectionné) {
                grille.getTuiles().get(i).setEtat(Etat.sec);
            }
        }
        getTuileAssechable().clear();
    }

    @Override
    public ArrayList<Integer> getAssechInge() {
        return assechInge;
    }

    /**
     * @param assechInge the assechInge to set
     */
    @Override
    public void setAssechInge(ArrayList<Integer> assechInge) {
        this.assechInge = assechInge;
    }

    /**
     * @return the nbTuileAssech
     */
    @Override
    public int getNbTuileAssech() {
        return nbTuileAssech;
    }

    /**
     * @param ingeasseche the nbTuileAssech to set
     */
    @Override
    public void setNbTuileAssech(int ingeasseche) {
        this.nbTuileAssech = ingeasseche;
    }

}
