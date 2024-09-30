package org.centrale.objet.WoE;

import java.util.Random;
import java.util.LinkedList;


/**
 * Création d'un monde WoE comprenant un archer, un paysan et un lapin. 
 * Leur position est initialisée aléatoirement à la création du monde par la méthode {@link #creaMondeAlea()}.
 * @author mattlerigolo
 * @author morga
 * 
 */
public class World_linkedList{
    
    /** Linked List contenant les personnages du Monde.
     * 
     */
    public LinkedList<Personnage> personnages = new LinkedList<>();
    /** Linked List contenant les monstres du Monde.
     * 
     */
    public LinkedList<Monstre> monstres = new LinkedList<>();
    
    /** Linked List contenant les objets du Monde.
     * 
     */
    public LinkedList<Objet> objets = new LinkedList<>();
    
    /**
     * Constructeur par défaut.
     */
    public World_linkedList(){
        this.personnages = new LinkedList<Personnage>();
        this.monstres = new LinkedList<Monstre>();
        this.objets = new LinkedList<Objet>();
    };
    
    /**
     * Constructeur.
     * @param persos
     * Liste de Personnage
     * 
     * @param monstres
     * Liste de monstres
     * 
     * @param objets
     * Liste d'objets
     */
    public World_linkedList(LinkedList<Personnage> persos, LinkedList<Monstre> monstres, LinkedList<Objet> objets){
        this.personnages = new LinkedList<Personnage>(persos);
        this.monstres = new LinkedList<Monstre>(monstres);
        this.objets = new LinkedList<Objet>(objets);
    }

    public LinkedList<Personnage> getPersonnages() {
        return personnages;
    }

    public void setPersonnages(LinkedList<Personnage> personnages) {
        this.personnages = personnages;
    }

    public LinkedList<Monstre> getMonstres() {
        return monstres;
    }

    public void setMonstres(LinkedList<Monstre> monstres) {
        this.monstres = monstres;
    }

    public LinkedList<Objet> getObjets() {
        return objets;
    }

    public void setObjets(LinkedList<Objet> objets) {
        this.objets = objets;
    }
    
    /**
     * Ajouter un personnage à notre monde
     * @param perso 
     * Personnage à ajouter
     */
    public void addPersonnage(Personnage perso){
        this.getPersonnages().add(perso);
    }
    
    /**
     * Ajouter un monstre au monde
     * @param monstre 
     */
    public void addMonstre(Monstre monstre){
        this.getMonstres().add(monstre);
    }
    
    public void addObjet(Objet objet){
        this.getObjets().add(objet);
    }
    
   /**
     * Constructeur.
     * @param nbArchers
     *          Nombre d'archers.
     * @param nbPaysans
     *          Nombre de paysans.
     * @param nbGuerriers
     *          Nombre de guerriers.
     * @param nbLoups
     *          Nombre de loups.
     * @param nbLapins
     *          Nombre de lapins.
     * @param nbPotionSoins
     *          Nombre de potions de soin.
     * @param nbEpees
     *          Nombre d'épées.
     * 
     */ 
    public World_linkedList(int nbArchers, int nbPaysans, int nbGuerriers, int nbLoups, int nbLapins, int nbPotionSoins, int nbEpees){

        // Crée les archers et les ajoute à la liste
        for (int i = 0; i < nbArchers; i++) {
            Archer archer = new Archer();
            archer.setNom("Archer " + (i + 1));
            listePersonnages.add(archer);
        }

        // Crée les guerriers et les ajoute à la liste
        for (int i = 0; i < nbGuerriers; i++) {
            Guerrier guerrier = new Guerrier();
            guerrier.setNom("Guerrier " + (i + 1));
            listePersonnages.add(guerrier);
        }
        
        // Crée les paysans et les ajoute à la liste
        for (int i = 0; i < nbPaysans; i++) {
            Paysan paysan = new Paysan();
            paysan.setNom("Paysan " + (i + 1));
            listePersonnages.add(paysan);
        }
        

        // Crée les loups et les ajoute à la liste
        for (int i = 0; i < nbLoups; i++) {
            Loup loup = new Loup();
            listeMonstres.add(loup);
        }

        // Crée les lapins et les ajoute à la liste
        for (int i = 0; i < nbLapins; i++) {
            Lapin lapin = new Lapin();
            listeMonstres.add(lapin);
        }
        
        // Crée les Potions de Soin et les ajoute à la liste
        for (int i = 0; i < nbPotionSoins; i++) {
            PotionSoin potion = new PotionSoin();
            listeObjets.add(potion);
        }

        // Crée les Epees et les ajoute à la liste
        for (int i = 0; i < nbEpees; i++) {
            Epee epee = new Epee();
            listeObjets.add(epee);
        }
   
    };

    
     /**
     * Constructeur par défaut, crée un nombre alétoire de personnages, monstres et objets.
     */
    public World_linkedList(){
       // Génère un nombre aléatoire de Personnages
        Random random = new Random();
        int nbArchers = random.nextInt();
        int nbGuerriers = random.nextInt();
        int nbPaysans = random.nextInt();
        
        // Génère un nombre aléatoire de Monstres
        int nbLoups = random.nextInt();
        int nbLapins = random.nextInt();

        // Génère un nombre aléatoire d'Objets.
        int nbPotionSoins = random.nextInt();
        int nbEpees = random.nextInt();

        Wornew World_linkedList(nbArchers, nbPaysans, nbGuerriers, nbLoups, nbLapins, nbPotionSoins, nbEpees);
   
    };
    
    
    

    
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

