/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import PasDefaultPackage.Message;
import PasDefaultPackage.Observateur;
import PasDefaultPackage.TypesMessages;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import util.Parameters;

/**
 *
 * @author Princesse Mathilde
 */
public class VueInscription {

    private JFrame window;
    private JPanel mainPanel;
     
    private JLabel icon;
    
    // nb Joueur
    private JRadioButton rnbJoueur2, rnbJoueur3, rnbJoueur4;

    // nom
    private JTextField nom1, nom2, nom3, nom4;
    private JLabel nomLabel, nomLabel2, nomLabel3, nomLabel4;

    //
    private JRadioButton level, levelNovice, levelNormal, levelElite, levelLegendaire, levelMortel;

    private Observateur observateur;
    private Message m;

    public VueInscription(Observateur o) {
        this.window = new JFrame();
        this.observateur = o;
        m = new Message();
          
        window.setTitle("Demarrage partie");
         window.setBackground(Color.yellow);
        mainPanel = new JPanel(new BorderLayout());

        
        mainPanel.setBackground(Color.PINK);        
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.PINK, 5));
        
        
        
        //image
            icon = new JLabel(new ImageIcon(Parameters.ROOT + "\\src\\images\\images\\ile.png"));
            JPanel panIcon = new JPanel();
            panIcon.setBackground(Color.white);
            panIcon.setLayout(new BorderLayout());
            panIcon.add(icon);

        
        // nb Joueur
        JPanel nbJoueurPan = new JPanel();
        nbJoueurPan.setBackground(Color.white);
        nbJoueurPan.setBorder(BorderFactory.createTitledBorder("Nombre de joueur"));
        nbJoueurPan.setPreferredSize(new Dimension(300, 100));
        rnbJoueur2 = new JRadioButton("2");
        rnbJoueur2.setSelected(true);
        rnbJoueur3 = new JRadioButton("3");
        rnbJoueur4 = new JRadioButton("4");
        ButtonGroup btnGrJoueur = new ButtonGroup();
        btnGrJoueur.add(rnbJoueur2);
        btnGrJoueur.add(rnbJoueur3);
        btnGrJoueur.add(rnbJoueur4);
        nbJoueurPan.add(rnbJoueur2);
        nbJoueurPan.add(rnbJoueur3);
        nbJoueurPan.add(rnbJoueur4);

        // Pour chaque joueur il doit y avoir un nomLabel
        // nom Joueur
        JPanel nomPan = new JPanel();
        nomPan.setBackground(Color.white);
        nomPan.setPreferredSize(new Dimension(500, 100));
        nom1 = new JTextField();
        nom1.setPreferredSize(new Dimension(100, 25));
        nom2 = new JTextField();
        nom2.setPreferredSize(new Dimension(100, 25));
        nom3 = new JTextField();
        nom3.setPreferredSize(new Dimension(100, 25));
        nom4 = new JTextField();
        nom4.setPreferredSize(new Dimension(100, 25));
        nomPan.setBorder(BorderFactory.createTitledBorder("Nom du Joueur"));
        nomLabel = new JLabel("Saisir nom Joueur 1 : ");
        nomLabel2 = new JLabel("Saisir nom Joueur 2 : ");
        nomLabel3 = new JLabel("Saisir nom Joueur 3 : ");
        nomLabel4 = new JLabel("Saisir nom Joueur 4 : ");
        nomPan.add(nomLabel);
        nomPan.add(nom1);
        nomPan.add(nomLabel2);
        nomPan.add(nom2);
        nomPan.add(nomLabel3);
        nomPan.add(nom3);
        nomPan.add(nomLabel4);
        nomPan.add(nom4);

        // level
        JPanel levelPan = new JPanel();
        levelPan.setBackground(Color.white);
        levelPan.setBorder(BorderFactory.createTitledBorder("Niveau de difficulté"));
        levelPan.setPreferredSize(new Dimension(300, 100));
        levelNovice = new JRadioButton("Novice");
        levelNovice.setSelected(true);
        levelNormal = new JRadioButton("Normal");
        levelElite = new JRadioButton("Elite");
        levelLegendaire = new JRadioButton("Légendaire");
        levelMortel = new JRadioButton("Mortel");
        ButtonGroup btnGrLevel = new ButtonGroup();
        btnGrLevel.add(levelNovice);
        btnGrLevel.add(levelNormal);
        btnGrLevel.add(levelElite);
        btnGrLevel.add(levelLegendaire);
        levelPan.add(levelNovice);
        levelPan.add(levelNormal);
        levelPan.add(levelElite);
        levelPan.add(levelLegendaire);

        JPanel centre = new JPanel();
        centre.add(nbJoueurPan);
        centre.add(nomPan);
        centre.add(levelPan);

        //Lance Partie quand on clique dessus
        JButton btnStartGame = new JButton("A l'Aventure !");
        btnStartGame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

                m.type = TypesMessages.DEMARRER_PARTIE;
                m.setNbj(getnbJoueurs());
                m.getNomsJoueurs().add(nom1.getText());
                m.getNomsJoueurs().add(nom2.getText());
                m.getNomsJoueurs().add(nom3.getText());
                m.getNomsJoueurs().add(nom4.getText());
                observateur.traiterMessage(m);

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

        mainPanel.add(centre, BorderLayout.CENTER);
        levelPan.add(btnStartGame, BorderLayout.SOUTH);
        mainPanel.add(panIcon, BorderLayout.WEST);
        this.window.add(mainPanel);
    }

    public void afficher() {
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 420);
        window.setVisible(true);
    }

    public int getnbJoueurs() {
        if (rnbJoueur2.isSelected()) {
            return 2;
        } else if (rnbJoueur3.isSelected()) {
            return 3;
        } else if (rnbJoueur4.isSelected()) {
            return 4;
        } else {
            return 2;
        }

    }
}
