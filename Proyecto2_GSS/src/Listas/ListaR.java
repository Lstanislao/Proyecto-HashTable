/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

import HashTable.Resumen;
import Listas.NodoR;

/**
 *
 * @author Luis Stanislao
 */
public class ListaR {

    private NodoR pFirst;
    private NodoR pLast;
    private int Size;

//Constructor-----------------------------------------------------
    public ListaR() {
        pFirst = null;
        pLast = null;
        Size = 0;
    }
//getters and setters----------------------------------------------

    public NodoR getpFirst() {
        return pFirst;
    }

    public void setpFirst(NodoR pFirst) {
        this.pFirst = pFirst;
    }

    public NodoR getpLast() {
        return pLast;
    }

    public void setpLast(NodoR pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

//-----------------------------------------------------------------
    // Verifica si la lista esta vacia
    public boolean EsVacio() {
        return pFirst == null;
    }

    public NodoR First() {
        return getpFirst();
    }

    public NodoR Last() {
        if (!EsVacio()) {
            NodoR aux = First();
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

    public NodoR Proximo(NodoR posicion) {
        if (posicion.getPnext() != null) {
            posicion = posicion.getPnext();
            return posicion;
        } else {
            return null;
        }
    }

    public NodoR Anterior(NodoR posicion) {
        NodoR aux = First();
        NodoR ant = First();

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

    public void Eliminar(NodoR posicion) {
        if (posicion == First()) {
            if (getSize() == 1) {
                setpFirst(null);
            } else {
                NodoR sig = Proximo(posicion);
                setpFirst(sig);
            }
        } else if (posicion == Last()) {
            NodoR ant = Anterior(posicion);
            ant.setPnext(null);
            setpLast(ant);
        } else {
            NodoR ant = Anterior(posicion);
            NodoR sig = Proximo(posicion);
            ant.setPnext(sig);
        }
        setSize(getSize() - 1);
    }

    // Inserta un elemento al inicio de la lista
    public void InsertarInicio(Resumen dato) {
        NodoR nuevo = new NodoR(dato);
        if (EsVacio()) {

            setpFirst(nuevo);
            setpLast(nuevo);
        } else {
            NodoR aux = First();
            nuevo.setPnext(aux);
            setpFirst(nuevo);
        }
        setSize(getSize() + 1);
    }

    /* 
    Funcion que a partir de un objeto resumen, busca un titulo en la lista y 
    retorna el nodo donde lo encontro. Si no lo encuentra, retorna null.
     */
    public NodoR Buscar(Resumen valor) {
        if (!EsVacio()) {
            boolean encontrado = false;
            NodoR pos = First();
            //while(pos!=null && encontrado==false)
            for (int i = 0; i < getSize(); i++) {
                if (pos.getDato().getTitulo().equals(valor.getTitulo())) {
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

    /* 
    Funcion que a partir de un string con el titulo de la investigacion, busca 
    un titulo en la lista y retorna el nodo donde lo encontro. Si no lo encuentra,
    retorna null.
     */
    public NodoR Buscar(String valor) {
        if (!EsVacio()) {
            boolean encontrado = false;
            NodoR pos = First();
            //while(pos!=null && encontrado==false)
            for (int i = 0; i < getSize(); i++) {

                if (pos.getDato().getTitulo().equals(valor)) {
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

}
