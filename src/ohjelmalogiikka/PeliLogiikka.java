package ohjelmalogiikka;

import pelidata.Kentta;

/* @author mhaanran */
public class PeliLogiikka {

    private Kentta kentta;
    private int kentanKoko;
    
    public PeliLogiikka(int kentanKoko) {
        this.kentanKoko=kentanKoko;
        kentta = new Kentta(this.kentanKoko);
        kentta.luoKentta();
    }
    
//    public void luoKentta() {
//        for (int i = 0; i < kentta.getMiinojenLukumaara(); ++i) {
//            kentta.setMiinaKentta(miinaKentta);
//        }
//    }

//    public void luoKentta(int miinojenLukumaara, Kentta kentta) {
//        kentta.setMiinojenLukumaara(miinojenLukumaara);
//        for (int i = 0; i < miinojenLukumaara; ++i) {
//            kentta.setMiinaKentta() = arvonta.miinojenArpoja(kentta.miinaKentta);
//        }
//    }

    //    public void tulostaKentta() {
    //        for(int i=0;i<kentanKoko;++i) {
    //            for(int j=0;j<kentanKoko;++j) {
    //                System.out.print(miinaKentta[i][j]);
    //            }
    //            System.out.println("");
    //        }
    //    }
    public void tulostaKentta() {
        for (int i = 0; i < kentta.getKentanKoko(); ++i) {
            for (int j = 0; j < kentta.getKentanKoko(); ++j) {
                if (kentta.getMiinaKentta()[i][j].isAuki() == false) {
                    System.out.print(kentta.getMiinaKentta()[i][j]);
                } else {
                    System.out.print(kentta.getMiinaKentta()[i][j]);
                }
            }
            System.out.println("");
        }
    }

    public boolean onkoMiina(int koordinaattiX, int koordinaattiY) {
        if (kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].isAuki() == true) {
            System.out.println("Ruutu on jo auki! Anna uudet koordinaatit.");
            return false;
        }
        if (kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].isMiina() == true) {
            System.out.println("Osuit miinaan! Peli Ohi!");
            kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].setAuki(true);
            return true;
        } else {
            System.out.println("Ei osunut");
            kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].setAuki(true);
            return false;
        }
    }

}
