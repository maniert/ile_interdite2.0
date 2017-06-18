package PasDefaultPackage;

import static PasDefaultPackage.TypeRole.explorateur;
import static PasDefaultPackage.TypeRole.ingénieur;
import static PasDefaultPackage.TypeRole.messager;
import static PasDefaultPackage.TypeRole.navigateur;
import static PasDefaultPackage.TypeRole.pilote;
import static PasDefaultPackage.TypeRole.plongeur;
import java.awt.Color;
import java.util.*;
import view.VueAventurier;

public class Contrôleur {

    private static Grille grille;
    private Collection<Aventurier> aventuriers;
    private TasCartesTrésor cartesTresor;
    private TasCartesInnondation cartesInnondation;
    private static boolean finPartie;
    
    public static void main(String[] args) {
        //initialisation partie
        /*
        creer une autre vue
        */
        grille = new Grille();
        //lancement partie
        finPartie = false;
        
        

       
        

        //window.setVisible(true);
        
        if(!finPartie){
             VueAventurier window = new VueAventurier(grille, grille.getTuiles().get(3).getAventuriers().get(0), Color.blue);
                          
        } else {
            System.out.println("fin Partie!");
        }
        
        
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
    
    
    
    public void debutPartie(){
        
    }

}
