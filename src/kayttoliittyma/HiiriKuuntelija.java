package kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import ohjelmalogiikka.PeliLogiikka;

/* @author mhaanran */
public class HiiriKuuntelija implements MouseListener {

    private int koordinaattiX, koordinaattiY;
    private PeliLogiikka miinaKentta;
    private GraafinenKayttoLiittyma gui;
    private Timer timer;
    
    public HiiriKuuntelija(GraafinenKayttoLiittyma gui, PeliLogiikka miinaKentta, int koordinaattiX, int koordinaattiY,Timer timer) {
        this.koordinaattiX=koordinaattiX;
        this.koordinaattiY=koordinaattiY;
        this.miinaKentta=miinaKentta;
        this.gui = gui;
        this.timer=timer;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        JButton tamaNappi = (JButton) e.getSource(); 
        tamaNappi.setMargin(new Insets(0,0,0,0));
        tamaNappi.setFont(new Font("Times New Roman",Font.PLAIN, 20));
        if(SwingUtilities.isRightMouseButton(e)) {
            if(miinaKentta.getKentta().getMiinaKentta()[koordinaattiX][koordinaattiY].isMerkattu()==false) {
                miinaKentta.getKentta().getMiinaKentta()[koordinaattiX][koordinaattiY].setMerkattu(true);
                tamaNappi.setBackground(Color.BLACK);
                tamaNappi.setForeground(Color.WHITE);
                tamaNappi.setText("M");
                int miinojenLukumaara = miinaKentta.getKentta().getMiinojenLukumaara();
                miinojenLukumaara-=1;
                miinaKentta.getKentta().setMiinojenLukumaara(miinojenLukumaara);          
            }
            else {
                miinaKentta.getKentta().getMiinaKentta()[koordinaattiX][koordinaattiY].setMerkattu(false);
                tamaNappi.setBackground(Color.green);
                tamaNappi.setText("");
                tamaNappi.setForeground(Color.BLACK);
                int miinojenLukumaara = miinaKentta.getKentta().getMiinojenLukumaara();
                miinojenLukumaara+=1;
                miinaKentta.getKentta().setMiinojenLukumaara(miinojenLukumaara);
            }
        }
        if(SwingUtilities.isLeftMouseButton(e)) {
            System.out.println(koordinaattiX+" : "+koordinaattiY);     
            //jos osuu miinaan niin pelin pitää loppua
            int naapuriRuutujenMiinojenLukumaara = miinaKentta.getKentta().getMiinaKentta()[koordinaattiX][koordinaattiY].getNaapuriRuutujenMiinojenLukumaara();
            if(naapuriRuutujenMiinojenLukumaara>8) {
                tamaNappi.setBackground(Color.red);
                tamaNappi.setForeground(Color.black);
                tamaNappi.setText("¤"); 
                timer.stop();            
            }
            else {
                tamaNappi.setText(""+miinaKentta.getKentta().getMiinaKentta()[koordinaattiX][koordinaattiY].getNaapuriRuutujenMiinojenLukumaara());
            }
        }      
        gui.repaint();      
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
