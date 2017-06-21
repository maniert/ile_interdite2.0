package PasDefaultPackage;

public class Explorateur extends Aventurier {

    public Explorateur(String nomJoueur, TypeRole typeRole, int idaventurier, Tuile t) {
        super(nomJoueur, typeRole, idaventurier, t);
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

    @Override
    public void setTuileAssechable(Grille g) { //ajout des diagonals qui peuvent être asséché
        int i = 0;
        int xPerso;
        int yPerso;
        xPerso = this.getTuile().getX();//récupére les coordonnées
        yPerso = this.getTuile().getY();//x et y du joueur de ce tour
        getTuileAssechable().clear(); // clear vide le vecteur
        casePossiblebasique(g, this.getTuileAssechable());
        getTuileAssechable().add(g.getLaTuile(xPerso - 1, yPerso - 1));//HG
        getTuileAssechable().add(g.getLaTuile(xPerso + 1, yPerso - 1));//HD
        getTuileAssechable().add(g.getLaTuile(xPerso - 1, yPerso + 1));//BG
        getTuileAssechable().add(g.getLaTuile(xPerso + 1, yPerso + 1));//BD
        filtrageTuileAssechable(getTuileAssechable(), g);
    }

}
