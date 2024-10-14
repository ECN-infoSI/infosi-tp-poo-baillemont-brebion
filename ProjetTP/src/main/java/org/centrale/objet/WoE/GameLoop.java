package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Scanner;
import org.centrale.objet.WoE.Monstre;
import java.util.Random;
import java.util.LinkedList;
import java.util.Iterator;

/**
 *
 * @author morga
 */
public class GameLoop {
    private boolean gameOver = false;
    private World_arrayList monde;
    
    
    public GameLoop(World_arrayList monde) {
        this.monde = monde;
    }
    
    public void startGame(World_arrayList monde) {
        monde.getJoueur().getPerso().affiche();
        
        monde.affichePlateau();
        while (!gameOver) {
            // Update stage
            updateGame();

            // Render stage
            renderGame();

            // Repeat stage
            try {
                Thread.sleep(16); // 16ms = 60fps
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Déplacement du personnage sur une case choisie par le joueur.
     */
    private void deplaceJoueur() {
        Scanner scanner = new Scanner(System.in);
        // Afficher la position du joueur
        System.out.println("Position du joueur : (" + monde.getJoueur().perso.getPos().getX() + ", " + monde.getJoueur().perso.getPos().getY() + ")");
        //Afficher les cases accessibles autour du joueur
        System.out.println("Cases accessibles :");
        int x = monde.getJoueur().perso.getPos().getX();
        int y = monde.getJoueur().perso.getPos().getY();
        int[][] casesAccessibles = new int[3][3];
        int compteur = 1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < monde.getPlateau().length && newY >= 0 && newY < monde.getPlateau()[0].length) {
                    if (monde.getPlateau()[newX][newY] == 0) {
                        casesAccessibles[i + 1][j + 1] = compteur;
                        compteur++;
                    }
                    else if (i == 0 && j == 0){
                        // case actuelle est toujours disponible pour le déplacement
                        casesAccessibles[1][1] = compteur;
                        compteur++;
                    }
                    else {
                        casesAccessibles[i + 1][j + 1] = 0;
                    }
                } else {
                    casesAccessibles[i + 1][j + 1] = 0;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (casesAccessibles[i][j] != 0) {
                    System.out.println("Case " + casesAccessibles[i][j] + " : (" + (x - 1 + i) + ", " + (y - 1 + j) + ")");
                }
            }
        }
        
        // Demander au joueur de choisir une case
        System.out.println("Choisissez une case :");
        int choix = scanner.nextInt();
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (casesAccessibles[i][j] == choix) {
                    int newX = x - 1 + i;
                    int newY = y - 1 + j;
                    monde.getJoueur().deplace(monde.getPlateau(), newX, newY);
                }
            }
        }
        for (Objet objet : this.monde.getObjets()){
            if (objet instanceof PotionSoin) {
            // Traiter l'objet comme une PotionSoin
                PotionSoin potion = (PotionSoin) objet;
                if (potion.getPos().samePosition(monde.getJoueur().getPerso().getPos())){
                    monde.getJoueur().getInventaire().add(potion);
                    System.out.println("Objet ajouté à l'inventaire ! \n");
                }
            }       
            else if (objet instanceof Nourriture) {
            // Traiter l'objet comme une Nourriture
                Nourriture nourriture = (Nourriture) objet;
                if (nourriture.getPos().samePosition(monde.getJoueur().getPerso().getPos())){
                    monde.getJoueur().getInventaire().add(nourriture);
                    System.out.println("Objet ajouté à l'inventaire ! \n");
                }
            }
            else if (objet instanceof NuageToxique){
                NuageToxique nuage = (NuageToxique) objet;
                if (nuage.getPos().samePosition(monde.getJoueur().getPerso().getPos())){
                    nuage.combattre(monde.getJoueur().getPerso());
                    System.out.println("On dirait le gaz dans BrawlStar. " + nuage.getDegats()+ " points de vie perdus. \n");
                }
            }
        }
    }
        
     
    private void combattre(){
        // Trouve des créatures à combattre
        
        Scanner scanner = new Scanner(System.in);
        // Afficher la position du joueur
        System.out.println("Position du joueur : (" + monde.getJoueur().perso.getPos().getX() + ", " + monde.getJoueur().perso.getPos().getY() + ")");
        //Afficher les cases accessibles autour du joueur
        System.out.println("Créatures à bonne distance de combat (si aucune créature ne s'affiche, taper 0) :");
        int compteur = 1;
        ArrayList<Creature> creatures = new ArrayList<>();
        for (Personnage perso : monde.getPersonnages()){
            creatures.add((Creature)perso);
        }
        for (Monstre monstre : monde.getMonstres()){
            creatures.add((Creature)monstre); 
        }
        for (Creature creature : creatures) {
            Personnage persoJoueur = monde.getJoueur().getPerso();
            if (persoJoueur instanceof Combattant){
                Combattant combJoueur = (Combattant) persoJoueur;
                if (combJoueur.aDistancedAttaque(creature)){ // on n'affiche que les créatures à bonne distance pour attaquer
                    System.out.println("Créature " + creature.getId() + " : ");
                    creature.affiche();
                    compteur ++;
                }
            }
        }
        // Demander au joueur de choisir une case
        System.out.println("Choisissez une créature :");
        int choix = scanner.nextInt();
        
        // Trouver la créature correspondante à l'ID choisi
        Creature creatureChoisie = null;
        for (Creature creature : creatures) {
            if (creature.getId() == choix) {
                creatureChoisie = creature;
                break;
            }
        }

        if (creatureChoisie != null && monde.getJoueur().perso instanceof Combattant) {
            Combattant comb = (Combattant) (monde.getJoueur().perso);
            comb.combattre(creatureChoisie);
            System.out.println("Créature " + choix + " après l'attaque :");
            creatureChoisie.affiche();
            if (creatureChoisie.estMort()){
                if (creatureChoisie instanceof Monstre){
                    Monstre monstre = (Monstre) creatureChoisie;
                    if (monstre.estMort()){
                        System.out.println(monstre.getClass().getSimpleName() + " est mort");
                        this.monde.getPlateau()[monstre.getPos().getX()][monstre.getPos().getY()] = 0;
                        this.monde.getMonstres().remove(monstre);
                    }
                }
                else if (creatureChoisie instanceof Personnage){
                    Personnage perso = (Personnage) creatureChoisie;
                    if (perso.estMort()){
                        System.out.println(perso.getNom() + " est mort");
                        this.monde.getPlateau()[perso.getPos().getX()][perso.getPos().getY()] = 0;
                        this.monde.getPersonnages().remove(perso);
                    }
                }
            }
        } 
        else {
            System.out.println("Créature non trouvée ou choix invalide.");
        }
    }
    
    private void consommer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Objets dans l'inventaire :");
        int compteur = 1;
        LinkedList<Utilisables> inventaire = this.monde.getJoueur().getInventaire();
        LinkedList<Utilisables> effets = this.monde.getJoueur().getEffets();
        
        if (inventaire.isEmpty()){
            System.out.println("Dommage, l'inventaire est vide !");
        }
        else {
            for (Utilisables objet : inventaire){
                System.out.println("Objet " + compteur + " : ");
                System.out.println(objet.getClass().getSimpleName() + "\n");
                compteur++;
            }
            System.out.println("Choisissez un objet à consommer :");
            int choix = scanner.nextInt();
            if (choix >= 1 && choix <= inventaire.size()){
                Utilisables objetChoisi = inventaire.get(choix - 1); // Récupérer l'objet (indices commençant à 0)
                // Ajouter l'objet à la liste des effets
                if (objetChoisi instanceof Nourriture){
                    Nourriture nourriture = (Nourriture) objetChoisi;
                    effets.add(nourriture);
                    // Supprimer l'objet de l'inventaire
                    inventaire.remove(objetChoisi);
                    System.out.println(objetChoisi.getClass().getSimpleName() + " a été consommé et ajouté aux effets. \n");
                    nourriture.mangerPar(this.monde.getJoueur().getPerso());

                }
                else if (objetChoisi instanceof PotionSoin){
                    PotionSoin potion = (PotionSoin) objetChoisi;
                    this.monde.getJoueur().getPerso().boirePotion(potion);
                }


            }
            else {
                System.out.println("Choix non valide, aucune action effectuée \n");
            }
        }
    }
    
    private void updateEffets(){
        LinkedList<Utilisables> effets = this.monde.getJoueur().getEffets();
        for (Utilisables objet : effets){
            if (objet instanceof Nourriture){
                Nourriture nourriture = (Nourriture) objet;
                nourriture.passerTour();
                if (nourriture.effetFini()){
                    nourriture.finEffet(this.monde.getJoueur().getPerso());
                }
            }
        }
    }
    
    private void updateGame() {
        // Update game state, handle user input, and perform calculations
        this.updateEffets();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voulez-vous vous déplacer, combattre ou consommer un objet de votre inventaire ?\n1 : Se déplacer\n2 : Combattre\n3 : Consommer");
        String classe = scanner.nextLine();
        if (classe.equalsIgnoreCase("1")){
            deplaceJoueur();
        }
        else if(classe.equalsIgnoreCase("2")){
            combattre();
        }
        else if(classe.equalsIgnoreCase("3")){
            consommer();
        }
        else{
            System.out.println("Action non-valide, pas d'action effectuée \n");
        }
        System.out.println();
        if (monde.getJoueur().perso.ptVie == 0) {
            gameOver = true; 
            System.out.println("GAME OVER");
        }
        Random random = new Random();
        // On fait se déplacer tous les personnages et ceux qui peuvent attaquer tentent d'attaquer
        for (Personnage perso : this.monde.getPersonnages()) {
            perso.deplace(this.monde.getPlateau());
            // on regarde s'il dans un nuage toxique
            for (Objet objet : this.monde.getObjets()){
                if (objet instanceof NuageToxique){
                    NuageToxique nuage = (NuageToxique) objet;
                    if (nuage.getPos().samePosition(perso.getPos())){
                        nuage.combattre(perso);
                        System.out.println(perso.getNom() + " est dans un nuage toxique \n");
                    }
                }
            }
            // Si c'est un combattant, il a 25% de chances d'attaquer le joueur s'il est à distance
            if (perso instanceof Combattant) {
                Personnage persoJoueur = this.monde.getJoueur().getPerso();
                Combattant combattant = (Combattant) perso;
                if (combattant.aDistancedAttaque(persoJoueur)){
                    if (random.nextInt(100) < 25) { // 25% de chance
                        System.out.println(perso.getNom() + " attaque le joueur !");
                        combattant.combattre(this.monde.getJoueur().getPerso());
                        System.out.println("\n");
                    }
                }
            }
        }
    
        // On fait se déplacer tous les monstres et ceux qui peuvent attaquer tentent d'attaquer
        for (Monstre monstre : this.monde.getMonstres()) {
            monstre.deplace(this.monde.getPlateau());
            // on regarde s'il dans un nuage toxique
            for (Objet objet : this.monde.getObjets()){
                if (objet instanceof NuageToxique){
                    NuageToxique nuage = (NuageToxique) objet;
                    if (nuage.getPos().samePosition(monstre.getPos())){
                        nuage.combattre(monstre);
                        System.out.println(monstre.getClass().getSimpleName() + " est dans un nuage toxique \n");
                    }
                }
            }
            // Si c'est un combattant, il a 60% de chances d'attaquer le joueur s'il est à bonne distance
            if (monstre instanceof Combattant) {
                Personnage persoJoueur = this.monde.getJoueur().getPerso();
                Combattant combattant = (Combattant) monstre;
                if (combattant.aDistancedAttaque(persoJoueur)){ // on considère que les monstres ne peuvent attaquer à distance
                    if (random.nextInt(100) < 60) { // 60% de chance
                        System.out.println(monstre.getClass().getSimpleName() + " attaque le joueur !");
                        combattant.combattre(this.monde.getJoueur().getPerso());
                        System.out.println("\n");
                    }
                }
            } 
        }
        
        // on fait se déplacer les nuages toxiques
        for (Objet objet : this.monde.getObjets()){
            if (objet instanceof NuageToxique){
                NuageToxique nuage = (NuageToxique) objet;
                nuage.deplace(this.monde.getPlateau());
                for (Personnage perso : this.monde.getPersonnages()){
                    if (nuage.getPos().samePosition(perso.getPos())){
                            nuage.combattre(perso);
                            System.out.println(perso.getNom() + " est dans un nuage toxique \n");
                    }
                }
                for (Monstre monstre : this.monde.getMonstres()){
                    if (nuage.getPos().samePosition(monstre.getPos())){
                            nuage.combattre(monstre);
                            System.out.println(monstre.getClass().getSimpleName() + " est dans un nuage toxique \n");
                    }
                }
            }
        }
        
        // Parcours des monstres et suppression des morts
        Iterator<Monstre> monstreIterator = this.monde.getMonstres().iterator();
        while (monstreIterator.hasNext()) {
            Monstre monstre = monstreIterator.next();
            if (monstre.estMort()) {
                this.monde.getPlateau()[monstre.getPos().getX()][monstre.getPos().getY()] = 0;
                monstreIterator.remove(); // Suppression sûre
                System.out.println(monstre.getClass().getSimpleName() + " est mort \n");
            }
        }

        // Parcours des personnages et suppression des morts
        Iterator<Personnage> persoIterator = this.monde.getPersonnages().iterator();
        while (persoIterator.hasNext()) {
            Personnage perso = persoIterator.next();
            if (perso.estMort()) {
                this.monde.getPlateau()[perso.getPos().getX()][perso.getPos().getY()] = 0;
                persoIterator.remove(); // Suppression sûre
                System.out.println(perso.getNom() + " est mort \n");
            }
        }   
    }

    private void renderGame() {
        // Render the updated game state to the screen
        monde.getJoueur().perso.affiche();
        this.monde.affichePlateau();
    }
}