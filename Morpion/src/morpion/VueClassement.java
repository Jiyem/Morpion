/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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
        window.setTitle("Classement : Base");
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);
        
        mainPanel.add(classementgeneral = new JButton("Classement general du tournoi"));
        classementgeneral.addActionListener((ActionEvent e) -> {
            setChanged();
            notifyObservers(Actions.CLASSEMENT_GENERAL);
            clearChanged();
        });
        
        contentPanel = new JPanel (new GridLayout(1,2));
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.
        contentPanel.add(listeJoueur = new JComboBox());
        
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }

    void close() {
        this.window.dispose();
    }
    
}
