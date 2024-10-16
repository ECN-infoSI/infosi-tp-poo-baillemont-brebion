package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

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
     * Création d'un loup à partir d'une ligne de texte de la sauvegarde
     * @param ligne
     * Ligne représentant le guerrier dans un .txt
     * @return 
     * Loup construit à partir de la ligne
     */
    @Override public Loup create(String ligne){
        // tokenisation
        StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
        ArrayList<String> mots_ligne = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            mots_ligne.add(mot);
        }
        Loup loup = new Loup(Integer.parseInt(mots_ligne.get(1)), Integer.parseInt(mots_ligne.get(2)), Integer.parseInt(mots_ligne.get(3)), Integer.parseInt(mots_ligne.get(4)), Integer.parseInt(mots_ligne.get(5)), new Point2D(Integer.parseInt(mots_ligne.get(6)), Integer.parseInt(mots_ligne.get(7))));
        return loup;
    }
    
    /**
     * Ecrit une ligne d'information sur l'objet pour sa sauvegarde.
     * @return
     */
    @Override public String ligneSauvegarde(){
        return this.getClass().getSimpleName() + 
                " " + this.getPtVie() + 
                " " + this.getDegAtt() + 
                " " + this.getPtPar() +
                " " + this.getPageAtt() +
                " " + this.getPagePar() +
                " " + this.getPos().getX() +
                " " + this.getPos().getY();
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
     * Fonction vérifiant si la créature c est à une distance inférieure ou égale à 1 du loup 
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
