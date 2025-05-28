
package com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas;

/**
 *
 * @author javier
 */
public abstract class Bebida {

    protected String nombre;
    protected String tamaño;
    
    public Bebida(String nombre, String tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
    }
    
    
    public abstract String getDescripcion();

    public String getNombre() {
        return nombre;
    }

    public String getTamaño() {
        return tamaño;
    }
    
}
