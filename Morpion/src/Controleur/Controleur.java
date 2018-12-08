/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import utilitaire.Actions;
import java.util.Observable;
import java.util.Observer;
import Vue.VueClassement;
import Vue.VueInscription;
import Vue.VueTournois;
import java.util.ArrayList;
import static utilitaire.GestionVue.DernierInscrit;
import static utilitaire.GestionVue.InitJoueurs;
import static utilitaire.GestionVue.Moins12;
import static utilitaire.GestionVue.Plus12;
import static utilitaire.GestionVue.PremierInscrit;
import static utilitaire.GestionVue.Préparation;
import utilitaire.MessageTournois;

/**
 *
 * @author Eric
 */
public class Controleur implements Observer {

   //ihm = new ihm()
    //Personne p = new Personne(...);
    //h.show(...);
    //update
           //si A -> h.hide()
           // si V -> p.setNom()...
    
    private VueTournois v1 = new VueTournois(Préparation);
    private VueInscription v2 = new VueInscription();
    private VueClassement v3 = new VueClassement();
    private ArrayList<String> lNomJoueurs = new ArrayList<>();
    private int compteurJoueurs = 1;
    private int maxJoueurs ;
    
    Controleur(){
        v1.addObserver(this);
        v1.afficher();
//        v2.addObserver(this);
//        v2.afficher();
        v3.addObserver(this);
        v3.afficher();
        
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
                v1 = new VueTournois(Moins12);
                v1.addObserver(this);
                v1.afficher();
            }
        if(arg == "+12"){
                v1.close();
                v1 = new VueTournois(Plus12);
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
                lNomJoueurs.add(message.getNomJoueur());
                v2.close();
                v2 = new VueInscription();
                v2.afficher();
                v2.show(compteurJoueurs);
                v2.addObserver(this);               
            }
            //Retour au joueur précédent.
            if (message.getAction() == Actions.JPRECEDENT){
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
                lNomJoueurs.add(message.getNomJoueur());
                v2.close();
                v2 = new VueInscription(DernierInscrit);
                v2.afficher();
                v2.show(compteurJoueurs);
                v2.addObserver(this);
            }
            // Terminer l'inscription.
            if(message.getAction() == Actions.JTERMINER){
                lNomJoueurs.add(message.getNomJoueur());
                v2.close();
                System.out.println("Inscription des joueurs terminer");
                for(int i = 0;i<lNomJoueurs.size();i++){
                    System.out.println(lNomJoueurs.get(i));
                }
                
            }
        }
    }
}
