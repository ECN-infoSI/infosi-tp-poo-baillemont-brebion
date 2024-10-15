/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author morga
 */
public class MesureTemps {
 
    public static void main(String[] args) {
    for (int k = 100; k < 10000000; k*=10) {
        int totalpdv = 0;
        World_arrayList world1 = new World_arrayList(5000,5000,true);

        world1.creaMondeAlea (
        k, 0, 0, 0, 0, 0, 0, 0, 0);  
        long debutN = System.nanoTime();
        for (int i = 0; i < world1.getPersonnages().size(); i++) {
            totalpdv += world1.getPersonnages().get(i).getPtVie();
        }
   
        long finN = System.nanoTime();
        System.out.println (k + " protagonistes, "+"temps ecoule : "+(finN-debutN)+", nombre total de points de vie :"+ totalpdv);
        int totalpdv2 = 0;
        long debutN2 = System.nanoTime();
        
        for (Personnage perso : world1.getPersonnages()) {
                totalpdv2 += perso.getPtVie();
            }
        long finN2 = System.nanoTime();
        System.out.println (k + " protagonistes, "+"temps ecoule : "+(finN2-debutN2)+", nombre total de points de vie :"+ totalpdv2);
    }
    }
}
    
    


