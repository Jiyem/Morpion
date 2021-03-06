/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modèle.EtatCase;
import Modèle.EtatMatch;
import Modèle.EtatTournoi;
import Modèle.Joueur;
import Modèle.Match;
import utilitaire.Actions;
import java.util.Observable;
import java.util.Observer;
import Vue.VueClassement;
import Vue.VueGrille;
import Vue.VueInscription;
import Vue.VueRegles;
import Vue.VueTournois;
import java.util.ArrayList;
import java.util.HashMap;
import utilitaire.GestionVue;
import static utilitaire.GestionVue.Classement;
import static utilitaire.GestionVue.DernierInscrit;
import static utilitaire.GestionVue.InitJoueurs;
import static utilitaire.GestionVue.JouerLeMatch;
import static utilitaire.GestionVue.Menu;
import static utilitaire.GestionVue.Moins12;
import static utilitaire.GestionVue.Plus12;
import static utilitaire.GestionVue.PremierInscrit;
import static utilitaire.GestionVue.Préparation;
import static utilitaire.GestionVue.Préparation2;
import static utilitaire.GestionVue.Quitter;
import utilitaire.MessageClassement;
import utilitaire.MessageDuel;
import utilitaire.MessageGrille;
import utilitaire.MessageMenu;
import utilitaire.MessageRegles;
import utilitaire.MessageSolo;
import utilitaire.MessageTournois;


public class Controleur implements Observer {

   //ihm = new ihm()
    //Personne p = new Personne(...);
    //h.show(...);
    //update
           //si A -> h.hide()
           // si V -> p.setNom()...
    
    private VueTournois v1;
    private VueInscription v2;
    private VueClassement v3;
    private VueGrille v4;
    private VueRegles v5;
    
    private ArrayList<Joueur> lJoueurs = new ArrayList<>();
    private int compteurJoueurs = 1;
    private int maxJoueurs ;
    private HashMap<Integer,Match> matchs = new HashMap<>();
    private int  matchCourant;
    private Joueur joueurCourant;
    private GestionVue age;
    private int nbMatch;
    private EtatTournoi etatTournoi= EtatTournoi.Pas_Termine;
    
    Controleur(){
        v1 = new VueTournois(Préparation);
        v1.addObserver(this);
        v1.afficher();
   
        
    }
    
        @Override
    public void update(Observable o, Object arg) {
        
        //Quitter / afficher le classement
        if (arg instanceof Actions) {
            this.faireAction((Actions) arg);
        }
        
        //Choix dans le menu principal du mode tournois.
        if(arg instanceof String){ 
            this.choixVueTournois((String) arg);
        }
        
        //Choix du mode de jeu dans le menu principal
        if(arg instanceof GestionVue){
            this.choixModeDeJeu((GestionVue) arg);
            
        }
        // Gestion des inscriptions :
        if(arg instanceof MessageTournois){
            MessageTournois message = (MessageTournois) arg ;
            // Terminer l'inscription.
            if(this.gestionInscription(message)){
                this.generationMatchs();
            }          
        }   
        //Gestion du menu
        if(arg instanceof MessageMenu){
            MessageMenu messageMenu = (MessageMenu) arg ;
            this.gestionMenu(messageMenu);
            }
        if(arg instanceof MessageDuel){
            MessageDuel messageduel = (MessageDuel) arg;
            this.gestionDuel(messageduel);
        }
        //Gestion de la grille du tournoi
        if(arg instanceof MessageGrille){
            MessageGrille messageGrille = (MessageGrille) arg;
            // /!\ fonction à optimiser grandement ! 
            this.gestionGrilleTournois(messageGrille);
        }
        //Gestion du classement
        if(arg instanceof MessageClassement){
            MessageClassement messageClassement = (MessageClassement) arg ;
            this.gestionClassement(messageClassement);
        }    
        //Gestion Regles
        if(arg instanceof MessageRegles){
            this.gestionRegles();
        }
        if(arg instanceof MessageSolo){
            MessageSolo messagesolo = (MessageSolo) arg;
            this.gestionSolo(messagesolo);
        }      
            
    }
    
