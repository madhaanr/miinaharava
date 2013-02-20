package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ohjelmalogiikka.PeliLogiikka;

/* @author mhaanran */
public class Kuuntelija implements ActionListener{

    private int koordinaattiX, koordinaattiY;
    private PeliLogiikka miinaKentta;
    
    public Kuuntelija(PeliLogiikka miinaKentta, int koordinaattiX, int koordinaattiY) {
        this.koordinaattiX=koordinaattiX;
        this.koordinaattiY=koordinaattiY;
        this.miinaKentta=miinaKentta;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(koordinaattiX+" : "+koordinaattiY);
        miinaKentta.onkoMiina(koordinaattiX, koordinaattiY); 
        miinaKentta.tulostaKenttaGUI();
    }
}
