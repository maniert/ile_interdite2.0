package view;

import PasDefaultPackage.Tuile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import javax.swing.event.MouseInputListener;
import util.Utils.Pion;

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

    public VueAventurier(String nomJoueur, String nomAventurier, Color couleur) {

        this.window = new JFrame();
        window.setSize(1080, 720);

        window.setTitle(nomJoueur);
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);

        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2));

        // =================================================================================
        // NORD : le titre = nom de l'aventurier + nom du joueur sur la couleurActive du pion
        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(couleur);
        panelAventurier.add(new JLabel(nomAventurier, SwingConstants.CENTER));
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

        for (int i = 1; i <= 36; i++) {

            switch (i) {
                case 3:
                    //this.plateau.add(new JButton("Le Pont Des Abimes"));
                    JPanel TPontAbimes = new JPanel();
                    plateau.add(TPontAbimes);

                    TPontAbimes.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            System.out.println("Test 1 2 ");
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                            System.out.println("Test 3 ");
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                            System.out.println("Test 4 ");
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                            System.out.println("Test 1 ");
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                            System.out.println("Test2");
                        }
                    });
                    break;
                case 4:
                    this.plateau.add(new JButton("La Porte De Bronze"));
                    /*JLabel TPorteBronze = new JLabel("La Porte DE Bronze ");
                    plateau.add(TPorteBronze); */

                    break;
                case 8:
                    this.plateau.add(new JButton("La Caverne Des Ombres")); //  new ImageIcon("/users/info/etu-s2/benettim/Projet_Ile_Interdite/ile_interdite2.0/src/view/9122512-14519887.jpg")));

                    break;
                case 9:
                    this.plateau.add(new JButton("La Porte De Fer"));
                 /*   JButton b = new JButton("La Porte De Fer");
                    ImageIcon image = new ImageIcon("https://www.google.fr/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwi_xt2y5KjUAhXDBBoKHWf1AT4QjRwIBw&url=http%3A%2F%2Fwww.senioractu.com%2FUne-pomme-par-jour-pour-vivre-plus-longtemps_a18841.html&psig=AFQjCNH1SO2-kdJnYYiEfM2oMyaXAYC3-A&ust=1496823546348100");
                    b.setIcon(image);
                            this.plateau.add(b); */
                    break;
                case 10:
                    this.plateau.add(new JButton("La Porte d'Or"));
                    break;
                case 11:
                    this.plateau.add(new JButton("Les Falaises De L'Oubli"));
                    break;
                case 13:
                    this.plateau.add(new JButton("Le Palais De Corail"));
                    break;
                case 14:
                    this.plateau.add(new JButton("La Porte d'Argent"));
                    break;
                case 15:
                    this.plateau.add(new JButton("Les Dunes De L'Illusion"));
                    break;
                case 16:
                    this.plateau.add(new JButton("Heliport"));
                    break;
                case 17:
                    this.plateau.add(new JButton("La Porte De Cuivre"));
                    break;
                case 18:
                    this.plateau.add(new JButton("Le Jardin Des Hurlements"));
                    break;
                case 19:
                    this.plateau.add(new JButton("La Forêt Pourpre"));
                    break;
                case 20:
                    this.plateau.add(new JButton("Le Lagon Perdu"));
                    break;
                case 21:
                    this.plateau.add(new JButton("Le Marais Brumeux"));
                    break;
                case 22:
                    this.plateau.add(new JButton("Observatoire"));
                    break;
                case 23:
                    this.plateau.add(new JButton("Le Rocher Fantôme"));
                    break;
                case 24:
                    this.plateau.add(new JButton("La Caverne Du Braisier"));
                    break;
                case 26:
                    this.plateau.add(new JButton("Le Temple Du Soleil"));
                    break;
                case 27:
                    this.plateau.add(new JButton("Le Temple De La Lune"));
                    break;
                case 28:
                    this.plateau.add(new JButton("Le Palais Des Marees"));
                    break;
                case 29:
                    this.plateau.add(new JButton("Le Val Du Crepuscule"));
                    break;
                case 33:
                    this.plateau.add(new JButton("La Tour Du Guet"));
                    break;
                case 34:
                    this.plateau.add(new JButton("Le Jardin Des Murmures"));
                    break;
                default:
                    this.plateau.add(new JButton(""));
                    break;

            }

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

    public static void main(String[] args) {
        // Instanciation de la fenêtre 
        VueAventurier vueAventurier = new VueAventurier("Mathildeuh", "Explorateur", Pion.VERT.getCouleur());
    }

}
