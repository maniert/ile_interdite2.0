package PasDefaultPackage;

import static PasDefaultPackage.Etat.immergé;
import static PasDefaultPackage.Etat.innondé;
import static PasDefaultPackage.Etat.sec;
import static PasDefaultPackage.Etat.vide;

public class TasCartesInnondation extends TasCartes {

    public TasCartesInnondation(Grille g) {
        for (int i = 0; i < 35; i++) {
            if (g.getTuiles().get(i).getEtat() != vide) {
                getCartesEnJeu().add(new CInnondation(i, g.getTuiles().get(i).getNomTuile(), t, img);
                getCartesEnJeu().add(new CInnondation(i, g.getTuiles().get(i).getNomTuile(), g.getTuiles().get(i), g.getTuiles().get(i).getImg());
            }
        }

        /*
        Carte c3 = new CInnondation(0, g.getTuiles().get(3).getNomTuile(), g.getTuiles().get(3));
        Carte c4 = new CInnondation(0, "La Porte De Bronze", g.getTuiles().get(4));
        Carte c8 = new CInnondation(0, "La Caverne Des Ombres", g.getTuiles().get(8));
        Carte c9 = new CInnondation(0, "La Porte De Fer", g.getTuiles().get(9));
        Carte c10 = new CInnondation(0, "La Porte D'Or ", g.getTuiles().get(10));
        Carte c11 = new CInnondation(0, "Les Falaises De L'Oubli", g.getTuiles().get(11));
        Carte c13 = new CInnondation(0, "Le Palais De Corail", g.getTuiles().get(13));
        Carte c14 = new CInnondation(0, "La Porte D'Argent", g.getTuiles().get(14));
        Carte c15 = new CInnondation(0, "Les Dunes De L'Illusion", g.getTuiles().get(15));
        Carte c16 = new CInnondation(0, "Héliport", g.getTuiles().get(16));
        Carte c17 = new CInnondation(0, "La Porte De Cuivre", g.getTuiles().get(17));
        Carte c18 = new CInnondation(0, "Le Jardin Des Hurelements", g.getTuiles().get(18));
        Carte c19 = new CInnondation(0, "La Forêt Pourpre", g.getTuiles().get(19));
        Carte c21 = new CInnondation(0, "Le Lagon Perdu", g.getTuiles().get(21));
        Carte c22 = new CInnondation(0, "Le Marais Brumeux", g.getTuiles().get(22));
        Carte c23 = new CInnondation(0, "Observatoire", g.getTuiles().get(23));
        Carte c24 = new CInnondation(0, "Le Rocher Fantôme", g.getTuiles().get(24));
        Carte c25 = new CInnondation(0, "La Caserne Du Brasier", g.getTuiles().get(25));
        Carte c26 = new CInnondation(0, "Le Temple Du Soleil", g.getTuiles().get(26));
        Carte c27 = new CInnondation(0, "Le Temple De La Lune", g.getTuiles().get(27));
        Carte c28 = new CInnondation(0, "Le Palais Des Marées", g.getTuiles().get(28));
        Carte c29 = new CInnondation(0, "Le Val Du Crepuscule", g.getTuiles().get(29));
        Carte c33 = new CInnondation(0, "La Tour Du Guet", g.getTuiles().get(33));
        Carte c34 = new CInnondation(0, "Le Jardin Des Murmures", g.getTuiles().get(34));
         */
    }

    public void removeCarte(Carte c) {
        getCartesEnJeu().remove(c);
    }

    

    public void deplacerCartesDefausseVersCartesEnJeu() {
        while (getCartesDefausse().size() != 0) {
            getCartesEnJeu().add(getCartesDefausse().get(0));
            getCartesDefausse().remove(0);
        }
    }
}
