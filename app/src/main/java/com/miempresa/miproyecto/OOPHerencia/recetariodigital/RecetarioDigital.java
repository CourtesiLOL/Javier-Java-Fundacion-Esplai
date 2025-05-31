package com.miempresa.miproyecto.OOPHerencia.recetariodigital;

import com.miempresa.miproyecto.OOPHerencia.recetariodigital.recetas.Receta;
import com.miempresa.miproyecto.OOPHerencia.recetariodigital.recetas.RecetaDulce;
import com.miempresa.miproyecto.OOPHerencia.recetariodigital.recetas.RecetaSalada;
import com.miempresa.miproyecto.Utils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javier
 */
public class RecetarioDigital {
    private static Recetario recetario = new Recetario();

    public static void recetarioDigital(Scanner scaner) {
        
        
        datosFalsos();

        System.out.println("Recetario digital");
        System.out.println("-----------------\n");

        System.out.println("Comandos");
        mostrarComandos();
        
        boolean salir = false;
        while (!salir) {
           
            System.out.print("\n> ");
            String option = scaner.nextLine();

            switch (option.toLowerCase())       {
                case "resumenrecetas" -> resumenRecetas();
                case "detallesreceta" -> detallesReceta(scaner);
                case "añadirreceta" -> añadirReceta(scaner);
                case "borrarreceta" -> borrarReceta(scaner);
                case "salir" -> salir = true;
                default -> {
                    System.out.println(String.format("La opcion %s no existe", option));
                    mostrarComandos();
                }
            }   
            
        }
    }
    
    private static void resumenRecetas() {
        System.out.println("Lista de recetas resumida");
        System.out.println("-------------------------");
        System.out.println();
        recetario.printResumido();
    }
    
    private static void detallesReceta(Scanner scaner) {
        System.out.print("Nombre de la receta: ");
        String nombre = scaner.nextLine();
        System.out.println();
        System.out.println("Detalles de la receta");
        System.out.println("---------------------\n");
        boolean result = recetario.mostrarReceta(nombre);
        if (!result) {
            System.out.println("No existe tal receta");
        }
    }
    
    private static void añadirReceta(Scanner scaner) {
        System.out.println("Tipo de receta");
        System.out.println("1. Dulce");
        System.out.println("2. Salado");
        
        String option = scaner.nextLine();
        switch(option.trim()) {
            case "1" -> crearReceta(RecetaDulce.class,scaner);
            case "2" -> crearReceta(RecetaSalada.class,scaner);
            default -> {
                System.out.println("Error: esa opcion no existe");
                return;
            }
        }
                
        System.out.println("Receta añadidad correctamente");
    }
    
    private static void borrarReceta(Scanner scaner) {
        System.out.print("Nombre: ");
        String nombre = scaner.nextLine();
        
        Receta receta = recetario.obtenerReceta(nombre);
        if (receta == null) {
            System.out.println("Error: receta inexistente");
            return;
        }
        
        recetario.borrarReceta(receta);
        System.out.println("Receta borrada correctamente");
        
        
    }
    
