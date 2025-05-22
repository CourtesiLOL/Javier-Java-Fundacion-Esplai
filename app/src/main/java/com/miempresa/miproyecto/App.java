package com.miempresa.miproyecto;

import com.miempresa.miproyecto.cajerobasico.CuentaBancaria;
import com.miempresa.miproyecto.gestorcontactos.Agenda;
import com.miempresa.miproyecto.gestorcontactos.Contacto;
import com.miempresa.miproyecto.gestorpersonas.Persona;
import com.miempresa.miproyecto.listatareas.Tarea;
import com.miempresa.miproyecto.registronotasalumno.Alumno;
import com.miempresa.miproyecto.listatareas.Estado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    

    public static void main(String[] args) {
        
        
        //gestorPersonas();
        //listaTareas();
        //cajeroBasico();
        //gestorContactos();
        //registroNotasAlumno();
              
        
    }

    private static void gestorPersonas() {

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
    
    

    private static void listaTareas() {        
        List<Tarea> listaTareas = new ArrayList();

        listaTareas.add(new Tarea("Colada", "Tender la colada"));
        listaTareas.add(new Tarea("Fregar", "Fregar los platos"));
        listaTareas.add(new Tarea("Barrer", "Barrer la casa"));
        listaTareas.add(new Tarea("Fregar", "Fregar el comedor"));
        listaTareas.add(new Tarea("Comida Perro", "Dar de comer al perro"));
        
        try (Scanner scaner = new Scanner(System.in)) {
            
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
    
    
    
    private static void cajeroBasico() {        
                       
        var cuenta = new CuentaBancaria("Juan", 1256);
        
        try (Scanner scaner = new Scanner(System.in)) {
            
            boolean salir = false;
            
            System.out.println("Cajero");
            System.out.println("------\n");

            System.out.println("Bienvenido juan");
            while (!salir) {
                System.out.print(">");
                String userInput = scaner.nextLine();
                double cantidad;

                switch (userInput.toLowerCase()) {
                    case "saldo":
                        System.out.println(String.format("Saldo acutal: %s $", cuenta.consultarSaldo()));
                        break;

                    case "retirar":
                        System.out.print("Cantidad a retirar: ");
                        cantidad = scaner.nextDouble();
                        
                        if (cantidad <= 0) {
                            System.out.println("Cantidad de 0 o inferior no estan permitidos");
                            break;
                        }
                            
                        
                        if (cuenta.retirar(cantidad)) {
                            System.out.println("Retirada exitosa");
                            System.out.println("Saldo actual: "+cuenta.consultarSaldo());
                        } else {
                            System.out.println("Error: saldo insuficiente");
                            System.out.println("Saldo atual: "+cuenta.consultarSaldo());
                            System.out.println("Cantidad a retirar: "+cantidad);                            
                        }
                        break;
                        
                    case "despositar":
                        cantidad = scaner.nextDouble();
                        if (cantidad <= 0) {
                            System.out.println("Cantidad de 0 o inferior no estan permitidos");
                            break;
                        }
                        
                        cuenta.depositar(cantidad);
                        System.out.println("Deposito exitoso");
                        System.out.println("Saldo actual: "+cuenta.consultarSaldo());
                        break;
                    case "resumen":
                        break;
                        
                    case "salir":
                        salir = true;
                        break;

                    default:
                        System.out.println("Comando no reconocido. Comandos posibles:");
                        System.out.println(" - saldo   → Muestra el saldo actual de la cuenta");
                        System.out.println(" - retirar    → Retirar dinero de tu cuenta");
                        System.out.println(" - depositar → Depositar una cantidad de dinero");
                        System.out.println(" - resumen → muestra el historial de operaciones");

                }
            }            
        }
        
    }
    private static void testCajeroBasico() {
        CuentaBancaria cuenta = new CuentaBancaria("Javier", 5000d);
        System.out.println("Creacion de cuenta");
        System.out.println("Consultar saldo: " + cuenta.consultarSaldo());
        System.out.println("Varias operaciones despues...");

        cuenta.depositar(256);
        cuenta.retirar(499.99);
        cuenta.retirar(45.89);

        System.out.println("Consultar saldo: " + cuenta.consultarSaldo());
        System.out.println("Varias operaciones despues...");

        cuenta.depositar(2000);
        cuenta.retirar(9800);
        cuenta.retirar(2.50);

        System.out.println("Consultar saldo: " + cuenta.consultarSaldo());
        System.out.println("-------------------");
        System.out.println("Resumen de transacciones\n");
        cuenta.resumenTransacciones();
    }
    
    

    private static void gestorContactos() {
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
    
    

    private static void registroNotasAlumno() {
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


