/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.EtatMatch;
import Modèle.Match;
import utilitaire.Actions;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import utilitaire.GestionVue;
import static utilitaire.GestionVue.Menu;
import static utilitaire.GestionVue.Moins12;
import static utilitaire.GestionVue.Plus12;
import static utilitaire.GestionVue.Préparation;
import static utilitaire.GestionVue.Préparation2;
import utilitaire.MessageMenu;
import utilitaire.MessageTournois;

public class VueTournois extends Observable {
    private final JFrame window ;
    private GestionVue Mois12;
    private JTextField champNom;
    private JLabel CombatDesJoueurs;
    private JLabel erreur = new JLabel("");
    
    
    @SuppressWarnings("Convert2Lambda")
    public VueTournois(GestionVue vEtape,GestionVue vAge) {
        if(vEtape==Préparation){        

        window = new JFrame(); 
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(700, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.lightGray);
        window.add(mainPanel) ;
        
        JPanel panelHaut = new JPanel(new GridLayout(2,3)) ;
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        panelHaut.setBackground(Color.decode("#D0CDC2"));
        
        panelHaut.add(new JLabel(""));
        JLabel titre = new JLabel("Tournois de morpion",SwingConstants.CENTER);
        titre.setFont(new Font("Arial",Font.BOLD,20));
        titre.setForeground(Color.red);
        panelHaut.add(titre);
        panelHaut.add(new JLabel(""));
        panelHaut.add(new JLabel(""));
        JLabel sousTitre = new JLabel("2 à 20 joueurs",SwingConstants.CENTER);
        sousTitre.setFont(new Font("Arial",Font.BOLD,10));
        panelHaut.add(sousTitre);
        panelHaut.add(new JLabel(""));
        
        JPanel contentPanel = new JPanel (new GridLayout(4, 3));
        contentPanel.setBackground(Color.decode("#D0CDC2"));
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        contentPanel.add(new JLabel(""));
        JButton btnMoins12 = new JButton("Mode enfant");
        btnMoins12.setBackground(Color.decode("#2FB94F"));
        btnMoins12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers("-12");
                clearChanged();
            }
        });
        contentPanel.add(btnMoins12);
        contentPanel.add(new JLabel(""));
        contentPanel.add(new JLabel(""));
        JButton btnPlus12 = new JButton("Mode adulte");
        btnPlus12.setBackground(Color.decode("#2FB9A6"));
        btnPlus12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers("+12");
                clearChanged();
            }
        });
        contentPanel.add(btnPlus12);
        contentPanel.add(new JLabel(""));
        contentPanel.add(new JLabel(""));
        JButton btnRègles = new JButton("Règles");
        btnRègles.setBackground(Color.decode("#CAD02B"));
        btnRègles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
                clearChanged();
            }
        });
        contentPanel.add(btnRègles);
        contentPanel.add(new JLabel(""));
        contentPanel.add(new JLabel(""));
        
        JButton btnQuitter = new JButton("Quitter le jeu");
        btnQuitter.setBackground(Color.decode("#D73535"));
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers();
                clearChanged();
            }
        });
        contentPanel.add(btnQuitter);
        contentPanel.add(new JLabel(""));
        
