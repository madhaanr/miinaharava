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
/**
 * Metodi arpoo miinan paikan. Jos paikassa on jo miina arvotaan uusi paikka.
 * @param miinanKoordinaattiX vaakakoordinaatti
 * @param miinanKoordinaattiY pystykoordinaatti
 * @param miinaKentta miinaKentta
 * @return palautetaan Ruutu[][] tyyppinen miinaKentta
 */
    public Ruutu[][] miinojenArpoja(Ruutu[][] miinaKentta) {
        
        miinanKoordinaattiX = random.nextInt(kentanKoko);
        miinanKoordinaattiY = random.nextInt(kentanKoko);
        
        if(miinaKentta[miinanKoordinaattiX][miinanKoordinaattiY].isMiina()==true) {
            miinojenArpoja(miinaKentta);
        }
        else {
            miinaKentta[miinanKoordinaattiX][miinanKoordinaattiY].setMiina(true); 
        }
        return miinaKentta; 
    }
}
