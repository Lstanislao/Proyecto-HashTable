/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

import HashTable.Palabra;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Stanislao
 */
public class Lista {

    private Nodo pFirst;
    private Nodo pLast;
    private Nodo Sort;
    private int Size;

//Constructor-----------------------------------------------------
    public Lista() {
        pFirst = null;
        pLast = null;
        Size = 0;
    }
//getters and setters----------------------------------------------

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public Nodo getSort() {
        return Sort;
    }

//-----------------------------------------------------------------
    // Verifica si la lista esta vacia
    public boolean EsVacio() {
        return pFirst == null;
    }

    public Nodo First() {
        return getpFirst();
    }

    public Nodo Last() {
        if (!EsVacio()) {
            Nodo aux = First();
            for (int i = 0; i < getSize(); i++) {
                if (i == getSize() - 1) {
                    setpLast(aux);
                }
                aux = Proximo(aux);
            }
            return getpLast();
        } else {
            return null;
        }
    }

    public Nodo Proximo(Nodo posicion) {
        if (posicion.getPnext() != null) {
            posicion = posicion.getPnext();
            return posicion;
        } else {
            return null;
        }
    }

    public Nodo Anterior(Nodo posicion) {
        Nodo aux = First();
        Nodo ant = First();

        boolean encontrado = false;
        if (aux == posicion) {
            return null;
        } else {
            while (aux != null && encontrado == false) {
                aux = Proximo(aux);
                if (aux == posicion) {
                    encontrado = true;
                    return ant;
                } else {
                    ant = Proximo(ant);
                }

            }
        }
        return null;
    }

    public void Eliminar(Nodo posicion) {
        if (posicion == First()) {
            if (getSize() == 1) {
                setpFirst(null);
            } else {
                Nodo sig = Proximo(posicion);
                setpFirst(sig);
            }
        } else if (posicion == Last()) {
            Nodo ant = Anterior(posicion);
            ant.setPnext(null);
            setpLast(ant);
        } else {
            Nodo ant = Anterior(posicion);
            Nodo sig = Proximo(posicion);
            ant.setPnext(sig);
        }
        setSize(getSize() - 1);

    }

    // Inserta un elemento al inicio de la lista
    public void InsertarInicio(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (EsVacio()) {

            setpFirst(nuevo);
            setpLast(nuevo);
        } else {
            Nodo aux = First();
            nuevo.setPnext(aux);
            setpFirst(nuevo);
        }
        setSize(getSize() + 1);
    }

    /* Busca un elemento en la lista y retorna el nodo donde lo encontro. Si no 
    lo encuentra, retorna null*/
    public Nodo Buscar(Object valor) {
        if (!EsVacio()) {
            boolean encontrado = false;
            Nodo pos = First();
            //while(pos!=null && encontrado==false)
            for (int i = 0; i < getSize(); i++) {
                if (pos.getDato() == valor) {
                    encontrado = true;
                    break;
                } else {
                    pos = Proximo(pos);
                }
            }
            return pos;
        } else {
            return null;
        }
    }

    // Construye un String con todos los elementos de la lista
    public String ListaResumenes() {
        String cadena = "";
        if (EsVacio() == false) {
            Nodo aux = First();
            for (int i = 0; i < getSize(); i++) {
                cadena = cadena + aux.getDato() + "\n";
                aux = aux.getPnext();
            }
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
        return cadena;
    }

    public String BuscarResumenes() {
        String cadena = "";
        if (EsVacio() == false) {
            Nodo aux = First();
            for (int i = 0; i < getSize(); i++) {
                cadena = cadena + aux.getDato() + ", ";
                aux = aux.getPnext();
            }
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
        return cadena;

    }

    // Inserta un elemento al final de la lista
    public void InsertarFinal(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (EsVacio()) {

            setpFirst(nuevo);
            setpLast(nuevo);
        } else {
            Nodo aux = Last();
            aux.setPnext(nuevo);
            setpLast(nuevo);
        }
        setSize(getSize() + 1);

    }

}
