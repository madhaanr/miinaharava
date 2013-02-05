package pelidata;

import ohjelmalogiikka.Arvonta;

/* @author mhaanran */
/**
 * Kentta luokka luo pelikentan ja käyttää Arvonta luokkaa miinojen arpomiseen 
 * kentälle.
 * 
 */
public class Kentta {

    private int kentanKoko;
    private int miinojenLukumaara;
    private Ruutu[][] miinaKentta;   
    private Arvonta arvonta;
    
//    public Kentta() {
//
//        arvonta=new Arvonta(kentanKoko); 
//        for(int i=0;i<kentanKoko;++i) {
//            for(int j=0;j<kentanKoko;++j) {
//                miinaKentta[i][j]=new Ruutu();
//            }
//        }
//    }
    public Kentta(int kentanKoko) {
        if(kentanKoko>3) {
            this.kentanKoko=kentanKoko; 
        }
        else {
            this.kentanKoko=3;
        }
        this.miinaKentta=new Ruutu[this.kentanKoko][this.kentanKoko];
        
        this.miinojenLukumaara=(kentanKoko*kentanKoko)/5;
        
        arvonta=new Arvonta(kentanKoko); 
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                miinaKentta[i][j]=new Ruutu();
            }
        }
    }
        
    public Kentta(int kentanKoko, int miinojenLukumaara) {
        if(kentanKoko>3) {
            this.kentanKoko=kentanKoko; 
        }
        else {
            this.kentanKoko=3;
        }
        this.miinaKentta=new Ruutu[this.kentanKoko][this.kentanKoko];
        
        arvonta=new Arvonta(kentanKoko);
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                miinaKentta[i][j]=new Ruutu();
            }
        }
    }

    public int getKentanKoko() {
        return kentanKoko;
    }

    public void setKentanKoko(int kentanKoko) {
        this.kentanKoko = kentanKoko;
    }

    public int getMiinojenLukumaara() {
        return miinojenLukumaara;
    }

    public void setMiinojenLukumaara(int miinojenLukumaara) {
        this.miinojenLukumaara = miinojenLukumaara;
    }

    public Ruutu[][] getMiinaKentta() {
        return miinaKentta;
    }

    public void setMiinaKentta(Ruutu[][] miinaKentta) {
        this.miinaKentta = miinaKentta;
    }

    public Arvonta getArvonta() {
        return arvonta;
    }

    public void setArvonta(Arvonta arvonta) {
        this.arvonta = arvonta;
    }
/**
 * Luodaan miinakentta ja arvotaan siihen haluttu määrä miinoja.
 */
    public void luoKentta() {
        for(int i=0;i<miinojenLukumaara;++i) {
            miinaKentta=arvonta.miinojenArpoja(miinaKentta);
        }
    }
    
    @Override
    public String toString() {
        return "kentanKoko: "+getKentanKoko();
    }
    
}
