package kayttoliittyma;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import ohjelmalogiikka.PeliLogiikka;

/* @author mhaanran */
public class MiinakenttaPanel extends JPanel {
    
    private int kentanKoko=10;
    private PeliLogiikka miinaKentta;
    JPanel peliKentta;
    
    public MiinakenttaPanel() {
        peliKentta = new JPanel(new BorderLayout());
    }
    public void asetaPeliKentta() {
        peliKentta.setBorder(null);
    }
    
    public void aloitaPeli() {    
        miinaKentta=new PeliLogiikka(kentanKoko);
        miinaKentta.miinojaLahella(); 
        
        miinaKentta.tulostaKentta();
    }
}
