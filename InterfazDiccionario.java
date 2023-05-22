
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
     * Incluye la lógica de la aplicación
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
     * Presenta el menú - pide una opción y la valida
     * 
     * @return  la opción seleccionada ya validada
     */
    private int menu()    {
        System.out.println("********************************");
        System.out.println("Gestión de un diccionario\n");
        System.out.println("********************************");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Mostrar diccionario");
        System.out.println("3. Traducir palabra");
        System.out.println("4. Salir");
        System.out.print("Teclea opción: ");
        int opcion = teclado.nextInt();
        while (!opcionValida(opcion))       {
             System.out.print("Opción incorrecta, Teclea opción: ");
             opcion = teclado.nextInt();
        }
        return opcion;

    }

    /**
     *  Valida una opción recibida como parámetro
     *  Devuelve true si la opción es correcta, false en otro caso
     *   Sin if
     */
    private boolean opcionValida(int opcion)    {
        return opcion >= ANADIR && opcion <= SALIR;
    }

    /**
     * Añade una nueva palabra al diccioanrio
     */
    private void anadirPalabra()    {
        borrarPantalla();
        teclado.nextLine(); //limpiar el buffer

        System.out.print("Palabra en castellano: ");
        String castellano = teclado.nextLine();

        System.out.print("Palabra en inglés: ");
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
