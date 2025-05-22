
package com.miempresa.miproyecto.registronotasalumno;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javier
 */
public class Alumno {

    private String nombre;
    private List<Double> notas;
    
    public Alumno(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void addNota(double nota) {
        notas.add(nota);
    }
    
    public double calcularPromedio() {
        double promedio = 0;
        
        for (double nota : notas) {
            promedio += nota;
        }
        
        return promedio / notas.size();
    }
    
    public boolean aprueba() {
        return calcularPromedio() >= 5 ? true : false;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Nombre: "+nombre+"\n");
        str.append("Notas\n-----\n");
        for (double nota : notas) {
            str.append(String.valueOf(nota));
            str.append("\n");
        }
        str.append("\n");
        
        double notaPromedio = calcularPromedio();
        str.append("Promedio: ");
        str.append(notaPromedio);
        str.append("\n");
        
        str.append("Aprueba: ");
        str.append(aprueba() ? "SI" : "NO");
        str.append("\n");
        
        return str.toString();
    }
}
