
package com.miempresa.miproyecto.gestorcontactos;

import com.miempresa.miproyecto.Utils;
import java.util.Scanner;

/**
 *
 * @author javier
 */
public class GestorContactos {
    
    public static void gestorContactos(Scanner scaner) {

        Agenda agenda = new Agenda();
        llenarAgenda(agenda);

        boolean salir = false;

        System.out.println("Gestor Contactos");
        System.out.println("----------------\n");

        System.out.println("Comandos");
        operacionesPosibles();

        while (!salir) {
            System.out.print(">");
            String userInput = scaner.nextLine().toLowerCase();

            switch (userInput) {
                case "vercontactos" ->
                    agenda.mostrarContactos();
                case "buscarcontacto" ->
                    buscarContacto(scaner, agenda);
                case "añadircontacto" ->
                    añadirContacto(scaner, agenda);
                case "borrarcontacto" ->
                    borrarContacto(scaner, agenda);
                case "salir" ->
                    salir = true;
                default -> {
                    System.out.println("Comando no reconocido. Comandos posibles:");
                    operacionesPosibles();
                }
            }
        }
    }

    private static void buscarContacto(Scanner scaner, Agenda agenda) {
        System.out.print("Nombre: ");
        String nombre = scaner.nextLine();
        Contacto contacto = agenda.buscar(nombre);
        if (contacto != null) {
            System.out.println(contacto);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    private static void añadirContacto(Scanner scaner, Agenda agenda) {
        System.out.print("Nombre: ");
        String nombre = scaner.nextLine();

        System.out.print("Email: ");
        String email = scaner.nextLine();

        System.out.print("Telefono: ");
        String telefono = scaner.nextLine();

        if (!Utils.esEnteroValido(telefono)) {
            System.out.println("Telefono invalido");
            return;
        }

        agenda.agregar(new Contacto(nombre, Integer.parseInt(telefono), email));
        System.out.println("Contacto " + nombre + " añadido correctamente");
    }

    private static void borrarContacto(Scanner scaner, Agenda agenda) {
        System.out.print("Nombre: ");
        String nombre = scaner.nextLine();

        Contacto contacto = agenda.buscar(nombre);
        if (contacto == null) {
            System.out.println("Error: contacto inexistente");
            return;
        }

        agenda.borrarContacto(contacto);
        System.out.println("Contacto borrado correctamente");
    }

    public static void testGestorContactos() {
        Agenda agenda = new Agenda();

        llenarAgenda(agenda);

        Contacto laura = agenda.buscar("Laura");
        System.out.println("Buscando laura");
        if (laura != null) {
            System.out.println("Contacto encontrado");
            System.out.println("-------------------");
            System.out.println(laura.toString());
        } else {
            System.out.println("Laura no existe");
        }

        agenda.mostrarContactos();

    }
    private static void llenarAgenda(Agenda agenda) {
        agenda.agregar(new Contacto("Carlos", 612345678, "carlos@mail.com"));
        agenda.agregar(new Contacto("Lucía", 698745123, "lucia@hotmail.com"));
        agenda.agregar(new Contacto("Pedro", 634567890, "pedro@gmail.com"));
        agenda.agregar(new Contacto("Ana", 622334455, "ana@yahoo.com"));
        agenda.agregar(new Contacto("Javier", 677889900, "javier@outlook.com"));
        agenda.agregar(new Contacto("Sofía", 699123456, "sofia@mail.com"));
        agenda.agregar(new Contacto("Sofía", 699123456, "sofia@mail.com"));
        agenda.agregar(new Contacto("Sofía", 699123456, "sofia@mail.com"));
        agenda.agregar(new Contacto("Diego", 655443322, "diego@gmail.com"));
        agenda.agregar(new Contacto("Laura", 688776655, "laura@hotmail.com"));
        agenda.agregar(new Contacto("Andrés", 611223344, "andres@yahoo.com"));
        agenda.agregar(new Contacto("Valeria", 697788990, "valeria@outlook.com"));
    }
    
    private static void operacionesPosibles() {
        System.out.println(" - VerContactos     → Muestra todos los contactos");
        System.out.println(" - BuscarContacto   → Busca un contacto por su nombre");
        System.out.println(" - AñadirContacto   → Añade un nuevo contacto");
        System.out.println(" - BorrarContacto   → Elimina un contacto existente");
        System.out.println(" - Salir            → Salir del gestor de contactos");
    }
    
    
    
}
