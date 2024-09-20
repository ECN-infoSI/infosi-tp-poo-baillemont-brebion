/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author mattlerigolo
 * @author morga
 * 
 * Classe pour les monstres.
 */
public class Monstre {
    
    /**
     * Nombre de points de vie du monstre.
     */
    private int ptVie;
    
    /**
     * Nombre de dégats d'attaque du monstre.
     * 
     */
    private int degAtt;
    
    /**
     * Nombre de points de parade du monstre.
     */
    private int ptPar;
    
    /**
     * Nombre de page attaque du monstre.
     */
    private int pageAtt;
    
    /**
     * Nombre de page de parade du monstre.
     */
    private int pagePar;
    
    /**
     * Position ud monstre.
     * @see Point2D
     */
    private Point2D pos;
    
    
    /**
     * Constructeur par défaut.
     */
    public Monstre(){
        this.ptVie = 100;
        this.ptPar = 10;
        this.pageAtt = 10;
        this.pagePar = 10;
        this.pos = new Point2D();
    };
    
    /**
     * Constructeur.
     * @param ptVie
     *          Nombre de points de vie
     * @param degAtt
     *          Nombre de dégats d'attaque
     * @param ptPar
     *          Nombre de points d'attaque
     * @param pageAtt
     *          Nombre de points de parade
     * @param pagePar
     *         Nombre de page de parade 
     * @param pos 
     *          Position
     */         
    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos){
        this.ptVie = ptVie;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = pos;
    };
    
    /**
     * Construit un monstre à partir des caractéristiques d'un monstre déjà existant.
     * @param monster 
     *          monstre déjà existant
     */
    public Monstre(Monstre monster){
        this.ptVie = monster.getPtVie();
        this.ptPar = monster.getPtPar();
        this.pageAtt = monster.getPageAtt();
        this.pagePar = monster.getPagePar();
        this.pos = new Point2D(monster.getPos());
    };

    public int getPtVie() {
        return ptVie;
    };

    public int getDegAtt() {
        return degAtt;
    };

    public int getPtPar() {
        return ptPar;
    };

    public int getPageAtt() {
        return pageAtt;
    };

    public int getPagePar() {
        return pagePar;
    };

    public Point2D getPos() {
        return pos;
    };

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    };

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    };

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    };

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    };

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    };

    public void setPos(Point2D pos) {
        this.pos = pos;
    };

    /**
     * Affiche les caractéristiques du monstre.
     */
    public void affiche(){
        System.out.println("Monstre" +
                           "\nptVie : " + this.ptVie +
                           "\ndegAtt : " + this.degAtt +
                           "\nptPar : " + this.ptPar +
                           "\npageAtt : " + this.pageAtt +
                           "\npagePar : " + this.pagePar +
                           "\npos : " + "["+pos.getX()+","+pos.getY()+"] \n" );
    };
    
    /**
     * Déplace le monstre aléatoirement, dans un rayon de 1, horizontalement, verticalement, ou en diagonale.
     */
    public void deplace(){
        Random r = new Random();
        int dx = r.nextInt(2); // le personnage peut se déplacer sur les cases adjacentes
        int dirX = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon x
        int dy = r.nextInt(2);
        int dirY = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon y
        
        this.pos.translate(dirX*dx, dirY*dy);
    }
    
    
}
