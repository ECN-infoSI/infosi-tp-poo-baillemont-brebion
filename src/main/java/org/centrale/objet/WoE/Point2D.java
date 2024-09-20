package org.centrale.objet.WoE;

/**
 *
 * @author mattlerigolo
 */
public class Point2D {
    private int x;
    private int y;
    
    public Point2D(){
        x = 0;
        y = 0;
    };
    
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
    
    public Point2D(Point2D p){
        this.x = p.getX();
        this.y = p.getY();
    };
    
    public void translate(int dx, int dy){
        this.x += dx;
        this.y += dy;
    };
    
    public void affiche(){
        System.out.println("["+this.x+","+this.y+"]");
    };
    
    public double distance(Point2D p){
        return(Math.sqrt((this.x-p.getX())*(this.x-p.getX()) + (this.y-p.getY())*(this.y-p.getY())));
    };
    
    public boolean samePosition(Point2D p){
        return (this.x == p.getX() && this.y == p.getY());
    };
}
