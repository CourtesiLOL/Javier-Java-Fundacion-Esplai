package com.miempresa.miproyecto.OOPHerencia;

import com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos.vehiculos.Bicicleta;
import com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos.vehiculos.Coche;
import com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos.vehiculos.Moto;
import com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos.vehiculos.Vehiculo;
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
@DisplayName("Simulador de vehiculos")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SimuladorDeVehiculosTest {
    List<Vehiculo> vehiculos = new ArrayList();
    
    @Test
    @Order(1)
    void instanciarVehiculos() {
        Vehiculo tempVehiculo;
        
        tempVehiculo = new Coche("Cadilac",5);
        Assertions.assertNotNull(tempVehiculo);
        vehiculos.add(tempVehiculo);
        
        tempVehiculo = new Moto("Yamaha",2);
        Assertions.assertNotNull(tempVehiculo);
        vehiculos.add(tempVehiculo);
        
        tempVehiculo = new Bicicleta("Yamaha",10);
        Assertions.assertNotNull(tempVehiculo);
        vehiculos.add(tempVehiculo);
        
        Assertions.assertEquals(3, vehiculos.size());
    }
    
}
