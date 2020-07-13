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
    static final int Max = 10; //numero espacion de la tabla
    static final double Factor = 0.318034;//Constante utilizada para hacer la dispension por multiplicacion
//cambiar para que no sea el boleta del libro JAJAJA
    
    /*public static long ValorPalabra(String palabra)
    {
        palabra.replace(" ", "");
        System.out.println(palabra);
        long valor=0;
        for (int i = 0; i < Math.min(palabra.length(),10) ; i++) 
        {
            valor = valor * 27 + (int)palabra.charAt(i); 
        }
        
        if (valor < 0)
        {
            valor=-valor;
        }  
          System.out.println(valor+ " 0");
        return valor;
    }*/
    
       public static long ValorPalabra2(String palabra)
    {
        palabra.replace(" ", "");
        System.out.println(palabra);
        int pos=5;
        long valor=0;
        for (int i = 0; i < palabra.length() ; i++) 
        {
            valor =pos*(int)palabra.charAt(i); 
        }
        return valor;
    }
    
    public static long ValorPalabra1(String palabra)//ESTA ES UN PRUEBA HAY QUE BORRARLA DESPUES 
    {
        
        long valor=0;
        for (int i = 0; i <palabra.length() ; i++) 
        {
            valor = valor * 27 + (int)palabra.charAt(i); 
        }
        
        if (valor < 0)//si el valor en un caso llegase a sobrepasar el limite se convierte en negativo por lo tanto se verifica que nomvaya a devolver un negativo 
        {
            valor=-valor;
        }
        return valor;
    }
    
    public static int Dispersion(String palabra)
    {
        System.out.println("");
        System.out.println(palabra);
        long valor=ValorPalabra1(palabra);
        System.out.println(valor+" sos");
        double val;
        int llave;
        val= (Factor*valor)-Math.floor(Factor*valor);
        System.out.println(val+" primer intento");
        if(val == 0)
        {
            valor=ValorPalabra2(palabra);
            val= (Factor*valor)-Math.floor(Factor*valor);
            System.out.println("Segundo intento "+valor);
        }
        llave= (int)(val*Max);
        System.out.println(llave+" esta es la llave");
        return llave;
       
    }
    

    
    
    
}
