
package com.miempresa.miproyecto.OOPHerencia.menudebebidas;

import com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas.Agua;
import com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas.Bebida;
import com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas.Refresco;
import com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas.Zumo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author javier
 */
public class MenuDeBebidas {
    
    public static void menuDeBebidas(Scanner scaner) {
        List<Bebida> bebidas = new ArrayList();
        
        System.out.println("Menu de bebidas");
        System.out.println("---------------\n");

        System.out.println("Comandos");
        mostrarComandos();

        boolean salir = false;
        while (!salir) {
           
            System.out.print("\n> ");
            String option = scaner.nextLine();

            switch (option.toLowerCase()) {
                case "listarbebidas" -> listarBebidas(bebidas);
                case "añadirbebida" -> añadirBebida(scaner,bebidas);
                case "borrarbebida" -> borrarBebida(scaner, bebidas);
                case "salir" -> salir = true;
                default -> {
                    System.out.println(String.format("La opcion %s no existe", option));
                    mostrarComandos();
                }
            }   
            
        }
        
    }
    
    private static void mostrarComandos() {        
        System.out.println(" - ListarBebidas   → Lista todas las bebidas y sus atributos.");
        System.out.println(" - AñadirBebida    → Añade una nueva bebida");
        System.out.println(" - BorrarBebida → Borra una bebidas");
        System.out.println(" - Salir     → Salir de la lista de tareas");
    }
    
    private static void listarBebidas(List<Bebida> bebidas) {
        
        System.out.println("Bebidas");
        System.out.println("-------");
        if (bebidas.isEmpty()) System.out.println("No hay ninguna");        
        bebidas.forEach(b -> System.out.println(b.getNombre()));
        System.out.println("\n");
        
    }
    
    private static boolean añadirBebida(Scanner scaner, List<Bebida> bebidas) {
        
        String tempStr;
                
        
        System.out.print("Tipo(Zumo, Agua o Refresco): ");
        tempStr = scaner.nextLine();
        tempStr = tempStr.toLowerCase();
        
        if (!tempStr.equals("agua") && !tempStr.equals("zumo") && !tempStr.equals("refresco")) {
            System.out.println("Error: %s no es una Bebida valida".formatted(tempStr));
            return false;
        }

        System.out.print("\nNombre: ");
        String nombre = scaner.nextLine();
        
        System.out.print("\nTamaño: ");
        String tamaño = scaner.nextLine();
        
        switch (tempStr) {
            case "agua":
                System.out.print("Mineral(si/no): ");
                tempStr = scaner.nextLine();
                boolean mineral;
                
                if (tempStr.equalsIgnoreCase("si")) {
                    mineral = true;
                } else if(tempStr.equalsIgnoreCase("no")) {
                    mineral = false;
                } else {
                    System.out.println("Valor %s no es valido, tiene que ser si o no".formatted(tempStr));
                    return false;
                }
                
                bebidas.add(new Agua(nombre,tamaño,mineral));
                break;
                
           case "refresco":
                System.out.print("Con gas(si/no): ");
                tempStr = scaner.nextLine();
                boolean conGas;
                
                if (tempStr.equalsIgnoreCase("si")) {
                    conGas = true;
                } else if(tempStr.equalsIgnoreCase("no")) {
                    conGas = false;
                } else {
                    System.out.println("Valor %s no es valido, tiene que ser si o no".formatted(tempStr));
                    return false;
                }
                
                bebidas.add(new Refresco(nombre,tamaño,conGas));
                break;
           case "zumo":
               System.out.print("Fruta: ");
               tempStr = scaner.nextLine();
               bebidas.add(new Zumo(nombre,tamaño,tempStr));
               break;
           
        }
        
        return true;
        
    }
    
    private static boolean borrarBebida(Scanner scaner, List<Bebida> bebidas) {
        System.out.print("Nombre: ");
        String nombre = scaner.nextLine();
        
        Bebida bebida = getBebida(nombre, bebidas);
        if (bebida == null) {
            System.out.println("La bebida %s no existe".formatted(nombre));
            return false;
        }
        
        bebidas.remove(bebida);
        System.out.println("Bebida borrada correctamente");
        return true;
        
    }
    
    private static Bebida getBebida(String nombre, List<Bebida> bebidas) {
        for (Bebida bebidaTemp : bebidas) {
            if (bebidaTemp.getNombre().equals(nombre)) {
               return bebidaTemp;
            }
        }
        
        return null;
    }
    

}
