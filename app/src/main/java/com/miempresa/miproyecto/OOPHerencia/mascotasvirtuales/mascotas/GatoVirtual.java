package com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales.mascotas;

/**
 *
 * @author javier
 */
public class GatoVirtual extends MascotaVirtual{

    public GatoVirtual(String nombre) {
        super(nombre);
    }

    @Override
    public void comer() {
        energia += 2;
    }
}
