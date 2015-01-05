/*
 * @Autor Frank
 * Dit is een oefening.
 */
package be.vdab.voertuigen.div;

import java.io.Serializable;

/**
 *
 * @author frank.roelants
 */
public class Nummerplaat implements Comparable<Nummerplaat>,Serializable{

    private static final long serialVersionUID = 1L; 
    private String plaat;
    
    Nummerplaat(String plaat) {
        this.plaat = plaat;
    }

    public String getPlaat() {
        return plaat;
    }

    @Override
    public String toString() {
        return plaat; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Nummerplaat) {
            return this.getPlaat().equals(((Nummerplaat) obj).getPlaat());
        } else {
            return this.getPlaat().equals(obj);
        }
    }

    @Override
    public int hashCode() {
        return this.getPlaat().hashCode();
    }

    @Override
    public int compareTo(Nummerplaat o) {
        return this.getPlaat().compareTo(o.getPlaat());
    }

    

}
