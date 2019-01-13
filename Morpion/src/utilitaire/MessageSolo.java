/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import Modèle.EtatCase;
import java.util.Random;

/**
 *
 * @author Théophane
 */
public class MessageSolo {
    private int numGrille;
    private int numGrilleIA;
    private EtatCase etatCase1;
    private EtatCase etatCase2;
    private Random random;
    
    public MessageSolo(EtatCase etat,int numgrille,EtatCase etatCase2,int numGrilleIA){
        this.numGrille = numgrille;
        this.etatCase1 = etat;
        this.numGrilleIA = numGrilleIA;
        this.etatCase2 = etatCase2;
    }

    /**
     * @return the numGrille
     */
    public int getNumGrille() {
        return numGrille;
    }


    /**
     * @return the numGrilleIA
     */
    public int getNumGrilleIA() {
        return numGrilleIA;
    }

    /**
     * @return the etatCase1
     */
    public EtatCase getEtatCase1() {
        return etatCase1;
    }

    /**
     * @return the etatCase2
     */
    public EtatCase getEtatCase2() {
        return etatCase2;
    }
}
