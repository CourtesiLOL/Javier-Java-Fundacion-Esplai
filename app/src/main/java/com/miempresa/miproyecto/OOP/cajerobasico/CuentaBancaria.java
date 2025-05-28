
package com.miempresa.miproyecto.OOP.cajerobasico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javier
 */
public class CuentaBancaria {

    private String titular;
    private double saldo;
    private List<String> transacciones;

    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        this.transacciones = new ArrayList();
    }
    
    
    public String getTitular() {
        return this.titular;
    }
    
    public double consultarSaldo() {
        return this.saldo;
    }
    
    public void depositar(double cantidad) {
        saldo += cantidad;
        transacciones.add("Deposito: "+cantidad+"$");        
    }
    
    public boolean retirar(double cantidad) {
        if (saldo - cantidad < 0) {
            transacciones.add("Error retirada "+ cantidad+ "$ saldo insuficiente");
            return false;
        }
        saldo -= cantidad;
        transacciones.add("Retirada: "+cantidad+"$");
        return true;
    }
    
    
    public void resumenTransacciones() {
        for (String str : transacciones) {
            System.out.println(str);
        }
        System.out.println("-----------");
        System.out.println("Saldo actual: "+saldo+"$");
    }
    
    
    
    
}
