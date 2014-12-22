/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.MensException;
import be.vdab.util.mens.Rijbewijs;
import java.awt.Color;

/**
 *
 * @author vdab
 */
public class Pickup extends Personenwagen implements Laadbaar{

    private Volume volume;
    
    @Override
    public Volume getLaadvolume() {
        return this.volume;
    }

    @Override
    public void setLaadvolume(Volume volume) {
        this.volume = volume;
    }
    
    public Pickup(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Color kleur, Volume volume ,Mens bestuurder, Mens... passagiers) throws IllegalArgumentException {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, kleur, bestuurder, passagiers);
        this.setLaadvolume(volume);
    }

    @Override
    public String toString() {
        return super.toString()+" "+this.getLaadvolume(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
