package com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales.mascotas;

/**
 *
 * @author javier
 */
public class HamsterVirtual extends MascotaVirtual {

    public HamsterVirtual(String nombre) {
        super(nombre);
    }

    @Override
    public void jugar() {
        energia -= 2;
        felicidad++;
    }
}
