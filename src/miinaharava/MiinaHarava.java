package miinaharava;

import javax.swing.SwingUtilities;
import kayttoliittyma.GraafinenKayttoLiittyma;
import kayttoliittyma.TekstiKayttoLiittyma;

/* @author mhaanran */
/**
 * Miinaharava luokasta peli käynnistetään.
 * 
 */
public class MiinaHarava {
//    private static Scanner lukija = new Scanner(System.in);
    
    public static void main(String args[]) {
//        Graafinen käyttöliittymä
//        GraafinenKayttoLiittyma GUI = new GraafinenKayttoLiittyma();
//        SwingUtilities.invokeLater(GUI);
        
        
        //TekstiKäyttöliittymä
        TekstiKayttoLiittyma TKL = new TekstiKayttoLiittyma();
        TKL.aloitaPeli();
    }
}
