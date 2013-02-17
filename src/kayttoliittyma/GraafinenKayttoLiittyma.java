package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/* @author mhaanran */
public class GraafinenKayttoLiittyma extends JFrame{

    JPanel paaIkkuna, ylaRiviPanel, kenttaPanel;
    
    public GraafinenKayttoLiittyma() {
        
    }
    
    public void alustaKomponentit() {
        setTitle("Miinaharava");
        setPreferredSize(new Dimension(700,500));  
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        paaIkkuna = new JPanel();
        ylaRiviPanel =  new JPanel();
        ylaRiviPanel.setSize(100, 700);
        kenttaPanel =  new JPanel();
        
        paaIkkuna.add(ylaRiviPanel,BorderLayout.NORTH);
        paaIkkuna.add(kenttaPanel,BorderLayout.SOUTH);
        setContentPane(paaIkkuna);
//        luoKomponentit(getContentPane());
        
        setResizable(false);
        pack();
        setVisible(true);
    }
    private void luoKomponentit(Container container) {
        
    }

}
