package org.centrale.objet.WoE;
import java.io.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
// File, FileReader, FileWriter
// BufferedReader, BufferedWriter
import java.util.StringTokenizer;
/**
 * Classe permettant la sauvegarde et le chargement d'un jeu.
 * @author morga
 * @author mattlerigolo
 */
public class Sauvegarde {
    protected String source;
    
    public Sauvegarde(String source){
        this.source = source;
    }
    
    /**
     * Charge une partie.
     * @return
     * Monde correspondant à la partie chargée
     * @throws IOException 
     * Si on arrive pas à trouver le fichier
     */
    public World_arrayList chargementPartie() throws IOException{
        String delimiteurs = " "; // délimiteurs pour la tokenisation
        // lecture du fichier source
        try{
            String ligne;
            BufferedReader fichier = new BufferedReader(new FileReader(source));
            ligne = fichier.readLine();
            // Récupération de la largeur et hauteur du monde
            int Largeur;
            int Hauteur;
            // création du tokenizer
            StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);
            ArrayList<String> mots_ligne = new ArrayList<>();
            while (tokenizer.hasMoreTokens()){
                    String mot = tokenizer.nextToken();
                    mots_ligne.add(mot);
                }
            
            if ("Largeur".equals(mots_ligne.get(0))){
                Largeur = Integer.parseInt(mots_ligne.get(1));
            }
            else{
                System.out.println("Fichier de sauvegarde corrompu.");
                return null;
            }
            
            ligne = fichier.readLine();
            tokenizer = new StringTokenizer(ligne, delimiteurs);
            mots_ligne = new ArrayList<>();
            while (tokenizer.hasMoreTokens()){
                    String mot = tokenizer.nextToken();
                    mots_ligne.add(mot);
                }
            
            if ("Hauteur".equals(mots_ligne.get(0))){
                Hauteur = Integer.parseInt(mots_ligne.get(1));
            }
            else{
                System.out.println("Fichier de sauvegarde corrompu.");
                return null;
            }
            
            ligne = fichier.readLine();
            // création d'un monde
            World_arrayList monde = new World_arrayList(Largeur, Hauteur, false);
            
            while (ligne != null){
                // tokenizer pour la ligne
                tokenizer = new StringTokenizer(ligne, delimiteurs);
                
                // Lecture de la classe
                String premier_mot = tokenizer.nextToken();
                if (premier_mot.equalsIgnoreCase("Inventaire")){
                    String deuxieme_mot = tokenizer.nextToken();
                    if (deuxieme_mot.equalsIgnoreCase("ClassiqueBurger")){
                        ClassiqueBurger burger = new ClassiqueBurger();
                        monde.getJoueur().getInventaire().add(burger.create(ligne));
                    }
                    else if (deuxieme_mot.equalsIgnoreCase("PotionSoin")){
                        PotionSoin potion = new PotionSoin();
                        monde.getJoueur().getInventaire().add(potion.create(ligne));
                    }
                    else if (deuxieme_mot.equalsIgnoreCase("Ilot5RU")){
                        Ilot5RU ilot = new Ilot5RU();
                        monde.getJoueur().getInventaire().add(ilot.create(ligne));
                    }
                }
                else if (premier_mot.equalsIgnoreCase("Effet")){
                    String deuxieme_mot = tokenizer.nextToken();
                    if (deuxieme_mot.equalsIgnoreCase("ClassiqueBurger")){
                        ClassiqueBurger burger = new ClassiqueBurger();
                        monde.getJoueur().getEffets().add(burger.create(ligne));
                    }
                    else if (deuxieme_mot.equalsIgnoreCase("Ilot5RU")){
                        Ilot5RU ilot = new Ilot5RU();
                        monde.getJoueur().getEffets().add(ilot.create(ligne));
                    }
                }
                else if (premier_mot.equalsIgnoreCase("Joueur")){
                    monde.getPlateau()[monde.getJoueur().getPerso().getPos().getX()][monde.getJoueur().getPerso().getPos().getX()]=0;
                    monde.setJoueur(monde.getJoueur().create(ligne));
                    monde.getPlateau()[monde.getJoueur().getPerso().getPos().getX()][monde.getJoueur().getPerso().getPos().getY()]=1;
                }
                else if (premier_mot.equalsIgnoreCase("Archer")){
                    Archer archer = new Archer();
                    archer = archer.create(ligne);
                    monde.addPersonnage(archer);
                }
                else if (premier_mot.equalsIgnoreCase("Guerrier")){
                    Guerrier guerrier = new Guerrier();
                    guerrier = guerrier.create(ligne);
                    monde.addPersonnage(guerrier);
                }
                else if (premier_mot.equalsIgnoreCase("Paysan")){
                    Paysan paysan = new Paysan();
                    paysan = paysan.create(ligne);
                    monde.addPersonnage(paysan);
                }
                else if (premier_mot.equalsIgnoreCase("Personnage")){
                    Personnage perso = new Personnage();
                    perso = perso.create(ligne);
                    monde.addPersonnage(perso);
                }
                else if (premier_mot.equalsIgnoreCase("Loup")) {
                    Loup loup = new Loup();
                    loup = loup.create(ligne);
                    monde.addMonstre(loup);
                } else if (premier_mot.equalsIgnoreCase("Lapin")) {
                    Lapin lapin = new Lapin();
                    lapin = lapin.create(ligne);
                    monde.addMonstre(lapin);
                } else if (premier_mot.equalsIgnoreCase("ClassiqueBurger")) {
                    ClassiqueBurger burger = new ClassiqueBurger();
                    burger = burger.create(ligne);
                    monde.addObjet(burger);
                } else if (premier_mot.equalsIgnoreCase("Ilot5RU")) {
                    Ilot5RU ilot = new Ilot5RU();
                    ilot = ilot.create(ligne);
                    monde.addObjet(ilot);
                } else if (premier_mot.equalsIgnoreCase("NuageToxique")) {
                    NuageToxique nuage = new NuageToxique();
                    nuage = nuage.create(ligne);
                    monde.addObjet(nuage);
                } else if (premier_mot.equalsIgnoreCase("PotionSoin")) {
                    PotionSoin potion = new PotionSoin();
                    potion = potion.create(ligne);
                    monde.addObjet(potion);
                }
                else if (premier_mot.equalsIgnoreCase("Tour")){
                    // création du tokenizer
                    monde.setTour(Integer.parseInt(tokenizer.nextToken()));
                    
        
        while (tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            mots_ligne.add(mot);
        }
                }
                
                else{
                    // ajout de l'information au monde
                    try {
                        Class<?> clazz = Class.forName(premier_mot);
                        Constructor<?> constructor = clazz.getConstructor(String.class);
                        Object instance = constructor.newInstance(ligne);

                        // Ajout de l'objet au monde
                        if (instance instanceof Personnage) {
                            Personnage personnage = (Personnage) instance;
                            monde.addPersonnage(personnage);
                        } else if (instance instanceof Monstre) {
                            Monstre monstre = (Monstre) instance;
                            monde.addMonstre(monstre);
                        } else if (instance instanceof Objet) {
                            Objet objet = (Objet) instance;
                            monde.addObjet(objet);
                        } else {
                            System.out.println("Classe non conforme dans le fichier de sauvegarde.");
                        }
                    } catch (ClassNotFoundException e) {
                        System.out.println("Classe non trouvée : " + e.getMessage());
                    } catch (InstantiationException e) {
                        System.out.println("Erreur d'instanciation : " + e.getMessage());
                    } catch (IllegalAccessException e) {
                        System.out.println("Erreur d'accès : " + e.getMessage());
                    }
                }
                
                ligne = fichier.readLine();
            }
            fichier.close();
            
            return monde;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
        
        
    }
    
