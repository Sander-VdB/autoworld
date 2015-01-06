/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;

/**
 *
 * @author vdab
 */
public class Volume implements Comparable<Volume>,Serializable{
    private static final long serialVersionUID = 1L;
    
    private int hoogte;
    private int breedte;
    private int diepte;
    private Maat maat;

    public int getBreedte() {
        return breedte;
    }

    public int getDiepte() {
        return diepte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public Maat getMaat() {
        return maat;
    }

    public long getVolume(){
        return this.getBreedte()*this.getDiepte()*this.getHoogte();
    }
    
    public Volume(int hoogte, int breedte, int diepte, Maat maat){
        this.hoogte = hoogte;
        this.breedte = breedte;
        this.diepte = diepte;
        this.maat = maat;
        if(this.getVolume()<0){
            throw new VolumeException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Volume){
            Volume volumeObj = (Volume)obj;
            return (this.compareTo(volumeObj)==0 && this.getMaat().equals(volumeObj.getMaat()));
        }else{
            return super.equals(obj);
        }
    }

    @Override
    public int hashCode() {
        return (this.getVolume()+this.getMaat().toString()).hashCode();
    }

    @Override
    public int compareTo(Volume o) {
        //beter gebruik te maken van nieuwe waarden in enum!
        int maatThis = (this.getMaat()==Maat.centimeter)?1:(this.getMaat()==Maat.decimeter?1000:1000000);
        int maatO = (o.getMaat()==Maat.centimeter)?1:(o.getMaat()==Maat.decimeter?1000:1000000);;
        
        return ((Long)(this.getVolume()*maatThis)).compareTo(o.getVolume()*maatO);
    }

    @Override
    public String toString() {
        return this.getHoogte()+"(h)x"+this.getBreedte()+"(b)x"+this.getDiepte()+"(d) "+this.getMaat().toString();
    }

    
    
    
    
}
