
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
        //TO-DO
    }
    public static void testRegistroNotasAlumno() {
        System.out.println("Registro de Notas de Alumnos");
        System.out.println("----------------------------\n");

        List<Alumno> alumnos = new ArrayList();

        Alumno alumnoTemp;
        //Añadimos alumno juan

        System.out.println("Añadiendo alumnos");
        alumnoTemp = new Alumno("Juan");
        alumnoTemp.addNota(0);
        alumnoTemp.addNota(3.5);
        alumnoTemp.addNota(4.6);
        alumnoTemp.addNota(2);
        alumnoTemp.addNota(7);
        alumnos.add(alumnoTemp);
        System.out.println("Juan");

        alumnoTemp = new Alumno("Carla");
        alumnoTemp.addNota(6.0);
        alumnoTemp.addNota(5.5);
        alumnoTemp.addNota(4.0);
        alumnoTemp.addNota(7.0);
        alumnoTemp.addNota(3.5);
        alumnos.add(alumnoTemp);
        System.out.println("Carla");

        alumnoTemp = new Alumno("Marcos");
        alumnoTemp.addNota(2.5);
        alumnoTemp.addNota(3.0);
        alumnoTemp.addNota(6.5);
        alumnoTemp.addNota(1.0);
        alumnoTemp.addNota(5.0);
        alumnos.add(alumnoTemp);
        System.out.println("Marcos");

        alumnoTemp = new Alumno("Luciana");
        alumnoTemp.addNota(7.0);
        alumnoTemp.addNota(6.8);
        alumnoTemp.addNota(5.9);
        alumnoTemp.addNota(4.2);
        alumnoTemp.addNota(3.1);
        alumnos.add(alumnoTemp);
        System.out.println("Luciana");

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
    
}
