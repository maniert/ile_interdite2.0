package view;

import PasDefaultPackage.Aventurier;
import PasDefaultPackage.Etat;
import PasDefaultPackage.Grille;
import PasDefaultPackage.Tuile;
import PasDefaultPackage.TypeRole;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
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

    private final JPanel panelBoutons;

    private JPanel mainAutreJoueur;
    private JPanel plateau;
    private JPanel mainJoueur;
    private final JPanel panelCentre;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnAller;
    private final JButton btnAssecher;
    private final JButton btnAutreAction;
    private final JButton btnTerminerTour;
    private final JTextField position;
    private JButton[] bton = new JButton[36];

    public VueAventurier(Grille g, Aventurier aJoueur, Color couleur) {

        this.window = new JFrame();
        window.setSize(1080, 720);

        window.setTitle(aJoueur.getNomJoueur());
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);

        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2));

        // =================================================================================
        // NORD : le titre = nom de l'aventurier + nom du joueur sur la couleurActive du pion
        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(couleur);
        panelAventurier.add(new JLabel(aJoueur.getTypeRole().toString(), CENTER));
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
        this.panelBoutons = new JPanel(new GridLayout(4, 1));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.EAST);
        // Ouest : les mains des autres joueurs
        this.mainAutreJoueur = new JPanel(new GridLayout(3, 5));
        this.mainAutreJoueur.setOpaque(false);
        mainPanel.add(this.mainAutreJoueur, BorderLayout.WEST);
        // Center : Le plateau
        this.plateau = new JPanel(new GridLayout(6, 6));
        this.plateau.setOpaque(false);
        mainPanel.add(this.plateau, BorderLayout.CENTER);
        // Sud : Main du joueur ++
        this.mainJoueur = new JPanel(new GridLayout(4, 1));
        this.mainJoueur.setOpaque(false);
        mainPanel.add(this.mainJoueur, BorderLayout.SOUTH);

        this.btnAller = new JButton("Se Déplacer");
        this.btnAssecher = new JButton("Assecher");
        this.btnAutreAction = new JButton("Autre Action");
        this.btnTerminerTour = new JButton("Terminer Tour");

        this.panelBoutons.add(btnAller);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnAutreAction);
        this.panelBoutons.add(btnTerminerTour);

        this.mainAutreJoueur.add(new JButton("7"));
        this.mainAutreJoueur.add(new JButton("8"));
        this.mainAutreJoueur.add(new JButton("9"));
        this.mainAutreJoueur.add(new JButton("10"));
        this.mainAutreJoueur.add(new JButton("11"));
        this.mainAutreJoueur.add(new JButton("12"));
        this.mainAutreJoueur.add(new JButton("13"));
        this.mainAutreJoueur.add(new JButton("14"));
        this.mainAutreJoueur.add(new JButton("15"));

        Pion pExplo = new Pion(TypeRole.explorateur, Color.GREEN, true);
        Pion pNav = new Pion(TypeRole.navigateur, Color.YELLOW, true);
        Pion pPlong = new Pion(TypeRole.plongeur, Color.BLACK, true);
        Pion pInge = new Pion(TypeRole.ingénieur, Color.RED, true);
        Pion pPilo = new Pion(TypeRole.pilote, Color.BLUE, true);
        Pion pMess = new Pion(TypeRole.messager, Color.ORANGE, true);

        for (int i = 0; i <= 35; i++) {
            //this.plateau.add(new JButton(g.getTuiles().get(i).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(i)));
            bton[i] = new JButton();
            this.plateau.add(bton[i]);
            bton[i].setText(g.getTuiles().get(i).getNomTuile());
            bton[i].setBackground(CouleurTuile(g.getTuiles().get(i)));

            for (int j = 0; j < g.getTuiles().get(i).getAventuriers().size(); j++) {
                if (0 != g.getTuiles().get(i).getAventuriers().size()) {
                    switch (g.getTuiles().get(i).getAventuriers().get(j).getTypeRole()) {
                        case plongeur:
                            bton[i].add(pPlong);    //Afficher le bon pion sur la tuile
                            break;
                        case explorateur:
                            bton[i].add(pExplo);
                            break;
                        case ingénieur:
                            bton[i].add(pInge);
                            break;
                        case messager:
                            bton[i].add(pMess);
                            break;
                        case navigateur:
                            bton[i].add(pNav);
                            break;
                        case pilote:
                            bton[i].add(pPilo);
                            break;
                        default:
                            break;
                    }
                }
            }

            /*
            switch (i) {
                case 3:
                    //this.plateau.add(new JButton(g.getTuiles().get(2).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(2)));
                    JPanel TPontAbimes = new JPanel();
                    
                    plateau.add(TPontAbimes);
                    TPontAbimes.setBackground(CouleurTuile(g.getTuiles().get(2)));
                    TPontAbimes.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            
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
                    break;
                case 4:
                    this.plateau.add(new JButton(g.getTuiles().get(3).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(3)));
                    /*JLabel TPorteBronze = new JLabel("La Porte DE Bronze ");
                    plateau.add(TPorteBronze);

                    break;
                case 8:
                    this.plateau.add(new JButton(g.getTuiles().get(7).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(7)));         // new ImageIcon("/users/info/etu-s2/maniert/ile_interdite_projet/Ile_interdite/src/view/9122512-14519887.jpg"))
                    break;
                case 9:
                    this.plateau.add(new JButton(g.getTuiles().get(8).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(8)));
                    JButton b = new JButton("La Porte De Fer");
                    ImageIcon image = new ImageIcon("/users/info/etu-s2/maniert/ile_interdite_projet/Ile_interdite/src/view/rond vide.png");
                    b.setIcon(image);
                    this.plateau.add(b);
                    break;
                case 10:
                    this.plateau.add(new JButton(g.getTuiles().get(9).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(9)));
                    break;
                case 11:
                    this.plateau.add(new JButton(g.getTuiles().get(10).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(10)));
                    break;
                case 13:
                    this.plateau.add(new JButton(g.getTuiles().get(12).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(12)));
                    break;
                case 14:
                    this.plateau.add(new JButton(g.getTuiles().get(13).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(13)));
                    break;
                case 15:
                    this.plateau.add(new JButton(g.getTuiles().get(14).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(14)));
                    break;
                case 16:
                    this.plateau.add(new JButton(g.getTuiles().get(15).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(15)));
                    break;
                case 17:
                    this.plateau.add(new JButton(g.getTuiles().get(16).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(16)));
                    break;
                case 18:
                    this.plateau.add(new JButton(g.getTuiles().get(17).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(17)));
                    break;
                case 19:
                    this.plateau.add(new JButton(g.getTuiles().get(18).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(18)));
                    break;
                case 20:
                    this.plateau.add(new JButton(g.getTuiles().get(19).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(19)));
                    break;
                case 21:
                    this.plateau.add(new JButton(g.getTuiles().get(20).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(20)));
                    break;
                case 22:
                    this.plateau.add(new JButton(g.getTuiles().get(21).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(21)));
                    break;
                case 23:
                    this.plateau.add(new JButton(g.getTuiles().get(22).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(22)));
                    break;
                case 24:
                    this.plateau.add(new JButton(g.getTuiles().get(23).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(23)));
                    break;
                case 26:
                    this.plateau.add(new JButton(g.getTuiles().get(25).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(25)));
                    break;
                case 27:
                    this.plateau.add(new JButton(g.getTuiles().get(26).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(26)));
                    break;
                case 28:
                    this.plateau.add(new JButton(g.getTuiles().get(27).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(27)));
                    break;
                case 29:
                    this.plateau.add(new JButton(g.getTuiles().get(28).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(28)));
                    break;
                case 33:
                    this.plateau.add(new JButton(g.getTuiles().get(32).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(32)));
                    break;
                case 34:
                    this.plateau.add(new JButton(g.getTuiles().get(33).getNomTuile())).setBackground(CouleurTuile(g.getTuiles().get(33)));
                    break;
                default:
                    this.plateau.add(new JButton(g.getTuiles().get(0).getNomTuile())).setBackground(Color.BLACK);
                    break;
            }
             */
        }

        this.mainJoueur.add(new JButton(""));
        this.mainJoueur.add(new JButton(""));
        this.mainJoueur.add(new JButton(""));
        this.mainJoueur.add(new JButton(""));
        //ferme la fenêtre correctement.
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
        mainPanel.repaint();
    }

    public JButton getBtnAutreAction() {
        return btnAutreAction;
    }

    public void setPosition(String pos) {
        this.position.setText(pos);
    }

    public JButton getBtnAller() {
        return btnAller;
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
