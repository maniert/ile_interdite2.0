package view;

import PasDefaultPackage.Aventurier;
import PasDefaultPackage.Carte;
import PasDefaultPackage.Etat;
import PasDefaultPackage.Grille;
import PasDefaultPackage.Message;
import PasDefaultPackage.Observateur;
import PasDefaultPackage.Tuile;
import PasDefaultPackage.TypeCarte;
import PasDefaultPackage.TypeRole;
import PasDefaultPackage.TypesMessages;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import util.Parameters;

public class VueAventurier {

    private Observateur o;
    private final JPanel panelBoutons;
    //private final JPanel mainAutresJoueurs;
    private JPanel plateau;
    private JPanel mainJoueur;
    private final JPanel panelCentre;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnDeplacer;
    private final JButton btnAssecher;
    private  JButton btnActionSpecial;
    private JButton btnDéfausseCTrésors, btnPiocherCTrésors, btnDonnerCTrésors;

    private JButton btnObtenirTresor;
    private JButton btnTerminerTour;
    private final JTextField position;
    private JButton[] btnGrille = new JButton[36];
    private JButton[] btnMainJoueur = new JButton[10];
    private boolean white = false;
    private Message m;
    private JLabel jl;
    private JPanel mainAutre;
    private JPanel btnMainJ;
     private Integer niveau ;
    
     HashMap<Integer, JPanel> panelsGauches ;
    private final JPanel niveauPan;

