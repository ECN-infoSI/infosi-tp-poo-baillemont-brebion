package org.centrale.objet.WoE;

/**
 * Interface regroupant toutes les créatures pouvant combattre
 * @author mattlerigolo
 */
public interface Combattant {
    /**
     * Action de combattre
     * @param c 
     * Créature à combattre
     */
    public void combattre(Creature c);
    
    /**
     * Vérifier si la créature est à distance d'attaque
     * @param c
     * Créature à attaquer
     * @return 
     * True si la créature est à distance d'attaque
     */
    public boolean aDistancedAttaque(Creature c);
}
