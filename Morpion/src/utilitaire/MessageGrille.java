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
 * @author Jiyem
 */
public class MessageGrille {
    private Integer numGrille;
    private EtatCase etat;
    
    public MessageGrille(Integer numGrille,EtatCase etat){
        this.etat = etat;
        this.numGrille = numGrille;
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
    
}
