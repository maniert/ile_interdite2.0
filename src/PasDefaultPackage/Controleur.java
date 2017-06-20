package PasDefaultPackage;

import java.awt.Color;
import java.util.*;
import view.VueAventurier;

public class Controleur implements Observateur {

    private VueAventurier vueAventurier;
    private Aventurier aventurier;

    private static Grille grille;
    private Collection<Aventurier> aventuriers;
    private TasCartesTrésor cartesTresor;
    private TasCartesInnondation cartesInnondation;
    private static boolean finPartie;
    private static int nbmaxPa = 2;

    public Controleur() {
        //initialisation partie
        /*
        creer une autre vue
         */
        grille = new Grille();
        //lancement partie
        finPartie = false;
        //window.setVisible(true);
        VueAventurier window = new VueAventurier(grille, Color.blue, this);
//       
        if (!finPartie) {

            grille.getJoueurCourant().setNbPA(nbmaxPa);
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

    }

    @Override
    public void traiterMessage(Message msg) {
        String joueur;
        int no_joueur = 0, suivant;

        switch (msg.type) {
            case DEMARRER_PARTIE:

                break;

            case DEMANDE_DEPLACEMENT:
                grille.getJoueurCourant().setHelicoDispo(false);
                grille.getJoueurCourant().getTuileAssechable().clear();
                grille.getJoueurCourant().setTuileAtteignable(grille);
                grille.getJoueurCourant().setHelicoDispo(true);
                break;

            case DEMANDE_ASSECHEMENT:
                grille.getJoueurCourant().getTuileAtteignable().clear();
                grille.getJoueurCourant().setTuileAssechable(grille);
                break;

            case DEPLACEMENT_SPE:

                if (grille.getJoueurCourant().getTypeRole() == TypeRole.pilote && grille.getJoueurCourant().isDeplSpePilote()) { // gestion du coup spécial du pilote
                    grille.getJoueurCourant().setTuileAtteignable(grille);
                    grille.getJoueurCourant().setHelicoDispo(false);
                }
                break;
            case FIN_TOUR:
                grille.getJoueurCourant().setNbPA(0);
                if (grille.getJoueurCourant().getNbPA() < 1) { // verifie  si le joueur peux encore agir sinon au tour du joueur suivant
                    if (grille.getRang(grille.getJoueurs(), grille.getJoueurCourant()) != grille.getnbJ()) {//regarde son rang si il n'est pas dernier
                        grille.setJoueurCourant(grille.getJoueurs().get(grille.getRang(grille.getJoueurs(), grille.getJoueurCourant()) + 1));// au tour du suivant
                        grille.getJoueurCourant().setNbPA(getNbmaxPa());//prépare les pa du joueur suivant 
                        if (grille.getJoueurCourant().getTypeRole() == TypeRole.pilote) {
                            grille.getJoueurCourant().setHelicoDispo(true);
                            grille.getJoueurCourant().setDeplSpePilote(true);//redonner le déplacement spécial au joueur Pilote
                        }
                    } else {                                                    //sinon meme chose mais pour le joueur 1 puisque le dernier joueur finis son tour
                        grille.setJoueurCourant(grille.getJoueurs().get(0));
                        grille.getJoueurCourant().setNbPA(getNbmaxPa());
                        if (grille.getJoueurCourant().getTypeRole() == TypeRole.pilote) {
                            grille.getJoueurCourant().setHelicoDispo(true);
                            grille.getJoueurCourant().setDeplSpePilote(true);   //redonner le déplacement spécial au joueur Pilote
                        }
                    }
                }

                grille.getJoueurCourant().getTuileAssechable().clear();
                grille.getJoueurCourant().getTuileAtteignable().clear();
                break;

            case DEPLACER:
                grille.getJoueurCourant().setNbPA(grille.getJoueurCourant().getNbPA() - 1);//retire un pa au joueur
                break;

            case ASSECHER:
                grille.getJoueurCourant().setNbPA(grille.getJoueurCourant().getNbPA() - 1);//retire un pa au joueur
                break;
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

    public void debutPartie() {

    }

    /**
     * @return the nbmaxPa
     */
    public static int getNbmaxPa() {
        return nbmaxPa;
    }

    /**
     * @param aNbmaxPa the nbmaxPa to set
     */
    public static void setNbmaxPa(int aNbmaxPa) {
        nbmaxPa = aNbmaxPa;
    }

}