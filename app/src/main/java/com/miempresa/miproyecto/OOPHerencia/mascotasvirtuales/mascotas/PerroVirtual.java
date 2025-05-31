package com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales.mascotas;

/**
 *
 * @author javier
 */
public class PerroVirtual extends MascotaVirtual{

    public PerroVirtual(String nombre) {
        super(nombre);
    }


    @Override
    public void jugar() {
        energia--;
        felicidad += 2;
    }
    
}
