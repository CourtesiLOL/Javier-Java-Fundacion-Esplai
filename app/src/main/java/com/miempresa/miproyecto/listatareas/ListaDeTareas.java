
package com.miempresa.miproyecto.listatareas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javier
 */
public class ListaDeTareas {

    
        public static void listaTareas(Scanner scaner) {        
        List<Tarea> listaTareas = new ArrayList();

        listaTareas.add(new Tarea("Colada", "Tender la colada"));
        listaTareas.add(new Tarea("Fregar", "Fregar los platos"));
        listaTareas.add(new Tarea("Barrer", "Barrer la casa"));
        listaTareas.add(new Tarea("Fregar", "Fregar el comedor"));
        listaTareas.add(new Tarea("Comida Perro", "Dar de comer al perro"));               
            
        boolean salir = false;

        System.out.println("Lista de tareas");
        System.out.println("---------------");

        while (!salir) {
            System.out.print(">");
            String userInput = scaner.nextLine();        
            String titulo,descripcion;

            switch (userInput.toLowerCase()) {
                case "mostrar":
                    for (Tarea t : listaTareas) {
                        System.out.println(t.toString());
                    }
                    break;

                case "añadir":

                    System.out.print("Titulo: ");
                    titulo = scaner.nextLine();
                    System.out.print("\nDescripcion: ");
                    descripcion = scaner.nextLine();
                    listaTareas.add(new Tarea(titulo,descripcion));
                    System.out.println(String.format("Tarea %s añadida correctamente", titulo));                
                    break;

                case "completar":
                    System.out.print("Titulo de la tarea: ");
                    titulo = scaner.nextLine();
                    for (Tarea t : listaTareas) {
                        if (!t.getTitulo().equalsIgnoreCase(titulo)) continue;

                        if (t.getEstado() == Estado.COMPLETADA) {
                            System.out.println("Ya estaba completada");
                            break;
                        }

                        t.completar();
                        System.out.println("Tarea completada correctamente");                    
                        break;


                    }
                    break;
                case "salir":
                    salir = true;
                    break;

                default:
                    System.out.println("Comando no reconocido. Comandos posibles:");
                    System.out.println(" - mostrar   → Lista todas las tareas.");
                    System.out.println(" - añadir    → Añade una nueva tarea.");
                    System.out.println(" - completar → Marca una tarea como completada.");
                    System.out.println(" - salir → salir de la lista de tareas");

            }
        }            
        

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
