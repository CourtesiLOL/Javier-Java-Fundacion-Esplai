
package com.miempresa.miproyecto.gestorpersonas;

import java.util.Scanner;

/**
 *
 * @author javier
 */
public class GestorPersona {
    public static void gestorPersonas(Scanner scaner) {

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
}
