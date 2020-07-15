/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

import Listas.Lista;
import Listas.Nodo;

/**
 *
 * @author orian
 */
public class Resumen {

    private String titulo;
    private String autores;
    private String cuerpo;
    private String[] palabrasClaves;

    public Resumen(String titulo, String autores, String cuerpo, String[] palabrasClaves) {
        this.titulo = titulo;
        this.autores = autores;
        this.cuerpo = cuerpo;
        this.palabrasClaves = palabrasClaves;
    }

    /*
    Funcion que se encarga de analizar un resumen, calculando las veces que se 
    repiten las palabras claves del repositorio y las palabras claves del resumen
    en dicho resumen.
     */
    public String Estadisticas() {
        // Tomo el tiempo de inicio
        long inicio = System.nanoTime();

        String estadistica = "";
        estadistica += titulo + ".\nAutores: " + autores + "\n\nNúmero de palabras del repositorio:\n\n";

        Lista aux = Central.getPalabrasClaves();
        Nodo actual = aux.getpFirst();
        while (actual != null) {
            boolean palabraDelResumen = false;
            String palabraActual = actual.getDato().toString();

            // Verifico que la palabra clave no sea una palabra clave del resumen
            for (String palabraClave : palabrasClaves) {
                if (palabraActual.equals(palabraClave)) {
                    palabraDelResumen = true;
                    break;
                }
            }

            /* Cuento las veces que se repite la palabra clave del repositorio 
            en el cuerpo del resumen*/
            if (!palabraDelResumen) {
                estadistica += contarRepeticion(palabraActual);
            }

            actual = actual.getPnext();
        }

        /* Cuento las veces que se repite la palabra clave del resumen en el 
        cuerpo del resumen*/
        estadistica += "\nNúmero de palabras del resumen:\n\n";

        for (String palabraClave : palabrasClaves) {
            estadistica += contarRepeticion(palabraClave);
        }

        // Tomo el tiempo final
        long fin = System.nanoTime();

        // Calculo el tiempo de ejecucion en milisegundos
        long tiempo = (fin - inicio) / 1000000;

        estadistica += "\nTiempo empleado: " + (fin - inicio) + " nanosegundos/ " + tiempo + " milisegundos.";

        return estadistica;
    }

    /*
    Funcion que se encarga de contar las repeticiones de una palabra clave en el 
    cuerpo del resumen.
     */
    public String contarRepeticion(String palabraClave) {
        int cont = 0;
        int indice = 0;

        indice = cuerpo.indexOf(palabraClave.toLowerCase(), indice);
        while (indice != -1) {
            /* 
            Verifico que haya encontrado realmente la palabra clave evaluando que
            el caracter que esta antes y despues de la palabra encontrada no sea
            una letra. 
                    
            Ej: Si la palabra clave es "archivo", si se encuentra "archivos"
            al evaluar si el caracter en el indice anterior (indice donde
            inicia la palabra encontrada menos 1) y posterior( indice donde
            inicia la palabra encontrada mas la longitud de la palabra clave)  
            a la palabra encontrada es una letra o no, podemos saber si 
            realmente encontramos la palabra buscada.
             */
            boolean anteriorNoEsLetra = (int) cuerpo.charAt(indice - 1) < 97
                    || (int) cuerpo.charAt(indice - 1) > 122;
            boolean posteriorNoEsLetra = (int) cuerpo.charAt(indice + palabraClave.length()) < 97
                    || (int) cuerpo.charAt(indice + palabraClave.length()) > 122;
            if (anteriorNoEsLetra && posteriorNoEsLetra) {
                cont++;
            }

            indice++;
            indice = cuerpo.indexOf(palabraClave.toLowerCase(), indice);
        }

        String repeticiones = palabraClave + ": " + cont + "\n";

        return repeticiones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String[] getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String[] palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

}
