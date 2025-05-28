
package com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas;

/**
 *
 * @author javier
 */
public class Zumo extends Bebida{
    private String fruta;
    public Zumo(String nombre, String tamaño, String fruta) {
        super(nombre, tamaño);
        this.fruta = fruta;
    }

    public String getFruta() {
        return fruta;
    }
    
    @Override
    public String getDescripcion() {
        return String.format("""
                             \nNombre: %s
                             Tamaño: %s
                             Fruta: %s
                             """, this.nombre,this.tamaño, this.fruta);
    }
}
