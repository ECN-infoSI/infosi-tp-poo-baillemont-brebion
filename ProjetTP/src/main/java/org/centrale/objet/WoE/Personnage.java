/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * Classe de personnage.
 * @author mattlerigolo
 * @author morga
 * 
 * 
 */
public class Personnage extends Creature{
    
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
     * Pourcentage attaque du personnage.
     */
    private int pageAtt;
    
    /**
     * Pourcentage de parade du personnage.
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
     * Constructeur.
     * @param nom
     *          Nom du personnage
     * @param ptVie
     *          Nombre de points de vie
     * @param degAtt
     *          Nombre de dégats d'attaque
     * @param ptPar
     *          Nombre de points de parade
     * @param pageAtt
     *          Pourcentage d'attaque
     * @param pagePar
     *          Pourcentage de Parade
     * @param distMaxAtt
     *          Distance maximum d'attaque
     * @param pos 
     *          Position
     * 
     * 
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
    
    /**
     * Construit un personnage à partir des caractéristiques d'un personnage déjà existant.
     * @param perso 
     *          Personnage déjà existant
     * 
     */
    public Personnage(Personnage perso){
        this.nom = perso.getNom();
        this.ptVie = perso.getPtVie();
        this.ptPar = perso.getPtPar();
        this.pageAtt = perso.getPageAtt();
        this.pagePar = perso.getPagePar();
        this.distMaxAtt = perso.getDistMaxAtt();
        this.pos = new Point2D(perso.getPos());
    }
    
    /**
     *
     * @return
     */
    public String getNom(){
        return this.nom ;
    };

    /**
     *
     * @return
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     *
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @return
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     *
     * @return
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     *
     * @return
     */
    public int getPagePar() {
        return pagePar;
    }

    /**
     *
     * @return
     */
    public int getDistMaxAtt() {
        return distMaxAtt;
    }

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }
    
    /**
     *
     * @param newNom
     */
    public void setNom(String newNom){
        this.nom = newNom;
    };

    /**
     *
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     *
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     *
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    /**
     *
     * @param distMaxAtt
     */
    public void setDistMaxAtt(int distMaxAtt) {
        this.distMaxAtt = distMaxAtt;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    
    /**
     * Affiche les caractéristiques du personnages.
     */
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
    
    /**
     * Déplace aléatoirement le personnage, dans un rayon de 1, horizontalement, verticalement, ou en diagonale.
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