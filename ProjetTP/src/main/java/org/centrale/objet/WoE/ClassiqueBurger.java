package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Nourriture qui augmente les points de parade quand consommée
 * @author mattlerigolo
 */
public class ClassiqueBurger extends Nourriture {

    public ClassiqueBurger() {
        super();
    }

    public ClassiqueBurger(Point2D pos, int bonusMalus, int tempsEffet, boolean isConsumed) {
        super(pos, bonusMalus, tempsEffet, isConsumed);
    }

    public ClassiqueBurger(Nourriture n) {
        super(n);
    }
    
    /**
     * Création d'un ClassiqueBurger à partir d'une ligne de texte de la sauvegarde
     * @param ligne
     * Ligne représentant le guerrier dans un .txt
     * @return 
     * ClassiqueBurger construit à partir de la ligne
     */
    @Override public ClassiqueBurger create(String ligne){
        // tokenisation
        StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
        ArrayList<String> mots_ligne = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            mots_ligne.add(mot);
        }
        ClassiqueBurger burger = new ClassiqueBurger(new Point2D(Integer.parseInt(mots_ligne.get(1)), Integer.parseInt(mots_ligne.get(2))), Integer.parseInt(mots_ligne.get(3)), Integer.parseInt(mots_ligne.get(4)), Integer.parseInt(mots_ligne.get(5))==1);
        return burger;
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
        p.setPtPar(p.getPtPar()+this.getBonusMalus());
        this.setIsConsumed(true);
    }
    
    @Override public void finEffet(Personnage p){
        if (this.effetFini()){
            p.setPtPar(p.getPtPar()-this.getBonusMalus());
        }
    }
}
