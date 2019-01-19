/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.EtatMatch;
import Modèle.Match;
import image.ImageContainer;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ImageIcon imageIcone;
    private final JFrame window ;
    private GestionVue Mois12;
    private JTextField champNom;
    private JLabel CombatDesJoueurs;
    private JLabel erreur = new JLabel("");
    private ImageContainer imageBackground = new ImageContainer("morpion.png",0,0,0,0);
    
    
    @SuppressWarnings("Convert2Lambda")
    public VueTournois(GestionVue vEtape,GestionVue vAge) {
        if(vEtape==Préparation){        
        
        window = new JFrame();
        window.setIconImage(imageBackground.getImage());
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(700, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        window.setTitle("Tournoi de morpion : choix de l'age");
        mainPanel.setBackground(Color.decode("#D3EBF2"));
        
        JPanel panelHaut = new JPanel(new GridLayout(2,3)) ;
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        
        // window.setIconImage(new ImageIcon("/src/images/morpion.png").getImage());

        panelHaut.setBackground(Color.decode("#FBEEE4")); 
        
        panelHaut.add(new JLabel(""));
        JLabel titre = new JLabel("Tournoi de morpion",SwingConstants.CENTER);        
        
        titre.setFont(new Font("Arial",Font.BOLD,20));
        panelHaut.add(titre);
        panelHaut.add(new JLabel(""));
        panelHaut.add(new JLabel(""));
        JLabel sousTitre = new JLabel("2 à 20 joueurs",SwingConstants.CENTER);
        sousTitre.setFont(new Font("Arial",Font.BOLD,10));
        sousTitre.setForeground(Color.decode("#7E7E7E"));
        panelHaut.add(sousTitre);
        panelHaut.add(new JLabel(""));
         //Choix couleur de fond : FBEEE4
        JPanel contentPanel = new JPanel (new GridLayout(4, 3));
        contentPanel.setBackground(Color.decode("#FBEEE4"));
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        contentPanel.add(new JLabel(""));
        
        JButton btnPlus12 = new JButton("Mode adulte");
        btnPlus12.setBackground(Color.decode("#FFFFFF"));
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
        JButton btnMoins12 = new JButton("Mode enfant");
        btnMoins12.setBackground(Color.decode("#98FB98"));
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
        JButton btnRègles = new JButton("Règles");
        btnRègles.setBackground(Color.decode("#FFFFFF"));
        btnRègles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers("regles");
                clearChanged();
            }
        });
        contentPanel.add(btnRègles);
        contentPanel.add(new JLabel(""));
        contentPanel.add(new JLabel(""));
        
        JButton btnQuitter = new JButton("Quitter le jeu");
        btnQuitter.setBackground(Color.decode("#FFFFFF"));
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
        
        JPanel botPanel = new JPanel (new GridLayout(1,1));
        mainPanel.add(botPanel, BorderLayout.SOUTH);
        botPanel.add(new JLabel("                           "));
        botPanel.setBackground(Color.decode("#FBEEE4"));
        
               
        }
        
        
        

        // Interface de moins de 12 ans !
        else if(vAge == Moins12 && vEtape == Préparation2){
        window = new JFrame();
        window.setIconImage(imageBackground.getImage());
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(800, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setTitle("Tournoi morpion : inscription du nombre de joueurs");
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        JPanel panelHaut = new JPanel();
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        
        panelHaut.add(new JLabel("Nombre de joueurs : "));
        panelHaut.setBackground(Color.decode("#98fb98"));    
        
        JPanel contentPanel = new JPanel (new GridLayout(1, 1));
        contentPanel.setBackground(Color.decode("#98fb98")); 
        mainPanel.add(contentPanel, BorderLayout.CENTER);
//        contentPanel.add(new JLabel("ici la barre (à ajouter)"));
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 2, 20, 2);
        slider.setBackground(Color.decode("#98fb98"));
        contentPanel.add(slider);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setLabelTable(slider.createStandardLabels(2));
        
        
        JPanel bottomPanel = new JPanel(new GridLayout(1, 4));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        bottomPanel.setBackground(Color.decode("#98fb98")); 
        JButton btnStop = new JButton("Stop");
        btnStop.setBackground(Color.decode("#D73535"));
        btnStop.setForeground(Color.decode("#FFFFFF"));
        
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
        btnFleche.setBackground(Color.decode("#008000"));
        btnFleche.setForeground(Color.decode("#FFFFFF"));
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
        window.setIconImage(imageBackground.getImage());
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(800, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        window.setTitle("Tournoi Morpion : Inscription du nombre de joueurs");
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        
        
        JPanel panelHaut = new JPanel(new GridLayout(2,3)) ;
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        panelHaut.add(new JLabel(""));
        JLabel nombreJoueurs = new JLabel("Nombre de joueurs :",SwingConstants.CENTER);
        panelHaut.setBackground(Color.decode("#FBEEE4"));
        nombreJoueurs.setFont(new Font("Arial",Font.BOLD,20));
        panelHaut.add(nombreJoueurs);
        panelHaut.add(new JLabel(""));
        panelHaut.add(new JLabel(""));
        panelHaut.add(erreur);
        panelHaut.add(new JLabel(""));
        JTextField nbJoueurs = new JTextField();
        
        JPanel panelMid = new JPanel(new GridLayout(5,4));
        panelMid.setBackground(Color.decode("#FBEEE4"));
        mainPanel.add(panelMid, BorderLayout.CENTER);
        
        for(int i = 0;i<25;i++){
           if(i == 12){
                panelMid.add(nbJoueurs);
           }else{
                panelMid.add(new JLabel(""));                
           }           
        }
        
             
        JPanel bottomPanel = new JPanel(new GridLayout(1, 4));
        bottomPanel.setBackground(Color.decode("#FBEEE4"));
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
        btnQuitter.setBackground(Color.decode("#D73535"));
        btnQuitter.setForeground(Color.decode("#FFFFFF"));

        bottomPanel.add(new JLabel(""));
      
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
        btnSuivant.setBackground(Color.decode("#008000"));
        btnSuivant.setForeground(Color.decode("#FFFFFF"));
        }
       
        else {
            window = new JFrame(); 
            window.setIconImage(imageBackground.getImage());
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
    
    public VueTournois(GestionVue vEtape,GestionVue vAge,HashMap<Integer,Match> matchs,int matchCourant){
        if(vAge == Plus12 && vEtape == Menu){
            window = new JFrame(); 
            window.setIconImage(imageBackground.getImage());
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
            window.setTitle("Tournoi de morpion : menu");
            
            JPanel mainPanel = new JPanel(new BorderLayout());
            window.add(mainPanel);
        
            JPanel panelCentre = new JPanel(new GridLayout(3,3)) ;
            JPanel panelBas = new JPanel(new GridLayout(1,4)) ;
            mainPanel.add(panelCentre, BorderLayout.CENTER);
            panelCentre.setBackground(Color.decode("#FBEEE4"));
            mainPanel.add(panelBas, BorderLayout.SOUTH);
            panelBas.setBackground(Color.decode("#FBEEE4"));
            
           
            panelCentre.add(new JLabel(""));
            CombatDesJoueurs = new JLabel("Le match prochain opposera "+ matchs.get(matchCourant).getJoueur1().getNom() + " à " + matchs.get(matchCourant).getJoueur2().getNom(),SwingConstants.CENTER);
            panelCentre.add(CombatDesJoueurs);
            panelCentre.add(new JLabel(""));
            
            panelCentre.add(new JLabel(""));
            JButton jouer = new JButton("Jouer le match");
            panelCentre.add(jouer);
            jouer.setBackground(Color.decode("#FFFFFF"));
            
            jouer.addActionListener((ActionEvent e) -> {
                setChanged();
                notifyObservers(new MessageMenu(vAge,GestionVue.JouerLeMatch));
                clearChanged();
                    });
            panelCentre.add(new JLabel(""));
            panelCentre.add(new JLabel(""));
            if(matchCourant > 1){
               if(matchs.get(matchCourant-1).getFinmatch() == EtatMatch.Victoire){
                   panelCentre.add(new JLabel("Ancien match : Victoire de " + matchs.get(matchCourant-1).getGagnant().getNom() + " sur " + matchs.get(matchCourant-1).getPerdant().getNom(),SwingConstants.CENTER));
               }
               else{
                   panelCentre.add(new JLabel("Ancien match : Egalité entre " + matchs.get(matchCourant-1).getJoueur1().getNom()+ " et" + matchs.get(matchCourant-1).getJoueur2().getNom(),SwingConstants.CENTER));
               }
            }
            else {panelCentre.add(new JLabel(""));}
            panelCentre.add(new JLabel(""));
            
            
            JButton btnQuitter = new JButton("Quitter");
            panelBas.add(btnQuitter);
            btnQuitter.addActionListener((ActionEvent e) -> {
                setChanged();
                notifyObservers(new MessageMenu(vAge,GestionVue.Quitter));
                clearChanged();
                });
            btnQuitter.setBackground(Color.decode("#D73535"));
            btnQuitter.setForeground(Color.decode("#FFFFFF"));
            panelBas.add(new JLabel(""));panelBas.add(new JLabel("")); 
            JButton btnclassement = new JButton("Classement");
            panelBas.add(btnclassement);
            btnclassement.addActionListener((ActionEvent e) -> {
                    setChanged();
                    notifyObservers(new MessageMenu(vAge,GestionVue.Classement));
                    clearChanged();
                });
            btnclassement.setBackground(Color.decode("#3232FF"));
            btnclassement.setForeground(Color.decode("#FFFFFF"));
        }
        else if(vAge == Moins12 && vEtape == Menu){
            //VUE MENU MOINS DE 12 ANS
            window = new JFrame(); 
            window.setIconImage(imageBackground.getImage());
            window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            // Définit la taille de la fenêtre en pixels
            window.setSize(800, 300);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
            window.setTitle("Tournoi de morpion : menu");
            
            JPanel mainPanel = new JPanel(new BorderLayout());
            window.add(mainPanel);
        
            JPanel panelCentre = new JPanel(new GridLayout(3,3)) ;
            JPanel panelBas = new JPanel(new GridLayout(1,4)) ;
            mainPanel.add(panelCentre, BorderLayout.CENTER);
            panelCentre.setBackground(Color.decode("#98FB98"));
            mainPanel.add(panelBas, BorderLayout.SOUTH);
            panelBas.setBackground(Color.decode("#98FB98"));
           // mainPanel.setBackground(Color.decode("#5DB600"));
            
           
            panelCentre.add(new JLabel(""));
            CombatDesJoueurs = new JLabel("Le match prochain opposera "+ matchs.get(matchCourant).getJoueur1().getNom() + " à " + matchs.get(matchCourant).getJoueur2().getNom(),SwingConstants.CENTER);
            panelCentre.add(CombatDesJoueurs);
            panelCentre.add(new JLabel(""));
            
            panelCentre.add(new JLabel(""));
            JButton jouer = new JButton("Jouer le match");
            panelCentre.add(jouer);
            jouer.setBackground(Color.decode("#FFFFFF"));
            
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
            
            
            JButton btnQuitter = new JButton("Quitter");
            panelBas.add(btnQuitter);
            btnQuitter.addActionListener((ActionEvent e) -> {
                setChanged();
                notifyObservers(new MessageMenu(vAge,GestionVue.Quitter));
                clearChanged();
                });
            btnQuitter.setBackground(Color.decode("#D73535"));
            btnQuitter.setForeground(Color.decode("#FFFFFF"));
            panelBas.add(new JLabel(""));panelBas.add(new JLabel("")); 
            JButton btnclassement = new JButton("Classement");
            panelBas.add(btnclassement);
            btnclassement.addActionListener((ActionEvent e) -> {
                    setChanged();
                    notifyObservers(new MessageMenu(vAge,GestionVue.Classement));
                    clearChanged();
                });
            btnclassement.setBackground(Color.decode("#3232FF"));
            btnclassement.setForeground(Color.decode("#FFFFFF"));
        }
        else{
            window = new JFrame(); 
            window.setIconImage(imageBackground.getImage());
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
    
    public VueTournois(GestionVue vEtape){     
        window = new JFrame();
        window.setIconImage(imageBackground.getImage());
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
        window.setSize(700, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        window.setTitle("Jeu du morpion : choix du mode de jeu");
        mainPanel.setBackground(Color.decode("#D3EBF2"));
        
        JPanel panelHaut = new JPanel(new GridLayout(1,3)) ;
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        
        // window.setIconImage(new ImageIcon("/src/images/morpion.png").getImage());

        panelHaut.setBackground(Color.decode("#FBEEE4")); 
        
        panelHaut.add(new JLabel(""));
        JLabel titre = new JLabel("Jeu du morpion",SwingConstants.CENTER);        
        
        titre.setFont(new Font("Arial",Font.BOLD,20));
        panelHaut.add(titre);
        panelHaut.add(new JLabel(""));

         //Choix couleur de fond : FBEEE4
        JPanel contentPanel = new JPanel (new GridLayout(4, 3));
        contentPanel.setBackground(Color.decode("#FBEEE4"));
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        contentPanel.add(new JLabel(""));
        
        JButton tournoi = new JButton("Mode tournoi");
        tournoi.setBackground(Color.decode("#FFFFFF"));
        tournoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(GestionVue.Tournoi);
                clearChanged();
            }
        });
        
        contentPanel.add(tournoi);
        contentPanel.add(new JLabel(""));
        contentPanel.add(new JLabel(""));
        JButton duel = new JButton("Mode Duel");
        duel.setBackground(Color.decode("#FFFFFF"));
        duel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(GestionVue.Duel);
                clearChanged();
            }
        });
        contentPanel.add(duel);
        contentPanel.add(new JLabel(""));
        contentPanel.add(new JLabel(""));
        JButton solo = new JButton("Mode solo");
        solo.setBackground(Color.decode("#FFFFFF"));
        solo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(GestionVue.Solo);
                clearChanged();
            }
        });
        contentPanel.add(solo);
        contentPanel.add(new JLabel(""));
        contentPanel.add(new JLabel(""));
        
        JButton btnQuitter = new JButton("Quitter le jeu");
        btnQuitter.setBackground(Color.decode("#FFFFFF"));
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChanged();
                notifyObservers(Actions.ANNULE);
                clearChanged();
            }
        });
        contentPanel.add(btnQuitter);
        contentPanel.add(new JLabel(""));
        
        JPanel botPanel = new JPanel (new GridLayout(1,1));
        mainPanel.add(botPanel, BorderLayout.SOUTH);
        botPanel.add(new JLabel("                           "));
        botPanel.setBackground(Color.decode("#FBEEE4"));
  
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
    
    public void erreurType(){
        this.erreur.setText("Le nombre de joueur doit être un chiffre !");
        this.erreur.setForeground(Color.red);
    }
    
}
