/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

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
    
    VueTournois v1 = new VueTournois();
    
    
    Controleur(){
        System.out.println("test");
        v1.addObserver(this);
//        v1.show(p1);
        v1.afficher();
    }
    
        @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Actions) {
            System.out.println("L'utilisateur a abandonné");
            ((VueTournois) o).close();
        }
    }
    
}
