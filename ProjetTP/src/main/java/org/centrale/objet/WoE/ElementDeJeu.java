package org.centrale.objet.WoE;

/**
 *
 * @author mattlerigolo
 */
public abstract class ElementDeJeu {
    public ElementDeJeu(){

    }
    
    public abstract ElementDeJeu create(String ligne);
    
    public abstract void creaElementDeJeuAlea();
}
