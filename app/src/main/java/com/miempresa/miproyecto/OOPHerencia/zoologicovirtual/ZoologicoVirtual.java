package com.miempresa.miproyecto.OOPHerencia.zoologicovirtual;

import com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas.Bebida;
import com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas.Refresco;
import com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas.Zumo;
import com.miempresa.miproyecto.OOPHerencia.zoologicovirtual.animales.Animal;
import com.miempresa.miproyecto.OOPHerencia.zoologicovirtual.animales.Gato;
import com.miempresa.miproyecto.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javier
 */
public class ZoologicoVirtual {

    public static void ZoologicoVirtual(Scanner scaner) {
        List<Animal> animales = new ArrayList();

        System.out.println("Menu Sonidos de animales");
        System.out.println("-------------------\n");

        System.out.println("Comandos");
        mostrarComandos();
        
        boolean salir = false;
        while (!salir) {
           
            System.out.print("\n> ");
            String option = scaner.nextLine();

            switch (option.toLowerCase()) {
                case "listarAnimales" -> listarAnimales(animales);
                case "añadirAnimal" -> añadirAnimal(scaner,animales);
                case "borrarAnimal" -> borrarAnimal(scaner, animales);
                case "hacerSonido" -> hacerSonido(animales);
                case "salir" -> salir = true;
                default -> {
                    System.out.println(String.format("La opcion %s no existe", option));
                    mostrarComandos();
                }
            }   
            
        }
        
    }
    
    
    private static void listarAnimales(List<Animal> animales) {
        System.out.println("Animales");
        System.out.println("--------");
        if (animales.isEmpty()) System.out.println("No hay ninguna");        
        animales.forEach(a -> System.out.println(a.getName()));
        System.out.println("\n");
    }
    
    private static boolean añadirAnimal(Scanner scaner, List<Animal> animales) {
        
        String tempStr;   
        
        System.out.print("Tipo(Gato, Perro o Pajaro): ");
        tempStr = scaner.nextLine();
        tempStr = tempStr.toLowerCase();
        
        if (!tempStr.equals("gato") && !tempStr.equals("perro") && !tempStr.equals("pajaro")) {
            System.out.println("Error: %s no es un animal valido".formatted(tempStr));
            return false;
        }

        System.out.print("\nNombre: ");
        String nombre = scaner.nextLine();
        
        System.out.print("\nEdad: ");
        String edadStr = scaner.nextLine();
        if (!Utils.esEnteroValido(edadStr)) {
            System.out.println("Error: Edad invalida, pon un numero entero");
            return false;
        }
        int edad = Integer.parseInt(edadStr);
        
        
        switch (tempStr) {
            case "gato"-> animales.add(new Gato(nombre,edad));
            case "perro"-> animales.add(new Gato(nombre,edad));
            case "pajaro"-> animales.add(new Gato(nombre,edad));
        }
        System.out.println("Animal añadido correctamente");
        return true;
        
    }
    
    private static boolean borrarAnimal(Scanner scaner, List<Animal> animales) {
        System.out.print("Nombre: ");
        String nombre = scaner.nextLine();
        
        Animal animal = getAnimal(nombre, animales);
        if (animal == null) {
            System.out.println("El animal %s no existe".formatted(nombre));
            return false;
        }
        
        animales.remove(animal);
        System.out.println("Animal borrado correctamente");
        return true;
        
    }
    
    private static Animal getAnimal(String nombre, List<Animal> animales) {
        for (Animal animalTemp : animales) {
            if (animalTemp.getName().equals(nombre)) {
               return animalTemp;
            }
        }
        
        return null;
    }
    
    private static void hacerSonido(List<Animal> animales) {
        System.out.println("Sonidos");
        System.out.println("-------");
        
        animales.forEach(a -> a.hacerSonido());
        
    }
    
    private static void mostrarComandos() {        
        System.out.println(" - ListarAnimales  → Lista todas las animales y sus atributos.");
        System.out.println(" - AñadirAnimal    → Añade un nuevo animal");
        System.out.println(" - BorrarAnimal → Borra una animal");
        System.out.println(" - Salir     → Salir de la lista de tareas");
    }
}
