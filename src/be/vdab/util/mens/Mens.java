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
import org.apache.commons.lang3.StringUtils;

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
        return rijbewijzen.toArray(new Rijbewijs[rijbewijzen.size()]);
    }
    
//    private Set<Rijbewijs> getRijbewijsSet() {
//        return this.rijbewijzen;
//    }

    public Mens(String naam, Rijbewijs... rijbewijzen) {
        this.setNaam(naam);
        this.setRijbewijzen(rijbewijzen);
    }

    @Override
    public int compareTo(Mens o) {
        return this.getNaam().compareTo(o.getNaam());
    }

    @Override
    public final boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        } else if (obj instanceof Mens) {
//            Mens mensObj = (Mens) obj;
//            
//            boolean naamGelijk = this.getNaam().equals(mensObj.getNaam());
//            
//            boolean rijbewijzenGelijk = true;
//            if (this.rijbewijzen.size() != mensObj.rijbewijzen.size()) {
//                rijbewijzenGelijk = false;
//            } else {
//                for (Rijbewijs rijbewijs : this.rijbewijzen) {
//                    if (!mensObj.rijbewijzen.contains(rijbewijs)) {
//                        rijbewijzenGelijk = false;
//                        break;
//                    }
//                }
//            }
//
//            return naamGelijk && rijbewijzenGelijk;
//        } else {
//            return this.equals(obj);
//        }
        if(obj instanceof Mens){
            Mens m = (Mens)obj;
            return m.naam.equals(this.naam) && m.rijbewijzen.equals(this.rijbewijzen);
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        return (this.getNaam()+this.rijbewijzen).hashCode();
    }

    //"Anita"
    //"Andree(A)"
    //"Ammelie(B, B+E, C, C+E)"
    @Override
    public String toString() {
        StringBuilder rs = new StringBuilder();
        rs.append(naam);
        if(this.rijbewijzen.size()>0){
//            rs.append("(");
//            for(Rijbewijs rijbewijs : this.rijbewijzen){
//                rs.append(rijbewijs+", ");
//            }
//            rs.delete(rs.length()-2,rs.length());
//            rs.append(")");
            rs.append("(")
              .append(StringUtils.join(rijbewijzen, ", "))
              .append(")");
        }
        return rs.toString();
    }

    
}
