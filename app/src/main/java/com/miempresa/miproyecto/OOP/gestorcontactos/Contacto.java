
package com.miempresa.miproyecto.OOP.gestorcontactos;

/**
 *
 * @author javier
 */
public record Contacto (String nombre, int telefono, String email) {

    @Override
    public String toString() {
        return "Nombre: "+nombre+
                "\nTelefono: "+telefono+
                "\nEmail: "+email;
    }
    
}
