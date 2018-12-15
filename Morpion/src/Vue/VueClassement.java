/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.EtatCase;
import Modèle.EtatTournoi;
import Modèle.Joueur;
import Modèle.Match;
import utilitaire.Actions;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import utilitaire.GestionVue;
import static utilitaire.GestionVue.Plus12;
import utilitaire.MessageClassement;
import utilitaire.MessageMenu;

/**
 *
 * @author domestit
 */
public class VueClassement extends Observable{
    
    private final JFrame window;
    private JPanel mainPanel;
    private JButton classementgeneral;
    private JButton btnretour;
    private JComboBox listeJoueur;
    private JPanel contentPanel;
    private JPanel bottomPanel;
    private JTable tableau;
    private  int[] nbPoints;
    
    @SuppressWarnings("empty-statement")
    public VueClassement(GestionVue v1,ArrayList<Joueur> listejoueur,HashMap<Integer,Match> matchs,EtatTournoi e1){
        if(v1 == Plus12 && e1 == EtatTournoi.Pas_Termine){
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
        
        contentPanel = new JPanel (new GridLayout(listejoueur.size()+1,3));
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.add(new JLabel("Nom du joueur"));
        contentPanel.add(new JLabel("Numero de place"));
        contentPanel.add(new JLabel("Nombre de points"));
       for(int i = 0;i < listejoueur.size();i++){
            JLabel place =  new JLabel("Place n°" + (i+1));
            JLabel nom = new JLabel(listejoueur.get(i).getNom());
            JLabel nbpoints = new JLabel(listejoueur.get(i).getNbpoints()+"");
            contentPanel.add(nom);
            contentPanel.add(place);
            contentPanel.add(nbpoints);
            if(i == 0){
                place.setOpaque(true);
                place.setBackground(Color.decode("#FFD700"));
                nom.setOpaque(true);
                nom.setBackground(Color.decode("#FFD700"));
                nbpoints.setOpaque(true);
                nbpoints.setBackground(Color.decode("#FFD700"));
            }
            else if(i == 1){
                place.setOpaque(true);
                place.setBackground(Color.decode("#c0c0c0"));
                nom.setOpaque(true);
                nom.setBackground(Color.decode("#c0c0c0"));
                nbpoints.setOpaque(true);
                nbpoints.setBackground(Color.decode("#c0c0c0"));
            }
            else if(i == 2){
                place.setOpaque(true);
                place.setBackground(Color.decode("#cd7f32"));
                nom.setOpaque(true);
                nom.setBackground(Color.decode("#cd7f32"));
                nbpoints.setOpaque(true);
                nbpoints.setBackground(Color.decode("#cd7f32"));
            }
            
        }
        bottomPanel = new JPanel(new GridLayout(1, 4));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(btnretour= new JButton("Retour"));
        btnretour.addActionListener((ActionEvent e) -> {
            setChanged();
            notifyObservers(new MessageClassement(v1,GestionVue.Menu));
            clearChanged();
        });
        bottomPanel.add(new JLabel(""));bottomPanel.add(new JLabel(""));bottomPanel.add(new JLabel(""));
        
        }
        else if(v1 == Plus12 && e1 == EtatTournoi.Termine){
            this.window = new JFrame();
        window.setSize(350, 200);
        //le titre = nom du joueur 
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(800, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setTitle("Fin de tournoi");
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);
        
        contentPanel = new JPanel (new GridLayout(listejoueur.size()+1,3));
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        contentPanel.add(new JLabel("Nom du joueur"));
        contentPanel.add(new JLabel("Numero de place"));
        contentPanel.add(new JLabel("Nombre de points"));
       for(int i = 0;i < listejoueur.size();i++){
            JLabel place =  new JLabel("Place n°" + (i+1));
            JLabel nom = new JLabel(listejoueur.get(i).getNom());
            JLabel nbpoints = new JLabel(listejoueur.get(i).getNbpoints()+"");
            contentPanel.add(nom);
            contentPanel.add(place);
            contentPanel.add(nbpoints);
            if(i == 0){
                place.setOpaque(true);
                place.setBackground(Color.decode("#FFD700"));
                nom.setOpaque(true);
                nom.setBackground(Color.decode("#FFD700"));
                nbpoints.setOpaque(true);
                nbpoints.setBackground(Color.decode("#FFD700"));
            }
            else if(i == 1){
                place.setOpaque(true);
                place.setBackground(Color.decode("#c0c0c0"));
                nom.setOpaque(true);
                nom.setBackground(Color.decode("#c0c0c0"));
                nbpoints.setOpaque(true);
                nbpoints.setBackground(Color.decode("#c0c0c0"));
            }
            else if(i == 2){
                place.setOpaque(true);
                place.setBackground(Color.decode("#cd7f32"));
                nom.setOpaque(true);
                nom.setBackground(Color.decode("#cd7f32"));
                nbpoints.setOpaque(true);
                nbpoints.setBackground(Color.decode("#cd7f32"));
            }  
        }
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

    public void close() {
        this.window.dispose();
    }
    
}
