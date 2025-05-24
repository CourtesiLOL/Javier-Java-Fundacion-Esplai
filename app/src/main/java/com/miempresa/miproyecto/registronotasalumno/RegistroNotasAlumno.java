
package com.miempresa.miproyecto.registronotasalumno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javier
 */
public class RegistroNotasAlumno {
    
    public static void registroNotasAlumno(Scanner scaner) {
        
        List<Alumno> alumnos = new ArrayList();
        crearAlumnos(alumnos);
        boolean salir = false;

        System.out.println("Gestor Alumnos");
        System.out.println("----------------\n");
        System.out.println("Commandos");
        mostrarComandos();
        while (!salir) {
            System.out.print(">");
            String userInput = scaner.nextLine();            
            
            switch (userInput.toLowerCase()) {
                case "veralumnos" -> verAlumnos(alumnos);
                case "añadirnota" -> añadirNota(alumnos,scaner);
                case "verpromedio" -> verPromedio(alumnos, scaner);
                case "vertodo" -> verTodo(alumnos);
                case "salir" -> salir = true;
                default -> {
                    System.out.println("Comando no reconocido. Comandos posibles:");
                    mostrarComandos();
                }


            }
        }
    }    
    
    
    
    private static void verAlumnos(List<Alumno> alumnos) {
        System.out.println("Alumnos");
        System.out.println("-------");
        
        if (alumnos == null || alumnos.size() == 0) {
            System.out.println("¡No hay Alumnos!");
            return;
        }
        
        for (Alumno alum : alumnos) {
            System.out.println(alum.getNombre());
        }
    }
    
    private static void añadirNota(List<Alumno> alumnos, Scanner scaner) {
        System.out.print("Nombre: ");
        String name = scaner.nextLine();
        
        var alumnoTemp = buscarAlumno(alumnos, name);
        if (alumnoTemp == null) {
            System.out.println("Alumno no existe");
            return;
        }
        
        System.out.print("Nota: ");
        double nota = scaner.nextDouble();
        scaner.nextLine();
        
        if (nota < 0 || nota > 10) {
            System.out.println("No puede ser menos de 0 o mas de 10");
            return;
        }
        
        alumnoTemp.addNota(nota);
        System.out.println("Nota añadidad correctamente");
    }
    
    private static void verPromedio(List<Alumno> alumnos, Scanner scaner) {
        System.out.print("Nombre: ");
        String name = scaner.nextLine();
        
        var alumnoTemp = buscarAlumno(alumnos, name);
        if (alumnoTemp == null) {
            System.out.println("Alumno no existe");
            return;
        }
        
        System.out.println("Promedio: "+alumnoTemp.calcularPromedio());
    }
    
    private static void verTodo(List<Alumno> alumnos) {
       
        System.out.println("Toda la informacion");
        System.out.println("-------------------\n");
        
        for (Alumno alum : alumnos) {
            System.out.println(alum.toString());
            System.out.println("---------------");
        }
        
    }
    
    private static Alumno buscarAlumno(List<Alumno> alumnos, String name) {
        for (Alumno alum : alumnos) {
            if (alum.getNombre().equalsIgnoreCase(name)) {
                return alum;
            }
        }
        
        return null;
    }
    
    
    
    public static void testRegistroNotasAlumno() {
        System.out.println("Registro de Notas de Alumnos");
        System.out.println("----------------------------\n");

        List<Alumno> alumnos = new ArrayList();
        crearAlumnos(alumnos);

        System.out.println("\nLista de alumnos y su informacion");
        System.out.println("---------------------------------\n");
        Alumno mejorAlumno = null;
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());
            
            if (mejorAlumno == null) {
                mejorAlumno = alumno;
                continue;
            }
            if (mejorAlumno.calcularPromedio() < alumno.calcularPromedio()) mejorAlumno = alumno;          
        }
        System.out.println("---------------------------------");
        
        System.out.println("Mejor alumno\n");
        System.out.println(mejorAlumno.toString());
        
        
    }
    
    private static void crearAlumnos(List<Alumno> alumnos) {
        
        Alumno alumnoTemp;
        
        alumnoTemp = new Alumno("Juan");
        alumnoTemp.addNota(0);
        alumnoTemp.addNota(3.5);
        alumnoTemp.addNota(4.6);
        alumnoTemp.addNota(2);
        alumnoTemp.addNota(7);
        alumnos.add(alumnoTemp);
        

        alumnoTemp = new Alumno("Carla");
        alumnoTemp.addNota(6.0);
        alumnoTemp.addNota(5.5);
        alumnoTemp.addNota(4.0);
        alumnoTemp.addNota(7.0);
        alumnoTemp.addNota(3.5);
        alumnos.add(alumnoTemp);
        

        alumnoTemp = new Alumno("Marcos");
        alumnoTemp.addNota(2.5);
        alumnoTemp.addNota(3.0);
        alumnoTemp.addNota(6.5);
        alumnoTemp.addNota(1.0);
        alumnoTemp.addNota(5.0);
        alumnos.add(alumnoTemp);


        alumnoTemp = new Alumno("Luciana");
        alumnoTemp.addNota(7.0);
        alumnoTemp.addNota(6.8);
        alumnoTemp.addNota(5.9);
        alumnoTemp.addNota(4.2);
        alumnoTemp.addNota(3.1);
        alumnos.add(alumnoTemp);
    }
    
    private static void mostrarComandos() {
        System.out.println(" - VerAlumnos   → Mustra todos los alumnos");
        System.out.println(" - AñadirNota    → Añade una nota a x alumno");
        System.out.println(" - VerPromedio → Muestra el promedio de un alumno");
        System.out.println(" - VerTodo → Muestra toda la informacion de todos los alumnos");
    }
}
