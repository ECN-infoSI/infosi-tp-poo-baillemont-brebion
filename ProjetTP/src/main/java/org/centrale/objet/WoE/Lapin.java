package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Sous-classe de Monstre représentant un lapin
 * @author mattlerigolo
 * @author morga
 */
public class Lapin extends Monstre {
    
    /**
     * Constructeur par défaut
     */
    public Lapin(){
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
    public Lapin(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos){
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    };
    
    
    /**
     * Constructeur de copie
     * @param l 
     * Lapin à copier
     */
    public Lapin(Lapin l){
        super(l);
    };
    
    /**
     * Création d'un lapin à partir d'une ligne de texte de la sauvegarde
     * @param ligne
     * Ligne représentant le guerrier dans un .txt
     * @return 
     * Lapin construit à partir de la ligne
     */
    @Override public Lapin create(String ligne){
        // tokenisation
        StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
        ArrayList<String> mots_ligne = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            mot = mot.toLowerCase(); // mot en minuscules
            mots_ligne.add(mot);
        }
        Lapin lapin = new Lapin(Integer.parseInt(mots_ligne.get(1)), Integer.parseInt(mots_ligne.get(2)), Integer.parseInt(mots_ligne.get(3)), Integer.parseInt(mots_ligne.get(4)), Integer.parseInt(mots_ligne.get(5)), new Point2D(Integer.parseInt(mots_ligne.get(6)), Integer.parseInt(mots_ligne.get(7))));
        return lapin;
    }
    
    /**
     * Crée un lapin avec des attributs aléatoires
     */
    @Override public void creaElementDeJeuAlea(){
        Random random = new Random();
        this.ptVie = random.nextInt(20)+10; // points de vie entre 10 et 30
        this.degAtt = random.nextInt(5)+1; // degats d'attaque entre 1 et 5
        this.pagePar = random.nextInt(101); // entre 0 et 100
        this.pageAtt = random.nextInt(101); // entre 0 et 100
        this.ptPar = random.nextInt(10)+5; // entre 5 et 15
    }
}
