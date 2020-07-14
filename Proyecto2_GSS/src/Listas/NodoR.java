package Listas;

import HashTable.Resumen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luis Stanislao
 */
public class NodoR {

    private Resumen dato;
    private NodoR pnext;

    public NodoR(Resumen dato) {
        this.dato = dato;
        pnext = null;
    }

    public Resumen getDato() {
        return dato;
    }

    public void setDato(Resumen dato) {
        this.dato = dato;
    }

    public NodoR getPnext() {
        return pnext;
    }

    public void setPnext(NodoR pnext) {
        this.pnext = pnext;
    }

}
