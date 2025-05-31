package com.miempresa.miproyecto.OOPHerencia.sistemaentradas.Entradas;

/**
 *
 * @author javier
 */
public abstract class Entrada {
    protected String evento;
    protected double precioBase;

    public Entrada(String evento, double precioBase) {
        this.evento = evento;
        this.precioBase = precioBase;
    }        

    public String getEvento() {
        return evento;
    }

    public double getPrecioBase() {
        return precioBase;
    }        
    
    public abstract double calcularPrecioFinal();
    
    @Override
    public String toString() {
        return String.format("""
                             Tipo de Entrada: %s
                             Nombre del evento: %s
                             Precio Base: %.2f
                             Precio final calculado: %.2f
                             """, this.getClass().getSimpleName(),evento, precioBase, calcularPrecioFinal());
    }
}
