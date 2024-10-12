package org.centrale.objet.WoE;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Création d'un monde WoE comprenant un archer, un paysan et un lapin. 
 * Leur position est initialisée aléatoirement à la création du monde par la méthode {@link #creaMondeAlea()}.
 * @author mattlerigolo
 * @author morga
 * 
 */
public class World_arrayList {
    /**
     * Le joueur
     */
    private Joueur joueur;
    
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
    private LinkedList<Objet> objets;
    
    /**
     * Matrice représentant le plateau de jeu
     */
    private int[][] plateau;
    
    /**
     * Compteur d'ID
     */
    private int nextId = 1; 
    
     /**
     * Constructeur par défaut.
     */
    public World_arrayList(){
        this.joueur = new Joueur();
        this.joueur.perso.setId(nextId ++);
        this.personnages = new ArrayList<Personnage>();
        this.monstres = new ArrayList<Monstre>();
        this.objets = new LinkedList<Objet>();
        this.plateau = new int[100][100];
        
        this.plateau[this.joueur.getPerso().getPos().getX()][this.joueur.getPerso().getPos().getY()] = 10; // 10 sera le nombre pour le joueur
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
     * 
     * @param joueur
     * Joueur
     */
    public World_arrayList(ArrayList<Personnage> persos, ArrayList<Monstre> monstres, LinkedList<Objet> objets, int[][] plateau, Joueur joueur){
        this.joueur = new Joueur(joueur);
        this.joueur.perso.setId(nextId ++);
        this.personnages = new ArrayList<Personnage>(persos);
        this.monstres = new ArrayList<Monstre>(monstres);
        this.objets = new LinkedList<Objet>(objets);
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
        this.joueur = new Joueur(world.getJoueur());
        this.joueur.perso.setId(nextId ++);
        this.personnages = new ArrayList<Personnage>(world.getPersonnages());
        this.monstres = new ArrayList<Monstre>(world.getMonstres());
        this.objets = new LinkedList<Objet>(world.getObjets());
        this.plateau = new int[world.getPlateau().length][world.getPlateau()[0].length];
        for (int i=0; i<world.getPlateau().length; i++){
            for (int j=0; i<world.getPlateau()[0].length; j++){
                this.plateau[i][j] = world.getPlateau()[i][j];
            }
        }
    }
    
    public World_arrayList(int longueur, int largeur){
        this.joueur = new Joueur();
        this.joueur.perso.setId(nextId ++);
        this.personnages = new ArrayList<Personnage>();
        this.monstres = new ArrayList<Monstre>();
        this.objets = new LinkedList<Objet>();
        this.plateau = new int[largeur][longueur];
        
        this.plateau[this.joueur.getPerso().getPos().getX()][this.joueur.getPerso().getPos().getY()] = joueur.perso.getId(); 
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

    public LinkedList<Objet> getObjets() {
        return objets;
    }

    public void setObjets(LinkedList<Objet> objets) {
        this.objets = new LinkedList<Objet>(objets);
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

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = new Joueur(joueur);
    }
    
    /**
     * Ajouter un personnage à notre monde
     * @param perso 
     * Personnage à ajouter
     */
    public void addPersonnage(Personnage perso){
        if (perso.getPos().getX() < 0 || perso.getPos().getX() >= plateau.length){
            System.out.println("Position en dehors du plateau");
        }
        else if (perso.getPos().getY() < 0 || perso.getPos().getY() >= plateau[0].length){
            System.out.println("Position en dehors du plateau");
        }
        else if (this.plateau[perso.getPos().getX()][perso.getPos().getY()] != 0){
            System.out.println("Une créature se trouve déjà sur la position du personnage à ajouter");
        }
        else {
            this.getPersonnages().add(perso);
            perso.setId(nextId ++);
            this.plateau[perso.getPos().getX()][perso.getPos().getY()]=perso.getId();
        }
    }
    
    /**
     * Ajouter un monstre au monde
     * @param monstre 
     */
    public void addMonstre(Monstre monstre){
        if (monstre.getPos().getX() < 0 || monstre.getPos().getX() >= plateau.length){
            System.out.println("Position en dehors du plateau");
        }
        else if (monstre.getPos().getY() < 0 || monstre.getPos().getY() >= plateau[0].length){
            System.out.println("Position en dehors du plateau");
        }
        else if (this.plateau[monstre.getPos().getX()][monstre.getPos().getY()] != 0){
            System.out.println("Une créature se trouve déjà sur la position du personnage à ajouter");
        }
        else {
            this.getMonstres().add(monstre);
            monstre.setId(nextId ++);
            this.plateau[monstre.getPos().getX()][monstre.getPos().getY()]=monstre.getId();
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
     * @param nbBurger
     * Nombre du burgers dans le monde (bonus)
     * @param nbIlot5
     * Nombre d'ilôts 5 du RU dans le monde (malus)
     * @param nbNuage
     * Nombre de nuages toxiques dans le monde
     */
    public void creaMondeAlea(int nbPaysan, int nbGuerrier, int nbArcher, int nbLapin, int nbLoup, int nbPotion, int nbBurger, int nbIlot5, int nbNuage){
        // On remet le monde à 0
        this.personnages = new ArrayList<Personnage>();
        this.monstres = new ArrayList<Monstre>();
        this.objets = new LinkedList<Objet>();
        
        for (int i=0; i<nbArcher; i++){
            Archer archer = new Archer();
            Random r = new Random();
            int x = r.nextInt(this.plateau.length);
            int y = r.nextInt(this.plateau[0].length);
            while (plateau[x][y] != 0){
                x = r.nextInt(this.plateau.length);
                y = r.nextInt(this.plateau[0].length);
            }
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
        
        for (int i=0; i<nbBurger; i++){
            ClassiqueBurger burger = new ClassiqueBurger();
            Random r = new Random();
            int x = r.nextInt(this.plateau.length);
            int y = r.nextInt(this.plateau[0].length);
            burger.setPos(new Point2D(x,y));
            this.addObjet(burger);
        }
        
        for (int i=0; i<nbIlot5; i++){
            Ilot5RU ilot = new Ilot5RU();
            Random r = new Random();
            int x = r.nextInt(this.plateau.length);
            int y = r.nextInt(this.plateau[0].length);
            ilot.setPos(new Point2D(x,y));
            this.addObjet(ilot);
        }
        
        for (int i=0; i<nbIlot5; i++){
            NuageToxique nuage = new NuageToxique();
            Random r = new Random();
            int x = r.nextInt(this.plateau.length);
            int y = r.nextInt(this.plateau[0].length);
            nuage.setPos(new Point2D(x,y));
            this.addObjet(nuage);
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
        int nbBurger = r.nextInt(11);
        int nbIlot = r.nextInt(11);
        int nbNuage = r.nextInt(11);
        
        this.creaMondeAlea(nbPaysan, nbGuerrier, nbArcher, nbLapin, nbLoup, nbPotion, nbBurger, nbIlot, nbNuage);
    }
    
    /** 
    * Affichage de toutes les créatures du monde.
    */
    public void afficheWorld(){
        System.out.println("Personnage principal :");
        this.joueur.getPerso().affiche();
        
        System.out.println("\nAutres créatures :");
        for (Personnage perso : this.personnages){
            perso.affiche();
        }
        for (Monstre monstre : this.monstres){
            monstre.affiche();
        }
    }
    
    /**
     * Affiche l'état du plateau actuel
     */
    public void affichePlateau(){
        for (int i = 0; i < this.plateau.length; i++) {
            for (int j = 0; j < this.plateau[i].length; j++) {
                System.out.print(this.plateau[i][j] + "\t"); // \t pour une meilleure présentation
            }
            System.out.println(); // Passer à la ligne suivante après chaque ligne de la matrice
        }
    }
    
    public Creature getMonstre(int id){
        for (Monstre monstre : this.monstres) {
            if (monstre.getId() == id) {
                return monstre;
            }
        }
        return null;
    }
          
    /**
    public Object getObjet(int id) {
        for (Utilisables objet : this.objets) {
            if (objet.getId() == id) {
                return objet;
            }
        }
        return null;
    }
    */
    
    public Personnage getPersonnage(int id) {
        for (Personnage perso : this.personnages) {
            if (perso.getId() == id) {
                return perso;
            }
        }
        return null;
    }
    
    public Creature getCreature(int id) {
        // Cherche dans le tableau de personnages
        for (Personnage perso : personnages) {
            if (perso.getId() == id) {
                return perso;
            }
        }

        // Cherche dans le tableau de monstres
        for (Monstre monstre : monstres) {
            if (monstre.getId() == id) {
                return monstre;
            }
        }

        return null;
    }
    
    
};

