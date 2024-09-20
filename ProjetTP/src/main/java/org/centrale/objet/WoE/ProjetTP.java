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
        
        monde.robin.setPos(new Point2D(6,0));
        monde.robin.setDistMaxAtt(10);
        monde.robin.affiche();
        
        
        monde.guillaumeT.setPos(new Point2D(12,0));
        monde.guillaumeT.setDistMaxAtt(10);
        monde.guillaumeT.affiche();
        
        
        monde.wolfie.setPos(new Point2D(0,0));
        monde.wolfie.affiche();
        
        monde.grosBill.setPos(new Point2D(1,0));
        monde.grosBill.affiche();
        
        monde.afficheWorld();
    }
}
