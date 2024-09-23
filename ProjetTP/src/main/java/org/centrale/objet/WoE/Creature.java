/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author morga
 * @author mattlerigolo
 */
public abstract class Creature {
    /**
     * Nombre de points de vie de la créature.
     */
    protected int ptVie;
    
    /**
     * Nombre de dégats infligés par la créature lors d'une attaque simple.
     */
    protected int degAtt;
    
    /**
     * Nombre de points de parade de la créature.
     */
    protected int ptPar;
    
    /**
     * Pourcentage attaque de la créature.
     */
    protected int pageAtt;
    
    /**
     * Pourcentage de parade de la créature.
     */
    protected int pagePar;
    
     /**
     * Position 2D de la créature.
     *@see Point2D
     */
    protected Point2D pos;
    
    public Creature(){
        this.ptVie = 100;
        this.degAtt = 15;
        this.ptPar = 10;
        this.pageAtt = 75;
        this.pagePar = 50;
        this.pos = new Point2D();
    }
    
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos){
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = new Point2D(pos);
    }
    
    public Creature(Creature c){
        this.ptVie = c.getPtVie();
        this.degAtt = c.getDegAtt();
        this.ptPar = c.getPtPar();
        this.pageAtt = c.getPageAtt();
        this.pagePar = c.getPagePar();
        this.pos = new Point2D(c.getPos());
    }

    public int getPtVie() {
        return ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     * Déplace la créature aléatoirement, dans un rayon de 1, horizontalement, verticalement, ou en diagonale.
     */
    public void deplace(){
        Random r = new Random();
        int dx = r.nextInt(2); // le personnage peut se déplacer sur les cases adjacentes
        int dirX = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon x
        int dy = r.nextInt(2);
        int dirY = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon y
        
        this.pos.translate(dirX*dx, dirY*dy);
    }
    
    public abstract void affiche();
    
    
    
}
