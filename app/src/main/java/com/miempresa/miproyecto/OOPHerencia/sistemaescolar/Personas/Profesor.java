package com.miempresa.miproyecto.OOPHerencia.sistemaescolar.Personas;

/**
 *
 * @author javier
 */
public class Profesor extends Persona{

    private String especialidad;
    
    public Profesor(String name, int edad, String  especialidad) {
        super(name, edad);
        this.especialidad = especialidad;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }    
}
