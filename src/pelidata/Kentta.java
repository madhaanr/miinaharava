package pelidata;

/* @author mhaanran */
public class Kentta {

    private int rivi;
    private int sarake;
    private int kentanKoko;
    private int[][] miinaKentta;
    
    public Kentta(int kentanKoko) {
    
        if(kentanKoko>3) {
            this.kentanKoko=kentanKoko; 
        }
        else {
            this.kentanKoko=3;
        }
        this.miinaKentta=new int[this.kentanKoko][this.kentanKoko];
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
    

    public int[][] getMiinaKentta() {
        return miinaKentta;
    }
    public void setMiinaKentta(int[][] miinaKentta) {
        this.miinaKentta = miinaKentta;
    }

    @Override
    public String toString() {
        return "kentanKoko: "+kentanKoko;
    }
    
}
