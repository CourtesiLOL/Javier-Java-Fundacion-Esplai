
package com.miempresa.miproyecto.OOP.gestorencustas;

/**
 *
 * @author javier
 */
public class Opcion {

    private int contadorSeleccion;
    private String descripcion;
    
    public Opcion(String descripcion) {
        this.descripcion = descripcion;
        this.contadorSeleccion = 0;
    }
    
    public Opcion(String descripcion, int contador) {
        this.descripcion = descripcion;
        this.contadorSeleccion = contador;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public int getContadorSeleccion() {
        return contadorSeleccion;
    }
    
    public void incrementarContador() {
        contadorSeleccion++;
    }
    
}
