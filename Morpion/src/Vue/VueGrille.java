/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.EtatCase;
import static Modèle.EtatCase.X;
import Modèle.EtatMatch;
import static Modèle.EtatMatch.Egalite;
import static Modèle.EtatMatch.Pas_Termine;
import static Modèle.EtatMatch.Victoire;
import Modèle.Joueur;
import image.ImageContainer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import utilitaire.Actions;
import utilitaire.GestionVue;
import utilitaire.MessageDuel;
import utilitaire.MessageGrille;
import utilitaire.MessageSolo;

/**
 *
 * @author Jiyem
 */
public class VueGrille extends Observable {

    private HashMap<Integer, EtatCase> grille = new HashMap<>();
    private final JFrame window;
    private GestionVue vAge;
    private JLabel joueurCourant;
    private JButton bouton1;
    private JButton bouton2;
    private JButton bouton3;
    private JButton bouton4;
    private JButton bouton5;
    private JButton bouton6;
    private JButton bouton7;
    private JButton bouton8;
    private JButton bouton9;
    private Integer numJoueur;
    private ImageContainer imageBackground = new ImageContainer("morpion.png",0,0,0,0);

    public VueGrille(int numMatch, Joueur joueur1, Joueur joueur2,GestionVue vAge) {
        this.vAge = vAge;
        if(vAge == GestionVue.Plus12){
            window = new JFrame();
            window.setIconImage(imageBackground.getImage());
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
            window.setTitle("Tournoi de morpion : match numero " + numMatch + " : " + joueur1.getNom() + " contre " + joueur2.getNom());
            JPanel mainPanel = new JPanel(new BorderLayout());
            window.add(mainPanel);

            JPanel panelHaut = new JPanel(new GridLayout(2, 3));
            mainPanel.add(panelHaut, BorderLayout.NORTH);
            panelHaut.setBackground(Color.decode("#FBEEE4"));
            panelHaut.add(new JLabel(joueur1.getNom(),SwingConstants.CENTER));
            joueurCourant = new JLabel("C'est au tour de " + joueur1.getNom(),SwingConstants.CENTER);
            panelHaut.add(joueurCourant);
            panelHaut.add(new JLabel(joueur2.getNom(),SwingConstants.CENTER));
            panelHaut.add(new JLabel("Signe: X",SwingConstants.CENTER));
            panelHaut.add(new JLabel(""));
            panelHaut.add(new JLabel("Signe: O",SwingConstants.CENTER));



            JPanel panelMid = new JPanel(new GridLayout(3, 3));
            panelMid.setBackground(Color.decode("#FBEEE4"));
            mainPanel.add(panelMid, BorderLayout.CENTER);

            //Création des boutons du morpion !
            bouton1 = new JButton("");
            bouton1.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton1.setFont(new Font("Arial",Font.PLAIN,50));
            bouton1.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton1);
            grille.put(1, EtatCase.NON_COCHEE);

            bouton2 = new JButton("");
            bouton2.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton2.setFont(new Font("Arial",Font.PLAIN,50));
            bouton2.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton2);
            grille.put(2, EtatCase.NON_COCHEE);

