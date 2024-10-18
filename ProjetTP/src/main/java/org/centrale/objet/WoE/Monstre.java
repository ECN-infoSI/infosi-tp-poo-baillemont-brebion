package org.centrale.objet.WoE;

/**
 * Classe pour les monstres.
 * @author mattlerigolo
 * @author morga
 * 
 * 
 */
public abstract class Monstre extends Creature{
    
    /**
     * Constructeur par défaut.
     */
    public Monstre(){
        super();
    };
    
    /**
     * Constructeur.
     * @param ptVie
     *          Nombre de points de vie
     * @param degAtt
     *          Nombre de dégats d'attaque
     * @param ptPar
     *          Nombre de points d'attaque
     * @param pageAtt
     *          Pourcentage d'attaque
     * @param pagePar
     *         Pourcentage de parade 
     * @param pos 
     *          Position
     */         
    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos){
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }
    
    /**
     * Construit un monstre à partir des caractéristiques d'un monstre déjà existant.
     * @param monster 
     *          monstre déjà existant
     */
    public Monstre(Monstre monster){
        super(monster);
    };

    /**
     * Affiche les caractéristiques du monstre.
     */
    @Override public void affiche(){
        System.out.println(this.getClass().getSimpleName() + " n°" + this.Id +
                           "\nptVie : " + this.getPtVie() +
                           "\ndegAtt : " + this.getDegAtt() +
                           "\nptPar : " + this.getPtPar() +
                           "\npageAtt : " + this.getPageAtt() +
                           "\npagePar : " + this.getPagePar() +
                           "\npos : " + "["+getPos().getX()+","+getPos().getY()+"] \n" );
    };
    
}
