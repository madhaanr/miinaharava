package pelidata;

import ohjelmalogiikka.Arvonta;

/* @author mhaanran */
public class Kentta {

    private int rivi;
    private int sarake;
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
    public Kentta(int kentanKoko) {
        if(kentanKoko>3) {
            this.kentanKoko=kentanKoko; 
        }
        else {
            this.kentanKoko=3;
        }
        this.miinaKentta=new Ruutu[this.kentanKoko][this.kentanKoko];
        this.miinojenLukumaara=kentanKoko*5;
        arvonta=new Arvonta(kentanKoko); 
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                miinaKentta[i][j]=new Ruutu();
            }
        }
    }
    public int getRivi() {
        return rivi;
    }

    public void setRivi(int rivi) {
        this.rivi = rivi;
    }

    public int getSarake() {
        return sarake;
    }

    public void setSarake(int sarake) {
        this.sarake = sarake;
    }

    public int getKentanKoko() {
        return kentanKoko;
    }

    public void setKentanKoko(int kentanKoko) {
        this.kentanKoko = kentanKoko;
    }
    
    public void luoKentta(int miinojenLukumaara) {
        this.miinojenLukumaara=miinojenLukumaara;
        for(int i=0;i<miinojenLukumaara;++i) {
            miinaKentta=arvonta.miinojenArpoja(miinaKentta);
        }
    }
    public void luoKentta() {
        for(int i=0;i<miinojenLukumaara;++i) {
            miinaKentta=arvonta.miinojenArpoja(miinaKentta);
        }
    }
    public void tulostaKentta() {
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                System.out.print(miinaKentta[i][j]);
            }
            System.out.println("");
        }
    }

    @Override
    public String toString() {
        return "kentanKoko: "+getKentanKoko();
    }
    
}
