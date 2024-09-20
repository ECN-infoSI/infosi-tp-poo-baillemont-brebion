/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author morga
 */
public class PotionSoin extends Objet {
    
    private int ptSoin;
    
    public PotionSoin(){
        this.ptSoin = 10;
    }
    
    public PotionSoin(int pointsSoin){
        this.ptSoin = pointsSoin;
    }
    
    public PotionSoin(PotionSoin p){
        this.ptSoin = p.getPtSoin();
    }

    public int getPtSoin() {
        return ptSoin;
    }

    public void setPtSoin(int ptSoin) {
        this.ptSoin = ptSoin;
    }
    
}
