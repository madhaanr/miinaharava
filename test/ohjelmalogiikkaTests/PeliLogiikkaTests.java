/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjelmalogiikkaTests;

import ohjelmalogiikka.PeliLogiikka;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pelidata.Kentta;

/**
 *
 * @author mhaanran
 */
public class PeliLogiikkaTests {
    
    private PeliLogiikka miinaKentta; 
    private int kentanKoko=10;
    
    public PeliLogiikkaTests() {
        miinaKentta = new PeliLogiikka(kentanKoko);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
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
        assertTrue(nollienLkm>=0&&nollienLkm<100);
        System.out.println(nollienLkm);
    }
     public void josOsuiNollaanAvaaPelikenttaaEiAlustettuKentta() {
        int nollienLkm=0;
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                if(miinaKentta.getKentta().getMiinaKentta()[i][j].getNaapuriRuutujenMiinojenLukumaara()==0) {
                    nollienLkm++;
                }
            }
        }
        assertTrue(nollienLkm==100);
        System.out.println(nollienLkm);
    }
}
