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

/**
 *
 * @author mhaanran
 */
public class PeliLogiikkaTests {
    
    private PeliLogiikka peliLogiikka;
    
    public PeliLogiikkaTests() {
        
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
     public void konstruktoriLuoPeliKentanJonkaKokoOn10() {
         peliLogiikka = new PeliLogiikka(10);
         assertEquals(10, peliLogiikka.getKentanKoko());
     }
}
