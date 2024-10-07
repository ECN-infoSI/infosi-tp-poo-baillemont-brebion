package org.centrale.objet.WoE;

/**
 * Interface pour les créatures/objets déplaçables
 * @author mattlerigolo
 */
public interface Deplacable {
    public void deplace(int[][] plateau);
    public void deplace(int[][] plateau, int newPosX, int newPosY);
}
