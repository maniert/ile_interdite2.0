package PasDefaultPackage;

import java.util.ArrayList;

public class Explorateur extends Aventurier {

    public Explorateur(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t, ArrayList<Carte> main) {
        super(nomJoueur, typeRole, idaventurier, t, main);
    }

    public void setTuileAtteignable(Grille g) {
        int xPerso;
        int yPerso;
        getTuileAtteignable().clear();// vider l'arraylist avant de le remplir
        xPerso = this.getTuile().getX();//récupére les coordonnées
        yPerso = this.getTuile().getY();//x et y du joueur de ce tour
        casePossiblebasique(g, this.getTuileAtteignable()); //rentre les déplacements propre à tout les roles  
        getTuileAtteignable().add(g.getLaTuile(xPerso - 1, yPerso - 1));//HG
        getTuileAtteignable().add(g.getLaTuile(xPerso + 1, yPerso - 1));//HD
        getTuileAtteignable().add(g.getLaTuile(xPerso - 1, yPerso + 1));//BG
        getTuileAtteignable().add(g.getLaTuile(xPerso + 1, yPerso + 1));//BD 
        filtrageDeplacementpossible(getTuileAtteignable(), g); //filtrage null+innondé,immergé 

    }

    public void setTuileAssechable(Grille g) { //ajout des diagonals qui peuvent être asséché
        int i = 0;
        int xPerso;
        int yPerso;
        xPerso = this.getTuile().getX();//récupére les coordonnées
        yPerso = this.getTuile().getY();//x et y du joueur de ce tour
        getTuileAssechable().clear(); // clear vide le vecteur
        casePossiblebasique(g, this.getTuileAssechable());
        getTuileAtteignable().add(g.getLaTuile(xPerso - 1, yPerso - 1));//HG
        getTuileAtteignable().add(g.getLaTuile(xPerso + 1, yPerso - 1));//HD
        getTuileAtteignable().add(g.getLaTuile(xPerso - 1, yPerso + 1));//BG
        getTuileAtteignable().add(g.getLaTuile(xPerso + 1, yPerso + 1));//BD
        filtrageTuileAssechable(getTuileAssechable(), g);
    }

}
