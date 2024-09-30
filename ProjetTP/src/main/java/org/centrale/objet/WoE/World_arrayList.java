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
     * Matrice représentant le plateau de jeu
     */
    private int[][] plateau;
    
    
    
     /**
     * Constructeur par défaut.
     */
    public World_arrayList(){
        this.personnages = new ArrayList<Personnage>();
        this.monstres = new ArrayList<Monstre>();
        this.objets = new ArrayList<Objet>();
        this.plateau = new int[100][100];
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
     * 
     * @param plateau
     * Plateau de jeu
     */
    public World_arrayList(ArrayList<Personnage> persos, ArrayList<Monstre> monstres, ArrayList<Objet> objets, int[][] plateau){
        this.personnages = new ArrayList<Personnage>(persos);
        this.monstres = new ArrayList<Monstre>(monstres);
        this.objets = new ArrayList<Objet>(objets);
        this.plateau = new int[plateau.length][plateau[0].length];
        
        for (int i=0; i<plateau.length; i++){
            for (int j=0; i<plateau[0].length; j++){
                this.plateau[i][j] = plateau[i][j];
            }
        }
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
        this.plateau = new int[world.getPlateau().length][world.getPlateau()[0].length];
        for (int i=0; i<world.getPlateau().length; i++){
            for (int j=0; i<world.getPlateau()[0].length; j++){
                this.plateau[i][j] = world.getPlateau()[i][j];
            }
        }
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

    public int[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(int[][] plateau) {
        this.plateau = new int[plateau.length][plateau[0].length];
        for (int i=0; i<plateau.length; i++){
            for (int j=0; i<plateau[0].length; j++){
                this.plateau[i][j] = plateau[i][j];
            }
        }
    }
        
    /**
     * Ajouter un personnage à notre monde
     * @param perso 
     * Personnage à ajouter
     */
    public void addPersonnage(Personnage perso){
        if (this.plateau[perso.getPos().getX()][perso.getPos().getY()] != 0){
            System.out.println("Une créature se trouve déjà sur la position du personnage à ajouter");
        }
        else {
            this.getPersonnages().add(perso);
        }
    }
    
    /**
     * Ajouter un monstre au monde
     * @param monstre 
     */
    public void addMonstre(Monstre monstre){
        if (this.plateau[monstre.getPos().getX()][monstre.getPos().getY()] != 0){
            System.out.println("Une créature se trouve déjà sur la position du personnage à ajouter");
        }
        else {
            this.getMonstres().add(monstre);
        }
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
     */
    public void creaMondeAlea(int nbPaysan, int nbGuerrier, int nbArcher, int nbLapin, int nbLoup, int nbPotion){
        // On remet le monde à 0
        this.personnages = new ArrayList<Personnage>();
        this.monstres = new ArrayList<Monstre>();
        this.objets = new ArrayList<Objet>();
        
        for (int i=0; i<nbArcher; i++){
            Archer archer = new Archer();
            Random r = new Random();
            int x = r.nextInt(this.plateau.length);
            int y = r.nextInt(this.plateau[0].length);
            while (plateau[x][y] != 0){
                x = r.nextInt(this.plateau.length);
                y = r.nextInt(this.plateau[0].length);
            }
            plateau[x][y] = 1;
            archer.setPos(new Point2D(x,y));
            this.addPersonnage(archer);
        }
        
        for (int i=0; i<nbPaysan; i++){
            Paysan paysan = new Paysan();
            Random r = new Random();
            int x = r.nextInt(this.plateau.length);
            int y = r.nextInt(this.plateau[0].length);
            while (plateau[x][y] != 0){
                x = r.nextInt(this.plateau.length);
                y = r.nextInt(this.plateau[0].length);
            }
            plateau[x][y] = 1;
            paysan.setPos(new Point2D(x,y));
            this.addPersonnage(paysan);
        }
        
        for (int i=0; i<nbGuerrier; i++){
            Guerrier guerrier = new Guerrier();
            Random r = new Random();
            int x = r.nextInt(this.plateau.length);
            int y = r.nextInt(this.plateau[0].length);
            while (plateau[x][y] != 0){
                x = r.nextInt(this.plateau.length);
                y = r.nextInt(this.plateau[0].length);
            }
            plateau[x][y] = 1;
            guerrier.setPos(new Point2D(x,y));
            this.addPersonnage(guerrier);
        }
        
        for (int i=0; i<nbLoup; i++){
            Loup loup = new Loup();
            Random r = new Random();
            int x = r.nextInt(this.plateau.length);
            int y = r.nextInt(this.plateau[0].length);
            while (plateau[x][y] != 0){
                x = r.nextInt(this.plateau.length);
                y = r.nextInt(this.plateau[0].length);
            }
            plateau[x][y] = 1;
            loup.setPos(new Point2D(x,y));
            this.addMonstre(loup);
        }
        
        for (int i=0; i<nbLapin; i++){
            Lapin lapin = new Lapin();
            Random r = new Random();
            int x = r.nextInt(this.plateau.length);
            int y = r.nextInt(this.plateau[0].length);
            while (plateau[x][y] != 0){
                x = r.nextInt(this.plateau.length);
                y = r.nextInt(this.plateau[0].length);
            }
            plateau[x][y] = 1;
            lapin.setPos(new Point2D(x,y));
            this.addMonstre(lapin);
        }
        
        for (int i=0; i<nbPotion; i++){
            PotionSoin potion = new PotionSoin();
            Random r = new Random();
            int x = r.nextInt(this.plateau.length);
            int y = r.nextInt(this.plateau[0].length);
            potion.setPos(new Point2D(x,y));
            this.addObjet(potion);
        }
    }
    
    public void creaMondeAlea(){
        Random r = new Random();
        int nbArcher = r.nextInt(11);
        int nbPaysan = r.nextInt(11);
        int nbGuerrier = r.nextInt(11);
        int nbLapin = r.nextInt(11);
        int nbLoup = r.nextInt(11);
        int nbPotion = r.nextInt(11);
        
        this.creaMondeAlea(nbPaysan, nbGuerrier, nbArcher, nbLapin, nbLoup, nbPotion);
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

