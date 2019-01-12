/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import java.util.ArrayList;

/**
 *
 * @author anandanj
 */
public class MessageTournois {
    private Actions action;
    private String nbJoueurs;
    private GestionVue vue;
    private ArrayList<String> pseudos;
    
    public MessageTournois(ArrayList<String> pseudos,Actions action){
        this.pseudos = pseudos;
        this.action = action;
    }
    
    public MessageTournois(String nbJoueurs, Actions action){
        this.nbJoueurs = nbJoueurs;
        this.action = action;
    }
    public MessageTournois(String nbJoueurs, Actions action , GestionVue vue){
        this.nbJoueurs = nbJoueurs;
        this.action = action;
    }
    
    public MessageTournois(int nbJoueurs, Actions action){
        this.nbJoueurs = Integer.toString(nbJoueurs);
        this.action = action;
    }
    
    public String getNomJoueur(){
        return nbJoueurs;
    }
    
    public int getNbJoueurs(){
        int i = Integer.parseInt(nbJoueurs);
        return i;
    }
    
    public Actions getAction(){
        return this.action;
    }
    
    public ArrayList<String> getPseudos(){
        return this.pseudos;
    }

    /**
     * @return the vue
     */
    public GestionVue getVue() {
        return vue;
    }
}
