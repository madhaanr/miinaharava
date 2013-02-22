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
    private int miinojenLKM;
    private int avoimiaRuutuja;
    private Ruutu[][] miinaKentta;   
    private Arvonta arvonta;
    
    /**
     * Konstruktori tarkistaa että kentanKoko on ainakin 3 ja luo miinakentän.
     * @param kentanKoko
     */
    
    public Kentta(int kentanKoko) {
        if(kentanKoko>3) {
            this.kentanKoko=kentanKoko; 
        }
        else {
            this.kentanKoko=3;
        }
        this.miinaKentta=new Ruutu[this.kentanKoko][this.kentanKoko];  
        this.miinojenLKM=(kentanKoko*kentanKoko)/5;   
        this.arvonta=new Arvonta(kentanKoko); 
        
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                miinaKentta[i][j]=new Ruutu();
            }
        }
        this.avoimiaRuutuja=0;       
    }
    
    /** 
     * Testeissä käytettävä konstruktori jolle voi parametrina asettaa miinojen lukumäärän. 
     * @param kentanKoko
     * @param miinojenLKM 
     */
    
    public Kentta(int kentanKoko, int miinojenLukumaara) {
        if(kentanKoko>3) {
            this.kentanKoko=kentanKoko; 
        }
        else {
            this.kentanKoko=3;
        }
        this.miinaKentta=new Ruutu[this.kentanKoko][this.kentanKoko];
        this.miinojenLKM=miinojenLukumaara;   
        this.arvonta=new Arvonta(kentanKoko);
        
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {
                miinaKentta[i][j]=new Ruutu();
            }
        }
        this.avoimiaRuutuja=0;
    }
    
    /**
     * Metodi luo miinakentän ja arpoo siihen halutun määrän miinoja.
     */
    public void luoKentta() {
        for(int i=0;i<miinojenLKM;++i) {
            miinaKentta=arvonta.miinojenArpoja(miinaKentta);
        }
    }
      
    public int getAvoimiaRuutuja() {
        return avoimiaRuutuja;
    }

    public void setAvoimiaRuutuja(int avoimiaRuutuja) {
        this.avoimiaRuutuja = avoimiaRuutuja;
    }
        
    public int getKentanKoko() {
        return kentanKoko;
    }

    public void setKentanKoko(int kentanKoko) {
        this.kentanKoko = kentanKoko;
    }

    public int getMiinojenLKM() {
        return miinojenLKM;
    }

    public void setMiinojenLKM(int miinojenLKM) {
        this.miinojenLKM = miinojenLKM;
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
    
    @Override
    public String toString() {
        return "kentanKoko: "+getKentanKoko();
    }
    
}
