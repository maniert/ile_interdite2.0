/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import PasDefaultPackage.TypeCarte;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JPanel;
/**
 *
 * @author Princesse Mathilde
 */
public class Tresor extends JPanel {
    


    private TypeCarte tresor;
    private Color couleur;

    public Tresor(TypeCarte tresor, Color couleur) {
        this.tresor = tresor;
        this.couleur = couleur;
        setOpaque(false);
        // Plusieurs pion de différente couleur
        setForeground(couleur);
    }

    // Fais les pions (ou les montres du moins)
    @Override
    public void paintComponent(Graphics g) {
        Paint paint;
        Graphics2D g2d;
        if (g instanceof Graphics2D) {
            g2d = (Graphics2D) g;
        } else {
            System.out.println("Oups");
            return;
        }
        paint = new GradientPaint(0, 0, getForeground(), getWidth(), getHeight(), getBackground());
        g2d.setPaint(paint);
            g.fillRect( 65, 65, getWidth(), getHeight());     //une en dessous, alligné avec les autres 
            g.setColor(Color.BLACK);
            g.drawRect(65, 65, getWidth(), getHeight());
            
            
       

    }

    public TypeCarte getCouleur() {
        return tresor;
    }

}

