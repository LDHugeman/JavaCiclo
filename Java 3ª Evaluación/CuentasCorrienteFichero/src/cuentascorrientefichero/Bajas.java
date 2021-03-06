package cuentascorrientefichero;

import java.io.BufferedReader;
import java.io.File;
import objetos.Cliente;
import objetos.Cuenta;

/**
 *
 * @author David
 */
public class Bajas {

    public static void cuenta(File fichero, Cuenta cuentaEncontrada) {
        File temporal = Archivo.obtenerTemporal(fichero, cuentaEncontrada);
        fichero.delete();
        temporal.renameTo(fichero);
    }

    public static void cliente(File fichero, String dni, BufferedReader lee) {
        Cuenta cuentaEncontrada = Consultar.encontrarCuentaPorNumero(fichero, Crear.pedirNumeroCuentaExistente(fichero, lee));
        Cliente clienteEncontrado = null;
        for (Cliente cliente : cuentaEncontrada.getClientes()) {
            if (cliente.getDni().equalsIgnoreCase(dni)) {
                clienteEncontrado = cliente;
            }
        }
        if (clienteEncontrado != null) {
            Visualizar.mostrarCliente(clienteEncontrado);
            System.out.println("¿Es este el cliente que desea eliminar?");
            System.out.println("[1] Si");
            System.out.println("[2] No");
            System.out.printf("Seleccione una opción: ");
            byte opcion = Pedir.numeroByte(lee);
            if (opcion == 1) {
                File temporal = Archivo.obtenerTemporal(fichero, cuentaEncontrada);
                cuentaEncontrada.getClientes().remove(clienteEncontrado);
                Altas.cuenta(temporal, cuentaEncontrada);
                fichero.delete();
                temporal.renameTo(fichero);
                System.out.println("Cliente eliminado");
            } else {
                System.out.println("Operación cancelada");
            }
        }
    }
}
