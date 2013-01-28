/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pelidataTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pelidata.Ruutu;

/**
 *
 * @author mhaanran
 */
public class RuutuTests {
    
    private Ruutu ruutu;
    
    public RuutuTests() {
        
        ruutu=new Ruutu();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void konstruktoriLuoRuudunOikeinisAuki() {
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
