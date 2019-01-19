/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import image.ImageContainer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import utilitaire.Actions;
import static utilitaire.GestionVue.Préparation;
import utilitaire.MessageRegles;

/**
 *
 * @author domestit
 */
public class VueRegles extends Observable{
    private final JFrame window;
    private JPanel bottomPanel;
    private JPanel panelCentre;
    private JButton btnretour;
    private ImageContainer imageBackground = new ImageContainer("morpion.png",0,0,0,0);
    
    public VueRegles(){
        window = new JFrame();
        window.setIconImage(imageBackground.getImage());
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(700, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        window.setTitle("Tournoi de morpion : Regles");
        
        
        panelCentre = new JPanel(new GridLayout(5,1)) ;
        mainPanel.add(panelCentre, BorderLayout.CENTER);
        panelCentre.setBackground(Color.decode("#FBEEE4"));
        panelCentre.add(new JLabel("Regle n°1 : Le premier joueur à aligner le même symbole 3 fois remporte la partie",SwingConstants.CENTER));
        panelCentre.add(new JLabel("Regle n°2 : Chaque match gagné rapportera 3 points au gagnant et 0 au perdant ",SwingConstants.CENTER));
        panelCentre.add(new JLabel("Regle n°3 : En cas d'égalité les deux joueurs gagnent 1 points",SwingConstants.CENTER));
        panelCentre.add(new JLabel("Regle n°4 : Le gagnant du tournoi est le joueur avec le plus de points ",SwingConstants.CENTER));
        panelCentre.add(new JLabel("Regle n°5 : Amusez vous bien ! ",SwingConstants.CENTER));
        
        bottomPanel = new JPanel(new GridLayout(1,4));
        bottomPanel.setBackground(Color.decode("#FBEEE4"));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(btnretour= new JButton("Retour"));
        btnretour.addActionListener((ActionEvent e) -> {
            setChanged();
            notifyObservers(new MessageRegles(Préparation));
            clearChanged();
            });
        btnretour.setBackground(Color.decode("#D73535"));
        btnretour.setForeground(Color.decode("#FFFFFF"));
        bottomPanel.add(new JLabel(""));bottomPanel.add(new JLabel(""));bottomPanel.add(new JLabel(""));
        
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }
}
