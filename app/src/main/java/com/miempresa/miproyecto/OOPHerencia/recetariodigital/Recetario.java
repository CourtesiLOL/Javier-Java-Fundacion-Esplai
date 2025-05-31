package com.miempresa.miproyecto.OOPHerencia.recetariodigital;

import com.miempresa.miproyecto.OOPHerencia.recetariodigital.recetas.Receta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javier
 */
public class Recetario {
    private List<Receta> recetas;
    
    public Recetario(List<Receta> recetas) {
        this.recetas = recetas;
    }
    public Recetario() {
        this(new ArrayList<Receta>());
    }
    
    public boolean agregarReceta(Receta receta) {
        if (receta == null) {
            System.out.println("Error: receta nula");
            return false;
        }
        recetas.add(receta);        
        return true;
    }
    
    public void printResumido() {
        
        for (Receta e : recetas) {
            System.out.println(
                    """
                    Nombre: %s
                    Tipo de receta: %s
                    Numero de ingredientes: %d
                    """
                    .formatted(
                            e.getNombre(),
                            e.getClass().getSimpleName(),
                            e.numeroDeIngredientes()
                    ));
        }
    }
    
    public boolean mostrarReceta(String nombre) {
        
        for (Receta e : recetas) {
            if (e.getNombre().equals(nombre)) {
                System.out.println(e.descripcionGeneral());
                return true;
            }
        }
        
        return false;
        
    }
    
    public Receta obtenerReceta(String nombre) {
        for (Receta e : recetas) {
            if (e.getNombre().equals(nombre)) {
                return e;
            }
        }
        
        return null;
    }
    
    public void borrarReceta(Receta receta) {
        recetas.remove(receta);
    }
}