            bouton3 = new JButton("");
            bouton3.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton3.setFont(new Font("Arial",Font.PLAIN,50));
            bouton3.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton3);
            grille.put(3, EtatCase.NON_COCHEE);

            bouton4 = new JButton("");
            bouton4.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton4.setFont(new Font("Arial",Font.PLAIN,50));
            bouton4.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton4);
            grille.put(4, EtatCase.NON_COCHEE);

            bouton5 = new JButton("");
            bouton5.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton5.setFont(new Font("Arial",Font.PLAIN,50));
            bouton5.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton5);
            grille.put(5, EtatCase.NON_COCHEE);

            bouton6 = new JButton("");
            bouton6.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton6.setFont(new Font("Arial",Font.PLAIN,50));
            bouton6.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton6);
            grille.put(6, EtatCase.NON_COCHEE);

            bouton7 = new JButton("");
            bouton7.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton7.setFont(new Font("Arial",Font.PLAIN,50));
            bouton7.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton7);
            grille.put(7, EtatCase.NON_COCHEE);

            bouton8 = new JButton("");
            bouton8.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton8.setFont(new Font("Arial",Font.PLAIN,50));
            bouton8.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton8);
            grille.put(8, EtatCase.NON_COCHEE);

            bouton9 = new JButton("");
            bouton9.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton9.setFont(new Font("Arial",Font.PLAIN,50));
            bouton9.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton9);
            grille.put(9, EtatCase.NON_COCHEE);

            //Fin de la création des boutons
            //Events de clic sur les boutons
            bouton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(1, grille.get(1)));
                    clearChanged();
                }
            });

            bouton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(2, grille.get(2)));
                    clearChanged();
                }
            });

            bouton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(3, grille.get(3)));
                    clearChanged();
                }
            });

            bouton4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(4, grille.get(4)));
                    clearChanged();
                }
            });

            bouton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(5, grille.get(5)));
                    clearChanged();
                }
            });

            bouton6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(6, grille.get(6)));
                    clearChanged();
                }
            });

            bouton7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(7, grille.get(7)));
                    clearChanged();
                }
            });

            bouton8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(8, grille.get(8)));
                    clearChanged();
                }
            });

            bouton9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(9, grille.get(9)));
                    clearChanged();
                }
            });

            //Fin des events de clic sur bouton


            JPanel panelSud = new JPanel(new GridLayout(1, 4));
            mainPanel.add(panelSud, BorderLayout.SOUTH);
            panelSud.setBackground(Color.decode("#FBEEE4"));

            JButton btnQuitter = new JButton("Quitter");
            btnQuitter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Actions.ANNULE);
                    clearChanged();
                }
            });
            btnQuitter.setBackground(Color.decode("#D73535"));
            btnQuitter.setForeground(Color.decode("#FFFFFF"));

            panelSud.add(btnQuitter);
            panelSud.add(new JLabel(""));
            panelSud.add(new JLabel(""));
            panelSud.add(new JLabel(""));
        }
        else{ 
            //Moins de 12 ans
            window = new JFrame();
            window.setIconImage(imageBackground.getImage());
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
            window.setTitle("Tournoi de morpion : match numero " + numMatch + " : " + joueur1.getNom() + " VS " + joueur2.getNom());
            JPanel mainPanel = new JPanel(new BorderLayout());
            window.add(mainPanel);

            JPanel panelHaut = new JPanel(new GridLayout(2, 3));
            mainPanel.add(panelHaut, BorderLayout.NORTH);
            panelHaut.setBackground(Color.decode("#98fb98"));
           
            JLabel nj1 = new JLabel(joueur1.getNom(),SwingConstants.CENTER);
            nj1.setForeground(Color.red);
            panelHaut.add(nj1);
            joueurCourant = new JLabel("C'est au tour de " + joueur1.getNom(),SwingConstants.CENTER);
            panelHaut.add(joueurCourant);
            
            JLabel nj2 = new JLabel(joueur2.getNom(),SwingConstants.CENTER);
            nj2.setForeground(Color.blue);
            panelHaut.add(nj2);
            JLabel j1v = new JLabel("Signe: X",SwingConstants.CENTER);
            j1v.setForeground(Color.red);
            panelHaut.add(j1v);
            panelHaut.add(new JLabel(""));
            JLabel j2v = new JLabel("Signe: O",SwingConstants.CENTER);
            j2v.setForeground(Color.blue);
            panelHaut.add(j2v);


            JPanel panelMid = new JPanel(new GridLayout(3, 3));
            panelMid.setBackground(Color.decode("#98fb98"));
            mainPanel.add(panelMid, BorderLayout.CENTER);

            //Création des boutons du morpion !
            bouton1 = new JButton("");
            bouton1.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton1.setFont(new Font("Arial",Font.PLAIN,50));
            bouton1.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton1);
            grille.put(1, EtatCase.NON_COCHEE);

            bouton2 = new JButton("");
            bouton2.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton2.setFont(new Font("Arial",Font.PLAIN,50));
            bouton2.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton2);
            grille.put(2, EtatCase.NON_COCHEE);

            bouton3 = new JButton("");
            bouton3.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton3.setFont(new Font("Arial",Font.PLAIN,50));
            bouton3.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton3);
            grille.put(3, EtatCase.NON_COCHEE);

            bouton4 = new JButton("");
            bouton4.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton4.setFont(new Font("Arial",Font.PLAIN,50));
            bouton4.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton4);
            grille.put(4, EtatCase.NON_COCHEE);

            bouton5 = new JButton("");
            bouton5.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton5.setFont(new Font("Arial",Font.PLAIN,50));
            bouton5.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton5);
            grille.put(5, EtatCase.NON_COCHEE);

            bouton6 = new JButton("");
            bouton6.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton6.setFont(new Font("Arial",Font.PLAIN,50));
            bouton6.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton6);
            grille.put(6, EtatCase.NON_COCHEE);

            bouton7 = new JButton("");
            bouton7.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton7.setFont(new Font("Arial",Font.PLAIN,50));
            bouton7.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton7);
            grille.put(7, EtatCase.NON_COCHEE);

            bouton8 = new JButton("");
            bouton8.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton8.setFont(new Font("Arial",Font.PLAIN,50));
            bouton8.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton8);
            grille.put(8, EtatCase.NON_COCHEE);

            bouton9 = new JButton("");
            bouton9.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton9.setFont(new Font("Arial",Font.PLAIN,50));
            bouton9.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton9);
            grille.put(9, EtatCase.NON_COCHEE);

            //Fin de la création des boutons
            //Events de clic sur les boutons
            bouton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(1, grille.get(1)));
                    clearChanged();
                }
            });

            bouton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(2, grille.get(2)));
                    clearChanged();
                }
            });

            bouton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(3, grille.get(3)));
                    clearChanged();
                }
            });

            bouton4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(4, grille.get(4)));
                    clearChanged();
                }
            });

            bouton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(5, grille.get(5)));
                    clearChanged();
                }
            });

            bouton6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(6, grille.get(6)));
                    clearChanged();
                }
            });

            bouton7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(7, grille.get(7)));
                    clearChanged();
                }
            });

            bouton8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(8, grille.get(8)));
                    clearChanged();
                }
            });

            bouton9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageGrille(9, grille.get(9)));
                    clearChanged();
                }
            });

            //Fin des events de clic sur bouton


            JPanel panelSud = new JPanel(new GridLayout(1, 4));
            mainPanel.add(panelSud, BorderLayout.SOUTH);
            panelSud.setBackground(Color.decode("#98fb98"));

            JButton btnQuitter = new JButton("Quitter");
            btnQuitter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Actions.ANNULE);
                    clearChanged();
                }
            });
            btnQuitter.setBackground(Color.decode("#D73535"));
            btnQuitter.setForeground(Color.decode("#FFFFFF"));

            panelSud.add(btnQuitter);
            panelSud.add(new JLabel(""));
            panelSud.add(new JLabel(""));
            panelSud.add(new JLabel(""));
        }

    }
    
    public VueGrille(GestionVue vue,Integer jgagant){
        if(vue == GestionVue.Duel){
            numJoueur = 1;
            window = new JFrame();
            window.setIconImage(imageBackground.getImage());
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
            window.setTitle("Jeu du morpion : Duel ");
            JPanel mainPanel = new JPanel(new BorderLayout());
            window.add(mainPanel);

            JPanel panelHaut = new JPanel(new GridLayout(2, 3));
            mainPanel.add(panelHaut, BorderLayout.NORTH);
            panelHaut.setBackground(Color.decode("#FBEEE4"));
            panelHaut.add(new JLabel("Joueur 1",SwingConstants.CENTER));
            joueurCourant = new JLabel("C'est au tour de Joueur 1",SwingConstants.CENTER);
            panelHaut.add(joueurCourant);
            panelHaut.add(new JLabel("Joueur 2",SwingConstants.CENTER));
            panelHaut.add(new JLabel("Signe: X",SwingConstants.CENTER));
            panelHaut.add(new JLabel(""));
            panelHaut.add(new JLabel("Signe: O",SwingConstants.CENTER));



            JPanel panelMid = new JPanel(new GridLayout(3, 3));
            panelMid.setBackground(Color.decode("#FBEEE4"));
            mainPanel.add(panelMid, BorderLayout.CENTER);

            //Création des boutons du morpion !
            bouton1 = new JButton("");
            bouton1.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton1.setFont(new Font("Arial",Font.PLAIN,50));
            bouton1.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton1);
            grille.put(1, EtatCase.NON_COCHEE);

            bouton2 = new JButton("");
            bouton2.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton2.setFont(new Font("Arial",Font.PLAIN,50));
            bouton2.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton2);
            grille.put(2, EtatCase.NON_COCHEE);

            bouton3 = new JButton("");
            bouton3.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton3.setFont(new Font("Arial",Font.PLAIN,50));
            bouton3.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton3);
            grille.put(3, EtatCase.NON_COCHEE);

            bouton4 = new JButton("");
            bouton4.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton4.setFont(new Font("Arial",Font.PLAIN,50));
            bouton4.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton4);
            grille.put(4, EtatCase.NON_COCHEE);

            bouton5 = new JButton("");
            bouton5.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton5.setFont(new Font("Arial",Font.PLAIN,50));
            bouton5.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton5);
            grille.put(5, EtatCase.NON_COCHEE);

            bouton6 = new JButton("");
            bouton6.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton6.setFont(new Font("Arial",Font.PLAIN,50));
            bouton6.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton6);
            grille.put(6, EtatCase.NON_COCHEE);

            bouton7 = new JButton("");
            bouton7.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton7.setFont(new Font("Arial",Font.PLAIN,50));
            bouton7.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton7);
            grille.put(7, EtatCase.NON_COCHEE);

            bouton8 = new JButton("");
            bouton8.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton8.setFont(new Font("Arial",Font.PLAIN,50));
            bouton8.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton8);
            grille.put(8, EtatCase.NON_COCHEE);

            bouton9 = new JButton("");
            bouton9.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton9.setFont(new Font("Arial",Font.PLAIN,50));
            bouton9.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton9);
            grille.put(9, EtatCase.NON_COCHEE);

            //Fin de la création des boutons
            //Events de clic sur les boutons
            bouton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageDuel(1, grille.get(1), getNumJoueur()));
                    clearChanged();
                }
            });

            bouton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageDuel(2, grille.get(2), getNumJoueur()));
                    clearChanged();
                }
            });

            bouton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageDuel(3, grille.get(3), getNumJoueur()));
                    clearChanged();
                }
            });

            bouton4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageDuel(4, grille.get(4), getNumJoueur()));
                    clearChanged();
                }
            });

            bouton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageDuel(5, grille.get(5), getNumJoueur()));
                    clearChanged();
                }
            });

            bouton6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageDuel(6, grille.get(6), getNumJoueur()));
                    if(grille.get(6) == EtatCase.NON_COCHEE){
                    }
                    clearChanged();
                }
            });

            bouton7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageDuel(7, grille.get(7), getNumJoueur()));
                    clearChanged();
                }
            });

            bouton8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageDuel(8, grille.get(8), getNumJoueur()));
                    clearChanged();
                }
            });

            bouton9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(new MessageDuel(9, grille.get(9), getNumJoueur()));
                    clearChanged();
                }
            });

            //Fin des events de clic sur bouton


            JPanel panelSud = new JPanel(new GridLayout(1, 4));
            mainPanel.add(panelSud, BorderLayout.SOUTH);
            panelSud.setBackground(Color.decode("#FBEEE4"));

            JButton btnQuitter = new JButton("Quitter");
            btnQuitter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Actions.ANNULE);
                    clearChanged();
                }
            });
            btnQuitter.setBackground(Color.decode("#D73535"));
            btnQuitter.setForeground(Color.decode("#FFFFFF"));

            panelSud.add(btnQuitter);
            panelSud.add(new JLabel(""));
            panelSud.add(new JLabel(""));
            panelSud.add(new JLabel(""));
        }
        else if(vue == GestionVue.Solo){
            Random random = new Random();
            
            window = new JFrame();
            window.setIconImage(imageBackground.getImage());
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
            window.setTitle("Jeu du morpion : Solo ");
            JPanel mainPanel = new JPanel(new BorderLayout());
            window.add(mainPanel);

            JPanel panelHaut = new JPanel(new GridLayout(2, 3));
            mainPanel.add(panelHaut, BorderLayout.NORTH);
            panelHaut.setBackground(Color.decode("#FBEEE4"));
            panelHaut.add(new JLabel(""));
            panelHaut.add(new JLabel("Vous êtes le joueur 1",SwingConstants.CENTER));
            panelHaut.add(new JLabel(""));
            panelHaut.add(new JLabel(""));
            joueurCourant = new JLabel("Vous avez le signe X",SwingConstants.CENTER);
            panelHaut.add(joueurCourant);
            panelHaut.add(new JLabel(""));



            JPanel panelMid = new JPanel(new GridLayout(3, 3));
            panelMid.setBackground(Color.decode("#FBEEE4"));
            mainPanel.add(panelMid, BorderLayout.CENTER);

            //Création des boutons du morpion !
            bouton1 = new JButton("");
            bouton1.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton1.setFont(new Font("Arial",Font.PLAIN,50));
            bouton1.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton1);
            grille.put(1, EtatCase.NON_COCHEE);

            bouton2 = new JButton("");
            bouton2.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton2.setFont(new Font("Arial",Font.PLAIN,50));
            bouton2.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton2);
            grille.put(2, EtatCase.NON_COCHEE);

            bouton3 = new JButton("");
            bouton3.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton3.setFont(new Font("Arial",Font.PLAIN,50));
            bouton3.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton3);
            grille.put(3, EtatCase.NON_COCHEE);

            bouton4 = new JButton("");
            bouton4.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton4.setFont(new Font("Arial",Font.PLAIN,50));
            bouton4.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton4);
            grille.put(4, EtatCase.NON_COCHEE);

            bouton5 = new JButton("");
            bouton5.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton5.setFont(new Font("Arial",Font.PLAIN,50));
            bouton5.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton5);
            grille.put(5, EtatCase.NON_COCHEE);

            bouton6 = new JButton("");
            bouton6.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton6.setFont(new Font("Arial",Font.PLAIN,50));
            bouton6.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton6);
            grille.put(6, EtatCase.NON_COCHEE);

            bouton7 = new JButton("");
            bouton7.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton7.setFont(new Font("Arial",Font.PLAIN,50));
            bouton7.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton7);
            grille.put(7, EtatCase.NON_COCHEE);

            bouton8 = new JButton("");
            bouton8.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton8.setFont(new Font("Arial",Font.PLAIN,50));
            bouton8.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton8);
            grille.put(8, EtatCase.NON_COCHEE);

            bouton9 = new JButton("");
            bouton9.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2));
            bouton9.setFont(new Font("Arial",Font.PLAIN,50));
            bouton9.setBackground(Color.decode("#FFFFFF"));
            panelMid.add(bouton9);
            grille.put(9, EtatCase.NON_COCHEE);

            //Fin de la création des boutons
            //Events de clic sur les boutons
            bouton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    int numGrilleIA = random.nextInt(8)+1;
                    int nbCasesNonCochees = 0;
                    for (int i=1;i<10;i++){
                        if(grille.get(i) == EtatCase.NON_COCHEE){
                            nbCasesNonCochees = nbCasesNonCochees + 1;
                        }
                    }
                    if(nbCasesNonCochees > 1){
                        while(numGrilleIA == 1 || grille.get(numGrilleIA) != EtatCase.NON_COCHEE ){
                            numGrilleIA = random.nextInt(8)+1;
                        }
                    }    
                    notifyObservers(new MessageSolo(grille.get(1),1,grille.get(numGrilleIA),numGrilleIA));
                    clearChanged();
                }
            });

            bouton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    int numGrilleIA = random.nextInt(8)+1;
                    int nbCasesNonCochees = 0;
                    for (int i=1;i<10;i++){
                        if(grille.get(i) == EtatCase.NON_COCHEE){
                            nbCasesNonCochees = nbCasesNonCochees + 1;
                        }
                    }
                    if(nbCasesNonCochees > 1){
                        while(numGrilleIA == 2 || grille.get(numGrilleIA) != EtatCase.NON_COCHEE ){
                            numGrilleIA = random.nextInt(8)+1;
                        }
                    }    
                    notifyObservers(new MessageSolo(grille.get(2),2,grille.get(numGrilleIA),numGrilleIA));
                    clearChanged();
                }
            });

            bouton3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    int numGrilleIA = random.nextInt(8)+1;
                    int nbCasesNonCochees = 0;
                    for (int i=1;i<10;i++){
                        if(grille.get(i) == EtatCase.NON_COCHEE){
                            nbCasesNonCochees = nbCasesNonCochees + 1;
                        }
                    }
                    if(nbCasesNonCochees > 1){
                        while(numGrilleIA == 3 || grille.get(numGrilleIA) != EtatCase.NON_COCHEE ){
                            numGrilleIA = random.nextInt(8)+1;
                        }
                    }    
                    notifyObservers(new MessageSolo(grille.get(3),3,grille.get(numGrilleIA),numGrilleIA));
                    clearChanged();
                }
            });

            bouton4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    int numGrilleIA = random.nextInt(9)+1;
                    int nbCasesNonCochees = 0;
                    for (int i=1;i<10;i++){
                        if(grille.get(i) == EtatCase.NON_COCHEE){
                            nbCasesNonCochees = nbCasesNonCochees + 1;
                        }
                    }
                    if(nbCasesNonCochees > 1){
                        while(numGrilleIA == 4 || grille.get(numGrilleIA) != EtatCase.NON_COCHEE ){
                            numGrilleIA = random.nextInt(9)+1;
                        }
                    }    
                    notifyObservers(new MessageSolo(grille.get(4),4,grille.get(numGrilleIA),numGrilleIA));
                    clearChanged();
                }
            });

            bouton5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    int numGrilleIA = random.nextInt(8)+1;
                    int nbCasesNonCochees = 0;
                    for (int i=1;i<10;i++){
                        if(grille.get(i) == EtatCase.NON_COCHEE){
                            nbCasesNonCochees = nbCasesNonCochees + 1;
                        }
                    }
                    if(nbCasesNonCochees > 1){
                        while(numGrilleIA == 5 || grille.get(numGrilleIA) != EtatCase.NON_COCHEE ){
                            numGrilleIA = random.nextInt(8)+1;
                        }
                    }    
                    notifyObservers(new MessageSolo(grille.get(5),5,grille.get(numGrilleIA),numGrilleIA));
                    clearChanged();
                }
            });

            bouton6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    int numGrilleIA = random.nextInt(8)+1;
                    int nbCasesNonCochees = 0;
                    for (int i=1;i<10;i++){
                        if(grille.get(i) == EtatCase.NON_COCHEE){
                            nbCasesNonCochees = nbCasesNonCochees + 1;
                        }
                    }
                    if(nbCasesNonCochees > 1){
                        while(numGrilleIA == 6 || grille.get(numGrilleIA) != EtatCase.NON_COCHEE ){
                            numGrilleIA = random.nextInt(8)+1;
                        }
                    }
                    notifyObservers(new MessageSolo(grille.get(6),6,grille.get(numGrilleIA),numGrilleIA));
                    clearChanged();
                }
            });

            bouton7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    int numGrilleIA = random.nextInt(8)+1;
                    int nbCasesNonCochees = 0;
                    for (int i=1;i<10;i++){
                        if(grille.get(i) == EtatCase.NON_COCHEE){
                            nbCasesNonCochees = nbCasesNonCochees + 1;
                            
                        }
                    }
                    if(nbCasesNonCochees > 1){
                        while(numGrilleIA == 7 || grille.get(numGrilleIA) != EtatCase.NON_COCHEE ){
                            numGrilleIA = random.nextInt(8)+1;
                            ;
                        }
                    }    
                    notifyObservers(new MessageSolo(grille.get(7),7,grille.get(numGrilleIA),numGrilleIA));
                    clearChanged();
                }
            });

            bouton8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    int numGrilleIA = random.nextInt(8)+1;
                    int nbCasesNonCochees = 0;
                    for (int i=1;i<10;i++){
                        if(grille.get(i) == EtatCase.NON_COCHEE){
                            nbCasesNonCochees = nbCasesNonCochees + 1;
                        }
                    }
                    if(nbCasesNonCochees > 1){
                        while(numGrilleIA == 8 || grille.get(numGrilleIA) != EtatCase.NON_COCHEE ){
                            numGrilleIA = random.nextInt(8)+1;
                        }
                    }
                    notifyObservers(new MessageSolo(grille.get(8),8,grille.get(numGrilleIA),numGrilleIA));
                    clearChanged();
                }
            });

            bouton9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    int numGrilleIA = random.nextInt(8)+1;
                    int nbCasesNonCochees = 0;
                    for (int i=1;i<10;i++){
                        if(grille.get(i) == EtatCase.NON_COCHEE){
                            nbCasesNonCochees = nbCasesNonCochees + 1;
                        }
                    }
                    if(nbCasesNonCochees > 1){
                        while(numGrilleIA == 8 || grille.get(numGrilleIA) != EtatCase.NON_COCHEE ){
                            numGrilleIA = random.nextInt(8)+1;
                        }
                    }    
                    notifyObservers(new MessageSolo(grille.get(9),9,grille.get(numGrilleIA),numGrilleIA));
                    clearChanged();
                }
            });
            //Fin des events de clic sur bouton


            JPanel panelSud = new JPanel(new GridLayout(1, 4));
            mainPanel.add(panelSud, BorderLayout.SOUTH);
            panelSud.setBackground(Color.decode("#FBEEE4"));

            JButton btnQuitter = new JButton("Quitter");
            btnQuitter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setChanged();
                    notifyObservers(Actions.ANNULE);
                    clearChanged();
                }
            });
            btnQuitter.setBackground(Color.decode("#D73535"));
            btnQuitter.setForeground(Color.decode("#FFFFFF"));

            panelSud.add(btnQuitter);
            panelSud.add(new JLabel(""));
            panelSud.add(new JLabel(""));
            panelSud.add(new JLabel(""));
        }
        else if(vue == GestionVue.RejouerSeul){
            if(jgagant == 1){
                JPanel mainPanel = new JPanel(new BorderLayout());
            window = new JFrame();
            window.setIconImage(imageBackground.getImage());
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
            window.setTitle("Jeu du morpion : Solo ");
            window.add(mainPanel);

            JPanel panelHaut = new JPanel(new GridLayout(1, 3));
            mainPanel.add(panelHaut, BorderLayout.NORTH);
            panelHaut.setBackground(Color.decode("#FBEEE4"));
            panelHaut.add(new JLabel(""));
            panelHaut.add(new JLabel("Vous avez gagné ! ",SwingConstants.CENTER));
            panelHaut.add(new JLabel(""));
            JPanel panelCentre = new JPanel(new GridLayout(2, 3));
            mainPanel.add(panelCentre,BorderLayout.CENTER);
            panelCentre.add(new JLabel(""));
            panelCentre.setBackground(Color.decode("#FBEEE4"));
            JButton rejouer = new JButton("Rejouer");
            panelCentre.add(rejouer);
            rejouer.setBackground(Color.decode("#FFFFFF"));
            rejouer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(GestionVue.Solo);
                        clearChanged();
                    }
                });
            panelCentre.add(new JLabel(""));
            panelCentre.add(new JLabel(""));
