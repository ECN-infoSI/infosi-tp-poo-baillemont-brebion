package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Sous-classe d'Objet représentant une épée
 * @author morga
 * @author mattlerigolo
 */
public class Epee extends Objet{
    
    /**
     * Points d'attaque
     */
    private int ptAtt;
    
    /**
     * Points de parade
     */
    private int ptPar;
    
    /**
     * Nom de l'épée
     */
    private String nom;
    
    /**
     * Constructeur par défaut
     */
    public Epee(){
        this.ptAtt = 20;
        this.ptPar = 10;
        this.nom = "Excalibur";
    }
    
    /**
     * Constructeur
     * @param pointsAttaque
     * Points d'attaque
     * @param pointsParade
     * Points de parade
     * @param nom 
     * Nom de l'épée
     */
    public Epee(int pointsAttaque, int pointsParade, String nom){
        this.ptAtt = pointsAttaque;
        this.ptPar = pointsParade;
        this.nom = nom;
    }
    
    /**
     * Constructeur de copie
     * @param e 
     * Epée à copier
     */
    public Epee(Epee e){
        this.ptAtt = e.getPtAtt();
        
    }

    public int getPtAtt() {
        return ptAtt;
    }
    
    public int getPtPar() {
        return ptPar;
    }

    public String getNom() {
        return nom;
    }

    public void setPtAtt(int ptAtt) {
        this.ptAtt = ptAtt;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    @Override public void creaElementDeJeuAlea(){
        Random random = new Random();
        this.setPtAtt(random.nextInt(11)+5); // entre 5 et 15
        this.setPtPar(random.nextInt(11)+5); // entre 5 et 15
    }
    
}