    public static void crearReceta(Class<? extends Receta> clase, Scanner scaner) {
        String nombre;
        List<Ingrediente> ingredientes = new ArrayList();
        List<String> pasos = new ArrayList();
        
        boolean salir = false;
        
        System.out.print("Nombre de la receta: ");
        nombre = scaner.nextLine();
        System.out.println();
        
        int count = 1;
        int  cantidad;
        
        String ingNombre;
        String strCantidad;        
        String unidad;
        String paso;
        
        
        System.out.println("Poner . para terminar de añadir ingredientes");
        System.out.println("--------------------------------------------\n");
        while (!salir) {
            System.out.println("Ingrediente "+count);
            
            System.out.print("Nombre: ");
            ingNombre = scaner.nextLine();
            System.out.println();
            
            if (ingNombre.equals(".")) {
                salir = true;
                continue;
            }
            
            System.out.print("Cantidad: ");
            strCantidad = scaner.nextLine();
            System.out.println();
            
            if (!Utils.esEnteroValido(strCantidad)) {
                System.out.println("Error: tiene que ser una valor entero");
                continue;
            }
            cantidad = Integer.parseInt(strCantidad);
            
            System.out.print("Unidad: ");
            unidad = scaner.nextLine();  
            System.out.println();
            
            ingredientes.add(new Ingrediente(ingNombre, cantidad, unidad));
            System.out.println();
            count++;
            
        }
        
        salir = false;
        count = 1;
        
        System.out.println("Poner . para terminar de añadir Pasos");
        System.out.println("-------------------------------------\n");
        while (!salir) {
            System.out.print("Paso %d:".formatted(count));
            paso = scaner.nextLine();            
            
            if (paso.isBlank()) {
                System.out.println("Error: paso en blanco");
                continue;
            }
            
            if (paso.equals(".")) {
                salir = true;
                continue;
            }
            
            pasos.add(paso);
            count++;

        }
        
        recetario.agregarReceta(InstanciarReceta(clase, nombre, ingredientes, pasos));     
        
    }
    
    private static Receta InstanciarReceta(Class<? extends Receta> clase, String nombre, List<Ingrediente> ingredientes, List<String> pasos) {
            
        try {
            //Crea una instancia de la receta adecuada y la retorna
            Constructor<? extends Receta> constructor = clase.getConstructor(String.class, List.class, List.class);
            return constructor.newInstance(nombre, ingredientes, pasos);
        } catch (NoSuchMethodException |InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            return null;
        }

    }
    
    private static void mostrarComandos() {
        System.out.println(" - ResumenRecetas  → Lista todas las recetas de forma resumida");
        System.out.println(" - DetallesReceta    → Muesta los detalles de una receta en concreta");
        System.out.println(" - AñadirReceta  → Te permtie crear y añadir una receta");
        System.out.println(" - BorrarReceta → Te permite borrar una receta por su nombre");
        System.out.println(" - Salir     → Salir del sistema de entradas");
    }
    
    private static void datosFalsos() {
        
        Receta receta;
        List<Ingrediente> ingredientes = new ArrayList();
        List<String> pasos = new ArrayList();
        
        ingredientes.add(new Ingrediente("Pan", 1, "entero"));
        ingredientes.add(new Ingrediente("Queso", 250, "gramos"));
        
        pasos.add("Corta el pan en rebanadas");
        pasos.add("Poner el queso");
        pasos.add("Gratinar en el horno/microondas");
        
        receta = new RecetaSalada(
                "Pan y queso",
                ingredientes,
                pasos
        );
        
        recetario.agregarReceta(receta);        
        ingredientes.clear();
        pasos.clear();
        
        ingredientes.add(new Ingrediente("Tortilla de maíz", 3, "piezas"));
        ingredientes.add(new Ingrediente("Frijoles refritos", 200, "gramos"));
        ingredientes.add(new Ingrediente("Queso fresco", 100, "gramos"));

        pasos.add("Calienta las tortillas en un comal");
        pasos.add("Unta los frijoles sobre las tortillas calientes");
        pasos.add("Espolvorea el queso fresco encima");

        receta = new RecetaSalada(
                "Tacos de frijoles",
                ingredientes,
                pasos
        );

        recetario.agregarReceta(receta);
        ingredientes.clear();
        pasos.clear();

        ingredientes.add(new Ingrediente("Arroz", 1, "taza"));
        ingredientes.add(new Ingrediente("Zanahoria", 1, "pieza"));
        ingredientes.add(new Ingrediente("Chícharos", 100, "gramos"));
        ingredientes.add(new Ingrediente("Soya", 2, "cucharadas"));

        pasos.add("Cocina el arroz hasta que esté listo");
        pasos.add("Pica la zanahoria y agrégala al arroz con los chícharos");
        pasos.add("Añade la soya y saltea por unos minutos");

        receta = new RecetaSalada(
                "Arroz frito vegetariano",
                ingredientes,
                pasos
        );

        recetario.agregarReceta(receta);
        ingredientes = null;
        pasos = null;
        
    }
    
}
