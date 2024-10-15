package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Sous-classe de Personnage représentant un paysan
 * @author mattlerigolo
 * @author morga
 */
public class Paysan extends Personnage {
    /**
     * Constructeur par défaut
     */
    public Paysan(){
        super();
    };
    
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
     */
    public Paysan(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distMaxAtt, Point2D pos){
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distMaxAtt, pos);
    };
    
    /**
     * Constructeur de copie
     * @param p 
     * Paysan à copier
     */
    public Paysan(Paysan p){
        super(p);
    };
    
    /**
     * Création d'un paysan à partir d'une ligne de texte de la sauvegarde
     * @param ligne
     * Ligne représentant le guerrier dans un .txt
     * @return 
     * Paysan construit à partir de la ligne
     */
    @Override public Paysan create(String ligne){
        // tokenisation
        StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
        ArrayList<String> mots_ligne = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            mots_ligne.add(mot);
        }
        Paysan paysan = new Paysan(mots_ligne.get(1), Integer.parseInt(mots_ligne.get(2)), Integer.parseInt(mots_ligne.get(3)), Integer.parseInt(mots_ligne.get(4)), Integer.parseInt(mots_ligne.get(5)), Integer.parseInt(mots_ligne.get(6)), Integer.parseInt(mots_ligne.get(7)), new Point2D(Integer.parseInt(mots_ligne.get(8)), Integer.parseInt(mots_ligne.get(9))));
        return paysan;
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
}
