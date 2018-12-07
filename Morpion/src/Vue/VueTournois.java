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
import static utilitaire.GestionVue.Préparation;
import utilitaire.MessageTournois;

public class VueTournois extends Observable {
    private final JFrame window ;
    private GestionVue Mois12;
    private JTextField champNom;

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
        
        JButton btnMoins12 = new JButton("-12 ans");
        btnMoins12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers("-12");
                clearChanged();
            }
        });
        bottomPanel.add(btnMoins12);

        bottomPanel.add(new JLabel(""));

        JButton btnPlus12 = new JButton("+ 12 ans");
        btnPlus12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers("+12");
                clearChanged();
            }
        });
        bottomPanel.add(btnPlus12);
        }
        // Interface de moins de 12 ans !
        else if(v1 == Moins12){
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(800, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel panelHaut = new JPanel();
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        
        panelHaut.add(new JLabel("Nombre de joueurs : "));

        
        JPanel contentPanel = new JPanel ();
        mainPanel.add(contentPanel, BorderLayout.CENTER);
//        contentPanel.add(new JLabel("ici la barre (à ajouter)"));
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 20, 2);
        contentPanel.add(slider);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLabelTable(slider.createStandardLabels(2));
        
        
        JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        JButton btnStop = new JButton("Stop");
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
                clearChanged();
            }
        });
        bottomPanel.add(btnStop);

        bottomPanel.add(new JLabel(""));

        JButton btnFleche = new JButton("-->");
        btnFleche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Actions.ANNULE);
                clearChanged();
            }
        });
        bottomPanel.add(btnFleche);   
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
        
        JPanel panelHaut = new JPanel(new GridLayout(1,2)) ;
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        
        panelHaut.add(new JLabel("Nombre de joueurs"));
        JTextField nbJoueurs = new JTextField();
        panelHaut.add(nbJoueurs);
        
             
        JPanel bottomPanel = new JPanel(new GridLayout(1, 4));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
                clearChanged();
            }
        });
        bottomPanel.add(btnQuitter);


        JButton btnRegles = new JButton("Règles");
        btnRegles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Actions.ANNULE);
                clearChanged();
            }
        });
        bottomPanel.add(btnRegles);
        
        bottomPanel.add(new JLabel(""));
        
        JButton btnSuivant = new JButton("Suivant");
        btnSuivant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new MessageTournois(nbJoueurs.getText(),Actions.SUIVENT));
                clearChanged();
            }
        });
        bottomPanel.add(btnSuivant);
        }
        
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }
    
    public void show(int nbJoueur){
        champNom.setText("Joueur n°"+nbJoueur);
//        champPrenom.setText();
//        champAge.setText();
//        radioHomme.setSelected();
//        radioFemme.setSelected();
    }
    
}
