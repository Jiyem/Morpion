/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import javax.swing.JFrame;

/**
 *
 * @author domestit
 */
public class Joueur {
    private final String nom;
    private int nbpoints;
    
    public Joueur(String nom){
        this.nom = nom;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the nbpoints
     */
    public int getNbpoints() {
        return nbpoints;
    }

    /**
     * @param nbpoints the nbpoints to set
     */
    public void setNbpoints(int nbpoints) {
        this.nbpoints = nbpoints;
    }
}
