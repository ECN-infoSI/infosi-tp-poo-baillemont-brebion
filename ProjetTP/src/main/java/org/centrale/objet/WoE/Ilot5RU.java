package org.centrale.objet.WoE;

/**
 * Nourriture qui diminue les points d'attaque quand consommée
 * @author mattlerigolo
 */
public class Ilot5RU extends Nourriture {
    public Ilot5RU() {
        super();
    }

    public Ilot5RU(Point2D pos, int bonusMalus, int tempsEffet, boolean isConsumed) {
        super(pos, bonusMalus, tempsEffet, isConsumed);
    }

    public Ilot5RU(Nourriture n) {
        super(n);
    }
    
    @Override public void mangerPar(Personnage p){
        p.setDegAtt(p.getDegAtt()-this.getBonusMalus());
        this.setIsConsumed(true);
    }
    
    @Override public void finEffet(Personnage p){
        if (this.effetFini()){
            p.setDegAtt(p.getDegAtt()+this.getBonusMalus());
        }
    }
    
}
