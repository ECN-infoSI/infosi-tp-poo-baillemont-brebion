/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *  Sous-classe de Objet représentant une potion de soin
 * @author morga
 * @author mattlerigolo
 */
public class PotionSoin extends Objet {
    
    /**
     * Nombre de points de soin
     */
    private int ptSoin;
    
    /**
     * Position
     */
    private Point2D pos;
    
    /**
     * Potion consommée ou pas ?
     */
    private boolean consumed;
    
    /**
     * Constructeur par défaut
     */
    public PotionSoin(){
        this.ptSoin = 10;
        this.pos = new Point2D();
        this.consumed = false;
    }
    
    /**
     * Constructeur
     * @param pointsSoin
     * Points de soin
     * @param pos 
     * Position
     */
    public PotionSoin(int pointsSoin, Point2D pos){
        this.ptSoin = pointsSoin;
        this.pos = new Point2D(pos);
        this.consumed = false; // la potion est forcément pleine quand on la crée
    }
    
    /**
     * Constructeur de copie
     * @param p 
     * Potion à copier
     */
    public PotionSoin(PotionSoin p){
        this.ptSoin = p.getPtSoin();
        this.pos = new Point2D(p.getPos());
        this.consumed = p.isConsumed();
    }

    public int getPtSoin() {
        return ptSoin;
    }

    public Point2D getPos() {
        return pos;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void setPtSoin(int ptSoin) {
        this.ptSoin = ptSoin;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public void setIsConsumed(boolean consumed) {
        this.consumed = consumed;
    }
    
    
    
}
