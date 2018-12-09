/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

/**
 *
 * @author anandanj
 */
public class MessageTournois {
    private Actions action;
    private String nbJoueurs;
    private GestionVue vue;
    
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

    /**
     * @return the vue
     */
    public GestionVue getVue() {
        return vue;
    }
}
