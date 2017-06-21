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
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Princesse Mathilde
 */
public class VueAutresJoueurs {
     private JPanel joueurPan;
     private JLabel  nomJoueurLab;
     
     
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
          nomRolePan.add(nomJoueurLab);
          joueurPan.add(nomRolePan, BorderLayout.NORTH);
          
          
          JPanel lesCartesPan = new JPanel();
          lesCartesPan.setBackground(Color.white);
          // là faudra rajouter les cartes au panel.
          joueurPan.add(lesCartesPan, BorderLayout.CENTER);
          
          
          JPanel lesTrésorsPan = new JPanel();
          lesTrésorsPan.setBackground(Color.white);
          //Rajouter trésors si posseder.
          
          joueurPan.add(lesTrésorsPan, BorderLayout.EAST);
          
          
          
          
          
          
          
               
}
    
}
