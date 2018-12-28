/**
 * 
 */
package pokeri;

/**
 * @author Joel
 * @version Nov 20, 2018
 *
 */
public class Kortti {
    
    private int numero;
    Maa maa;
    
    /**
     * Alustetaan kortin tiedot
     * @param maa mik� maa
     * @param numero mik� numero
     */
    public void alusta(Maa maa, int numero) {
        this.numero = numero;
        this.maa = maa;
    }
    
    private String getMaa() {
        return maa.tulosta();
    }
    
    private int getNum() {
        return numero;
    }
    
    /**
     * Tulostaa
     * @return palautus
     */
    public String tulosta() {
        return getMaa() + "" + getNum();
    }
    
    public static int numero(Kortti kortti) {
        int i = kortti.getNum();
        return i;
    }
    

    /**
     * @param args ei k�yt�ss�
     */
    public static void main(String[] args) {
        Kortti pA = new Kortti();
        Maa hertta = new Maa();
        hertta.alusta("Hertta");
        
        pA.alusta(hertta, 1);
        
    }

}
