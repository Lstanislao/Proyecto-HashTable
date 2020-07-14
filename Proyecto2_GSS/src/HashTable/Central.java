/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

import Listas.Lista;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Stanislao
 */
public class Central {

    private static Lista PalabrasClaves = new Lista();
    private static Lista NombresResumenes = new Lista();
    private static HashTablePalabra Palabras = new HashTablePalabra();
    private static HashTableResumen Resumenes = new HashTableResumen();
    private static boolean Iniciado = false;

    public static boolean isIniciado() {
        return Iniciado;
    }

    public static void setIniciado(boolean Iniciado) {
        Central.Iniciado = Iniciado;
    }

    public static Lista getPalabrasClaves() {
        return PalabrasClaves;
    }

    public static void setPalabrasClaves(Lista PalabrasClaves) {
        Central.PalabrasClaves = PalabrasClaves;
    }

    public static Lista getNombresResumenes() {
        return NombresResumenes;
    }

    public static void setNombresResumenes(Lista NombresResumenes) {
        Central.NombresResumenes = NombresResumenes;
    }

    public static HashTablePalabra getPalabras() {
        return Palabras;
    }

    public static void setPalabras(HashTablePalabra Palabras) {
        Central.Palabras = Palabras;
    }

    public static HashTableResumen getResumenes() {
        return Resumenes;
    }

    public static void setResumenes(HashTableResumen Resumenes) {
        Central.Resumenes = Resumenes;
    }

    /*
    Funcion para guardar en el archivo por defecto los resumenes del repositorio
    para que al correr el programa se puedan cargar.
     */
    public static void GuardarResumenesCargados() {
        String resumenes = NombresResumenes.ListaResumenes();
        System.out.println(resumenes);

        File archivo;
        PrintWriter escribir;
        archivo = new File("ArchivoPorDefecto.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new PrintWriter(archivo, "utf-8");
                escribir.println();
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                escribir = new PrintWriter(archivo, "utf-8");
                escribir.println(resumenes);
                escribir.close();
            } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*
    Funcion que se encarga de leer el archivo por defecto, obtener los resumenes
    del repositorio y leerlos para cargar las tablas hash.
     */
    public static void CargarResumenes() {
        File miArchivo;
        miArchivo = new File("ArchivoPorDefecto.txt");
        String linea;
        try {
            FileReader leer = new FileReader(miArchivo);
            BufferedReader almacenado = new BufferedReader(leer);
            linea = "";
            while (linea != null) {
                try {
                    linea = almacenado.readLine();
                    if (!"".equals(linea) && linea != null) {
                        System.out.println(linea + "me tienes YA LADILLADO");
                        NombresResumenes.InsertarFinal(linea);
                        File cargar = new File(linea);
                        Archivo.LeerArchivo(cargar);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Central.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Central.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*Grafo mygraph = new Grafo(1000);
        File miArchivo;
        String nombre, calle, urb, line, cadena[];
        int v1, v2, distancia;
        miArchivo = new File("ArchivoPorDefecto.txt");
        boolean lineaClientes = false;
        boolean lineaCaminos = false;
        
        try {
            FileReader fileReader
                    = new FileReader(miArchivo);
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

           
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("")) {
                    if (line.toLowerCase().equals("clientes")) {
                        lineaClientes = true;
                        line = bufferedReader.readLine();
                    }
                    if (line.toLowerCase().equals("caminos")) {
                        lineaClientes = false;
                        line = bufferedReader.readLine();
                        lineaCaminos = true;
                    }

                    // Parte que inserta clientes en la lista clientes
                    if (lineaClientes) {
                        line = line.replace(", ", ",");
                        cadena = line.split(",");
                        nombre = cadena[1];
                        urb = cadena[2];
                        if (cadena.length > 3) {
                            calle = cadena[3];
                        } else {
                            calle = "";
                        }
                        
                        mygraph.NuevoV(nombre, calle, urb);

                        // Parte que inserta caminos en la lista caminos
                    } else if (lineaCaminos) {
                        line = line.replace(", ", ",");
                        cadena = line.split(",");
                        String vertice1 = cadena[0];
                        String vertice2 = cadena[0];
                        if (!vertice1.equals("") && !vertice2.equals("")) {
                            
                            v1 = Integer.parseInt(cadena[0]) - 1;
                            v2 = Integer.parseInt(cadena[1]) - 1;
                            distancia = Integer.parseInt(cadena[2]);
                            mygraph.NuevoA(v1, v2, distancia);
                            
                        }
                    }
                }
                
            }
            
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "No se puede abrir este archivo'"
                    + miArchivo + "'");
        } catch (IOException ex) {
            System.out.println(
                    "No se puede leer este archivo '"
                    + miArchivo + "'");
            
        } catch (IndexOutOfBoundsException ex) {
            
        }
        Central.setGraph(mygraph);
    }
     */
}
