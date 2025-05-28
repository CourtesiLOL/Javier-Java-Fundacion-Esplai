
package com.miempresa.miproyecto.OOPHerencia.zoologicovirtual.animales;

/**
 *
 * @author javier
 */
public abstract class Animal {

    protected String name;
    protected int edad;
    
    public Animal(String name, int edad) {
        this.name = name;
        this.edad = edad;
    }
    
    public abstract void hacerSonido();
    
    public String getName() {
        return name;
    }
    
    public int getEdad() {
        return edad;
    }
}
