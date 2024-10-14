package org.centrale.objet.WoE;

import java.util.Random;

/**
 *  Nuage toxique qui se déplace aléatoirement et fais des dégâts aux créatures
 * @author mattlerigolo
 */
public class NuageToxique extends Objet implements Combattant, Deplacable {
    private Point2D pos;
    private int degats;

    /**
     * Constructeur par défaut
     */
    public NuageToxique() {
        this.pos = new Point2D();
        degats = 5;
    }

    /**
     * Constructeur
     * @param pos
     * Position du nuage
     * @param degats 
     * Degats du nuage
     */
    public NuageToxique(Point2D pos, int degats) {
        this.pos = pos;
        this.degats = degats;
    }

    /**
     * Constructeur de copie
     * @param n 
     * Nuage à copier
     */
    public NuageToxique(NuageToxique n){
        this.pos = new Point2D(n.getPos());
        this.degats = n.getDegats();
    }
    
    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
    
    @Override public void combattre(Creature c){
        if (this.pos.samePosition(c.getPos())){
            c.setPtVie(c.getPtVie()-this.degats);
        }
    }
    
    @Override public void deplace(int[][] plateau){
        Random r = new Random();
        int dx = r.nextInt(2); // le nuage peut se déplacer sur les cases adjacentes
        int dirX = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon x
        int dy = r.nextInt(2);
        int dirY = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon y
        int newPosX = this.pos.getX()+dirX*dx;
        int newPosY = this.pos.getY()+dirY*dy;
        boolean goodPosition = false;
        while (!goodPosition){
            if ((newPosX >= 0 && newPosX < plateau.length) && (newPosY >= 0 && newPosY < plateau[0].length)){
                goodPosition = true; // la position est valide
            }
            else { // position non-valide donc on tire à nouveau au hasard
                dx = r.nextInt(2); // le nuage peut se déplacer sur les cases adjacentes
                dirX = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon x
                dy = r.nextInt(2);
                dirY = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon y
                newPosX = this.pos.getX()+dirX*dx;
                newPosY = this.pos.getY()+dirY*dy;
            }
        }
        this.pos.translate(dirX*dx, dirY*dy);
    }
    
    @Override public boolean aDistancedAttaque(Creature c){
        double distance = this.getPos().distance(c.getPos());
        return distance==0; //le nuage attaque seulement s'il est sur la même case qu'une créature
    }
}
