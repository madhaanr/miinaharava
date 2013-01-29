package pelidata;

/* @author mhaanran */
public class Ruutu {
    private boolean miina;
    private boolean auki;
    private int naapuriRuutujenMiinojenLukumaara;
   

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
        this.naapuriRuutujenMiinojenLukumaara += naapuriRuutujenMiinojenLukumaara;
    }

    public boolean isAuki() {
        return auki;
    }

    public void setAuki(boolean auki) {
        this.auki = auki;
    }
    public String toString() {
        return ""+isAuki();
    }
//    public String toString() {
//        if(isMiina()==false) {
//            return ""+naapuriRuutujenMiinojenLukumaara;
//        }
//        else {
//            return ""+9;
//        }
//    }
}
