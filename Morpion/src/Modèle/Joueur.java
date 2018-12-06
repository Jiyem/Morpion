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
    private EtatCase signe;
    
    public Joueur(){
        this.nom = null;
        this.signe = null;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the signe
     */
    public EtatCase getSigne() {
        return signe;
    }

    /**
     * @param signe the signe to set
     */
    public void setSigne(EtatCase signe) {
        this.signe = signe;
    }
}
