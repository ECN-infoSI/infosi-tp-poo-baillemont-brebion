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
        World monde = new World();
        PotionSoin potion = new PotionSoin();
        
        monde.creaMondeAlea();
        
        monde.robin.setPos(new Point2D(6,0));
        monde.robin.setDistMaxAtt(10);
        monde.robin.setNom("Robin");
        
        
        monde.guillaumeT.setPos(new Point2D(12,0));
        monde.guillaumeT.setDistMaxAtt(10);
        monde.guillaumeT.setNom("Guillaume");
        
        
        monde.wolfie.setPos(new Point2D(0,0));
        
        monde.grosBill.setPos(new Point2D(1,0));
        monde.grosBill.setNom("Gros Bill");

        
        monde.wolfie.affiche();
        monde.robin.affiche();
        monde.robin.combattre(monde.wolfie);
        monde.wolfie.affiche();
        monde.robin.affiche();
        
        monde.wolfie.affiche();
        monde.guillaumeT.affiche();
        monde.guillaumeT.combattre(monde.wolfie);
        monde.wolfie.affiche();
        monde.guillaumeT.affiche();
        
        monde.wolfie.affiche();
        monde.grosBill.affiche();
        monde.wolfie.combattre(monde.grosBill);
        monde.robin.affiche();
        monde.grosBill.affiche();
        
        monde.robin.boirePotion(potion);
        if (potion.isConsumed()){
            potion = null;
        }
        monde.robin.affiche();
        monde.grosBill.boirePotion(potion);
        if (potion.isConsumed()){
            potion = null;
        }
        monde.grosBill.affiche();
    }
}
