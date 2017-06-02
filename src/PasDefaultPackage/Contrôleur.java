package PasDefaultPackage;

import static PasDefaultPackage.TypeRole.explorateur;
import static PasDefaultPackage.TypeRole.pilote;
import static PasDefaultPackage.TypeRole.plongeur;
import java.util.*;
import view.VueAventurier;

public class Contrôleur {

    private Grille grille;
    private Collection<Aventurier> aventuriers;
    private TasCartesTrésor cartesTresor;
    private TasCartesInnondation cartesInnondation;

    public static void main(String[] args) {

        Tuile t = new Tuile(0, "Le Pont Des Abimes", 3, 1);

        Aventurier av1 = new Aventurier("Thibaud", explorateur, 0, t, null);
        Aventurier av2 = new Aventurier("Alexis", pilote, 1, t, null);
        Aventurier av3 = new Aventurier("Mathilde", plongeur, 2, t, null);
        Aventurier av4 = new Aventurier("Thibaud", explorateur, 3, t, null);
        VueAventurier window;
        //window = new VueAventurier(av4, Color.blue, grille);

    }

    /**
     *
     * @param a
     */
    public void jouerTour(Aventurier a) {
        // TODO - implement Contrôleur.jouerTour
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param a
     */
    public void realiserAction(Aventurier a) {
        // TODO - implement Contrôleur.realiserAction
        throw new UnsupportedOperationException();
    }

    public void monterEchelleEau() {
        // TODO - implement Contrôleur.monterEchelleEau
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param aventurier
     * @param carte
     */
    public void defausserCarteTresorJoueur(Aventurier aventurier, Ctrésor carte) {
        // TODO - implement Contrôleur.defausserCarteTresorJoueur
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param aventurier
     * @param carteS
     */
    public void utiliserCarteSpeciale(Aventurier aventurier, CSpéciale carteS) {
        // TODO - implement Contrôleur.utiliserCarteSpeciale
        throw new UnsupportedOperationException();
    }

    public void DemandeDeplacement(Aventurier a) {//tuile de destination + aventurier concerné
        boolean enAttenteDAppuie = true;

        a.getTuileAtteignable();
        /*AFFICHAGE MATHILDE*/
 /*debut loop EN ATTENTE DE detection click sur bouton possible
                     attente d'appuie sur une tuile valide   */
        Tuile tDest = null;/*récupérer tuile au click
          fin loop*/
        Deplacement(tDest, a);
    }

    public void Deplacement(Tuile tDest, Aventurier a) {
        a.getTuile().getAventuriers().remove(a);
        a.setT(tDest);
        tDest.getAventuriers().add(a);
    }
    
    public void Demandeassecher(Aventurier a) {//tuile de destination + aventurier concerné
        boolean enAttenteDAppuie = true;
        a.getTuileAssechable();
        /*AFFICHAGE MATHILDE*/
 /*debut loop EN ATTENTE DE detection click sur bouton possible
                     attente d'appuie sur une tuile valide   */
        Tuile tDest = null;/*récupérer tuile au click
          fin loop*/
        Deplacement(tDest, a);
    }
    
    public void assecher(Tuile tDest, Aventurier a) {
	a.getTuile().getAventuriers().remove(a);
        a.setT(tDest);
        tDest.getAventuriers().add(a);	
		
    }

    /**
     * @return the grille
     */
    public Grille getGrille() {
        return grille;
    }

}
