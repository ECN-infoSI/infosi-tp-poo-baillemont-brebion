package org.centrale.objet.WoE;

/**
 *
 * @author mattlerigolo
 * @author morga
 */
public class ProjetTP {

    public static void main(String[] args) {
        World_arrayList monde = new World_arrayList(10,10);
        GameLoop Game = new GameLoop(monde);
        monde.creaMondeAlea(2,2,2,2,2,10,10,10,3);
        monde.getPersonnages().get(0).setNom("Ivan");
        monde.getPersonnages().get(0).setPtVie(1);
        monde.getPersonnages().get(1).setNom("Dmitri");
        monde.getPersonnages().get(2).setNom("Aliocha");
        
        Game.startGame();
    }
}
