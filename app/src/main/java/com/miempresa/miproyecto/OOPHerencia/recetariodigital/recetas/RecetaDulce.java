package com.miempresa.miproyecto.OOPHerencia.recetariodigital.recetas;

import com.miempresa.miproyecto.OOPHerencia.recetariodigital.Ingrediente;
import java.util.List;

/**
 *
 * @author javier
 */
public class RecetaDulce extends Receta{

    public RecetaDulce(String nombre, List<Ingrediente> ingredientes, List<String> pasos) {
        super(nombre, ingredientes, pasos);
    }

    @Override
    public String descripcionGeneral() {
        StringBuilder str = new StringBuilder();
        str.append("Receta del plato dulce ");
        str.append(nombre);
        str.append("\n\nLista de ingredientes\n");
        str.append("---------------------\n");
        for (Ingrediente ing : ingredientes) {
            str.append(ing.toString());
            str.append("\n");
        }
        
        str.append("Lista de pasos\n");
        str.append("--------------\n");
        
        for (String paso : pasos) {
            str.append(paso);
            str.append("\n");
        }
        str.append("\n");
        
        return str.toString();
    }
    
    
}
