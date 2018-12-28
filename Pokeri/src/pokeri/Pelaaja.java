/**
 * 
 */
package pokeri;

import java.util.ArrayList;

/**
 * @author Joel
 * @version Dec 2, 2018
 *
 */
public class Pelaaja {
    
    String nimi;
    int varat;
    private static int seuraavaNro = 0;
    
    private Kortti[] kasi = new Kortti[2];
    
    boolean variSuora;
    boolean neljaSamaa;
    boolean taysKasi;
    boolean vari;
    boolean suora;
    boolean kolmoset;
    boolean kaksParia;
    boolean pari;
    Kortti highCard;
    
    int pata;
    int risti;
    int ruutu;
    int hertta;
    
    
    /**
     * Alustetaan luotu pelaaja 
     * @param nimi Pelaajan nimi
     * @param varat Pelaajan varat
     */
    public void alusta(String nimi, int varat) {
        this.nimi = nimi;
        this.varat = varat;
    }
    
    /**
     * Tulostaa kortit
     * @return Stringin korteista
     */
    public String tulostaKortit() {
        String s = ""; 
        
        for(int i = 0; i < kasi.length; i++) {
            s = s + "" + kasi[i].tulosta() + ", ";
        }
        
        return s;
    }
    
    /**
     * @return pelaajan nimi
     */
    public String getNimi() {
        return nimi;
    }
    
    /**
     * N�ytt�� pelaajan kortit
     * @return kortit
     */
    public Kortti[] naytaKasi() {
        return kasi;
    }
    
    /**
     * Tulostaa pelaajan tiedot
     */
    public void tulosta() {
        System.out.println("Pelaaja " + nimi + ", jolla varoja " + varat);
        System.out.println("ja k�dess� on " + tulostaKortit());
    }
    
    /**
     * Lis�t��n pelaajan k�teen kortti
     * @param kortti lis�tty kortti
     */
    public void lisaaKortti(Kortti kortti) {
        kasi[seuraavaNro++] = kortti;
        if(seuraavaNro == 2) seuraavaNro = 0;
    }
    
    /**
     * Katsoo mik� on pelaajan High Card k�dess�
     */
    public void tarkistaHigh() {
        if(Kortti.numero(kasi[0]) > Kortti.numero(kasi[1])) highCard = kasi[0];
        else highCard = kasi[1];
    }
    
    /**
     * Tarkistaa mit� pelaajalla on 
     */
    public void tarkistaPari() {
        if(Kortti.numero(kasi[0]) == Kortti.numero(kasi[1])) pari = true;
    }
    
    public void tarkista() {
        tarkistaHigh();
        tarkistaPari();
    }
    
    public void tarkistaKasi(ArrayList<Kortti> poyta) {
        //
    }
    
    public void tarkista(ArrayList<Kortti> poyta) {
        tarkistaKasi(poyta);
        
        // TODO: MITEN PELAAJA VOI ITSE TARKASTELLA MIT� H�NELL� ON? ESIM. 
        // PELAAJALLA COLLECTION JOSSA PIT�� YLL� MONTA PATAA TAI RISTI� H�NELL� ON
        // TAI MONTA KAKKOSTA TAI KOLMOSTA H�NELL� ON...
    }
    
    /**
     * @param args ei k�yt�ss�
     */
    public static void main(String[] args) {
        Pelaaja x = new Pelaaja();
        x.alusta("Seppo",100);
        x.tulosta();
        
        Kortti pA = new Kortti();
        Maa hertta = new Maa();
        hertta.alusta("Hertta");
        pA.alusta(hertta, 1);
        
        x.lisaaKortti(pA);
    }

}
