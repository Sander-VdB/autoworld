/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

/**
 *
 * @author vdab
 */
public enum Maat {
    centimeter (1),
    decimeter (10),
    meter(100);
    
    private int verhouding;
    
    private Maat(int verhouding){
        this.verhouding=verhouding;
    }
    
    public int get3DVerhouding(){
        return verhouding*verhouding*verhouding;
    }
}
