/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author mattlerigolo
 */
public class Monstre {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;
    
    public Monstre(){
        this.ptVie = 100;
        this.ptPar = 10;
        this.pageAtt = 10;
        this.pagePar = 10;
        this.pos = new Point2D();
    };
    
    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos){
        this.ptVie = ptVie;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = pos;
    };
    
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

    
    
}
