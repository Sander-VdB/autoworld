/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author vdab
 */
public class Boekentas implements Laadbaar, Serializable {

    private static final long serialVersionUID = 1L;

    private Volume laadVolume;
    private String kleur;

    public Boekentas(String kleur, Volume laadVolume) {
        this.setLaadvolume(laadVolume);
        this.setKleur(kleur);
    }

    public String getKleur() {
        return kleur;
    }

    @Override
    public Volume getLaadvolume() {
        return this.laadVolume;
    }

    public void setKleur(String kleur) {
        if (kleur == null) {
            throw new IllegalArgumentException("geen kleur opgegeven");
        } else {
            this.kleur = kleur;
        }
    }

    @Override
    public void setLaadvolume(Volume volume) {
        if (volume == null) {
            throw new IllegalArgumentException("geen volume opgegeven");
        } else {
            this.laadVolume = volume;
        }
    }

    @Override
    public String toString() {
        return "boekentas " + this.getKleur() + " "+this.getLaadvolume();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Boekentas) {
            Boekentas boekentasObj = (Boekentas)obj;
            boolean laadvolumeGelijk = this.getLaadvolume().equals(boekentasObj.getLaadvolume());
            boolean kleurGelijk = this.getKleur().equals(boekentasObj.getKleur());
            boolean gelijk = (laadvolumeGelijk && kleurGelijk)?true:false;
            return gelijk;
        } else {
            return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public int hashCode() {
        return (this.getKleur()+this.getLaadvolume()).hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
