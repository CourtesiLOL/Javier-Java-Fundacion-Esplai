package com.miempresa.miproyecto.OOPHerencia.recetariodigital;

/**
 *
 * @author javier
 */
public class Ingrediente {
    private String nombre;
    private int cantidad;
    private String unidad;

    public Ingrediente(String nombre, int cantidad, String unidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getUnidad() {
        return unidad;
    }
    
    @Override
    public String toString() {
        return String.format(
                """
                Nombre: %s
                Cantidad: %d
                Unidad: %s
                """, nombre,cantidad,unidad);
    }
}
