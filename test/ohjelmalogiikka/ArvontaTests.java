/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjelmalogiikka;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
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
    
    @Before
    public void setUp() {
        kentanKoko=10;
        arvonta = new Arvonta(kentanKoko);
        miinaKentta = new Ruutu[kentanKoko][kentanKoko];
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                miinaKentta[i][j]=new Ruutu();
            }
        }
    }
    
     @Test
     public void miinaKenttallaOnYlarajaKoko() {  
         assertNotNull(miinaKentta[9][9]);
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
