package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Sous-classe de Monstre représentant un Loup
 * 
 * @author mattlerigolo
 * @author morga
 */

public class Loup extends Monstre implements Combattant {
    /**
     * Constructeur par défaut
     */
    public Loup(){
        super();
    }
    
    /**
     * Constructeur
     * @param ptVie
     * Nombre de points de vie
     * @param degAtt
     * Dégâts d'attaque
     * @param ptPar
     * Points de Parade
     * @param pageAtt
     * Pourcentage d'attaque
     * @param pagePar
     * Pourcentage de parade
     * @param pos
     * Position
     */
    public Loup(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos){
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }
    
    /**
     * Constructeur de copie
     * @param l 
     * Loup à copier
     */
    public Loup(Loup l){
        super(l);
    }
    
    /**
     * Action de combattre
     * @param c 
     * Créature à combattre
     */
    @Override public void combattre(Creature c){
        if ((this.pos.distance(c.getPos())) <= 1){ // le loup ne peut pas attaquer à distance
            Random r = new Random();
            int tirageAtt = r.nextInt(99)+1;
            int tirageDef = r.nextInt(99)+1;
            
            if (tirageAtt <= this.pageAtt){
                if (tirageDef > c.getPagePar()){
                    c.setPtVie(c.getPtVie()-this.degAtt);
                    System.out.println("Attaque Réussie ! \n");
                }
                else{
                    c.setPtVie(c.getPtVie()-this.degAtt+c.getPtPar());
                    System.out.println("Attaque Réussie, mais parade de l'adversaire !");
                }
            }
            else {
                System.out.println("Attaque Ratée !");
            }
        }
        else{
            System.out.println("Trop loin !");
        }
    }
    
    @Override public boolean aDistancedAttaque(Creature c){
        double distance = this.getPos().distance(c.getPos());
        return distance<=1; // tous les monstres ont une diqtance d'attaque de 1
    }
}
