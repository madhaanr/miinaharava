/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjelmalogiikka;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mhaanran
 */
public class PeliLogiikkaTests {
    
    private PeliLogiikka miinaKentta; 
    private int kentanKoko=10;
    
    public PeliLogiikkaTests() {    
    }
    
    @Before
    public void setUp() {
        miinaKentta = new PeliLogiikka(kentanKoko);
    }
       
    @Test
    public void miinojaLahella() {
        miinaKentta.miinojaLahella();
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                assertNotNull(miinaKentta.getKentta().getMiinaKentta()[i][j].getMiinaLahiRuudussa());        
            }
        }
    }
    @Test
    public void onkoMiinaJossainRuudussa() {
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                if(miinaKentta.onkoMiina(i, j)) {
                    assertTrue(true);
                    return;
                }
            }   
        }
    }
    
    @Test
    public void onkoMiinaisAukiTrue() {
         miinaKentta.getKentta().getMiinaKentta()[0][0].setAuki(true);
         assertEquals(true,miinaKentta.getKentta().getMiinaKentta()[0][0].isAuki());   
    }
     public void onkoMiinaisAukiTrueEriKoordinaatit() {
         miinaKentta.getKentta().getMiinaKentta()[kentanKoko-1][kentanKoko-1].setAuki(true);
         assertEquals(true,miinaKentta.getKentta().getMiinaKentta()[kentanKoko-1][kentanKoko-1].isAuki());   
    }
    @Test
    public void onkoMiinaisAukiFalse() {
         assertEquals(false,miinaKentta.getKentta().getMiinaKentta()[0][0].isAuki());   
    }

    @Test
    public void josOsuiNollaanAvaaPelikenttaaAlustettuKentta() {
        int nollienLkm=0;
        miinaKentta.miinojaLahella();
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                if(miinaKentta.getKentta().getMiinaKentta()[i][j].getMiinaLahiRuudussa()==0) {
                    nollienLkm++;
                }
            }
        }
        assertTrue(nollienLkm>=0&&nollienLkm<kentanKoko*kentanKoko);
    }
    @Test
    public void josOsuiNollaanAvaaPelikenttaaEiAlustettuKentta() {
        int nollienLkm=0;
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                if(miinaKentta.getKentta().getMiinaKentta()[i][j].getMiinaLahiRuudussa()==0) {
                    nollienLkm++;
                }
            }
        }
        assertTrue(nollienLkm==kentanKoko*kentanKoko);
    }
}
