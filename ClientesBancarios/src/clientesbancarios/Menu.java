
package clientesbancarios;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author David
 */
public class Menu {
    
    public static byte seleccionarOpcion (BufferedReader lee) throws IOException{
        mostrarMenu();
        return Byte.parseByte(lee.readLine());        
    }
    
    private static void mostrarMenu (){
        System.out.printf("-------------------------------- Menú --------------------------------%n"
                + "1. Introducir clientes.%n"
                + "2. Obtener clientes con saldo positivo, números rojos y saldo nulo.%n"
                + "3. Clasificar.%n"
                + "4. Visualizar.%n"
                + "5. Salir.%n"
                + "Seleccione una opción: ");
    }
}
