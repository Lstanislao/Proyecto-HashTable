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

/**
 *
 * @author orian
 */
public class Archivo {

    /*
    Funcion que se encarga de verificar que el formato del archivo sea valido. 
    Para esto debe tener titulo, la palabra autores, la palabra resumen y las
    palabras claves.
     */
    public static boolean VerificarFormatoArchivo(File archivo) {
        boolean archivoValido;
        boolean tieneTitulo = false;
        boolean tieneAutores = false;
        boolean tieneResumen = false;
        boolean tienePalabrasClaves = false;

        String linea;
        FileReader leer;
        BufferedReader almacenamiento;
        try {
            leer = new FileReader(archivo);
            almacenamiento = new BufferedReader(leer);

            while ((linea = almacenamiento.readLine()) != null) {

                if (!"".equals(linea)) {
                    if (linea.toLowerCase().equals("autores")) {
                        tieneAutores = true;
                    } else if (linea.toLowerCase().equals("resumen")) {
                        tieneResumen = true;
                    } else if (linea.toLowerCase().startsWith("palabras claves")) {
                        tienePalabrasClaves = true;
                    } else if (!tieneAutores && !tieneResumen && !tienePalabrasClaves) {
                        tieneTitulo = true;
                    }
                }
            }

            almacenamiento.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "No se puede abrir este archivo'"
                    + archivo + "'");
        } catch (IOException ex) {
            System.out.println(
                    "No se puede leer este archivo '"
                    + archivo + "'");

        }

        archivoValido = tieneTitulo && tieneAutores && tieneResumen && tienePalabrasClaves;
        return archivoValido;
    }

    /*
    Funcion que se encarga de leer el archivo y extraer la informacion necesaria 
    del mismo: el titulo, los autores, el cuerpo del resumen y las palabras claves.
    
    Una vez que obtengo todos los campos, creo un objeto Resumen y lo agrego a la
    tabla hash.
     */
    public static void LeerArchivo(File archivo) {
        String titulo = "";
        String autores = "";
        String resumen = "";
        String palabrasClaves = "";
        boolean lineaAutores = false;
        boolean lineaResumen = false;
        boolean lineaPalabrasClaves = false;

        String linea;
        FileReader leer;
        BufferedReader almacenamiento;
        try {
            leer = new FileReader(archivo);
            almacenamiento = new BufferedReader(leer);

            while ((linea = almacenamiento.readLine()) != null) {

                if (!linea.isBlank()) {
                    if (linea.toLowerCase().equals("autores")) {
                        lineaAutores = true;
                    } else if (linea.toLowerCase().equals("resumen")) {
                        lineaAutores = false;
                        lineaResumen = true;
                    } else if (linea.toLowerCase().startsWith("palabras claves")) {
                        lineaAutores = false;
                        lineaResumen = false;
                        lineaPalabrasClaves = true;
                    } else if (!lineaAutores && !lineaResumen && !lineaPalabrasClaves) {
                        titulo += linea + " ";
                    } else if (lineaAutores) {
                        autores += linea + ", ";
                    } else if (lineaResumen) {
                        resumen += linea + " ";
                    }

                    if (lineaPalabrasClaves) {
                        palabrasClaves += linea + " ";
                    }

                }
            }

            almacenamiento.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "No se puede abrir este archivo'"
                    + archivo + "'");
        } catch (IOException ex) {
            System.out.println(
                    "No se puede leer este archivo '"
                    + archivo + "'");

        }

        // Arreglando formato del titulo
        int x = titulo.length() - 2;

        if (titulo.endsWith(". ")) {
            titulo = titulo.substring(0, x);
        } else {
            titulo = titulo.substring(0, x + 1);
        }

        // Arreglando formato del cuerpo del resumen
        resumen = resumen.replace(",", "");
        resumen = resumen.replace(".", "");

        // Arreglando formato de los autores
        autores = autores.substring(0, autores.length() - 2) + ".";

        // Arreglando formato de las palabras claves
        palabrasClaves = palabrasClaves.replace(".", "");
        while (palabrasClaves.endsWith(" ")) {
            palabrasClaves = palabrasClaves.substring(0, palabrasClaves.length() - 1);
        }

        System.out.println(palabrasClaves + "houla");

        String[] palabras = palabrasClaves.split(": ");
        String[] arregloPalabrasClaves = palabras[1].split(", ");

        for (String s : arregloPalabrasClaves) {
            System.out.println(s + "sos");
        }

        Resumen nuevoResumen = new Resumen(titulo, autores, resumen.toLowerCase(), arregloPalabrasClaves);
        HashTableResumen temp = Central.getResumenes();

        boolean seguir = temp.InsertarResumen(nuevoResumen);
        Central.setResumenes(temp);

        if (seguir) {
            String tituloTxt = titulo;
            int n = tituloTxt.length() - 1;
            //Lista aux2 = Central.getNombresResumenes();
            //System.out.println(tituloTxt+"hola");
            if (" ".equals(tituloTxt.substring(n))) {
                tituloTxt = tituloTxt.substring(0, (n));
            }
            tituloTxt = tituloTxt.replace(".", "");
            tituloTxt = tituloTxt + ".txt";
            //System.out.println("MAMGUEVO QUE TE PASA QUE NO AGARRAS EL .TXT " +tituloTxt);
            //aux2.InsertarFinal(tituloTxt);
            //System.out.println("EXPLICAMEEE\n"+aux2.ListaResumenes());
            //Central.setNombresResumenes(aux2);

            /* Una vez que ya tengo la informacion, agrego las palabras claves del resumen
        a la tabla hash y a la lista de palabras claves*/
            HashTablePalabra hash = Central.getPalabras();
            Lista aux1 = Central.getPalabrasClaves();
            for (String a : arregloPalabrasClaves) {
                boolean laInserte = hash.InsertarPalabra(a, titulo);

                if (laInserte) {
                    aux1.InsertarInicio(a);
                }
            }

            Central.setPalabrasClaves(aux1);
            Central.setPalabras(hash);

            /* Se crea objeto resumen y se asigna cada atributo. Luego se inserta a 
        la tabla hash*/
            // Agrego titulo a la lista de titulos
            Lista titulos = Central.getTitulosResumenes();
            titulos.InsertarFinal(titulo);
            Central.setTitulosResumenes(titulos);

        }

    }
}
