/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author morga
 */
public class Epee extends Objet{
    
    private int ptAtt;
    
    public Epee(){
        this.ptAtt = 10;
    }
    
    public Epee(int pointsAttaque){
        this.ptAtt = pointsAttaque;
    }
    
    public Epee(Epee e){
        this.ptAtt = e.getPtAtt();
    }

    public int getPtAtt() {
        return ptAtt;
    }

    public void setPtAtt(int ptAtt) {
        this.ptAtt = ptAtt;
    }
    
}
