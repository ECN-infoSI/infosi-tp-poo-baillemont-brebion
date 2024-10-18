package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

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
     * Personnage déjà existant
     * 
     */
    public Personnage(Personnage perso){
        super(perso);
        this.nom = perso.nom;
        this.distMaxAtt = perso.distMaxAtt;
    }
    
    /**
     * Création d'un personnage à partir d'une ligne de texte de la sauvegarde
     * @param ligne
     * Ligne représentant le guerrier dans un .txt
     * @return 
     * Personnage construit à partir de la ligne
     */
    @Override public Personnage create(String ligne){
        // tokenisation
        StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
        ArrayList<String> mots_ligne = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            mots_ligne.add(mot);
        }
        Personnage perso = new Personnage(mots_ligne.get(1), Integer.parseInt(mots_ligne.get(2)), Integer.parseInt(mots_ligne.get(3)), Integer.parseInt(mots_ligne.get(4)), Integer.parseInt(mots_ligne.get(5)), Integer.parseInt(mots_ligne.get(6)), Integer.parseInt(mots_ligne.get(7)), new Point2D(Integer.parseInt(mots_ligne.get(8)), Integer.parseInt(mots_ligne.get(9))));
        return perso;
    }
    
    @Override public String ligneSauvegarde(){
        return this.getClass().getSimpleName() + 
                " " + this.getNom() +
                " " + this.getPtVie() + 
                " " + this.getDegAtt() + 
                " " + this.getPtPar() +
                " " + this.getPageAtt() +
                " " + this.getPagePar() +
                " " + this.getDistMaxAtt() +
                " " + this.getPos().getX() +
                " " + this.getPos().getY();
    }
    
    /**
     *
     * @return
     * Nom du personnage
     */
    public String getNom(){
        return this.nom ;
    };

    /**
     *
     * @return
     * Distance Maximale d'attaque
     */
    public int getDistMaxAtt() {
        return distMaxAtt;
    }
    
    /**
     *
     * @param newNom
     * Nouveau nom
     */
    public void setNom(String newNom){
        this.nom = newNom;
    };

    /**
     *
     * @param distMaxAtt
     * Distance maximale d'attaque
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
    
    
    /**
     * Action de boire une potion pot.
     * @param pot 
     * Potion que le personnage veut boire
     */
    
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
    
    public static List<String> loadNamesFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
    
    /**
     * Crée un personnage avec des attributs aléatoires
     */
    @Override public void creaElementDeJeuAlea(){
        Random random = new Random();
        try {
            // Charger noms depuis les fichiers texte
            List<String> noms = loadNamesFromFile("mmo_names.txt");
            // Générer et afficher un nom
            nom = noms.get(random.nextInt(noms.size()));
        } catch (IOException e) {
            this.nom = "Robert";
        }
        this.ptVie = random.nextInt(50)+25; // points de vie entre 25 et 75
        this.ptPar = random.nextInt(10)+5; // entre 5 et 15
        this.degAtt = random.nextInt(10)+5; // degats d'attaque entre 5 et 15
        this.pagePar = random.nextInt(101); // entre 0 et 100
        this.pageAtt = random.nextInt(101); // entre 0 et 100
    }
    
    @Override public Personnage clone(){
        return new Personnage(this);
    }
}