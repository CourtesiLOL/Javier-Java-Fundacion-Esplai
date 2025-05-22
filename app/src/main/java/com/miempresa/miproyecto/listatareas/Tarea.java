
package com.miempresa.miproyecto.listatareas;

/**
 *
 * @author javier
 */
public class Tarea {    
    
    private static int tareasTotal = 0;
    private static int tareasCompletas = 0;
    
    private String titulo;
    private String descripcion;
    private Estado estado;

    public Tarea(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = Estado.PENDIENTE;
        tareasTotal++;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Estado getEstado() {
        return estado;
    }
    
    public void completar() {
        if (estado == Estado.COMPLETADA) return;
        
        this.estado = Estado.COMPLETADA;
        tareasCompletas++;
    }
    
    public static void tareasCompletadas() {
        System.out.println("Tareas completadas: "+tareasCompletas);
    }
    
    public static void tareasPendiente() {
        System.out.println("Tareas pendiente: "+ (tareasTotal - tareasCompletas));
    }
    
    @Override
    public String toString() {
        
    return """
           Titulo: %s
           Descripcion: %s
           Estado: %s
           """.formatted(this.titulo, this.descripcion, this.estado);
    }
    
}
