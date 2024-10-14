package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/**
 *  Nuage toxique qui se déplace aléatoirement et fais des dégâts aux créatures
 * @author mattlerigolo
 */
public class NuageToxique extends Objet implements Combattant, Deplacable {
    private Point2D pos;
    private int degats;

    /**
     * Constructeur par défaut
     */
    public NuageToxique() {
        this.pos = new Point2D();
        degats = 5;
    }

    /**
     * Constructeur
     * @param pos
     * Position du nuage
     * @param degats 
     * Degats du nuage
     */
    public NuageToxique(Point2D pos, int degats) {
        this.pos = pos;
        this.degats = degats;
    }

    /**
     * Constructeur de copie
     * @param n 
     * Nuage à copier
     */
    public NuageToxique(NuageToxique n){
        this.pos = new Point2D(n.getPos());
        this.degats = n.getDegats();
    }
    
    /**
     * Création d'un NuageToxique à partir d'une ligne de texte de la sauvegarde
     * @param ligne
     * Ligne représentant le guerrier dans un .txt
     * @return 
     * NuageToxique construite à partir de la ligne
     */
    @Override public NuageToxique create(String ligne){
        // tokenisation
        StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
        ArrayList<String> mots_ligne = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            mot = mot.toLowerCase(); // mot en minuscules
            mots_ligne.add(mot);
        }
        NuageToxique nuage = new NuageToxique(new Point2D(Integer.parseInt(mots_ligne.get(1)), Integer.parseInt(mots_ligne.get(2))), Integer.parseInt(mots_ligne.get(3)));
        return nuage;
    }
    
    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
    
    @Override public void combattre(Creature c){
        if (this.aDistancedAttaque(c)){
            c.setPtVie(c.getPtVie()-this.degats);
        }
    }
    
    @Override public void deplace(int[][] plateau){
        Random r = new Random();
        int dx = r.nextInt(2); // le nuage peut se déplacer sur les cases adjacentes
        int dirX = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon x
        int dy = r.nextInt(2);
        int dirY = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon y
        int newPosX = this.pos.getX()+dirX*dx;
        int newPosY = this.pos.getY()+dirY*dy;
        boolean goodPosition = false;
        while (!goodPosition){
            if ((newPosX >= 0 && newPosX < plateau.length) && (newPosY >= 0 && newPosY < plateau[0].length)){
                goodPosition = true; // la position est valide
            }
            else { // position non-valide donc on tire à nouveau au hasard
                dx = r.nextInt(2); // le nuage peut se déplacer sur les cases adjacentes
                dirX = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon x
                dy = r.nextInt(2);
                dirY = r.nextBoolean() ? 1 : -1; // on choisit la direction de déplacement selon y
                newPosX = this.pos.getX()+dirX*dx;
                newPosY = this.pos.getY()+dirY*dy;
            }
        }
        this.pos.translate(dirX*dx, dirY*dy);
    }
    
    /**
     * Fonction vérifiant si la créature c est à la même position que le nuage
     * @param c
     * Créature que l'on veut attaquer
     * @return 
     * True si on peut l'attaquer, False si elle est trop proche ou trop loin
     */
    @Override public boolean aDistancedAttaque(Creature c){
        return this.getPos().samePosition(c.getPos()); //le nuage attaque seulement s'il est sur la même case qu'une créature
    }
    
    @Override public void creaElementDeJeuAlea(){
        Random random = new Random();
        this.setDegats(random.nextInt(6)+3);
    }
}
