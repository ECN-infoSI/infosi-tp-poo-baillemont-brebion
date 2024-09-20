package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author mattlerigolo et @morga
 */
public class World {
    public Archer robin;
    public Paysan peon;
    public Lapin bugs;
    
    public World(){
        this.robin = new Archer();
        this.peon = new Paysan();
        this.bugs = new Lapin();
    };
    
    public void creaMondeAlea(){
        Random r = new Random();
        
        int x1 = r.nextInt(201)-100; // nombre compris entre -100 et 100
        int y1 = r.nextInt(201)-100; // nombre compris entre -100 et 100
        Point2D posArcher = new Point2D(x1,y1);
        this.robin.setPos(posArcher);
        
        int x2 = r.nextInt(201)-100; // nombre compris entre -100 et 100
        int y2 = r.nextInt(201)-100; // nombre compris entre -100 et 100
        while ((x1==x2) && (y1==y2)){
            x2 = r.nextInt(201)-100; // si meme position alors on reprend 2 nombres aléatoires
            y2 = r.nextInt(201)-100;
        }
        Point2D posPaysan = new Point2D(x2,y2);
        this.peon.setPos(posPaysan);
        
        int x3 = r.nextInt(201)-100; // nombre compris entre -100 et 100
        int y3 = r.nextInt(201)-100; // nombre compris entre -100 et 100
        while (((x1==x3) && (y1==y3)) || ((x2==x3) && (y2==y3))){
            x3 = r.nextInt(201)-100;
            y3 = r.nextInt(201)-100;
        }
        Point2D posLapin = new Point2D(x3,y3);
        this.bugs.setPos(posLapin);
    };
};