    public VueAventurier(Grille grille, Color couleur, Observateur obs) {
        m = new Message();
        this.o = obs;


        // ========================= 
        //Instanciation fenètre
        this.window = new JFrame();
        window.setSize(1800, 1000);
        window.setTitle("L'Ile Interdite");

        // ========================= 
        //Ajout mainPanel dans la fenêtre
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2));
        this.window.add(mainPanel);
    

        // =================================================================================
        // NORD : le titre = nom de l'aventurier + nom du joueur sur la couleurActive du pion
        this.panelAventurier = new JPanel();
        mainPanel.add(panelAventurier, BorderLayout.NORTH);

        // =================================================================================
        // CENTRE : 1 ligne pour position courante
        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, couleur));

        panelCentre.add(new JLabel("Position", SwingConstants.CENTER));
        position = new JTextField(30);
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);

        // =================================================================================
        // Est : Les boutons assècher ect
        this.panelBoutons = new JPanel(new GridLayout(5, 1));
        this.btnDeplacer = new JButton("Se Déplacer");
        this.btnAssecher = new JButton("Assecher");
        this.btnActionSpecial = new JButton("Action Spécial");
        this.btnTerminerTour = new JButton("Fin Action");
        this.btnObtenirTresor = new JButton("Donner Tresor");
        panelBoutons.add(btnDeplacer);
        panelBoutons.add(btnAssecher);
        panelBoutons.add(btnActionSpecial);
        panelBoutons.add(btnObtenirTresor);
        panelBoutons.add(btnTerminerTour);
        mainPanel.add(panelBoutons, BorderLayout.EAST);

        // =========================================================
        // Ouest : les mains des autres joueurs
        //grille.getEchelle().getNiveauEchelle(), 
        
        int niveauInitial = grille.getEchelle().getNiveauEchelle();
          panelsGauches = new HashMap<>();

        niveauPan  = new JPanel(new BorderLayout());

        niveauPan.setLayout(new BorderLayout());
        niveauPan.setBackground(Color.WHITE);
        niveauPan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));
        
        JLabel labelTitre = new JLabel("Niveau", JLabel.CENTER);
        niveauPan.add(labelTitre, BorderLayout.NORTH);
        labelTitre.setFont(labelTitre.getFont().deriveFont(Font.BOLD));
        labelTitre.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
        
        JPanel panelNiveaux = new JPanel(new GridBagLayout());
        panelNiveaux.setOpaque(false);
        niveauPan.add(panelNiveaux, BorderLayout.CENTER);
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 2 ;
        c.weighty = 10 ;
        c.insets = new Insets(0, 0, 0, 0);
        c.fill = GridBagConstraints.VERTICAL ;
        
        // Insertion de la cellule gauche de niveauInitial 10
        for (int i=0; i < 10; i++) {
            c.gridx = 0 ;
            c.gridy = i ;
            JPanel panelGauche = new JPanel();
            panelGauche.setLayout(new BoxLayout(panelGauche, BoxLayout.Y_AXIS));
            panelGauche.setBackground(getBgColor(10-i));
            panelGauche.setPreferredSize(new Dimension(50, 50));
            if (i < 9) {
                panelGauche.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
            } else {
                panelGauche.setBorder(new MatteBorder(1, 0, 0, 0, Color.WHITE));
            }

            panelNiveaux.add(panelGauche, c);

            JLabel labelGauche = new JLabel("", JLabel.LEFT);
            labelGauche.setPreferredSize(new Dimension(50, 50));
            labelGauche.setForeground(i==0 ? new Color(223, 168, 169) : Color.BLACK);
            labelGauche.setFont(new Font(labelGauche.getFont().getFamily(), labelGauche.getFont().getStyle(), 8));
            labelGauche.setText(getLibelle(10-i));
            panelGauche.add(labelGauche);
            panelsGauches.put((10-i), panelGauche) ;
        }
            
        // Insertion de la cellule droite de niveauInitial 10
        for (int iPanel=0; iPanel < 4; iPanel++) {
            c.gridx = 1 ;
            c.gridy = (iPanel==0 ? 0 : (iPanel==1 ? 3 : (iPanel==2 ? 5 : 8))) ;
            c.gridheight = (iPanel==0 || iPanel==2 ? 3 : 2) ;
            JPanel panelDroit = new JPanel();
            panelDroit.setPreferredSize(new Dimension(50, 50));
            panelDroit.setLayout(new GridBagLayout());
            panelNiveaux.add(panelDroit, c);

            JLabel labelDroit;
            switch (iPanel) {
                case 0:
                    panelDroit.setBackground(getBgColor(10));
                    labelDroit = new JLabel("5", JLabel.CENTER) ;
                    break;
                case 1:
                    panelDroit.setBackground(getBgColor(7));
                    labelDroit = new JLabel("4", JLabel.CENTER) ;
                    break;
                case 2:
                    panelDroit.setBackground(getBgColor(5));
                    labelDroit = new JLabel("3", JLabel.CENTER) ;
                    break;
                default:
                    panelDroit.setBackground(getBgColor(1));
                    labelDroit = new JLabel("2", JLabel.CENTER) ;
                    break;
            }
            labelDroit.setPreferredSize(new Dimension(50, 50));
            labelDroit.setForeground(Color.WHITE);
            labelDroit.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 40));
            GridBagConstraints gbc = new GridBagConstraints();
            panelDroit.add(labelDroit, gbc);
        }
        panelsGauches.get(niveauInitial).setBackground(Color.YELLOW);

        mainPanel.add(niveauPan, BorderLayout.WEST);
        // =========================================================
        // Center : Le plateau
        this.plateau = new JPanel(new GridLayout(6, 6));
        this.plateau.setOpaque(false);
        mainPanel.add(this.plateau, BorderLayout.CENTER);

        // =========================================================
        // Sud : Main du joueur ++
        this.mainJoueur = new JPanel(new GridLayout(1,0)); 
        this.mainJoueur.setOpaque(false);
       
        for (int i = 0; i <= 9; i++) {
            btnMainJoueur[i] = new JButton();
            btnMainJoueur[i].setName(Integer.toString(i));
            mainJoueur.add(btnMainJoueur[i], BorderLayout.WEST);
        }

        this.btnDéfausseCTrésors = new JButton("Défausse Cartes Trésors");
        this.btnPiocherCTrésors = new JButton("Pioche Cartes Trésors");
        this.btnDonnerCTrésors = new JButton("Donner une Carte Trésor");
        this.btnMainJ = new JPanel(new GridLayout(3,1));
        btnMainJ.add(btnPiocherCTrésors);
        btnMainJ.add(btnDéfausseCTrésors);
        btnMainJ.add(btnDonnerCTrésors);
        mainJoueur.add(btnMainJ, BorderLayout.CENTER);
        
