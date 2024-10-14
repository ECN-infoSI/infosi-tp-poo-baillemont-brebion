/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.io.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
// File, FileReader, FileWriter
// BufferedReader, BufferedWriter
import java.util.StringTokenizer;
/**
 *
 * @author morga
 */
public class Sauvegarde {
    protected String source;
    
    public Sauvegarde(String source){
        this.source = source;
    }
    
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
                    mot = mot.toLowerCase(); // mot en minuscules
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
                    mot = mot.toLowerCase(); // mot en minuscules
                    mots_ligne.add(mot);
                }
            
            if ("Hauteur".equals(mots_ligne.get(0))){
                Hauteur = Integer.parseInt(mots_ligne.get(1));
            }
            else{
                System.out.println("Fichier de sauvegarde corrompu.");
                return null;
            }
            
            // création d'un monde
            World_arrayList monde = new World_arrayList(Largeur, Hauteur);
            
            while (ligne != null){
                System.out.println(ligne);
                // décomposition de la ligne en mots
                
                // tokenizer pour la ligne
                tokenizer = new StringTokenizer(ligne, delimiteurs);
                
                // Lecture de la classe
                String premier_mot = tokenizer.nextToken();
                if (premier_mot == "Inventaire"){
                    String classe = tokenizer.nextToken();
                    try {
                        Class<?> clazz = Class.forName(classe);
                        Constructor<?> constructor = clazz.getConstructor(String.class);
                        Utilisables instance = (Utilisables) constructor.newInstance(ligne.substring(11));
                        monde.getJoueur().getInventaire().add(instance);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else if (premier_mot == "Effet"){
                    String classe = tokenizer.nextToken();
                    try {
                        Class<?> clazz = Class.forName(classe);
                        Constructor<?> constructor = clazz.getConstructor(String.class);
                        Utilisables instance = (Utilisables) constructor.newInstance(ligne.substring(6));
                        monde.getJoueur().getEffets().add(instance);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else if (premier_mot == "Joueur"){
                    String classe = tokenizer.nextToken();
                    try {
                        Class<?> clazz = Class.forName(classe);
                        Constructor<?> constructor = clazz.getConstructor(String.class);
                        Personnage instance = (Personnage) constructor.newInstance(ligne.substring(7));
                        monde.getJoueur().setPerso(instance);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    // ajout de l'information au monde
                    try {
                        Class<?> clazz = Class.forName(premier_mot);
                        Constructor<?> constructor = clazz.getConstructor(String.class);
                        Object instance = constructor.newInstance(ligne);

                        // Ajout de l'objet au monde
                        switch (instance) {
                            case Personnage personnage -> monde.addPersonnage(personnage);
                            case Monstre monstre -> monde.addMonstre(monstre);
                            case Objet objet -> monde.addObjet(objet);
                            default -> System.out.println("Classe non conforme dans le fichier de sauvegarde.");
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
    
    public void sauvegardePartie(World_arrayList monde) throws IOException {
    // Écriture du fichier de sauvegarde
    try (BufferedWriter fichier = new BufferedWriter(new FileWriter(this.source))) {
        // Écriture de la largeur et de la hauteur du monde
        fichier.write("Largeur " + monde.getPlateau()[0].length + "\n");
        fichier.newLine();
        fichier.write("Hauteur " + monde.getPlateau().length + "\n");
        
        // Écriture des personnages du monde
        for (Object element : monde.getPersonnages()) {
            String classe = element.getClass().getName();
            fichier.write(classe + " ");
            fichier.write(element.ligneSauvegarde());
        }
        // Écriture des monstres du monde
        for (Object element : monde.getMonstres()) {
            String classe = element.getClass().getName();
            fichier.write(classe + " ");
            fichier.write(element.ligneSauvegarde());
        }
        // Écriture des objets du monde
        for (Object element : monde.getObjets()) {
            String classe = element.getClass().getName();
            fichier.write(classe + " ");
            fichier.write(element.ligneSauvegarde());
        }
        
        // Écriture de l'inventaire du personnage
        for (Object element : monde.getJoueur().getInventaire()) {
            String classe = element.getClass().getName();
            fichier.write(classe + " ");
            fichier.write(element.ligneSauvegarde());
        }  
        
        // Écriture des effets du personnage
        for (Object element : monde.getJoueur().getEffets()) {
            String classe = element.getClass().getName();
            fichier.write(classe + " ");
            fichier.write(element.ligneSauvegarde());
        }  
        
        fichier.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
}
