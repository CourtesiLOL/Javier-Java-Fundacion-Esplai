
package com.miempresa.miproyecto.OOPHerencia;

import com.miempresa.miproyecto.OOPHerencia.zoologicovirtual.animales.Animal;
import com.miempresa.miproyecto.OOPHerencia.zoologicovirtual.animales.Gato;
import com.miempresa.miproyecto.OOPHerencia.zoologicovirtual.animales.Pajaro;
import com.miempresa.miproyecto.OOPHerencia.zoologicovirtual.animales.Perro;
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
@DisplayName("Zoologico virtual")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ZoologicoVirtualTest {
    List<Animal> animales = new ArrayList();
    
    @Test
    @Order(1)
    void intanciarAnimales() {
        Animal tempAnimal;
        
        tempAnimal = new Gato("Bigotes",20);
        Assertions.assertNotNull(tempAnimal);
        animales.add(tempAnimal);
        
        tempAnimal = new Pajaro("Bigotes",20);
        Assertions.assertNotNull(tempAnimal);
        animales.add(tempAnimal);
        
        tempAnimal = new Perro("Bigotes",20);
        Assertions.assertNotNull(tempAnimal);
        animales.add(tempAnimal);
        
        Assertions.assertEquals(3, animales.size());
    }
      
    
}
