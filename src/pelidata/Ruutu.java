package pelidata;

/* @author mhaanran */
/**
 * Ruutu luokka määrittelee mikä on pelikentän kunkin yksittäisen ruudun tila.
 * 
 */
public class Ruutu {
    private boolean miina;
    private boolean auki;
    private int miinaLahiRuudussa;
    private boolean merkattu;
   
/**
 * Konstruktori luo Ruudun ja asettaa sen metodien alkuarvot.
 * @param miina alkuarvo on false. Jos ruutuun arvotaan miina niin vaihdetaan trueksi.
 * @param auki Alkuarvo on false. Jos ruutu avataan niin vaihdetaan trueksi.
 * @param miinaLahiRuudussa Kertoo kuinka monessa ruudun naapuri ruudussa on miina
 * @param merkattu Pelaaja on merkannut ruudussa mahdolliseksi miinan paikaksi.
 * ruudussa on miinoja. Maksimi on 8 ja yhdeksän kertoo että tässä ruudussa on miina.
 */
    public Ruutu() {
        this.miina=false;
        this.auki=false;
        this.miinaLahiRuudussa=0;
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

    public int getMiinaLahiRuudussa() {
        return miinaLahiRuudussa;
    }

    public void setMiinaLahiRuudussa(int miinaLahiRuudussa) {
        this.miinaLahiRuudussa += miinaLahiRuudussa;
    }

    public boolean isAuki() {
        return auki;
    }

    public void setAuki(boolean auki) {
        this.auki = auki;
    }
   
    public String toString() {
        return ":"+isAuki()+" : "+miinaLahiRuudussa+":";
    }
}
