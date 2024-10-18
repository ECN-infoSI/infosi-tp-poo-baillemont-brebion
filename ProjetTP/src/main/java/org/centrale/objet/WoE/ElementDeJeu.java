package org.centrale.objet.WoE;

/**
 * Super-classe contenant tous les éléments du jeu
 * @author mattlerigolo
 */
public abstract class ElementDeJeu {
    public ElementDeJeu(){

    }
    
    /**
     * Créer un élément de jeu à partir d'une ligne de sauvegarde
     * @param ligne
     * Ligne dans le fichier de sauvegarde
     * @return 
     * Element de jeu correspondant à la ligne
     */
    public abstract ElementDeJeu create(String ligne);
    
    /**
     * Crée un élément de jeu aléatoire
     */
    public abstract void creaElementDeJeuAlea();
    
    /**
     * Crée une ligne à mettre dans le fichier de sauvegarde
     * @return 
     * Ligne de sauvegarde
     */
    public abstract String ligneSauvegarde();
}
