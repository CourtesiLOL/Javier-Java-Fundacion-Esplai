
package com.miempresa.miproyecto.gestorpersonas;

/**
 *
 * @author javier
 */
public class Persona {

    private String nombre;
    private int edad;
    private String correo;

    public Persona(String nombre, int edad, String correo) {              
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }    

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
        

    public String getCorreo() {
        return correo;
    }    
    
    public boolean esMayorDeEdad() {
        return edad >=18;
    }
    
    public boolean correoValido() {
        
        if (this.correo == null || this.correo.isEmpty()) return false;    
        if (!this.correo.contains("@")) return false;
        
        return true;
    }
    
    @Override
    public String toString() {
        
        return "Nombre: "+this.nombre+
                "\nEdad: "+String.valueOf(this.edad)+ 
                "\nCorreo: "+this.correo+"\nMayor de edad: "+this.esMayorDeEdad()+
                "\nCorreo valido: "+correoValido();
    }
}
