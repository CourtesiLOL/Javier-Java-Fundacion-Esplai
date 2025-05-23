
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
        
        boolean salir = false;

        System.out.println("Gestor Contactos");
        System.out.println("----------------\n");

        operacionesPosibles();
        
        while (!salir) {
            System.out.print(">");
            String userInput = scaner.nextLine();
            String nombre;

            switch (userInput.toLowerCase()) {
                case "vercontactos":                    
                    agenda.mostrarContactos();                    
                    break;

                case "buscarcontacto":
                    System.out.print("Nombre: ");
                    nombre = scaner.nextLine();
                    System.out.println(agenda.buscar(nombre).toString());
                    break;
                    
                case "añadircontacto":
                    System.out.print("Nombre: ");
                    nombre = scaner.nextLine();
                    
                    System.out.print("\nEmail: ");
                    String email = scaner.nextLine();
                    
                    System.out.print("\nTelefono: ");
                    String telefono = scaner.nextLine();
                    
                    if (!Utils.esEnteroValido(telefono)) {
                        System.out.println("Telefono invalido");
                        break;
                    }
                    
                    agenda.agregar(new Contacto(nombre,Integer.parseInt(telefono), email));
                    System.out.println("Contacto "+nombre+" añadido correctamente");
                    break;
                    
                case "borrarcontacto":
                    
                    System.out.print("Nombre: ");
                    nombre = scaner.nextLine();
                    
                    Contacto contacto = agenda.buscar(nombre);
                    if (contacto == null) {
                        System.out.println("Error: contacto inexistente");
                        break;
                    }
                    
                    agenda.borrarContacto(contacto);
                    break;

                case "salir":
                    salir = true;
                    break;

                default:
                    System.out.println("Comando no reconocido. Comandos posibles:");
                    operacionesPosibles();
                    break;

            }
        }
        
    }
    
    public static void testGestorContactos() {
        Agenda agenda = new Agenda();

        System.out.println("Agregamos contactos\n");
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
    
    private static void operacionesPosibles() {
        System.out.println("Operaciones posibles\n");
        System.out.println(" - saldo   → Muestra el saldo actual de la cuenta");
        System.out.println(" - retirar    → Retirar dinero de tu cuenta");
        System.out.println(" - depositar → Depositar una cantidad de dinero");
        System.out.println(" - resumen → muestra el historial de operaciones");
        System.out.println(" - salir → salir del cajero");
    }
}