    private void ClassementFinal(){
        etatTournoi = EtatTournoi.Termine;
        //Classement du nombre de joueurs
        int maxPoints = 0;
        int indiceMaxPoints = 0;
        ArrayList<Joueur> lJoueursClassé = new ArrayList<>();
        System.out.println("Ceci est un testtt");
        System.out.println(maxJoueurs);
        int x = 0;
        for(int i = 0;i<maxJoueurs;i++){
            System.out.println("je print i "+i);
            while(x<lJoueurs.size()){
                System.out.println("x : "+x);
                System.out.println("lsize: "+lJoueurs.size());
                if(lJoueurs.get(x).getNbpoints() > maxPoints){
                    maxPoints = lJoueurs.get(x).getNbpoints();
                    indiceMaxPoints = x;
                }
                x = x+1;
            }                                 
            //Maintenant qu'on a l'indice du joueur qui à fait le plus de points on va l'ajouter a l'arraylist classé
            //et le retiré de l'arraylist des joueurs.
            if(indiceMaxPoints < lJoueurs.size()){
                lJoueursClassé.add(lJoueurs.get(indiceMaxPoints));
                lJoueurs.remove(indiceMaxPoints);                                        
            }
            x=0;
            maxPoints = 0;
            indiceMaxPoints = 0;
        }
        //On créer la vue tournois avec les joueurs classé
        v3 = new VueClassement(Plus12,lJoueursClassé,matchs,etatTournoi);
        v3.afficher();
    }
    
    private void ClassementEnCours(GestionVue age){
        //Classement du nombre de joueurs
        int maxPoints = 0;
        int indiceMaxPoints = 0;
        ArrayList<Joueur> lJoueursCopie = new ArrayList<>();
        for(int i = 0;i<lJoueurs.size();i++){
            lJoueursCopie.add(lJoueurs.get(i));
        }
        
        
        ArrayList<Joueur> lJoueursClassé = new ArrayList<>();
        int x = 0;
        for(int i = 0;i<maxJoueurs;i++){
            while(x<lJoueursCopie.size()){
                if(lJoueursCopie.get(x).getNbpoints() > maxPoints){
                    maxPoints = lJoueursCopie.get(x).getNbpoints();
                    indiceMaxPoints = x;
                }
                x = x+1;
            }                                 
            //Maintenant qu'on a l'indice du joueur qui à fait le plus de points on va l'ajouter a l'arraylist classé
            //et le retiré de l'arraylist des joueurs.
            if(indiceMaxPoints < lJoueursCopie.size()){
                lJoueursClassé.add(lJoueursCopie.get(indiceMaxPoints));
                lJoueursCopie.remove(indiceMaxPoints);                                        
            }
            x=0;
            maxPoints = 0;
            indiceMaxPoints = 0;
        }
        //On créer la vue classement avec les joueurs classé
        if(age == Plus12){
            v3 = new VueClassement(Plus12,lJoueursClassé,matchs,etatTournoi);
            v3.afficher();
            v3.addObserver(this);           
        }else{
            v3 = new VueClassement(Moins12,lJoueursClassé,matchs,etatTournoi);
            v3.afficher();
            v3.addObserver(this); 
        }

    }
    
    private boolean vérifPseudo(){
        String statut = new String();
        for(int i = 0; i < lJoueurs.size();i++){
            for(int y = i +1;y <lJoueurs.size(); y++){
                if(lJoueurs.get(i).getNom().compareTo(lJoueurs.get(y).getNom())==0){
                    statut = "Identique";
                }
            }
            if(lJoueurs.get(i).getNom().isEmpty()){
                statut = "Vide";
            }
        }
        
        if(statut.compareTo("Vide") == 0){
            v2.erreurVide();
            return false;
        }else if(statut.compareTo("Identique")==0){
            v2.erreurIdentique();
            return false;
        }else{
            v2.close();
            System.out.println("Inscription des joueurs terminée");
            for(int i = 0;i<lJoueurs.size();i++){
                System.out.println(lJoueurs.get(i).getNom());
            }
            return true;
        }
       
        
    }
    
