/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import PasDefaultPackage.Observateur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Princesse Mathilde
 */
public class VueInscription {

    private JFrame window;
    private JPanel mainPanel;
    
    // nb Joueur
    private JRadioButton nbJoueur, nbJoueur2, nbJoueur3, nbJoueur4;
            
    // nom
    private JTextField nom;
    private JLabel nomLabel;

    // 
    private JRadioButton level, levelNovice, levelNormal, levelElite, levelLegendaire;

    private Observateur observateur;

    public VueInscription() {
        this.window = new JFrame();
      
        
        window.setTitle("Demarrage partie");
        mainPanel = new JPanel(new BorderLayout());
        
        mainPanel.setBackground(new Color(230, 0, 155));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.PINK, 2));     
        
        // nb Joueur
        JPanel nbJoueurPan = new JPanel();
        nbJoueurPan.setBackground(Color.white);
        nbJoueurPan.setBorder(BorderFactory.createTitledBorder("Nombre de joueur"));
        nbJoueurPan.setPreferredSize(new Dimension(300,100));
        nbJoueur2 = new JRadioButton("2");
        nbJoueur2.setSelected(true);
        nbJoueur3 = new JRadioButton("3");
        nbJoueur4 = new JRadioButton("4");
        ButtonGroup btnGrJoueur = new ButtonGroup();
        btnGrJoueur.add(nbJoueur2);
        btnGrJoueur.add(nbJoueur3);
        btnGrJoueur.add(nbJoueur4);
        nbJoueurPan.add(nbJoueur2);
        nbJoueurPan.add(nbJoueur3);
        nbJoueurPan.add(nbJoueur4);
        
        // Pour chaque joueur il doit y avoir un nomLabel
        // nom Joueur
        JPanel nomPan = new JPanel();
        nomPan.setBackground(Color.white);
        nomPan.setPreferredSize(new Dimension(300, 100));
        nom = new JTextField();
        nom.setPreferredSize(new Dimension(100, 25));
        nomPan.setBorder(BorderFactory.createTitledBorder("Nom du Joueur"));
        nomLabel = new JLabel("Saisir un nom : ");
        nomPan.add(nomLabel);
        nomPan.add(nom);

        // level 
        JPanel levelPan = new JPanel();
        levelPan.setBackground(Color.white);
        levelPan.setBorder(BorderFactory.createTitledBorder("Niveau de difficulté"));
        levelPan.setPreferredSize(new Dimension(300,100));
        levelNovice = new JRadioButton("Novice");
        levelNovice.setSelected(true);
        levelNormal = new JRadioButton("Normal");
        levelElite = new JRadioButton("Elite");
        levelLegendaire = new JRadioButton("Légendaire");
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
        
        JButton btnStartGame = new JButton("A l'Aventure !");
        
        mainPanel.add(centre, BorderLayout.CENTER);
        mainPanel.add(btnStartGame, BorderLayout.SOUTH);
        this.window.add(mainPanel);
    
     
    }
     public void afficher() {
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 150);
        window.setVisible(true);                        
    }
}
