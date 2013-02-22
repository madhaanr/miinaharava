/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pelidata;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mhaanran
 */
public class KenttaTest {

    private Kentta miinaKentta;
    private int miinojenLKM;
    
    public KenttaTest() {
    }
    
    @Before
    public void setUp() {
        miinaKentta = new Kentta(15);
        miinojenLKM = 15;
    }
    @Test
    public void avoimiaRuutuja() {
        assertEquals(0,miinaKentta.getAvoimiaRuutuja());
    }
    @Test
    public void konstruktoriAsettaaKentanKoonOikein() {
        Kentta miinaKentta2 = new Kentta(10);
        assertEquals("kentanKoko: 10", miinaKentta2.toString());
    }
    @Test
    public void konstruktoriEiAsetaLiianPientaKenttaa() {
        Kentta miinaKentta3= new Kentta(2);
        assertEquals("kentanKoko: 3", miinaKentta3.toString());
    }
   
}
