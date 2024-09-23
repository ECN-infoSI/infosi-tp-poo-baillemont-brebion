/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * Classe de personnage.
 * @author mattlerigolo
 * @author morga
 * 
 * 
 */
public class Personnage extends Creature{
    
    /**
     * Nom du personnage.
     */
    protected String nom;
    
    /**
     * Distance maximale d'attaque du personnage.
     */
    protected int distMaxAtt;
    
    /**
     * Constructeur par défaut.
     */
    public Personnage(){
        super();
        this.nom = "Robert";
        this.distMaxAtt = 1;
    };
    
    /**
     * Constructeur.
     * @param nom
     *          Nom du personnage
     * @param ptVie
     *          Nombre de points de vie
     * @param degAtt
     *          Nombre de dégats d'attaque
     * @param ptPar
     *          Nombre de points de parade
     * @param pageAtt
     *          Pourcentage d'attaque
     * @param pagePar
     *          Pourcentage de Parade
     * @param distMaxAtt
     *          Distance maximum d'attaque
     * @param pos 
     *          Position
     * 
     * 
     */
    public Personnage(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distMaxAtt, Point2D pos){
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
        this.nom = nom;
        this.distMaxAtt = distMaxAtt;
    };
    
    /**
     * Construit un personnage à partir des caractéristiques d'un personnage déjà existant.
     * @param perso 
     *          Personnage déjà existant
     * 
     */
    public Personnage(Personnage perso){
        super(perso);
        this.nom = perso.nom;
        this.distMaxAtt = perso.distMaxAtt;
    }
    
    /**
     *
     * @return
     */
    public String getNom(){
        return this.nom ;
    };

    /**
     *
     * @return
     */
    public int getDistMaxAtt() {
        return distMaxAtt;
    }
    
    /**
     *
     * @param newNom
     */
    public void setNom(String newNom){
        this.nom = newNom;
    };

    /**
     *
     * @param distMaxAtt
     */
    public void setDistMaxAtt(int distMaxAtt) {
        this.distMaxAtt = distMaxAtt;
    }
    
    
    /**
     * Affiche les caractéristiques du personnages.
     */
    @Override public void affiche(){
        System.out.println("nom : " + this.nom +
                           "\nptVie : " + this.getPtVie() +
                           "\ndegAtt : " + this.getDegAtt() +
                           "\nptPar : " + this.getPtPar() +
                           "\npageAtt : " + this.getPageAtt() +
                           "\npagePar : " + this.getPagePar() +
                           "\ndistMaxAtt : " + this.distMaxAtt +
                           "\npos : " + "["+this.getPos().getX()+","+this.getPos().getY()+"] \n" );
    };
    
    public void boirePotion(PotionSoin pot){
        if ((this.getPos().distance(pot.getPos()) <= 1) && (!pot.isConsumed())){
            this.setPtVie(this.getPtVie()+pot.getPtSoin());
            System.out.println(pot.getPtSoin() + " points de vie regagnés !");
            pot.setIsConsumed(true);
        }
        else{
            System.out.println("Cette potion est trop éloignée ! \n");
        }
    }
}