package com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos.vehiculos;

/**
 *
 * @author javier
 */
public class Coche extends Vehiculo {

    public Coche(String marca, int año) {
        super(marca, año);
    }    
    
    @Override
    public void arrancar() {
        System.out.println("Coche arrancando..");
    }

    @Override
    public void detener() {
        System.out.println("Coche detenido..");
    }
    
}
