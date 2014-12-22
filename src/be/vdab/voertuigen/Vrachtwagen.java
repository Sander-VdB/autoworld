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
import be.vdab.voertuigen.Voertuig;

/**
 *
 * @author vdab
 */
public class Vrachtwagen extends Voertuig implements Laadbaar {

    private final int maxAantalZitplaatsen = 3;
    private Volume laadVolume;
    private int maximaalToegelatenMassa;
    private int aantalAssen;

    public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    @Override
    protected int getMAX_ZITPLAATSEN() {
        return this.maxAantalZitplaatsen;
    }

    @Override
    protected Rijbewijs[] getToegestaneRijbewijzen() {
        return new Rijbewijs[]{Rijbewijs.C, Rijbewijs.CE};
    }

    @Override
    public Volume getLaadvolume() {
        return this.laadVolume;
    }

    @Override
    public void setLaadvolume(Volume volume) {
        this.laadVolume = volume;
    }

    public void setMaximaalToegelatenMassa(int maximaalToegelatenMassa) {
        this.maximaalToegelatenMassa = maximaalToegelatenMassa;
    }

    public void setAantalAssen(int aantalAssen) {
        this.aantalAssen = aantalAssen;
    }

    public Vrachtwagen(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Volume laadVolume, int maximaalToegelatenMassa, int aantalAssen, Mens bestuurder, Mens... passagiers) throws IllegalArgumentException {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, bestuurder, passagiers);
        
        if(passagiers.length+1>this.getMAX_ZITPLAATSEN()){
            throw new IllegalArgumentException("Onvoldoende zitplaatsen");
        } 
        
        this.laadVolume = laadVolume;
        this.maximaalToegelatenMassa = maximaalToegelatenMassa;
        this.aantalAssen = aantalAssen;
    }

    @Override
    public String toString() {
        return super.toString()+" assen:"+this.getAantalAssen()+", maximaal toegelaten massa:"+this.getMaximaalToegelatenMassa()+", laadvolume:"+this.getLaadvolume(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
