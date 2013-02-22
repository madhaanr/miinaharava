package ohjelmalogiikka;

import pelidata.Kentta;

/* @author mhaanran */
/**
 * PeliLogiikka luokassa on pelin varsinainen toimintalogiikka.
 * 
 */
public class PeliLogiikka {

    private Kentta kentta;
    private int kentanKoko;
   
    /**
     * Luokan normaali konstruktori. 
     * @param kentanKoko 
     */
    public PeliLogiikka(int kentanKoko) {
        this.kentanKoko=kentanKoko;
        kentta = new Kentta(this.kentanKoko);
        kentta.luoKentta();     
    }
    
    /**
     * Konstruktori jossa miinojen lukumäärä voidaan asettaa itse. 
     * Automaattinen miinojen arvonta poistettu testausta varten.
     * Käytössä ainoastaan testeissä.
     * @param kentanKoko
     * @param miinojenLKM 
     */
    public PeliLogiikka(int kentanKoko, int miinojenLKM) {
        this.kentanKoko=kentanKoko;
        kentta = new Kentta(this.kentanKoko, miinojenLKM);   
    }

    public Kentta getKentta() {
        return kentta;
    }

    public int getKentanKoko() {
        return kentanKoko;
    }
    /**
     * Metodi tulostaa miinakentän tekstikäyttöliittymälle.
     * 
     */    
    public void tulostaKentta() {
        for (int i = 0; i < kentta.getKentanKoko(); ++i) {
            for (int j = 0; j < kentta.getKentanKoko(); ++j) {
                if (kentta.getMiinaKentta()[i][j].isAuki() == false) {
                    System.out.print("|"+i+" : "+j+ "|");
                } else {
                    System.out.print("|  "+kentta.getMiinaKentta()[i][j].getMiinaLahiRuudussa()+"  |");
                }
            }
            System.out.println("");
        }
    }
    /**
     * Metodi onkoMiina tarkistaa onko pelaajan valitsemissa koordinaateissa sijaitse-
     * vassa peliruudussa miina. Tekstikäyttöliittymään liittyvää koodia kommentoitu pois.
     * @param koordinaattiX 
     * @param koordinaattiY
     * @return Palauttaa false jos ruudussa ei ole miinaa ja true jos ruudussa on miina.
     */
    public boolean onkoMiina(int koordinaattiX, int koordinaattiY) {
        //tekstiliittymän juttuja kommentoitu pois.
//        if (kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].isAuki() == true) {
////            System.out.println("Ruutu on jo auki! Anna uudet koordinaatit.");
//            return false;
//        }
//        if (kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].isMiina() == true) {
////            System.out.println("Osuit miinaan! Peli Ohi!");
//            kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].setAuki(true);
//            return true;
//        } 
//        else {
//            System.out.println("Ei osunut");   
           
            avaaMiinaKenttaa(koordinaattiX,koordinaattiY);
            kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].setAuki(true);        
            int laskuri=0;
            for(int i=0;i<kentanKoko;++i) {
                for(int j=0;j<kentanKoko;++j) {
                    if(kentta.getMiinaKentta()[i][j].isAuki()) {
                        ++laskuri;
                    }
                }
            }
            kentta.setAvoimiaRuutuja(laskuri);
            return false;
//        }
    }

/**
 * Metodi miinojaLahella käy läpi pelikentän joka ruudun ja jos jossain 
 * ruudussa on miina niin sen ruudun miinojalahella arvoksi asetetaan 9. 
 * ja naapuri ruutujen miinojalahella muuttujaa kasvatetaan yhdellä.
 */
    public void miinojaLahella() {
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                if(kentta.getMiinaKentta()[i][j].isMiina()) {
                    kentta.getMiinaKentta()[i][j].setMiinaLahiRuudussa(9);
                    if(i-1>=0&&j-1>=0) {
                        kentta.getMiinaKentta()[i-1][j-1].setMiinaLahiRuudussa(1);
                    }
                    if(i-1>=0) {
                        kentta.getMiinaKentta()[i-1][j].setMiinaLahiRuudussa(1);
                    }
                    if(i-1>=0&&j+1<kentanKoko) {
                        kentta.getMiinaKentta()[i-1][j+1].setMiinaLahiRuudussa(1);
                    }
                    if(j-1>=0) {
                        kentta.getMiinaKentta()[i][j-1].setMiinaLahiRuudussa(1);
                    }
                    if(j+1<kentanKoko) {
                        kentta.getMiinaKentta()[i][j+1].setMiinaLahiRuudussa(1);
                    }
                    if(i+1<kentanKoko&&j-1>=0) {
                        kentta.getMiinaKentta()[i+1][j-1].setMiinaLahiRuudussa(1);
                    }
                    if(i+1<kentanKoko) {
                        kentta.getMiinaKentta()[i+1][j].setMiinaLahiRuudussa(1);
                    }
                    if(i+1<kentanKoko&&j+1<kentanKoko) {
                        kentta.getMiinaKentta()[i+1][j+1].setMiinaLahiRuudussa(1);
                    }              
                }
            }
        }
    }
    
/**
 * Rekursiivinen metodi joka avaa lisää pelikenttää näkyville jos 
 * klikatun ruudun naapurimiinojen lukumäärä on 0.
 * palauttaa arvon 0.
 * @param koordinaattiX 
 * @param koordinaattiY 
 */
    public void avaaMiinaKenttaa(int koordinaattiX, int koordinaattiY) {
        
        if(koordinaattiX<0 || koordinaattiY<0 || koordinaattiX>=kentanKoko || koordinaattiY>=kentanKoko) {
            return;
        }
        if(kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].isAuki()) {
            return;
        } 
        kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].setAuki(true);         
        if(kentta.getMiinaKentta()[koordinaattiX][koordinaattiY].getMiinaLahiRuudussa()!=0) {
            return;
        }                 
        for(int i=-1;i<2;++i) {
            for(int j=-1;j<2;++j) {
                avaaMiinaKenttaa((koordinaattiX+i),(koordinaattiY+j));
            }
        }
    }  
}
