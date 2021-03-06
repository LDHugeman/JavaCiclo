package cuentascorrientefichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 *
 * @author a18luisdvp
 */
public class CuentasCorrienteFichero {

    public static void main(String[] args) {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        File fichero = new File("cuentas.dat");
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = Menu.seleccionarOpcionMenuPrincipal(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Archivo.nuevoFichero(fichero, lee);
                    break;
                case 2:
                    Menu.menuAltas(fichero, lee);
                    break;
                case 3:
                    Menu.menuBajas(fichero, lee);
                    break;
                case 4:
                    Modificar.direccionCliente(fichero, Crear.pedirDniExistente(fichero, lee), lee);
                    System.out.println("Dirección modificada correctamente");
                    break;
                case 5:
                    Menu.menuConsultas(fichero, lee);
                    break;
                case 0:
                    break;
                default:
                    System.err.printf("Esa opción no existe %n");
            }
        } while (opcionSeleccionada != 0);
    }     
}
