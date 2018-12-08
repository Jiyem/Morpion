/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import utilitaire.Actions;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author domestit
 */
public class VueClassement extends Observable{
    
    private final JFrame window;
    private JPanel mainPanel;
    private final JButton classementgeneral;
    private final JComboBox listeJoueur;
    private JPanel contentPanel;
    
    public VueClassement(){
        this.window = new JFrame();
        window.setSize(350, 200);
        //le titre = nom du joueur 
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(800, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setTitle("Classement : Base");
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);
        
        contentPanel = new JPanel (new GridLayout(3,3));
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.add(new JLabel(""));contentPanel.add(new JLabel(""));contentPanel.add(new JLabel(""));
        
        
        contentPanel.add(classementgeneral = new JButton("Classement general du tournoi"));
        classementgeneral.addActionListener((ActionEvent e) -> {
            setChanged();
            notifyObservers(Actions.CLASSEMENT_GENERAL);
            clearChanged();
        });
        
        contentPanel.add(new JLabel(""));
        contentPanel.add(listeJoueur = new JComboBox());
        
        contentPanel.add(new JLabel(""));contentPanel.add(new JLabel(""));contentPanel.add(new JLabel(""));
        
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }

    void close() {
        this.window.dispose();
    }
    
}
