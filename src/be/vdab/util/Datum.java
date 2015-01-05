/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author vdab
 */
public class Datum implements Comparable<Datum>,Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int dag;
    private int maand;
    private static final int[] DAGEN_PER_MAAND = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int jaar;

    private void validator(int dag, int maand, int jaar) throws DatumException{
        if (!(maand >= 1 && maand <= 12 &&
               jaar >=1583 && jaar <=4099 &&
               dag>=1 && dag<= (DAGEN_PER_MAAND[maand] +(isSchrikkeljaar(jaar) ? 1 : 0 ) )))
        {
            throw new DatumException();
        }
    }
//    private void setDag(int dag) throws DatumException {
//        if (isSchrikkeljaar(this.getJaar())) {
//            if (this.getMaand() == 2) {
//                if (dag > 29) {
//                    throw new DatumException("Dag moet tussen 1 en 29 zijn !!");
//                }
//            }
//        } else {
//            if (dag < 1 || dag > DAGEN_PER_MAAND[this.getMaand()]) {
//                throw new DatumException(String.format("Dag moet tussen 1 en %d zijn !!", DAGEN_PER_MAAND[this.getMaand()]));
//            }
//        }
//        this.dag = dag;
//    }
//
//    private void setJaar(int jaar) {
//        if (jaar < 1583 || jaar > 4099) {
//            throw new DatumException("verkeerde jaar");
//        } else {
//            this.jaar = jaar;
//        }
//    }
//
//    private void setMaand(int maand)  {
//        if (maand < 1 || maand > 12) {
//            throw new DatumException("verkeerde maand");
//        } else {
//            this.maand = maand;
//        }
//    }

    public int getDag() {
        return dag;
    }

    public int getJaar() {
        return jaar;
    }

    public int getMaand() {
        return maand;
    }

//    public Datum() {
//        //TODO default values
//        this.setDag(1);
//        this.setMaand(1);
//        this.setJaar(1583);
//    }

    public Datum(int dag, int maand, int jaar) {
        validator(dag, maand, jaar);
        //this.setJaar(jaar);
        //this.setMaand(maand);
        //this.setDag(dag);
        this.dag=dag;
        this.maand= maand;
        this.jaar=jaar;

    }

    private boolean isSchrikkeljaar(int jaar) {
        return (jaar % 4 == 0 && jaar % 100 != 0) || (jaar % 400 == 0) ;
    }

    @Override
    public String toString() {
//        String dag;
//        String maand;
//        if (this.getDag() < 10) {
//            dag = "0" + this.getDag();
//        } else {
//            dag = "" + this.getDag();
//        }
//        if (this.getMaand() < 10) {
//            maand = "0" + this.getMaand();
//        } else {
//            maand = "" + this.getMaand();
//        }
//        return dag + "/" + maand + "/" + this.getJaar();
        return String.format("%02d/%02d/%04d",dag,maand,jaar);
    }

    @Override
    public final boolean equals(Object obj) {
//        if (this == obj) //vergelijken van geheugen adressen van de objecten
//        {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        Datum other = (Datum) obj; //object casten
//        if (dag != other.dag) {
//            return false;
//        }
//        if (maand != other.maand) {
//            return false;
//        }
//        if (jaar != other.jaar) {
//            return false;
//        }
//        return true;
        return obj instanceof Datum &&
                ((Datum)obj).dag==dag &&
                ((Datum)obj).maand==maand &&
                ((Datum)obj).jaar==jaar;
    }

    @Override
    public int hashCode() {
        //TODO test of correct
        return toInt();
    }
    
    private int toInt(){
        return jaar*10000+maand*100+dag;
    }

    @Override
    public int compareTo(Datum o) {
//        if (o.getJaar() > this.getJaar()) {
//            //jaar van deze datum is kleiner dan jaar van opgegeven datum:
//            return -1;
//        } else if (o.getJaar() < this.getJaar()) {
//            return 1;
//        } else {
//            if (o.getMaand() > this.getMaand()) {
//                return -1;
//            } else if (o.getMaand() < this.getMaand()) {
//                return 1;
//            } else {
//                if (o.getDag() > this.getDag()) {
//                    return -1;
//                } else if (o.getDag() < this.getDag()) {
//                    return 1;
//                } else {
//                    //jaar, maand en dag gelijk:
//                    return 0;
//                }
//            }
        return toInt()-o.toInt();
    }

}
