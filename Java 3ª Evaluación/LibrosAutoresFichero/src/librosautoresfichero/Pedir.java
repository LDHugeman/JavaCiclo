package librosautoresfichero;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author David
 */
public class Pedir {

    public static String texto(BufferedReader lee) {
        boolean esTextoValido;
        String texto = "";
        do {
            try {
                esTextoValido = true;
                texto = lee.readLine();
            } catch (IOException excepcion) {
                System.err.printf("No es un texto válido %n");
                System.out.printf("Vuelva a introducirlo %n");
                esTextoValido = false;
            }
        } while (!esTextoValido);
        return texto;
    }

    public static int numeroEntero(BufferedReader lee) {
        boolean esNumeroEnteroValido;
        int numeroEntero = 0;
        do {
            try {
                esNumeroEnteroValido = true;
                numeroEntero = Integer.parseInt(lee.readLine());
            } catch (NumberFormatException | IOException excepcion) {
                System.err.printf("Introduzca un número válido %n");
                esNumeroEnteroValido = false;
            }
        } while (!esNumeroEnteroValido);
        return numeroEntero;
    }

    public static float numeroReal(BufferedReader lee) {
        boolean esNumeroRealValido;
        float numeroReal = 0;
        do {
            try {
                esNumeroRealValido = true;
                numeroReal = Float.parseFloat(lee.readLine());
            } catch (NumberFormatException | IOException excepcion) {
                System.err.printf("Introduzca un número válido %n");
                esNumeroRealValido = false;
            }
        } while (!esNumeroRealValido);
        return numeroReal;
    }

    public static byte numeroByte(BufferedReader lee) {
        boolean esNumeroByteValido;
        byte numeroByte = 0;
        do {
            try {
                esNumeroByteValido = true;
                numeroByte = Byte.parseByte(lee.readLine());
            } catch (NumberFormatException | IOException excepcion) {
                System.out.printf("Introduzca un número válido %n");
                esNumeroByteValido = false;
            }
        } while (!esNumeroByteValido);
        return numeroByte;
    }
}
