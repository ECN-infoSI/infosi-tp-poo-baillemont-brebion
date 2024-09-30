package org.centrale.objet.WoE;
import java.util.Random;
import java.util.ArrayList;

/**
 * Création d'un monde WoE comprenant un archer, un paysan et un lapin. 
 * Leur position est initialisée aléatoirement à la création du monde par la méthode {@link #creaMondeAlea()}.
 * @author mattlerigolo
 * @author morga
 * 
 */
public class World_arrayList {
     /** 
     * Une liste de Personnage
     */
    private ArrayList<Personnage> personnages;
    
    
    /** 
     * Une liste de Monstre
     */
    private ArrayList<Monstre> monstres;
    
    /** 
     * Une liste d'Objet
     */
    private ArrayList<Objet> objets;
    
    
    
    
     /**
     * Constructeur par défaut.
     */
    public World_arrayList(){
        this.personnages = new ArrayList<Personnage>();
        this.monstres = new ArrayList<Monstre>();
        this.objets = new ArrayList<Objet>();
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
    public World_arrayList(ArrayList<Personnage> persos, ArrayList<Monstre> monstres, ArrayList<Objet> objets){
        this.personnages = new ArrayList<Personnage>(persos);
        this.monstres = new ArrayList<Monstre>(monstres);
        this.objets = new ArrayList<Objet>(objets);
    }
    
    /**
     * Constructeur de copie
     * @param world 
     * Monde à copier
     */
    public World_arrayList(World_arrayList world){
        this.personnages = new ArrayList<Personnage>(world.getPersonnages());
        this.monstres = new ArrayList<Monstre>(world.getMonstres());
        this.objets = new ArrayList<Objet>(world.getObjets());
    }
    
    public ArrayList<Personnage> getPersonnages() {
        return personnages;
    }

    public void setPersonnages(ArrayList<Personnage> personnages) {
        this.personnages = new ArrayList<Personnage>(personnages);
    }

    public ArrayList<Monstre> getMonstres() {
        return monstres;
    }

    public void setMonstres(ArrayList<Monstre> monstres) {
        this.monstres = new ArrayList<Monstre>(monstres);
    }

    public ArrayList<Objet> getObjets() {
        return objets;
    }

    public void setObjets(ArrayList<Objet> objets) {
        this.objets = new ArrayList<Objet>(objets);
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
     * Création d'un monde aléatoire
     * @param nbPaysan
     * Nombre de paysans dans le monde
     * @param nbGuerrier
     * Nombre de guerriers dans le monde
     * @param nbArcher
     * Nombre d'archers dans le monde
     * @param nbLapin
     * Nombre de lapins dans le monde
     * @param nbLoup
     * Nombre de loups dans le monde
     * @param nbPotion
     * Nombre de potions dans le monde
     * @param nbEpee 
     * Nombre d'épées dans le monde
     */
    public void creaMondeAlea(int nbPaysan, int nbGuerrier, int nbArcher, int nbLapin, int nbLoup, int nbPotion, int nbEpee){
        // On remet le monde à 0
        this.personnages = new ArrayList<Personnage>();
        this.monstres = new ArrayList<Monstre>();
        this.objets = new ArrayList<Objet>();
        
        
    }
    
    public void creaMondeAlea(){
        Random r = new Random();
        int nbArcher = r.nextInt(11);
        int nbPaysan = r.nextInt(11);
        int nbGuerrier = r.nextInt(11);
        int nbLapin = r.nextInt(11);
        int nbLoup = r.nextInt(11);
        int nbPotion = r.nextInt(11);
        int nbEpee = r.nextInt(11);
        
        this.creaMondeAlea(nbPaysan, nbGuerrier, nbArcher, nbLapin, nbLoup, nbPotion, nbEpee);
    }
    
    /** 
    * Affichage de toutes les créatures du monde.
    */
    public void afficheWorld(){
        for (Personnage perso : this.personnages){
            perso.affiche();
        }
        for (Monstre monstre : this.monstres){
            monstre.affiche();
        }
    }
    
};

