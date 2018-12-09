/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modèle.Joueur;
import Modèle.Match;
import utilitaire.Actions;
import java.util.Observable;
import java.util.Observer;
import Vue.VueClassement;
import Vue.VueInscription;
import Vue.VueTournois;
import java.util.ArrayList;
import java.util.HashMap;
import utilitaire.GestionVue;
import static utilitaire.GestionVue.Classement;
import static utilitaire.GestionVue.DernierInscrit;
import static utilitaire.GestionVue.InitJoueurs;
import static utilitaire.GestionVue.JouerLeMatch;
import static utilitaire.GestionVue.Menu;
import static utilitaire.GestionVue.Moins12;
import static utilitaire.GestionVue.Plus12;
import static utilitaire.GestionVue.PremierInscrit;
import static utilitaire.GestionVue.Préparation;
import static utilitaire.GestionVue.Préparation2;
import static utilitaire.GestionVue.Quitter;
import utilitaire.MessageGrille;
import utilitaire.MessageMenu;
import utilitaire.MessageTournois;


public class Controleur implements Observer {

   //ihm = new ihm()
    //Personne p = new Personne(...);
    //h.show(...);
    //update
           //si A -> h.hide()
           // si V -> p.setNom()...
    
    private VueTournois v1;
    private VueInscription v2 = new VueInscription();
    private VueClassement v3;
    private ArrayList<Joueur> lJoueurs = new ArrayList<>();
    private int compteurJoueurs = 1;
    private int maxJoueurs ;
    private HashMap<Integer,Match> matchs = new HashMap<>();
    private int  matchCourant;
    private GestionVue age;
    
    Controleur(){
        v1 = new VueTournois(Préparation,null);
        v1.addObserver(this);
        v1.afficher();
   
        
    }
    
