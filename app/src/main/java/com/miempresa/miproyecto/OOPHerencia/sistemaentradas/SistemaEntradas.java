package com.miempresa.miproyecto.OOPHerencia.sistemaentradas;

import com.miempresa.miproyecto.OOPHerencia.sistemaentradas.Entradas.Entrada;
import com.miempresa.miproyecto.OOPHerencia.sistemaentradas.Entradas.EntradaConDescuento;
import com.miempresa.miproyecto.OOPHerencia.sistemaentradas.Entradas.EntradaEstandar;
import com.miempresa.miproyecto.OOPHerencia.sistemaentradas.Entradas.EntradaVIP;
import com.miempresa.miproyecto.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javier
 */
public class SistemaEntradas {
    public static void sistemaEntradas(Scanner scaner) {
        List<Entrada> entradas = new ArrayList();
        
        datosFalsos(entradas);

        System.out.println("Sistema de entradas");
        System.out.println("-------------------\n");

        System.out.println("Comandos");
        mostrarComandos();
        
        boolean salir = false;
        while (!salir) {
           
            System.out.print("\n> ");
            String option = scaner.nextLine();

            switch (option.toLowerCase())       {
                case "verentradas" -> verEntradas(entradas);
                case "añadirentrada" -> añadirEntradas(scaner,entradas);
                case "borrarentrada" -> borrarEntradas(scaner, entradas);
                case "salir" -> salir = true;
                default -> {
                    System.out.println(String.format("La opcion %s no existe", option));
                    mostrarComandos();
                }
            }   
            
        }
    }
    
    private static void verEntradas(List<Entrada> entradas) {
        System.out.println("Lista de entradas");
        System.out.println("-----------------");
        entradas.forEach(e -> System.out.println(e.toString()));
        System.out.println();
    }
    
    private static void añadirEntradas(Scanner scaner, List<Entrada> entradas) {
        String temp;
        
        System.out.println("Tipo de entrada");
        System.out.println("1.Entrada Estandar");
        System.out.println("2.Entrada Vip");
        System.out.println("3.Entrada con descuento");
        System.out.print("> ");
        temp = scaner.nextLine();
        
        
        if (!Utils.esEnteroValido(temp)) {
            System.out.println("Error: no es un numero valido");
            return;
        }
        int opcion = Integer.parseInt(temp);
        

        double precio;
        int porcentaje;
        String evento;
        
        switch(opcion) {
            case 1 -> {
                System.out.print("Nombre evento: ");
                evento = scaner.nextLine();
                
                System.out.println();
                System.out.print("Precio: ");
                precio = scaner.nextDouble();
                
                entradas.add(new EntradaEstandar(evento, precio));
            }
            case 2 -> {
                System.out.print("Nombre evento: ");
                evento = scaner.nextLine();
                
                System.out.println();
                System.out.print("Precio: ");
                precio = scaner.nextDouble();
                scaner.nextLine();
                
                System.out.println();
                System.out.print("Porcentaje extra: ");
                porcentaje = scaner.nextInt();
                scaner.nextLine();
                
                entradas.add(new EntradaVIP(evento, precio, (porcentaje / 1000)));
            }
            case 3 -> {
                System.out.print("Nombre evento: ");
                evento = scaner.nextLine();
                
                System.out.println();
                System.out.print("Precio: ");
                precio = scaner.nextDouble();
                scaner.nextLine();
                
                System.out.println();
                System.out.print("Porcentaje descuento(entre 1% a 100%): ");
                porcentaje = scaner.nextInt();
                scaner.nextLine();
                
                entradas.add(new EntradaConDescuento(evento, precio, (porcentaje / 1000)));
            }
            
            default -> {
                System.out.println("Error: entrada desconocida");
                return;
            }
        }
        
        System.out.println("Entrada creada y añadidad correctamente");
        
        
    }    
    
    private static void borrarEntradas(Scanner scaner, List<Entrada> entradas) {
        
        System.out.print("Nombre evento: ");
        String evento = scaner.nextLine();
        Entrada temp = getEntrada(evento, entradas);
        if (temp == null) {
            System.out.println("Error: No exite ninguna entrada con ese evento");
            return;
        }
        
        entradas.remove(temp);
        System.out.println("Entrada borrada correctamente");
    }
    
    private static Entrada getEntrada(String evento, List<Entrada> entradas) {
        for (Entrada e : entradas) {
            if (e.getEvento().equalsIgnoreCase(evento)) {
                return e;
            }
        }
        return null;
    }
    
    
    private static void mostrarComandos() {
        System.out.println(" - VerEntradas  → Ver todas las entradas y su informacion");
        System.out.println(" - AñadirEntrada    → Añade una nueva entrada a la lista");
        System.out.println(" - BorrarEntrada → borrar una netrada de la lista por nombre de evento");
        System.out.println(" - Salir     → Salir del sistema de entradas");
    }
    
    private static void datosFalsos(List<Entrada> entradas) {
        entradas.add(new EntradaEstandar("Metallica", 150));
        entradas.add(new EntradaEstandar("Queen", 140));

        entradas.add(new EntradaVIP("Iron Maiden", 180, 0.25));
        entradas.add(new EntradaVIP("Guns N' Roses", 200, 0.20));

        entradas.add(new EntradaConDescuento("Red Hot Chili Peppers", 160, 0.15));
        entradas.add(new EntradaConDescuento("The Rolling Stones", 170, 0.10));
    }
}
