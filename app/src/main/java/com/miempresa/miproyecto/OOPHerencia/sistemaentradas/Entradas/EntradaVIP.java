package com.miempresa.miproyecto.OOPHerencia.sistemaentradas.Entradas;

/**
 *
 * @author javier
 */
public class EntradaVIP extends Entrada {
    private double recargoVIP;
    
    public EntradaVIP(String evento, double precioBase, double recargoVIP) {
        super(evento, precioBase);
        this.recargoVIP = recargoVIP;
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase + (precioBase * recargoVIP);
    }

}
