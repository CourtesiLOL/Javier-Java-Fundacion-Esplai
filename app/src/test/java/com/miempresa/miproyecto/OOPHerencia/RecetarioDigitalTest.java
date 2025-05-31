package com.miempresa.miproyecto.OOPHerencia;

import com.miempresa.miproyecto.OOPHerencia.recetariodigital.Ingrediente;
import com.miempresa.miproyecto.OOPHerencia.recetariodigital.Recetario;
import com.miempresa.miproyecto.OOPHerencia.recetariodigital.recetas.Receta;
import com.miempresa.miproyecto.OOPHerencia.recetariodigital.recetas.RecetaSalada;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author javier
 */
@DisplayName("Recetario digital")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RecetarioDigitalTest {
    
    @Test
    @Order(1)
    void pruebaIngredientes() {
        Ingrediente ingrediente = new Ingrediente("Tomate", 1, "entero");
        Assertions.assertNotNull(ingrediente);
        
        Assertions.assertInstanceOf(String.class, ingrediente.getNombre());
        Assertions.assertInstanceOf(Integer.class, ingrediente.getCantidad());
        Assertions.assertInstanceOf(String.class, ingrediente.getUnidad());
    }
    
    @Test
    @Order(2)
    void pruebaReceta() {
        Receta receta;
        List<Ingrediente> ingredientes = new ArrayList();
        List<String> pasos = new ArrayList();
        
        ingredientes.add(new Ingrediente("Pan", 1, "entero"));
        ingredientes.add(new Ingrediente("Queso", 250, "gramos"));
        
        pasos.add("Corta el pan en rebanadas");
        pasos.add("Poner el queso");
        pasos.add("Gratinar en el horno/microondas");
        
        receta = new RecetaSalada(
                "Pan y queso",
                ingredientes,
                pasos
        );
        
        Assertions.assertNotNull(receta);
        Assertions.assertEquals(ingredientes.size(), receta.numeroDeIngredientes());
    }
    
    @Test
    @Order(3)
    void recetasDiversas() {
        Recetario recetario = new Recetario();
        Assertions.assertNotNull(recetario);
        
        Receta receta;
        List<Ingrediente> ingredientes = new ArrayList();
        List<String> pasos = new ArrayList();
        
        ingredientes.add(new Ingrediente("Pan", 1, "entero"));
        ingredientes.add(new Ingrediente("Queso", 250, "gramos"));
        
        pasos.add("Corta el pan en rebanadas");
        pasos.add("Poner el queso");
        pasos.add("Gratinar en el horno/microondas");
        
        receta = new RecetaSalada(
                "Pan y queso",
                ingredientes,
                pasos
        );
        
        Assertions.assertTrue(recetario.agregarReceta(receta));        
        
    }

}
