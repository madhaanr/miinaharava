package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import ohjelmalogiikka.PeliLogiikka;

/* @author mhaanran */
public class GraafinenKayttoLiittyma extends JFrame implements ActionListener {

    private JPanel paaIkkuna,ylaRiviIkkuna,kenttaRuudukkoIkkuna;
    private JButton uusiPeli;
    private JLabel naytaAikaa;
    private PeliLogiikka miinaKentta;
    private int kentanKoko=10;
    private int koordinaattiX, koordinaattiY;
    private Timer timer;
    private SimpleDateFormat ajanMuoto = new SimpleDateFormat("mm:ss");
    private long alkuAika;
    JButton[][] miinaNappi;
    
    
    public GraafinenKayttoLiittyma() {
        
    }   
    public void alustaKomponentit() {  
        miinaKentta = new PeliLogiikka(kentanKoko);
        miinaKentta.miinojaLahella();
        setTitle("Miinaharava");
        setPreferredSize(new Dimension(700,600));  
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        GridBagLayout gridBagLayout = new GridBagLayout();      
        paaIkkuna = new JPanel();
        paaIkkuna.setLayout(gridBagLayout);     
    
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        uusiPeli(gridBagConstraints);
        naytaAikaa(gridBagConstraints);
        miinaNappi(gridBagConstraints);
        
        setContentPane(paaIkkuna);
        setResizable(false);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(timer)) {
            naytaAikaa.setText(ajanMuoto.format(new Date(System.currentTimeMillis()-alkuAika)));
        }
        if(e.getSource().equals(uusiPeli)) {
            alustaKomponentit();
        }
        if(e.getSource() instanceof JButton) {
            e.getActionCommand();
            miinaKentta.onkoMiina(koordinaattiX, koordinaattiY);
        }
         
    }

    public JButton uusiPeli(GridBagConstraints gridBagConstraints) {
        uusiPeli = new JButton("Uusi");
        uusiPeli.setPreferredSize(new Dimension(50,50));
        uusiPeli.setFont(new Font("Dialog",Font.PLAIN, 12));
        gridBagConstraints.fill=GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx=0.0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.gridx=0;
        gridBagConstraints.ipadx=0;
        gridBagConstraints.ipady=0;
        paaIkkuna.add(uusiPeli,gridBagConstraints);
        uusiPeli.addActionListener(this);
        return uusiPeli;
    }

    public JLabel naytaAikaa(GridBagConstraints gridBagConstraints) {
        naytaAikaa = new JLabel();
        naytaAikaa.setPreferredSize(new Dimension(50,50));
        gridBagConstraints.fill=GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx=0.0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.gridx=kentanKoko-1;
        naytaAikaa.setText(ajanMuoto.format(new Date(0)));
        naytaAikaa.setFont(new Font("Dialog",Font.PLAIN, 16));
        timer = new Timer(1000,this);
        timer.setRepeats(true);
        alkuAika=System.currentTimeMillis();
        timer.start();
        paaIkkuna.add(naytaAikaa,gridBagConstraints);
        return naytaAikaa;
    }

    public JButton miinaNappi(GridBagConstraints gridBagConstraints) {
        miinaNappi=new JButton[kentanKoko][kentanKoko];
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx=0.1;
        gridBagConstraints.weighty=1.0;
        gridBagConstraints.gridy=1;
        gridBagConstraints.gridx=0;
        gridBagConstraints.ipadx=0;
        gridBagConstraints.ipady=0;
//        gridBagConstraints.gridwidth=1;
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {       
                miinaNappi[i][j]=new JButton();
                miinaNappi[i][j].setPreferredSize(new Dimension(50,50));
                miinaNappi[i][j].addActionListener(this);
//                miinaNappi[i][j].setActionCommand("command"+i+"-"+j);
                paaIkkuna.add(miinaNappi[i][j],gridBagConstraints);
                gridBagConstraints.gridx=0+j;
            }
            gridBagConstraints.gridy=1+i;        
        }
        return miinaNappi[koordinaattiX][koordinaattiY];
    }
}
