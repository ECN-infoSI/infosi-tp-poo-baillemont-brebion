package org.centrale.objet.WoE;

/**
 * 
 * @author mattlerigolo
 * @author morga
 */
public class Point2D {
    /**
     * Coordonnées X
     */
    private int x;
    
    /**
     * Coordonnées Y
     */
    private int y;
    
    /**
     * Constructeur par défaut
     */
    public Point2D(){
        x = 0;
        y = 0;
    };
    
    /**
     * Constructeur
     * @param x
     * Coordonnées X
     * @param y 
     * Coordonnées Y
     */
    public Point2D(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public int getX(){
        return(this.x);
    };
    
    public int getY(){
        return(this.y);
    };
    
    public void setX(int newX){
        this.x = newX;
    };
    
    public void setY(int newY){
        this.y = newY;
    };
    
    public void setPosition(int newX, int newY){
        this.x = newX;
        this.y = newY;
    }
    
    /**
     * Constructeur de copie
     * @param p 
     * Point à copier
     */
    public Point2D(Point2D p){
        this.x = p.getX();
        this.y = p.getY();
    };
    
    public void translate(int dx, int dy){
        this.x += dx;
        this.y += dy;
    };
    
    /**
     * Affiche les coordonnées du point
     */
    public void affiche(){
        System.out.println("["+this.x+","+this.y+"]");
    };
    
    /**
     * Calcule la distance avec le point p
     * @param p
     * Point p
     * @return
     * Distance avec le point p
     */
    public double distance(Point2D p){
        return(Math.sqrt((this.x-p.getX())*(this.x-p.getX()) + (this.y-p.getY())*(this.y-p.getY())));
    };
    
    /**
     * Vérifie si les deux points sont au même endroit
     * @param p
     * Point p
     * @return
     * True si les deux points sont au même endroit, False sinon
     */
    public boolean samePosition(Point2D p){
        return (this.x == p.getX() && this.y == p.getY());
    };
}
