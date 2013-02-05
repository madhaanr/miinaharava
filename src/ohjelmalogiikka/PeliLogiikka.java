package ohjelmalogiikka;

import pelidata.Kentta;

/* @author mhaanran */
/**
 * PeliLogiikka luokassa on pelin varsinainen logiikka.
 * 
 */
public class PeliLogiikka {

    private Kentta kentta;
    private int kentanKoko;
    
    public PeliLogiikka(int kentanKoko) {
        this.kentanKoko=kentanKoko;
        kentta = new Kentta(this.kentanKoko);
        kentta.luoKentta();
    }

    public Kentta getKentta() {
        return kentta;
    }

    public int getKentanKoko() {
        return kentanKoko;
    }
/**
 * Metodi tulostaa miinakentan.
 */    
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
/**
 * Metodi onkoMiina tarkistaa onko pelaajan valitsemissa koordinaateissa sijaitse-
 * vassa peliruudussa miina.
 * @param koordinaattiX Ruudun x koordinaatti eli vaakasuunnan koordinaatti.
 * @param koordinaattiY Ruudun y koordinaatti eli pystysuunnan koordinaatti.
 * @return Palauttaa false jos ruudussa ei ole miinaa ja true jos ruudussa on miina.
 */
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
//            kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].setAuki(true);
            josOsuiNollaanAvaaPelikenttaa(koordinaattiX,koordinaattiY);
            return false;
        }
    }
/**
 * Metodi miinojaLahella käy läpi pelikentän joka ruudun ja jos jossain 
 * ruudussa on miina niin sen ruudun miinojalahella arvoksi asetetaan 9. ja 
 * naapuri ruutujen miinojalahella muuttujaa kasvatetaan yhdellä.
 */
    public void miinojaLahella() {
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                if(kentta.getMiinaKentta()[i][j].isMiina()) {
                    kentta.getMiinaKentta()[i][j].setNaapuriRuutujenMiinojenLukumaara(9);
                    if(i-1>=0&&j-1>=0) {
                        kentta.getMiinaKentta()[i-1][j-1].setNaapuriRuutujenMiinojenLukumaara(1);
                    }
                    if(i-1>=0) {
                        kentta.getMiinaKentta()[i-1][j].setNaapuriRuutujenMiinojenLukumaara(1);
                    }
                    if(i-1>=0&&j+1<kentanKoko) {
                        kentta.getMiinaKentta()[i-1][j+1].setNaapuriRuutujenMiinojenLukumaara(1);
                    }
                    if(j-1>=0) {
                        kentta.getMiinaKentta()[i][j-1].setNaapuriRuutujenMiinojenLukumaara(1);
                    }
                    if(j+1<kentanKoko) {
                        kentta.getMiinaKentta()[i][j+1].setNaapuriRuutujenMiinojenLukumaara(1);
                    }
                    if(i+1<kentanKoko&&j-1>=0) {
                        kentta.getMiinaKentta()[i+1][j-1].setNaapuriRuutujenMiinojenLukumaara(1);
                    }
                    if(i+1<kentanKoko) {
                        kentta.getMiinaKentta()[i+1][j].setNaapuriRuutujenMiinojenLukumaara(1);
                    }
                    if(i+1<kentanKoko&&j+1<kentanKoko) {
                        kentta.getMiinaKentta()[i+1][j+1].setNaapuriRuutujenMiinojenLukumaara(1);
                    }
                }
            }
        }
    }
/**
 * Metodi avaa lisää pelikenttää näkyville jos metodi getNaapuriRuutujenMiinojenLukumaara 
 * palauttaa arvon 0.
 * @param koordinaattiX vaakakoordinaatti.
 * @param koordinaattiY pystykoordinaatti.
 */
    public void josOsuiNollaanAvaaPelikenttaa(int koordinaattiX, int koordinaattiY) {
        if(koordinaattiX<0 || koordinaattiY<0 || koordinaattiX>kentanKoko || koordinaattiY>kentanKoko) {
            return;
        }
        if(kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].getNaapuriRuutujenMiinojenLukumaara()!=0) {
            return;
        }
        if(kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].isAuki()) {
            return;
        } 
        kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].setAuki(true);
        josOsuiNollaanAvaaPelikenttaa(koordinaattiX-1, koordinaattiY);
        josOsuiNollaanAvaaPelikenttaa(koordinaattiX+1, koordinaattiY);
        josOsuiNollaanAvaaPelikenttaa(koordinaattiX, koordinaattiY-1);
        josOsuiNollaanAvaaPelikenttaa(koordinaattiX, koordinaattiY+1);
         
            
//        for(int i=koordinaattiX-1;i<koordinaattiX+1;++i) {
//            for(int j=koordinaattiY-1;j<koordinaattiY+1;++j) {
//                josOsuiNollaanAvaaPelikenttaa(koordinaattiX+i, koordinaattiY+j);
//            }
//        }
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

}
