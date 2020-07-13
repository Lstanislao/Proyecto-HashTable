/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

/**
 *
 * @author Luis Stanislao
 */
import HashTable.*;

import static HashTable.FuncionHash.*;
import Listas.NodoP;
import HashTable.Palabra;
import Listas.Lista;
import java.io.File;

public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println("EL SEGUNDO 20 MUCHACHOS");
//        HashTablePalabra table = new HashTablePalabra();
//        Palabra hola = new Palabra("hola");
//        Palabra ori = new Palabra("ori");
//        Palabra Guillermo = new Palabra("Guillermo");
//        Palabra Luis = new Palabra("Luis");
//        Palabra Stanislao = new Palabra("Stanislao");
//        Palabra Gonzalez = new Palabra("Gonzalez");
//        Palabra Sosa = new Palabra("Sosa");
//        Palabra Zara = new Palabra("Sosa");
//
//        table.InsertarPalabra(hola);
//        //table.InsertarPalabra(hola);
//        //table.InsertarPalabra(Zara);
//        table.InsertarPalabra(ori);
//        table.InsertarPalabra(Guillermo);
//        table.InsertarPalabra(Luis);
//        table.InsertarPalabra(Stanislao);
//        table.InsertarPalabra(Gonzalez);
//        table.InsertarPalabra(Sosa);
//        Palabra word = table.tabla[1].getpFirst().getDato();
//        System.out.println(Luis);
//        Palabra prueba = table.BuscarPalabra("Luis");
//        System.out.println(prueba);
//
//        System.out.println(word.getWord() + " ALOOO");
//        //System.out.println("");
//        //System.out.println(table.BuscarPalabra(Sosa).getWord()+" sos");
//        //System.out.println(table.tabla[9].Buscar(Sosa));
//
//        String tit = "Complemento de software para el diseño de fundaciones.";
//        String autores = "Raquel Sandoval, Iván Loscher, Christian Guillén-Drija,";
//        String cuerpo = "El adelanto tecnológico presente hoy en día ha traído "
//                + "una gran cantidad de herramientas útiles para los ingenieros,"
//                + " incorporando el uso de sistemas de información para la toma "
//                + "de decisiones en los procesos de cálculo y la visualización de"
//                + " materiales creados a través de los cálculos; así como avanza"
//                + " las tecnologías a usar, también deben actualizarse las herramientas"
//                + " para asegurar su durabilidad y fiabilidad en el tiempo. El siguiente"
//                + " trabajo presenta una herramienta que, con ayuda de métodos de "
//                + "cálculo existentes para fundaciones directas e indirectas, genera "
//                + "el diseño de las mismas en conjunto a través de valores ingresados "
//                + "por el usuario, estableciendo así un medio en el que pueda visualizarse "
//                + "de manera eficiente y sencilla los resultados del cálculo previamente establecido, "
//                + "pues automatiza el proceso de dibujo y cálculo en AutoCAD. Dicha herramienta se "
//                + "implementó como un complemento o extensión de software que permite el diseño y "
//                + "dibujo de las fundaciones con base en las librerías, funciones y modelos de "
//                + "AutoCAD. La extensión obtenida puede ser modificada en el tiempo para "
//                + "extender sus funcionalidades. La misma implementa diversos métodos para diseño de fundaciones, "
//                + "entre los que se cuenta Caquot-Kerisel y Meyerhof, aplicado en las fundaciones indirectas. En el caso "
//                + "de las fundaciones directas, implementa el método de Terzaghi y Vesic. Igualmente, se realizó un "
//                + "modelo de cálculo para el diseño de todas las fundaciones de la estructura, el cual fue implementado en "
//                + "el complemento obtenido en este trabajo de investigación.";
//
//        String palabrasClaves = "Palabras claves: fundaciones directas, fundaciones indirectas, AutoCAD, complemento, C#";
//
//        cuerpo = cuerpo.replace(",", "");
//        cuerpo = cuerpo.replace(".", "");
//        autores = autores.substring(0, autores.length() - 1) + ".";
//        String[] palabras = palabrasClaves.split(": ");
//        String[] arregloPalabrasClaves = palabras[1].split(", ");
//
//        Resumen nuevoResumen = new Resumen(tit, autores, cuerpo.toLowerCase(), arregloPalabrasClaves);
//        Lista sos = Central.getPalabrasClaves();
//        for (String p : arregloPalabrasClaves) {
//            sos.InsertarInicio(p);
//        }
//
//        sos.InsertarInicio("hola");
//        sos.InsertarInicio("ayuda");
//        sos.InsertarInicio("no");
//        sos.InsertarInicio("quiero");
//        sos.InsertarInicio("estudiar");
//        sos.InsertarInicio("base");
//        sos.InsertarInicio("estructura");
//
//        System.out.println(nuevoResumen.Estadisticas());
//
//        String tit1 = "Arquitectura referencial para mecanismos de "
//                + "Internacionalización y localización en PHP.";
//        String autores1 = "Christian Guillén Drija, "
//                + "Andrea Pérez, "
//                + "Carlos Maldonado,";
//        String cuerpo1 = "Los procesos de internacionalización y localización inciden directamente en la usabilidad de un sistema web al "
//                + "facilitar su adaptación a diferentes elementos culturales tales como la moneda, idioma, formato de fecha, sistema "
//                + "de medidas, entre otros. Algunos frameworks para aplicaciones web cuentan con soporte para dichos procesos. "
//                + "Sin embargo, en muchas ocasiones, la información sobre la arquitectura de los mecanismos utilizados en cada "
//                + "framework, así como su funcionamiento interno resulta insuficiente. La arquitectura de software se corresponde "
//                + "a visión abstracta de un sistema en la que se representan los componentes del mismo, el comportamiento de cada "
//                + "uno de dichos elementos y la forma en que se relacionan. Su uso adecuado conlleva a la disminución de los "
//                + "costos de manutención del software, mayor facilidad en la toma de decisiones de diseño, disminución de las "
//                + "fallas, entre otras ventajas. Por otra parte, la generación de una Arquitectura de Referencia (AR), es el producto "
//                + "con mayor relevancia generado en la etapa de Análisis del Dominio (AD), dentro de la denominada disciplina de "
//                + "Ingeniería del Dominio (ID), la cual tiene gran relevancia para el desarrollo de software basado en componentes. "
//                + "En este trabajo, se aplica un AD, asumiendo un enfoque ascendente (“bottom-up”) sobre una muestra de "
//                + "frameworks de desarrollo para PHP, específicamente centrado en los mecanismos que cada framework "
//                + "implementa para posibilitar la internacionalización y la localización en aplicaciones web. Para lograr lo anterior, "
//                + "se aplicó ingeniería inversa sobre las distintas arquitecturas y se modelaron en UML. Del análisis de las variantes "
//                + "e invariantes de las mismas, se obtuvo una Arquitectura de Referencia para un subsistema de "
//                + "internacionalización y localización. Si bien la muestra de arquitecturas analizadas en este trabajo se "
//                + "circunscriben a frameworks de desarrollo en PHP, la Arquitectura de Referencia obtenida puede ser considerada "
//                + "de carácter genérico, con el suficiente nivel de abstracción de manera que pueda ser asumida como una "
//                + "arquitectura base sobre la cual comenzar un desarrollo basado en componentes; sin embargo, su validación "
//                + "puede realizarse a través de la ampliación de la muestra inicial de frameworks seleccionados y el análisis de las "
//                + "posibles variantes que puedan generarse. No obstante, la Arquitectura de Referencia obtenida en este ejercicio de "
//                + "Análisis de Dominio puede utilizarse como referente dentro de una organización para evaluar la mejor opción al "
//                + "momento de seleccionar la alternativa arquitectónica más robusta al considerar un conjunto de frameworks de "
//                + "desarrollo.";
//
//        String palabrasClaves1 = "Palabras claves: análisis de dominio, ingeniería de dominio, PHP, arquitectura referencial, "
//                + "internacionalización y localización.";
//
//        cuerpo1 = cuerpo1.replace(",", "");
//        cuerpo1 = cuerpo1.replace(".", "");
//        autores1 = autores1.substring(0, autores1.length() - 1) + ".";
//        palabrasClaves1 = palabrasClaves1.replace(".", "");
//        String[] palabras1 = palabrasClaves1.split(": ");
//        String[] arregloPalabrasClaves1 = palabras1[1].split(", ");
//
//        Resumen nuevoResumen1 = new Resumen(tit1, autores1, cuerpo1.toLowerCase(), arregloPalabrasClaves1);
//
////        for (String a : arregloPalabrasClaves1) { Esto se agrga ahora cuando se carga el archivo
////            PalabrasClaves.InsertarInicio(a);
////        }
//
//        System.out.println(nuevoResumen1.Estadisticas());
        File archivo = new File("Sistema de diseño basado en Grid.txt");
        System.out.println(Archivo.VerificarFormatoArchivo(archivo)+" hola");
        Archivo.LeerArchivo(archivo);
        HashTableResumen table = Central.getResumenes();
        

    }

}
