/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pelidata;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pelidata.Ruutu;

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
        assertTrue(ruutu.isAuki()==false);
    }
    @Test
    public void konstruktoriLuoRuudunOikeinMiina() {
        assertTrue(ruutu.isMiina()==false);
    }
    @Test
    public void konstruktoriLuoRuudunOikeinnaapuriMiinojenLKM() {
        assertTrue(ruutu.getNaapuriRuutujenMiinojenLukumaara()==0);
    }
     
}