        @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Actions) {
            if (((Actions) arg) == Actions.ANNULE) {
            System.out.println("L'utilisateur a abandonné");
            v1.close();v2.close();
            }
            if (((Actions) arg) == Actions.CLASSEMENT_GENERAL) {
                //Faut afficher la vue classement avec tous les joueurs
            }}

        if(arg == "-12"){
                v1.close();
                age = Moins12;
                v1 = new VueTournois(Préparation2,age);
                v1.addObserver(this);
                v1.afficher();
            }
        if(arg == "+12"){
                v1.close();
                age = Plus12;
                v1 = new VueTournois(Préparation2,age);
                v1.addObserver(this);
                v1.afficher();
            }
        
        // Contrôle pour la vue +12 ans de VueTournois :
        
        if(arg instanceof MessageTournois){
            MessageTournois message = (MessageTournois) arg ;
            //Premier joueur à s'inscrire
            if (message.getAction()== Actions.SUIVANT) {
                maxJoueurs = message.getNbJoueurs();
                v1.close();
                v2 = new VueInscription(PremierInscrit);
                v2.afficher();
                v2.show(compteurJoueurs);
                v2.addObserver(this);
            }
            //Les Joueurs qui s'inscrivent.
            if (message.getAction() == Actions.JSUIVANT && compteurJoueurs < maxJoueurs ){
                compteurJoueurs = compteurJoueurs +1;
                Joueur j = new Joueur(message.getNomJoueur());
                lJoueurs.add(j);
                v2.close();
                v2 = new VueInscription();
                v2.afficher();
                v2.show(compteurJoueurs);
                v2.addObserver(this);               
            }
            //Retour au joueur précédent.
            if (message.getAction() == Actions.JPRECEDENT ){
                compteurJoueurs = compteurJoueurs - 1;
                v2.close();
                v2 = new VueInscription();
                v2.afficher();
                v2.show(compteurJoueurs);
                v2.addObserver(this);
            }
            // Dernier joueur à s'inscrire.
            if (message.getAction() == Actions.JSUIVANT && compteurJoueurs == maxJoueurs ){
                compteurJoueurs = maxJoueurs;
                v2.close();
                v2 = new VueInscription(DernierInscrit);
                v2.afficher();
                v2.show(compteurJoueurs);
                v2.addObserver(this);
            }
            // Terminer l'inscription.
            if(message.getAction() == Actions.JTERMINER){
                Joueur j = new Joueur(message.getNomJoueur());
                lJoueurs.add(j);;
                v2.close();
                System.out.println("Inscription des joueurs terminée");
                for(int i = 0;i<lJoueurs.size();i++){
                    System.out.println(lJoueurs.get(i).getNom());
                }
                //Génération des matchs
                
                // A,B,C,D,E,F,G,H
                //A vs B / A vs C  / A vs D / A vs E / A vs F / A vs G / A vs H -> Flag = m -1 / itFlag = 0;
                // B vs C / B vs D / B vs E / B vs F / B vs G / B vs H -> Flag = m -2 / itFlag = 1;
                // C vs D / C vs E / c vs F / c vs G / c vs H -> Flag = m-3 / itFag = 2;
                // D vs E / D vs F / d vs G / d vs H -> Flag = m-4 / itFlag = 3;
                // E vs F / E vs g / e vs H -> Flag = m - 5 / itFlag = 4;
                // F vs G / f vs H -> Flag = m - 6 / itFlag = 5;
                // G vs H -> Flag = m - 7 / itFlag = 6;
                // Formule pour 8 joueurs : 7 + 6 + 5 + 4 + 3 + 2 + 1
                // fin de boucle quand itFlag = nbJoueurs -2;
                
                int nbMatch = 0;
                Integer cpt = maxJoueurs -1;
                while(cpt > 0){
                    nbMatch = nbMatch + cpt;
                    cpt = cpt -1;
                }
                 System.out.println(nbMatch);
                 
                cpt = 1; // 2 // 3 // 4
                int flag = maxJoueurs -1; // ex de 4 joueurs, flag = 3 // 2 // 1 // 0 //2
                int itFlag = 0; //nombre de reset du flag //1 
                
                int joueurAct = 0; // 1
                int joueurDef = 1; // 2 // 3 // 2
                        System.out.println(itFlag);
                while(cpt < nbMatch +1){
                    Match m = new Match(lJoueurs.get(joueurAct),lJoueurs.get(joueurDef));
                    matchs.put(cpt,m);
                    cpt = cpt +1;
                    flag = flag -1;
                    if(flag > 0){
                        joueurDef = joueurDef +1;                        
                    }
                    if(flag == 0){
                        itFlag = itFlag +1;
                        System.out.println(itFlag);
                        System.out.println(maxJoueurs);
                        if(itFlag <= maxJoueurs -2){
                        flag = maxJoueurs -1 -itFlag;
                        joueurAct = joueurAct +1;
                        joueurDef = joueurAct +1;
                        }
                    }
                 
                
                }
                    System.out.println("Fin d'initialisation du tournois");
                    for(HashMap.Entry<Integer, Match> entry : matchs.entrySet()) {
                        Integer key = entry.getKey();
                        Match value = entry.getValue();
                        System.out.println("Le matchs "+key+" opposera "+ value.getJoueur1().getNom()+ " à "+ value.getJoueur2().getNom());
                    
                    }
                matchCourant = 1;
                v1 = new VueTournois(Menu,age,matchs,matchCourant);
                v1.addObserver(this);
                v1.afficher();
                }
            
            //Gestion du menu
            if(arg instanceof MessageMenu){
                MessageMenu messageMenu = (MessageMenu) arg ;
                v1.close();
                if(messageMenu.getAge() == Plus12 && messageMenu.getQueFaire() == Classement){
                    v3 = new VueClassement(Plus12);
                }
                if(messageMenu.getAge() == Plus12 && messageMenu.getQueFaire() == Quitter){
                   //On a déjà fermé la Vue à l'appui d'un bouton donc on ne fait rien
                }
                if(messageMenu.getAge() == Plus12 && messageMenu.getQueFaire() == JouerLeMatch){
                   v1.close();
                   //Bah la faudra lancer le match ave cle numero correspondant
                        
                }
            }
            }
            //Gestion de la grille
            if(arg instanceof MessageGrille){
                
            }
    }
}
