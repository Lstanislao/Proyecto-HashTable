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
    static final int Max = 50;  
    public ListaP [] tabla; //hay que ponerlo privado pero mientras necesito verla para verificar que todo este bien
    private int Elementos; 
    

    public HashTablePalabra() {
        tabla = new ListaP[Max];
        for (int i = 0; i < Max; i++) 
        {
            tabla[i]=new ListaP();
        }
        Elementos=0;
    }
    //NOTA HAY QUE VERIFICAR QUE YA NO SE HAYA INGRESADO LUIS
    /*public void InsertarPalabra(Palabra palabra)
    {
        int posicion;
        posicion=Dispersion(palabra.getWord());
        NodoP encontrado = tabla[posicion].Buscar(palabra);
        if (encontrado==null)
        {
            tabla[posicion].InsertarInicio(palabra);
            Elementos++;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"El elemento que desea ingresar ya se encuentra en la tabla");
        }

    }*/
    
    public void InsertarPalabra(String pal, String resumen)
    {
        Palabra palabra = new Palabra(pal);
        int posicion;
        posicion=Dispersion(palabra.getWord());
        NodoP encontrado = tabla[posicion].Buscar(palabra);
        if (encontrado==null)
        {
            tabla[posicion].InsertarInicio(palabra);
            Elementos++;
        }
        else
        {
            palabra = tabla[posicion].Buscar(pal);

        }
        Lista aux = palabra.getResumenes();
        aux.InsertarFinal(resumen);
        palabra.setResumenes(aux);

    }
    
    public void EliminarPalabra(Palabra palabra)
    {
        int posicion;
        posicion=Dispersion(palabra.getWord());
        NodoP eliminar = tabla[posicion].Buscar(palabra);
        tabla[posicion].Eliminar(eliminar);
        Elementos++;       
    }
    
    public Palabra BuscarPalabra(Palabra palabra)
    {
        int posicion;
        posicion=Dispersion(palabra.getWord());
        NodoP encontrado =tabla[posicion].Buscar(palabra);
        if (encontrado!=null)
        {
            Palabra aux = encontrado.getDato();
            //System.out.println(aux.getWord());
            return aux;
        }
        JOptionPane.showMessageDialog(null,"Palabra no encontrada");
        return null;

    }
    
    public Palabra BuscarPalabra(String palabra)
    {
        int posicion;
        posicion=Dispersion(palabra);
        Palabra encontrado =tabla[posicion].Buscar(palabra);
        if (encontrado!=null)
        {
            
            //System.out.println(encontrado.getWord());
            return encontrado;
        }
        JOptionPane.showMessageDialog(null,"Palabra no encontrada");
        return null;

    }
    
    public String BuscarDocumentos(String word)
    {
        Palabra aux=BuscarPalabra(word);
        String resumenes = "Las investigaciones relacionadas con "+word+" son: \n\n";
        resumenes=resumenes+(String)aux.getResumenes().ListaResumenes();
        return resumenes;
    }
    

 
    
    
    
}
