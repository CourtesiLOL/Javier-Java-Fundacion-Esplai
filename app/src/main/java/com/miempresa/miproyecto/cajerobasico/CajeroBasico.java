
package com.miempresa.miproyecto.cajerobasico;

import java.util.Scanner;

/**
 *
 * @author javier
 */
public class CajeroBasico {

    
    public static void cajeroBasico(Scanner scaner) {
        var cuenta = new CuentaBancaria("Juan", 1256);
        boolean salir = false;

        System.out.println("Cajero");
        System.out.println("------");
        System.out.println("Bienvenido Juan\n");
        
        System.out.println("Comandos");
        mostrarComandos();

        while (!salir) {
            System.out.print(">");
            String userInput = scaner.nextLine().toLowerCase();

            switch (userInput) {
                case "saldo" -> mostrarSaldo(cuenta);
                case "retirar" -> retirarDinero(cuenta, scaner);
                case "depositar" -> depositarDinero(cuenta, scaner);
                case "resumen" -> cuenta.resumenTransacciones();
                case "salir" -> salir = true;
                default -> {
                    System.out.println("Comando no reconocido. Comandos posibles:");
                    mostrarComandos();
                }
            }
        }
    }

    private static void mostrarSaldo(CuentaBancaria cuenta) {
        System.out.printf("Saldo actual: %.2f $\n", cuenta.consultarSaldo());
    }

    private static void retirarDinero(CuentaBancaria cuenta, Scanner scaner) {
        System.out.print("Cantidad a retirar: ");
        double cantidad = scaner.nextDouble();
        scaner.nextLine();

        if (cantidad <= 0) {
            System.out.println("Cantidad de 0 o inferior no está permitida");
            return;
        }

        if (cuenta.retirar(cantidad)) {
            System.out.println("Retirada exitosa");
        } else {
            System.out.println("Error: saldo insuficiente");
        }
        System.out.printf("Saldo actual: %.2f $\n", cuenta.consultarSaldo());
    }

    private static void depositarDinero(CuentaBancaria cuenta, Scanner scaner) {
        System.out.print("Cantidad: ");
        double cantidad = scaner.nextDouble();
        scaner.nextLine();

        if (cantidad <= 0) {
            System.out.println("Cantidad de 0 o inferior no está permitida");
            return;
        }

        cuenta.depositar(cantidad);
        System.out.println("Depósito exitoso");
        System.out.printf("Saldo actual: %.2f $\n", cuenta.consultarSaldo());
    }

    private static void mostrarComandos() {
        System.out.println(" - saldo   → Muestra el saldo actual de la cuenta");
        System.out.println(" - retirar    → Retirar dinero de tu cuenta");
        System.out.println(" - depositar → Depositar una cantidad de dinero");
        System.out.println(" - resumen → Muestra el historial de operaciones");
        System.out.println(" - salir → Salir del cajero");
    }

    
    
    public static void testCajeroBasico() {
        CuentaBancaria cuenta = new CuentaBancaria("Javier", 5000d);
        System.out.println("Creacion de cuenta");
        System.out.println("Consultar saldo: " + cuenta.consultarSaldo());
        System.out.println("Varias operaciones despues...");

        cuenta.depositar(256);
        cuenta.retirar(499.99);
        cuenta.retirar(45.89);

        System.out.println("Consultar saldo: " + cuenta.consultarSaldo());
        System.out.println("Varias operaciones despues...");

        cuenta.depositar(2000);
        cuenta.retirar(9800);
        cuenta.retirar(2.50);

        System.out.println("Consultar saldo: " + cuenta.consultarSaldo());
        System.out.println("-------------------");
        System.out.println("Resumen de transacciones\n");
        cuenta.resumenTransacciones();
    }
    
}
