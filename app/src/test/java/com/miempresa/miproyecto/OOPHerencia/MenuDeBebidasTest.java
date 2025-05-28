
package com.miempresa.miproyecto.OOPHerencia;

import com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas.Agua;
import com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas.Bebida;
import com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas.Refresco;
import com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas.Zumo;
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
@DisplayName("Menu de Bebidas")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MenuDeBebidasTest {
    List<Bebida> bebidas = new ArrayList();
    
    @Test
    @Order(1)
    void intanciarBebidas() {
        Bebida tempBebida;
        
        tempBebida = new Zumo("Granini", "1 litro", "Multifrutas");
        Assertions.assertNotNull(tempBebida);
        Assertions.assertInstanceOf(Zumo.class, tempBebida);
        bebidas.add(tempBebida);
        
        tempBebida = new Refresco("Naranja loca", "50 cl", true);
        Assertions.assertNotNull(tempBebida);
        Assertions.assertInstanceOf(Refresco.class, tempBebida);
        bebidas.add(tempBebida);
        
        tempBebida = new Agua("Font Vella", "33 cl", false);
        Assertions.assertNotNull(tempBebida);
        Assertions.assertInstanceOf(Agua.class, tempBebida);
        bebidas.add(tempBebida);               
        
        Assertions.assertEquals(3, bebidas.size());
    }
    
}
