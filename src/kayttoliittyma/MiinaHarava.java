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
        miinaKentta.tulostaKentta();
    }
}
