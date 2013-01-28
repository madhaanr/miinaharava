package kayttoliittyma;

import java.util.Scanner;
import ohjelmalogiikka.PeliLogiikka;

/* @author mhaanran */
public class MiinaHarava {
    private static Scanner lukija = new Scanner(System.in);
    
    public static void main(String args[]) {
        System.out.println("Tervetuloa miinaharava peliin!");
        System.out.print("Kuinka suuren miinakentän haluat?: ");
        int kentanKoko=lukija.nextInt();
        PeliLogiikka miinaKentta=new PeliLogiikka(kentanKoko);
        miinaKentta.miinojaLahella();
        int koordinaattiX;
        int koordinaattiY;
        do {
            miinaKentta.tulostaKentta();
            System.out.print("Anna miinan koordinaatti X: ");
            koordinaattiX = lukija.nextInt();
            System.out.print("Anna miinan koordinaatti Y: ");
            koordinaattiY = lukija.nextInt();
            
        } while (miinaKentta.onkoMiina(koordinaattiX, koordinaattiY)==false);
        miinaKentta.tulostaKentta();
        System.out.println("Lopputilanne!");
    }
}
