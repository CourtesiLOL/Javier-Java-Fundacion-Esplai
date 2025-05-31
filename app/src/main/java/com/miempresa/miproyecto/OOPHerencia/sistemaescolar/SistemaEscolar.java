package com.miempresa.miproyecto.OOPHerencia.sistemaescolar;

import com.miempresa.miproyecto.OOPHerencia.sistemaescolar.Personas.Estudiante;
import com.miempresa.miproyecto.OOPHerencia.sistemaescolar.Personas.Profesor;
import com.miempresa.miproyecto.Utils;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author javier
 */
public class SistemaEscolar {
    
    public static void sistemaEscolar(Scanner scaner) {
    
        Curso curso = new Curso(
                "Programacion",
                new Profesor("Mario", 28, "Programacion"),
                new ArrayList<Estudiante>()
        );
        

        System.out.println("Sistema Escolar");
        System.out.println("---------------\n");

        System.out.println("Comandos");
        mostrarComandos();
        
        boolean salir = false;
        while (!salir) {
           
            System.out.print("\n> ");
            String option = scaner.nextLine();

            switch (option.toLowerCase()) {
                case "añadirprofesor" -> añadirProfesor(scaner, curso);
                case "añadirestudiante" -> añadirEstudiante(scaner,curso);
                case "mostrarparticipantes" -> mostrarParticipantes(curso);
                case "salir" -> salir = true;
                default -> {
                    System.out.println(String.format("La opcion %s no existe", option));
                    mostrarComandos();
                }
            }   
            
        }
        
    }
    
    private static boolean añadirProfesor(Scanner scaner, Curso curso) {
        System.out.print("Nombre: ");
        String nombre = scaner.nextLine();
        System.out.println();
        
        System.out.print("Edad: ");
        String edadStr = scaner.nextLine();
        if (!Utils.esEnteroValido(edadStr)) {
            System.out.println("Error: %s no es un numero entero valido".formatted(edadStr));
            return false;
        }
        int edad = Integer.parseInt(edadStr);
        System.out.println();
        
        System.out.print("Especialidad: ");
        String especialidad = scaner.nextLine();
        System.out.println();
        
        boolean response = curso.setProfesor(new Profesor(nombre, edad, especialidad));
        if (!response) {
            System.out.println("Error: No se a podido agregar el profesor");
            return false;
        }
        
        System.out.println("Profesor añadido correctamente");
        return true;
        
    }
    
    private static boolean añadirEstudiante(Scanner scaner, Curso curso) {
        System.out.print("Nombre: ");
        String nombre = scaner.nextLine();
        System.out.println();
        
        System.out.print("Edad: ");
        String edadStr = scaner.nextLine();
        if (!Utils.esEnteroValido(edadStr)) {
            System.out.println("Error: %s no es un numero entero valido".formatted(edadStr));
            return false;
        }
        int edad = Integer.parseInt(edadStr);
        System.out.println();
        
        System.out.print("Grado: ");
        String grado = scaner.nextLine();
        System.out.println();
        
        boolean response = curso.agregarEstudiante(new Estudiante(nombre, edad, grado));
        if (!response) {
            System.out.println("Error: No se a podido añadir el estudiante");
            return false;
        }
        
        System.out.println("Estudiante añadido correctamente");
        return true;
    }
    
    private static void mostrarParticipantes(Curso curso) {        
        curso.mostrarParticipantes();        
    }
    
    private static void mostrarComandos() {
        System.out.println(" - AñadirProfesor  → Cambia al profesor actual del curso");
        System.out.println(" - AñadirEstudiante    → Añadir nuevo estudiante al curso");
        System.out.println(" - MostrarParticipantes → Muestra todos los participantes del curso");
        System.out.println(" - Salir     → Salir de la lista de tareas");
    }
    
}
