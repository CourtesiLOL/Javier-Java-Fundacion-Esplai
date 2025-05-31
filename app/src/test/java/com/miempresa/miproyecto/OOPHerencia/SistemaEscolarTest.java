package com.miempresa.miproyecto.OOPHerencia;

import com.miempresa.miproyecto.OOPHerencia.sistemaescolar.Curso;
import com.miempresa.miproyecto.OOPHerencia.sistemaescolar.Personas.Estudiante;
import com.miempresa.miproyecto.OOPHerencia.sistemaescolar.Personas.Profesor;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author javier
 */
@DisplayName("Sistema Escolar")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SistemaEscolarTest {

    @Test
    @Order(1)
    void sitemaCompleto() {
        Profesor profesor = new Profesor("Pepe", 28, "Programacion");
        Assertions.assertNotNull(profesor);
        
        Estudiante estudianteTemp;
        List<Estudiante> estudiantes = new ArrayList();
        Assertions.assertNotNull(estudiantes);
        
        estudianteTemp = new Estudiante("Maria", 20, "Programacion");
        Assertions.assertNotNull(estudianteTemp);
        estudiantes.add(estudianteTemp);
        
        estudianteTemp = new Estudiante("Juan", 22, "Matemáticas");
        Assertions.assertNotNull(estudianteTemp);
        estudiantes.add(estudianteTemp);
        
        estudianteTemp = new Estudiante("Luis", 19, "Física");
        Assertions.assertNotNull(estudianteTemp);
        estudiantes.add(estudianteTemp);
        
        estudianteTemp = new Estudiante("Carlos", 23, "Ingeniería");
        Assertions.assertNotNull(estudianteTemp);
        estudiantes.add(estudianteTemp);
        
        estudianteTemp = new Estudiante("Maria", 20, "Programacion");
        Assertions.assertNotNull(estudianteTemp);
        estudiantes.add(estudianteTemp);                
        
        
        
        Curso curso = new Curso("Programacion", profesor, estudiantes);
        Assertions.assertNotNull(curso);
        
        Assertions.assertEquals(5, estudiantes.size());
        curso.agregarEstudiante(new Estudiante("David",18,"Cocina"));
        Assertions.assertEquals(6, estudiantes.size());
    }
}
