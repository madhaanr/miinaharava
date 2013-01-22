/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjelmalogiikkaTests;

import ohjelmalogiikka.Arvonta;
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
public class ArvontaTests {
    
    private Arvonta arvonta;
    private int min=0;
    private int max=15;
    
    public ArvontaTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        arvonta = new Arvonta(max);
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void arvoLukuValillaNollaJaMax() {
        int arvottuArvo=arvonta.miinojenArpoja();
        assertTrue(min <= arvottuArvo && arvottuArvo <=max);
     }
}
