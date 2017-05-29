package view;

import PasDefaultPackage.Tuile;
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
import util.Utils.Pion;

 
public class VueAventurier  {
     
    private final JPanel panelBoutons ;
    
    private JPanel mainAutreJoueur ;
    private JPanel plateau ;
    private JPanel mainJoueur;
    private final JPanel panelCentre ;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnAller;
    private final JButton btnAssecher;
    private final JButton btnAutreAction;
    private final JButton btnTerminerTour;
    private final JTextField position;
    
    
    
    public VueAventurier (String nomJoueur, String nomAventurier, Color couleur){

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
        this.panelBoutons = new JPanel(new GridLayout(4,1));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.EAST);
        // Ouest : les mains des autres joueurs
        this.mainAutreJoueur = new JPanel(new GridLayout(3,5));
        this.mainAutreJoueur.setOpaque(false);
        mainPanel.add(this.mainAutreJoueur, BorderLayout.WEST);
        // Center : Le plateau
        this.plateau = new JPanel(new GridLayout(6,6));
        this.plateau.setOpaque(false);
        mainPanel.add(this.plateau, BorderLayout.CENTER);
        // Sud : Main du joueur ++
        this.mainJoueur = new JPanel(new GridLayout(4,1));
        this.mainJoueur.setOpaque(false);
        mainPanel.add(this.mainJoueur, BorderLayout.SOUTH);
    

        this.btnAller = new JButton("Aller");
        this.btnAssecher = new JButton("Assecher");
        this.btnAutreAction = new JButton("AutreAction");
        this.btnTerminerTour = new JButton("Terminer Tour");

        this.panelBoutons.add(btnAller);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnAutreAction);
        this.panelBoutons.add(btnTerminerTour);

        this.mainAutreJoueur.add(new JButton("1"));
        this.mainAutreJoueur.add(new JButton("2"));
        this.mainAutreJoueur.add(new JButton("3"));
        this.mainAutreJoueur.add(new JButton("4"));
        this.mainAutreJoueur.add(new JButton("5"));
        this.mainAutreJoueur.add(new JButton("6"));
        this.mainAutreJoueur.add(new JButton("7"));
        this.mainAutreJoueur.add(new JButton("8"));
        this.mainAutreJoueur.add(new JButton("9"));
        this.mainAutreJoueur.add(new JButton("10"));
        this.mainAutreJoueur.add(new JButton("11"));
        this.mainAutreJoueur.add(new JButton("12"));
        this.mainAutreJoueur.add(new JButton("13"));
        this.mainAutreJoueur.add(new JButton("14"));
        this.mainAutreJoueur.add(new JButton("15"));

        
        for (int i = 1; i <= 36; i ++ ) {
            this.plateau.add(new JButton(""));
        }
        //JButton 11 = new JButton("");
        /*
        this.plateau.add(new JButton(""));
        this.plateau.add(new JButton("Le Pont Des Abimes"));
        this.plateau.add(new JButton("La Porte De Bronze"));
        this.plateau.add(new JButton(""));
        this.plateau.add(new JButton(""));
        this.plateau.add(new JButton(""));
        this.plateau.add(new JButton("La Caverne Des Ombres"));
        this.plateau.add(new JButton("La Porte De Fer"));
        this.plateau.add(new JButton("La Porte d'Or"));
        this.plateau.add(new JButton("Les Falaises De L'Oubli"));
        this.plateau.add(new JButton(""));
        this.plateau.add(new JButton("Le Palais De Corail"));
        this.plateau.add(new JButton("La Porte d'Argent"));
        this.plateau.add(new JButton("Les Dunes De L'Illusion"));
        this.plateau.add(new JButton("Heliport"));
        this.plateau.add(new JButton("La Porte De Cuivre"));
        this.plateau.add(new JButton("Le Jardin Des Hurlements"));
        this.plateau.add(new JButton("La Forêt Pourpre"));
        this.plateau.add(new JButton("Le Lagon Perdu"));
        this.plateau.add(new JButton("Le Marais Brumeux"));
        this.plateau.add(new JButton("Observatoire"));
        this.plateau.add(new JButton("Le Rocher Fantôme"));
        this.plateau.add(new JButton("La Caverne Du Braisier"));
        this.plateau.add(new JButton(""));
        this.plateau.add(new JButton("Le Temple Du Soleil"));
        this.plateau.add(new JButton("Le Temple De La Lune"));
        this.plateau.add(new JButton("Le Palais Des Marees"));
        this.plateau.add(new JButton("Le Val Du Crepuscule"));
        this.plateau.add(new JButton(""));
        this.plateau.add(new JButton(""));
        this.plateau.add(new JButton(""));
        this.plateau.add(new JButton("La Tour Du Guet"));
        this.plateau.add(new JButton("Le Jardin Des Murmures"));
        this.plateau.add(new JButton(""));
        this.plateau.add(new JButton(""));
        */
        
        this.mainJoueur.add(new JButton(""));
        this.mainJoueur.add(new JButton(""));
        this.mainJoueur.add(new JButton(""));
        this.mainJoueur.add(new JButton(""));
        
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
    public String affichageTuile (Tuile t)  {
        //chercher la tuile et l'afficher

        return t.getNomTuile();
        
    }
   
    
     public static void main(String [] args) {
        // Instanciation de la fenêtre 
        VueAventurier vueAventurier = new VueAventurier ("Mathildeuh", "Explorateur",Pion.VERT.getCouleur() );
    }

}
