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

/**
 * HiiriKuuntelija luokka kuuntelee hiiren nappien painalluksia ja
 * päivittää GUIta tarpeen mukaisesti.
 * @author mhaanran
 */
public class HiiriKuuntelija implements MouseListener {

    private int koordinaattiX, koordinaattiY;
    private PeliLogiikka miinaKentta;
    private GraafinenKayttoLiittyma gui;
    private Timer timer;
    
    /**
     * Kostruktori
     * @param gui GraafinenKäyttöLiittymä.
     * @param miinaKentta Käyttöliittymässä luotu miinaKentta.
     * @param koordinaattiX
     * @param koordinaattiY
     * @param timer Pelin kestoa seuraava timer.
     */
    
    public HiiriKuuntelija(GraafinenKayttoLiittyma gui, PeliLogiikka miinaKentta, int koordinaattiX, int koordinaattiY,Timer timer) {
        this.koordinaattiX=koordinaattiX;
        this.koordinaattiY=koordinaattiY;
        this.miinaKentta=miinaKentta;
        this.gui = gui;
        this.timer=timer;
    }
    
    /**
     * Hiiren napin painallusten kuuntelija metodi. Jossa erikseen
     * käsitellään ensin hiiren oikean napin aiheuttamat toimenpiteet ja sen jälkeen
     * hiiren vasemman napin klikkausten aiheuttamat toimenpiteet sekä päivitetään 
     * GUIta tarpeen mukaisesti.
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        JButton tamaNappi = (JButton) e.getSource(); 
        tamaNappi.setMargin(new Insets(0,0,0,0));
        tamaNappi.setBorder(null);
        tamaNappi.setFont(new Font("Times New Roman",Font.PLAIN, 20));
        if(SwingUtilities.isRightMouseButton(e)) {
            if(miinaKentta.getKentta().getMiinaKentta()[koordinaattiX][koordinaattiY].isMerkattu()==false) {
                miinaKentta.getKentta().getMiinaKentta()[koordinaattiX][koordinaattiY].setMerkattu(true);
                tamaNappi.setBackground(Color.BLACK);
                tamaNappi.setForeground(Color.WHITE);
                tamaNappi.setText("M");
                int miinojenLukumaara = miinaKentta.getKentta().getMiinojenLKM();
                miinojenLukumaara-=1;
                miinaKentta.getKentta().setMiinojenLKM(miinojenLukumaara);          
            }
            else {
                miinaKentta.getKentta().getMiinaKentta()[koordinaattiX][koordinaattiY].setMerkattu(false);
                tamaNappi.setBackground(Color.green);
                tamaNappi.setText("");
                tamaNappi.setForeground(Color.BLACK);
                int miinojenLukumaara = miinaKentta.getKentta().getMiinojenLKM();
                miinojenLukumaara+=1;
                miinaKentta.getKentta().setMiinojenLKM(miinojenLukumaara);
            }
        }
        if(SwingUtilities.isLeftMouseButton(e)) {
            
            System.out.println(miinaKentta.getKentta().getAvoimiaRuutuja());
        
            int naapuriRuutujenMiinojenLukumaara = miinaKentta.getKentta().getMiinaKentta()[koordinaattiX][koordinaattiY].getNaapuriRuutujenMiinojenLukumaara();
            if(naapuriRuutujenMiinojenLukumaara>=9) {
                tamaNappi.setBackground(Color.red);
                tamaNappi.setForeground(Color.black);
                tamaNappi.setText("¤"); 
                gui.peliOhi("Osuit miinaan!");
                timer.stop();
                gui.repaint();
                return;
            }
           
            if(naapuriRuutujenMiinojenLukumaara==0) {
                JButton[][] miinaNappi = new JButton[miinaKentta.getKentanKoko()][miinaKentta.getKentanKoko()];
                tamaNappi.setText(""+miinaKentta.getKentta().getMiinaKentta()[koordinaattiX][koordinaattiY].getNaapuriRuutujenMiinojenLukumaara());
                miinaKentta.onkoMiina(koordinaattiX, koordinaattiY);
                gui.avaaKenttaaJosNolla(gui.gridBagConstraints);
                for(int i=0;i<miinaKentta.getKentta().getKentanKoko();++i) {
                    for(int j=0;j<miinaKentta.getKentta().getKentanKoko();++j) {
                        if(koordinaattiX>=0 && koordinaattiY>=0 && koordinaattiX<miinaKentta.getKentta().getKentanKoko() && koordinaattiY<miinaKentta.getKentta().getKentanKoko()) {
                            miinaNappi[i][j]=new JButton();
                            if(miinaKentta.getKentta().getMiinaKentta()[i][j].isAuki()) {
                                tamaNappi=miinaNappi[i][j];
                                tamaNappi.setText(""+miinaKentta.getKentta().getMiinaKentta()[i][j].getNaapuriRuutujenMiinojenLukumaara());  
                            }
                        }
                    }
                }
            }
            if(miinaKentta.getKentta().getAvoimiaRuutuja()==80) {
                gui.peliOhi("Voitit!");
                timer.stop();
                tamaNappi.setText(""+miinaKentta.getKentta().getMiinaKentta()[koordinaattiX][koordinaattiY].getNaapuriRuutujenMiinojenLukumaara());
            }
            else {    
                miinaKentta.getKentta().getMiinaKentta()[koordinaattiX][koordinaattiY].setAuki(true);
                miinaKentta.getKentta().setAvoimiaRuutuja(miinaKentta.getKentta().getAvoimiaRuutuja()+1);
                tamaNappi.setText(""+miinaKentta.getKentta().getMiinaKentta()[koordinaattiX][koordinaattiY].getNaapuriRuutujenMiinojenLukumaara());
            }             
        }             
        gui.repaint();      
    }
    
    /**
     * metodit jotka piti "toteuttaa" MouseListenerin implementoinnin takia.
     * @param e 
     */

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