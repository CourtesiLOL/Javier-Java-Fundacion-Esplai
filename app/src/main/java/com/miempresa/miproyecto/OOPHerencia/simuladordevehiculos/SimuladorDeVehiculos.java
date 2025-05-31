/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos;

import com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos.vehiculos.Bicicleta;
import com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos.vehiculos.Coche;
import com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos.vehiculos.Moto;
import com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos.vehiculos.Vehiculo;
import com.miempresa.miproyecto.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javier
 */
public class SimuladorDeVehiculos {
    
    public static void simuladorDeVehiculos(Scanner scaner) {
        List<Vehiculo> vehiculos = new ArrayList();

        System.out.println("Menu Simulador de Vehiculos");
        System.out.println("-------------------\n");

        System.out.println("Comandos");
        mostrarComandos();
        
        boolean salir = false;
        while (!salir) {
           
            System.out.print("\n> ");
            String option = scaner.nextLine();

            switch (option.toLowerCase())       {
                case "listarvehiculos" -> listarVehiculoes(vehiculos);
                case "añadirvehiculo" -> añadirVehiculo(scaner,vehiculos);
                case "borrarvehiculo" -> borrarVehiculo(scaner, vehiculos);
                case "arrancarvehiculos" -> arrancarVehiculos(vehiculos);
                case "detenervehiculos" -> detenerVehiculos(vehiculos);
                case "salir" -> salir = true;
                default -> {
                    System.out.println(String.format("La opcion %s no existe", option));
                    mostrarComandos();
                }
            }   
            
        }
    }
    
    private static void listarVehiculoes(List<Vehiculo> vehiculos) {
        System.out.println("vehiculos");
        System.out.println("--------");
        if (vehiculos.isEmpty()) System.out.println("No hay ningun vehiculo");     
        vehiculos.forEach(a -> System.out.println(a.getMarca()));
        System.out.println("\n");
    }    
    
    private static boolean añadirVehiculo(Scanner scaner, List<Vehiculo> vehiculos) {
        
        String tempStr;   
        
        System.out.print("Tipo(Coche, Moto o Bicicleta): ");
        tempStr = scaner.nextLine();       
        tempStr = tempStr.toLowerCase();
        System.out.println("Input vehiculo: ");
        
        if (!tempStr.equals("coche") && !tempStr.equals("moto") && !tempStr.equals("bicicleta")) {
            System.out.println("Error: %s no es un vehiculo valido".formatted(tempStr));
            return false;
        }

        System.out.print("\nMarca: ");
        String nombre = scaner.nextLine();
        
        System.out.print("\nEdad: ");
        String edadStr = scaner.nextLine();
        if (!Utils.esEnteroValido(edadStr)) {
            System.out.println("Error: Edad invalida, pon un numero entero");
            return false;
        }
        int edad = Integer.parseInt(edadStr);
        
        
        switch (tempStr) {
            case "coche"-> vehiculos.add(new Coche(nombre,edad));
            case "moto"-> vehiculos.add(new Moto(nombre,edad));
            case "bicicleta"-> vehiculos.add(new Bicicleta(nombre,edad));
        }
        System.out.println("Vehiculo añadido correctamente");
        return true;
        
    }
    
    private static boolean borrarVehiculo(Scanner scaner, List<Vehiculo> vehiculos) {
        System.out.print("Marca: ");
        String nombre = scaner.nextLine();
        
        Vehiculo vehiculo = getVehiculo(nombre, vehiculos);
        if (vehiculo == null) {
            System.out.println("El vehiculo %s no existe".formatted(nombre));
            return false;
        }
        
        vehiculos.remove(vehiculo);
        System.out.println("vehiculo borrado correctamente");
        return true;
        
    }
    
    private static void arrancarVehiculos(List<Vehiculo> vehiculos) {
        System.out.println("Arrancando los Vehiculos");
        System.out.println("------------------------");
        if (vehiculos.isEmpty()) System.out.println("No hay ningun vehiculo");
        vehiculos.forEach(v -> v.arrancar());
    }
    
    private static void detenerVehiculos(List<Vehiculo> vehiculos) {
        System.out.println("Deteniendo los Vehiculos");
        System.out.println("------------------------");
        if (vehiculos.isEmpty()) System.out.println("No hay ningun vehiculo");
        vehiculos.forEach(v -> v.detener()); 
    }
    
    private static Vehiculo getVehiculo(String nombre, List<Vehiculo> vehiculos) {
        for (Vehiculo vehiculoTemp : vehiculos) {
            if (vehiculoTemp.getMarca().equals(nombre)) {
               return vehiculoTemp;
            }
        }
        
        return null;
    }
    
    private static void mostrarComandos() {        
        System.out.println(" - ListarVehiculos  → Lista todas las Vehiculos y sus atributos.");
        System.out.println(" - AñadirVehiculo    → Añade un nuevo Vehiculo");
        System.out.println(" - BorrarVehiculo → Borra una Vehiculo");
        System.out.println(" - ArrancarVehiculos → Arranca todos los Vehiculos");
        System.out.println(" - DetenerVehiculos → Detiene todos los Vehiculos");
        System.out.println(" - Salir     → Salir de la lista de tareas");
    }
    
}
