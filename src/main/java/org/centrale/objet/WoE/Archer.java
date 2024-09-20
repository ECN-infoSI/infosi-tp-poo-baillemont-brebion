/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author mattlerigolo
 */
public class Archer extends Personnage {
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
    
    
}
