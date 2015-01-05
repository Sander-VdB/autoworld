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
import be.vdab.voertuigen.div.DIV;
import be.vdab.voertuigen.div.Nummerplaat;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.collections.CollectionUtils;

/**
 *
 * @author vdab
 */
public abstract class Voertuig implements Comparable, Serializable {

    private static final long serialVersionUID = 1L;

    private final Nummerplaat nummerplaat;
    private String merk;
    private Datum datumEersteIngebruikname;
    private int aankoopprijs;
    private int zitplaatsen;
    private final TreeSet<Mens> mensen = new TreeSet<>();
    private Mens bestuurder;
    //private final Rijbewijs[] toegestaneRijbewijzen = {Rijbewijs.B, Rijbewijs.BE};

    public void setAankoopprijs(int aankoopprijs) {
        this.aankoopprijs = aankoopprijs;
    }

    public void setDatumEersteIngebruikname(Datum datumEersteIngebruikname) {
        this.datumEersteIngebruikname = datumEersteIngebruikname;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setZitplaatsen(int zitplaatsen) {
        if(zitplaatsen<1){
            throw new IllegalArgumentException("Ongeldig aantal zitplaatsen");
        }
        //controleren op aantal inzittenden> zitplaatsen zou exception moeten geven, ontbreekt in testen
        this.zitplaatsen = zitplaatsen;
    }

    public void addIngezetene(Mens mens) {
        if (mensen.contains(mens)) {

        } else if (this.getZitplaatsen() == this.getIngezetenen().size()) {
            throw new MensException("Geen zitplaatsen meer vrij");
        } else if (this.getIngezetenen().size() == 0) {
            this.setBestuurder(mens);
            this.mensen.add(mens);
        } else {
            this.mensen.add(mens);
        }
    }

    public void setBestuurder(Mens mens) {
        if (!CollectionUtils.containsAny(Arrays.asList(mens.getRijbewijs()), Arrays.asList(this.getToegestaneRijbewijzen()))) {
            throw new MensException("Geen geldig rijbewijs");
        } else if (mensen.contains(mens)) {
            this.bestuurder = mens;
        } else if (this.getZitplaatsen() == this.getIngezetenen().size()) {
            throw new MensException("Geen zitplaatsen meer vrij voor nieuwe bestuurder");
        } else {
            this.mensen.add(mens);
            this.bestuurder = mens;
        }
    }

    public int getAankoopprijs() {
        return aankoopprijs;
    }

    public Datum getDatumEersteIngebruikname() {
        return datumEersteIngebruikname;
    }

    public String getMerk() {
        return merk;
    }

    public Nummerplaat getNummerplaat() {
        return nummerplaat;
    }

    public int getZitplaatsen() {
        return zitplaatsen;
    }

    protected SortedSet<Mens> getIngezetenen() {
        //zou in de testen moeten zitten
        return Collections.unmodifiableSortedSet(mensen);
    }

    public Mens getBestuurder() {
        return this.bestuurder;
    }

    public TreeSet<Mens> getIngezeteneExclusiefBestuurder() {
        TreeSet<Mens> lijst = new TreeSet<Mens>(this.getIngezetenen());
        lijst.remove(this.getBestuurder());
        return lijst;
    }

    public static MerkComparator getMerkComparator() {
        return new MerkComparator();
    }

    public static AankoopprijsComparator getAankoopprijsComparator() {
        return new AankoopprijsComparator();
    }

    public Voertuig(String merk, Datum datumEersteIngebruikname, int aankoopprijs, int zitplaatsen, Mens bestuurder, Mens... passagiers) throws IllegalArgumentException {
        if (bestuurder == null) {
            throw new IllegalArgumentException("Geen bestuurder");
        }

        this.nummerplaat = DIV.INSTANCE.getNummerplaat();
        this.setMerk(merk);
        this.setDatumEersteIngebruikname(datumEersteIngebruikname);
        this.setAankoopprijs(aankoopprijs);
        this.setZitplaatsen(zitplaatsen);

        this.setBestuurder(bestuurder);
        for (Mens mens : passagiers) {
            this.addIngezetene(mens);
        }

    }

    public boolean isIngezetene(Mens mens) {
        return this.getIngezetenen().contains(mens);
    }

    @Override
    public String toString() {

        String text = this.getNummerplaat() + " " + this.getMerk() + " " + this.getDatumEersteIngebruikname() + " " + this.aankoopprijs
                + " " + this.getBestuurder();
        if (this.getIngezeteneExclusiefBestuurder().isEmpty()) {
            return text;
        } else {
            return text
                    + " " + this.getIngezeteneExclusiefBestuurder();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Voertuig) {
            Voertuig voertuigObj = (Voertuig) obj;
            return (voertuigObj.getNummerplaat().equals(this.getNummerplaat()));
        } else {
            return this.equals(obj);
        }
    }

    @Override
    public int hashCode() {
        return this.getNummerplaat().hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Voertuig) {
            Voertuig voertuigObj = (Voertuig) o;
            return  this.getNummerplaat().compareTo(voertuigObj.getNummerplaat());
        } else {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    public int compareTo(int aankoopprijs) {
        return this.getAankoopprijs() - aankoopprijs;
    }

    protected abstract Rijbewijs[] getToegestaneRijbewijzen();
    
    protected abstract int getMAX_ZITPLAATSEN();

    public static class MerkComparator implements Comparator<Voertuig>, Serializable{
        private static final long serialVersionUID = 1L;
        @Override
        public int compare(Voertuig v1, Voertuig v2) {
            return v1.getMerk().compareTo(v2.getMerk());
        }
    }

    public static class AankoopprijsComparator implements Comparator<Voertuig>, Serializable{
        private static final long serialVersionUID = 1L;
        @Override
        public int compare(Voertuig v1, Voertuig v2) {
            return v1.getAankoopprijs() - v2.getAankoopprijs();
        }
    }
}
