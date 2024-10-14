package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

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
        this.nom = e.getNom();
        this.ptPar = e.getPtPar();
    }
    
    /**
     * Création d'une épée à partir d'une ligne de texte de la sauvegarde
     * @param ligne
     * Ligne représentant le guerrier dans un .txt
     * @return 
     * Épée construit à partir de la ligne
     */
    @Override public Epee create(String ligne){
        // tokenisation
        StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
        ArrayList<String> mots_ligne = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            mot = mot.toLowerCase(); // mot en minuscules
            mots_ligne.add(mot);
        }
        Epee epee = new Epee(Integer.parseInt(mots_ligne.get(1)), Integer.parseInt(mots_ligne.get(2)), mots_ligne.get(3));
        return epee;
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
