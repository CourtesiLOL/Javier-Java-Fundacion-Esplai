
package com.miempresa.miproyecto.OOP.gestorpersonas;

import com.miempresa.miproyecto.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javier
 */
public class GestorPersona {
    
    public static void gestorPersonas(Scanner scaner) {

        List<Persona> personas = new ArrayList<>();
        generatePersonas(personas);

        boolean salir = false;
        System.out.println("Gestor Personas");
        System.out.println("---------------\n");

        System.out.println("Comandos");
        showOptions();

        while (!salir) {
            System.out.print(">");
            String userInput = scaner.nextLine().toLowerCase();

            switch (userInput) {
                case "listarpersonas" -> listarPersonas(personas);
                case "crearpersona" -> crearPersona(scaner, personas);
                case "eliminarpersona" -> eliminarPersona(scaner, personas);
                case "actualizarpersona" -> actualizarPersona(scaner, personas);
                case "salir" -> salir = true;
                default -> {
                    System.out.println("Comando no reconocido. Comandos posibles:");
                    showOptions();
                }
            }
        }
    }
    
    public static void testGestorPersonas() {

        Persona pepe = new Persona("pepe", 45, "pepe@gmail.com");
        Persona maria = new Persona("maria", 34, "maria@gmail.com");
        Persona juan = new Persona("juan", 12, "juan@gmail.com");
        Persona noa = new Persona("noa", 87, "noa@gmail.com");
        Persona pol = new Persona("pol", 4, "pol@gmail.com");
        Persona prueba = new Persona("prueba", 4, "pinPon.com");

        System.out.println("Personas");
        System.out.println("--------\n");

        System.out.println(pepe.toString());
        System.out.println("................");
        System.out.println(maria.toString());
        System.out.println("................");
        System.out.println(juan.toString());
        System.out.println("................");
        System.out.println(noa.toString());
        System.out.println("................");
        System.out.println(pol.toString());
        System.out.println("................");
        System.out.println(prueba.toString());
        System.out.println("................");

    }

    private static void listarPersonas(List<Persona> personas) {
        for (Persona p : personas) {
            System.out.println(p);
        }
    }

    private static void crearPersona(Scanner scaner, List<Persona> personas) {
        System.out.print("Nombre: ");
        String nombre = scaner.nextLine();

        Persona personaTemp = searchPersona(personas, nombre);
        if (personaTemp != null) {
            System.out.println("Ya existe esa persona");
            return;
        }

        System.out.print("Edad: ");
        String edad = scaner.nextLine();
        if (!Utils.esEnteroValido(edad)) {
            System.out.println(edad + " no es un número válido");
            return;
        }

        System.out.print("Email: ");
        String correo = scaner.nextLine();

        int edadNum = Integer.parseInt(edad);
        personaTemp = new Persona(nombre, edadNum, correo);
        if (!personaTemp.correoValido()) {
            System.out.println(correo + " no es un correo válido");
            return;
        }

        personas.add(personaTemp);
        System.out.println("Persona creada correctamente");
    }

    private static void eliminarPersona(Scanner scaner, List<Persona> personas) {
        System.out.print("Nombre: ");
        String nombre = scaner.nextLine();
        Persona personaTemp = searchPersona(personas, nombre);

        if (personaTemp == null) {
            System.out.println("La persona " + nombre + " no existe");
            return;
        }

        personas.remove(personaTemp);
        System.out.println("Eliminada correctamente");
    }

    private static void actualizarPersona(Scanner scaner, List<Persona> personas) {
        System.out.print("Nombre: ");
        String nombre = scaner.nextLine();
        Persona personaTemp = searchPersona(personas, nombre);

        if (personaTemp == null) {
            System.out.println("No existe esa persona");
            return;
        }

        System.out.print("Edad: ");
        String edad = scaner.nextLine();
        if (!Utils.esEnteroValido(edad)) {
            System.out.println(edad + " no es un número válido");
            return;
        }

        System.out.print("Email: ");
        String correo = scaner.nextLine();

        int edadNum = Integer.parseInt(edad);
        if (!new Persona(nombre, edadNum, correo).correoValido()) {
            System.out.println(correo + " no es un correo válido");
            return;
        }

        personaTemp.setNombre(nombre);
        personaTemp.setCorreo(correo);
        personaTemp.setEdad(edadNum);

        System.out.println("Datos actualizados correctamente");
    }

        
    
    private static void generatePersonas(List<Persona> personas) {
        personas.add(new Persona("Ana", 28, "ana28@gmail.com"));
        personas.add(new Persona("Luis", 35, "luis35@hotmail.com"));
        personas.add(new Persona("Marta", 22, "marta22@yahoo.com"));
        personas.add(new Persona("Carlos", 41, "carlos41@gmail.com"));
        personas.add(new Persona("Sofía", 30, "sofia30@outlook.com"));
    }    
    private static Persona searchPersona(List<Persona> personas, String name) {
        for (Persona persona : personas) {
            if (persona.getNombre().equalsIgnoreCase(name)) {
                return persona;
            }
        }
        return null;
    }
    private static void showOptions() {
        System.out.println(" - ListarPersonas   → Lista todas las personas");
        System.out.println(" - CrearPersona    → Crea una nueva persona");
        System.out.println(" - EliminarPersona    → Elimina a una persona");
        System.out.println(" - ActualizarPersona    → Actualiza los valores de una persona");
        System.out.println(" - Salir            → Salir del programa");
        
    }
}
