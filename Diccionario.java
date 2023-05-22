
/**
 *  la clase Diccionario representa a un diccionario
 *  de palabras
 * 
 */

public class Diccionario
{
    private static final int MAX_PALABRAS = 10;
    private Palabra[] listaPalabras;
    private int pos;

    /**
     * Constructor de la clase Diccionario
     * @param numPalabras la cantidad de palabras máxima
     * que guardará el diccionario
     */
    public Diccionario(int numPalabras)   {
        if(numPalabras > MAX_PALABRAS){
            listaPalabras = new Palabra[MAX_PALABRAS];
        }
        else {
            listaPalabras = new Palabra[numPalabras];
        }
        pos = 0;
    
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    /**
     * 
     * @param nuevaPalabra la palabra a añadir     
     */
    public boolean insertarPalabra(Palabra nuevaPalabra)   { //esto antes era void xd
        if (pos < listaPalabras.length){
            listaPalabras[pos] = nuevaPalabra; //ALT: listaPalabras[pos++] = nuevaPalabra;
            pos++;
            return true;
        }else{
            //System.out.println("Diccionario lleno.");
            return false;
        }
    }

    /**
     * @param posicion la posición de la palabra
     *        a devolver. A partir de 1.
     * @return la palabra de posicion
     */
    public Palabra obtenerPalabra(int posicion)   {
        if(posicion > 0 && posicion <= listaPalabras.length){
           return listaPalabras[posicion-1];
       // }else{
         //  return null;
        }
        return null;
    }

    /**
     * @param posicion la posición de la palabra
     *        a traducir. A partir de 1.
     * @return la traducción al inglés de la palabra
     *          de posición 
     */
    public String traducirPalabra(int posicion)   {
        if(posicion > 0 && posicion <= listaPalabras.length){
            return listaPalabras[posicion-1].getIngles();
        }
        return "-"; //mensaje de error
    }

    /**
     * Mostrar el diccionario
     */
    public void escribirDiccionario()   {
       //ALT: System.out.println(toString());
        System.out.println(this);
    }

    /**
     * Representación textual del diccionario
     */
    public String toString()   {
        String s = "";
        for (int i = 0; i < pos; i++) {
            s += (i+1) + " " + listaPalabras[i] + "\n";
        }
        return s;

            
    }

}
