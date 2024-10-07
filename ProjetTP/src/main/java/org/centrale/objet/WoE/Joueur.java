package org.centrale.objet.WoE;

/**
 * Classe du joueur 
 * @author mattlerigolo
 */

import java.util.Scanner;
import java.util.Random;

public class Joueur {
    /**
     * Personnage joué par le joueur
     */
    public Personnage perso;
    
    /**
     * Constructeur par défaut
     */
    public Joueur(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Quelle classe voulez-vous jouer ? (Guerrier ou Archer)");
        String classe = scanner.nextLine();
        
        System.out.print("Quel nom voulez vous donner à votre personnage ?");
        String nom = scanner.nextLine();
        
        if (classe.equalsIgnoreCase("Archer")){
            Archer perso = new Archer();
            perso.setNom(nom);
            int ptVie = random.nextInt(50)+50; // points de vie entre 50 et 100
            perso.setPtVie(ptVie);
            int degAtt = random.nextInt(10)+5; // degats d'attaque entre 5 et 15
            perso.setDegAtt(degAtt);
            int pagePar = random.nextInt(101); // entre 0 et 100
            perso.setPagePar(pagePar);
            int pageAtt = random.nextInt(101); // entre 0 et 100
            perso.setPageAtt(pageAtt);
            int distMaxAtt = random.nextInt(7)+3; // entre 3 et 10
            perso.setDistMaxAtt(distMaxAtt);
            int nbFleches = random.nextInt(10)+5; // entre 5 et 15
            perso.setNbFleches(nbFleches);
            
            this.perso = new Archer(perso);
            
        }
        else if (classe.equalsIgnoreCase("Guerrier")){
            Guerrier perso = new Guerrier();
            perso.setNom(nom);
            int ptVie = random.nextInt(50)+75; // points de vie entre 75 et 125
            perso.setPtVie(ptVie);
            int degAtt = random.nextInt(15)+15; // degats d'attaque entre 15 et 30
            perso.setDegAtt(degAtt);
            int pagePar = random.nextInt(101); // entre 0 et 100
            perso.setPagePar(pagePar);
            int pageAtt = random.nextInt(101); // entre 0 et 100
            perso.setPageAtt(pageAtt);
            Epee epee = new Epee();
            epee.setPtAtt(degAtt);
            perso.setEpee(epee);
            
            this.perso = new Guerrier(perso);
        }
        else {
            System.out.println("Nom de classe non-valide, personnage non créé");
        }
    }
    
    /**
     * Constructeur
     * @param perso
     * Personnage à attribuer au joueur
     */
    public Joueur(Personnage perso){
        this.perso = new Personnage(perso);
    }
    
    /**
     * Constructeur de copie
     * @param j 
     * Joueur à copier
     */
    public Joueur(Joueur j){
        this.perso = new Personnage(j.getPerso());
    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = new Personnage(perso);
    }
    
    
}



