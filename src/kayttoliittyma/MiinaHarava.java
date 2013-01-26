package kayttoliittyma;

import java.util.Scanner;
import pelidata.Kentta;

/* @author mhaanran */
public class MiinaHarava {
    private static Scanner lukija = new Scanner(System.in);
    
    public static void main(String args[]) {
        System.out.println("Tervetuloa miinaharava peliin!");
        System.out.print("Kuinka suuren miinakentän haluat?: ");
        int kentanKoko=lukija.nextInt();
        Kentta miinaKentta=new Kentta(kentanKoko);
        miinaKentta.luoKentta();
        int koordinaattiX=0;
        int koordinaattiY=0;
        do {
            miinaKentta.tulostaKentta();
            System.out.println("Anna miinan koordinaatti X:");
            koordinaattiX = lukija.nextInt();
            System.out.println("Anna miinan koordinaatti Y:");
            koordinaattiY = lukija.nextInt();
//        miinaKentta.onkoMiina(koordinaattiX, koordinaattiY);       
        } while(miinaKentta.onkoMiina(koordinaattiX, koordinaattiY)==false);
    }
}
