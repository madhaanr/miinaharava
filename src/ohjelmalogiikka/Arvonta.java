package ohjelmalogiikka;

import java.util.Random;
import pelidata.Kentta;
import pelidata.Ruutu;

/* @author mhaanran */
public class Arvonta {

    private Random random = new Random();
    private int kentanKoko;
    private int miinanKoordinaattiX;
    private int miinanKoordinaattiY;
    
    public Arvonta(int kentanKoko) {
        this.kentanKoko=kentanKoko;  
    }
    
    public Ruutu[][] miinojenArpoja(Ruutu[][] miinaKentta) {
        miinanKoordinaattiX = random.nextInt(kentanKoko);
        miinanKoordinaattiY = random.nextInt(kentanKoko);
        miinaKentta[miinanKoordinaattiX][miinanKoordinaattiY].setMiina(true);
        return miinaKentta; 
    }
}
