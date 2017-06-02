/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author benettim
 */
public class MonBouton extends JButton {

    private int petit;

    public void paintComponent(Graphics g) {
        Dimension dimension = getSize(); // Taille de la zone de dessin       

        g.setColor(Color.green);
        g.fillOval(dimension.width / 2 - getPetit() / 2, dimension.height / 2 - getPetit() / 2, getPetit(), getPetit());
        g.setColor(Color.black);

    }

    public int getPetit() {
        return petit;
    }

    //fonction qui détecte le plus petit côté et qui renvoie 90ù du petit 
    public void setPetit(Dimension dim) {
        if (dim.height < dim.width) {
            petit = dim.height / 100 * 90;
        } else {
            petit = dim.width / 100 * 90;

        }
    }
}
