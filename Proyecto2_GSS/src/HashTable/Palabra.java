/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

import Listas.Lista;

/**
 *
 * @author Luis Stanislao
 */
public class Palabra {

    private String word;
    private int repeticion;
    private Lista resumenes;

    // REPETICION SE VA?
    public Palabra(String word, int repeticion) {
        this.word = word;
        this.repeticion = repeticion;
        this.resumenes = new Lista();
    }

    public Palabra(String word) {
        this.word = word;
        this.repeticion = 0;
        this.resumenes = new Lista();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(int repeticion) {
        this.repeticion = repeticion;
    }

    public Lista getResumenes() {
        return resumenes;
    }

    public void setResumenes(Lista resumenes) {
        this.resumenes = resumenes;
    }

}
