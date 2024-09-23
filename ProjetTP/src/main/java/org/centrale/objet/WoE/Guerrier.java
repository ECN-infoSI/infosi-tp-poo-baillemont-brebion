package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author mattlerigolo
 */
public class Guerrier extends Personnage implements Combattant {
    private Epee epee;
    
    public Guerrier(){
        super();
        this.epee = new Epee();
    }
    
    public Guerrier(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distMaxAtt, Point2D pos, Epee epee){
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distMaxAtt, pos);
        this.epee = epee;
    }
    
    public Guerrier(Guerrier g){
        super(g);
        this.epee = new Epee(g.getEpee());
    }

    public Epee getEpee() {
        return epee;
    }

    public void setEpee(Epee epee) {
        this.epee = epee;
    }
    
    @Override public void combattre(Creature c){
        if ((this.pos.distance(c.getPos())) <= 1){ // le loup ne peut pas attaquer à distance
            Random r = new Random();
            int tirageAtt = r.nextInt(99)+1;
            int tirageDef = r.nextInt(99)+1;
            
            if (tirageAtt <= this.pageAtt){
                if (tirageDef > c.getPagePar()){
                    c.setPtVie(c.getPtVie()-this.epee.getPtAtt());
                }
                else{
                    c.setPtVie(c.getPtVie()-this.epee.getPtAtt()+c.getPtPar());
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
