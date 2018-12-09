/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

/**
 *
 * @author domestit
 */
public class MessageMenu {
    private GestionVue age;
    private GestionVue queFaire;
    
    public MessageMenu(GestionVue age, GestionVue queFaire){
        this.age = age;
        this.queFaire = queFaire;
        
    }

    /**
     * @return the age
     */
    public GestionVue getAge() {
        return age;
    }

    /**
     * @return the queFaire
     */
    public GestionVue getQueFaire() {
        return queFaire;
    }
}
