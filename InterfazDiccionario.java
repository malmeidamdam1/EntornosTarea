
/**
 * clase InterfazDiccionario 
 *  
 */
import java.util.Scanner;
public class InterfazDiccionario
{
    private static final int ANADIR = 1;
    private static final int MOSTRAR = 2;
    private static final int TRADUCIR = 3;
    private static final int SALIR = 4;

    private Scanner teclado;
    private Diccionario diccionario;

    /**
     * Constructor de objetos de la clase InterfazDiccionario
     * Crea e inicializa adecuadamente los atributos
     */
    public InterfazDiccionario(Diccionario diccionario)    {
        // TODO
        this.diccionario = diccionario;

        teclado = new Scanner(System.in);

    }

    /**
     * Incluye la l�gica de la aplicaci�n
     *  
     */
    public void iniciar()    {
        borrarPantalla();
        int opcion = menu();
        while (opcion != SALIR)       {
            switch (opcion){
                case ANADIR: anadirPalabra();
                    break;
                case MOSTRAR: mostrarDiccionario();
                    break;
                case TRADUCIR: traducirPalabra();
                    break;
            }
            opcion = menu(); 
        }
    }

    /**
     * Presenta el men� - pide una opci�n y la valida
     * 
     * @return  la opci�n seleccionada ya validada
     */
    private int menu()    {
        System.out.println("********************************");
        System.out.println("Gesti�n de un diccionario\n");
        System.out.println("********************************");
        System.out.println("1. A�adir palabra");
        System.out.println("2. Mostrar diccionario");
        System.out.println("3. Traducir palabra");
        System.out.println("4. Salir");
        System.out.print("Teclea opci�n: ");
        int opcion = teclado.nextInt();
        while (!opcionValida(opcion))       {
             System.out.print("Opci�n incorrecta, Teclea opci�n: ");
             opcion = teclado.nextInt();
        }
        return opcion;

    }

    /**
     *  Valida una opci�n recibida como par�metro
     *  Devuelve true si la opci�n es correcta, false en otro caso
     *   Sin if
     */
    private boolean opcionValida(int opcion)    {
        return opcion >= ANADIR && opcion <= SALIR;
    }

    /**
     * A�ade una nueva palabra al diccioanrio
     */
    private void anadirPalabra()    {
        borrarPantalla();
        teclado.nextLine(); //limpiar el buffer

        System.out.print("Palabra en castellano: ");
        String castellano = teclado.nextLine();

        System.out.print("Palabra en ingl�s: ");
        String ingles = teclado.nextLine();

        Palabra palabra = new Palabra(castellano, ingles);
        diccionario.insertarPalabra(palabra);
    }

    /**
     * Mostrar el diccioanrio
     */
    private void mostrarDiccionario()   {
        borrarPantalla();
        diccionario.escribirDiccionario();
    }

    /**
     * Traducir una  palabra al diccioanrio
     */
    private void traducirPalabra()   {
        borrarPantalla();
        teclado.nextLine(); //limpiar el buffer
        System.out.print("Posicion: ");
        int posicion = teclado.nextInt();
       String ingles = diccionario.traducirPalabra(posicion);
        System.out.println(ingles);

    }

    /**
     * Borrar la pantalla
     */
    private void borrarPantalla()    {
        System.out.println("\u000C");
    }

    
    
    
}
