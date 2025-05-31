package com.miempresa.miproyecto.OOPHerencia;

import com.miempresa.miproyecto.OOPHerencia.sistemaentradas.Entradas.Entrada;
import com.miempresa.miproyecto.OOPHerencia.sistemaentradas.Entradas.EntradaConDescuento;
import com.miempresa.miproyecto.OOPHerencia.sistemaentradas.Entradas.EntradaEstandar;
import com.miempresa.miproyecto.OOPHerencia.sistemaentradas.Entradas.EntradaVIP;
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
@DisplayName("Sistema Entradas")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SistemaEntradasTest {

    @Test
    @Order(1)
    void simulacionVentaEntradas() {
        Entrada entrada;
        
        entrada = new EntradaEstandar("AC DC",165);
        Assertions.assertNotNull(entrada);
        Assertions.assertEquals(entrada.getPrecioBase(), entrada.calcularPrecioFinal());
        
        //30% mas cara
        entrada = new EntradaVIP("AC DC",165,0.30);
        Assertions.assertNotNull(entrada);
        Assertions.assertEquals(
                entrada.getPrecioBase() + (entrada.getPrecioBase() * 0.30),
                entrada.calcularPrecioFinal());
        
        //30% mas barata
        entrada = new EntradaConDescuento("AC DC",165,0.30);
        Assertions.assertNotNull(entrada);
        Assertions.assertEquals(
                entrada.getPrecioBase() - (entrada.getPrecioBase() * 0.30),
                entrada.calcularPrecioFinal());
    }
    
}
