/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

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

/**
 *
 * @author Eric
 */
public class VueTournois extends Observable {
    private final JFrame window ;
    private final JTextField champNom;
    private final JTextField champPrenom;
    private final JTextField champAge;
    private final JRadioButton radioHomme;
    private final JRadioButton radioFemme;
    private final JButton btnValider ;
    private final JButton btnAnnuler ;
//    private String nom;
//    private String prenom;
//    private Genres genre;
//    private Integer age;

    @SuppressWarnings("Convert2Lambda")
    public VueTournois() {
//        this.nom = nom;
//        this.prenom = prenom;
//        this.genre = genre;
//        this.age = age;
        
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(300, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel contentPanel = new JPanel (new GridLayout(5, 2));
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        contentPanel.add(new JLabel("Nom :"));
        champNom = new JTextField();
        contentPanel.add(champNom);
        
        contentPanel.add(new JLabel("Prénom :"));
        champPrenom = new JTextField();
        contentPanel.add(champPrenom);
        
        contentPanel.add(new JLabel("Age : "));
        champAge = new JTextField();
        contentPanel.add(champAge);
        
        contentPanel.add(new JLabel("Genre :"));
        ButtonGroup radioGroupGenre = new ButtonGroup();

        radioHomme = new JRadioButton("Homme");
        contentPanel.add(radioHomme);
        radioGroupGenre.add(radioHomme) ;
        
        contentPanel.add(new JLabel(""));

        radioFemme = new JRadioButton("Femme");
        contentPanel.add(radioFemme);
        radioGroupGenre.add(radioFemme) ;
        
        JPanel bottomPanel = new JPanel(new GridLayout(1, 3));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        btnValider = new JButton("Valider");
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

        btnAnnuler = new JButton("Annuler");
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
