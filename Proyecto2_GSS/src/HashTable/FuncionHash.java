/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

/**
 *
 * @author Luis Stanislao
 */
public class FuncionHash {

    static final int Max = 100; // Numero de elementos de la tabla
    static final double Factor = 0.318034;// Constante utilizada para hacer la dispersion por multiplicacion

    /*El metodo de la multiplicacion consiste en multiplicar el numero obtenido de la palabra a traves de la codificacion
    que se le da segun la tabala ASCII en las funciones ValorPalabra, por una costante decimal , para luego restarle la parte entera
    y quedar con tan solo el decimal el cual se multiplica por el tamano de la tabla para asegurar que el numero generado este en los 
    que compre del arreglo*/
    
    /*Otorga un valor numerico a la palabra si el metodo 1 falla por dar un numero muy grande*/
    public static long ValorPalabra2(String palabra) {
        palabra = palabra.replace(" ", "");
        int pos = 5;
        long valor = 0;
        for (int i = 0; i < palabra.length(); i++) {
            valor = pos * (int) palabra.charAt(i);
        }
        return valor;
    }
    
    /*Otorga un valor numerico a la palabra multiplicando el codigo ascci del caracter por una costante y el valor acumulado del resto de los valores de la palabra*/
    public static long ValorPalabra1(String palabra) 
    {

        long valor = 0;
        for (int i = 0; i < Math.min(palabra.length(), 11); i++) {
            valor = valor * 17 + (int) palabra.charAt(i);
        }

        if (valor < 0)
        {
            valor = -valor;
        }
        return valor;
    }

    /*
    Funcion que se encarga de calcular la llave de un string. Es decir el indice
    donde sera insertado dicho string en la tabla hash. 
     */
    public static int Dispersion(String palabra) {      
        long valor = ValorPalabra1(palabra);
        double val;
        int llave;
        val = (Factor * valor) - Math.floor(Factor * valor);
        if (val == 0) {
            valor = ValorPalabra2(palabra);
            val = (Factor * valor) - Math.floor(Factor * valor);
        }
        llave = (int) (val * Max);
        return llave;
    }

}
