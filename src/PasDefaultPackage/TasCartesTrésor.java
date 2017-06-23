package PasDefaultPackage;

import java.util.*;
import javax.swing.ImageIcon;
import util.Parameters;

public class TasCartesTrésor extends TasCartes {

    /* private ArrayList<CFigurine> cartesFigurineEnJeu;
    private ArrayList<CSpéciale> cartesSpecialesEnJeu;
    private ArrayList<CMonteeDesEaux> cartesMonteeDesEauxEnJeu;
    private ArrayList<CFigurine> cartesFigurineDefausse;
    private ArrayList<CSpéciale> cartesSpecialesDefausse;
    private ArrayList<CMonteeDesEaux> cartesMonteeDesEauxEnJeuDefausse;*/
    private int nbcFigurine = 5; // nombre de carte figurine par type de figurine
    private int nbcMde = 3; //nombre de crte montées des eaux
    private int nbchulucupter = 3;
    private int nbcSds = 2;

    public TasCartesTrésor() {
        /* cartesFigurineEnJeu = new ArrayList<>();
        cartesSpecialesEnJeu = new ArrayList<>();
        cartesMonteeDesEauxEnJeu = new ArrayList<>();
        cartesFigurineDefausse = new ArrayList<>();
        cartesSpecialesDefausse = new ArrayList<>();
        cartesMonteeDesEauxEnJeuDefausse = new ArrayList<>();*/

        Carte cfps = new CFigurine(0, TypeCarte.la_Pierre_sacrée, new ImageIcon(Parameters.CARTES + "Pierre.png"));
        Carte cfsz = new CFigurine(0, TypeCarte.la_Statue_du_Zéphyr, new ImageIcon(Parameters.CARTES + "Zephyr.png"));
        Carte cfcl = new CFigurine(0, TypeCarte.le_Calice_de_londe, new ImageIcon(Parameters.CARTES + "Calice.png"));
        Carte cfca = new CFigurine(0, TypeCarte.le_Cristal_Ardent, new ImageIcon(Parameters.CARTES + "Cristal.png"));
        Carte cs = new CSpéciale(0, TypeCarte.sacDeSable, new ImageIcon(Parameters.CARTES + "SacsDeSable.png"));
        Carte ch = new CSpéciale(0, TypeCarte.helicoptere, new ImageIcon(Parameters.CARTES + "Helicoptere.png"));
        Carte cmde = new CMonteeDesEaux(0, TypeCarte.MonteesDesEaux, new ImageIcon(Parameters.CARTES + "MonteeDesEaux.png"));

        for (int i = 0; i < nbcFigurine; i++) {
            getCartesEnJeu().add(cfps);
            getCartesEnJeu().add(cfsz);
            getCartesEnJeu().add(cfcl);
            getCartesEnJeu().add(cfca);
        }
        for (int i = 0; i < nbcSds; i++) {
            getCartesEnJeu().add(cs);
        }
        for (int j = 0; j < nbchulucupter; j++) {
            getCartesEnJeu().add(ch);
        }

        for (int i = 0; i < nbcMde; i++) {
            getCartesEnJeu().add(cmde);
        }
        Collections.shuffle(getCartesEnJeu());
    }

    public void tirerCarteJoueurCourant(Grille grille) {
        grille.getJoueurCourant().getMain().add(getCartesEnJeu().get(0));
        getCartesEnJeu().remove(0);

    }
}
