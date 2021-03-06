
package cuentascorriente;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import obxetos.Cliente;
import obxetos.Cuenta;
import obxetos.CuentaPlazo;
import obxetos.Movimiento;

/**
 *
 * @author Luis David
 */
public class Menu {
    
    public static void menuAltas(BufferedReader lee, ArrayList<Cliente> clientes, ArrayList<Cuenta> cuentas) throws IOException, ParseException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = selecionarOpcionMenuAltas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Altas.altaCuentaCorriente(cuentas, clientes, lee);
                    break;
                case 2:
                    Altas.altaCuentaPlazo(cuentas, clientes, lee);
                    break;
                case 3:
                    Altas.altaMovimiento(lee, cuentas);
                    break;
            }
        } while (opcionSeleccionada != 0);
    }
    
    public static void menuBaixas(BufferedReader lee, ArrayList<Cliente> clientes, ArrayList<Cuenta> cuentas) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = selecionarOpcionMenuBaixas(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Bajas.eliminarClienteDeCuenta(Crear.pedirDni(lee), Crear.pedirNumeroCuenta(lee), cuentas);
                    break;
            }
            
        } while (opcionSeleccionada != 0);
    }
    
    public static byte menuTipoMovimiento(BufferedReader lee) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = seleccionarTipoMovimiento(lee);                                                            
        } while (opcionSeleccionada !=1 && opcionSeleccionada!=2);
        return opcionSeleccionada;
    }
    
    public static void menuModificacions(BufferedReader lee, ArrayList<Cliente> clientes, ArrayList<Cuenta> cuentas) throws IOException {
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = selecionarOpcionMenuModificacions(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Cuenta cuentaModificada = Consultar.encontrarCuenta(Crear.pedirNumeroCuenta(lee), cuentas);
                    if (cuentaModificada instanceof CuentaPlazo){
                        Modificar.modificarIntereses((CuentaPlazo) cuentaModificada, lee);
                    } else {
                        System.out.println("La cuenta introducida no es una cuentaPlazo");
                    }
                    break;
            }
        } while (opcionSeleccionada != 0);
    }
    
    public static void menuVisualizar(BufferedReader lee, ArrayList<Cliente> clientes, ArrayList<Cuenta> cuentas) throws IOException, ParseException{
        byte opcionSeleccionada = 0;
        do {
            opcionSeleccionada = selecionarOpcionMenuVisualizar(lee);
            switch (opcionSeleccionada) {
                case 1:
                    Visualizar.mostrarClientes(
                            Consultar.obterClientesContaMaiordeCantidade(cuentas, 200000));
                    break;
                case 2:
                    Visualizar.mostrarClientes(
                            Consultar.obterClientesNumerosVermellos(cuentas));
                    break;
                case 3:
                    double saldoMedio = Consultar.obterSaldoMedioDeClientes(clientes, cuentas);
                    System.out.println("O saldo medio dos clientes e: "+saldoMedio+" euros");
                    break;
                case 4:
                    Visualizar.mostrarCuentas(cuentas);
                    break;
                case 5:
                    ArrayList<Movimiento> movimientos =Consultar.obtenerMovimientosCuenta(lee, cuentas);
                    ArrayList<Movimiento> movimientosEntreFechas = Consultar.obtenerMovimientosEntreFechas(movimientos, lee);
                    Visualizar.mostrarMovimientos(movimientosEntreFechas);
                    break;
            }
        } while (opcionSeleccionada != 0);
    }
    
    public static byte selecionarOpcionMenuPrincipal(BufferedReader lee) throws IOException {
        System.out.println("------- MENU -------");
        System.out.println("1 - Altas");
        System.out.println("2 - Modificacions");
        System.out.println("3 - Baixas");
        System.out.println("4 - Visualizar");
        System.out.println("0 - Sair");
        System.out.println("Selecione a opcion");
        return Byte.parseByte(lee.readLine());
    }
    
    private static byte selecionarOpcionMenuAltas(BufferedReader lee) throws IOException {
        System.out.println("------- ALTAS -------");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Plazo");
        System.out.println("3 - Nuevo Movimiento");
        System.out.println("0 - Atras");
        System.out.println("Selecione a opcion");
        return Byte.parseByte(lee.readLine());
    }
    
    private static byte selecionarOpcionMenuModificacions(BufferedReader lee) throws IOException {
        System.out.println("------- MODIFICACIONS -------");
        System.out.println("1 - Modificar interes de conta plazo");
        System.out.println("0 - Atras");
        System.out.println("Selecione a opcion");
        return Byte.parseByte(lee.readLine());
    }
    
    private static byte selecionarOpcionMenuBaixas(BufferedReader lee) throws IOException {
        System.out.println("------- BAIXAS -------");
        System.out.println("1 - Conta Plazo");
        System.out.println("0 - Atras");
        System.out.println("Selecione a opcion");
        return Byte.parseByte(lee.readLine());
    }
    
    private static byte selecionarOpcionMenuVisualizar(BufferedReader lee) throws IOException {
        System.out.println("------- VISUALIZAR -------");
        System.out.println("1 - Clientes con conta corrente > 200.000€");
        System.out.println("2 - Clientes en numeros vermellos");
        System.out.println("3 - Saldo medio de clientes");
        System.out.println("4 - Ver cuentas");
        System.out.println("5 - Ver movimientos de una cuenta");
        System.out.println("0 - Atras");
        System.out.println("Selecione a opcion");
        return Byte.parseByte(lee.readLine());
    }
    
    public static byte seleccionarTipoMovimiento(BufferedReader lee)throws IOException{
        System.out.printf("Elija el tipo de movimiento: %n"
                + "1 - Ingreso %n"
                + "2 - Retirada %n"
                + "Movimiento: ");
        return Byte.parseByte(lee.readLine());
    }
}
