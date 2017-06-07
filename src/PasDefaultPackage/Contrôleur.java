package PasDefaultPackage;

import static PasDefaultPackage.TypeRole.explorateur;
import static PasDefaultPackage.TypeRole.ingénieur;
import static PasDefaultPackage.TypeRole.messager;
import static PasDefaultPackage.TypeRole.navigateur;
import static PasDefaultPackage.TypeRole.pilote;
import static PasDefaultPackage.TypeRole.plongeur;
import java.awt.Color;
import java.util.*;
import javax.swing.JButton;
import view.VueAventurier;

public class Contrôleur {

    private Grille grille;
    private Collection<Aventurier> aventuriers;
    private TasCartesTrésor cartesTresor;
    private TasCartesInnondation cartesInnondation;
    

    public static void main(String[] args) {
        Tuile t1 = new Tuile(0, "", 1, 1);
        Tuile t2 = new Tuile(0, "", 2, 1);
        Tuile t3 = new Tuile(0, "Le Pont Des Abimes", 3, 1);
        Tuile t4 = new Tuile(0, "La porte De Bronze", 4, 1);
        t4.setEtat(Etat.innondé);
        Tuile t5 = new Tuile(0, "", 5, 1);
        Tuile t6 = new Tuile(0, "", 6, 1);
        Tuile t7 = new Tuile(0, "", 1, 2);
        Tuile t8 = new Tuile(0, "La Caverne Des Ombres", 2, 2);
        Tuile t9 = new Tuile(0, "La porte De Fer", 3, 2);
        Tuile t10 = new Tuile(0, "La porte D'or", 4, 2);
        Tuile t11 = new Tuile(0, "Les Falaises De L'Oubli", 5, 2);
        Tuile t12 = new Tuile(0, "", 6, 2);
        Tuile t13 = new Tuile(0, "Le Palais De Corail", 1, 3);
        Tuile t14 = new Tuile(0, "La porte D'Argent", 2, 3);
        Tuile t15 = new Tuile(0, "Les Dunes De L'Illusion", 3, 3);
        t15.setEtat(Etat.immergé);
        Tuile t16 = new Tuile(0, "Héliport", 4, 3);
        Tuile t17 = new Tuile(0, "La Porte De Cuivre", 5, 3);
        Tuile t18 = new Tuile(0, "Le Jardin des Hurlements", 6, 3);
        Tuile t19 = new Tuile(0, "La Foret Pourpre", 1, 4);
        Tuile t20 = new Tuile(0, "Le Lagon Perdu", 2, 4);
        t20.setEtat(Etat.innondé);
        Tuile t21 = new Tuile(0, "Le Marais Brumeux", 3, 4);
        t21.setEtat(Etat.immergé);
        Tuile t22 = new Tuile(0, "Observatoire", 4, 4);
        t22.setEtat(Etat.innondé);
        Tuile t23 = new Tuile(0, "Le Rocher Fantôme", 5, 4);
        t23.setEtat(Etat.immergé);
        Tuile t24 = new Tuile(0, "La Caserne Du Brasier", 6, 4);
        t24.setEtat(Etat.innondé);
        Tuile t25 = new Tuile(0, "", 1, 5);
        Tuile t26 = new Tuile(0, "Le Temple Du Soleil", 2, 5);
        Tuile t27 = new Tuile(0, "Le Temple De La Lune", 3, 5);
        t27.setEtat(Etat.immergé);
        Tuile t28 = new Tuile(0, "Le Palais Des Marées", 4, 5);
        Tuile t29 = new Tuile(0, "Le Val Du Crépuscule", 5, 5);
        Tuile t30 = new Tuile(0, "", 6, 5);
        Tuile t31 = new Tuile(0, "", 1, 6);
        Tuile t32 = new Tuile(0, "", 2, 6);
        Tuile t33 = new Tuile(0, "La Tour Du Guet", 3, 6);
        Tuile t34 = new Tuile(0, "Le Jardin Des Murmures", 4, 6);
        t34.setEtat(Etat.innondé);
        Tuile t35 = new Tuile(0, "", 5, 6);
        Tuile t36 = new Tuile(0, "", 6, 6);

        Grille g = new Grille();

        g.getTuiles().add(t1);
        g.getTuiles().add(t2);
        g.getTuiles().add(t3);
        g.getTuiles().add(t4);
        g.getTuiles().add(t5);
        g.getTuiles().add(t6);
        g.getTuiles().add(t7);
        g.getTuiles().add(t8);
        g.getTuiles().add(t9);
        g.getTuiles().add(t10);
        g.getTuiles().add(t11);
        g.getTuiles().add(t12);
        g.getTuiles().add(t13);
        g.getTuiles().add(t14);
        g.getTuiles().add(t15);
        g.getTuiles().add(t16);
        g.getTuiles().add(t17);
        g.getTuiles().add(t18);
        g.getTuiles().add(t19);
        g.getTuiles().add(t20);
        g.getTuiles().add(t21);
        g.getTuiles().add(t22);
        g.getTuiles().add(t23);
        g.getTuiles().add(t24);
        g.getTuiles().add(t25);
        g.getTuiles().add(t26);
        g.getTuiles().add(t27);
        g.getTuiles().add(t28);
        g.getTuiles().add(t29);
        g.getTuiles().add(t30);
        g.getTuiles().add(t31);
        g.getTuiles().add(t32);
        g.getTuiles().add(t33);
        g.getTuiles().add(t34);
        g.getTuiles().add(t35);
        g.getTuiles().add(t36);

        Aventurier av1 = new Aventurier("le Prof", ingénieur, 0, t4, null);
        t4.getAventuriers().add(av1);
        Aventurier av2 = new Aventurier("Thibaud", plongeur, 0, t9, null);
        t9.getAventuriers().add(av2);
        Aventurier av3 = new Aventurier("Alexis", navigateur, 0, t10, null);
        t10.getAventuriers().add(av3);
        Aventurier av4 = new Aventurier("Mathilde", messager, 0, t14, null);
        t14.getAventuriers().add(av4);
        Aventurier av5 = new Aventurier("Sami", pilote, 0, t16, null);
        t16.getAventuriers().add(av5);
        Aventurier av6 = new Aventurier("l'autre Prof", explorateur, 0, t17, null);
        t14.getAventuriers().add(av6);

        VueAventurier window = new VueAventurier(g, av1, Color.blue);
        
        
        
    
        
        
        

        
        
        
        //window.setVisible(true);
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

    public void demandeDeplacement(Aventurier a) {//tuile de destination + aventurier concerné
        boolean enAttenteDAppuie = true;
        a.getTuileAtteignable();
        /*AFFICHAGE MATHILDE*/
 /*debut loop EN ATTENTE DE detection click sur bouton possible
                     attente d'appuie sur une tuile valide   */
        Tuile tDest = null;/*récupérer tuile au click
          fin loop*/
        deplacement(tDest, a);
    }

    public void deplacement(Tuile tDest, Aventurier a) {
        a.getTuile().getAventuriers().remove(a);
        a.setT(tDest);
        tDest.getAventuriers().add(a);
    }

    public void demandeassecher(Aventurier a) {//tuile de destination + aventurier concerné
        boolean enAttenteDAppuie = true;
        a.getTuileAssechable();
        /*AFFICHAGE MATHILDE*/
 /*debut loop EN ATTENTE DE detection click sur bouton possible
                     attente d'appuie sur une tuile valide   */
        Tuile tDest = null;/*récupérer tuile au click
          fin loop*/
        deplacement(tDest, a);
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
