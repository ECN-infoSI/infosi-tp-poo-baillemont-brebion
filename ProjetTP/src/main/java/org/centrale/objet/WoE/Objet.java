package org.centrale.objet.WoE;

/**
 *
 * @author morga
 * @author mattlerigolo
 */
public abstract class Objet extends ElementDeJeu {
    protected int Id;
    public Objet(){
        this.Id = 1;
    }
    
    public int getId() {
        return Id;
    }
}
