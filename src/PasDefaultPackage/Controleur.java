package PasDefaultPackage;

import java.awt.Color;
import java.util.*;
import view.VueAventurier;
import view.VueInscription;

public class Controleur implements Observateur {
    private VueAventurier vueAventurier;
    private Aventurier aventurier;
    
    
    
    private static Grille grille;
    private Collection<Aventurier> aventuriers;
    private TasCartesTrésor cartesTresor;
    private TasCartesInnondation cartesInnondation;
    private static boolean finPartie;
    private static Aventurier joueurCourant;

    
    public Controleur() {
        //initialisation partie
        /*
        creer une autre vue
         */
        grille = new Grille();
        //lancement partie
        finPartie = false;
        //window.setVisible(true);
        VueInscription window = new VueInscription();
        window.afficher();
        
      //  System.out.println("Pomme");
//       
/*
        if (!finPartie) {

            grille.getJoueurCourant().setNbPA(window.getNbmaxPa());
            int i = 1;

            while (i <= grille.getnbJ()) {
                int nbpaPast = 2;
                if (grille.getJoueurCourant().getNbPA() != nbpaPast) {
                    window.peinture(grille, grille.getJoueurCourant(), Color.blue, finPartie);
                }

            }

        } else {
            System.out.println("fin Partie!");
        }

     */
}
    @Override
    public void traiterMessage(Message msg) {
    }

    /**
     *
     * @param a
     */
    public void jouerTour(Aventurier a) {
        // TODO - implement Contrôleur.jouerTour

    }

    /**
     *
     * @param a
     */
    public void realiserAction(Aventurier a) {
        // TODO - implement Contrôleur.realiserAction

    }

    public void monterEchelleEau() {
        // TODO - implement Contrôleur.monterEchelleEau

    }

    /**
     *
     * @param aventurier
     * @param carte
     */
    public void defausserCarteTresorJoueur(Aventurier aventurier, Ctrésor carte) {
        // TODO - implement Contrôleur.defausserCarteTresorJoueur

    }

    /**
     *
     * @param aventurier
     * @param carteS
     */
    public void utiliserCarteSpeciale(Aventurier aventurier, CSpéciale carteS) {
        // TODO - implement Contrôleur.utiliserCarteSpeciale

    }

    /**
     * @return the grille
     */
    public Grille getGrille() {
        return grille;
    }

    public void debutPartie() {

    
    }
}
