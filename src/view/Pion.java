/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import PasDefaultPackage.TypeRole;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JPanel;

/**
 *
 * @author benettim
 */
public class Pion extends JPanel {

    private TypeRole role;
    private Color couleur;
    private boolean monte;

    public Pion(TypeRole role, Color couleur, boolean monte) {
        this.monte = monte;
        this.role = role;
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
            System.out.println("Error");
            return;
        }
        paint = new GradientPaint(0, 0, getBackground(), getWidth(), getHeight(), getForeground());
        g2d.setPaint(paint);
        g.fillOval(5, 5, getWidth() - 25, getHeight() - 10);

    }

    public TypeRole getCouleur() {
        return role;
    }

    public boolean isMonte() {
        return monte;
    }

    public void setMonte(boolean monte) {
        this.monte = monte;
    }

}
