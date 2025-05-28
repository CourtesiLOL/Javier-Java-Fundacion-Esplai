
package com.miempresa.miproyecto.OOPHerencia.zoologicovirtual.animales;

/**
 *
 * @author javier
 */
public class Perro extends Animal{

    public Perro(String name, int edad) {
        super(name, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println("¡Guau guau!");
    }
    
}
