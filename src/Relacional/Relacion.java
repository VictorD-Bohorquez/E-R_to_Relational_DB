/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relacional;

import java.util.ArrayList;

/**
 *
 * @author DANIEL
 */
public class Relacion {
    private String nombre;
    private ArrayList<String> atrib;
    private ArrayList<Entidad>e1;
    private String part;
    private String card;
    
public Relacion(String n, String p, String c)
{
    nombre=n;
    e1= new ArrayList<Entidad>();
    atrib=new ArrayList<String>();
    part=p;
    card=c;
}

public void añadiratrib(ArrayList<String> a)
{
    atrib=a;
}

public void añadirent(ArrayList<Entidad> e)
{
    e1=e;
}

public Entidad getentidad(int i)
{
    return e1.get(i);
}

public int tamrelacion()
{
    return e1.size();
}

public boolean haydevil()
{
    int i;
    for(i=0;i<e1.size();i++)
    {
        if((e1.get(i)).tipoentidad()=="D"||(e1.get(i)).tipoentidad()=="d")
        {
            return true;
        }
    }
    return false;
}

public String getcard()
{
    return card;
}

public String getatribr()
{
    String atributos="";
    int i,x;
    if(!atrib.isEmpty()){
    for(i=0;i<atrib.size();i++)
    {
        atributos=atributos+atrib.get(i)+",";
    }
    }
    return atributos;
}

public String getnombre()
{
    return nombre;
}

}
