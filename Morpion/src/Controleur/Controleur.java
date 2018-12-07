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
import static utilitaire.GestionVue.InitJoueurs;
import static utilitaire.GestionVue.Moins12;
import static utilitaire.GestionVue.Plus12;
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
    
    VueTournois v1 = new VueTournois(Préparation);
    VueInscription v2 = new VueInscription(0);
    VueClassement v3 = new VueClassement();
    
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
            ((VueTournois) o).close();
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
//            if (((Actions) arg) == Actions.SUIVENT) {
                v1.close();
                int nbJoueurs = ((MessageTournois) arg).getNbJoueurs();
                v2 = new VueInscription(nbJoueurs);
                v2.afficher();
                v2.addObserver(this);
                v2.show(nbJoueurs);
//            }
//        }
        }
    }
}
