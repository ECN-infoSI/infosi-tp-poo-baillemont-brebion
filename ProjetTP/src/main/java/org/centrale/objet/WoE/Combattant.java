/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
}
