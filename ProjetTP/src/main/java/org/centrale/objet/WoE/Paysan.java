/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author mattlerigolo
 * @author morga
 */
public class Paysan extends Personnage {
    public Paysan(){
        super();
    };
    
    public Paysan(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distMaxAtt, Point2D pos){
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distMaxAtt, pos);
    };
    
    public Paysan(Paysan p){
        super(p);
    };
}