//        JPanel botPanel = new JPanel (new GridLayout(1,1));
//        contentPanel.setBackground(Color.lightGray);
//        mainPanel.add(botPanel, BorderLayout.CENTER);
//        botPanel.add(new JLabel(""));
        
               
        }
        
        
        

        // Interface de moins de 12 ans !
        else if(vAge == Moins12 && vEtape == Préparation2){
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
                notifyObservers(Actions.ANNULE);
                clearChanged();
            }
        });
        //Ajout de l'image stop
        try {
            System.out.println(System.getProperty("user.dir") + "/src/images/morpionvide.jpg");
            //Image img = ImageIO.read(new File("/users/info/etu-s2/anandanj/Morpion/Morpion/src/images/morpionvide.jpg"));
            btnStop.setIcon(new ImageIcon("/users/info/etu-s2/anandanj/Morpion/Morpion/src/images/ok.jpeg"));
       } catch (Exception ex) {
            System.out.println(ex);
        }
        btnStop.setSize(10, 10);
        
        
        bottomPanel.add(btnStop);

        bottomPanel.add(new JLabel(""));

        JButton btnFleche = new JButton("-->");
        btnFleche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(new MessageTournois(slider.getValue(),Actions.SUIVANT));
                clearChanged();
            }
        });
        bottomPanel.add(btnFleche);   
        }
        
        //Interface pour plus de 12 ans !
        else if(vAge == Plus12 && vEtape == Préparation2){
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
        
        JPanel panelMid = new JPanel();
        mainPanel.add(panelMid, BorderLayout.CENTER);
        panelMid.add(erreur);        
             
        JPanel bottomPanel = new JPanel(new GridLayout(1, 4));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                setChanged();
                notifyObservers(Actions.ANNULE);
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
                notifyObservers(new MessageTournois(nbJoueurs.getText(),Actions.SUIVANT));
                clearChanged();
            }
        });
        bottomPanel.add(btnSuivant);
        }
       
        else {
            window = new JFrame(); 
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);

            JPanel mainPanel = new JPanel(new BorderLayout());
            window.add(mainPanel) ;

            JPanel panelHaut = new JPanel(new GridLayout(1,1)) ;
            mainPanel.add(panelHaut, BorderLayout.NORTH);

            panelHaut.add(new JLabel("CA BUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUG"));
        }
    }
    
    public VueTournois(GestionVue vEtape,GestionVue vAge,HashMap<Integer,Match> matchs,int matchCourant) {
        if(vAge == Plus12 && vEtape == Menu){
            window = new JFrame(); 
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
            window.setTitle("MENU : Plus de 12 ans");
            
            JPanel mainPanel = new JPanel(new BorderLayout());
            window.add(mainPanel);
        
            JPanel panelCentre = new JPanel(new GridLayout(3,3)) ;
            JPanel panelBas = new JPanel(new GridLayout(1,4)) ;
            mainPanel.add(panelCentre, BorderLayout.CENTER);
            mainPanel.add(panelBas, BorderLayout.SOUTH);
            panelCentre.add(new JLabel(""));
           
            panelCentre.add(new JLabel(""));
            CombatDesJoueurs = new JLabel("Le match prochain opposera "+ matchs.get(matchCourant).getJoueur1().getNom() + " à " + matchs.get(matchCourant).getJoueur2().getNom());
            panelCentre.add(CombatDesJoueurs);
            panelCentre.add(new JLabel(""));
            
            panelCentre.add(new JLabel(""));
            JButton jouer = new JButton("Jouer le match");
            panelCentre.add(jouer);
            jouer.addActionListener((ActionEvent e) -> {
                setChanged();
                notifyObservers(new MessageMenu(vAge,GestionVue.JouerLeMatch));
                clearChanged();
                    });
            panelCentre.add(new JLabel(""));
            panelCentre.add(new JLabel(""));
            if(matchCourant > 1){
               if(matchs.get(matchCourant-1).getFinmatch() == EtatMatch.Victoire){
                   panelCentre.add(new JLabel("Ancien match : Victoire de " + matchs.get(matchCourant-1).getGagnant().getNom() + " sur " + matchs.get(matchCourant-1).getPerdant().getNom()));
               }
               else{
                   panelCentre.add(new JLabel("Ancien match : Egalité entre " + matchs.get(matchCourant-1).getJoueur1().getNom()+ " et" + matchs.get(matchCourant-1).getJoueur2().getNom()));
               }
            }
            else {panelCentre.add(new JLabel(""));}
            panelCentre.add(new JLabel(""));
            
            JButton quitter = new JButton("Quitter");
            panelBas.add(quitter);
            quitter.addActionListener((ActionEvent e) -> {
                setChanged();
                notifyObservers(new MessageMenu(vAge,GestionVue.Quitter));
                clearChanged();
                });
            panelBas.add(new JLabel(""));panelBas.add(new JLabel("")); 
            JButton classement = new JButton("Classement");
            panelBas.add(classement);
            classement.addActionListener((ActionEvent e) -> {
                    setChanged();
                    notifyObservers(new MessageMenu(vAge,GestionVue.Classement));
                    clearChanged();
                });      
        }
        else {
            window = new JFrame(); 
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);

            JPanel mainPanel = new JPanel(new BorderLayout());
            window.add(mainPanel) ;

            JPanel panelHaut = new JPanel(new GridLayout(1,1)) ;
            mainPanel.add(panelHaut, BorderLayout.NORTH);

            panelHaut.add(new JLabel("CA BUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUG"));
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
    
    public void erreurNbJoueurs(){
        this.erreur.setText("Le nombre de joueurs doit être compris entre 2 et 20.");
        this.erreur.setForeground(Color.red);
    }
    

    
}
