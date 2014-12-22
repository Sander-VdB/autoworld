/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author vdab
 */
public class Mens implements Comparable<Mens>,Serializable {

    private static final long serialVersionUID = 1L; 
    
    private String naam;
    private SortedSet<Rijbewijs> rijbewijzen;

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setRijbewijzen(Rijbewijs[] rijbewijzen) {
        this.rijbewijzen = new TreeSet<Rijbewijs>(Arrays.asList(rijbewijzen));
    }

    public String getNaam() {
        return naam;
    }

    public Rijbewijs[] getRijbewijs() {
        return getRijbewijsSet().toArray(new Rijbewijs[getRijbewijsSet().size()]);
    }
    
    private Set<Rijbewijs> getRijbewijsSet() {
        return this.rijbewijzen;
    }

    public Mens(String naam, Rijbewijs... rijbewijzen) {
        this.setNaam(naam);
        this.setRijbewijzen(rijbewijzen);
    }

    @Override
    public int compareTo(Mens o) {
        return this.getNaam().compareTo(o.getNaam());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Mens) {
            Mens mensObj = (Mens) obj;
            
            boolean naamGelijk = this.getNaam().equals(mensObj.getNaam());
            
            boolean rijbewijzenGelijk = true;
            if (this.getRijbewijsSet().size() != mensObj.getRijbewijsSet().size()) {
                rijbewijzenGelijk = false;
            } else {
                for (Rijbewijs rijbewijs : this.getRijbewijsSet()) {
                    if (!mensObj.getRijbewijsSet().contains(rijbewijs)) {
                        rijbewijzenGelijk = false;
                        break;
                    }
                }
            }

            return naamGelijk && rijbewijzenGelijk;
        } else {
            return this.equals(obj);
        }

    }

    @Override
    public int hashCode() {
        return (this.getNaam()+this.getRijbewijsSet()).hashCode();
    }

    @Override
    public String toString() {
        StringBuilder rijbewijsString = new StringBuilder();
        if(this.getRijbewijsSet().size()>0){
            rijbewijsString.append("(");
            for(Rijbewijs rijbewijs : this.getRijbewijsSet()){
                rijbewijsString.append(rijbewijs+", ");
            }
            rijbewijsString.delete(rijbewijsString.length()-2,rijbewijsString.length());
            rijbewijsString.append(")");
        }
        return this.getNaam()+rijbewijsString;
    }

    
}
