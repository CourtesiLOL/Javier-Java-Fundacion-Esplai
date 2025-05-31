package com.miempresa.miproyecto.OOPHerencia.sistemaescolar.Personas;

/**
 *
 * @author javier
 */
public class Estudiante extends Persona{

    private String grado;
    
    public Estudiante(String name, int edad, String grado) {
        super(name, edad);
        this.grado = grado;
    }
    
    
    
    
}
