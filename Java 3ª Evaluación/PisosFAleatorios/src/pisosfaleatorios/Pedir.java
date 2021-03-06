package pisosfaleatorios;

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
                System.out.printf("Vuelva a introducirlo: ");
                esTextoValido = false;
            }
        } while (!esTextoValido);
        return texto;
    }
    
    public static char caracter(BufferedReader lee) {
        boolean esCaracterValido;
        char caracter = ' ';
        do {
            try {
                esCaracterValido = true;
                caracter = (char)lee.read();
            } catch (IOException excepcion) {
                System.err.printf("No es un carácter válido %n");
                System.out.printf("Vuelva a introducirlo: ");
                esCaracterValido = false;
            }
        } while (!esCaracterValido);
        return caracter;
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

    public static float numeroRealFloat(BufferedReader lee) {
        boolean esNumeroRealFloatValido;
        float numeroReal = 0;
        do {
            try {
                esNumeroRealFloatValido = true;
                numeroReal = Float.parseFloat(lee.readLine());
            } catch (NumberFormatException | IOException excepcion) {
                System.err.printf("Introduzca un número válido %n");
                esNumeroRealFloatValido = false;
            }
        } while (!esNumeroRealFloatValido);
        return numeroReal;
    }

    public static double numeroRealDouble(BufferedReader lee) {
        boolean esNumeroRealDoubleValido;
        double numeroReal = 0;
        do {
            try {
                esNumeroRealDoubleValido = true;
                numeroReal = Double.parseDouble(lee.readLine());
            } catch (NumberFormatException | IOException excepcion) {
                System.err.printf("Introduzca un número válido %n");
                esNumeroRealDoubleValido = false;
            }
        } while (!esNumeroRealDoubleValido);
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
    
    public static long numeroLong(BufferedReader lee) {
        boolean esNumeroLongValido;
        long numeroLong = 0;
        do {
            try {
                esNumeroLongValido = true;
                numeroLong = Long.parseLong(lee.readLine());
            } catch (NumberFormatException | IOException excepcion) {
                System.out.printf("Introduzca un número válido %n");
                esNumeroLongValido = false;
            }
        } while (!esNumeroLongValido);
        return numeroLong;
    }
}
