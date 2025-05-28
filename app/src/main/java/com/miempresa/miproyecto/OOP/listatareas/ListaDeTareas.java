
package com.miempresa.miproyecto.OOP.listatareas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javier
 */
public class ListaDeTareas {       
    
    public static void listaTareas(Scanner scanner) {
        List<Tarea> listaTareas = new ArrayList<>();

        listaTareas.add(new Tarea("Colada", "Tender la colada"));
        listaTareas.add(new Tarea("Fregar", "Fregar los platos"));
        listaTareas.add(new Tarea("Barrer", "Barrer la casa"));
        listaTareas.add(new Tarea("Fregar", "Fregar el comedor"));
        listaTareas.add(new Tarea("Comida Perro", "Dar de comer al perro"));

        boolean salir = false;

        System.out.println("Lista de tareas");
        System.out.println("---------------\n");
        System.out.println("Comandos");
        mostrarComandos();

        while (!salir) {
            System.out.print(">");
            String userInput = scanner.nextLine();

            switch (userInput.toLowerCase()) {
                case "mostrar" -> mostrarTareas(listaTareas);
                case "añadir" -> añadirTarea(scanner, listaTareas);
                case "completar" -> completarTarea(scanner, listaTareas);
                case "salir" -> salir = true;
                default -> {
                    System.out.println("Comando no reconocido. Comandos posibles:");
                    mostrarComandos();
                }
            }
        }
    }

    private static void mostrarTareas(List<Tarea> listaTareas) {
        for (Tarea t : listaTareas) {
            System.out.println(t);
        }
    }

    private static void añadirTarea(Scanner scanner, List<Tarea> listaTareas) {
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();

        listaTareas.add(new Tarea(titulo, descripcion));
        System.out.printf("Tarea %s añadida correctamente%n", titulo);
    }

    private static void completarTarea(Scanner scanner, List<Tarea> listaTareas) {
        System.out.print("Titulo de la tarea: ");
        String titulo = scanner.nextLine();

        for (Tarea t : listaTareas) {
            if (!t.getTitulo().equalsIgnoreCase(titulo)) continue;

            if (t.getEstado() == Estado.COMPLETADA) {
                System.out.println("Ya estaba completada");
            } else {
                t.completar();
                System.out.println("Tarea completada correctamente");
            }
            return;
        }
        System.out.println("No se encontró una tarea con ese título.");
    }

    private static void mostrarComandos() {        
        System.out.println(" - Mostrar   → Lista todas las tareas.");
        System.out.println(" - Añadir    → Añade una nueva tarea.");
        System.out.println(" - Completar → Marca una tarea como completada.");
        System.out.println(" - Salir     → Salir de la lista de tareas");
    }

    
    private static void testListaTareas() {
        List<Tarea> listaTareas = new ArrayList();

        listaTareas.add(new Tarea("Colada", "Tender la colada"));
        listaTareas.add(new Tarea("Fregar", "Fregar los platos"));
        listaTareas.add(new Tarea("Barrer", "Barrer la casa"));
        listaTareas.add(new Tarea("Fregar", "Fregar el comedor"));
        listaTareas.add(new Tarea("Comida Perro", "Dar de comer al perro"));

        for (Tarea tarea : listaTareas) {
            System.out.println(tarea.toString() + "\n");
            tarea.completar();
        }
        System.out.println("----------------");
        Tarea.tareasCompletadas();
        Tarea.tareasPendiente();
        System.out.println("Inserto 2 tareas mas");
        System.out.println("----------------");

        listaTareas.add(new Tarea("Java", "Hacer los ejercicios de java"));
        listaTareas.add(new Tarea("Comprar", "Ir a comprar al mercadona"));

        for (Tarea tarea : listaTareas) {
            System.out.println(tarea.toString() + "\n");
        }

        System.out.println("----------------");
        Tarea.tareasCompletadas();
        Tarea.tareasPendiente();
        System.out.println("----------------");
    }
}
