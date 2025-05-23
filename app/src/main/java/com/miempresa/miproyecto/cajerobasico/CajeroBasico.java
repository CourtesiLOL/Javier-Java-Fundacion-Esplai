
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
        System.out.println("------\n");

        System.out.println("Bienvenido juan");
        System.out.println("---------------\n");
        System.out.println("Operaciones posibles\n");
        System.out.println(" - saldo   → Muestra el saldo actual de la cuenta");
        System.out.println(" - retirar    → Retirar dinero de tu cuenta");
        System.out.println(" - depositar → Depositar una cantidad de dinero");
        System.out.println(" - resumen → muestra el historial de operaciones");
        System.out.println(" - salir → salir del cajero");

        while (!salir) {
            System.out.print(">");
            String userInput = scaner.nextLine();
            double cantidad;

            switch (userInput.toLowerCase()) {
                case "saldo":
                    System.out.println(String.format("Saldo acutal: %s $", cuenta.consultarSaldo()));
                    break;

                case "retirar":
                    System.out.print("Cantidad a retirar: ");
                    cantidad = scaner.nextDouble();
                    scaner.nextLine();

                    if (cantidad <= 0) {
                        System.out.println("Cantidad de 0 o inferior no estan permitidos");
                        break;
                    }


                    if (cuenta.retirar(cantidad)) {
                        System.out.println("Retirada exitosa");
                        System.out.println("Saldo actual: "+cuenta.consultarSaldo());
                    } else {
                        System.out.println("Error: saldo insuficiente");
                        System.out.println("Saldo atual: "+cuenta.consultarSaldo());
                        System.out.println("Cantidad a retirar: "+cantidad);                            
                    }
                    break;

                case "depositar":
                    System.out.print("Cantidad: ");
                    cantidad = scaner.nextDouble();
                    scaner.nextLine();

                    if (cantidad <= 0) {
                        System.out.println("Cantidad de 0 o inferior no estan permitidos");
                        break;
                    }

                    cuenta.depositar(cantidad);
                    System.out.println("Deposito exitoso");
                    System.out.println("Saldo actual: "+cuenta.consultarSaldo());
                    break;
                case "resumen":
                    cuenta.resumenTransacciones();
                    break;

                case "salir":
                    salir = true;
                    break;

                default:
                    System.out.println("Comando no reconocido. Comandos posibles:");
                    System.out.println(" - saldo   → Muestra el saldo actual de la cuenta");
                    System.out.println(" - retirar    → Retirar dinero de tu cuenta");
                    System.out.println(" - depositar → Depositar una cantidad de dinero");
                    System.out.println(" - resumen → muestra el historial de operaciones");
                    System.out.println(" - salir → salir del cajero");
                    break;

            }
        }            
        
        
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
