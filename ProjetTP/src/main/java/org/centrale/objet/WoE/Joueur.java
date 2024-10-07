package org.centrale.objet.WoE;

/**
 * Classe du joueur 
 * @author mattlerigolo
 */
public class Joueur {
    /**
     * Personnage joué par le joueur
     */
    public Personnage perso;
    
    /**
     * Constructeur par défaut
     */
    public Joueur(){
        this.perso = new Paysan(); // on met le perso comme un paysan qui est le personnage par défaut (aucun ajout par rapport à Personnage)
    }
    
    /**
     * Constructeur
     * @param perso
     * Personnage à attribuer au joueur
     */
    public Joueur(Personnage perso){
        this.perso = new Personnage(perso);
    }
    
    /**
     * Constructeur de copie
     * @param j 
     * Joueur à copier
     */
    public Joueur(Joueur j){
        this.perso = new Personnage(j.getPerso());
    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = new Personnage(perso);
    }
    
    
}



