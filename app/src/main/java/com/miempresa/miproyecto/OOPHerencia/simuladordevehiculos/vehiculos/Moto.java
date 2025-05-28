package com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos.vehiculos;

/**
 *
 * @author javier
 */
public class Moto extends Vehiculo{

    public Moto(String marca, int año) {
        super(marca, año);
    }

    @Override
    public void arrancar() {
        System.out.println("Moto lista para rodar.");
    }

    @Override
    public void detener() {
        System.out.println("Moto parada.");
    }
    
    
}