mainPanel.add(mainJoueur, BorderLayout.SOUTH);
        
        
        jl = new JLabel(grille.getJoueurCourant().getTypeRole().toString(), CENTER);

        peinture(grille, grille.getJoueurCourant(), couleur, white);

        JPanel joueurPan = new JPanel();
        joueurPan.setBackground(Color.white);
        joueurPan.setBorder(BorderFactory.createTitledBorder(grille.getJoueurs().toString()));

        //ferme la fenêtre correctement.
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
        mainPanel.repaint();

        btnDeplacer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (grille.getJoueurCourant().getNbPA() == 0) {
                    System.out.println("tu ne peux plus te déplacer");
                } else {
                    plateau.removeAll();
                    white = false;
                    peinture(grille, grille.getJoueurCourant(), couleur, white);
                    m.type = TypesMessages.DEMANDE_DEPLACEMENT;
                    o.traiterMessage(m);
                    plateau.removeAll();
                    white = true;
                    peinture(grille, grille.getJoueurCourant(), couleur, white);
                }
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
                if (grille.getJoueurCourant().getNbPA() == 0) {
                    System.out.println("tu ne peux plus assecher");
                } else {
                    grille.getJoueurCourant().getTuileAtteignable().clear();
                    m.type = TypesMessages.DEPLACEMENT_SPE;
                    o.traiterMessage(m);
                    plateau.removeAll();
                    white = true;
                    peinture(grille, grille.getJoueurCourant(), couleur, white);
                }
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
                if (grille.getJoueurCourant().getNbPA() == 0) {
                    System.out.println("tu ne peux plus assecher");
                } else {
                    plateau.removeAll();
                    white = false;
                    peinture(grille, grille.getJoueurCourant(), couleur, white);
                    if (grille.getTuiles().get(m.getIndiceTuile()).getEtat() == Etat.innondé && grille.getJoueurCourant().getAssechInge().size() == 2) {
                        grille.getTuiles().get(grille.getJoueurCourant().getAssechInge().get(0)).setEtat(Etat.selectionné);
                        grille.getTuiles().get(grille.getJoueurCourant().getAssechInge().get(1)).setEtat(Etat.selectionné);
                        grille.getJoueurCourant().getAssechInge().clear();
                        grille.getJoueurCourant().assecherInge(grille);
                    } else {
                        m.type = TypesMessages.DEMANDE_ASSECHEMENT;
                        o.traiterMessage(m);
                    }
                    plateau.removeAll();
                    white = true;
                    peinture(grille, grille.getJoueurCourant(), couleur, white);
                }
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
                if (btnTerminerTour.getText() == "Fin Action") {
                    grille.getJoueurCourant().setNbPA(0);
                } else if (btnTerminerTour.getText() == "Terminer Tour") {
                    grille.getJoueurCourant().setNbCarteTiré(0);
                }
                m.type = TypesMessages.FIN_TOUR;
                o.traiterMessage(m);
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

        Tuile premiereTuile;
        panelAventurier.remove(jl);
        jl = new JLabel(grille.getJoueurCourant().getTypeRole().toString() + ":  " + grille.getJoueurCourant().getNomJoueur(), CENTER);
        jl.setForeground(Color.white);
        panelAventurier.add(jl);

        panelAventurier.setBackground(donnerCouleur(grille.getJoueurCourant()));
        for (int i = 0; i <= 35; i++) {
            //this.plateau.add(new JButton(g.getTuiles().get(indiceTuile).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(indiceTuile)));
            btnGrille[i] = new JButton();
            switch (i) {
                case 0:

                    btnGrille[0].add(new JLabel(new ImageIcon(Parameters.ROOT + "\\src\\images\\images\\tresors\\zephyr.png")));
                    break;
                case 5:
                    btnGrille[5].add(new JLabel(new ImageIcon(Parameters.ROOT + "\\src\\images\\images\\tresors\\calice.png")));
                    break;
                case 30:

                    btnGrille[30].add(new JLabel(new ImageIcon(Parameters.ROOT + "\\src\\images\\images\\tresors\\pierre.png")));
                    break;
                case 35:
                    btnGrille[35].add(new JLabel(new ImageIcon(Parameters.ROOT + "\\src\\images\\images\\tresors\\cristal.png")));
                    break;
                default:
                    break;
            }
            this.plateau.add(btnGrille[i]);
            btnGrille[i].setText(grille.getTuiles().get(i).getNomTuile());
            btnGrille[i].setBackground(CouleurTuile(grille.getTuiles().get(i)));

            creationPion(grille, i);

            creationTuileTresor(grille, i);

            if (grille.getJoueurCourant().getNbPA() < 1) {
                getBtnTerminerTour().setText("Terminer Tour");
            } else if (grille.getJoueurCourant().getNbPA() == Aventurier.getNbmaxPa()) {
                getBtnTerminerTour().setText("Fin Action");
            }

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
                if (grille.getJoueurCourant().getTypeRole() == TypeRole.Ingénieur) {
                    m.setIndiceTuile(i);
                }

                btnGrille[i].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        joueurCourant.assecher(t);
                        m.type = TypesMessages.ASSECHER;
                        o.traiterMessage(m);
                        m.type = TypesMessages.FIN_TOUR;
                        o.traiterMessage(m);
                        plateau.removeAll();//efface le plateau
                        peinture(grille, grille.getJoueurCourant(), couleur, false);//réaffiche le plateau
                    }

                    ;
                        @Override
                    public void mousePressed(MouseEvent e
                    ) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e
                    ) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e
                    ) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e
                    ) {

                    }

                });
            }

            if (white == true) {
                if (joueurCourant.existedéjà((joueurCourant.getTuileAtteignable()), grille.getTuiles().get(i)) && white == true || joueurCourant.existedéjà((joueurCourant.getTuileAssechable()), grille.getTuiles().get(i))) {
                    btnGrille[i].setBackground(Color.WHITE);
                }

            }

        }

        if (grille.getJoueurCourant().getNbPA() == 0 && grille.getJoueurCourant().getNbCarteTiré() > 0) {
            btnPiocherCTrésors.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    m.type = TypesMessages.PIOCHER_CARTE_TRESOR;
                    o.traiterMessage(m);
                    for (int i = 0; i < grille.getJoueurCourant().getMain().size(); i++) {
                        System.out.println(grille.getJoueurCourant().getMain().get(i).getTypeCarte());
                    }
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

            btnDéfausseCTrésors.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {

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
        } else if (grille.getJoueurCourant().getNbPA() == 0 && grille.getJoueurCourant().getNbCarteTiré() == 0) {
            m.type = TypesMessages.FIN_TOUR;
            o.traiterMessage(m);
        }

        btnObtenirTresor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Tuile t;

                m.type = TypesMessages.DONNE_TRESOR;
                o.traiterMessage(m);

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

        btnDonnerCTrésors.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
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
        } else if (t.getEtat() == Etat.selectionné) {
            return Color.LIGHT_GRAY;

        } else if (t.getEtat() == Etat.immergé) {
            return Color.GRAY;
        } else {
            return Color.BLACK;
        }
    }

    public void creationPion(Grille grille, int i) {

        for (int j = 0; j <= grille.getTuiles().get(i).getAventuriers().size() - 1; j++) {
            if (0 != grille.getTuiles().get(i).getAventuriers().size()) {
                System.out.println(grille.getTuiles().get(i).getAventuriers().size());
                System.out.println(i);

                switch (grille.getTuiles().get(i).getAventuriers().get(j).getTypeRole()) {

                    case Plongeur:
                        //création des pions en tenant en compte du rang dans la tuile, pour effectuer un décalage
                        Pion pPlong = new Pion(TypeRole.Plongeur, donnerCouleur(grille.getTuiles().get(i).getAventuriers().get(j)), grille.getTuiles().get(i).getAventuriers().indexOf(grille.getTuiles().get(i).getAventuriers().get(j)));
                        btnGrille[i].add(pPlong);    //Afficher le bon pion sur la tuile
                        break;
                    case Explorateur:
                        //création des pions en tenant en compte du rang dans la tuile, pour effectuer un décalage
                        Pion pExplo = new Pion(TypeRole.Explorateur, donnerCouleur(grille.getTuiles().get(i).getAventuriers().get(j)), grille.getTuiles().get(i).getAventuriers().indexOf(grille.getTuiles().get(i).getAventuriers().get(j)));
                        btnGrille[i].add(pExplo);
                        break;
                    case Ingénieur:
                        //création des pions en tenant en compte du rang dans la tuile, pour effectuer un décalage
                        Pion pInge = new Pion(TypeRole.Ingénieur, donnerCouleur(grille.getTuiles().get(i).getAventuriers().get(j)), grille.getTuiles().get(i).getAventuriers().indexOf(grille.getTuiles().get(i).getAventuriers().get(j)));
                        btnGrille[i].add(pInge);
                        break;
                    case Messager:
                        //création des pions en tenant en compte du rang dans la tuile, pour effectuer un décalage
                        Pion pMess = new Pion(TypeRole.Messager, donnerCouleur(grille.getTuiles().get(i).getAventuriers().get(j)), grille.getTuiles().get(i).getAventuriers().indexOf(grille.getTuiles().get(i).getAventuriers().get(j)));
                        btnGrille[i].add(pMess);
                        break;
                    case Navigateur:
                        //création des pions en tenant en compte du rang dans la tuile, pour effectuer un décalage
                        Pion pNav = new Pion(TypeRole.Navigateur, donnerCouleur(grille.getTuiles().get(i).getAventuriers().get(j)), grille.getTuiles().get(i).getAventuriers().indexOf(grille.getTuiles().get(i).getAventuriers().get(j)));
                        btnGrille[i].add(pNav);
                        break;
                    case Pilote:
                        //création des pions en tenant en compte du rang dans la tuile, pour effectuer un décalage
                        Pion pPilo = new Pion(TypeRole.Pilote, donnerCouleur(grille.getTuiles().get(i).getAventuriers().get(j)), grille.getTuiles().get(i).getAventuriers().indexOf(grille.getTuiles().get(i).getAventuriers().get(j)));
                        btnGrille[i].add(pPilo);
                        break;
                    default:
                        break;
                }

            }

        }
    }

    public void creationTuileTresor(Grille grille, int i) {
        switch (grille.getTuiles().get(i).getFigure()) {
            case la_Pierre_sacrée:
                Tresor tsacrée = new Tresor(TypeCarte.la_Pierre_sacrée, Color.GRAY);
                btnGrille[i].add(tsacrée);
                break;
            case la_Statue_du_Zéphyr:
                Tresor tzeph = new Tresor(TypeCarte.la_Statue_du_Zéphyr, Color.orange);
                btnGrille[i].add(tzeph);
                break;
            case le_Calice_de_londe:
                Tresor tlonde = new Tresor(TypeCarte.le_Calice_de_londe, Color.blue);
                btnGrille[i].add(tlonde);
                break;
            case le_Cristal_Ardent:
                Tresor tcrist = new Tresor(TypeCarte.le_Cristal_Ardent, Color.RED);
                btnGrille[i].add(tcrist);
                break;
        }
    }

    public Color donnerCouleur(Aventurier a) {
        switch (a.getTypeRole()) {
            case Explorateur:
                return Color.GREEN;
            case Pilote:
                return Color.BLUE;
            case Plongeur:
                return Color.BLACK;
            case Navigateur:
                return Color.pink;
            case Messager:
                return Color.ORANGE;
            case Ingénieur:
                return Color.RED;
        }
        return Color.cyan;

    }

    /**
     * @param btnTerminerTour the btnTerminerTour to set
     */
    public void setBtnTerminerTour(JButton btnTerminerTour) {
        this.btnTerminerTour = btnTerminerTour;
    }
    
     public void setNiveau(Integer niveau) {
        System.out.println("VueNiveau_nopic.setNiveau(" + niveau + ")");
        panelsGauches.get(this.niveau).setBackground(getBgColor(this.niveau - 1));
        this.niveau = niveau ;
        panelsGauches.get(this.niveau).setBackground(this.niveau == 10 ? Color.RED : Color.YELLOW);
        this.niveauPan.repaint();
    }

    public Integer getNiveau() {
        return this.niveau ;
    }

    public Integer getColoredNiveau() {
        for (Integer coloredNiveau : panelsGauches.keySet()) {
            if (panelsGauches.get(coloredNiveau).getBackground() == Color.YELLOW) {
                return coloredNiveau;
            }
        }
        return -1 ;
    }

    private Color getBgColor(Integer niveau) {
        if (niveau <= 2)
            return new Color(169, 215, 226) ;
        
        if (niveau <= 5)
            return new Color(129, 194, 212) ;
            
        
        if (niveau <= 7)
            return new Color(67, 119, 204) ;
        
        return new Color(42, 76, 127) ;
    }

    private String getLibelle(int i) {
        switch (i) {
            case 1 : 
                return " novice" ;
            case 2 : 
                return " normal" ;
            case 3 : 
                return " élite" ;
            case 4 : 
                return " légendaire" ;
            case 10 : 
                return " mortel" ;
            default :
                return "" ;
        }
}
}
