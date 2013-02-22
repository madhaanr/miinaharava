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
    private PeliLogiikka miinaKentta2;
    private PeliLogiikka miinaKentta3;
    private PeliLogiikka miinaKentta4;
    private int kentanKoko=10;
    private int kentanKoko2=3;
    
    
    public PeliLogiikkaTests() {    
    }
    
    @Before
    public void setUp() {
        miinaKentta = new PeliLogiikka(kentanKoko);
        miinaKentta2 = new PeliLogiikka(kentanKoko2,1);
        miinaKentta3 = new PeliLogiikka(kentanKoko2,5);
        miinaKentta4 = new PeliLogiikka(kentanKoko,5);
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
    public void miinojaLahellaYksi() {
        miinaKentta2.getKentta().getMiinaKentta()[0][0].setMiina(true);
        miinaKentta2.miinojaLahella();
        int miinaLahiRuudussa = miinaKentta2.getKentta().getMiinaKentta()[0][1].getMiinaLahiRuudussa();
        assertEquals(1,miinaLahiRuudussa);
    }
    @Test
    public void miinojaKentallaMuttaEiLahella() {
        miinaKentta4.getKentta().getMiinaKentta()[3][0].setMiina(true);
        miinaKentta4.getKentta().getMiinaKentta()[0][5].setMiina(true);
        miinaKentta4.getKentta().getMiinaKentta()[1][1].setMiina(true);
        miinaKentta4.getKentta().getMiinaKentta()[2][1].setMiina(true);
        miinaKentta4.getKentta().getMiinaKentta()[4][9].setMiina(true);
        miinaKentta4.getKentta().getMiinaKentta()[2][7].setMiina(true);
        miinaKentta.miinojaLahella();
        int miinaLahiRuudussa = miinaKentta4.getKentta().getMiinaKentta()[5][1].getMiinaLahiRuudussa();
        assertEquals(0,miinaLahiRuudussa);
    }
    @Test
    public void miinojaLahellaViisi() {
        miinaKentta3.getKentta().getMiinaKentta()[0][0].setMiina(true);
        miinaKentta3.getKentta().getMiinaKentta()[0][1].setMiina(true);
        miinaKentta3.getKentta().getMiinaKentta()[0][2].setMiina(true);
        miinaKentta3.getKentta().getMiinaKentta()[2][0].setMiina(true);
        miinaKentta3.getKentta().getMiinaKentta()[2][1].setMiina(true);
        miinaKentta3.miinojaLahella();
        int miinaLahiRuudussa = miinaKentta3.getKentta().getMiinaKentta()[1][1].getMiinaLahiRuudussa();
        assertEquals(5,miinaLahiRuudussa);
    }
    @Test
    public void miinojaLahellaKahdeksan() {
        miinaKentta3.getKentta().getMiinaKentta()[0][0].setMiina(true);
        miinaKentta3.getKentta().getMiinaKentta()[0][1].setMiina(true);
        miinaKentta3.getKentta().getMiinaKentta()[0][2].setMiina(true);
        miinaKentta3.getKentta().getMiinaKentta()[1][0].setMiina(true);
        miinaKentta3.getKentta().getMiinaKentta()[1][2].setMiina(true);
        miinaKentta3.getKentta().getMiinaKentta()[2][0].setMiina(true);
        miinaKentta3.getKentta().getMiinaKentta()[2][1].setMiina(true);
        miinaKentta3.getKentta().getMiinaKentta()[2][2].setMiina(true);
        miinaKentta3.miinojaLahella();
        int miinaLahiRuudussa = miinaKentta3.getKentta().getMiinaKentta()[1][1].getMiinaLahiRuudussa();
        assertEquals(8,miinaLahiRuudussa);
    }
    @Test
    public void miinojaLahellaNolliaPaljon() {
        int nollienLkm=0;
        miinaKentta4.getKentta().getMiinaKentta()[3][1].setMiina(true);
        miinaKentta4.getKentta().getMiinaKentta()[8][8].setMiina(true);
        miinaKentta4.getKentta().getMiinaKentta()[5][5].setMiina(true);
        miinaKentta4.miinojaLahella();
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                if(miinaKentta4.getKentta().getMiinaKentta()[i][j].getMiinaLahiRuudussa()==0) {
                    nollienLkm++;
                    
                }
            }
        }
        assertTrue(nollienLkm==73);
    }
    @Test
    public void miinojaLahellaKunLisataanJaPoistetaan() {
        int nollienLkm=0;
        miinaKentta4.getKentta().getMiinaKentta()[3][0].setMiina(true);
        miinaKentta4.getKentta().getMiinaKentta()[3][0].setMiina(false);
        miinaKentta4.getKentta().getMiinaKentta()[1][1].setMiina(true);
        miinaKentta4.getKentta().getMiinaKentta()[1][1].setMiina(false);
        miinaKentta4.getKentta().getMiinaKentta()[2][7].setMiina(true);
        miinaKentta4.miinojaLahella();
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                if(miinaKentta4.getKentta().getMiinaKentta()[i][j].getMiinaLahiRuudussa()==0) {
                    ++nollienLkm;
                }
            }
        }
        assertTrue(nollienLkm==91);
    }
    @Test
    public void miinojaLahellaNolla() {
        int miinaLahiRuudussa = miinaKentta3.getKentta().getMiinaKentta()[1][1].getMiinaLahiRuudussa();
        assertEquals(0,miinaLahiRuudussa);
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
    @Test
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
