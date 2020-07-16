/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

//import static HashTable.Central.NombresResumenes;
import static HashTable.FuncionHash.Dispersion;
import Listas.ListaR;
import Listas.NodoR;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Stanislao
 */
public class HashTableResumen {

    private static final int MAX = 100;
    public ListaR[] tabla; //Arreglo con el cual funciona el hash table


    /* 
    Constructor de la tabla. Cada posicion se incicializa con una lista de  
    objetos palabra. Este fue el metodo elegido para tratar las colisiones.
     */
    public HashTableResumen() {
        tabla = new ListaR[MAX];
        for (int i = 0; i < MAX; i++) {
            tabla[i] = new ListaR();
        }
    }

    /*
    Funcion que se encarga de insertar en la tabla hash un resumen nuevo.
    En caso de que el resumen ya pertenezca a la tabla, se muestra un mensaje.
     */
    public boolean InsertarResumen(Resumen resumen) {
        int posicion;
        posicion = Dispersion(resumen.getTitulo());
        NodoR encontrado = tabla[posicion].Buscar(resumen);
        if (encontrado == null) {
            tabla[posicion].InsertarInicio(resumen);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "La investigación ya ha sido "
                    + "ingresada anteriormente.\nIntente agregar una investigación"
                    + " diferente.");
            return false;
        }
    }

    /*
    Funcion que a partir de un objeto resumen, verifica si dicho resumen ya 
    pertenece a la tabla hash.
     */
    public Resumen BuscarResumen(Resumen resumen) {
        int posicion;
        posicion = Dispersion(resumen.getTitulo());
        NodoR encontrado = tabla[posicion].Buscar(resumen);
        if (encontrado != null) {
            Resumen aux = encontrado.getDato();
            return aux;
        }

        return null;

    }

    /*
    Funcion que a partir del titulo de la investigacion, verifica si un resumen 
    ya pertenece a la tabla hash.
     */
    public Resumen BuscarResumen(String resumen) {
        int posicion;
        posicion = Dispersion(resumen);
        NodoR encontrado = tabla[posicion].Buscar(resumen);
        if (encontrado != null) {
            Resumen aux = encontrado.getDato();
            return aux;
        }

        return null;

    }

}
