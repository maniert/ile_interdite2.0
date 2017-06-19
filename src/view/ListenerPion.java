/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author benettim
 */
import PasDefaultPackage.Grille;
import PasDefaultPackage.Aventurier;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ListenerPion implements MouseListener {
    
    private VueAventurier plateau;
    private Pion pion;
    private Grille g;
    
    public ListenerPion(Pion pion,VueAventurier plateau){
        this.plateau=plateau;
        this.pion=pion;
    }

    public void mouseClicked(MouseEvent arg0) {
        
    }

    public void mouseEntered(MouseEvent arg0) {
    
    }

    public void mouseExited(MouseEvent arg0) {
        
    }

        // Affiche les possibilité
    public void mousePressed(MouseEvent arg0) {
     //  plateau.deplacementPossiblebasique(pion);
    }

    
    
    public void mouseReleased(MouseEvent arg0) {
        
    }

}
