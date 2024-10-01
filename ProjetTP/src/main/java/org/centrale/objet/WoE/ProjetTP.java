/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

/**
 *
 * @author mattlerigolo
 * @author morga
 */
public class ProjetTP {

    public static void main(String[] args) {
        World_arrayList monde = new World_arrayList(5,5);
        
        monde.creaMondeAlea(1,1,1,1,1,0);
        monde.getPersonnages().get(0).setNom("Ivan");
        monde.getPersonnages().get(1).setNom("Dmitri");
        monde.getPersonnages().get(2).setNom("Aliocha");
        
        
        for (Personnage perso : monde.getPersonnages()){
            perso.affiche();
            perso.deplace(monde.getPlateau());
            System.out.println("\nAprès déplacement : \n");
            perso.affiche();
        }
        
        monde.affichePlateau();
    }
}
