package PasDefaultPackage;

import static PasDefaultPackage.TypeRole.Explorateur;
import static PasDefaultPackage.TypeRole.Ingénieur;
import static PasDefaultPackage.TypeRole.Messager;
import static PasDefaultPackage.TypeRole.Navigateur;
import static PasDefaultPackage.TypeRole.Pilote;
import static PasDefaultPackage.TypeRole.Plongeur;
import java.util.ArrayList;
import java.util.HashMap;

public class Grille {

    private int nbcolonne;
    private int nbligne;
    private ArrayList<Tuile> tuiles;
    private HashMap<Integer, Aventurier> joueurs;
    private Aventurier joueurCourant;
    

    public Grille() {
        this.nbligne = 6;
        this.nbcolonne = 6;
        tuiles = new ArrayList<>();
        joueurs = new HashMap<>();

        Tuile t1 = new Tuile(0, "", 1, 1);
        t1.setEtat(Etat.vide);
        Tuile t2 = new Tuile(0, "", 2, 1);
        t2.setEtat(Etat.vide);
        Tuile t3 = new Tuile(0, "Le Pont Des Abimes", 3, 1);
        t3.setEtat(Etat.innondé);
        Tuile t4 = new Tuile(0, "La porte De Bronze", 4, 1);
        Tuile t5 = new Tuile(0, "", 5, 1);
        t5.setEtat(Etat.vide);
        Tuile t6 = new Tuile(0, "", 6, 1);
        t6.setEtat(Etat.vide);
        Tuile t7 = new Tuile(0, "", 1, 2);
        t7.setEtat(Etat.vide);
        Tuile t8 = new Tuile(0, "La Caverne Des Ombres", 2, 2);
        t8.setFigure(TypeFigurine.le_Cristal_Ardent);
        Tuile t9 = new Tuile(0, "La porte De Fer", 3, 2);
        Tuile t10 = new Tuile(0, "La porte D'or", 4, 2);
        t10.setEtat(Etat.innondé);
        Tuile t11 = new Tuile(0, "Les Falaises De L'Oubli", 5, 2);
        Tuile t12 = new Tuile(0, "", 6, 2);
        t12.setEtat(Etat.vide);
        Tuile t13 = new Tuile(0, "Le Palais De Corail", 1, 3);
        t13.setFigure(TypeFigurine.le_Calice_de_londe);
        Tuile t14 = new Tuile(0, "La porte D'Argent", 2, 3);
        Tuile t15 = new Tuile(0, "Les Dunes De L'Illusion", 3, 3);
        t15.setEtat(Etat.immergé);
        Tuile t16 = new Tuile(0, "Héliport", 4, 3);
        Tuile t17 = new Tuile(0, "La Porte De Cuivre", 5, 3);
        Tuile t18 = new Tuile(0, "Le Jardin des Hurlements", 6, 3);
        t18.setFigure(TypeFigurine.la_Statue_du_Zéphyr);
        Tuile t19 = new Tuile(0, "La Foret Pourpre", 1, 4);
        Tuile t20 = new Tuile(0, "Le Lagon Perdu", 2, 4);
        t20.setEtat(Etat.innondé);
        Tuile t21 = new Tuile(0, "Le Marais Brumeux", 3, 4);
        t21.setEtat(Etat.immergé);
        Tuile t22 = new Tuile(0, "Observatoire", 4, 4);
        t22.setEtat(Etat.innondé);
        Tuile t23 = new Tuile(0, "Le Rocher Fantôme", 5, 4);
        t23.setEtat(Etat.immergé);
        Tuile t24 = new Tuile(0, "La Caserne Du Brasier", 6, 4);
        t24.setFigure(TypeFigurine.le_Cristal_Ardent);
        t24.setEtat(Etat.innondé);
        Tuile t25 = new Tuile(0, "", 1, 5);
        t25.setEtat(Etat.vide);
        Tuile t26 = new Tuile(0, "Le Temple Du Soleil", 2, 5);
        Tuile t27 = new Tuile(0, "Le Temple De La Lune", 3, 5);
        t26.setFigure(TypeFigurine.la_Pierre_sacrée);
        t27.setEtat(Etat.immergé);
        t27.setFigure(TypeFigurine.la_Pierre_sacrée);
        Tuile t28 = new Tuile(0, "Le Palais Des Marées", 4, 5);
        t28.setFigure(TypeFigurine.le_Calice_de_londe);
        Tuile t29 = new Tuile(0, "Le Val Du Crépuscule", 5, 5);
        Tuile t30 = new Tuile(0, "", 6, 5);
        Tuile t31 = new Tuile(0, "", 1, 6);
        Tuile t32 = new Tuile(0, "", 2, 6);
        Tuile t33 = new Tuile(0, "La Tour Du Guet", 3, 6);
        Tuile t34 = new Tuile(0, "Le Jardin Des Murmures", 4, 6);
        t34.setFigure(TypeFigurine.la_Statue_du_Zéphyr);
        t34.setEtat(Etat.innondé);
        Tuile t35 = new Tuile(0, "", 5, 6);
        Tuile t36 = new Tuile(0, "", 6, 6);
        t30.setEtat(Etat.vide);
        t31.setEtat(Etat.vide);
        t32.setEtat(Etat.vide);
        t35.setEtat(Etat.vide);
        t36.setEtat(Etat.vide);

        this.getTuiles().add(t1);
        this.getTuiles().add(t2);
        this.getTuiles().add(t3);
        this.getTuiles().add(t4);
        this.getTuiles().add(t5);
        this.getTuiles().add(t6);
        this.getTuiles().add(t7);
        this.getTuiles().add(t8);
        this.getTuiles().add(t9);
        this.getTuiles().add(t10);
        this.getTuiles().add(t11);
        this.getTuiles().add(t12);
        this.getTuiles().add(t13);
        this.getTuiles().add(t14);
        this.getTuiles().add(t15);
        this.getTuiles().add(t16);
        this.getTuiles().add(t17);
        this.getTuiles().add(t18);
        this.getTuiles().add(t19);
        this.getTuiles().add(t20);
        this.getTuiles().add(t21);
        this.getTuiles().add(t22);
        this.getTuiles().add(t23);
        this.getTuiles().add(t24);
        this.getTuiles().add(t25);
        this.getTuiles().add(t26);
        this.getTuiles().add(t27);
        this.getTuiles().add(t28);
        this.getTuiles().add(t29);
        this.getTuiles().add(t30);
        this.getTuiles().add(t31);
        this.getTuiles().add(t32);
        this.getTuiles().add(t33);
        this.getTuiles().add(t34);
        this.getTuiles().add(t35);
        this.getTuiles().add(t36); 

     /*   Aventurier av1 = new Ingenieur("le Prof", Ingénieur, 0, this.getTuiles().get(3), null);//correspond à t4
        Aventurier av2 = new Plongeur("Thibaud", Plongeur, 0, this.getTuiles().get(8), null);//correspond à t9
        Aventurier av3 = new Navigateur("Alexis", Navigateur, 0, this.getTuiles().get(9), null);//correspond à t10
        Aventurier av4 = new Messager("Mathilde", Messager, 0, this.getTuiles().get(13), null);//correspond à t14
        Aventurier av5 = new Pilote("ami", Pilote, 0, this.getTuiles().get(15), null);//correspond à t16
        Aventurier av6 = new Explorateur("l'autre Prof", Explorateur, 0, this.getTuiles().get(16), null);//correspond à t17
        joueurs.put(1, av1);
        joueurs.put(2, av2);
        joueurs.put(3, av5);
        // joueurs.put(3, av5);
        joueurs.put(4, av6);
        //
*/
    }

    /**
     * @return the tuiles
     */
    public ArrayList<Tuile> getTuiles() {
        return tuiles;
    }

    public Tuile getLaTuile(int x, int y) {
        int i = 0;
        while (i != 36) {
            if (x == getTuiles().get(i).getX(i) && y == getTuiles().get(i).getY(i)) {
                return (getTuiles().get(i));
            } else {
                i++;

            }
        }
        return null;
    }

    /**
     * @param tuiles the tuiles to set
     */
    public void setTuiles(ArrayList<Tuile> tuiles) {
        this.tuiles = tuiles;
    }

    public int getnbJ() {
        return getJoueurs().size();
    }

    /**
     * @return the joueurs
     */
    public HashMap<Integer, Aventurier> getJoueurs() {
        return joueurs;
    }

    /**
     * @return the joueurCourant
     */
    public Aventurier getJoueurCourant() {
        return joueurCourant;
    }

    /**
     * @param joueurCourant the joueurCourant to set
     */
    public void setJoueurCourant(Aventurier joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    public int getRang(HashMap<Integer, Aventurier> h, Aventurier a) {
        for (int i = 0; i < h.size(); i++) {
            if (h.get(i) == a) {
                return i;
            }
        }
        return 0;
    }
}
