
package com.miempresa.miproyecto.OOPHerencia.menudebebidas.bebidas;

/**
 *
 * @author javier
 */
public class Refresco extends Bebida{
    private boolean conGas;    
    
    public Refresco(String nombre, String tamaño, boolean conGas) {
        super(nombre, tamaño);
        this.conGas = conGas;
    }

    public boolean getConGas() {
        return conGas;
    }
    
    @Override
    public String getDescripcion() {
        return String.format("""
                             \nNombre: %s
                             Tamaño: %s
                             conGas: %s
                             """, this.nombre,this.tamaño, this.conGas ? "SI" : "NO");
    }

}
