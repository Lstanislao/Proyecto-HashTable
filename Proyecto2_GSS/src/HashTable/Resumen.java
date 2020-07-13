/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

import static HashTable.Central.PalabrasClaves;
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

    public String Estadisticas() {
        long inicio = System.nanoTime();

        String estadistica = "";
        estadistica += titulo + "\nAutores: " + autores + "\n\nNumero de palabras del repositorio:\n";

        Nodo actual = PalabrasClaves.getpFirst();
        while (actual != null) {
            boolean palabraDelResumen = false;
            String palabraActual = actual.getDato().toString();

            for (String palabraClave : palabrasClaves) {
                if (palabraActual.equals(palabraClave)) {
                    palabraDelResumen = true;
                    break;
                }
            }

            if (!palabraDelResumen) {
                int cont = 0;
                int indice = 0;

                indice = cuerpo.indexOf(palabraActual.toLowerCase(), indice);
                while (indice != -1) {
                    if ((int) cuerpo.charAt(indice - 1) < 97 || (int) cuerpo.charAt(indice + palabraActual.length()) > 122) {
                        cont++;
                    }

                    indice++;
                    indice = cuerpo.indexOf(palabraActual.toLowerCase(), indice);
                }

//                for (String palabra : cuerpo) {
//                    
//                    if (palabra.toLowerCase().equals(palabraActual.toLowerCase())) {
//                        cont++;
//                    }
//                }
                estadistica += palabraActual + ": " + cont + "\n";
            }

            actual = actual.getPnext();
        }

        estadistica += "\nNumero de palabras del resumen:\n";
        for (String palabraClave : palabrasClaves) {
            int cont = 0;
            int indice = 0;

            indice = cuerpo.indexOf(palabraClave.toLowerCase(), indice);
            while (indice != -1) {
                if ((int) cuerpo.charAt(indice - 1) < 97 || (int) cuerpo.charAt(indice + palabraClave.length()) > 122) {
                    cont++;
                }
                indice++;
                indice = cuerpo.indexOf(palabraClave.toLowerCase(), indice);
            }

//            for (String palabra : cuerpo) {
//                if (palabra.toLowerCase().equals(palabraClave.toLowerCase())) {
//                    cont++;
//                }
//            }
            estadistica += palabraClave + ": " + cont + "\n";
        }
        long fin = System.nanoTime();

        // tiempo en milisegundos
        long tiempo = (fin - inicio) / 1000000;

        estadistica += "\nTiempo empleado: " + tiempo + " milisegundos.";

        return estadistica;
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
