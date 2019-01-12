/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import Modèle.EtatCase;
import static Modèle.EtatCase.O;
import static Modèle.EtatCase.X;

/**
 *
 * @author Théophane
 */
public class MessageDuel {
    private Integer numGrille;
    private EtatCase etat;
    private Integer numJoueur;
    
    public MessageDuel(Integer numGrille,EtatCase etat,Integer numJoueur){
        this.etat = etat;
        this.numGrille = numGrille;
        this.numJoueur = numJoueur;
    }
    
    public String NouvEtatCase(){
        if(this.etat == X){
            return "X";
        }
        else if(this.etat == O){
            return "O";
        }
        else{
            return "";
        }
    }

    /**
     * @return the numGrille
     */
    public int getNumGrille() {
        return numGrille;
    }

    /**
     * @param numGrille the numGrille to set
     */
    public void setNumGrille(Integer numGrille) {
        this.numGrille = numGrille;
    }

    /**
     * @return the etat
     */
    public EtatCase getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(EtatCase etat) {
        this.etat = etat;
    }

    /**
     * @return the numJoueur
     */
    public Integer getNumJoueur() {
        return numJoueur;
    }

    /**
     * @param numJoueur the numJoueur to set
     */
    public void setNumJoueur(Integer numJoueur) {
        this.numJoueur = numJoueur;
    }
}
