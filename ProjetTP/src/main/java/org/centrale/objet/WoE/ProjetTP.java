/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

/**
 *
 * @author mattlerigolo
 */
public class ProjetTP {

    public static void main(String[] args) {
        World monde = new World();
        
        monde.creaMondeAlea();
        
        monde.robin.affiche();
        monde.peon.affiche();
        monde.bugs.affiche();
        
        monde.robin.deplace();
        monde.peon.deplace();
        monde.bugs.deplace();
        
        monde.robin.affiche();
        monde.peon.affiche();
        monde.bugs.affiche();
    }
}
