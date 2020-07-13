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
public class Temporal {
    public static boolean ContienePalabra(String palabra, String text)
    {
        text=text.toLowerCase();
        palabra=palabra.toLowerCase();
        return text.contains(palabra);
        
    }    
}
