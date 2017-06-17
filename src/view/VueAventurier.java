package view;

import PasDefaultPackage.Aventurier;
import PasDefaultPackage.Etat;
import PasDefaultPackage.Grille;
import PasDefaultPackage.Tuile;
import PasDefaultPackage.TypeRole;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static javafx.scene.paint.Color.color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import sun.security.krb5.Config;
import static javafx.scene.paint.Color.color;

public class VueAventurier {

    private final JPanel panelBoutons;

    private JPanel mainAutreJoueur;
    private JPanel plateau;
    private JPanel mainJoueur;
    private final JPanel panelCentre;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnDeplacer;
    private final JButton btnAssecher;
    private final JButton btnAutreAction;
    private final JButton btnTerminerTour;
    private final JTextField position;
    private JButton[] bton = new JButton[36];
    private boolean white = false;

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

        this.btnDeplacer = new JButton("Se Déplacer");
        this.btnAssecher = new JButton("Assecher");
        this.btnAutreAction = new JButton("Autre Action");
        this.btnTerminerTour = new JButton("Terminer Tour");

        this.panelBoutons.add(btnDeplacer);
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
        peinture(g, aJoueur, couleur,white);
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
                            aJoueur.setTuileAtteignable(g);
                            plateau.removeAll();
                            white = true;
                            peinture(g, aJoueur, couleur,white);
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
        
         btnAssecher.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent me) {
                            aJoueur.setTuileAssechable(g);
                            plateau.removeAll();
                            white = true;
                            peinture(g, aJoueur, couleur,white);
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
        
    public void peinture(Grille g, Aventurier aJoueur, Color couleur, boolean white){
        
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
           if(white && aJoueur.existedéjà(aJoueur.getTuileAtteignable(), g.getTuiles().get(i))){ 
                    Tuile t = g.getTuiles().get(i);
                    bton[i].addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                        aJoueur.deplacement(t);
                        plateau.removeAll();
                        boolean white = false;
                        peinture(g, aJoueur, couleur, white);
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
        } else if(white && aJoueur.existedéjà(aJoueur.getTuileAssechable(), g.getTuiles().get(i))){ 
                    Tuile t = g.getTuiles().get(i);
                    bton[i].addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                        aJoueur.assecher(t);
                        plateau.removeAll();
                        boolean white = false;
                        peinture(g, aJoueur, couleur, white);
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
        }
            
        if(aJoueur.existedéjà((aJoueur.getTuileAtteignable()), g.getTuiles().get(i)) && white == true || aJoueur.existedéjà((aJoueur.getTuileAssechable()), g.getTuiles().get(i)) && white == true){
                    bton[i].setBackground(Color.WHITE);
                }    
        }
      
    }
        
    public JButton getBtnAutreAction() {
        return btnAutreAction;
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
