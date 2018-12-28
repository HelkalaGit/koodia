/**
 * 
 */
package pokeri;

/**
 * @author Joel
 * @version Nov 20, 2018
 *
 */
public class Maa {
    
    String maa;
    
    protected void alusta(String maa){
        this.maa = maa;
    }
    
    protected String tulosta() {
        return maa;
    }

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Maa hertta = new Maa();
        Maa pata = new Maa();
        Maa risti = new Maa();
        Maa ruutu = new Maa();
        
        hertta.alusta("hertta");
        pata.alusta("pata");
        risti.alusta("risti");
        ruutu.alusta("ruutu");
    }

}
