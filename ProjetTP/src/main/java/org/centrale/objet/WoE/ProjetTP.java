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
        World_linkedList monde = new World_linkedList(50,50);
        
        monde.creaMondeAlea(1,1,1,1,1,1);
        monde.afficheWorld();
    }
}
