package PasDefaultPackage;

import java.util.ArrayList;

public class Ingenieur extends Aventurier {

    private ArrayList<Integer> assechInge;
    private int ingeasseche;

    public Ingenieur(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(nomJoueur, typeRole, idaventurier, t, main);
        assechInge = new ArrayList<>();
    }

    public void assecherInge(Grille grille) {
        for (int i = 0; i <= grille.getTuiles().size() - 1; i++) {
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
     * @return the ingeasseche
     */
    public int getIngeasseche() {
        return ingeasseche;
    }

    /**
     * @param ingeasseche the ingeasseche to set
     */
    public void setIngeasseche(int ingeasseche) {
        this.ingeasseche = ingeasseche;
    }

}
