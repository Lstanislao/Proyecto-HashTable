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
    public ListaR [] tabla; //hay que ponerlo privado pero mientras necesito verla para verificar que todo este bien
    private int Elementos; 
    

    public HashTableResumen() {
        tabla = new ListaR[Max];
        for (int i = 0; i < Max; i++) 
        {
            tabla[i]=new ListaR();
        }
        Elementos=0;
    }
    
    public void InsertarResumen(Resumen resumen)
    {
        int posicion;
        posicion=Dispersion(resumen.getTitulo());
        NodoR encontrado = tabla[posicion].Buscar(resumen);
        if (encontrado==null)
        {
            tabla[posicion].InsertarInicio(resumen);
            Elementos++;
            //NombresResumenes.InsertarInicio(resumen.getTitulo());
        }
        else
        {
            JOptionPane.showMessageDialog(null,"El elemento que desea ingresar ya se encuentra en la tabla");
        }
    }
    
   /* public void EliminarResumen(Resumen resumen)
    {
        int posicion;
        posicion=Dispersion(resumen.getAutores());
        NodoR eliminar = tabla[posicion].Buscar(resumen);
        tabla[posicion].Eliminar(eliminar);
        Elementos++;       
    }*/
        
    public Resumen BuscarResumen(Resumen resumen)
    {
        int posicion;
        posicion=Dispersion(resumen.getTitulo());
        NodoR encontrado =tabla[posicion].Buscar(resumen);
        if (encontrado!=null)
        {
            Resumen aux = encontrado.getDato();
            //System.out.println(aux.getTitulo());
            return aux;
        }
        JOptionPane.showMessageDialog(null,"Resumen no encontrado");
        return null;

    }
    
    public Resumen BuscarResumen(String resumen)
    {
        int posicion;
        posicion=Dispersion(resumen);
        NodoR encontrado =tabla[posicion].Buscar(resumen);
        if (encontrado!=null)
        {
            Resumen aux = encontrado.getDato();
            //System.out.println(aux.getTitulo());
            return aux;
        }
        JOptionPane.showMessageDialog(null,"Resumen no encontrado");
        return null;

    }
    
    
}
