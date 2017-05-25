
import java.util.*;

public class Contrôleur {

    Grille grille;
    Collection<Aventurier> aventuriers;
    TasCartesTrésor cartesTresorEnJeu;
    Collection<TasCartesTrésor> cartesTresor;
    Collection<TasCartesInnondation> cartesInnondation;
    Collection<TasCartesInnondation> cartesInnondationsHorsjeu;
    private ArrayList<Tuile> caseAtteignable;
    
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
     * @param a
     */
    public void seDeplacer(Aventurier a) {
        // TODO - implement Contrôleur.seDeplacer
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
    
    public void DeplacementPossible() {
		// TODO - implement Aventurier.DeplacementPossible
		throw new UnsupportedOperationException();
	}
    
    public void deplacementbasique(Aventurier a){
        int xPerso;
        int yPerso;
        xPerso = a.getTuile().getX();
        yPerso = a.getTuile().getY();
        
    }
    
    public ArrayList<Tuile> getCaseAtteignable() {
        return caseAtteignable;
    }
        
}
