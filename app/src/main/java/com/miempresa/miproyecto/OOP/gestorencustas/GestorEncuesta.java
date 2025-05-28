
package com.miempresa.miproyecto.OOP.gestorencustas;

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
        List<Encuesta> encuestas = new ArrayList<>();
        if (!importFromXML(encuestas)) {
            System.out.println("Error: No se han podido cargar las encuestas");
        }

        boolean salir = false;

        System.out.println("Gestor encuestas");
        System.out.println("----------------\n");
        System.out.println("Comandos");
        mostrarComandosDisponibles();

        while (!salir) {
            System.out.print(">");
            String userInput = scaner.nextLine();

            switch (userInput.toLowerCase()) {
                case "verencuestas" -> mostrarEncuestas(encuestas);
                case "hacerencuestas" -> realizarEncuestas(encuestas, scaner);
                case "verestadisticas" -> mostrarEstadisticas(encuestas);
                case "crearencuesta" -> crearEncuesta(encuestas, scaner);
                case "salir" -> salir = true;
                default -> {
                    System.out.println("Comando no reconocido. Comandos posibles:");
                    mostrarComandosDisponibles();
                }
            }
        }
        
        exportarEncuestas(encuestas);
    }

    private static void mostrarEncuestas(List<Encuesta> encuestas) {
        System.out.println("\nLista de encuestas");
        System.out.println("------------------");
        for (Encuesta encuesta : encuestas) {
            System.out.println(encuesta.getTitulo());
        }
    }

    private static void realizarEncuestas(List<Encuesta> encuestas, Scanner scaner) {
        for (Encuesta encuesta : encuestas) {
            encuesta.mostrarEncuesta(scaner);
        }
    }

    private static void mostrarEstadisticas(List<Encuesta> encuestas) {
        for (Encuesta encuesta : encuestas) {
            encuesta.mostrarEstadisticas();
        }
    }

    private static void crearEncuesta(List<Encuesta> encuestas, Scanner scaner) {
        System.out.print("Titulo: ");
        String titulo = scaner.nextLine();

        List<Opcion> opciones = new ArrayList<>();
        boolean fin = false;
        int count = 1;

        System.out.println("Poner . para dejar de añadir opciones");
        while (!fin) {
            System.out.print("Opcion " + count + ": ");
            String textoOpcion = scaner.nextLine();

            if (textoOpcion.isBlank()) {
                System.out.println("Error: no puede estar vacio");
                continue;
            }

            if (textoOpcion.equals(".")) {
                fin = true;
                continue;
            }

            opciones.add(new Opcion(textoOpcion));
            count++;
        }

        encuestas.add(new Encuesta(titulo, opciones.toArray(new Opcion[0])));
        System.out.println("Encuesta creada correctamente");
    }

    private static void exportarEncuestas(List<Encuesta> encuestas) {
        boolean respuesta = exportToXML(encuestas);
        System.out.println(respuesta ? "Archivo exportado correctamente" : "Error: no se puede exportar");
    }

    private static void mostrarComandosDisponibles() {        
        System.out.println(" - VerEncuestas     → Muestra las encuestas existentes");
        System.out.println(" - HacerEncuestas   → Selecciona y haces la encuesta");
        System.out.println(" - VerEstadisticas  → Ver estadísticas de una encuesta concreta");
        System.out.println(" - CrearEncuesta    → Crea tu propia encuesta");
        System.out.println(" - Salir            → Salir del programa");
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
