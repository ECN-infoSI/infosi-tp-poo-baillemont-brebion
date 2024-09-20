package org.centrale.objet.WoE;

/**
 *
 * @author mattlerigolo
 */

import java.util.Random;

public class Loup extends Monstre implements Combattant {
    public Loup(){
        super();
    }
    
    public Loup(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos){
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }
    
    public Loup(Loup l){
        super(l);
    }
    
    @Override public void combattre(Creature c){
        if ((this.pos.distance(c.getPos())) <= 1){ // le loup ne peut pas attaquer à distance
            Random r = new Random();
            int tirageAtt = r.nextInt(99)+1;
            int tirageDef = r.nextInt(99)+1;
            
            if (tirageAtt <= this.pageAtt){
                if (tirageDef > c.getPagePar()){
                    c.setPtVie(c.getPtVie()-this.degAtt);
                }
                else{
                    c.setPtVie(c.getPtVie()-this.degAtt+c.getPtPar());
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
}
