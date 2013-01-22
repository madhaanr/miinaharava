/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjelmalogiikkaTests;

import ohjelmalogiikka.AsetaMiinat;
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
public class AsetaMiinatTests {
    
    private AsetaMiinat asetaMiinat;
    private int[] koordinaatit = new int[2];
    
    public AsetaMiinatTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {    
        asetaMiinat = new AsetaMiinat();
        
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void koordinaattinollaRajojenSisalla() {
        koordinaatit=asetaMiinat.arvoMiinat();
//        System.out.println("Testifilen koordit: "+koordinaatit[0]+":"+koordinaatit[1]);
        assertTrue(0 <= koordinaatit[0] && koordinaatit[0]<=asetaMiinat.getKentanKoko());
     }
     public void koordinaattiyksiRajojenSisalla() {
        koordinaatit=asetaMiinat.arvoMiinat();
//        System.out.println("Testifilen koordit: "+koordinaatit[0]+":"+koordinaatit[1]);
        assertTrue(0 <= koordinaatit[1] && koordinaatit[1]<=asetaMiinat.getKentanKoko());
     }
     
}
