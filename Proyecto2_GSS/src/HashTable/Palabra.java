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

    private String word;// String palabra
    private Lista resumenes;//Resumenes que tiene asociada la palabra

    public Palabra(String word, int repeticion) {
        this.word = word;
        this.resumenes = new Lista();
    }

    public Palabra(String word) {
        this.word = word;
        this.resumenes = new Lista();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Lista getResumenes() {
        return resumenes;
    }

    public void setResumenes(Lista resumenes) {
        this.resumenes = resumenes;
    }

}
