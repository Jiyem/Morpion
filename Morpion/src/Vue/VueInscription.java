/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import utilitaire.Actions;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.PopupMenu;
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
import javax.swing.JSlider;
import javax.swing.JTextField;
import utilitaire.GestionVue;
import static utilitaire.GestionVue.Moins12;
import static utilitaire.GestionVue.Plus12;
import static utilitaire.GestionVue.PremierInscrit;
import static utilitaire.GestionVue.Préparation;
import utilitaire.MessageTournois;

/**
 *
 * @author anandanj
 */
public class VueInscription extends Observable {
    private final JFrame window ;
    private JLabel numJoueur;
    
    //Vue pour le premier joueur
    public VueInscription(GestionVue message){
        if(message == PremierInscrit){
            //Interface pour l'initialisation des joueurs
            window = new JFrame();
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
            JPanel mainPanel = new JPanel(new BorderLayout());
            window.add(mainPanel) ;
        
            JPanel panelHaut = new JPanel() ;
            mainPanel.add(panelHaut, BorderLayout.NORTH);
        
            numJoueur = new JLabel();
            numJoueur.setBackground(Color.getColor("#FEFEFE"));
            panelHaut.add(numJoueur);
            panelHaut.setBackground(Color.decode("#046380"));
        
            JPanel panelMid = new JPanel(new GridLayout(6,4));
            mainPanel.add(panelMid, BorderLayout.CENTER);
            for(int i = 0;i < 9;i++){
                panelMid.add(new JLabel(""));
            }
            JLabel pseudoJoueurL = new JLabel("Pseudo du joueur");
            pseudoJoueurL.setForeground(Color.getColor("#FEFEFE"));
            panelMid.add(pseudoJoueurL);
            JTextField pseudoJoueur = new JTextField();
            panelMid.add(pseudoJoueur);
            panelMid.setBackground(Color.decode("#046380"));
            for(int i = 0;i < 9;i++){
                panelMid.add(new JLabel(""));
            } 
        
             
            JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
            bottomPanel.setBackground(Color.decode("#046380"));
            mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
            JButton btnQuitter = new JButton("Quitter");
            btnQuitter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Actions.ANNULE);
                    clearChanged();
                }
            });
            bottomPanel.add(btnQuitter);
            btnQuitter.setBackground(Color.decode("#D73535"));
        
            JButton btnSuivant = new JButton("Suivant");
            btnSuivant.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageTournois(pseudoJoueur.getText(),Actions.JSUIVANT));
                    clearChanged();
                }
            });
            bottomPanel.add(btnSuivant);
            btnSuivant.setBackground(Color.decode("#2FB94F"));
            }
        else{
            //Interface pour l'initialisation des joueurs
            window = new JFrame();
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
            JPanel mainPanel = new JPanel(new BorderLayout());
            window.add(mainPanel) ;
        
            JPanel panelHaut = new JPanel() ;
            mainPanel.add(panelHaut, BorderLayout.NORTH);
            panelHaut.setBackground(Color.decode("#046380"));
        
            numJoueur = new JLabel();
            panelHaut.add(numJoueur);
        
            JPanel panelMid = new JPanel(new GridLayout(6,4));
            mainPanel.add(panelMid, BorderLayout.CENTER);
            for(int i = 0;i < 9;i++){
                panelMid.add(new JLabel(""));
            }
            JLabel pseudoJoueurL = new JLabel("Pseudo du joueur");
            pseudoJoueurL.setForeground(Color.getColor("#FEFEFE"));
            panelMid.add(pseudoJoueurL);
            JTextField pseudoJoueur = new JTextField();
            panelMid.add(pseudoJoueur);
            for(int i = 0;i < 9;i++){
                panelMid.add(new JLabel(""));
            } 
            panelMid.setBackground(Color.decode("#046380"));
    
            JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
            mainPanel.add(bottomPanel, BorderLayout.SOUTH);
            bottomPanel.setBackground(Color.decode("#046380"));
        
            JButton btnQuitter = new JButton("Précédent");
            btnQuitter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageTournois(pseudoJoueur.getText(),Actions.JPRECEDENT));
                    clearChanged();
                }
            });
            bottomPanel.add(btnQuitter);
            btnQuitter.setBackground(Color.decode("#D73535"));
        
            JButton btnSuivant = new JButton("Terminer");
            btnSuivant.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageTournois(pseudoJoueur.getText(),Actions.JTERMINER,GestionVue.Menu));
                    clearChanged();
             }
        });
        bottomPanel.add(btnSuivant);
        btnSuivant.setBackground(Color.decode("#2FB94F"));
        }
    }
    
    //Vue pour les joueurs suivants
    public VueInscription(){
        //Interface pour l'initialisation des joueurs
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(800, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel panelHaut = new JPanel() ;
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        panelHaut.setBackground(Color.decode("#046380"));
        
        numJoueur = new JLabel();
        numJoueur.setBackground(Color.getColor("#FEFEFE"));
        panelHaut.add(numJoueur);
        
        JPanel panelMid = new JPanel(new GridLayout(6,4));
        mainPanel.add(panelMid, BorderLayout.CENTER);
        for(int i = 0;i < 9;i++){
            panelMid.add(new JLabel(""));
        }
        JLabel pseudoJoueurL = new JLabel("Pseudo du joueur");
        pseudoJoueurL.setForeground(Color.getColor("#FEFEFE"));
        panelMid.add(pseudoJoueurL);
        JTextField pseudoJoueur = new JTextField();
        panelMid.add(pseudoJoueur);
        for(int i = 0;i < 9;i++){
            panelMid.add(new JLabel(""));
        } 
        panelMid.setBackground(Color.decode("#046380"));
    
        JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setBackground(Color.decode("#046380"));
        
        JButton btnQuitter = new JButton("Précédent");
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new MessageTournois(pseudoJoueur.getText(),Actions.JPRECEDENT));
                clearChanged();
            }
        });
        bottomPanel.add(btnQuitter);
        btnQuitter.setBackground(Color.decode("#D73535"));
        
        JButton btnSuivant = new JButton("Suivant");
        btnSuivant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new MessageTournois(pseudoJoueur.getText(),Actions.JSUIVANT));
                clearChanged();
            }
        });
        bottomPanel.add(btnSuivant);
        btnSuivant.setBackground(Color.decode("#2FB94F"));
        }
    
    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }
    
    public void show(int nbJoueur){
        numJoueur.setText("Joueur n°"+nbJoueur);
        numJoueur.setForeground(Color.getColor("#FEFEFE"));
//        champPrenom.setText();
//        champAge.setText();
//        radioHomme.setSelected();
//        radioFemme.setS
    
    
    }

}


        

