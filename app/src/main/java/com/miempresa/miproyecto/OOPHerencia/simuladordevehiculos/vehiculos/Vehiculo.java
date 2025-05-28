package com.miempresa.miproyecto.OOPHerencia.simuladordevehiculos.vehiculos;

/**
 *
 * @author javier
 */
public abstract class Vehiculo {
    protected String marca;
    protected int año;

    public Vehiculo(String marca, int año) {
        this.marca = marca;
        this.año = año;
    }

    public String getMarca() {
        return marca;
    }

    public int getAño() {
        return año;
    }
        
    
    public abstract void arrancar();
    public abstract void detener();
}
