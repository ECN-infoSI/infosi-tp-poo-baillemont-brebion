/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author morga
 * @author mattlerigolo
 */
public abstract class Objet extends ElementDeJeu {
    protected int Id;
    public Objet(){
        this.Id = 1;
    }
    
    public int getId() {
        return Id;
    }
}
