
package com.miempresa.miproyecto.OOPHerencia.zoologicovirtual.animales;

/**
 *
 * @author javier
 */
public class Pajaro extends Animal{

    public Pajaro(String name, int edad) {
        super(name, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println("¡Pío pío!");
    }

}
