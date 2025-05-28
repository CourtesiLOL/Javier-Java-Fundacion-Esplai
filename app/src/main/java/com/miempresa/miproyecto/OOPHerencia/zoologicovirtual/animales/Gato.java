
package com.miempresa.miproyecto.OOPHerencia.zoologicovirtual.animales;

/**
 *
 * @author javier
 */
public class Gato extends Animal{

    public Gato(String name, int edad) {
        super(name, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println("¡Miau!");
    }
    
}
