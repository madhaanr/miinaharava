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
   
/**
 * Konstruktori luo Ruudun ja asettaa sen metodien alkuarvot.
 * @param miina alkuarvo on false. Jos ruutuun arvotaan miina niin vaihdetaan trueksi.
 * @param auki Alkuarvo on false. Jos ruutu avataan niin vaihdetaan trueksi.
 * @param naapuriRuutujenMiinojenLukumaara Kertoo kuinka monessa ruudun naapuri
 * ruudussa on miinoja. Maksimi on 8 ja yhdeksän kertoo että tässä ruudussa on miina.
 */
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
