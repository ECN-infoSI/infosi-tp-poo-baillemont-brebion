/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Sous-classe de Monstre représentant un lapin
 * @author mattlerigolo
 * @author morga
 */
public class Lapin extends Monstre {
    
    /**
     * Constructeur par défaut
     */
    public Lapin(){
        super();
    }
    
    /**
     * Constructeur
     * @param ptVie
     * Nombre de points de vie
     * @param degAtt
     * Dégâts d'attaque
     * @param ptPar
     * Points de Parade
     * @param pageAtt
     * Pourcentage d'attaque
     * @param pagePar
     * Pourcentage de parade
     * @param pos
     * Position
     */
    public Lapin(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos){
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    };
    
    
    /**
     * Constructeur de copie
     * @param l 
     * Lapin à copier
     */
    public Lapin(Lapin l){
        super(l);
    };
}
