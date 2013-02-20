package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

    private JPanel paaIkkuna, ylaRiviIkkuna, peliKenttaIkkuna;
    private JButton uusiPeli;
    private JLabel naytaAikaa;
    private PeliLogiikka miinaKentta;
    private int kentanKoko=10;
    private int koordinaattiX, koordinaattiY;
    private Timer timer;
    private SimpleDateFormat ajanMuoto = new SimpleDateFormat("mm:ss");
    private long alkuAika;
    JButton[][] miinaNappi;
    private Kuuntelija kuuntelija;
    private HiiriKuuntelija hiiriKuuntelija;
    
    
    public GraafinenKayttoLiittyma() {
        miinaKentta = new PeliLogiikka(kentanKoko);
        miinaKentta.miinojaLahella();
        this.koordinaattiX=0;
        this.koordinaattiY=0;
    }   
    
    public void alustaKomponentit() {      
        setTitle("Miinaharava");
        setPreferredSize(new Dimension(380,420));  
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        GridBagLayout gridBagLayout = new GridBagLayout();      
        paaIkkuna = new JPanel();
        ylaRiviIkkuna = new JPanel();
        peliKenttaIkkuna=new JPanel();
        paaIkkuna.add(ylaRiviIkkuna,BorderLayout.NORTH);
        peliKenttaIkkuna.setLayout(gridBagLayout);
        paaIkkuna.add(peliKenttaIkkuna,BorderLayout.SOUTH);
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        uusiPeli();
        naytaAikaa();
        miinaNappi(gridBagConstraints);
        
        setContentPane(paaIkkuna);
        setResizable(false);
        pack();
        setVisible(true);
    }

    public void uusiPeli() {
        uusiPeli = new JButton("Uusi Peli");
        uusiPeli.setPreferredSize(new Dimension(100,30));
        uusiPeli.setFont(new Font("Dialog",Font.PLAIN, 12));
        ylaRiviIkkuna.add(uusiPeli,BorderLayout.WEST);
        uusiPeli.addActionListener(this);
    }

    public void naytaAikaa() {
        naytaAikaa = new JLabel();
        naytaAikaa.setPreferredSize(new Dimension(250,30));
        naytaAikaa.setText(ajanMuoto.format(new Date(0)));
        naytaAikaa.setFont(new Font("Dialog",Font.PLAIN, 16));
        timer = new Timer(1000,this);
        timer.setRepeats(true);
        alkuAika=System.currentTimeMillis();
        timer.start();
        ylaRiviIkkuna.add(naytaAikaa,BorderLayout.EAST);
    }

    public void miinaNappi(GridBagConstraints gridBagConstraints) {
        miinaNappi=new JButton[kentanKoko][kentanKoko];
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx=0.1;
        gridBagConstraints.weighty=1.0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.gridx=0;
        gridBagConstraints.ipadx=0;
        gridBagConstraints.ipady=0;
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {       
                miinaNappi[i][j]=new JButton();
                miinaNappi[i][j].setBackground(Color.red);
                miinaNappi[i][j].setPreferredSize(new Dimension(30,30));
                koordinaattiX=i;
                koordinaattiY=j;
                kuuntelija = new Kuuntelija(miinaKentta,koordinaattiX, koordinaattiY);
                hiiriKuuntelija = new HiiriKuuntelija(miinaKentta,koordinaattiX, koordinaattiY);
                miinaNappi[i][j].addMouseListener(hiiriKuuntelija);
                paaIkkuna.add(miinaNappi[i][j],gridBagConstraints);
                gridBagConstraints.gridx=0+j;
            }
            gridBagConstraints.gridy=0+i;        
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(timer)) {
            naytaAikaa.setText(ajanMuoto.format(new Date(System.currentTimeMillis()-alkuAika)));
        }
        if(e.getSource().equals(uusiPeli)) {
            alustaKomponentit();
        }        
    }
   
}
