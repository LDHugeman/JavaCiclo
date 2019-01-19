/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentascorriente;

import java.util.ArrayList;
import obxetos.Cliente;
import obxetos.Cuenta;

/**
 *
 * @author Luis David
 */
public class Consultar {
    public static boolean existeCuenta(String numeroCuenta, ArrayList<Cuenta> cuentas){
        return encontrarCuenta(numeroCuenta, cuentas) != null;
    }
    
    public static boolean existeCliente(String dni, ArrayList<Cliente> clientes){
        return encontrarCliente(clientes, dni) != null;
    }
    
    public static Cuenta encontrarCuenta(String numeroCuenta, ArrayList<Cuenta> cuentas){
        Cuenta cuentaEncontrada = null;
        for(Cuenta cuenta : cuentas){
            if(cuenta.getNumero().equals(numeroCuenta)){
                cuentaEncontrada = cuenta;
            }
        }
        return cuentaEncontrada;
    }
    
    public static Cliente encontrarCliente(ArrayList<Cliente>clientes, String dniBuscado){
        Cliente clienteEncontrado = null;
        for(Cliente cliente : clientes){
            if(cliente.getDNI().equals(dniBuscado)){
                clienteEncontrado = cliente;
            }
        }
        return clienteEncontrado;
    }
  
}
