/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

import morpion.utilitaires.Actions;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import morpion.utilitaires.GestionVue;
import static morpion.utilitaires.GestionVue.Préparation;

/**
 *
 * @author Eric
 */
public class VueTournois extends Observable {
    private final JFrame window ;
    private final JButton btnValider ;
    private final JButton btnAnnuler ;
//    private String nom;
//    private String prenom;
//    private Genres genre;
//    private Integer age;
    private GestionVue Mois12;

    @SuppressWarnings("Convert2Lambda")
    public VueTournois(GestionVue v1) {
        if(v1 == Préparation){
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(800, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel panelHaut = new JPanel(new GridLayout(2,3)) ;
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        
        panelHaut.add(new JLabel(""));
        panelHaut.add(new JLabel("Bienvenue dans le fabuleux"));
        panelHaut.add(new JLabel(""));
        panelHaut.add(new JLabel(""));
        panelHaut.add(new JLabel("jeu de morpion !"));
        panelHaut.add(new JLabel(""));
        
        JPanel contentPanel = new JPanel (new GridLayout(1, 3));
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.add(new JLabel(""));
        contentPanel.add(new JLabel("Vous avez ?"));
        contentPanel.add(new JLabel(""));
        
        
        JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        btnValider = new JButton("-12 ans");
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
                clearChanged();
            }
        });
        bottomPanel.add(btnValider);

        bottomPanel.add(new JLabel(""));

        btnAnnuler = new JButton("+ 12 ans");
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Actions.ANNULE);
                clearChanged();
            }
        });
        bottomPanel.add(btnAnnuler);
        }
        // Interface de moins de 12 ans !
        else if(v1 == Mois12){
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(800, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel panelHaut = new JPanel(new GridLayout(2,3)) ;
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        
        panelHaut.add(new JLabel(""));
        panelHaut.add(new JLabel("Bienvenue dans le fabuleux"));
        panelHaut.add(new JLabel(""));
        panelHaut.add(new JLabel(""));
        panelHaut.add(new JLabel("jeu de morpion !"));
        panelHaut.add(new JLabel(""));
        
        JPanel contentPanel = new JPanel (new GridLayout(1, 3));
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.add(new JLabel(""));
        contentPanel.add(new JLabel("Vous avez ?"));
        contentPanel.add(new JLabel(""));
        
        
        JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        btnValider = new JButton("-12 ans");
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
                clearChanged();
            }
        });
        bottomPanel.add(btnValider);

        bottomPanel.add(new JLabel(""));

        btnAnnuler = new JButton("+ 12 ans");
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Actions.ANNULE);
                clearChanged();
            }
        });
        bottomPanel.add(btnAnnuler);   
        }
        
        //Interface pour plus de 12 ans !
        else{
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(800, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel panelHaut = new JPanel(new GridLayout(2,3)) ;
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        
        panelHaut.add(new JLabel(""));
        panelHaut.add(new JLabel("Bienvenue dans le fabuleux"));
        panelHaut.add(new JLabel(""));
        panelHaut.add(new JLabel(""));
        panelHaut.add(new JLabel("jeu de morpion !"));
        panelHaut.add(new JLabel(""));
        
        JPanel contentPanel = new JPanel (new GridLayout(1, 3));
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.add(new JLabel(""));
        contentPanel.add(new JLabel("Vous avez ?"));
        contentPanel.add(new JLabel(""));
        
        
        JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        btnValider = new JButton("-12 ans");
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
                clearChanged();
            }
        });
        bottomPanel.add(btnValider);

        bottomPanel.add(new JLabel(""));

        btnAnnuler = new JButton("+ 12 ans");
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Actions.ANNULE);
                clearChanged();
            }
        });
        bottomPanel.add(btnAnnuler);
            
        }
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }

    void close() {
        this.window.dispose();
    }
    
    public void show(){
//        champNom.setText();
//        champPrenom.setText();
//        champAge.setText();
//        radioHomme.setSelected();
//        radioFemme.setSelected();
    }
    
}