//            
            JButton quitter = new JButton("Retour au menu");
            panelCentre.add(quitter);
            quitter.setBackground(Color.decode("#FFFFFF"));
            quitter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(GestionVue.Jeu);
                        clearChanged();
                    }
                });
            panelCentre.add(new JLabel(""));
            }
            else if(jgagant == 2){
                JPanel mainPanel = new JPanel(new BorderLayout());
                window = new JFrame();
                window.setIconImage(imageBackground.getImage());
                window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                // Définit la taille de la fenêtre en pixels
                window.setSize(800, 300);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
                window.setTitle("Jeu du morpion : Solo ");
                window.add(mainPanel);

                JPanel panelHaut = new JPanel(new GridLayout(1, 3));
                mainPanel.add(panelHaut, BorderLayout.NORTH);
                panelHaut.setBackground(Color.decode("#FBEEE4"));
                panelHaut.add(new JLabel(""));
                panelHaut.add(new JLabel("Vous avez perdu ! ",SwingConstants.CENTER));
                panelHaut.add(new JLabel(""));
                JPanel panelCentre = new JPanel(new GridLayout(2, 3));
                mainPanel.add(panelCentre,BorderLayout.CENTER);
                panelCentre.add(new JLabel(""));
                panelCentre.setBackground(Color.decode("#FBEEE4"));
                JButton rejouer = new JButton("Rejouer");
                panelCentre.add(rejouer);
                rejouer.setBackground(Color.decode("#FFFFFF"));
                rejouer.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            setChanged();
                            notifyObservers(GestionVue.Solo);
                            clearChanged();
                        }
                    });
                panelCentre.add(new JLabel(""));
                panelCentre.add(new JLabel(""));
    //            
                JButton quitter = new JButton("Retour au menu");
                panelCentre.add(quitter);
                quitter.setBackground(Color.decode("#FFFFFF"));
                quitter.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            setChanged();
                            notifyObservers(GestionVue.Jeu);
                            clearChanged();
                        }
                    });
                panelCentre.add(new JLabel(""));
                }
            else{
                JPanel mainPanel = new JPanel(new BorderLayout());
                window = new JFrame();
                window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                window.setIconImage(imageBackground.getImage());
                // Définit la taille de la fenêtre en pixels
                window.setSize(800, 300);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
                window.setTitle("Jeu du morpion : Solo ");
                window.add(mainPanel);

                JPanel panelHaut = new JPanel(new GridLayout(1, 3));
                mainPanel.add(panelHaut, BorderLayout.NORTH);
                panelHaut.setBackground(Color.decode("#FBEEE4"));
                panelHaut.add(new JLabel(""));
                panelHaut.add(new JLabel("Il a égalité ! ",SwingConstants.CENTER));
                panelHaut.add(new JLabel(""));
                JPanel panelCentre = new JPanel(new GridLayout(2, 3));
                mainPanel.add(panelCentre,BorderLayout.CENTER);
                panelCentre.add(new JLabel(""));
                panelCentre.setBackground(Color.decode("#FBEEE4"));
                JButton rejouer = new JButton("Rejouer");
                panelCentre.add(rejouer);
                rejouer.setBackground(Color.decode("#FFFFFF"));
                rejouer.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            setChanged();
                            notifyObservers(GestionVue.Solo);
                            clearChanged();
                        }
                    });
                panelCentre.add(new JLabel(""));
                panelCentre.add(new JLabel(""));
    //            
                JButton quitter = new JButton("Retour au menu");
                panelCentre.add(quitter);
                quitter.setBackground(Color.decode("#FFFFFF"));
                quitter.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            setChanged();
                            notifyObservers(GestionVue.Jeu);
                            clearChanged();
                        }
                    });
                panelCentre.add(new JLabel(""));
                }
        }
        else if(jgagant > 0){ //Panneau victoire du joueur en mode duel
            JPanel mainPanel = new JPanel(new BorderLayout());
            window = new JFrame();
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            window.setIconImage(imageBackground.getImage());
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
            window.setTitle("Jeu du morpion : Duel ");
            window.add(mainPanel);

            JPanel panelHaut = new JPanel(new GridLayout(1, 3));
            mainPanel.add(panelHaut, BorderLayout.NORTH);
            panelHaut.setBackground(Color.decode("#FBEEE4"));
            panelHaut.add(new JLabel(""));
            panelHaut.add(new JLabel("Victoire du joueur " + jgagant,SwingConstants.CENTER));
            panelHaut.add(new JLabel(""));
            JPanel panelCentre = new JPanel(new GridLayout(2, 3));
            mainPanel.add(panelCentre,BorderLayout.CENTER);
            panelCentre.add(new JLabel(""));
            panelCentre.setBackground(Color.decode("#FBEEE4"));
            JButton rejouer = new JButton("Rejouer");
            panelCentre.add(rejouer);
            rejouer.setBackground(Color.decode("#FFFFFF"));
            rejouer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(GestionVue.Duel);
                        clearChanged();
                    }
                });
            panelCentre.add(new JLabel(""));
            panelCentre.add(new JLabel(""));
