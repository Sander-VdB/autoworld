/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

/**
 *
 * @author vdab
 */
public enum Rijbewijs {
    A("A"),
    B("B"),
    BE("B+E"),
    C("C"),
    CE("C+E"),
    D("D"),
    DE("D+E");
    
    private final String rijbewijs;

    private Rijbewijs(String rijbewijs) {
        this.rijbewijs = rijbewijs;
    }
    
    
    
    @Override    
    public String toString() {
        return rijbewijs;
    }
}
