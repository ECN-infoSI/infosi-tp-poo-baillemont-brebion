package org.centrale.objet.WoE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import static org.centrale.objet.WoE.Personnage.loadNamesFromFile;

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
     * Création d'un guerrier à partir d'une ligne de texte de la sauvegarde
     * @param ligne
     * Ligne représentant le guerrier dans un .txt
     * @return 
     * Guerrier construit à partir de la ligne
     */
    @Override public Guerrier create(String ligne){
        // tokenisation
        StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
        ArrayList<String> mots_ligne = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            mots_ligne.add(mot);
        }
        // construction de l'épée
        Epee epee_guerrier = new Epee(Integer.parseInt(mots_ligne.get(10)), Integer.parseInt(mots_ligne.get(11)), mots_ligne.get(12));
        Guerrier guerrier = new Guerrier(mots_ligne.get(1), Integer.parseInt(mots_ligne.get(2)), Integer.parseInt(mots_ligne.get(3)), Integer.parseInt(mots_ligne.get(4)), Integer.parseInt(mots_ligne.get(5)), Integer.parseInt(mots_ligne.get(6)), Integer.parseInt(mots_ligne.get(7)), new Point2D(Integer.parseInt(mots_ligne.get(8)), Integer.parseInt(mots_ligne.get(9))), epee_guerrier);
        return guerrier;
    }
    
    /**
     * Ecrit une ligne d'information sur l'objet pour sa sauvegarde.
     * @return
     */
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
                " " + this.getPos().getY() +
                " " + this.getEpee().getPtAtt() +
                " " + this.getEpee().getPtPar() +
                " " + this.getEpee().getNom();
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
     * Fonction vérifiant si la créature c est à une distance inférieure ou égale à distMaxAtt du Guerrier
     * @param c
     * Créature que l'on veut attaquer
     * @return 
     * True si on peut l'attaquer, False si elle est trop proche ou trop loin
     */
    @Override public boolean aDistancedAttaque(Creature c){
        double distance = this.getPos().distance(c.getPos());
        return distance<=this.getDistMaxAtt();
    }

    @Override public Guerrier clone(){
        return new Guerrier(this);
    }
     
}
