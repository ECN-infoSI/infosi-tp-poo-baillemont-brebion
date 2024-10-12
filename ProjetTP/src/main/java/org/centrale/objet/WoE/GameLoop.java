/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import org.centrale.objet.WoE.Monstre;
import java.util.LinkedList;

/**
 *
 * @author morga
 */
public class GameLoop {
    private boolean gameOver = false;
    private World_arrayList monde;
    
    
    public GameLoop(World_arrayList monde) {
        this.monde = monde;
    }
    
    public void startGame(World_arrayList monde) {
        monde.getJoueur().getPerso().affiche();
        
        monde.affichePlateau();
        while (!gameOver) {
            // Update stage
            updateGame();

            // Render stage
            renderGame();

            // Repeat stage
            try {
                Thread.sleep(16); // 16ms = 60fps
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Déplacement du personnage sur une case choisie par le joueur.
     */
    private void deplaceJoueur() {
        Scanner scanner = new Scanner(System.in);
        // Afficher la position du joueur
        System.out.println("Position du joueur : (" + monde.getJoueur().perso.getPos().getX() + ", " + monde.getJoueur().perso.getPos().getY() + ")");
        //Afficher les cases accessibles autour du joueur
        System.out.println("Cases accessibles :");
        int x = monde.getJoueur().perso.getPos().getX();
        int y = monde.getJoueur().perso.getPos().getY();
        int[][] casesAccessibles = new int[3][3];
        int compteur = 1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < monde.getPlateau().length && newY >= 0 && newY < monde.getPlateau()[0].length) {
                    if (monde.getPlateau()[newX][newY] == 0) {
                        casesAccessibles[i + 1][j + 1] = compteur;
                        compteur++;
                    }
                    else if (i == 0 && j == 0){
                        // case actuelle est toujours disponible pour le déplacement
                        casesAccessibles[1][1] = compteur;
                        compteur++;
                    }
                    else {
                        casesAccessibles[i + 1][j + 1] = 0;
                    }
                } else {
                    casesAccessibles[i + 1][j + 1] = 0;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (casesAccessibles[i][j] != 0) {
                    System.out.println("Case " + casesAccessibles[i][j] + " : (" + (x - 1 + i) + ", " + (y - 1 + j) + ")");
                }
            }
        }
        
        // Demander au joueur de choisir une case
        System.out.println("Choisissez une case :");
        int choix = scanner.nextInt();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (casesAccessibles[i][j] == choix) {
                    int newX = x - 1 + i;
                    int newY = y - 1 + j;
                    monde.getJoueur().deplace(monde.getPlateau(), newX, newY);
                }
            }
        }
        for (Utilisables objet : this.monde.getObjets()){
            if (objet instanceof PotionSoin) {
            // Traiter l'objet comme une PotionSoin
                PotionSoin potion = (PotionSoin) objet;
                if (potion.getPos().samePosition(monde.getJoueur().getPerso().getPos())){
                    monde.getJoueur().getInventaire().add(potion);
                    System.out.println("Objet ajouté à l'inventaire !");
                }
            }       
            else if (objet instanceof Nourriture) {
            // Traiter l'objet comme une Nourriture
                Nourriture nourriture = (Nourriture) objet;
                if (nourriture.getPos().samePosition(monde.getJoueur().getPerso().getPos())){
                    monde.getJoueur().getInventaire().add(nourriture);
                    System.out.println("Objet ajouté à l'inventaire !");
                }
    }
        }
    }
        
     
    private void combattre(){
        // Trouve des créatures à combattre
        
        Scanner scanner = new Scanner(System.in);
        // Afficher la position du joueur
        System.out.println("Position du joueur : (" + monde.getJoueur().perso.getPos().getX() + ", " + monde.getJoueur().perso.getPos().getY() + ")");
        //Afficher les cases accessibles autour du joueur
        System.out.println("Créatures à combattre :");
        int compteur = 1;
        ArrayList<Creature> creatures = new ArrayList<>();
        for (Personnage perso : monde.getPersonnages()){
            creatures.add((Creature)perso); 
        }
        for (Monstre monstre : monde.getMonstres()){
            creatures.add((Creature)monstre); 
        }
        for (Creature creature : creatures) {
            System.out.println("Créature " + creature.getId() + " : ");
            creature.affiche();
            compteur ++;
        }
        // Demander au joueur de choisir une case
        System.out.println("Choisissez une créature :");
        int choix = scanner.nextInt();
        if (monde.getJoueur().perso instanceof Combattant){
            Combattant comb = (Combattant)(monde.getJoueur().perso);
            comb.combattre(creatures.get(choix - 1));
        }   
    }
    
    private void consommer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Objets dans l'inventaire :");
        int compteur = 1;
        LinkedList<Utilisables> inventaire = this.monde.getJoueur().getInventaire();
        LinkedList<Utilisables> effets = this.monde.getJoueur().getEffets();
        for (Utilisables objet : inventaire){
            System.out.println("Objet " + compteur + " : ");
            System.out.println(objet.getClass().getSimpleName() + "\n");
            compteur++;
        }
        System.out.println("Choisissez un objet à consommer :");
        int choix = scanner.nextInt();
        if (choix >= 1 && choix <= inventaire.size()){
            Utilisables objetChoisi = inventaire.get(choix - 1); // Récupérer l'objet (indices commençant à 0)
            // Ajouter l'objet à la liste des effets
            if (objetChoisi instanceof Nourriture){
                Nourriture nourriture = (Nourriture) objetChoisi;
                effets.add(nourriture);
                // Supprimer l'objet de l'inventaire
                inventaire.remove(objetChoisi);
                System.out.println(objetChoisi.getClass().getSimpleName() + " a été consommé et ajouté aux effets.");
                nourriture.mangerPar(this.monde.getJoueur().getPerso());
                
            }
            else if (objetChoisi instanceof PotionSoin){
                PotionSoin potion = (PotionSoin) objetChoisi;
                this.monde.getJoueur().getPerso().boirePotion(potion);
            }
            
            
        }
        else {
            System.out.println("Choix non valide, aucune action effectuée");
        }
        
    }
    
    private void updateEffets(){
        LinkedList<Utilisables> effets = this.monde.getJoueur().getEffets();
        for (Utilisables objet : effets){
            if (objet instanceof Nourriture){
                Nourriture nourriture = (Nourriture) objet;
                nourriture.passerTour();
                if (nourriture.effetFini()){
                    nourriture.finEffet(this.monde.getJoueur().getPerso());
                }
            }
        }
    }
    
    private void updateGame() {
        // Update game state, handle user input, and perform calculations
        this.updateEffets();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous vous déplacer ou combattre ou consommer un objet de votre inventaire ? ('Se déplacer' ou 'Combattre' ou 'Consommer')");
        String classe = scanner.nextLine();
        
        if (classe.equalsIgnoreCase("Se déplacer")){
            deplaceJoueur();
        }
        else if(classe.equalsIgnoreCase("Combattre")){
            combattre();
        }
        else if(classe.equalsIgnoreCase("Consommer")){
            consommer();
        }
        else{
            System.out.println("Action non-valide, pas d'action effectuée");
        }
        if (monde.getJoueur().perso.ptVie == 0) {
            gameOver = true; 
            System.out.println("GAME OVER");
        }
        // on fait se déplacer tous les personnages
        for (Personnage perso : this.monde.getPersonnages()){
            perso.deplace(this.monde.getPlateau());
        }
        
        // on fait se déplacer tous les monstres
        for (Monstre monstre : this.monde.getMonstres()){
            monstre.deplace(this.monde.getPlateau());
        }
    }

    private void renderGame() {
        // Render the updated game state to the screen
        monde.getJoueur().perso.affiche();
        this.monde.affichePlateau();
    }
}