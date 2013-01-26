package pelidata;

/* @author mhaanran */
public class Ruutu {
    private boolean miina;
    private int naapuriRuutujenMiinojenLukumaara;
    private boolean auki;

    public Ruutu() {
        this.miina=false;
        this.auki=false;
        this.naapuriRuutujenMiinojenLukumaara=0;
    }
     
    public boolean isMiina() {
        return miina;
    }

    public void setMiina(boolean miina) {
        this.miina = miina;
    }

    public int getNaapuriRuutujenMiinojenLukumaara() {
        return naapuriRuutujenMiinojenLukumaara;
    }

    public void setNaapuriRuutujenMiinojenLukumaara(int naapuriRuutujenMiinojenLukumaara) {
        this.naapuriRuutujenMiinojenLukumaara = naapuriRuutujenMiinojenLukumaara;
    }

    public boolean isAuki() {
        return auki;
    }

    public void setAuki(boolean auki) {
        this.auki = auki;
    }
    public String toString() {
        return ""+auki;
    }
}
