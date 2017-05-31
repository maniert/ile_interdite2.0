package PasDefaultPackage;

import java.util.ArrayList;

public class Messager extends Aventurier{
    
    public Messager(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(nomJoueur, typeRole, idaventurier, t, main);
    }
    
    public void setTuileAtteignable(Grille g) {
    getTuileAtteignable(g).clear();// vider l'arraylist avant de le remplir
    deplacementPossiblebasique(g); //rentre les déplacements propre à tout les roles
    filtrageDeplacementpossible(getTuileAtteignable(g), g); //filtrage null+innondé,immergé   
    }
    
    
    
    
}