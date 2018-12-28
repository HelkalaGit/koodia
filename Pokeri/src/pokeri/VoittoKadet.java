/**
 * 
 */
package pokeri;

/**
 * @author Joel
 * @version Dec 3, 2018
 *
 */
public class VoittoKadet {
    int arvo;
    
    private void alusta(int nro) {
        arvo = nro;
    }
    
    public static void luoVoittoKadet() {
        VoittoKadet variSuora   = new VoittoKadet(); variSuora.alusta(9);
        VoittoKadet neljaSamaa  = new VoittoKadet(); neljaSamaa.alusta(8);
        VoittoKadet taysKasi    = new VoittoKadet(); taysKasi.alusta(7);
        VoittoKadet vari        = new VoittoKadet(); vari.alusta(6);
        VoittoKadet suora       = new VoittoKadet(); suora.alusta(5);
        VoittoKadet kolmoset    = new VoittoKadet(); kolmoset.alusta(4);
        VoittoKadet kaksiParia  = new VoittoKadet(); kaksiParia.alusta(3);
        VoittoKadet pari        = new VoittoKadet(); pari.alusta(2);
        VoittoKadet highCard    = new VoittoKadet(); highCard.alusta(1);
    }
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        luoVoittoKadet();
    }

}
