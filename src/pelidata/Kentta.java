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
    public Kentta(int kentanKoko) {
        if(kentanKoko>3) {
            this.kentanKoko=kentanKoko; 
        }
        else {
            this.kentanKoko=3;
        }
        this.miinaKentta=new Ruutu[this.kentanKoko][this.kentanKoko];
        
        this.miinojenLukumaara=(kentanKoko*kentanKoko)/3;
        
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
