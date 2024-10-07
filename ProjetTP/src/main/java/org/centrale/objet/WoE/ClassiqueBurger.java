package org.centrale.objet.WoE;

/**
 *
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
    
    public void mangerPar(Personnage p){
        p.setPtPar(p.getPtPar()+this.getBonusMalus());
        this.setIsConsumed(true);
    }
    
    public void finEffet(Personnage p){
        if (this.effetFini()){
            p.setPtPar(p.getPtPar()-this.getBonusMalus());
        }
    }
}
