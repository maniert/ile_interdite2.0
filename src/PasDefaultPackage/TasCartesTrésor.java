package PasDefaultPackage;

import java.util.*;

public class TasCartesTrésor {

    /* private ArrayList<CFigurine> cartesFigurineEnJeu;
    private ArrayList<CSpéciale> cartesSpecialesEnJeu;
    private ArrayList<CMonteeDesEaux> cartesMonteeDesEauxEnJeu;
    private ArrayList<CFigurine> cartesFigurineDefausse;
    private ArrayList<CSpéciale> cartesSpecialesDefausse;
    private ArrayList<CMonteeDesEaux> cartesMonteeDesEauxEnJeuDefausse;*/
    private ArrayList<Carte> cartesTresorEnJeu;
    private ArrayList<Carte> cartesTresorDefausse;
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

        cartesTresorEnJeu = new ArrayList<>();
        cartesTresorDefausse = new ArrayList<>();

        Carte cfps = new CFigurine(0, "", TypeFigurine.la_Pierre_sacrée);
        Carte cfsz = new CFigurine(0, "", TypeFigurine.la_Statue_du_Zéphyr);
        Carte cfcl = new CFigurine(0, "", TypeFigurine.le_Calice_de_londe);
        Carte cfca = new CFigurine(0, "", TypeFigurine.le_Cristal_Ardent);
        Carte cs = new CSpéciale(0, "", TypeSpeciale.sacDeSable);
        Carte ch = new CSpéciale(0, "", TypeSpeciale.helicoptere);
        Carte cmde = new CMonteeDesEaux(nbcMde, "");

        for (int i = 0; i < nbcFigurine; i++) {
            cartesTresorEnJeu.add(cfps);
            cartesTresorEnJeu.add(cfsz);
            cartesTresorEnJeu.add(cfcl);
            cartesTresorEnJeu.add(cfca);
        }
        for (int i = 0; i < nbcSds; i++) {
            cartesTresorEnJeu.add(cs);
        }
        for (int j = 0; j < nbchulucupter; j++) {
            cartesTresorEnJeu.add(ch);
        }

        for (int i = 0; i < nbcMde; i++) {
            cartesTresorEnJeu.add(cmde);
        }

    }

    public void tirerCarte() {
    }

    /**
     *
     * @param t
     */
    public void defausserCarte(Carte c) {
    }

    /**
     *
     * @param t
     */
    public void removeCarte(Carte c) {
    }

    public void melangerCarteTresorDefausse() {
    }

    public void deplacerCartesDefausseVersCartesEnJeu() {
    }

}
