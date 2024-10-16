package org.centrale.objet.WoE;

/**
 *
 * @author mattlerigolo
 * @author morga
 */
public class ProjetTP {

    public static void main(String[] args) {
        World_arrayList monde = new World_arrayList(5,5,false);
        GameLoop Game = new GameLoop(monde);
        
        Game.startGame();
    }
}
