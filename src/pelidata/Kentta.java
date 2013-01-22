package pelidata;

/* @author mhaanran */
public class Kentta {

    private int rivi;
    private int sarake;
    private int kentanKoko;
    private int[][] miinaKentta;
    
    public Kentta(int kentanKoko) {
    
        this.kentanKoko=kentanKoko; 
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
