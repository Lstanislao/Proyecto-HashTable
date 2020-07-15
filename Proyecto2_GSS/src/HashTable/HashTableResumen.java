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

    private static final int Max = 50;
    public ListaR[] tabla; //hay que ponerlo privado pero mientras necesito verla para verificar que todo este bien
    private int Elementos; // SE VA?

    /* 
    Constructor de la tabla. Cada posicion se incicializa con una lista de  
    objetos palabra. Este fue el metodo elegido para tratar las colisiones.
     */
    public HashTableResumen() {
        tabla = new ListaR[Max];
        for (int i = 0; i < Max; i++) {
            tabla[i] = new ListaR();
        }
        Elementos = 0;
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
            Elementos++;
            //NombresResumenes.InsertarInicio(resumen.getTitulo());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "La investigación ya ha sido "
                    + "ingresada anteriormente.\nIntente agregar una investigación"
                    + " diferente.");
            return false;
        }
    }

//     public void EliminarResumen(Resumen resumen)
//    {
//        int posicion;
//        posicion=Dispersion(resumen.getAutores());
//        NodoR eliminar = tabla[posicion].Buscar(resumen);
//        tabla[posicion].Eliminar(eliminar);
//        Elementos++;       
//    }
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
            //System.out.println(aux.getTitulo());
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
            //System.out.println(aux.getTitulo());
            return aux;
        }

        return null;

    }

}
