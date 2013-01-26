package ohjelmalogiikka;

import java.util.Random;
import pelidata.Kentta;
import pelidata.Ruutu;

/* @author mhaanran */
public class Arvonta {

    private Random random = new Random();
    private int kentanKoko;
    private int miinanKoordinaattix;
    private int miinanKoordinaattiy;
    
    public Arvonta(int kentanKoko) {
        this.kentanKoko=kentanKoko;      
    }
    
    public Ruutu[][] miinojenArpoja() {
        Ruutu[][] ruututaulukko = new Ruutu[kentanKoko][kentanKoko];
        miinanKoordinaattix = random.nextInt(kentanKoko);
        miinanKoordinaattiy = random.nextInt(kentanKoko);
        ruututaulukko[miinanKoordinaattix][miinanKoordinaattiy].setMiina(true);
        return ruututaulukko; 
    }
}