    /**
     * Sauvegarde une partie.
     * @param monde
     * Monde à sauvegarder
     * @throws IOException 
     */
    public void sauvegardePartie(World_arrayList monde) throws IOException {
    // Écriture du fichier de sauvegarde
    try (BufferedWriter fichier = new BufferedWriter(new FileWriter(this.source))) {
        // Écriture de la largeur et de la hauteur du monde
        fichier.write("Largeur " + monde.getPlateau()[0].length);
        fichier.newLine();
        fichier.write("Hauteur " + monde.getPlateau().length);
        fichier.newLine();
        
        // Écriture du joueur
        fichier.write(monde.getJoueur().ligneSauvegarde());
        fichier.newLine();
        
        // Écriture des personnages du monde
        for (Personnage element : monde.getPersonnages()) {
            fichier.write(element.ligneSauvegarde());
            fichier.newLine();
        }
        // Écriture des monstres du monde
        for (Monstre element : monde.getMonstres()) {
            fichier.write(element.ligneSauvegarde());
            fichier.newLine();
        }
        // Écriture des objets du monde
        for (Objet element : monde.getObjets()) {
            fichier.write(element.ligneSauvegarde());
            fichier.newLine();
        }
        
        // Écriture de l'inventaire du personnage
        for (Utilisables element : monde.getJoueur().getInventaire()) {
            fichier.write("Inventaire ");
            Objet elem = (Objet)element;
            fichier.write(elem.ligneSauvegarde());
            fichier.newLine();
        }  
        
        // Écriture des effets du personnage
        for (Utilisables element : monde.getJoueur().getEffets()) {
            fichier.write("Effet ");
            Objet elem = (Objet)element;
            fichier.write(elem.ligneSauvegarde());
            fichier.newLine();
        }  
       // Ecriture du numéro du tour
        fichier.write("Tour ");
        fichier.write(Integer.toString(monde.getTour()));
        fichier.newLine();
        
        fichier.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
}
