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
        monde.guillaumeT.affiche();
        
        monde.guillaumeT = new Archer(monde.robin);
        
        monde.guillaumeT.affiche();
        monde.robin.affiche();
        
        monde.robin.deplace();
        monde.guillaumeT.deplace();
        
        monde.robin.affiche();
        monde.guillaumeT.affiche();

    }
}
