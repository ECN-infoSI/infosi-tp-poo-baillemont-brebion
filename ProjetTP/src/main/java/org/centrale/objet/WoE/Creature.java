package org.centrale.objet.WoE;

import java.util.Random;
/**
 * Super-classe de tous les êtres vivants du monde
 * @author morga
 * @author mattlerigolo
 */
public abstract class Creature extends ElementDeJeu implements Deplacable {
    /**
     * Nombre de points de vie de la créature.
     */
    protected int ptVie;
    
    /**
     * Nombre de dégats infligés par la créature lors d'une attaque simple.
     */
    protected int degAtt;
    
    /**
     * Nombre de points de parade de la créature.
     */
    protected int ptPar;
    
    /**
     * Pourcentage attaque de la créature.
     */
    protected int pageAtt;
    
    /**
     * Pourcentage de parade de la créature.
     */
    protected int pagePar;
    
     /**
     * Position 2D de la créature.
     *@see Point2D
     */
    protected Point2D pos;
    
    /**
     * ID de la créature.
     */
    protected int Id;
    
    /**
     * Constructeur par défaut
     */
    public Creature(){
        this.ptVie = 100;
        this.degAtt = 15;
        this.ptPar = 10;
        this.pageAtt = 75;
        this.pagePar = 50;
        this.pos = new Point2D();
        this.Id = 1; // à changer TODO
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
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos){
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
        this.pos = new Point2D(pos);
        this.Id = 1; 
    }
    
    /**
     * Constructeur de copie
     * @param c 
     * Créature à copier
     */
    public Creature(Creature c){
        this.ptVie = c.getPtVie();
        this.degAtt = c.getDegAtt();
        this.ptPar = c.getPtPar();
        this.pageAtt = c.getPageAtt();
        this.pagePar = c.getPagePar();
        this.pos = new Point2D(c.getPos());
        this.Id = 1; 
    }

    public int getPtVie() {
        return ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public Point2D getPos() {
        return pos;
    }
    
    public int getId() {
        return Id;
    }
    
    public void setId(int id) {
        this.Id = id;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     * Déplace la créature aléatoirement, dans un rayon de 1, horizontalement, verticalement, ou en diagonale.
     * 
     * @param plateau
     * Plateau du jeu
     */
    @Override public void deplace(int[][] plateau){
        plateau[this.pos.getX()][this.pos.getY()] = 0;
        Random r = new Random();
        int dx = r.nextInt(2); // le personnage peut se déplacer sur les cases adjacentes
        int dirX = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon x
        int dy = r.nextInt(2);
        int dirY = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon y
        int newPosX = this.pos.getX()+dirX*dx;
        int newPosY = this.pos.getY()+dirY*dy;
        boolean goodPosition = false;
        while (!goodPosition){
            if ((newPosX >= 0 && newPosX < plateau.length) && (newPosY >= 0 && newPosY < plateau[0].length) && (plateau[newPosX][newPosY] == 0)){
                goodPosition = true; // la position est valide
            }
            else { // position non-valide donc on tire à nouveau au hasard
                dx = r.nextInt(2); // le personnage peut se déplacer sur les cases adjacentes
                dirX = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon x
                dy = r.nextInt(2);
                dirY = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon y
                newPosX = this.pos.getX()+dirX*dx;
                newPosY = this.pos.getY()+dirY*dy;
            }
        }
        plateau[newPosX][newPosY] = this.Id;
        this.pos.translate(dirX*dx, dirY*dy);
    }
    
    /**
     * Renvoie un booléen true si la créature est morte
     * @return 
     * Morte ou pas
     */
    public boolean estMort(){
        return (this.ptVie<=0);
    }
    
    /**
     * Affiche les attributs de la créature
     */
    public abstract void affiche();
    
    
    
}
