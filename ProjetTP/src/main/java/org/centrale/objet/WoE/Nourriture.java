package org.centrale.objet.WoE;

/**
 *
 * @author mattlerigolo
 */
public abstract class Nourriture extends Objet implements Utilisables {
    private Point2D pos;
    private int bonusMalus;
    private int tempsEffet;
    private boolean isConsumed;
    
    
    public Nourriture(){
        this.pos = new Point2D();
        this.bonusMalus = 10;
        this.tempsEffet = 3;
        this.isConsumed = false;
    }

    public Nourriture(Point2D pos, int bonusMalus, int tempsEffet, boolean isConsumed) {
        this.pos = pos;
        this.bonusMalus = bonusMalus;
        this.tempsEffet = tempsEffet;
        this.isConsumed = isConsumed;
        
    }
   
    public Nourriture(Nourriture n){
        this.pos = new Point2D(n.getPos());
        this.bonusMalus = n.getBonusMalus();
        this.tempsEffet = n.getTempsEffet();
        this.isConsumed = n.isIsConsumed();
    }
    
    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }

    public int getBonusMalus() {
        return bonusMalus;
    }

    public void setBonusMalus(int bonusMalus) {
        this.bonusMalus = bonusMalus;
    }

    public int getTempsEffet() {
        return tempsEffet;
    }

    public void setTempsEffet(int tempsEffet) {
        this.tempsEffet = tempsEffet;
    }

    public boolean isIsConsumed() {
        return isConsumed;
    }

    public void setIsConsumed(boolean isConsumed) {
        this.isConsumed = isConsumed;
    }
    
    public abstract void mangerPar(Personnage p);
    
    public abstract void finEffet(Personnage p);
    
    public void passerTour(){
        this.setTempsEffet(this.getTempsEffet()-1);
    }
    
    public boolean effetFini(){
        return(this.tempsEffet==0);
    }
}
