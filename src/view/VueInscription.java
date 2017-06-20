/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Princesse Mathilde
 */
public class VueInscription {

    private JFrame window;
    private JPanel mainPanel;
    
    
    
    public VueInscription()

    {

        this.window = new JFrame();
        window.setSize(1080, 720);

        window.setTitle("Demmarage partie");
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);
        
        
        

    }

}
