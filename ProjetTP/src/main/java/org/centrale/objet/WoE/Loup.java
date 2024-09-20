package org.centrale.objet.WoE;

/**
 *
 * @author mattlerigolo
 */
public class Loup extends Monstre {
    public Loup(){
        super();
    }
    
    public Loup(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos){
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }
    
    public Loup(Loup l){
        super(l);
    }
}
