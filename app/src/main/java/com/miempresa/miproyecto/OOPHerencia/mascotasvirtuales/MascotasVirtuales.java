package com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales;

import com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales.mascotas.GatoVirtual;
import com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales.mascotas.HamsterVirtual;
import com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales.mascotas.MascotaVirtual;
import com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales.mascotas.PerroVirtual;
import java.util.Scanner;

/**
 *
 * @author javier
 */
public class MascotasVirtuales {

    public static void mascotasVirtuales(Scanner scaner) {
        System.out.println("Mascota virtual");
        System.out.println("---------------");
        
        System.out.println("Elejir mascota");
        System.out.println("Perro");
        System.out.println("Hamster");
        System.out.println("Gato");
                        
        boolean salir = false;
        String temp;
        
        while (!salir) {
            System.out.print("Mascota: ");
            temp = scaner.nextLine();
            switch (temp.toLowerCase()) {
                case "perro" -> {
                    System.out.print("Nombre: ");
                    temp = scaner.nextLine();                    
                    runGame(scaner, new PerroVirtual(temp));
                    salir = true;
                }
                
                case "gato" -> {
                    System.out.print("Nombre: ");
                    temp = scaner.nextLine();
                    runGame(scaner, new GatoVirtual(temp));
                    salir = true;
                }
                
                case "hamster" -> {
                    System.out.print("Nombre: ");
                    temp = scaner.nextLine();
                    runGame(scaner, new HamsterVirtual(temp));
                    salir = true;
                }
                
                default -> {
                    System.out.println("Error: esa no es una mascota valida");
                }
            }
            
        }
    }
    
    private static void runGame(Scanner scaner, MascotaVirtual mascota) {
        
        System.out.println("Commandos");
        mostrarComandos();
        
        boolean salir = false;
        String temp;
        
        while (!salir) {
            
            System.out.print("> ");
            temp = scaner.nextLine();
            
            switch (temp.toLowerCase()) {
                case "jugar" -> mascota.jugar();
                case "alimentar" -> mascota.comer();
                case "mostrarestado" -> mascota.mostrarEstado();
                case "salir" -> salir = true;
                default -> {
                    System.out.println("La opcion %s no existe".formatted(temp));
                    mostrarComandos();
                }
            }
            
        }
        
    }
    
    private static void mostrarComandos() {        
        System.out.println(" - Jugar  → Juegas con tu mascota");
        System.out.println(" - Alimentar    → Alimentas a tu mascota");
        System.out.println(" - MostrarEstado → Muestra el estado de la mascota");
        System.out.println(" - Salir     → Salir del juego");
    }
    
}
