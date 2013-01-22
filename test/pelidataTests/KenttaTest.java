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
    
    private Kentta miinaKentta;
    
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
       miinaKentta = new Kentta(10);
    }
    
    @After
    public void tearDown() {
    }
//     TODO add test methods here.
//     The methods must be annotated with annotation @Test. For example:
//    
     @Test
     public void konstruktoriAsettaaKentanKoonOikein() {
     assertEquals("kentanKoko: 10",miinaKentta.toString());
     }  
     @Test
     public void konstruktoriEiAsetaLiianPientaKenttaa() {
     miinaKentta = new Kentta(2);
     assertEquals("kentanKoko: 3",miinaKentta.toString());
     }  
}
