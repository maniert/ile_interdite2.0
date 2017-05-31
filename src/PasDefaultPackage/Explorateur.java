package PasDefaultPackage;

import java.util.ArrayList;

public class Explorateur extends Aventurier{
    
    public Explorateur(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(nomJoueur, typeRole, idaventurier, t, main);
    }
    
    
    public void setTuileAtteignable(Grille g) {
    int xPerso;
    int yPerso;
    getTuileAtteignable(g).clear();// vider l'arraylist avant de le remplir
    xPerso = this.getTuile().getX();//récupére les coordonnées
    yPerso = this.getTuile().getY();//x et y du joueur de ce tour
    deplacementPossiblebasique(g); //rentre les déplacements propre à tout les roles  
    getTuileAtteignable(g).add(g.getLaTuile(xPerso - 1, yPerso - 1));//HG
    getTuileAtteignable(g).add(g.getLaTuile(xPerso + 1, yPerso - 1));//HD
    getTuileAtteignable(g).add(g.getLaTuile(xPerso - 1, yPerso + 1));//BG
    getTuileAtteignable(g).add(g.getLaTuile(xPerso + 1, yPerso + 1));//BD 
    filtrageDeplacementpossible(getTuileAtteignable(g), g); //filtrage null+innondé,immergé 
        
    }
    
    
    
}
    