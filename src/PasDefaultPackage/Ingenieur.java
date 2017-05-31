package PasDefaultPackage;

import java.util.ArrayList;

public class Ingenieur extends Aventurier{
    
    public Ingenieur(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(nomJoueur, typeRole, idaventurier, t, main);
    }
    
    public ArrayList<Tuile> getTuileAtteignable(Grille g) {
    int xPerso;
    int yPerso;
    getTuileAtteignable(g).clear();// vider l'arraylist avant de le remplir
    xPerso = this.getTuile().getX();//récupére les coordonnées
    yPerso = this.getTuile().getY();//x et y du joueur de ce tour
    deplacementPossiblebasique(g); //rentre les déplacements propre à tout les roles  
    filtrageDeplacementpossible(tuilesAtteignable, g); //filtrage null+innondé,immergé 
    return tuilesAtteignable;    
    }
    
    
    
    
}
