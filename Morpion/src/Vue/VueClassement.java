/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.EtatCase;
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
import utilitaire.GestionVue;
import static utilitaire.GestionVue.Plus12;

/**
 *
 * @author domestit
 */
public class VueClassement extends Observable{
    
    private final JFrame window;
    private JPanel mainPanel;
    private JButton classementgeneral;
    private JButton btnretour;
    private  JComboBox listeJoueur;
    private JPanel contentPanel;
    private JPanel bottomPanel;
    private JFrame tableau;
    
    public VueClassement(GestionVue v1){
        if(v1 == Plus12){
        this.window = new JFrame();
        window.setSize(350, 200);
        //le titre = nom du joueur 
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(800, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setTitle("Classement : Plus de 12 ans");
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);
        
        contentPanel = new JPanel (new GridLayout(3,3));
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.add(new JLabel(""));contentPanel.add(new JLabel(""));contentPanel.add(new JLabel(""));
        contentPanel.add(classementgeneral = new JButton("Classement general"));
        classementgeneral.addActionListener((ActionEvent e) -> {
            setChanged();
            notifyObservers(Actions.CLASSEMENT_GENERAL);
            clearChanged();
        });
        contentPanel.add(new JLabel(""));
        contentPanel.add(listeJoueur = new JComboBox());
        contentPanel.add(new JLabel(""));contentPanel.add(new JLabel(""));contentPanel.add(new JLabel(""));
        
        bottomPanel = new JPanel(new GridLayout(1, 4));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(btnretour= new JButton("Retour"));
        btnretour.addActionListener((ActionEvent e) -> {
            setChanged();
            notifyObservers(Actions.RETOUR);
            clearChanged();
        });
        bottomPanel.add(new JLabel(""));bottomPanel.add(new JLabel(""));bottomPanel.add(new JLabel(""));
        
        }
        else{
            this.window = new JFrame();
            window.setSize(350, 200);
            //le titre = nom du joueur 
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
            window.setTitle("Classement : Moins de 12 ans");
            mainPanel = new JPanel(new BorderLayout());
            this.window.add(mainPanel);

            contentPanel = new JPanel (new GridLayout(1,1));
            
            tableau = new JFrame();
            
            bottomPanel = new JPanel(new GridLayout(1, 4));
            mainPanel.add(bottomPanel, BorderLayout.SOUTH);
            bottomPanel.add(btnretour= new JButton("Retour"));
            btnretour.addActionListener((ActionEvent e) -> {
            setChanged();
            notifyObservers(Actions.RETOUR);
            clearChanged();
            });
            bottomPanel.add(new JLabel(""));bottomPanel.add(new JLabel(""));bottomPanel.add(new JLabel(""));
            }}
            
    
    public void afficher(){
        this.window.setVisible(true);
    }

    void close() {
        this.window.dispose();
    }
    
}
