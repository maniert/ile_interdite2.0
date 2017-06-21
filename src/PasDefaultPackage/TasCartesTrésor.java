package PasDefaultPackage;

import java.util.*;

public class TasCartesTrésor {

    private ArrayList<CFigurine> cartesFigurineEnJeu;
    private ArrayList<CSpéciale> cartesSpecialesEnJeu;
    private ArrayList<CMonteeDesEaux> cartesMonteeDesEauxEnJeu;
    private ArrayList<CFigurine> cartesFigurineDefausse;
    private ArrayList<CSpéciale> cartesSpecialesDefausse;
    private ArrayList<CMonteeDesEaux> cartesMonteeDesEauxEnJeuDefausse;

    private ArrayList<Carte> cartesTresorEnJeu;
    private ArrayList<Carte> cartesTresorDefausse;

    public TasCartesTrésor() {
        cartesFigurineEnJeu = new ArrayList<>();
        cartesSpecialesEnJeu = new ArrayList<>();
        cartesMonteeDesEauxEnJeu = new ArrayList<>(); 
        cartesFigurineDefausse = new ArrayList<>();
        cartesSpecialesDefausse = new ArrayList<>();
        cartesMonteeDesEauxEnJeuDefausse = new ArrayList<>();
        
        
        cartesTresorEnJeu = new ArrayList<>();
        cartesTresorDefausse = new ArrayList<>();
        
        Carte cf1 = new CFigurine(0, "", TypeFigurine.vide);
        
        Carte cs1 = new CSpéciale(0, "", TypeSpeciale.sacDeSable);
        
        
        
        
        
        
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
