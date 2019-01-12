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
    public VueInscription(int nbJoueurs){
            ArrayList<JTextField> flag = new ArrayList<>();
            
            
            window = new JFrame();
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
            window.setTitle("Tournoi morpion : Inscription des joueurs");
            JPanel mainPanel = new JPanel(new BorderLayout());
            window.add(mainPanel) ;
            mainPanel.add(new JLabel("Inscription des joueurs :"),BorderLayout.NORTH);
            JPanel midPanel = new JPanel(new GridLayout(nbJoueurs,2));
            mainPanel.add(midPanel,BorderLayout.CENTER);
            for(int i = 0;i<nbJoueurs;i++){
                midPanel.add(new JLabel("Pseudo du joueur "+(i+1)+" :"));
                JTextField saisie  = new JTextField();
                flag.add(saisie);
                midPanel.add(flag.get(i));
            }
            JPanel botPanel = new JPanel(new GridLayout(1,3));
            mainPanel.add(botPanel,BorderLayout.SOUTH);
            JButton btnQuitter = new JButton("Quitter");
            btnQuitter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Actions.ANNULE);
                    clearChanged();
                }
            });
            JButton btnSuivant = new JButton("Suivant");
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
            botPanel.add(erreur);
            botPanel.add(btnSuivant);
            
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


        