//            
            JButton quitter = new JButton("Retour au menu");
            panelCentre.add(quitter);
            quitter.setBackground(Color.decode("#FFFFFF"));
            quitter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(GestionVue.Jeu);
                        clearChanged();
                    }
                });
            panelCentre.add(new JLabel(""));
        }   
        else{ //Si jgagant n'est ni 1 ni 2 et on en déduit qu'il y a une egalité 
          JPanel mainPanel = new JPanel(new BorderLayout());
            window = new JFrame();
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            window.setIconImage(imageBackground.getImage());
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
            window.setTitle("Jeu du morpion : Duel ");
            window.add(mainPanel);

            JPanel panelHaut = new JPanel(new GridLayout(1, 3));
            mainPanel.add(panelHaut, BorderLayout.NORTH);
            panelHaut.setBackground(Color.decode("#FBEEE4"));
            panelHaut.add(new JLabel(""));
            panelHaut.add(new JLabel("Egalité entre les deux joueurs ! ",SwingConstants.CENTER));
            panelHaut.add(new JLabel(""));
            JPanel panelCentre = new JPanel(new GridLayout(2, 3));
            mainPanel.add(panelCentre,BorderLayout.CENTER);
            panelCentre.add(new JLabel(""));
            panelCentre.setBackground(Color.decode("#FBEEE4"));
            JButton rejouer = new JButton("Rejouer");
            rejouer.setBackground(Color.decode("#FFFFFF"));
            panelCentre.add(rejouer);
            rejouer.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(GestionVue.Rejouer);
                        clearChanged();
                    }
                });
            panelCentre.add(new JLabel(""));
            panelCentre.add(new JLabel(""));
