/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjelmalogiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void miinojaLahellaTest() {
        miinaKentta.miinojaLahella();
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                    //tbd 
            }
        }
    }
    @Test
    public void onkoMiinaTest() {
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
    public void josOsuiNollaanAvaaPelikenttaaAlustettuKentta() {
        int nollienLkm=0;
        miinaKentta.miinojaLahella();
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                if(miinaKentta.getKentta().getMiinaKentta()[i][j].getNaapuriRuutujenMiinojenLukumaara()==0) {
                    nollienLkm++;
                }
            }
        }
        assertTrue(nollienLkm>=0&&nollienLkm<kentanKoko*kentanKoko);
        System.out.println(nollienLkm);
    }
    @Test
    public void josOsuiNollaanAvaaPelikenttaaEiAlustettuKentta() {
    int nollienLkm=0;
    for(int i=0;i<kentanKoko;++i) {
        for(int j=0;j<kentanKoko;++j) {
            if(miinaKentta.getKentta().getMiinaKentta()[i][j].getNaapuriRuutujenMiinojenLukumaara()==0) {
                nollienLkm++;
            }
        }
    }
    assertTrue(nollienLkm==kentanKoko*kentanKoko);
    System.out.println(nollienLkm);
    }
}
