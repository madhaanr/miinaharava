package kayttoliittyma;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import ohjelmalogiikka.PeliLogiikka;

/* @author mhaanran */
public class HiiriKuuntelija implements MouseListener {

    private int koordinaattiX, koordinaattiY;
    private PeliLogiikka miinaKentta;
    
    public HiiriKuuntelija(PeliLogiikka miinaKentta, int koordinaattiX, int koordinaattiY) {
        this.koordinaattiX=koordinaattiX;
        this.koordinaattiY=koordinaattiY;
        this.miinaKentta=miinaKentta;
    }
     
    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)) {
            System.out.println("oikea nappia painettu");
        }
        if(SwingUtilities.isLeftMouseButton(e)) {
            System.out.println(koordinaattiX+" : "+koordinaattiY);
            miinaKentta.onkoMiina(koordinaattiX, koordinaattiY); 
            miinaKentta.tulostaKenttaGUI();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
