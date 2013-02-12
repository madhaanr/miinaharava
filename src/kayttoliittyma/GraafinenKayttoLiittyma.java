package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/* @author mhaanran */
public class GraafinenKayttoLiittyma implements Runnable{

    private JFrame frame;
    
    public GraafinenKayttoLiittyma() {
        
    }
    
    @Override
    public void run() {
        frame=new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(700,500));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    private void luoKomponentit(Container container) {
        
    }
    public JFrame getFrame() {
        return frame;
    }

}
