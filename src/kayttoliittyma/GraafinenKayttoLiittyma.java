package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
/**
 * GraafinenKäyttöLiittymä toteutetaan tässä luokassa. 
 * @author mhaanran
 */

public class GraafinenKayttoLiittyma extends JFrame implements ActionListener {

    private JPanel paaIkkuna, ylaRiviIkkuna, peliKenttaIkkuna,alaRiviIkkuna;
    private JButton uusiPeli;
    private JLabel naytaAikaa,miinojenLKM, peliOhi;
    private PeliLogiikka miinaKentta;
    private int kentanKoko=10;
    private int koordinaattiX, koordinaattiY;
    private Timer timer;
    private SimpleDateFormat ajanMuoto = new SimpleDateFormat("mm:ss");
    private long alkuAika;
    JButton[][] miinaNapit;
    JButton[][] nollaMiinaa;
    private HiiriKuuntelija hiiriKuuntelija;
    GridBagLayout gridBagLayout;
    GridBagConstraints gridBagConstraints;
    
    public GraafinenKayttoLiittyma() {
        miinaKentta = new PeliLogiikka(kentanKoko);
        miinaKentta.miinojaLahella();
        this.koordinaattiX=0;
        this.koordinaattiY=0;
    }   
    
    /**
     * Metodi alustaKomponentit luo käyttöliittymä ikkunan.
     */
    
    public void alustaKomponentit() {      
        setTitle("Miinaharava");
        setPreferredSize(new Dimension(380,460));  
        setDefaultCloseOperation(EXIT_ON_CLOSE);     
             
        paaIkkuna = new JPanel();
        ylaRiviIkkuna = new JPanel();
        peliKenttaIkkuna = new JPanel();
        alaRiviIkkuna = new JPanel();
        paaIkkuna.add(ylaRiviIkkuna);
        gridBagLayout = new GridBagLayout(); 
        gridBagConstraints = new GridBagConstraints();
        peliKenttaIkkuna.setLayout(gridBagLayout);
        paaIkkuna.add(peliKenttaIkkuna);
        paaIkkuna.add(alaRiviIkkuna);
       
        
        uusiPeli();
        naytaAikaa();
        naytaMiinojenLKM();  
        peliOhi("");
        miinaNapit(gridBagConstraints);
        
        setContentPane(paaIkkuna);
        setResizable(false);
        pack();
        setVisible(true);
    }

    /**
     * uusiPeli metodi luo JButtonin josta voi aloittaa uuden miinaharava pelin.
     * Button sijoitetaan ylaRiviIkkunan JPaneliin.
     */  
    public void uusiPeli() {
        uusiPeli = new JButton("Uusi Peli");
        uusiPeli.setPreferredSize(new Dimension(100,30));
        uusiPeli.setBorder(null);
        uusiPeli.setFont(new Font("Times New Roman",Font.PLAIN, 20));
        ylaRiviIkkuna.add(uusiPeli,BorderLayout.WEST);
        uusiPeli.addActionListener(this);
    }

    /**
     * naytaAika metodi toteuttaa JLabelin jossa näytetään miten pitkään peli 
     * on ollut käynnissä.
     */  
    public void naytaAikaa() {
        naytaAikaa = new JLabel();
        naytaAikaa.setPreferredSize(new Dimension(200,30));
        naytaAikaa.setText(ajanMuoto.format(new Date(0)));
        naytaAikaa.setFont(new Font("Times New Roman",Font.PLAIN, 16));
        timer = new Timer(1000,this);
        timer.setRepeats(true);
        alkuAika=System.currentTimeMillis();
        timer.start();
        ylaRiviIkkuna.add(naytaAikaa);
    }
        
    /**
     * naytaMiinojenLKM on JLabel kenttä jossa näytetään miten monta 
     * merkkaamatonta miina pelikentällä on.
     */
    public void naytaMiinojenLKM() {
        miinojenLKM=new JLabel();
        miinojenLKM.setPreferredSize(new Dimension(50,30));
        miinojenLKM.addMouseListener(hiiriKuuntelija);
        miinojenLKM.setText(""+miinaKentta.getKentta().getMiinojenLKM());
        ylaRiviIkkuna.add(miinojenLKM,BorderLayout.NORTH);
    }
    
