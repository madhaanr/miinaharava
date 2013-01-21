package ohjelmalogiikka;

/* @author mhaanran */
public class AsetaMiinat {
    
    private Arvonta arvonta;
    private int[] koordinaatit;
    private int kentanKoko=5;
            
    public AsetaMiinat() {
        arvonta = new Arvonta(kentanKoko);
        koordinaatit = new int[2];
    }
    public int[] arvoMiinat() {
        koordinaatit[0]=arvonta.miinojenArpoja();
        koordinaatit[1]=arvonta.miinojenArpoja();
//        System.out.println("Mitä arvoja koordinaatit taulukossa: "+koordinaatit[0]+":"+koordinaatit[1]);
        return koordinaatit;
    } 
    
//    @Override
//    public String toString() {
//        return koordinaatit[0]+":"+koordinaatit[1];
//    }

    public int getKentanKoko() {
        return kentanKoko;
    }
         
}
