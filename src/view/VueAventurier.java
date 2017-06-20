package view;

import PasDefaultPackage.Aventurier;
import PasDefaultPackage.Etat;
import PasDefaultPackage.Grille;
import PasDefaultPackage.Message;
import PasDefaultPackage.Observateur;
import PasDefaultPackage.Tuile;
import PasDefaultPackage.TypeRole;
import PasDefaultPackage.TypesMessages;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;

public class VueAventurier {

    private Observateur o;
    private final JPanel panelBoutons;
    private final JPanel mainAutresJoueurs;
    private JPanel plateau;
    private JPanel mainJoueur;
    private final JPanel panelCentre;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnDeplacer;
    private final JButton btnAssecher;
    private final JButton btnActionSpecial;
    private JButton btnDonnerTresor;
    private final JButton btnTerminerTour;
    private final JTextField position;
    private JButton[] btnGrille = new JButton[36];
    private JButton[] btnMainAutresJoueurs = new JButton[15];
    private JButton[] btnMainJoueur = new JButton[5];
    private boolean white = false;
    private Message m;

    public VueAventurier(Grille grille, Color couleur, Observateur obs) {
        m = new Message();
        this.o = obs;
        this.window = new JFrame();
        window.setSize(1080, 720);

        window.setTitle(grille.getJoueurCourant().getNomJoueur());
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);

        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2));

        // =================================================================================
        // NORD : le titre = nom de l'aventurier + nom du joueur sur la couleurActive du pion
        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(couleur);
        panelAventurier.add(new JLabel(grille.getJoueurCourant().getTypeRole().toString(), CENTER));
        mainPanel.add(panelAventurier, BorderLayout.NORTH);

        // =================================================================================
        // CENTRE : 1 ligne pour position courante
        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, couleur));
        mainPanel.add(this.panelCentre, BorderLayout.CENTER);

        panelCentre.add(new JLabel("Position", SwingConstants.CENTER));
        position = new JTextField(30);
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);

        // =================================================================================
        // Est : Les boutons assècher ect 
        this.panelBoutons = new JPanel(new GridLayout(5, 1));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.EAST);
        // Ouest : les mains des autres joueurs
        this.mainAutresJoueurs = new JPanel(new GridLayout(3, 5));
        this.mainAutresJoueurs.setOpaque(false);
        mainPanel.add(this.mainAutresJoueurs, BorderLayout.WEST);
        for (int i = 0; i <= 14; i++) {
            btnMainAutresJoueurs[i] = new JButton();
            btnMainAutresJoueurs[i].setName(Integer.toString(i));
            mainAutresJoueurs.add(btnMainAutresJoueurs[i]);
        }
        // Center : Le plateau
        this.plateau = new JPanel(new GridLayout(6, 6));
        this.plateau.setOpaque(false);
        mainPanel.add(this.plateau, BorderLayout.CENTER);

        // Sud : Main du joueur ++
        this.mainJoueur = new JPanel(new GridLayout(1, 4));
        this.mainJoueur.setOpaque(false);
        mainPanel.add(this.mainJoueur, BorderLayout.SOUTH);
        for (int i = 0; i <= 4; i++) {
            btnMainJoueur[i] = new JButton();
            btnMainJoueur[i].setName(Integer.toString(i));
            mainJoueur.add(btnMainJoueur[i]);
        }
        this.btnDeplacer = new JButton("Se Déplacer");
        this.btnAssecher = new JButton("Assecher");
        this.btnActionSpecial = new JButton("Action Spécial");
        this.btnTerminerTour = new JButton("Terminer Tour");
        this.btnDonnerTresor = new JButton("Donner Tresor");

        this.panelBoutons.add(btnDeplacer);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnActionSpecial);
        this.panelBoutons.add(btnDonnerTresor);
        this.panelBoutons.add(btnTerminerTour);

        peinture(grille, grille.getJoueurCourant(), couleur, white);

        this.mainJoueur.add(new JButton(""));
        this.mainJoueur.add(new JButton(""));
        this.mainJoueur.add(new JButton(""));
        this.mainJoueur.add(new JButton(""));
        //ferme la fenêtre correctement.
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
        mainPanel.repaint();

        btnDeplacer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                white = false;
                plateau.removeAll();
                peinture(grille, grille.getJoueurCourant(), couleur, white);
                m.type = TypesMessages.DEMANDE_DEPLACEMENT;
                o.traiterMessage(m);
                white = true;
                plateau.removeAll();
                peinture(grille, grille.getJoueurCourant(), couleur, white);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

        });

        btnActionSpecial.addMouseListener(new MouseListener() {           //quand le pilote décide d'utiliser
            @Override
            public void mouseClicked(MouseEvent e) {
                m.type = TypesMessages.DEPLACEMENT_SPE;
                o.traiterMessage(m);
                plateau.removeAll();
                white = true;
                peinture(grille, grille.getJoueurCourant(), couleur, white);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        btnAssecher.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                plateau.removeAll();
                white = false;
                peinture(grille, grille.getJoueurCourant(), couleur, white);
                m.type = TypesMessages.DEMANDE_ASSECHEMENT;
                o.traiterMessage(m);
                plateau.removeAll();
                white = true;
                peinture(grille, grille.getJoueurCourant(), couleur, white);

            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

        });

        btnTerminerTour.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                m.type = TypesMessages.FIN_TOUR;
                o.traiterMessage(m);
                window.setTitle(grille.getJoueurCourant().getNomJoueur());
                plateau.removeAll();
                white = false;
                peinture(grille, grille.getJoueurCourant(), couleur, white);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

        });

    }

    public void peinture(Grille grille, Aventurier joueurCourant, Color couleur, boolean white) {

        for (int i = 0; i <= 35; i++) {
            //this.plateau.add(new JButton(g.getTuiles().get(i).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(i)));
            btnGrille[i] = new JButton();
            this.plateau.add(btnGrille[i]);
            btnGrille[i].setText(grille.getTuiles().get(i).getNomTuile());
            btnGrille[i].setBackground(CouleurTuile(grille.getTuiles().get(i)));

            for (int j = 0; j < grille.getTuiles().get(i).getAventuriers().size(); j++) {
                if (0 != grille.getTuiles().get(i).getAventuriers().size()) {
                    switch (grille.getTuiles().get(i).getAventuriers().get(j).getTypeRole()) {
                        case plongeur:
                            //création des pions en tenant en compte du rang dans la tuile, pour effectuer un décalage 
                            Pion pPlong = new Pion(TypeRole.plongeur, Color.BLACK, true, grille.getTuiles().get(i).getAventuriers().indexOf(grille.getTuiles().get(i).getAventuriers().get(j)));
                            btnGrille[i].add(pPlong);    //Afficher le bon pion sur la tuile
                            break;
                        case explorateur:
                            //création des pions en tenant en compte du rang dans la tuile, pour effectuer un décalage 
                            Pion pExplo = new Pion(TypeRole.explorateur, Color.GREEN, true, grille.getTuiles().get(i).getAventuriers().indexOf(grille.getTuiles().get(i).getAventuriers().get(j)));
                            btnGrille[i].add(pExplo);
                            break;
                        case ingénieur:
                            //création des pions en tenant en compte du rang dans la tuile, pour effectuer un décalage 
                            Pion pInge = new Pion(TypeRole.ingénieur, Color.RED, true, grille.getTuiles().get(i).getAventuriers().indexOf(grille.getTuiles().get(i).getAventuriers().get(j)));
                            btnGrille[i].add(pInge);
                            break;
                        case messager:
                            //création des pions en tenant en compte du rang dans la tuile, pour effectuer un décalage 
                            Pion pMess = new Pion(TypeRole.messager, Color.ORANGE, true, grille.getTuiles().get(i).getAventuriers().indexOf(grille.getTuiles().get(i).getAventuriers().get(j)));
                            btnGrille[i].add(pMess);
                            break;
                        case navigateur:
                            //création des pions en tenant en compte du rang dans la tuile, pour effectuer un décalage 
                            Pion pNav = new Pion(TypeRole.navigateur, Color.YELLOW, true, grille.getTuiles().get(i).getAventuriers().indexOf(grille.getTuiles().get(i).getAventuriers().get(j)));
                            btnGrille[i].add(pNav);
                            break;
                        case pilote:
                            //création des pions en tenant en compte du rang dans la tuile, pour effectuer un décalage 
                            Pion pPilo = new Pion(TypeRole.pilote, Color.BLUE, true, grille.getTuiles().get(i).getAventuriers().indexOf(grille.getTuiles().get(i).getAventuriers().get(j)));
                            btnGrille[i].add(pPilo);
                            break;
                        default:
                            break;
                    }

                }
            }
            System.out.println(joueurCourant.getNbPA());
            if (white && joueurCourant.existedéjà(joueurCourant.getTuileAtteignable(), grille.getTuiles().get(i))) {
                Tuile t = grille.getTuiles().get(i);
                btnGrille[i].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        joueurCourant.deplacement(t);
                        m.type = TypesMessages.DEPLACER;
                        o.traiterMessage(m);
                        plateau.removeAll();//efface le plateau
                        boolean white = false;//cache les possibilité de déplacement
                        peinture(grille, grille.getJoueurCourant(), couleur, white);//réaffiche le plateau
                        m.type = TypesMessages.FIN_TOUR;
                        o.traiterMessage(m);
                        window.setTitle(grille.getJoueurCourant().getNomJoueur());
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }

                });
            } else if (white && joueurCourant.existedéjà(joueurCourant.getTuileAssechable(), grille.getTuiles().get(i))) {
                Tuile t = grille.getTuiles().get(i);
                btnGrille[i].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        joueurCourant.assecher(t);
                        m.type = TypesMessages.ASSECHER;
                        o.traiterMessage(m);
                        plateau.removeAll();
                        boolean white = false;
                        peinture(grille, grille.getJoueurCourant(), couleur, white);
                        m.type = TypesMessages.FIN_TOUR;
                        o.traiterMessage(m);
                        window.setTitle(grille.getJoueurCourant().getNomJoueur());
                    }

                    ;
                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }

                });
            }
            if (white == true) {
                if (joueurCourant.existedéjà((joueurCourant.getTuileAtteignable()), grille.getTuiles().get(i)) && white == true || joueurCourant.existedéjà((joueurCourant.getTuileAssechable()), grille.getTuiles().get(i))) {
                    btnGrille[i].setBackground(Color.WHITE);
                }
            }

        }

    }

    public JButton getBtnAutreAction() {
        return btnActionSpecial;
    }

    public void setPosition(String pos) {
        this.position.setText(pos);
    }

    public JButton getBtnAller() {
        return btnDeplacer;
    }

    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    public JButton getBtnTerminerTour() {
        return btnTerminerTour;
    }

    //Mettre tuile sur l'interface selon son état donner une couleur et regarder son nom + Coordonées 
    public String affichageTuile(Tuile t) {
        //chercher la tuile et l'afficher
        return t.getNomTuile();
    }

    public Color CouleurTuile(Tuile t) {
        if (t.getEtat() == Etat.sec) {
            return Color.yellow;
        } else if (t.getEtat() == Etat.innondé) {
            return Color.CYAN;
        } else {
            return Color.GRAY;
        }
    }

}
