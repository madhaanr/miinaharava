package ohjelmalogiikka;

import java.util.Random;
import pelidata.Ruutu;

/* @author mhaanran */
/**
 * Arvonta luokassa on metodi miinojen arpomiseen pelikentälle.
 * 
 */
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
        System.out.println( miinanKoordinaattiX+" : "+miinanKoordinaattiY+" ");
        if(miinaKentta[miinanKoordinaattiX][miinanKoordinaattiY].isMiina()==true) {
            miinojenArpoja(miinaKentta);
        }
        else {
            miinaKentta[miinanKoordinaattiX][miinanKoordinaattiY].setMiina(true); 
        }
        return miinaKentta; 
    }
}
