/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.EtatTournoi;
import utilitaire.Actions;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
    private JLabel erreur = new JLabel("");
    
    //Vue pour le premier joueur
    public VueInscription(int nbJoueurs,GestionVue vAge){
            ArrayList<JTextField> flag = new ArrayList<>();
            
            if(vAge == GestionVue.Plus12){
                window = new JFrame();
                window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                // Définit la taille de la fenêtre en pixels
                window.setSize(800, 300);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
                window.setTitle("Tournoi morpion : Inscription des joueurs");
                JPanel mainPanel = new JPanel(new BorderLayout());
                mainPanel.setBackground(Color.decode("#FBEEE4"));
                window.add(mainPanel) ;
                mainPanel.add(new JLabel("Inscription des joueurs :",SwingConstants.CENTER),BorderLayout.NORTH);
                JPanel midPanel = new JPanel(new GridLayout(nbJoueurs,2));
                mainPanel.add(midPanel,BorderLayout.CENTER);
                midPanel.setBackground(Color.decode("#FBEEE4"));
                for(int i = 0;i<nbJoueurs;i++){
                    midPanel.add(new JLabel("Pseudo du joueur "+(i+1)+" :",SwingConstants.CENTER));
                    JTextField saisie  = new JTextField();
                    flag.add(saisie);
                    midPanel.add(flag.get(i));
                }
                JPanel botPanel = new JPanel(new GridLayout(1,4));
                mainPanel.add(botPanel,BorderLayout.SOUTH);
                botPanel.setBackground(Color.decode("#FBEEE4"));
                JButton btnQuitter = new JButton("Quitter");
                btnQuitter.setBackground(Color.decode("#D73535"));
                btnQuitter.setForeground(Color.decode("#FFFFFF"));
                btnQuitter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(Actions.ANNULE);
                        clearChanged();
                    }
                });
                JButton btnSuivant = new JButton("Suivant");
                btnSuivant.setBackground(Color.decode("#008000"));
                btnSuivant.setForeground(Color.decode("#FFFFFF"));
                btnSuivant.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        ArrayList<String> pseudos = new ArrayList<>();
                        for(int i =0;i<flag.size();i++){
                            pseudos.add(flag.get(i).getText());
                        }
                        notifyObservers(new MessageTournois(pseudos,Actions.JTERMINER));
                        clearChanged();
                    }
                });
                botPanel.add(btnQuitter);
                botPanel.add(new JLabel(""));
                botPanel.add(new JLabel(""));
                botPanel.add(btnSuivant);
            }
            else{
                window = new JFrame();
                window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                // Définit la taille de la fenêtre en pixels
                window.setSize(800, 300);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
                window.setTitle("Tournoi morpion : Inscription des joueurs");
                JPanel mainPanel = new JPanel(new BorderLayout());
                window.add(mainPanel) ;
                mainPanel.add(new JLabel("Inscription des joueurs :",SwingConstants.CENTER),BorderLayout.NORTH);
                JPanel midPanel = new JPanel(new GridLayout(nbJoueurs,2));
                mainPanel.setBackground(Color.decode("#98FB98"));
                mainPanel.add(midPanel,BorderLayout.CENTER);
                midPanel.setBackground(Color.decode("#98FB98"));
                for(int i = 0;i<nbJoueurs;i++){
                    midPanel.add(new JLabel("Pseudo du joueur "+(i+1)+" :",SwingConstants.CENTER));
                    JTextField saisie  = new JTextField();
                    flag.add(saisie);
                    midPanel.add(flag.get(i));
                }
                JPanel botPanel = new JPanel(new GridLayout(1,4));
                mainPanel.add(botPanel,BorderLayout.SOUTH);
                botPanel.setBackground(Color.decode("#98FB98"));
                JButton btnQuitter = new JButton("Quitter");
                btnQuitter.setBackground(Color.decode("#D73535"));
                btnQuitter.setForeground(Color.decode("#FFFFFF"));
                btnQuitter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(Actions.ANNULE);
                        clearChanged();
                    }
                });
                JButton btnSuivant = new JButton("->");
                btnSuivant.setBackground(Color.decode("#008000"));
                btnSuivant.setForeground(Color.decode("#FFFFFF"));
                btnSuivant.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        ArrayList<String> pseudos = new ArrayList<>();
                        for(int i =0;i<flag.size();i++){
                            pseudos.add(flag.get(i).getText());
                        }
                        notifyObservers(new MessageTournois(pseudos,Actions.JTERMINER));
                        clearChanged();
                    }
                });
                botPanel.add(btnQuitter);
                botPanel.add(new JLabel(""));
                botPanel.add(new JLabel(""));
                botPanel.add(btnSuivant);        
            }        
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }
    
    public void erreurIdentique(){
        erreur.setText("Erreur : deux pseudo identique.");
    }
    
    public void erreurVide(){
        erreur.setText("Erreur : pseudo vide.");
    }

}


        

