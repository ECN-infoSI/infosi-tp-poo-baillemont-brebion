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
    
    public void creaPaysanAlea(){
        Random random = new Random();
        this.ptVie = random.nextInt(50)+25; // points de vie entre 25 et 75
        this.ptPar = random.nextInt(10)+5; // entre 5 et 15
        this.degAtt = random.nextInt(10)+5; // degats d'attaque entre 5 et 15
        this.pagePar = random.nextInt(101); // entre 0 et 100
        this.pageAtt = random.nextInt(101); // entre 0 et 100
    }
}
