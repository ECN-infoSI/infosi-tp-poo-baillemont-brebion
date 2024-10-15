package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/**
 *  Sous-classe de Objet représentant une potion de soin
 * @author morga
 * @author mattlerigolo
 */
public class PotionSoin extends Objet implements Utilisables {
    
    /**
     * Nombre de points de soin
     */
    private int ptSoin;
    
    /**
     * Position
     */
    private Point2D pos;
    
    /**
     * Potion consommée ou pas ?
     */
    private boolean consumed;
    
    /**
     * Constructeur par défaut
     */
    public PotionSoin(){
        this.ptSoin = 10;
        this.pos = new Point2D();
        this.consumed = false;
    }
    
    /**
     * Constructeur
     * @param pointsSoin
     * Points de soin
     * @param pos 
     * Position
     */
    public PotionSoin(int pointsSoin, Point2D pos){
        this.ptSoin = pointsSoin;
        this.pos = new Point2D(pos);
        this.consumed = false; // la potion est forcément pleine quand on la crée
    }
    
    /**
     * Constructeur de copie
     * @param p 
     * Potion à copier
     */
    public PotionSoin(PotionSoin p){
        this.ptSoin = p.getPtSoin();
        this.pos = new Point2D(p.getPos());
        this.consumed = p.isConsumed();
    }
        
    /**
     * Création d'une PotionSoin à partir d'une ligne de texte de la sauvegarde
     * @param ligne
     * Ligne représentant le guerrier dans un .txt
     * @return 
     * PotionSoin construite à partir de la ligne
     */
    @Override public PotionSoin create(String ligne){
        // tokenisation
        StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
        ArrayList<String> mots_ligne = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            mots_ligne.add(mot);
        }
        if (!mots_ligne.get(0).equalsIgnoreCase("PotionSoin")){
            PotionSoin potion = new PotionSoin(Integer.parseInt(mots_ligne.get(2)), new Point2D(Integer.parseInt(mots_ligne.get(3)), Integer.parseInt(mots_ligne.get(4))));
            return potion;
        }
        else {
            PotionSoin potion = new PotionSoin(Integer.parseInt(mots_ligne.get(1)), new Point2D(Integer.parseInt(mots_ligne.get(2)), Integer.parseInt(mots_ligne.get(3))));
            return potion;   
        }
    }
    
    @Override public String ligneSauvegarde(){
        return this.getClass().getSimpleName() +
                " " + this.getPtSoin() +
                " " + this.getPos().getX() +
                " " + this.getPos().getY();
    }

    public int getPtSoin() {
        return ptSoin;
    }

    public Point2D getPos() {
        return pos;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void setPtSoin(int ptSoin) {
        this.ptSoin = ptSoin;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public void setIsConsumed(boolean consumed) {
        this.consumed = consumed;
    }
    
    @Override public void creaElementDeJeuAlea(){
        Random random = new Random();
        this.setPtSoin(random.nextInt(11)+7); // entre 7 et 17
    }
    
}
