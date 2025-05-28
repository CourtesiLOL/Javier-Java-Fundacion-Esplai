
package com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas;

/**
 *
 * @author javier
 */
public class Agua extends Bebida{
    private boolean mineral;
    public Agua(String nombre, String tamaño, boolean mineral) {
        super(nombre, tamaño);
        this.mineral = mineral;
    }

    public boolean getMineral() {
        return mineral;
    }
    
    @Override
    public String getDescripcion() {
        return String.format("""
                             \nNombre: %s
                             Tamaño: %s
                             Mineral: %s
                             """, this.nombre,this.tamaño, this.mineral ? "SI" : "NO");
    }
}
