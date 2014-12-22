/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import be.vdab.util.Datum;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Vrachtwagen;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;

/**
 *
 * @author vdab
 */
public class Main {
    public static void main(String[] args) {
        TreeSet<Voertuig> set = new TreeSet<Voertuig>();
        TreeSet<Voertuig> secondSet =  new TreeSet<Voertuig>(Voertuig.getAankoopprijsComparator());
        TreeSet<Voertuig> thirdSet =  new TreeSet<Voertuig>(Voertuig.getMerkComparator());
        
        set.add(new Personenwagen("Opel", new Datum(12, 6, 2006), 5230, 4, Color.GREEN, new Mens("Joske", Rijbewijs.A,Rijbewijs.B)));
        set.add(new Personenwagen("Peugeot", new Datum(15, 9, 2008), 8000, 6, Color.PINK, new Mens("Kulderzipken", Rijbewijs.C,Rijbewijs.B)));
        
        set.add(new Pickup("Landrover", new Datum(1,1,1991), 15000, 2, Color.blue, new Volume(150,200, 180, Maat.centimeter), new Mens("Pol",Rijbewijs.BE)));
        set.add(new Pickup("Nokia", new Datum(1,8,1998), 6000, 2, Color.GREEN, new Volume(150,1900, 180, Maat.centimeter), new Mens("Marcel",Rijbewijs.B,Rijbewijs.D)));
        
        set.add(new Vrachtwagen("Volvo", new Datum(16,8,2013), 16000, 2, new Volume(420, 230, 750, Maat.centimeter), 1500 , 2, new Mens("Frans",Rijbewijs.C),new Mens("Gerard",Rijbewijs.A)));
        set.add(new Vrachtwagen("Opel", new Datum(26,5,2006), 9800, 2, new Volume(360, 210, 620, Maat.centimeter), 1100 , 2, new Mens("Prieel",Rijbewijs.CE),new Mens("Jozef")));
        
        System.out.println(set);
        
        //volgende wordt aankoopprijs vergeleken: het laatste voertuig met eenzelfde aankoopprijs als een ander voertuig verdwijnt
        //(niet in dit voorbeeld)
        secondSet.addAll(set);
        System.out.println(secondSet.descendingSet());
        
        //volgende wordt merk vergeleken: het laatste voertuig met eenzelfde merk als een ander voertuig verdwijnt
        thirdSet.addAll(set);
        System.out.println(thirdSet);
        
        
        //Opslaan in bestand:
        String locatie =  "wagenpark.ser";
        FileOutputStream file = null;
        ObjectOutputStream obj = null;
        try {
            file = new FileOutputStream(locatie);
            obj = new ObjectOutputStream(file);
            //array wegschrijven (array elementen worden automatisch ook weggeschreven
            obj.writeObject(thirdSet);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (obj
                    != null) {
                try {
                    //outputstream sluiten
                    obj.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        //Lezen uit bestand
        FileInputStream fileinput = null;
        ObjectInputStream objinput = null;
        try {
            fileinput = new FileInputStream(locatie);
            objinput = new ObjectInputStream(fileinput);
            thirdSet= (TreeSet<Voertuig>) objinput.readObject();
            
            System.out.println(thirdSet);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            //de file sluiten
            if (objinput
                    != null) {
                try {
                    objinput.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
