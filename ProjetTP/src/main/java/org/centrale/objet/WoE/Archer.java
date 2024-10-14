package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Sous-classe de Personnage représentant un archer
 * 
 * @author mattlerigolo
 * @author morga
 */
public class Archer extends Personnage implements Combattant {
    /**
     * Nombre de flèches dans le carquois
     */
    private int nbFleches;
    
    /**
     * Constructeur par défaut
     */
    public Archer(){
        super();
        this.nbFleches = 10;
        this.setDistMaxAtt(5);
    };
    
    
    /**
     * Constructeur
     * @param nom
     * Nom du personnage
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
     * @param nbFleches
     * Nombre de flèches dans le carquois
     */
    public Archer(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distMaxAtt, Point2D pos, int nbFleches){
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distMaxAtt, pos);
        this.nbFleches = nbFleches;
    };
    
    /**
     * Constructeur de copie
     * @param a 
     * Archer à copier
     */
    public Archer(Archer a){
        super(a);
        this.nbFleches = a.getNbFleches();
    };

    public int getNbFleches() {
        return nbFleches;
    };

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    };
    
    /**
     * Crée un archer avec des attributs aléatoires
     */
    @Override public void creaElementDeJeuAlea(){
        Random random = new Random();
        this.ptVie = random.nextInt(50)+50; // points de vie entre 50 et 100
        this.ptPar = random.nextInt(10)+5; // entre 5 et 15
        this.degAtt = random.nextInt(10)+5; // degats d'attaque entre 5 et 15
        this.pagePar = random.nextInt(101); // entre 0 et 100
        this.pageAtt = random.nextInt(101); // entre 0 et 100
        this.distMaxAtt = random.nextInt(7)+3; // entre 3 et 10
        this.nbFleches = random.nextInt(10)+5; // entre 5 et 15
    }
    
    /**
     * Fonction d'affichage des caractèristiques du personnage
     */
    @Override public void affiche(){
        System.out.println("nom : " + this.nom +
                           "\nptVie : " + this.getPtVie() +
                           "\ndegAtt : " + this.getDegAtt() +
                           "\nptPar : " + this.getPtPar() +
                           "\npageAtt : " + this.getPageAtt() +
                           "\npagePar : " + this.getPagePar() +
                           "\ndistMaxAtt : " + this.distMaxAtt +
                           "\nNbFleches : " + this.nbFleches +
                           "\npos : " + "["+this.getPos().getX()+","+this.getPos().getY()+"] \n" );
    }
    
    /**
     * Action de combattre
     * @param c 
     * Créature à combattre
     */
    @Override public void combattre(Creature c){
        if (this.nbFleches <= 0){
            System.out.println("Plus de flèches pour attaquer");
        }
        else{
            this.nbFleches -= 1; // il perd une flèche dans tous les cas
            if (this.aDistancedAttaque(c)){ // l'archer ne peut attaquer qu'a distance
                Random r = new Random();
                int tirageAtt = r.nextInt(99)+1;

                if (tirageAtt <= this.pageAtt){
                    c.setPtVie(c.getPtVie()-this.degAtt);
                    System.out.println("Attaque Réussie !");
                }
                else {
                    System.out.println("Attaque Ratée !");
                }
            }
            else{
                System.out.println("Trop loin ou trop proche !");
            }
        }
    }
    
    /**
     * Fonction vérifiant si la créature c est à une distance strictment plus grande que 1 et plus petite que distMaxAtt de l'Archer
     * @param c
     * Créature que l'on veut attaquer
     * @return 
     * True si on peut l'attaquer, False si elle est trop proche ou trop loin
     */
    @Override public boolean aDistancedAttaque(Creature c){
        double distance = this.getPos().distance(c.getPos());
        return ((distance>1) && (distance<=this.getDistMaxAtt()));
    }
}
