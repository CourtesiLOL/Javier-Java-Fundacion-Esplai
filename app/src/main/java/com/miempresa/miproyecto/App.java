package com.miempresa.miproyecto;

import com.miempresa.miproyecto.listatareas.Tarea;
import com.miempresa.miproyecto.listatareas.Estado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.miempresa.miproyecto.Utils.esEnteroValido;
import com.miempresa.miproyecto.cajerobasico.CajeroBasico;
import com.miempresa.miproyecto.gestorcontactos.GestorContactos;
import com.miempresa.miproyecto.gestorencustas.GestorEncuesta;
import com.miempresa.miproyecto.gestorpersonas.GestorPersona;
import com.miempresa.miproyecto.listatareas.ListaDeTareas;
import com.miempresa.miproyecto.registronotasalumno.RegistroNotasAlumno;


public class App {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
           
            System.out.println("Lista de ejercicios");
            System.out.println("-------------------");
            System.out.println("1.Gestor de Personas");
            System.out.println("2.Lista de tareas");
            System.out.println("3.Cajero Basico");
            System.out.println("4.Gestor de Contactos");
            System.out.println("5.Registro notas alumno");
            System.out.println("6.Gestor encuestas");
            System.out.println("7.Salir");
            
            System.out.print("\n> ");
            String option = scaner.nextLine();
            if (!esEnteroValido(option)) {
                System.out.println(String.format("Error: %s no es un numero entero valido", option));
                continue;
            }

            int optionNum = Integer.valueOf(option);
            switch (optionNum) {
                case 1 -> GestorPersona.gestorPersonas(scaner);
                case 2 -> ListaDeTareas.listaTareas(scaner);
                case 3 -> CajeroBasico.cajeroBasico(scaner);
                case 4 -> GestorContactos.gestorContactos(scaner);
                case 5 -> RegistroNotasAlumno.registroNotasAlumno(scaner);
                case 6 -> GestorEncuesta.gestorEncuestas(scaner);
                case 7 -> salir = true;
                default -> System.out.println(String.format("La opcion %s no existe", option));
            }   
            
        }
        
        scaner.close();
        
        
    }
    

}