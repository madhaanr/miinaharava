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
import pelidata.Ruutu;

/**
 *
 * @author mhaanran
 */
public class ArvontaTests {
    
    private Arvonta arvonta;
    private int kentanKoko=10;
    private Ruutu[][] arvottuArvo;
    private int min=0;
    private int max=10;
    
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
        arvottuArvo = new Ruutu[kentanKoko][kentanKoko];
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//     @Test
//     public void arvoLukuValillaNollaJaMax() {
//        arvottuArvo=arvonta.miinojenArpoja();
//         System.out.println(": "+arvottuArvo);
//        assertTrue(min <= arvottuArvo && arvottuArvo <=max);
//     }
}
