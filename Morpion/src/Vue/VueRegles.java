/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author domestit
 */
public class VueRegles {
    private final JFrame window;
    
    public VueRegles(){
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(700, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        window.setTitle("Tournoi de morpion : Regles");
        mainPanel.setBackground(Color.decode("#D3EBF2"));
        
        JPanel panelCentre = new JPanel(new GridLayout(1,3)) ;
        mainPanel.add(panelCentre, BorderLayout.NORTH);
        panelCentre.setBackground(Color.decode("#D3EBF2"));
        panelCentre.add(new JLabel("Le premier joueur à aligner le même symbole 3 fois remporte la partie"));
        panelCentre.add(new JLabel("Chaque match gagné rapportera 3 points au gagnant et 0 au perdant, en cas d'égalité les deux joueurs gagnent 1 points"));
        panelCentre.add(new JLabel("Le gagnant du tournoi est le joueur avec le plus de points ! "));
        
        
    }
}
