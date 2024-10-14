package org.centrale.objet.WoE;

/**
 * Classe du joueur 
 * @author mattlerigolo
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;
import java.util.StringTokenizer;

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
    public Joueur(Personnage perso, LinkedList<Utilisables> effets, LinkedList<Utilisables> inventaire){
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
    
    /**
     * Déplace le personnage du joueur sur une case choisie
     * @param plateau
     * Plateau du jeu
     * @param newPosX
     * Valeur X de l'endroit où l'on veut se déplacer
     * @param newPosY 
     * Valeur Y de l'endroit où l'on veut se déplacer
     */
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
    
    public Joueur create(String ligne){
        // tokenisation
        
        StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
        ArrayList<String> mots_ligne = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            mot = mot.toLowerCase(); // mot en minuscules
            mots_ligne.add(mot);
        }
        if (mots_ligne.get(1).equals("Archer")){
            Archer personnage = new Archer(mots_ligne.get(2), Integer.parseInt(mots_ligne.get(3)), Integer.parseInt(mots_ligne.get(4)), Integer.parseInt(mots_ligne.get(5)), Integer.parseInt(mots_ligne.get(6)), Integer.parseInt(mots_ligne.get(7)), Integer.parseInt(mots_ligne.get(8)), new Point2D(Integer.parseInt(mots_ligne.get(9)), Integer.parseInt(mots_ligne.get(10))), Integer.parseInt(mots_ligne.get(11)));
            Joueur joueur = new Joueur(personnage, new LinkedList<Utilisables>(), new LinkedList<Utilisables>());
            return joueur;
        }       
        else if (mots_ligne.get(1).equals("Guerrier")){
            Epee epee_guerrier = new Epee(Integer.parseInt(mots_ligne.get(11)), Integer.parseInt(mots_ligne.get(12)), mots_ligne.get(13));
            Guerrier personnage = new Guerrier(mots_ligne.get(2), Integer.parseInt(mots_ligne.get(3)), Integer.parseInt(mots_ligne.get(4)), Integer.parseInt(mots_ligne.get(5)), Integer.parseInt(mots_ligne.get(6)), Integer.parseInt(mots_ligne.get(7)), Integer.parseInt(mots_ligne.get(8)), new Point2D(Integer.parseInt(mots_ligne.get(9)), Integer.parseInt(mots_ligne.get(10))), epee_guerrier);
            Joueur joueur = new Joueur(personnage, new LinkedList<Utilisables>(), new LinkedList<Utilisables>());
            return joueur;
        }
        else {
            return new Joueur();
        }
    }
    
    public String ligneSauvegarde(){
        if (this.getPerso() instanceof Archer){
            Archer archer = (Archer) this.getPerso();
            return this.getClass().getSimpleName() + 
                " " + archer.getClass().getSimpleName() +
                " " + archer.getPtVie() + 
                " " + archer.getDegAtt() + 
                " " + archer.getPtPar() +
                " " + archer.getPageAtt() +
                " " + archer.getPagePar() +
                " " + archer.getDistMaxAtt() +
                " " + archer.getPos().getX() +
                " " + archer.getPos().getY() +
                " " + archer.getNbFleches();
        }
        else if (this.getPerso() instanceof Guerrier){
            Guerrier guerrier = (Guerrier) this.getPerso();
            return this.getClass().getSimpleName() + 
                " " + guerrier.getClass().getSimpleName() +
                " " + guerrier.getPtVie() + 
                " " + guerrier.getDegAtt() + 
                " " + guerrier.getPtPar() +
                " " + guerrier.getPageAtt() +
                " " + guerrier.getPagePar() +
                " " + guerrier.getDistMaxAtt() +
                " " + guerrier.getPos().getX() +
                " " + guerrier.getPos().getY() +
                " " + guerrier.getEpee().getPtAtt() +
                " " + guerrier.getEpee().getPtPar() +
                " " + guerrier.getEpee().getNom();
        }
        else  {
            return "";
        }
    }
    
}



