package com.miempresa.miproyecto.OOPHerencia.sistemaescolar.Personas;

/**
 *
 * @author javier
 */
public class Persona {
    protected String name;
    protected int edad;

    public Persona(String name, int edad) {
        this.name = name;
        this.edad = edad;
    }

    public String getName() {
        return name;
    }

    public int getEdad() {
        return edad;
    }            
    
}
