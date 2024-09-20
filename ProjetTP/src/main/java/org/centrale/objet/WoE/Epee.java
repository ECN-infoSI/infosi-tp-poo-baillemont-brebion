package org.centrale.objet.WoE;

/**
 *
 * @author morga
 */
public class Epee extends Objet{
    
    private int ptAtt;
    private int ptPar;
    private String nom;
    
    public Epee(){
        this.ptAtt = 20;
        this.ptPar = 10;
        this.nom = "Excalibur";
    }
    
    public Epee(int pointsAttaque, int pointsParade, String nom){
        this.ptAtt = pointsAttaque;
        this.ptPar = pointsParade;
        this.nom = nom;
    }
    
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
    
    
}
