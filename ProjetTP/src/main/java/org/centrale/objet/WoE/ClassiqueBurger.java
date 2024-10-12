package org.centrale.objet.WoE;

/**
 * Nourriture qui augmente les points de parade quand consommée
 * @author mattlerigolo
 */
public class ClassiqueBurger extends Nourriture {

    public ClassiqueBurger() {
        super();
    }

    public ClassiqueBurger(Point2D pos, int bonusMalus, int tempsEffet, boolean isConsumed) {
        super(pos, bonusMalus, tempsEffet, isConsumed);
    }

    public ClassiqueBurger(Nourriture n) {
        super(n);
    }
    
    @Override public void mangerPar(Personnage p){
        p.setPtPar(p.getPtPar()+this.getBonusMalus());
        this.setIsConsumed(true);
    }
    
    @Override public void finEffet(Personnage p){
        if (this.effetFini()){
            p.setPtPar(p.getPtPar()-this.getBonusMalus());
        }
    }
}
