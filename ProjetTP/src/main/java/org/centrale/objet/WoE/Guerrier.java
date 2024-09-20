package org.centrale.objet.WoE;

/**
 *
 * @author mattlerigolo
 */
public class Guerrier extends Personnage {
    private Epee epee;
    
    public Guerrier(){
        super();
        this.epee = new Epee();
    }
    
    public Guerrier(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distMaxAtt, Point2D pos, Epee epee){
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distMaxAtt, pos);
        this.epee = epee;
    }
    
    public Guerrier(Guerrier g){
        super(g);
        this.epee = new Epee(g.getEpee());
    }

    public Epee getEpee() {
        return epee;
    }

    public void setEpee(Epee epee) {
        this.epee = epee;
    }
}