//            
            JButton quitter = new JButton("Retour au menu");
            panelCentre.add(quitter);
            quitter.setBackground(Color.decode("#FFFFFF"));
            quitter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setChanged();
                        notifyObservers(GestionVue.Jeu);
                        clearChanged();
                    }
                });
            panelCentre.add(new JLabel(""));
        }     
        
    }

    public void afficher() {
        this.window.setVisible(true);
    }

    public void close() {
        this.window.dispose();
    }

    public void setJoueurCourant(Joueur j) {
        joueurCourant.setText("C'est à " + j.getNom() + " de jouer.");
    }

    public void majCase(MessageGrille message) {
        System.out.println(message.getNumGrille());
        if(vAge == GestionVue.Moins12){
            if (message.getNumGrille() == 1) {
                bouton1.setText(message.NouvEtatCase());
                if(message.getEtat() == EtatCase.O){
                    bouton1.setBackground(Color.decode("#3399ff"));
                }
                else{
                    bouton1.setBackground(Color.decode("#ff6666"));
                }
                grille.put(1, message.getEtat());
            } else if (message.getNumGrille() == 2) {
                bouton2.setText(message.NouvEtatCase());
                if(message.getEtat() == EtatCase.O){
                    bouton2.setBackground(Color.decode("#3399ff"));
                }
                else{
                    bouton2.setBackground(Color.decode("#ff6666"));
                }
                grille.put(2, message.getEtat());            
            } else if (message.getNumGrille() == 3) {
                bouton3.setText(message.NouvEtatCase());
                if(message.getEtat() == EtatCase.O){
                    bouton3.setBackground(Color.decode("#3399ff"));
                }
                else{
                    bouton3.setBackground(Color.decode("#ff6666"));
                }
                grille.put(3, message.getEtat());
            } else if (message.getNumGrille() == 4) {
                bouton4.setText(message.NouvEtatCase());
                if(message.getEtat() == EtatCase.O){
                    bouton4.setBackground(Color.decode("#3399ff"));
                }
                else{
                    bouton4.setBackground(Color.decode("#ff6666"));
                }
                grille.put(4, message.getEtat());
            } else if (message.getNumGrille() == 5) {
                bouton5.setText(message.NouvEtatCase());
                if(message.getEtat() == EtatCase.O){
                    bouton5.setBackground(Color.decode("#3399ff"));
                }
                else{
                    bouton5.setBackground(Color.decode("#ff6666"));
                }
                grille.put(5, message.getEtat());
            } else if (message.getNumGrille() == 6) {
                bouton6.setText(message.NouvEtatCase());
                if(message.getEtat() == EtatCase.O){
                    bouton6.setBackground(Color.decode("#3399ff"));
                }
                else{
                    bouton6.setBackground(Color.decode("#ff6666"));
                }
                grille.put(6, message.getEtat());
            } else if (message.getNumGrille() == 7) {
                bouton7.setText(message.NouvEtatCase());
                if(message.getEtat() == EtatCase.O){
                    bouton7.setBackground(Color.decode("#3399ff"));
                }
                else{
                    bouton7.setBackground(Color.decode("#ff6666"));
                }
                grille.put(7, message.getEtat());
            } else if (message.getNumGrille() == 8) {
                bouton8.setText(message.NouvEtatCase());
                if(message.getEtat() == EtatCase.O){
                    bouton8.setBackground(Color.decode("#3399ff"));
                }
                else{
                    bouton8.setBackground(Color.decode("#ff6666"));
                }
                grille.put(8, message.getEtat());
            } else if (message.getNumGrille() == 9) {
                bouton9.setText(message.NouvEtatCase());
                if(message.getEtat() == EtatCase.O){
                    bouton9.setBackground(Color.decode("#3399ff"));
                }
                else{
                    bouton9.setBackground(Color.decode("#ff6666"));
                }
                grille.put(9, message.getEtat());
            }
        }
        else{
            if (message.getNumGrille() == 1){
                bouton1.setText(message.NouvEtatCase());
                grille.put(1, message.getEtat());
            } else if (message.getNumGrille() == 2) {
                bouton2.setText(message.NouvEtatCase());
                grille.put(2, message.getEtat());            
            } else if (message.getNumGrille() == 3) {
                bouton3.setText(message.NouvEtatCase());
                grille.put(3, message.getEtat());
            } else if (message.getNumGrille() == 4) {
                bouton4.setText(message.NouvEtatCase());
                grille.put(4, message.getEtat());
            } else if (message.getNumGrille() == 5) {
                bouton5.setText(message.NouvEtatCase());
                grille.put(5, message.getEtat());
            } else if (message.getNumGrille() == 6) {
                bouton6.setText(message.NouvEtatCase());
                grille.put(6, message.getEtat());
            } else if (message.getNumGrille() == 7) {
                bouton7.setText(message.NouvEtatCase());
                grille.put(7, message.getEtat());
            } else if (message.getNumGrille() == 8) {
                bouton8.setText(message.NouvEtatCase());
                grille.put(8, message.getEtat());
            } else if (message.getNumGrille() == 9) {
                bouton9.setText(message.NouvEtatCase());
                grille.put(9, message.getEtat());
            }
        }  
    }
    public EtatMatch verifVictoire(EtatCase etatCase){
            EtatMatch etat = null;
            if(grille.get(1) == etatCase && grille.get(2) == etatCase &&  grille.get(3) == etatCase){
                etat = Victoire; //Verification pour la première ligne
                System.out.print("Victoire 1er ligne");
            }
            else if(grille.get(4) == etatCase && grille.get(5) == etatCase && grille.get(6) == etatCase){
                etat = Victoire;  //Verification pour la deuxième ligne
                System.out.print("Victoire 2er ligne");
            }
            else if(grille.get(7) == etatCase && grille.get(8) == etatCase && grille.get(9) == etatCase){
                etat = Victoire;  //Verification pour la troisième ligne
                System.out.print("Victoire 3er ligne");
            }
            else if(grille.get(1) == etatCase && grille.get(4) ==etatCase  && grille.get(7) == etatCase){
                etat = Victoire;  //Verification pour la première colonne
                 System.out.print("Victoire 1er colonne");
            }
            else if(grille.get(2) == etatCase && grille.get(5)== etatCase && grille.get(8) == etatCase){
                etat = Victoire;  //Verification pour la deuxième colonne
                System.out.print("Victoire 2er colonne");
            }
            else if(grille.get(3) ==etatCase &&  grille.get(6) == etatCase && grille.get(9) == etatCase){
                etat = Victoire;  //Verification pour la troisième colonne
                System.out.print("Victoire 3er colonne");
            }
            else if(grille.get(1) == etatCase &&grille.get(5) == etatCase && grille.get(9) == etatCase){
                etat = Victoire;  //Verification pour la diagonale droite
                System.out.print("Diagonale droite");
            }
            else if(grille.get(3) ==etatCase && grille.get(5)==etatCase &&  grille.get(7)==etatCase){
                etat = Victoire;  //Verification pour la diagonale gauche
                System.out.print("Diagonale droite");
            }
            else {
                if(grille.containsValue(EtatCase.NON_COCHEE)){
                    etat = Pas_Termine;
                }
                else{
                    etat = Egalite;
                }
            }
            return etat;
        }

    /**
     * @return the numJoueur
     */
    public Integer getNumJoueur() {
        return numJoueur;
    }

    /**
     * @param numJoueur the numJoueur to set
     */
    public void setNumJoueur(Integer numJoueur) {
        this.numJoueur = numJoueur;
    }

}
