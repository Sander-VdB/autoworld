/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.MensException;
import be.vdab.util.mens.Rijbewijs;
import java.awt.Color;

/**
 *
 * @author vdab
 */
public class Personenwagen extends Voertuig{
    private Color kleur;
    private final int maxAantalZitplaatsen = 8;

    public Color getKleur() {
        return kleur;
    }

    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }

    public Personenwagen(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Color kleur, Mens bestuurder, Mens... passagiers) throws IllegalArgumentException {
        super(merk, datumEersteIngebruikname, aankoopprijs, zitplaatsen, bestuurder, passagiers);
        
        if(zitplaatsen > this.getMAX_ZITPLAATSEN()){
            throw new IllegalArgumentException("Ongeldig aantal zitplaatsen");
        }      
        
        if(passagiers.length+1>this.getMAX_ZITPLAATSEN()){
            throw new IllegalArgumentException("Onvoldoende zitplaatsen");
        }      
        
        this.setKleur(kleur);
    }

    @Override
    protected int getMAX_ZITPLAATSEN() {
        return this.maxAantalZitplaatsen;
    }

    @Override
    protected Rijbewijs[] getToegestaneRijbewijzen() {
        //TODO check other possibilities
        return new Rijbewijs[]{Rijbewijs.B,Rijbewijs.BE};
    }

    @Override
    public String toString() {
        return super.toString()+" "+this.getZitplaatsen(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
