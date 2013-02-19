package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/* @author mhaanran */
public class GraafinenKayttoLiittyma extends JFrame{

    private JPanel paaIkkuna, ylaRiviPanel, kenttaPanel;
    private JButton aloitaPeli, naytaAikaa;
    
    public GraafinenKayttoLiittyma() {
        
    }
    
    public void alustaKomponentit() {
        setTitle("Miinaharava");
        setPreferredSize(new Dimension(700,500));  
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        GridBagLayout gridBagLayout = new GridBagLayout();      
        paaIkkuna = new JPanel();
        paaIkkuna.setLayout(gridBagLayout);   
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        aloitaPeli = new JButton("Aloita Peli");
        gridBagConstraints.fill=GridBagConstraints.HORIZONTAL;
//        gridBagConstraints.weightx=0.5;
        gridBagConstraints.gridy=0;
        gridBagConstraints.gridx=0;
        paaIkkuna.add(aloitaPeli,gridBagConstraints);
        
        naytaAikaa = new JButton("Nayta Aikaa");
        gridBagConstraints.fill=GridBagConstraints.HORIZONTAL;
//        gridBagConstraints.weightx=0.5;
        gridBagConstraints.gridy=0;
        gridBagConstraints.gridx=1;
        paaIkkuna.add(naytaAikaa,gridBagConstraints);
        
        JButton[][] miinaNappi=new JButton[10][10];
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx=0.1;
        gridBagConstraints.weighty=0.1;
        gridBagConstraints.gridy=1;
        gridBagConstraints.gridx=0;
        for(int i=0;i<10;++i) {
            for(int j=0;j<10;++j) {       
                miinaNappi[i][j]=new JButton("X");
                paaIkkuna.add(miinaNappi[i][j],gridBagConstraints);   
                gridBagConstraints.gridx=0+j;
            }
            gridBagConstraints.gridy=1+i;        
        }
        
//        gridBagConstraints.gridheight=11;
//        gridBagConstraints.gridwidth=2
//        
//        ylaRiviPanel =  new JPanel();   
//        gridBagConstraints.gridx = 0;
//	gridBagConstraints.gridy = 0;
//        gridBagConstraints.weighty=0.1;
//        gridBagConstraints.weightx=1.0;
//        paaIkkuna.add(ylaRiviPanel, gridBagConstraints);
//        
//        kenttaPanel =  new JPanel();      
//        gridBagConstraints.gridx = 0;
//	gridBagConstraints.gridy = 0;
//        gridBagConstraints.weighty=0.9;
//        gridBagConstraints.weightx=1.0;
////        gridBagConstraints.gridwidth=10;
//        JButton button = new JButton("");
//        gridBagConstraints.gridheight=10;
//        gridBagConstraints.gridwidth=10;
//        gridBagConstraints.gridx = 0;
//	gridBagConstraints.gridy = 0;
////        gridBagConstraints.weighty=0.9;
////        gridBagConstraints.weightx=1.0;
//        kenttaPanel.setLayout(new GridBagLayout());
//        for(int i=0;i<10;++i) {
//            for(int j=0;j<10;++j) {
//                kenttaPanel.add(button);
//            }
//        }   
//        paaIkkuna.add(kenttaPanel, gridBagConstraints);
        
        setContentPane(paaIkkuna);
        setResizable(false);
        pack();
        setVisible(true);
    }
    private void luoKomponentit(Container container) {
        
    }

}
