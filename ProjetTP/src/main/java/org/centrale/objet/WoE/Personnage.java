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
 * 
 */


public class Personnage {
    
    /**
     * Nom du personnage.
     */
    private String nom;
    
    /**
     * Nombre de points de vie du personnage.
     */
    private int ptVie;
    
    /**
     * Nombre de dégats infligés par le personnages lors d'une attaque simple.
     */
    private int degAtt;
    
    /**
     * Nombre de points de parade du personnage.
     */
    private int ptPar;
    
    /**
     * Nombre de page attaque du personnage.
     */
    private int pageAtt;
    
    /**
     * Nombre de page de parade du personnage.
     */
    private int pagePar;
    
    /**
     * Distance maximale d'attaque du personnage.
     */
    private int distMaxAtt;
    
    /**
     * Position 2D du personnage.
     *@see Point2D
     */
    private Point2D pos;
    
    /**
     * Constructeur par défaut.
     */
    public Personnage(){
        this.nom = "Robert";
        this.ptVie = 100;
        this.ptPar = 10;
        this.pageAtt = 10;
        this.pagePar = 10;
        this.distMaxAtt = 10;
        this.pos = new Point2D();
    };
    
    /**
     * @param nom
     * @param ptVie
     * @param degAtt
     * @param ptPar
     * @param pageAtt
     * @param pagePar
     * @param distMaxAtt
     * @param pos 
     */
    public Personnage(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distMaxAtt, Point2D pos){
        this.nom = nom;
        this.ptVie = ptVie;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.distMaxAtt = distMaxAtt;
        this.pos = pos;
    };
    
    public Personnage(Personnage perso){
        this.nom = perso.getNom();
        this.ptVie = perso.getPtVie();
        this.ptPar = perso.getPtPar();
        this.pageAtt = perso.getPageAtt();
        this.pagePar = perso.getPagePar();
        this.distMaxAtt = perso.getDistMaxAtt();
        this.pos = new Point2D(perso.getPos());
    }
    
    public String getNom(){
        return this.nom ;
    };

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

    public int getDistMaxAtt() {
        return distMaxAtt;
    }

    public Point2D getPos() {
        return pos;
    }
    
    public void setNom(String newNom){
        this.nom = newNom;
    };

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

    public void setDistMaxAtt(int distMaxAtt) {
        this.distMaxAtt = distMaxAtt;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    
    
    public void affiche(){
        System.out.println("nom : " + this.nom +
                           "\nptVie : " + this.ptVie +
                           "\ndegAtt : " + this.degAtt +
                           "\nptPar : " + this.ptPar +
                           "\npageAtt : " + this.pageAtt +
                           "\npagePar : " + this.pagePar +
                           "\ndistMaxAtt : " + this.distMaxAtt +
                           "\npos : " + "["+pos.getX()+","+pos.getY()+"] \n" );
    };
    
    public void deplace(){
        Random r = new Random();
        int dx = r.nextInt(2); // le personnage peut se déplacer sur les cases adjacentes
        int dirX = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon x
        int dy = r.nextInt(2);
        int dirY = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon y
        
        this.pos.translate(dirX*dx, dirY*dy);
    }
}