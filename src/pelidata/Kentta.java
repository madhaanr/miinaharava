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
    
    public Kentta(int kentanKoko, int miinojenLukumaara) {
    
        if(kentanKoko>3) {
            this.kentanKoko=kentanKoko; 
        }
        else {
            this.kentanKoko=3;
        }
        this.miinaKentta=new Ruutu[this.kentanKoko][this.kentanKoko];
        arvonta=new Arvonta(kentanKoko);  
    }
    public Kentta(int kentanKoko) {
        if(kentanKoko>3) {
            this.kentanKoko=kentanKoko; 
        }
        else {
            this.kentanKoko=3;
        }
        this.miinaKentta=new Ruutu[this.kentanKoko][this.kentanKoko];
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
            miinaKentta=arvonta.miinojenArpoja();
        }
    }

    @Override
    public String toString() {
        return ""+miinaKentta;
    }
    
}
