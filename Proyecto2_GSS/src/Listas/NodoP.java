package Listas;

import HashTable.Palabra;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Stanislao
 */
public class NodoP {
    private Palabra dato;
    private NodoP pnext;

    public NodoP(Palabra dato) {
        this.dato = dato;
        pnext= null;
    }

    public Palabra getDato() {return dato;}

    public void setDato(Palabra dato) {this.dato = dato;}

    public NodoP getPnext() {return pnext;}

    public void setPnext(NodoP pnext) {this.pnext = pnext;}
    


    

}
