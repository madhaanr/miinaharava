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
import pelidata.Kentta;
import pelidata.Ruutu;

/**
 *
 * @author mhaanran
 */
public class ArvontaTests {
    
    private int kentanKoko;  
    private Ruutu[][] miinaKentta;   
    private Arvonta arvonta;
    
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
        kentanKoko=5;
        arvonta = new Arvonta(kentanKoko);
        miinaKentta = new Ruutu[kentanKoko][kentanKoko];
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                miinaKentta[i][j]=new Ruutu();
            }
        }
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void miinaKenttallaOnYlarajaKoko() {  
         assertNotNull(miinaKentta[4][4]);
     }
     @Test
     public void miinaKenttallaOnAlaRajaKoko() {  
         assertNotNull(miinaKentta[0][0]);
     }
     @Test
     public void miinojenArpominen() {
         miinaKentta=arvonta.miinojenArpoja(miinaKentta);
         assertNotNull(miinaKentta);
     }
}