    private void choixVueTournois(String string){
        if(string != "regles"){
            if(string == "-12"){
                age = Moins12;
            }else if(string == "+12"){
                age = Plus12;
            }
            v1.close();
            v1 = new VueTournois(Préparation2,age);
            v1.addObserver(this);
            v1.afficher();            
        }else{
            v1.close();
            v5 = new VueRegles();
            v5.addObserver(this);
            v5.afficher();  
        }

    }
    
    private void choixModeDeJeu(GestionVue gv){
            if(gv == GestionVue.Tournoi){
                v1.close();
                v1 = new VueTournois(Préparation,null);
                v1.addObserver(this);
                v1.afficher();
            }
            if(gv == GestionVue.Duel){
                v1.close();
                if(v4 != null){
                    v4.close();
                }
                v4 = new VueGrille(gv,0);
                v4.addObserver(this);
                v4.afficher();
            }
            if(gv == GestionVue.Solo){
                v1.close();
                 if(v4 != null){
                    v4.close();
                }
                v4 = new VueGrille(gv,0);
                v4.addObserver(this);
                v4.afficher();
            }
            if(gv == GestionVue.Rejouer){
                v4.close();
                v4 = new VueGrille(gv,0);
                v4.addObserver(this);
                v4.afficher();
            }
            if(gv == GestionVue.Jeu){
                v4.close();
                v1 = new VueTournois(Préparation);
                v1.addObserver(this);
                v1.afficher();
            }
            
    }
    
    private void faireAction(Actions action){
        if (action == Actions.ANNULE) {
            System.out.println("L'utilisateur a abandonné");
            if(v1 != null){
                v1.close();
            }
            if(v2 != null){
                v2.close();
            }
            if(v4 != null){
               v4.close();
            }
        }
        if (action == Actions.CLASSEMENT_GENERAL) {
                //Faut afficher la vue classement avec tous les joueurs
        }
    }
    
