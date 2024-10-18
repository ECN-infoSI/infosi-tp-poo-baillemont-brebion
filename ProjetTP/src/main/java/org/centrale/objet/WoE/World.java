package org.centrale.objet.WoE;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Création d'un monde WoE comprenant un archer, un paysan et un lapin (inutilisé). 
 * Leur position est initialisée aléatoirement à la création du monde par la méthode {@link #creaMondeAlea()}.
 * @author mattlerigolo
 * @author morga
 * 
 */
public class World {
    /** 
     * Une instance d'Archer, robin.
     * @see Archer
     */
    public Archer robin;
    
    /** 
     * Une instance d'Archer, guillaumeT.
     * @see Archer
     */
    public Archer guillaumeT;
    
    /** 
     * Une instance de Paysan, peon.
     * @see Paysan
     */
    public Paysan peon;
    
    /** 
     * Une instance de Lapin, bugs1.
     * @see Lapin
     */
    public Lapin bugs1;
    
    /** 
     * Une instance de Lapin, bugs2.
     * @see Lapin
     */
    public Lapin bugs2;
    
    /** 
     * Une instance de Guerrier, grosBill
     * @see Guerrier
     */
    public Guerrier grosBill;
    
    
    /** 
     * Une instance de Loup, wolfie
     * @see Loup
     */
    public Loup wolfie;
    
    
    
    
     /**
     * Constructeur par défaut.
     */
    public World(){
       
        this.robin = new Archer();
        this.peon = new Paysan();
        this.bugs1 = new Lapin();
        this.bugs2 = new Lapin();
        this.guillaumeT = new Archer();
        this.grosBill = new Guerrier();
        this.wolfie = new Loup();
    };
    
    
    /**
     * Constructeur.
     * @param a1
     *          Archer 1
     * @param p
     *          Paysan
     * @param l1
     *          Lapin 1
     * @param l2
     *          Lapin 2
     * @param a2
     *          Archer 2
     * @param g
     *          Guerrier
     * @param l3
     *          Loup
     * 
     */
    public World(Archer a1, Paysan p, Lapin l1, Lapin l2, Archer a2, Guerrier g, Loup l3){
        this.robin = a1;
        this.peon = p;
        this.bugs1 = l1;
        this.bugs2 = l2;
        this.guillaumeT = a2;
        this.grosBill = g;
        this.wolfie = l3;
    }
    /** 
    * Création des positions aléatoires des objets du monde. 
    * Deux objets ne peuvent pas être à la même position.
    */
    public void creaMondeAlea(){
    Random r = new Random();
    Creature[] creatures = {this.robin, this.peon, this.bugs1, this.bugs2, this.guillaumeT, this.grosBill, this.wolfie};
    Point2D[] positions = new Point2D[creatures.length];

    for (int i = 0; i < creatures.length; i++) {
        int x;
        int y;
        do {
            x = r.nextInt(201) - 100;
            y = r.nextInt(201) - 100;
            Point2D tempPosition = new Point2D(x, y);
            if (!java.util.Arrays.stream(positions).anyMatch((Point2D p) -> p != null && p.equals(tempPosition))) {
                positions[i] = tempPosition;
                creatures[i].setPos(positions[i]);
                break;
            }
        } while (true);
    }
};
    
    /** 
    * Affichage de toutes les créatures du monde.
    */
    public void afficheWorld(){
        Creature[] creatures = {this.robin, this.peon, this.bugs1, this.bugs2, this.guillaumeT, this.grosBill, this.wolfie};
        for (Creature creature : creatures) {
            creature.affiche();
        }
    }
    
};
