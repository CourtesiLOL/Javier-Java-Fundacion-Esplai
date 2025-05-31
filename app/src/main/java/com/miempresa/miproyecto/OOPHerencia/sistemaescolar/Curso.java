package com.miempresa.miproyecto.OOPHerencia.sistemaescolar;

import com.miempresa.miproyecto.OOPHerencia.sistemaescolar.Personas.Estudiante;
import com.miempresa.miproyecto.OOPHerencia.sistemaescolar.Personas.Profesor;
import java.util.List;

/**
 *
 * @author javier
 */
public class Curso {
    private String nombreCurso;
    private Profesor profesor;
    private List<Estudiante> estudiantes;

    public Curso(String nombreCurso, Profesor profesor, List<Estudiante> estudiantes) {
        this.nombreCurso = nombreCurso;
        this.profesor = profesor;
        this.estudiantes = estudiantes;
    }
    
    public boolean agregarEstudiante(Estudiante estudiante) {
        if (estudiante == null) return false;
        estudiantes.add(estudiante);
        return true;
    }
    
    public void mostrarParticipantes() {
        System.out.println("Participantes");
        System.out.println("-------------");
        System.out.println("Profesor: "+profesor.getName());
        System.out.println();
        estudiantes.forEach(e -> System.out.println("Estudiante: "+e.getName()));
        
    }
    
}