    /**
     * metodi tulostaa tekstin joka kertoo pelin päättymisestä. Joko
     * osuttaessa miinaan tai kun kaikki miinattomat ruudut on avattu.
     */
    public void peliOhi(String tilanne) {
        peliOhi = new JLabel();
        peliOhi.setPreferredSize(new Dimension(360,30));
        peliOhi.setBorder(null);
        peliOhi.setText(tilanne);
        alaRiviIkkuna.add(peliOhi,BorderLayout.WEST);       
    }
    /**
     * miinaNapit metodi luo JButtonin jokaiselle miinaKentän alkiolle.
     * @param gridBagConstraints 
     */
    public void miinaNapit(GridBagConstraints gridBagConstraints) {
        miinaNapit=new JButton[kentanKoko][kentanKoko];
//        gridBagConstraints.fill = GridBagConstraints.BOTH;
//        gridBagConstraints.weightx=1.0;
//        gridBagConstraints.weighty=1.0;
//        gridBagConstraints.gridy=0;
//        gridBagConstraints.gridx=0;
//        gridBagConstraints.ipadx=0;
//        gridBagConstraints.ipady=0;
        for(int i=0;i<kentanKoko;++i) {
            for(int j=0;j<kentanKoko;++j) {       
                miinaNapit[i][j]=new JButton();
                miinaNapit[i][j].setBorder(null);
                miinaNapit[i][j].setMargin(new Insets(0,0,0,0));
                miinaNapit[i][j].setBackground(Color.green);
                miinaNapit[i][j].setPreferredSize(new Dimension(30,30));
                koordinaattiX=i;
                koordinaattiY=j;
                hiiriKuuntelija = new HiiriKuuntelija(this, miinaKentta,koordinaattiX, koordinaattiY,timer);
                miinaNapit[i][j].addMouseListener(hiiriKuuntelija);
                paaIkkuna.add(miinaNapit[i][j],gridBagConstraints);
                gridBagConstraints.gridx=0+j;
            }
            gridBagConstraints.gridy=0+i;        
        }
       
     }
    
    /**
     * avaaKenttaaJosNolla metodi päivittää kentän tilanteen jos osutaan
     * ruutuun jonka naapuriRuutujenMiinojenLukumäärä muuttujan arvo on
     * nolla.
     * @param gridBagConstraints 
     */
    public void avaaKenttaaJosNolla(GridBagConstraints gridBagConstraints) {
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx=0.1;
        gridBagConstraints.weighty=1.0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.gridx=0;
        gridBagConstraints.ipadx=0;
        gridBagConstraints.ipady=0;
        for(int i=0;i<miinaKentta.getKentta().getKentanKoko();++i) {
           for(int j=0;j<miinaKentta.getKentta().getKentanKoko();++j) {
               if(koordinaattiX>=0 && koordinaattiY>=0 && koordinaattiX<miinaKentta.getKentta().getKentanKoko() && koordinaattiY<miinaKentta.getKentta().getKentanKoko()) {   
                   if(miinaKentta.getKentta().getMiinaKentta()[i][j].isAuki()==true) {   
                       miinaNapit[i][j].setBorder(null);
                       miinaNapit[i][j].setMargin(new Insets(1,1,1,1));
                       miinaNapit[i][j].setFont(new Font("Times New Roman",Font.PLAIN, 20));
                       miinaNapit[i][j].setText(""+miinaKentta.getKentta().getMiinaKentta()[i][j].getMiinaLahiRuudussa());  
                       gridBagConstraints.gridx=0+j;
                   }
                   gridBagConstraints.gridy=0+i; 
               }
           }
        }
    }
    
    /**
     * Kuuntelija joka päivittää peliin käytettyä aikaa sekä miinojenLKM
     * ruutua sekä toteuttaa uusi peli nappulan klikkaamisesta seuraavat
     * toimenpiteet.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(timer)) {
            naytaAikaa.setText(ajanMuoto.format(new Date(System.currentTimeMillis()-alkuAika)));
            miinojenLKM.setText(""+miinaKentta.getKentta().getMiinojenLKM());
            
        }
        if(e.getSource().equals(uusiPeli)) {
            miinaKentta=new PeliLogiikka(kentanKoko);
            miinaKentta.miinojaLahella();
            alustaKomponentit();
        }             
    }   
}