    //S'occupe de vérifier si les les inscriptions n'ont pas d'erreur et d'enregistrer les joueurs inscrit. Retourne True si l'inscription est terminé.
    private boolean gestionInscription(MessageTournois message){
        //Début inscription
        if (message.getAction()== Actions.SUIVANT) {
            maxJoueurs = message.getNbJoueurs();
            if(maxJoueurs == 0){
                v1.erreurType();
            }
            else if(maxJoueurs > 1 && maxJoueurs <21){
                v1.close();
                v2 = new VueInscription(maxJoueurs,age);
                v2.afficher();
                v2.addObserver(this);                   
            }else{
                v1.erreurNbJoueurs();
            }
        }
        if(message.getAction() == Actions.JTERMINER){
            lJoueurs.clear();
            for(int i = 0;i<message.getPseudos().size();i++){
                Joueur j = new Joueur(message.getPseudos().get(i));
                lJoueurs.add(j);;
            }
            // Vérification sur les pseudos :   
            if(!this.vérifPseudo()){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
    
    //Termine l'initialisation du tournois avec création des matchs et du match courant.
    private void generationMatchs(){
        //Génération des matchs
                
        // A,B,C,D,E,F,G,H
        //A vs B / A vs C  / A vs D / A vs E / A vs F / A vs G / A vs H -> Flag = m -1 / itFlag = 0;
        // B vs C / B vs D / B vs E / B vs F / B vs G / B vs H -> Flag = m -2 / itFlag = 1;
        // C vs D / C vs E / c vs F / c vs G / c vs H -> Flag = m-3 / itFag = 2;
        // D vs E / D vs F / d vs G / d vs H -> Flag = m-4 / itFlag = 3;
        // E vs F / E vs g / e vs H -> Flag = m - 5 / itFlag = 4;
        // F vs G / f vs H -> Flag = m - 6 / itFlag = 5;
        // G vs H -> Flag = m - 7 / itFlag = 6;
        // Formule pour 8 joueurs : 7 + 6 + 5 + 4 + 3 + 2 + 1
        // fin de boucle quand itFlag = nbJoueurs -2;

        // nbMatch = 0;
        Integer cpt = maxJoueurs -1;
        while(cpt > 0){
            nbMatch = nbMatch + cpt;
            cpt = cpt -1;
        }
            System.out.println("Nombre de matchs: "+nbMatch);
            cpt = 1; // 2 // 3 // 4
            int flag = maxJoueurs -1; // ex de 4 joueurs, flag = 3 // 2 // 1 // 0 //2
            int itFlag = 0; //nombre de reset du flag //1 

            int joueurAct = 0; // 1
            int joueurDef = 1; // 2 // 3 // 2
            while(cpt < nbMatch +1){
                Match m = new Match(lJoueurs.get(joueurAct),lJoueurs.get(joueurDef));
                matchs.put(cpt,m);
                cpt = cpt +1;
                flag = flag -1;
                if(flag > 0){
                    joueurDef = joueurDef +1;                        
                }
                if(flag == 0){
                    itFlag = itFlag +1;
                    if(itFlag <= maxJoueurs -2){
                        flag = maxJoueurs -1 -itFlag;
                        joueurAct = joueurAct +1;
                        joueurDef = joueurAct +1;
                    }
                }
            }
            System.out.println("Fin d'initialisation du tournois");
            for(HashMap.Entry<Integer, Match> entry : matchs.entrySet()) {
                Integer key = entry.getKey();
                Match value = entry.getValue();
                System.out.println("Le matchs "+key+" opposera "+ value.getJoueur1().getNom()+ " à "+ value.getJoueur2().getNom());
            }
            //Match courant c'est la match courant.
            matchCourant = 1;
            //Le joueur courant est le joueur qui doit jouer son tour de jeu.
            joueurCourant = matchs.get(matchCourant).getJoueur1();
            //Matchs c'est la liste des matchs (hashmap) avec en clé le n° du match et en valeur le match.
            //age = plus12 ou moins12
            v1 = new VueTournois(Menu,age,matchs,matchCourant);
            v1.addObserver(this);
            v1.afficher();
    }
    
    private void gestionMenu(MessageMenu messageMenu){
        //Plus de 12 ans
        if(messageMenu.getQueFaire() == Classement){
            v1.close();
            this.ClassementEnCours(messageMenu.getAge());
        }
        if(age == Plus12 && messageMenu.getQueFaire() == Quitter){
            v1.close();
        }
        if(age == Plus12 && messageMenu.getQueFaire() == JouerLeMatch){
            v1.close();
            v4 = new VueGrille(matchCourant,matchs.get(matchCourant).getJoueur1(),matchs.get(matchCourant).getJoueur2(),age);
            v4.addObserver(this);
            v4.afficher();
            v1.close();             
        }
        //Moins de 12 ans
        if(messageMenu.getAge() == Moins12 && messageMenu.getQueFaire() == Classement){
            v1.close();
            this.ClassementEnCours(messageMenu.getAge());
        }
        if(messageMenu.getAge() == Moins12 && messageMenu.getQueFaire() == Quitter){
            v1.close();
        }
        if(messageMenu.getAge() == Moins12 && messageMenu.getQueFaire() == JouerLeMatch){
        v1.close();
        v4 = new VueGrille(matchCourant,matchs.get(matchCourant).getJoueur1(),matchs.get(matchCourant).getJoueur2(),age);
        v4.addObserver(this);
        v4.afficher();
        v1.close();             
        }
    }
    
    private void gestionDuel(MessageDuel messageduel){
        if(messageduel.getEtat()== EtatCase.NON_COCHEE){
            System.out.println("Case non cochée");
            if(messageduel.getNumJoueur()%2 == 0){
                v4.majCase(new MessageGrille(messageduel.getNumGrille(),EtatCase.O));
                v4.setNumJoueur(v4.getNumJoueur()+1);
                if(v4.verifVictoire(EtatCase.O) == EtatMatch.Victoire){
                    v4.close();
                    v4 = new VueGrille(GestionVue.Rejouer,2);
                    v4.addObserver(this);
                    v4.afficher();
                }
                else if(v4.verifVictoire(EtatCase.O) == EtatMatch.Egalite){
                    v4.close();
                    v4 = new VueGrille(GestionVue.Rejouer,0);
                    v4.addObserver(this);
                    v4.afficher();
                }
            }
            else{
                v4.majCase(new MessageGrille(messageduel.getNumGrille(),EtatCase.X));
                v4.setNumJoueur(v4.getNumJoueur()+1);
                if(v4.verifVictoire(EtatCase.X) == EtatMatch.Victoire){
                    v4.close();
                    v4 = new VueGrille(GestionVue.Rejouer,1);
                    v4.addObserver(this);
                    v4.afficher();
                }
                else if(v4.verifVictoire(EtatCase.X) == EtatMatch.Egalite){
                    v4.close();
                    v4 = new VueGrille(GestionVue.Rejouer,0);
                    v4.addObserver(this);
                    v4.afficher();
                }
            }
        }
    }
    
    private void gestionSolo(MessageSolo messagesolo){
        if(messagesolo.getEtatCase1()== EtatCase.NON_COCHEE){
            v4.majCase(new MessageGrille(messagesolo.getNumGrille(),EtatCase.X));
            if(v4.verifVictoire(EtatCase.X) == EtatMatch.Victoire){
                    v4.close();
                    v4 = new VueGrille(GestionVue.RejouerSeul,1);
                    v4.addObserver(this);
                    v4.afficher();
            }
            else if(v4.verifVictoire(EtatCase.X) == EtatMatch.Egalite){
                    v4.close();
                    v4 = new VueGrille(GestionVue.RejouerSeul,0);
                    v4.addObserver(this);
                    v4.afficher();
            }
            else{
                if (messagesolo.getEtatCase2() == EtatCase.NON_COCHEE){
                v4.majCase(new MessageGrille(messagesolo.getNumGrilleIA(),EtatCase.O));
                if(v4.verifVictoire(EtatCase.O) == EtatMatch.Victoire){
                        v4.close();
                        v4 = new VueGrille(GestionVue.RejouerSeul,2);
                        v4.addObserver(this);
                        v4.afficher();
                    }
                    else if(v4.verifVictoire(EtatCase.O) == EtatMatch.Egalite){
                        v4.close();
                        v4 = new VueGrille(GestionVue.RejouerSeul,0);
                        v4.addObserver(this);
                        v4.afficher();
                    }
                }   
            }
                
        }
        
//            if(v4.verifVictoire(EtatCase.O) == EtatMatch.Victoire){
//                    v4.close();
//                    v4 = new VueGrille(GestionVue.Rejouer,2);
//                    v4.addObserver(this);
//                    v4.afficher();
//                }
//                else if(v4.verifVictoire(EtatCase.O) == EtatMatch.Egalite){
//                    v4.close();
//                    v4 = new VueGrille(GestionVue.Rejouer,0);
//                    v4.addObserver(this);
//                    v4.afficher();
//                }
//
        }
    
    
    //Coche la case, vérifie si victoire et si match fini affiche le classement.
    private void gestionGrilleTournois(MessageGrille messageGrille){
        //si la case est vide
        if(messageGrille.getEtat()== EtatCase.NON_COCHEE){
            System.out.println("Case non cochée");
            //si le joueur actuel est le joueur 1 (donc qu'il à le signe X
            if(matchs.get(matchCourant).getJoueur1() == joueurCourant){
                System.out.println("Cochez avec X");
                v4.majCase(new MessageGrille(messageGrille.getNumGrille(),EtatCase.X));
                if(v4.verifVictoire(EtatCase.X) == EtatMatch.Victoire){ //S'il y a une victoire
                    System.out.print("VOUS AVEZ GAGNE");
                    matchs.get(matchCourant).getJoueur1().addPoints(3);
                    v4.close();
                    matchs.get(matchCourant).setGagnant(matchs.get(matchCourant).getJoueur1());
                    matchs.get(matchCourant).setPerdant(matchs.get(matchCourant).getJoueur1());
                    matchs.get(matchCourant).setFinmatch(EtatMatch.Victoire);
                    if(matchCourant == nbMatch){
                        this.ClassementFinal();
                    }
                    else {
                        matchCourant = matchCourant+1;
                        v1 = new VueTournois(Menu,age,matchs,matchCourant);
                        v1.addObserver(this);
                        v1.afficher();
                    }
                }
                else if(v4.verifVictoire(EtatCase.X) == EtatMatch.Egalite){ //S'il il y a une egalité
                    System.out.print("Egalité");
                    matchs.get(matchCourant).getJoueur1().addPoints(1);
                    matchs.get(matchCourant).getJoueur2().addPoints(1);
                    v4.close();
                    matchs.get(matchCourant).setGagnant(null);
                    matchs.get(matchCourant).setPerdant(null);
                    matchs.get(matchCourant).setFinmatch(EtatMatch.Egalite);
                    if(matchCourant == nbMatch){
                        this.ClassementFinal();
                    }
                    else {
                        matchCourant = matchCourant+1;
                        v1 = new VueTournois(Menu,age,matchs,matchCourant);
                        v1.addObserver(this);
                        v1.afficher();
                    }
                }
            }    
            else{
                System.out.println("Cochez avec O");
                v4.majCase(new MessageGrille(messageGrille.getNumGrille(),EtatCase.O));
                if (v4.verifVictoire(EtatCase.O) == EtatMatch.Victoire){ //S'il y a une victoire
                    System.out.print("VOUS AVEZ GAGNE");
                    matchs.get(matchCourant).getJoueur2().addPoints(3);
                    v4.close();
                    matchs.get(matchCourant).setGagnant(matchs.get(matchCourant).getJoueur2());
                    matchs.get(matchCourant).setPerdant(matchs.get(matchCourant).getJoueur1());
                    matchs.get(matchCourant).setFinmatch(EtatMatch.Victoire);
                    if(matchCourant == nbMatch){
                        this.ClassementFinal();
                    }
                    else {
                        matchCourant = matchCourant+1;
                        v1 = new VueTournois(Menu,age,matchs,matchCourant);
                        v1.addObserver(this);
                        v1.afficher();
                    }
                }
                else if(v4.verifVictoire(EtatCase.O) == EtatMatch.Egalite){ //S'il il y a une egalité
                    System.out.print("Egalité");
                    matchs.get(matchCourant).getJoueur1().addPoints(1);
                    matchs.get(matchCourant).getJoueur2().addPoints(1);
                    v4.close();
                    matchs.get(matchCourant).setGagnant(null);
                    matchs.get(matchCourant).setPerdant(null);
                    matchs.get(matchCourant).setFinmatch(EtatMatch.Egalite);
                    if(matchCourant == nbMatch){
                        this.ClassementFinal();
                    }
                    else {
                        matchCourant = matchCourant+1;
                        v1 = new VueTournois(Menu,age,matchs,matchCourant);
                        v1.addObserver(this);
                        v1.afficher();
                    }
                               
                }
            }
            //Changement de joueur courant
            if(joueurCourant == matchs.get(matchCourant).getJoueur1()){
                joueurCourant = matchs.get(matchCourant).getJoueur2();
            }else{
                joueurCourant = matchs.get(matchCourant).getJoueur1(); 
            }
            v4.setJoueurCourant(joueurCourant);
        }
        //si la case est cochée
        else{
            System.out.println("La case est déjà sélectionné");
        }
            
    }
    
    private void gestionClassement(MessageClassement messageClassement){
        v3.close();
        v1 = new VueTournois(messageClassement.getQueFaire(),messageClassement.getAge(),matchs,matchCourant);
        v1.addObserver(this);
        v1.afficher();
    }
    
    private void gestionRegles(){
        v5.close();
        v1 = new VueTournois(GestionVue.Préparation,GestionVue.Moins12);
        v1.addObserver(this);
        v1.afficher();
    }
}
