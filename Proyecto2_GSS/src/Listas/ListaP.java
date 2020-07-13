/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

import HashTable.Palabra;

/**
 *
 * @author Luis Stanislao
 */
public class ListaP {
    private NodoP pFirst;
    private NodoP pLast;
    private int Size;

//Constructor-----------------------------------------------------
    public ListaP() {
        pFirst =null;
        pLast =null;
        Size=0;
    }
//getters and setters----------------------------------------------

    public NodoP getpFirst() {return pFirst;}
    
    public void setpFirst(NodoP pFirst) {this.pFirst = pFirst;}

    public NodoP getpLast() {return pLast;}

    public void setpLast(NodoP pLast) {this.pLast = pLast;}

    public int getSize() {return Size;}

    public void setSize(int Size) {this.Size = Size;}

//-----------------------------------------------------------------
    public boolean EsVacio()
    {
        return pFirst==null;  
    }
    
    public NodoP First()
    {
        return getpFirst();
    }
    
    public NodoP Last()
    {
        if(!EsVacio())
        {
            NodoP aux = First();
            for (int i = 0; i < getSize(); i++)
            {
                if (i==getSize()-1)
                {
                    setpLast(aux);
                }
                aux=Proximo(aux);
            }
            return getpLast();
        }
        else
        {
            return null;
        }
    }
    
    public NodoP Proximo(NodoP posicion){
        if(posicion.getPnext()!=null)
            {
              posicion=posicion.getPnext();
              return posicion;  
            }  
        else
            {
            return null;
            }
    }
    
    public NodoP Anterior(NodoP posicion)
    {
        NodoP aux = First();
        NodoP ant = First();
        
        boolean encontrado = false;
        if(aux==posicion)//aux.getDato().getWord().equals(posicion.getDato().getWord())
        {
            return null;
        }
        else
        {
            while(aux!=null && encontrado==false)//aux.getDato().getWord().equals(posicion.getDato().getWord())
            {
                aux=Proximo(aux);
                if(aux==posicion)
                {
                    encontrado=true;
                    return ant;
                }
                else
                {
                    ant=Proximo(ant);
                }
                
            }  
        }
        return null;
    }
    
    public void Eliminar(NodoP posicion)
    {
        if(posicion==First())
        {
            if (getSize()==1)
            {
                setpFirst(null);
            }
            else
            {
            NodoP sig= Proximo(posicion);
            setpFirst(sig);
            }
        }
        else if (posicion ==Last())
        {
            NodoP ant= Anterior(posicion);
            ant.setPnext(null);
            setpLast(ant);
        }
        else
        {
            NodoP ant= Anterior(posicion);
            NodoP sig= Proximo(posicion);
            ant.setPnext(sig); 
        }
    setSize(getSize()-1);
        
        
    }
    

    public void InsertarInicio(Palabra dato)
    {
        NodoP nuevo = new NodoP(dato);
        if(EsVacio())
        {

            setpFirst(nuevo); 
            setpLast(nuevo);
        }
        else
        {
            NodoP aux = First();
            nuevo.setPnext(aux);
            setpFirst(nuevo);
        }
        setSize(getSize()+1);
    }
        
    public NodoP Buscar(Palabra valor)
    {   
        if(!EsVacio())
        {
            boolean encontrado=false;
            NodoP pos=First();
            //while(pos!=null && encontrado==false)
            for (int i = 0; i < getSize(); i++)
            {
                if(pos.getDato().getWord().equals(valor.getWord()))
                {
                    encontrado=true;
                    break;
                }
                else
                {     
                    pos = Proximo(pos);      
                }
            }
            return pos;  
        }
        else
        {
            return null;
        }
    }
    
    public Palabra Buscar(String valor)
    {
        if(!EsVacio())
        {
            boolean encontrado=false;
            NodoP pos=First();
            //while(pos!=null && encontrado==false)
            for (int i = 0; i < getSize(); i++)
            {
                if(pos.getDato().getWord().equals(valor))
                {
                    encontrado=true;
                    break;
                }
                else
                {     
                    pos = Proximo(pos);      
                }
            }
            return pos.getDato();  
        }
        else
        {
            return null;
        }
    }
    
  
    
    
    
}
