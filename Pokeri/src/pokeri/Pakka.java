/**
 * 
 */
package pokeri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Joel
 * @version Nov 20, 2018
 *
 */
public class Pakka {
    
    private static int lkm;
    
    //private static Kortti[] alkiot = new Kortti[52];
    
    private static ArrayList<Kortti> lista = new ArrayList<>();
    private static ArrayList<Kortti> poyta = new ArrayList<>();
    //private static ArrayList<Kortti> tarkistus = new ArrayList<>();
    private static ArrayList<Pelaaja> pelaajat = new ArrayList<>();
    
    /**
     * Lis‰t‰‰n kortti pakkaan
     * @param kortti kortti
     */
    public static void lisaa(Kortti kortti) {
        //alkiot[lkm++] = kortti;
        lista.add(kortti);
    }
    
    /**
     * Luodaan peliin uusi osallistuja
     * @param nimi Osallistujan nimi
     * @param rahat Osallistujan varat
     */
    public static void uusiPelaaja(String nimi, int rahat) {
        Pelaaja x = new Pelaaja();
        x.alusta(nimi, rahat);
        pelaajat.add(x);
    }
    
    /**
     * Luodaan yhden maan kortit
     * @param maa mik‰ maa
     */
    public static void luoKortit(Maa maa) {
        for(int i = 1; i < 14; i++) {
            Kortti k = new Kortti();
            k.alusta(maa,i);
            lisaa(k);
        }
    }

    /**
     * Tulostaa korttipakan
     */
    public static void tulosta() {
        for(int i = 0; i < lista.size()-1; i++) {
            System.out.println(lista.get(i).tulosta());
        }
    }

   /**
    * Jaetaan annetulle pelaajalle kaksi korttia
    */
   public static void jaaKortit() {
       for(int i = 0; i < pelaajat.size(); i++) {
           
           for(int y = 0; y < 2; y++) {
               pelaajat.get(i).lisaaKortti(lista.get(lista.size()-1));
               lista.remove(lista.size()-1);
               //poistaKortti(alkiot,alkiot.length-1);
           }pelaajat.get(i).tarkista();
       }
   }
   
   /**
    * Tulostetaan mit‰ kortteja pˆyd‰ss‰ on
    */
   public static void tulostaPoyta() {
       System.out.println("\nPˆyd‰ss‰ on: ");
       
       for(int i = 0; i < poyta.size(); i++) {
           System.out.print(poyta.get(i).tulosta() + " ");
       }System.out.println("");
   }
   
   public static void pelaajatTarkista(ArrayList<Kortti> poyta) {
       for(int i = 0; i < pelaajat.size(); i++) {
           pelaajat.get(i).tarkista(poyta);
       }
   }
    
   /**
    * Jaetaan ensimm‰iset kolme pˆyt‰ korttia
    */
   public static void jaaEka() {
       for(int i = 0; i < 3; i++) {
           lista.remove(lista.size()-1);
       }
       
       for(int i = 0; i < 3; i++) {
           poyta.add(lista.get(lista.size()-1));
           lista.remove(lista.size()-1);
       }
       
       pelaajatTarkista(poyta);
   }
   
   /**
    * Jaetaan toinen ja kolmas pˆyt‰ kortti 
    */
   public static void jaaToka() {
       lista.remove(lista.size()-1);
       poyta.add(lista.get(lista.size()-1));
       lista.remove(lista.size()-1);
       
       pelaajatTarkista(poyta);
   }
   
   /**
    * J‰rjestet‰‰n k‰si korttien suuruuden mukaan
    * @param kasi Mik‰ k‰si
    * @return J‰rjestetty k‰si
    */
   public static ArrayList<Kortti> jarjesta(ArrayList<Kortti> kasi) {
       ArrayList<Kortti> jarjestetty = new ArrayList<>();
       Kortti pienin = new Kortti();
       
       int kesto = kasi.size();
       
       for(int y = 0; y < kesto; y++) {
           int pieninI = 0;
           pienin = kasi.get(0);
           for(int i = 1; i < kasi.size(); i++) {
               if(Kortti.numero(kasi.get(i)) < Kortti.numero(pienin)) {
                   pienin = kasi.get(i);
                   pieninI = i;
               }
           }
           jarjestetty.add(pienin);
           kasi.remove(pieninI);
       }
       return jarjestetty;
   }
   
