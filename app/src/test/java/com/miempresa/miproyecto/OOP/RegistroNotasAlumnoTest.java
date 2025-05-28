package com.miempresa.miproyecto.OOP;

import com.miempresa.miproyecto.OOP.registronotasalumno.Alumno;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
@DisplayName("Test Alumnos")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistroNotasAlumnoTest {
    List<Alumno> alumnos = new ArrayList();

    @Test
    @Order(1)
    void instanciarAlumnos() {        
        Alumno tempAlumn;
        
        tempAlumn = new Alumno("Pepe");
        Assertions.assertNotNull(tempAlumn);
        alumnos.add(tempAlumn);
        
        tempAlumn = new Alumno("Maria");
        Assertions.assertNotNull(tempAlumn);
        alumnos.add(tempAlumn);
        
        tempAlumn = new Alumno("Pablo");
        Assertions.assertNotNull(tempAlumn);
        alumnos.add(tempAlumn);
             
        
    }
    
    @Test
    @Order(2)
    void insercionYvalidacionNotas() {
        
        Random rand = new Random();
        for (var alum : alumnos) {
            Assertions.assertTrue(alum.addNota(rand.nextDouble(0, 10)));
            Assertions.assertTrue(alum.addNota(rand.nextDouble(0, 10)));
            Assertions.assertTrue(alum.addNota(rand.nextDouble(0, 10)));
            
            Assertions.assertFalse(alum.addNota(-15));
            Assertions.assertFalse(alum.addNota(11));

        }
    }
    
}
