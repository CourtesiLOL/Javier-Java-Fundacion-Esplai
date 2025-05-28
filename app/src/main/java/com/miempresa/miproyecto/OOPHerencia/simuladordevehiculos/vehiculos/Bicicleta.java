package com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos.vehiculos;

/**
 *
 * @author javier
 */
public class Bicicleta extends Vehiculo{

    public Bicicleta(String marca, int año) {
        super(marca, año);
    }

    @Override
    public void arrancar() {
        System.out.println("No necesita arrancar.");
    }

    @Override
    public void detener() {
        System.out.println("No necesita detener.");
    }
    
}
