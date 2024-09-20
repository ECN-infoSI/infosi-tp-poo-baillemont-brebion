/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author mattlerigolo
 */
public class Archer extends Personnage implements Combattant {
    private int nbFleches;
    
    public Archer(){
        super();
        this.nbFleches = 10;
    };
    
    public Archer(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distMaxAtt, Point2D pos, int nbFleches){
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distMaxAtt, pos);
        this.nbFleches = nbFleches;
    };
    
    public Archer(Archer a){
        super(a);
        this.nbFleches = a.getNbFleches();
    };

    public int getNbFleches() {
        return nbFleches;
    };

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    };
    

    @Override public void affiche(){
        System.out.println("nom : " + this.nom +
                           "\nptVie : " + this.getPtVie() +
                           "\ndegAtt : " + this.getDegAtt() +
                           "\nptPar : " + this.getPtPar() +
                           "\npageAtt : " + this.getPageAtt() +
                           "\npagePar : " + this.getPagePar() +
                           "\ndistMaxAtt : " + this.distMaxAtt +
                           "\nNbFleches : " + this.nbFleches +
                           "\npos : " + "["+this.getPos().getX()+","+this.getPos().getY()+"] \n" );
    }
    
    @Override public void combattre(Creature c){
        this.nbFleches -= 1; // il perd une flèche dans tous les cas
        if ((this.pos.distance(c.getPos()) > 1) && (this.pos.distance(c.getPos()) <= this.distMaxAtt)){ // l'archer ne peut attaquer qu'a distance
            Random r = new Random();
            int tirageAtt = r.nextInt(99)+1;
            
            if (tirageAtt <= this.pageAtt){
                    c.setPtVie(c.getPtVie()-this.degAtt);
            }
            else {
                System.out.println("Attaque Ratée !");
            }
        }
        else{
            System.out.println("Trop loin ou trop proche !");
        }
    }
}
