package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Nourriture qui influe sur les points d'attaque quand consommée
 * @author mattlerigolo
 */
public class Ilot5RU extends Nourriture {
    public Ilot5RU() {
        super();
    }

    public Ilot5RU(Point2D pos, int bonusMalus, int tempsEffet, boolean isConsumed) {
        super(pos, bonusMalus, tempsEffet, isConsumed);
    }

    public Ilot5RU(Nourriture n) {
        super(n);
    }
    
    /**
     * Création d'un Ilot5RU à partir d'une ligne de texte de la sauvegarde
     * @param ligne
     * Ligne représentant le guerrier dans un .txt
     * @return 
     * Ilot5RU construit à partir de la ligne
     */
    @Override public Ilot5RU create(String ligne){
        // tokenisation
        StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
        ArrayList<String> mots_ligne = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            mot = mot.toLowerCase(); // mot en minuscules
            mots_ligne.add(mot);
        }
        Ilot5RU ilot = new Ilot5RU(new Point2D(Integer.parseInt(mots_ligne.get(1)), Integer.parseInt(mots_ligne.get(2))), Integer.parseInt(mots_ligne.get(3)), Integer.parseInt(mots_ligne.get(4)), Integer.parseInt(mots_ligne.get(5))==1);
        return ilot;
    }
    
    
    @Override public String ligneSauvegarde(){
        int consumed;
        if (this.isIsConsumed()){
            consumed = 1;
        }
        else {
            consumed = 0;
        }
        return this.getClass().getSimpleName() +
                " " + this.getPos().getX() +
                " " + this.getPos().getY() +
                " " + this.getBonusMalus() +
                " " + this.getTempsEffet() +
                " " + consumed;
    }
    
    @Override public void mangerPar(Personnage p){
        p.setDegAtt(p.getDegAtt()-this.getBonusMalus());
        this.setIsConsumed(true);
    }
    
    @Override public void finEffet(Personnage p){
        if (this.effetFini()){
            p.setDegAtt(p.getDegAtt()+this.getBonusMalus());
        }
    }
}
