/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;
import java.util.Scanner;

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
                    } else {
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
    }
        
     
    private void combattre(){
        // Trouve des créatures à combattre
        
        Scanner scanner = new Scanner(System.in);
        // Afficher la position du joueur
        System.out.println("Position du joueur : (" + monde.getJoueur().perso.getPos().getX() + ", " + monde.getJoueur().perso.getPos().getY() + ")");
        //Afficher les cases accessibles autour du joueur
        System.out.println("Créatures à combattre :");
        int x = monde.getJoueur().perso.getPos().getX();
        int y = monde.getJoueur().perso.getPos().getY();
        int[][] creaturesAccessibles = new int[3][3];
        int compteur = 1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < monde.getPlateau().length && newY >= 0 && newY < monde.getPlateau()[0].length) {
                    if (monde.getPlateau()[newX][newY] != 0) {
                        creaturesAccessibles[i + 1][j + 1] = compteur;
                        compteur++;
                    } else {
                        creaturesAccessibles[i + 1][j + 1] = 0;
                    }
                } else {
                    creaturesAccessibles[i + 1][j + 1] = 0;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (creaturesAccessibles[i][j] != 0) {
                    Creature c = (Creature)monde.getObjet(monde.getPlateau()[x + i][y + j]);
                    System.out.println("Créature " + creaturesAccessibles[i][j] + " : ");
                    c.affiche();
                }
            }
        }

        // Demander au joueur de choisir une case
        System.out.println("Choisissez une case :");
        int choix = scanner.nextInt();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (creaturesAccessibles[i][j] == choix) {
                    Creature c = (Creature)monde.getObjet(monde.getPlateau()[x + i][y + j]);
                    if (monde.getJoueur().perso instanceof Combattant comb){
                        comb.combattre(c);
                    }
                }
            }
        }
    }
    private void updateGame() {
        // Update game state, handle user input, and perform calculations
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous vous déplacer ou combattre ? ('Se déplacer' ou 'Combattre')");
        String classe = scanner.nextLine();
        
        if (classe.equalsIgnoreCase("Se déplacer")){
            deplaceJoueur();
        }
        else if(classe.equalsIgnoreCase("Combattre")){
            combattre();
        }
        else{
            System.out.println("Action non-valide, pas d'action effectuée");
        }
    }

    private void renderGame() {
        // Render the updated game state to the screen
        this.monde.affichePlateau();
    }
}