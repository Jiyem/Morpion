/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import static Modèle.EtatCase.O;
import static Modèle.EtatCase.X;

/**
 *
 * @author Jiyem
 */
public class Match {
    private Joueur joueur1;
    private Joueur joueur2;
    private EtatCase signe1 = X;
    private EtatCase signe2 = O;
     private EtatMatch finmatch;
    private Joueur gagnant;
    private Joueur perdant;
    
    public Match(Joueur j1, Joueur j2){
        this.joueur1 = j1;
        this.joueur2 = j2;
    }

    /**
     * @return the joueur1
     */
    public Joueur getJoueur1() {
        return joueur1;
    }

    /**
     * @param joueur1 the joueur1 to set
     */
    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    /**
     * @return the joueur2
     */
    public Joueur getJoueur2() {
        return joueur2;
    }

    /**
     * @param joueur2 the joueur2 to set
     */
    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    /**
     * @return the signe1
     */
    public EtatCase getSigne1() {
        return signe1;
    }

    /**
     * @param signe1 the signe1 to set
     */
    public void setSigne1(EtatCase signe1) {
        this.signe1 = signe1;
    }

    /**
     * @return the signe2
     */
    public EtatCase getSigne2() {
        return signe2;
    }

    /**
     * @param signe2 the signe2 to set
     */
    public void setSigne2(EtatCase signe2) {
        this.signe2 = signe2;
    }

    /**
     * @return the finmatch
     */
    public EtatMatch getFinmatch() {
        return finmatch;
    }

    /**
     * @param finmatch the finmatch to set
     */
    public void setFinmatch(EtatMatch finmatch) {
        this.finmatch = finmatch;
    }

    /**
     * @return the gagnant
     */
    public Joueur getGagnant() {
        return gagnant;
    }

    /**
     * @param gagnant the gagnant to set
     */
    public void setGagnant(Joueur gagnant) {
        this.gagnant = gagnant;
    }

    /**
     * @return the perdant
     */
    public Joueur getPerdant() {
        return perdant;
    }

    /**
     * @param perdant the perdant to set
     */
    public void setPerdant(Joueur perdant) {
        this.perdant = perdant;
    }
    
    
}
