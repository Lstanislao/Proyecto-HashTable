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
    private static Lista NombresResumenes = new Lista();//Nombre de los txt donde se encuentran los resumenes
    private static HashTablePalabra Palabras = new HashTablePalabra();
    private static HashTableResumen Resumenes = new HashTableResumen();
    private static boolean Iniciado = false;
    private static Lista TitulosResumenes = new Lista();

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

    public static Lista getTitulosResumenes() {
        return TitulosResumenes;
    }

    public static void setTitulosResumenes(Lista TitulosResumenes) {
        Central.TitulosResumenes = TitulosResumenes;
    }

    /*
    Funcion para guardar en el archivo por defecto los resumenes del repositorio
    para que al correr el programa se puedan cargar.
     */
    public static void GuardarResumenesCargados() {
        String resumenes = NombresResumenes.ListaResumenes();
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
    del repositorio y acceder a dichos archivos para cargar la informacion a las
    tablas hash.
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
                        NombresResumenes.InsertarFinal(linea);
                        File cargar = new File(linea);
                        boolean b = Archivo.LeerArchivo(cargar);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Central.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Central.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
