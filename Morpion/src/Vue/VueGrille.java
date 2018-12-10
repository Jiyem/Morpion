/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.EtatCase;
import static Modèle.EtatCase.X;
import Modèle.Joueur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import utilitaire.Actions;
import utilitaire.MessageGrille;

/**
 *
 * @author Jiyem
 */
public class VueGrille extends Observable {

    private HashMap<Integer, EtatCase> grille = new HashMap<>();
    private final JFrame window;
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

    public VueGrille(int numMatch, Joueur joueur1, Joueur joueur2) {
        joueurCourant = new JLabel("C'est au tour de " + joueur1.getNom());
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(800, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);

        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel);

        JPanel panelHaut = new JPanel(new GridLayout(2, 1));
        mainPanel.add(panelHaut, BorderLayout.NORTH);

        panelHaut.add(new JLabel("Match n°" + numMatch + " " + joueur1.getNom() + " contre " + joueur2.getNom()));

        panelHaut.add(joueurCourant);

        JPanel panelMid = new JPanel(new GridLayout(3, 3));
        mainPanel.add(panelMid, BorderLayout.CENTER);

        //Création des boutons du morpion !
        bouton1 = new JButton("");
        bouton1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        panelMid.add(bouton1);
        grille.put(1, EtatCase.NON_COCHEE);

        bouton2 = new JButton("");
        bouton2.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        panelMid.add(bouton2);
        grille.put(2, EtatCase.NON_COCHEE);

        bouton3 = new JButton("");
        bouton3.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        panelMid.add(bouton3);
        grille.put(3, EtatCase.NON_COCHEE);

        bouton4 = new JButton("");
        bouton4.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        panelMid.add(bouton4);
        grille.put(4, EtatCase.NON_COCHEE);

        bouton5 = new JButton("");
        bouton5.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        panelMid.add(bouton5);
        grille.put(5, EtatCase.NON_COCHEE);

        bouton6 = new JButton("");
        bouton6.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        panelMid.add(bouton6);
        grille.put(6, EtatCase.NON_COCHEE);

        bouton7 = new JButton("");
        bouton7.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        panelMid.add(bouton7);
        grille.put(7, EtatCase.NON_COCHEE);

        bouton8 = new JButton("");
        bouton8.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        panelMid.add(bouton8);
        grille.put(8, EtatCase.NON_COCHEE);

        bouton9 = new JButton("");
        bouton9.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
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
        JPanel panelGauche = new JPanel();
        mainPanel.add(panelGauche, BorderLayout.WEST);
        panelGauche.add(new JLabel(joueur1.getNom()));
        panelGauche.add(new JLabel("Signe: X"));

        JPanel panelDroite = new JPanel();
        mainPanel.add(panelDroite, BorderLayout.EAST);
        panelDroite.add(new JLabel(joueur2.getNom()));
        panelDroite.add(new JLabel("Signe: O"));

        JPanel panelSud = new JPanel(new GridLayout(1, 3));
        mainPanel.add(panelSud, BorderLayout.SOUTH);

        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Actions.ANNULE);
                clearChanged();
            }
        });
        panelSud.add(btnQuitter);

        panelSud.add(new JLabel(""));

        JButton btnVoirClassement = new JButton("Classement");
        btnVoirClassement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
                clearChanged();
            }
            
        });
        panelSud.add(btnVoirClassement);

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
        if (message.getNumGrille() == 1) {
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
