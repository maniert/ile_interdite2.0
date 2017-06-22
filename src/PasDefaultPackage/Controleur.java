package PasDefaultPackage;

import static PasDefaultPackage.TypeRole.Explorateur;
import static PasDefaultPackage.TypeRole.Ingénieur;
import static PasDefaultPackage.TypeRole.Messager;
import static PasDefaultPackage.TypeRole.Navigateur;
import static PasDefaultPackage.TypeRole.Pilote;
import static PasDefaultPackage.TypeRole.Plongeur;
import java.awt.Color;
import java.util.*;
import view.VueAventurier;
import view.VueInscription;

public class Controleur implements Observateur {

    private VueAventurier vueAventurier;
    VueInscription windowI;
    private Aventurier aventurier;

    private static Grille grille;
    private Collection<Aventurier> aventuriers;
    private TasCartesTrésor cartesTresor;
    private TasCartesInnondation cartesInnondation;
    private static boolean finPartie;
    private int nbj;
    private Aventurier av1;
    private Aventurier av2;
    private Aventurier av3;
    private Aventurier av4;
    private Aventurier av5;
    private Aventurier av6;

    public Controleur() {
        VueInscription window = new VueInscription(this);
        window.afficher();
    }

    @Override
    public void traiterMessage(Message msg) {

        switch (msg.type) {
            case DEMARRER_PARTIE:
                grille = new Grille(msg.getEchelledebut());
                av1 = new Ingenieur("le Prof", Ingénieur, 0, grille.getTuiles().get(3));//correspond à t4
                av2 = new Plongeur("Thibaud", Plongeur, 0, grille.getTuiles().get(8));//correspond à t9
                av3 = new Navigateur("Alexis", Navigateur, 0, grille.getTuiles().get(9));//correspond à t10
                av4 = new Messager("Mathilde", Messager, 0, grille.getTuiles().get(13));//correspond à t14
                av5 = new Pilote("ami", Pilote, 0, grille.getTuiles().get(15));//correspond à t16
                av6 = new Explorateur("l'autre Prof", Explorateur, 0, grille.getTuiles().get(16));//correspond à t17
                cartesInnondation = new TasCartesInnondation(grille);
                cartesTresor = new TasCartesTrésor();
                
                
                ArrayList<Aventurier> ttAv = new ArrayList<>();
                ttAv.add(av1);
                ttAv.add(av2);
                ttAv.add(av3);
                ttAv.add(av4);
                ttAv.add(av5);
                ttAv.add(av6);

                Collections.shuffle(ttAv);
                for (int i = 0; i < msg.getNbj(); i++) { // parcours les aventuriers
                    grille.getJoueurs().put(i + 1, ttAv.get(i)); //ajoute l'aventurier i au hashmap
                    grille.getJoueurs().get(i + 1).getTuile().getAventuriers().add(ttAv.get(i)); // Ajoute l'aventurier à la sa tuile
                    grille.getJoueurs().get(i + 1).setNomJoueur(msg.getNomsJoueurs().get(i));   //
                }

                grille.setJoueurCourant(grille.getJoueurs().get(1));
                vueAventurier = new VueAventurier(grille, Color.white, this);

                break;

            case DEMANDE_DEPLACEMENT:
                grille.getJoueurCourant().getTuileAssechable().clear();
                grille.getJoueurCourant().getTuileAtteignable().clear();
                grille.getJoueurCourant().setHelicoDispo(false);
                grille.getJoueurCourant().setTuileAtteignable(grille);
                grille.getJoueurCourant().setHelicoDispo(true);
                break;

            case DEMANDE_ASSECHEMENT:
                grille.getJoueurCourant().getTuileAtteignable().clear();
                grille.getJoueurCourant().getTuileAssechable().clear();
                grille.getJoueurCourant().setTuileAssechable(grille);

                break;

            case DEPLACEMENT_SPE:

                if (grille.getJoueurCourant().getTypeRole() == TypeRole.Pilote && grille.getJoueurCourant().isDeplSpePilote()) { // gestion du coup spécial du pilote
                    grille.getJoueurCourant().setTuileAtteignable(grille);
                    grille.getJoueurCourant().setDeplSpePilote(false);
                }
                break;
            case FIN_TOUR:
                if (grille.getJoueurCourant().getNbPA() < 1) { // verifie  si le joueur peux encore agir sinon au tour du joueur suivant
                    //CONDITION si nombre de points de tirage > 0 OU (prévoir un bouton qui set à 0 les pointdt pour finir tour completement)
                    if (grille.getJoueurCourant().getNbCarteTiré() < 1 && grille.getJoueurCourant().getMain().size() <= 5) {
                        if (grille.getRang(grille.getJoueurs(), grille.getJoueurCourant()) != grille.getnbJ()) {//regarde son rang si il n'est pas dernier
                            grille.setJoueurCourant(grille.getJoueurs().get(grille.getRang(grille.getJoueurs(), grille.getJoueurCourant()) + 1));// au tour du suivant
                            grille.getJoueurCourant().setNbPA(grille.getJoueurCourant().getNbmaxPa());//prépare les pa du joueur suivant
                            grille.getJoueurCourant().setNbCarteTiré(2);
                        } else {                                                    //sinon meme chose mais pour le joueur 1 puisque le dernier joueur finis son tour
                            grille.setJoueurCourant(grille.getJoueurs().get(0));
                            grille.getJoueurCourant().setNbPA(grille.getJoueurCourant().getNbmaxPa());
                            grille.getJoueurCourant().setNbCarteTiré(2);
                        }
                        if (grille.getJoueurCourant().getTypeRole() == TypeRole.Pilote) {
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

            case PIOCHER_CARTE_TRESOR:
                /* if (cartesTresor.getCartesEnJeu().get(0).getTypeCarte() == TypeCarte.MonteesDesEaux) {
                    //Modifier lechelle etc
                //grille.getJoueurCourant().setNbCarteTiré(grille.getJoueurCourant().getNbCarteTiré() - 1);
                } else*/ if (cartesTresor.getCartesEnJeu().get(0).getTypeCarte() != TypeCarte.vide) {
                    cartesTresor.tirerCarteJoueurCourant(grille);
                    grille.getJoueurCourant().setNbCarteTiré(grille.getJoueurCourant().getNbCarteTiré() - 1);
                }
                break;

            case ASSECHER:
                if (grille.getJoueurCourant().getTypeRole() == TypeRole.Ingénieur && grille.getJoueurCourant().getNbTuileAssech() == 0) {
                    grille.getJoueurCourant().setNbTuileAssech(1);
                    grille.getJoueurCourant().setNbPA(grille.getJoueurCourant().getNbPA() - 1);//retire un pa au joueur
                } else if (grille.getJoueurCourant().getTypeRole() == TypeRole.Ingénieur) {
                    grille.getJoueurCourant().setNbTuileAssech(0);
                } else {
                    grille.getJoueurCourant().setNbPA(grille.getJoueurCourant().getNbPA() - 1);//retire un pa au joueur
                }
                break;
            case DEFFAUSE_CARTE:
                cartesTresor.getCartesDefausse().add(grille.getJoueurCourant().getMain().get(msg.getIndiceMain()));
                grille.getJoueurCourant().getMain().remove(msg.getIndiceMain());

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
    public void defausserCarteTresorJoueur(Aventurier aventurier, Carte carte) {
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


}
