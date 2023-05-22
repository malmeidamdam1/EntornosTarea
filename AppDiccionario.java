/**
 * 
 *  
 */
public class AppDiccionario
{

    /**
     *   crea el diccionario
     *   crea e inicia el interfaz
     *  
     */
    public static void main(String[] args)   {
          Diccionario diccionario = new Diccionario(4);
          InterfazDiccionario i = new InterfazDiccionario(diccionario);
          i.iniciar();
        
        
    }
}
