package org.centrale.objet.WoE;

/**
 * Interface pour les créatures/objets déplaçables
 * @author mattlerigolo
 */
public interface Deplacable {
    /**
     * Déplace la créature sur le plateau
     * @param plateau
     * Plateau de jeu où se trouve la créature
     */
    public void deplace(int[][] plateau);
}
