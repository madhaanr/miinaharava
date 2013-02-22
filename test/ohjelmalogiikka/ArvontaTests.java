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
    private int miinoja;
    
    public ArvontaTests() {
    }
    
    @Before
    public void setUp() {
        miinoja=0;
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
    public void eiArvotaMiinaaKenttaTyhja() {
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                if(miinaKentta[i][j].isMiina()) {
                    ++miinoja;
                }
            }
        }
        assertEquals(0,miinoja);
    }
    @Test
    public void yksiMiinaArvotaan() {
        miinaKentta=arvonta.miinojenArpoja(miinaKentta);
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                if(miinaKentta[i][j].isMiina()) {
                    ++miinoja;
                }
            }
        }
        assertEquals(1,miinoja);
    }
    @Test
    public void useitaMiinojaArvotaan() {
        miinaKentta=arvonta.miinojenArpoja(miinaKentta);
        miinaKentta=arvonta.miinojenArpoja(miinaKentta);
        miinaKentta=arvonta.miinojenArpoja(miinaKentta);
        miinaKentta=arvonta.miinojenArpoja(miinaKentta);
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                if(miinaKentta[i][j].isMiina()) {
                    ++miinoja;
                }
            }
        }
        assertEquals(4,miinoja);
    }
    @Test
    public void kenttaArvotaanTayteen() {
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                 miinaKentta=arvonta.miinojenArpoja(miinaKentta);      
            }
        }  
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                if(miinaKentta[i][j].isMiina()) {
                    ++miinoja;
                }
            }
        }
        assertEquals(100,miinoja);
    }
}
