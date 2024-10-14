package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Sous-classe de Personnage représentant un paysan
 * @author mattlerigolo
 * @author morga
 */
public class Paysan extends Personnage {
    /**
     * Constructeur par défaut
     */
    public Paysan(){
        super();
    };
    
    /**
     * Constructeur
     * @param nom
     * Nom
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
     * @param distMaxAtt
     * Distance maximale d'attaque
     * @param pos
     * Position
     */
    public Paysan(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distMaxAtt, Point2D pos){
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distMaxAtt, pos);
    };
    
    /**
     * Constructeur de copie
     * @param p 
     * Paysan à copier
     */
    public Paysan(Paysan p){
        super(p);
    };
}
