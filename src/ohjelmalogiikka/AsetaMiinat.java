package ohjelmalogiikka;

import pelidata.Kentta;

/* @author mhaanran */
public class AsetaMiinat {
    
    private Kentta kentta;
    private Arvonta arvonta;
    private int[] koordinaatit;
    private int kentanKoko=5;
    
            
    public AsetaMiinat() {
        arvonta = new Arvonta(kentanKoko);    
        koordinaatit = new int[2];
        kentta = new Kentta(kentanKoko);
    }
    public int[] arvoMiinat() {
        koordinaatit[0]=arvonta.miinojenArpoja();
        koordinaatit[1]=arvonta.miinojenArpoja();
//        System.out.println("Mitä arvoja koordinaatit taulukossa: "+koordinaatit[0]+":"+koordinaatit[1]);
        return koordinaatit;
    }
    public void asetaMiina() {
        kentta.setRivi(koordinaatit[0]);
        kentta.setSarake(koordinaatit[1]);
        
    }  
//    @Override
//    public String toString() {
//        return koordinaatit[0]+":"+koordinaatit[1];
//    }

    public int getKentanKoko() {
        return kentanKoko;
    }
         
}
