package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Sous-classe de Monstre représentant un Loup
 * 
 * @author mattlerigolo
 * @author morga
 */

public class Loup extends Monstre implements Combattant {
    /**
     * Constructeur par défaut
     */
    public Loup(){
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
    public Loup(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos){
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }
    
    /**
     * Constructeur de copie
     * @param l 
     * Loup à copier
     */
    public Loup(Loup l){
        super(l);
    }
    
    /**
     * Crée un loup avec des attributs aléatoires
     */
    @Override public void creaElementDeJeuAlea(){
        Random random = new Random();
        this.ptVie = random.nextInt(50)+25; // points de vie entre 25 et 755
        this.degAtt = random.nextInt(15)+15; // degats d'attaque entre 15 et 30
        this.pagePar = random.nextInt(101); // entre 0 et 100
        this.pageAtt = random.nextInt(101); // entre 0 et 100
        this.ptPar = random.nextInt(10)+5; // entre 5 et 15
    }
    
    /**
     * Action de combattre
     * @param c 
     * Créature à combattre
     */
    @Override public void combattre(Creature c){
        if (this.aDistancedAttaque(c)){
            Random r = new Random();
            int tirageAtt = r.nextInt(99)+1;
            int tirageDef = r.nextInt(99)+1;
            
            if (tirageAtt <= this.pageAtt){
                if (tirageDef > c.getPagePar()){
                    c.setPtVie(c.getPtVie()-this.degAtt);
                    System.out.println("Attaque Réussie ! \n");
                }
                else{
                    c.setPtVie(c.getPtVie()-this.degAtt+c.getPtPar());
                    System.out.println("Attaque Réussie, mais parade de l'adversaire !");
                }
            }
            else {
                System.out.println("Attaque Ratée !");
            }
        }
        else{
            System.out.println("Trop loin !");
        }
    }
    
    /**
     * Fonction vérifiant si la créature c est à une distance <= 1 du loup 
     * @param c
     * Créature que l'on veut attaquer
     * @return 
     * True si on peut l'attaquer, False si elle est trop proche ou trop loin
     */
    @Override public boolean aDistancedAttaque(Creature c){
        double distance = this.getPos().distance(c.getPos());
        return distance<=1; // tous les monstres ont une diqtance d'attaque de 1
    }
}
