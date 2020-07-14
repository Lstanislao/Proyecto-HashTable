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
                    System.out.println(linea);
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

    public static Resumen LeerArchivo(File archivo) {
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

                if (!"".equals(linea)) {
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

        resumen = resumen.replace(",", "");
        resumen = resumen.replace(".", "");
        autores = autores.substring(0, autores.length() - 1) + ".";
        palabrasClaves = palabrasClaves.replace(".", "");
        String[] palabras = palabrasClaves.split(": ");
        String[] arregloPalabrasClaves = palabras[1].split(", ");
        
       
        int n;
                String tituloTxt=titulo;
        n = tituloTxt.length()-1;
        Lista aux2 = Central.getNombresResumenes();
        //System.out.println(tituloTxt+"hola");
        if(" ".equals(tituloTxt.substring(n)))
        {
            tituloTxt=tituloTxt.substring(0,(n));
        }
        tituloTxt=tituloTxt.replace(".","");
        tituloTxt=tituloTxt+".txt";
        System.out.println("MAMGUEVO QUE TE PASA QUE NO AGARRAS EL .TXT " +tituloTxt);
        aux2.InsertarFinal(tituloTxt);
        System.out.println("EXPLICAMEEE\n"+aux2.ListaResumenes());
        Central.setNombresResumenes(aux2);
        
        
        
        HashTablePalabra hash = Central.getPalabras();
        Lista aux1 = Central.getPalabrasClaves();
        for (String a : arregloPalabrasClaves) {
            n=a.length()-1;
            if(" ".equals(a.substring(n)))
            {
                //System.out.println(a+"Entre");
                hash.InsertarPalabra(a,tituloTxt);
                a=a.substring(0,(n));
                aux1.InsertarInicio(a);
                System.out.println(a+"Entre");

            }
            else
            {
                aux1.InsertarInicio(a);
                hash.InsertarPalabra(a,tituloTxt);
                //System.out.println(a);
                
            }
            

        }
        Central.setPalabrasClaves(aux1);
        Central.setPalabras(hash);
        
        

        
        

        // Se crea objeto resumen y se asigna cada atributo y se inserta al hash
        Resumen nuevoResumen = new Resumen(titulo, autores, resumen.toLowerCase(), arregloPalabrasClaves);
        
        HashTableResumen temp = Central.getResumenes();
        temp.InsertarResumen(nuevoResumen);
        Central.setResumenes(temp);
        
        return nuevoResumen;
    }
}
