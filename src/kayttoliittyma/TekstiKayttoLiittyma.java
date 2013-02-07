package kayttoliittyma;

import java.util.Scanner;
import ohjelmalogiikka.PeliLogiikka;

/* @author mhaanran */
public class TekstiKayttoLiittyma {
    private static Scanner lukija = new Scanner(System.in);
    PeliLogiikka miinaKentta;
    
    public void aloitaPeli() {
        System.out.println("Tervetuloa miinaharava peliin!");
        System.out.print("Kuinka suuren miinakentän haluat?: ");
        int kentanKoko=lukija.nextInt();
        miinaKentta = new PeliLogiikka(kentanKoko);
        miinaKentta.miinojaLahella();
        int koordinaattiX;
        int koordinaattiY;
        do {
            miinaKentta.tulostaKentta();
            System.out.print("Anna miinan koordinaatti korkeus: ");
            koordinaattiX = lukija.nextInt();
            System.out.print("Anna miinan koordinaatti leveys: ");
            koordinaattiY = lukija.nextInt();
            
        } while (miinaKentta.onkoMiina(koordinaattiX, koordinaattiY)==false);
        miinaKentta.tulostaKentta();
        System.out.println("Lopputilanne!");
    }
     
        
        
}
