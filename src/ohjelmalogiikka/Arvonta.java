package ohjelmalogiikka;

import java.util.Random;

/* @author mhaanran */
public class Arvonta {

    private Random random = new Random();
    private int kentanKoko;
    private int miinanKoordinaatti;
    
    public Arvonta(int kentanKoko) {
        this.kentanKoko=kentanKoko;      
    }
    
    public int miinojenArpoja() {
        miinanKoordinaatti = random.nextInt(kentanKoko);
        return miinanKoordinaatti; 
    }
}
