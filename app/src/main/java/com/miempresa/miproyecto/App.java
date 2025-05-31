package com.miempresa.miproyecto;

import java.util.Scanner;

import static com.miempresa.miproyecto.Utils.esEnteroValido;
import com.miempresa.miproyecto.OOP.cajerobasico.CajeroBasico;
import com.miempresa.miproyecto.OOP.gestorcontactos.GestorContactos;
import com.miempresa.miproyecto.OOP.gestorencustas.GestorEncuesta;
import com.miempresa.miproyecto.OOP.gestorpersonas.GestorPersona;
import com.miempresa.miproyecto.OOP.listatareas.ListaDeTareas;
import com.miempresa.miproyecto.OOP.registronotasalumno.RegistroNotasAlumno;
import com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales.MascotasVirtuales;
import com.miempresa.miproyecto.OOPHerencia.menudebebidas.MenuDeBebidas;
import com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos.SimuladorDeVehiculos;
import com.miempresa.miproyecto.OOPHerencia.sistemaentradas.SistemaEntradas;
import com.miempresa.miproyecto.OOPHerencia.sistemaescolar.SistemaEscolar;
import com.miempresa.miproyecto.OOPHerencia.zoologicovirtual.ZoologicoVirtual;


public class App {

    public static void main(String[] args) {
        
        try (Scanner scaner = new Scanner(System.in)){
            boolean salir = false;
            while (!salir) {

                System.out.println("Lista de ejercicios");
                System.out.println("-------------------");
                System.out.println("1.OOP");
                System.out.println("2.Herencia");
                System.out.println("3.Salir");

                System.out.print("\n> ");
                String option = scaner.nextLine();
                if (!esEnteroValido(option)) {
                    System.out.println(String.format("Error: %s no es un numero entero valido", option));
                    continue;
                }

                int optionNum = Integer.valueOf(option);
                switch (optionNum) {
                    case 1 -> OOP(scaner);
                    case 2 -> OOPHerencia(scaner);
                    case 3 -> salir = true;
                    default -> System.out.println(String.format("La opcion %s no existe", option));
                }   

            }
        }
        
    }
    
    private static void OOP(Scanner scaner) {
        
        boolean salir = false;
        while (!salir) {
           
            System.out.println("Lista de Projectos");
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
        
    }

    private static void OOPHerencia(Scanner scaner) {
        
        boolean salir = false;
        while (!salir) {
           
            System.out.println("Lista de Projectos");
            System.out.println("-------------------");
            System.out.println("1.Zoológico Virtual");
            System.out.println("2.Menú de Bebidas");
            System.out.println("3.Simulador de Vehículos");
            System.out.println("4.Sistema Escolar");
            System.out.println("5.Mascotas Virtuales");
            System.out.println("6.Sistema de Entradas para Espectáculos");
            System.out.println("7.Recetario Digital");
            System.out.println("8.Salir");
            
            System.out.print("\n> ");
            String option = scaner.nextLine();
            if (!esEnteroValido(option)) {
                System.out.println(String.format("Error: %s no es un numero entero valido", option));
                continue;
            }

            int optionNum = Integer.valueOf(option);
            switch (optionNum) {
                case 1 -> ZoologicoVirtual.ZoologicoVirtual(scaner);
                case 2 -> MenuDeBebidas.menuDeBebidas(scaner);
                case 3 -> SimuladorDeVehiculos.simuladorDeVehiculos(scaner);
                case 4 -> SistemaEscolar.sistemaEscolar(scaner);
                case 5 -> MascotasVirtuales.mascotasVirtuales(scaner);
                case 6 -> SistemaEntradas.sistemaEntradas(scaner);
                case 7 -> System.out.println("TO-DO");
                case 8 -> salir = true;
                default -> System.out.println(String.format("La opcion %s no existe", option));
            }   
            
        }
        
    }
}