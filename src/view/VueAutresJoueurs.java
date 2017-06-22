/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import PasDefaultPackage.Message;
import PasDefaultPackage.Observateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.Parameters;

/**
 *
 * @author Princesse Mathilde
 */
public class VueAutresJoueurs extends  JPanel {
     private JPanel joueurPan;
     private JLabel  nomJoueurLab;
     private JButton[] btnMainAutresJoueurs = new JButton[15];
     private JPanel mainAutresJoueurs;
     
     
    private Observateur observateur;
    private Message m;
     
        public VueAutresJoueurs(Observateur o) {
          /*  Nom Joueur + Role
                Ses cartes  / Ses Trésors possédés
             
            */
          
          this.observateur = o;
          m = new Message();
          
          // Panel qui contiendra les autres.
          joueurPan = new JPanel(new BorderLayout());
          joueurPan.setBackground(Color.yellow);
          joueurPan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
          joueurPan.setSize(new Dimension(500,500));
          
          //Je veux des cartes mais sur quoi je les veux ? boutons ? Image ? Panel ? 
          // Façon je les met dans un panel les 5 ou + comme ça hop hop 
          
          JPanel nomRolePan = new JPanel();
          nomRolePan.setBackground(Color.white);
          //nomJoueurLab = new JLabel(.getNomsJoueurs()); // nom Joueur + role
//          nomRolePan.add(nomJoueurLab);
         // joueurPan.add(nomRolePan, BorderLayout.NORTH);
          
          
          JPanel lesCartesPan = new JPanel();
          lesCartesPan.setBackground(Color.white);
          // là faudra rajouter les cartes au panel.
          joueurPan.add(lesCartesPan, BorderLayout.CENTER);
          
           this.mainAutresJoueurs = new JPanel(new GridLayout(3, 5));
        this.mainAutresJoueurs.setOpaque(false);
        joueurPan.add(this.mainAutresJoueurs, BorderLayout.WEST);
        for (int i = 0; i <= 5; i++) {
            btnMainAutresJoueurs[i] = new JButton();
            btnMainAutresJoueurs[i].setName(Integer.toString(i));
            mainAutresJoueurs.add(btnMainAutresJoueurs[i]);
        } 
          
          
          JPanel lesTrésorsPan = new JPanel();
          lesTrésorsPan.setBackground(Color.white);
          //Rajouter trésors si posseder.
                 
          joueurPan.add(lesTrésorsPan, BorderLayout.EAST);
          this.add(joueurPan);
          
          
          
          
          
          
          
          
               
}
    
}