   /**
    * Tulostaa pelaajien kortit
    */
   public static void tulostaPelaajat() {
       for(int i = 0; i < pelaajat.size(); i++) {
           System.out.println("Pelaajan " + pelaajat.get(i).getNimi()   + " kortit:");
           
           System.out.print(pelaajat.get(i).tulostaKortit() + " ");
           System.out.println("");
           
       }
   }
   
   /*public static boolean tarkistaSuora(ArrayList<Kortti> kasi) {
       int jatkumo = 0;
       
       ArrayList<Kortti> vara = new ArrayList<>();
       vara = kasi;
       
       for(int i = 0; i < kasi.size()-1; i++) {
           if(Kortti.numero(vara.get(i)) == Kortti.numero(vara.get(++i))) vara.remove(i);
       }
       
       for(int i = 0; i < vara.size()-1; i++) {
           if((Kortti.numero(vara.get(i)) - Kortti.numero(vara.get(++i))) == 1) jatkumo++;
       }
       if(jatkumo == 5) return true;
    return false;
   }*/
   
   /*public static void tarkistaVoitot(ArrayList<Kortti> kasi) {
       boolean suora = tarkistaSuora(kasi);
       // TODO: 
   }*/
   
   /*public static void pokerHands(ArrayList<Kortti> kasi) {
       ArrayList<Kortti> jarjestetty = new ArrayList<>();
       jarjestetty = jarjesta(kasi);
       
       tarkistaVoitot(jarjestetty);
   }*/
    
   /*public static void tarkistaKadet(Pelaaja p) {
       Kortti[] vara = p.naytaKasi();
       
       for(int i = 0; i < vara.length; i++) {
           tarkistus.add(vara[i]);
       }
       
       for(int i = 0; i < poyta.size(); i++) {
           tarkistus.add(poyta.get(i));
       }
       
       pokerHands(tarkistus);
   }*/
   
    /**
     * @param args ei k‰ytˆss‰
     */
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner reader = new Scanner(System.in);
        String pelaaja1;
        String pelaaja2;
        
        System.out.println("Tervetuloa pelaamaan Texasia.\nPeliin mahtuu kaksi pelaajaa.\nOlkaa hyv‰t ja antakaa nimenne ensimm‰inen pelaaja.");
        pelaaja1 = reader.next();
        System.out.println("Antakaa nimenne toinen pelaaja.");
        pelaaja2 = reader.next();
        reader.close();
        
        alustaPeli();
        //tulosta();
        
        Collections.shuffle(lista);
        //System.out.println("------------------------------");
        //tulosta();
        
        uusiPelaaja(pelaaja1,100);
        uusiPelaaja(pelaaja2, 50);
        
        jaaKortit();
        
        jaaEka();
        tulostaPoyta();
        
        jaaToka();
        tulostaPoyta();
        
        jaaToka();
        tulostaPoyta();
        
        tulostaPelaajat();
    }

    private static void alustaPeli() {
        luoMaat();
        //VoittoKadet.luoVoittoKadet();
        
        
    }

    private static void luoMaat() {
        Maa hertta = new Maa();
        hertta.alusta("hertta");
        Maa pata = new Maa();
        pata.alusta("pata");
        Maa risti = new Maa();
        risti.alusta("risti");
        Maa ruutu = new Maa();
        ruutu.alusta("ruutu");
        
        luoKortit(hertta);
        luoKortit(pata);
        luoKortit(risti);
        luoKortit(ruutu);
        
    }

}
