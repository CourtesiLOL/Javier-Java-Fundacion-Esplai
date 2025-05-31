package com.miempresa.miproyecto.OOPHerencia.recetariodigital.recetas;

import com.miempresa.miproyecto.OOPHerencia.recetariodigital.Ingrediente;
import java.util.List;

/**
 *
 * @author javier
 */
public abstract class Receta {
    protected String nombre;
    protected List<Ingrediente> ingredientes;
    protected List<String> pasos;

    public Receta(String nombre, List<Ingrediente> ingredientes, List<String> pasos) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
    }

    public String getNombre() {
        return nombre;
    }
    
    public int numeroDeIngredientes() {
        return ingredientes.size();
    }
    
    public abstract String descripcionGeneral();
}
