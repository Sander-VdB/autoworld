/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen.div;

import java.util.List;

/**
 *
 * @author vdab
 */
public enum DIV {
    //TODO nummerplaat genereren
    INSTANCE;
    
    
    private int cijfer;

    private DIV() {
        this.cijfer = 1;
    }
    
    public Nummerplaat getNummerplaat() {
//        String cijferreeks = "";
//        if(cijfer<10){
//            cijferreeks = "00"+cijfer;
//        }
//        else if(cijfer<100){
//            cijferreeks = "0"+cijfer;
//        } else{
//            cijferreeks = ""+cijfer;
//        }
        if(cijfer<999){
            this.cijfer++;
        }else{
            this.cijfer = 1;
        }
        
        return new Nummerplaat(String.format("AAA%03d",cijfer));
    }
    
}
