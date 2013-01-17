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
import pelidata.Kentta;

/**
 *
 * @author mhaanran
 */
public class KenttaTest {
    
    public KenttaTest() {
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
//     TODO add test methods here.
//     The methods must be annotated with annotation @Test. For example:
//    
     @Test
     public void konstruktoriAsettaaKentanKoonOikein() {
     Kentta miinaKentta = new Kentta(10,10);
     assertEquals("rivi 10 ja sarake 10",miinaKentta.toString());
     }
}
