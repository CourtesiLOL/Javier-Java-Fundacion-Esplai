package com.miempresa.miproyecto.OOPHerencia;

import com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales.mascotas.GatoVirtual;
import com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales.mascotas.HamsterVirtual;
import com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales.mascotas.MascotaVirtual;
import com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales.mascotas.PerroVirtual;
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
@DisplayName("Juego de mascotas")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MascotasVirtualesTest {

    @Test
    @Order(1)
    void gamePlaySimulation() {
        
        MascotaVirtual mascota;
        
        //Valores base de todas las mascotas
        // 100 energia
        // 100 felicidad
        
        mascota = new GatoVirtual("Juan");
        Assertions.assertNotNull(mascota);
        Assertions.assertInstanceOf(GatoVirtual.class, mascota);
        
        //El gato recupera 1 mas que los demas
        mascota.comer();
        Assertions.assertEquals(mascota.getEnergia(), 102);
        
        
        
        mascota = new PerroVirtual("Juan");
        Assertions.assertNotNull(mascota);
        Assertions.assertInstanceOf(PerroVirtual.class, mascota);
        
        //El perro recibe 1 mas de felicidad
        mascota.jugar();
        Assertions.assertEquals(mascota.getFelicidad(), 102);
        
        
        
        mascota = new HamsterVirtual("Juan");
        Assertions.assertNotNull(mascota);
        Assertions.assertInstanceOf(HamsterVirtual.class, mascota);
        
        //El hamster se cansa mas rapido
        mascota.jugar();
        Assertions.assertEquals(mascota.getEnergia(), 98);
        
    }    
    
}
