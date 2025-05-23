
package com.miempresa.miproyecto.gestorencustas;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author javier
 */
public class GestorEncuesta {

    public static void gestorEncuestas(Scanner scaner) {
        List<Encuesta> encuestas = new ArrayList();        
        if (!importFromXML(encuestas)) System.out.println("Error: No se han podido cargar las encuestas");       
        
        boolean salir = false;

        System.out.println("Gestor encuestas");
        System.out.println("----------------");

        while (!salir) {
            System.out.print(">");
            String userInput = scaner.nextLine();            
            
            switch (userInput.toLowerCase()) {
                case "verencuestas":
                    System.out.println("\nLista de encuestas");
                    System.out.println("------------------");
                    
                    for (Encuesta encuesta : encuestas) {
                        System.out.println(encuesta.getTitulo());
                    }
                    break;

                case "hacerencuestas":
                    
                    for (Encuesta encuesta : encuestas) {
                        encuesta.mostrarEncuesta(scaner);
                    }                    
                    
                    break;

                case "verestadisticas":
                  
                    for (Encuesta encuesta : encuestas) {
                        encuesta.mostrarEstadisticas();
                    }      
                    
                    break;
                    
                case "crearencuesta":
                    System.out.print("Titulo: ");
                    String titulo = scaner.nextLine();
                    
                    List<Opcion> opciones = new ArrayList();
                    
                    boolean fin = false;                    
                    int count = 1;
                    String textoOpcion;
                    
                    System.out.println("Poner . para dejar de añadir opciones");
                    while (!fin) {
                        System.out.print("Opcion "+count+": ");
                        textoOpcion = scaner.nextLine();
                        if (textoOpcion.isBlank()) {
                            System.out.println("Error: no puede estar vacio");
                            continue;
                        }
                        if (textoOpcion.equals(".")) {
                            fin = true;
                            continue;
                        }
                        count++;
                        opciones.add(new Opcion(textoOpcion));
                    }
                                        
                    encuestas.add(new Encuesta(titulo, opciones.toArray(new Opcion[0])));
                    System.out.println("Encuesta creada correctamente");                   
                    
                    break;
                    
                case "exportar":                    
                    
                    boolean respuesta = exportToXML(encuestas);
                    System.out.println(respuesta ? "Archivo exportado correctamente" : "Error: no se puede exportar");
                    break;
                  
                    
                case "salir":
                    salir = true;
                    break;

                default:
                    System.out.println("Comando no reconocido. Comandos posibles:");
                    System.out.println(" - VerEncuestas   → Mustra las encuestas existentes");
                    System.out.println(" - HacerEncuestas    → Selecciona y haces la encuesta");
                    System.out.println(" - VerEstadisticas → ver estadisticas de una encuesta concreta");
                    System.out.println(" - CrearEncuesta → creas tu propia encuesta");
                    System.out.println(" - Exportar → exporta las encuestas en un archivo");
                    System.out.println(" - salir → salir de la lista de tareas");

            }
        }        
    }
    
    private static Encuesta buscarEncuesta(String titulo, List<Encuesta> encuestas) {
        for (Encuesta encuesta : encuestas) {
            if (encuesta.getTitulo().equalsIgnoreCase(titulo)) return encuesta;
        }

        return null;
    }
    
    private static boolean exportToXML(List<Encuesta> encuestas) {
                        
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer;
        try {
            Path path = Paths.get("output", "Encuesta.xml");
            Files.createDirectories(path.getParent()); // Crea la carpeta si no existe 
            
            FileWriter tempFileWriter = new FileWriter(path.toFile());
            
            writer = factory.createXMLStreamWriter(tempFileWriter);

            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("encuestas");

            for (Encuesta encuesta : encuestas) {
                writer.writeStartElement("encuesta");

                writer.writeStartElement("titulo");
                writer.writeCharacters(encuesta.getTitulo());
                writer.writeEndElement();

                for (Opcion op : encuesta.getOptions()) {
                    writer.writeStartElement("opcion");
                    
                    writer.writeStartElement("contador");
                    writer.writeCharacters(String.valueOf(op.getContadorSeleccion()));
                    writer.writeEndElement();
                    
                    writer.writeStartElement("descipcion");                    
                    writer.writeCharacters(op.getDescripcion());
                    writer.writeEndElement();
                    
                    writer.writeEndElement();
                }
                
                writer.writeEndElement();
                


            }            
            
            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();            

        } catch (XMLStreamException | IOException ex) {
            return false;
        }
        
        return true;
    }
    
    private static boolean importFromXML(List<Encuesta> encuestas) {
        
        try {
            Path path = Paths.get("output", "Encuesta.xml");
            if (!Files.exists(path)) {
                return false;
            }
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(path.toFile());
            doc.getDocumentElement().normalize();

            NodeList encuestasXML = doc.getElementsByTagName("encuesta");

            for (int i = 0; i < encuestasXML.getLength(); i++) {
                Element encuestaElement = (Element) encuestasXML.item(i);
                String titulo = encuestaElement.getElementsByTagName("titulo").item(0).getTextContent();
                NodeList opcionesXML = encuestaElement.getElementsByTagName("opcion");
                List<Opcion> opciones = new ArrayList<>();

                for (int j = 0; j < opcionesXML.getLength(); j++) {
                    Element opcionElement = (Element) opcionesXML.item(j);
                    int contador = Integer.parseInt(opcionElement.getElementsByTagName("contador").item(0).getTextContent().trim());
                    String descripcion = opcionElement.getElementsByTagName("descipcion").item(0).getTextContent().trim();
                    opciones.add(new Opcion(descripcion, contador));
                }

                encuestas.add(new Encuesta(titulo, opciones.toArray(new Opcion[0])));
            }
            
            
            
            
            
        }catch(SAXException | IOException | ParserConfigurationException ex) {
            return false;
        }
        
        return true;
    }
}
