package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Sous-classe de personnage représentant un guerrier
 * @author mattlerigolo
 * @author morga
 */
public class Guerrier extends Personnage implements Combattant {
    /**
     * Epée du guerrier
     */
    private Epee epee;
    
    /**
     * Constructeur par défaut
     */
    public Guerrier(){
        super();
        this.epee = new Epee();
    }
    
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
     * @param epee
     * Epée du guerrier
     */
    public Guerrier(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distMaxAtt, Point2D pos, Epee epee){
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distMaxAtt, pos);
        this.epee = epee;
    }
    
    /**
     * Constructeur de copie
     * @param g 
     * Guerrier à copier
     */
    public Guerrier(Guerrier g){
        super(g);
        this.epee = new Epee(g.getEpee());
    }

    public Epee getEpee() {
        return epee;
    }

    public void setEpee(Epee epee) {
        this.epee = epee;
    }
    
    /**
     * Crée un guerrier avec des attributs aléatoires
     */
    @Override public void creaElementDeJeuAlea(){
        Random random = new Random();
        this.ptVie = random.nextInt(50)+75; // points de vie entre 75 et 125
        this.degAtt = random.nextInt(15)+15; // degats d'attaque entre 15 et 30
        this.ptPar = random.nextInt(10)+5; // entre 5 et 15
        this.pagePar = random.nextInt(101); // entre 0 et 100
        this.pageAtt = random.nextInt(101); // entre 0 et 100
        this.epee = new Epee();
        this.epee.setPtAtt(degAtt);
    }
    
    /**
     * Action de combattre
     * @param c 
     * Créature à combattre
     */
    @Override public void combattre(Creature c){
        if (this.aDistancedAttaque(c)){ // le guerrier ne peut pas attaquer à distance
            Random r = new Random();
            int tirageAtt = r.nextInt(99)+1;
            int tirageDef = r.nextInt(99)+1;
            
            if (tirageAtt <= this.pageAtt){
                if (tirageDef > c.getPagePar()){
                    c.setPtVie(c.getPtVie()-this.epee.getPtAtt());
                    System.out.println("Attaque Réussie !");
                }
                else{
                    c.setPtVie(c.getPtVie()-this.epee.getPtAtt()+c.getPtPar());
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
     * Fonction vérifiant si la créature c est à une distance <= à distMaxAtt du Guerrier
     * @param c
     * Créature que l'on veut attaquer
     * @return 
     * True si on peut l'attaquer, False si elle est trop proche ou trop loin
     */
    @Override public boolean aDistancedAttaque(Creature c){
        double distance = this.getPos().distance(c.getPos());
        return distance<=this.getDistMaxAtt();
    }
}
