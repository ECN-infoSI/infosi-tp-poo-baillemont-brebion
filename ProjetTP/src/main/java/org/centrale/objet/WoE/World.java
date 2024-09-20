package org.centrale.objet.WoE;
import java.util.Random;

/**
 * Création d'un monde WoE comprenant un archer, un paysan et un lapin. 
 * Leur position est initialisée aléatoirement à la création du monde par la méthode {@link #creaMondeAlea()}.
 * @author mattlerigolo
 * @author morga
 * 
 */
public class World {
    /** 
     * Une instance d'Archer, robin.
     * @see Archer
     */
    public Archer robin;
    
    /** 
     * Une instance d'Archer, guillaumeT.
     * @see Archer
     */
    public Archer guillaumeT;
    
    /** 
     * Une instance de Paysan, peon.
     * @see Paysan
     */
    public Paysan peon;
    
    /** 
     * Une instance de Lapin, bugs1.
     * @see Lapin
     */
    public Lapin bugs1;
    
    /** 
     * Une instance de Lapin, bugs2.
     * @see Lapin
     */
    public Lapin bugs2;
    
    /** 
     * Une instance de Guerrier
     * 
     */
    public Guerrier grosBill;
    
    public Loup wolfie;
    
    
    
    
     /**
     * Constructeur.
     */
    public World(){
       
        this.robin = new Archer();
        this.peon = new Paysan();
        this.bugs1 = new Lapin();
        this.bugs2 = new Lapin();
        this.guillaumeT = new Archer();
        this.grosBill = new Guerrier();
        this.wolfie = new Loup();
    };
    
    public World(Archer a1, Paysan p, Lapin l1, Lapin l2, Archer a2, Guerrier g, Loup l3){
        this.robin = a1;
        this.peon = p;
        this.bugs1 = l1;
        this.bugs2 = l2;
        this.guillaumeT = a2;
        this.grosBill = g;
        this.wolfie = l3;
    }
    /** 
    * Création des positions aléatoires des objets du monde. 
    * Deux objets ne peuvent pas être à la même position.
    */
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
        
        int x4 = r.nextInt(201)-100; // nombre compris entre -100 et 100
        int y4 = r.nextInt(201)-100; // nombre compris entre -100 et 100
        while (((x1==x4) && (y1==y4)) || ((x2==x4) && (y2==y4)) || ((x3==x4) && (y3==y4))){
            x4 = r.nextInt(201)-100;
            y4 = r.nextInt(201)-100;
        }
        Point2D posGuillaume = new Point2D(x4,y4);
        this.guillaumeT.setPos(posGuillaume);
    };
};
