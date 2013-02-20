package pelidata;

/* @author mhaanran */
/**
 * Ruutu luokka määrittelee mikä on pelikentän kunkin yksittäisen ruudun tila.
 * 
 */
public class Ruutu {
    private boolean miina;
    private boolean auki;
    private int naapuriRuutujenMiinojenLukumaara;
    private boolean merkattu;
   
/**
 * Konstruktori luo Ruudun ja asettaa sen metodien alkuarvot.
 * @param miina alkuarvo on false. Jos ruutuun arvotaan miina niin vaihdetaan trueksi.
 * @param auki Alkuarvo on false. Jos ruutu avataan niin vaihdetaan trueksi.
 * @param naapuriRuutujenMiinojenLukumaara Kertoo kuinka monessa ruudun naapuri
 * @param merkattu Jos on merkattu mahdollinen miinan paikka
 * ruudussa on miinoja. Maksimi on 8 ja yhdeksän kertoo että tässä ruudussa on miina.
 */
    public Ruutu() {
        this.miina=false;
        this.auki=false;
        this.naapuriRuutujenMiinojenLukumaara=0;
        this.merkattu=false;
    }

    public boolean isMerkattu() {
        return merkattu;
    }

    public void setMerkattu(boolean merkattu) {
        this.merkattu = merkattu;
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
        return ":"+isAuki()+" : "+naapuriRuutujenMiinojenLukumaara+":";
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
