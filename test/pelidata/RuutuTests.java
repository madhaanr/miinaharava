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
public class RuutuTests {
    
    private Ruutu ruutu;
    
    @Before
    public void setUp() {
        ruutu=new Ruutu();
    }
    
    @Test
    public void konstruktoriLuoRuudunOikein() {
        assertFalse(ruutu.isAuki());
    }
    @Test
    public void konstruktoriLuoRuudunOikeinMiina() {
        assertFalse(ruutu.isMiina());
    }
    @Test
    public void konstruktoriLuoRuudunOikeinnaapuriMiinojenLKM() {
        assertTrue(ruutu.getMiinaLahiRuudussa()==0);
    }
    @Test
    public void konstruktoriLuoRuudunOikeinisMerkattu() {
        assertFalse(ruutu.isMerkattu());
    }
    @Test
    public void asetaRuutuAuki() {
        ruutu.setAuki(true);
        assertTrue(ruutu.isAuki());
    }
    @Test
    public void isMiinaTrue() {
        ruutu.setMiina(true);
        assertTrue(ruutu.isMiina());
    }
    @Test
    public void naapuriMiinojenLKMkuusi() {
        ruutu.setMiinaLahiRuudussa(6);
        assertEquals(6,ruutu.getMiinaLahiRuudussa());
    }
    @Test
    public void naapuriMiinojenLKMyhdeksan() {
        ruutu.setMiinaLahiRuudussa(9);
        assertEquals(9,ruutu.getMiinaLahiRuudussa());
    }
            
}
