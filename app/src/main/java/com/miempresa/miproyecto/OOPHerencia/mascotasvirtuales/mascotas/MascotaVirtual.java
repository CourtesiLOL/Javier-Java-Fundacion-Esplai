package com.miempresa.miproyecto.OOPHerencia.mascotasvirtuales.mascotas;

/**
 *
 * @author javier
 */
public abstract class MascotaVirtual {
    protected String nombre;
    protected int energia;
    protected int felicidad;

    public MascotaVirtual(String nombre) {
        this.nombre = nombre;
        this.energia = 100;
        this.felicidad = 100;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public int getFelicidad() {
        return felicidad;
    }        
    
    public void comer() {
        energia++;
    }
    public void jugar() {
        energia--;
        felicidad++;
    }
    public void mostrarEstado() {
        System.out.println("Estado");
        System.out.println("------");
        System.out.println();
        System.out.println("Nombre: "+nombre);
        System.out.println("Energia: "+energia);
        System.out.println("Felicidad: "+felicidad);
    }
    
}
