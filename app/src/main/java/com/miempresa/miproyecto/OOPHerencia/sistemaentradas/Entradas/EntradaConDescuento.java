package com.miempresa.miproyecto.OOPHerencia.sistemaentradas.Entradas;

/**
 *
 * @author javier
 */
public class EntradaConDescuento extends Entrada{

    private double descuento;

    public EntradaConDescuento(String evento, double precioBase, double descuento) {
        super(evento, precioBase);
        this.descuento = descuento;
    }
    
    @Override
    public double calcularPrecioFinal() {
        return precioBase - (precioBase * descuento);
    }
    
    
}
