    
package com.miempresa.miproyecto.gestorencustas;

import com.miempresa.miproyecto.Utils;
import java.util.Scanner;

/**
 *
 * @author javier
 */
public class Encuesta {


    private String titulo;
    private Opcion[] opciones;

    public Encuesta(String titulo, Opcion[] options) {
        this.titulo = titulo;
        this.opciones = options;
    }


    public String getTitulo() {
        return titulo;
    }

    public Opcion[] getOptions() {
        return opciones;
    }
    
    public void mostrarEncuesta(Scanner scan) {
        System.out.println();
        System.out.println(titulo);
        System.out.println("-".repeat(titulo.length()));
        
        boolean completado = false;
        
        while (!completado) {
            int count = 1;
            for (Opcion opt : opciones) {
                System.out.println(String.format("%d. %s", count,opt.getDescripcion()));
                count++;
            }

            System.out.print("\n>");
            String respuesta = scan.nextLine();
            if(!Utils.esEnteroValido(respuesta)) {
                System.out.println(respuesta+" no es una opcion valida, introduzca un numero entero entre 1-"+opciones.length);
                System.out.println("----------------------------------------------------------------------");
                continue;
            }
            
            int opcion = Integer.parseInt(respuesta);
            System.out.println("Cantidad: "+opcion);
            if (opcion > opciones.length || opcion < 1) {
                System.out.println(opcion+" esta fuera del rango, introduzca un numero entero entre 1-"+opciones.length);
                continue;
            }
            
            opciones[opcion-1].incrementarContador();
            completado = true;
            System.out.println();
        }              
        
        
        
    }
    
 
    
    public void mostrarEstadisticas() {
        
        String tempTitle = "Estadistica de encuesta "+titulo;
        System.out.println(tempTitle);
        System.out.println("-".repeat(tempTitle.length()));
        int count = 1;
        for (Opcion opt : opciones) {
            System.out.println(String.format("%d. %s : elegida %d veces", count,opt.getDescripcion(),opt.getContadorSeleccion()));
            count++;
        }
        
        System.out.println();
        
    }
    
    
}
