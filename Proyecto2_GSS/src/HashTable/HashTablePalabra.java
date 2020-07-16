/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

import Listas.NodoP;
import Listas.ListaP;
import static HashTable.FuncionHash.Dispersion;
import Listas.Lista;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Stanislao
 */
public class HashTablePalabra {

    static final int Max = 100;
    private ListaP[] tabla; //arreglo que funciona como hashtable


    /* 
    Constructor de la tabla. Cada posicion se incicializa con una lista de  
    objetos palabra. Este fue el metodo elegido para tratar las colisiones.
     */
    public HashTablePalabra() {
        tabla = new ListaP[Max];
        for (int i = 0; i < Max; i++) {
            tabla[i] = new ListaP();
        }
    }
    /*
    Funcion que se encarga de insertar en la tabla hash una palabra clave nueva.
    En caso de que la palabra clave ya pertenezca a la tabla, se agrega el titulo 
    del resumen a la lista de resumenes relacionados con la palabra clave.
     */
    public boolean InsertarPalabra(String pal, String resumen) {
        boolean insertada = false;
        pal = pal.toLowerCase();
        Palabra palabra = new Palabra(pal);
        int posicion;
        posicion = Dispersion(palabra.getWord());
        NodoP encontrado = tabla[posicion].Buscar(palabra);
        if (encontrado == null) {
            tabla[posicion].InsertarInicio(palabra);
            insertada = true;
        } else {
            palabra = tabla[posicion].Buscar(pal);

        }
        Lista aux = palabra.getResumenes();
        aux.InsertarFinal(resumen);
        palabra.setResumenes(aux);

        return insertada;
    }
    /*
    Funcion que a partir de un objeto palabra verifica si una palabra clave ya 
    pertenece a la tabla hash.
     */
    public Palabra BuscarPalabra(Palabra palabra) {
        int posicion;
        posicion = Dispersion(palabra.getWord());
        NodoP encontrado = tabla[posicion].Buscar(palabra);
        if (encontrado != null) {
            Palabra aux = encontrado.getDato();
           
            return aux;
        }
        JOptionPane.showMessageDialog(null, "Palabra no encontrada");
        return null;

    }

    /*
    Funcion que a partir de un string que contiene una palabra clave, verifica 
    si dicha palabra clave ya pertenece a la tabla hash.
     */
    public Palabra BuscarPalabra(String palabra) {
        palabra = palabra.toLowerCase();
        int posicion;
        posicion = Dispersion(palabra);
        Palabra encontrado = tabla[posicion].Buscar(palabra);
        if (encontrado != null) {

            
            return encontrado;
        }

        return null;

    }

    /*
    Funcion que busca las investigaciones relacionas con una palabra clave.
     */
    public String BuscarDocumentos(String word) {
        word = word.toLowerCase();
        Palabra aux = BuscarPalabra(word);
        String resumenes = "Las investigaciones relacionadas con '" + word + "' son: \n\n";
        if (aux != null) {
            resumenes += (String) aux.getResumenes().ListaResumenes();
            return resumenes;
        }
        return null;

    }

}
