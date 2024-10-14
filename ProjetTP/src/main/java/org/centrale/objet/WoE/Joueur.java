package org.centrale.objet.WoE;

/**
 * Classe du joueur 
 * @author mattlerigolo
 */

import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;

public class Joueur {
    /**
     * Personnage joué par le joueur
     */
    public Personnage perso;
    private LinkedList<Utilisables> inventaire;
    private LinkedList<Utilisables> effets;
    
    /**
     * Constructeur par défaut
     */
    public Joueur(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Quelle classe voulez-vous jouer ? (Guerrier ou Archer) \n");
        String classe = scanner.nextLine();
        
        System.out.print("Quel nom voulez vous donner à votre personnage ? \n");
        String nom = scanner.nextLine();
        
        System.out.print("\n");
        
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
            int ptPar = random.nextInt(10)+5; // entre 5 et 15
            perso.setPtPar(ptPar);
            Epee epee = new Epee();
            epee.setPtAtt(degAtt);
            perso.setEpee(epee);
            
            this.perso = new Guerrier(perso);
        }
        else {
            System.out.println("Nom de classe non-valide, personnage non créé");
        }
        
        this.effets = new LinkedList<Utilisables>();
        this.inventaire = new LinkedList<Utilisables>();
    }
    
    /**
     * Constructeur
     * @param perso
     * Personnage à attribuer au joueur
     * @param effets
     * Inventaire du joueur
     */
    public Joueur(Personnage perso, LinkedList<Utilisables> effets){
        this.perso = new Personnage(perso);
        this.effets = new LinkedList<Utilisables>(effets);
        this.inventaire = new LinkedList<Utilisables>(inventaire);
    }
    
    /**
     * Constructeur de copie
     * @param j 
     * Joueur à copier
     */
    public Joueur(Joueur j){
        this.perso = new Personnage(j.getPerso());
        this.effets = new LinkedList<Utilisables>(j.getEffets());
        this.inventaire = new LinkedList<Utilisables>(j.getInventaire());
    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = new Personnage(perso);
    }

    public LinkedList<Utilisables> getEffets() {
        return effets;
    }

    public void setEffets(LinkedList<Utilisables> effets) {
        this.effets = new LinkedList<Utilisables>(effets);
    }

    public LinkedList<Utilisables> getInventaire() {
        return inventaire;
    }

    public void setInventaire(LinkedList<Utilisables> inventaire) {
        this.inventaire = inventaire;
    }
    
    public void deplace(int[][] plateau, int newPosX, int newPosY){
        plateau[this.perso.pos.getX()][this.perso.pos.getY()] = 0;

        boolean goodPosition = false;
        while (!goodPosition){
            if ((newPosX >= 0 && newPosX < plateau.length) && (newPosY >= 0 && newPosY < plateau[0].length) && (plateau[newPosX][newPosY] == 0)){
                goodPosition = true; // la position est valide
            }
            else { 
                System.out.println("Position invalide.");
            }
        }
        plateau[newPosX][newPosY] = this.perso.Id;
        this.perso.pos.translate(newPosX - this.perso.pos.getX(), newPosY - this.perso.pos.getY());
    }
    
    
}



