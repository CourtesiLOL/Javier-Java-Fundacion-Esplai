
package com.miempresa.miproyecto.OOP.gestorcontactos;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author javier
 */
public class Agenda {
    
    private List<Contacto> contactos;
    
    public Agenda() {
        this.contactos = new ArrayList();
    }
    
    public boolean agregar(Contacto contacto) {
        //Si el contacto existe no lo agrega
        if (searchContacto(contacto.nombre()) != null) return false;
        
        contactos.add(contacto);
        return true;
    }
    
    public Contacto buscar(String nombre) {
        return searchContacto(nombre);
    }

    private Contacto searchContacto(String name) {
        
        for (Contacto c : contactos) {
            if (c.nombre().equalsIgnoreCase(name)) return c;
        }
        
        return null;
        
    }
    
    public void mostrarContactos() {
        
        System.out.println("Mostrar Contactos");
        System.out.println("---------");
        
        for (Contacto c : contactos) {
            System.out.println("\n"+c.toString());
        }
        
    }
    
    public void borrarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }
}
