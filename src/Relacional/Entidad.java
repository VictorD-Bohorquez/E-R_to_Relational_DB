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
public class Entidad {
    private String nombre;
    private String tipo;
    private String padre;
    private String dt; 
    private ArrayList<String> atribllaves;
    private ArrayList<String> atribsimples;
    private ArrayList<String> atribmulti;
    private ArrayList<ArrayList<String>> atribcomp;
    
public Entidad(String nom, String tip)
{
    nombre=nom;
    tipo=tip;
    padre="";
    dt="";
    atribsimples= new ArrayList<String>();
    atribmulti= new ArrayList<String>();
    atribcomp= new ArrayList<ArrayList<String>>();
    atribllaves=new ArrayList<String>();
}

public Entidad(String nom, String tip,String dad,String dit)
{
    nombre=nom;
    tipo=tip;
    padre=dad;
    dt=dit;
    atribsimples= new ArrayList<String>();
    atribmulti= new ArrayList<String>();
    atribcomp= new ArrayList<ArrayList<String>>();
    
}

public String getnombre()
{
    return nombre;
}

public String getpadre()
{
    return padre;
}

public String getdt()
{
    return dt;
}

public void añadirllavesp(ArrayList<String> a)
{
    atribllaves=a;
}

public void añadirsimples(ArrayList<String> a)
{
    atribsimples=a;
    
}

public void añadirmultiv(ArrayList<String> a)
{
    atribmulti=a;
    
}

public void añadircompuestos(ArrayList<ArrayList<String>> a)
{
    atribcomp=a;
    
}

public void añadiratrib(ArrayList<String> a)
{
    atribsimples=a;
}

public boolean atribmultiestavacio()
{
    return atribmulti.isEmpty();
}
public String getllaves()
{
    String llaves="";
    int i;
    for(i=0;i<atribllaves.size();i++)
    {
        llaves=llaves+atribllaves.get(i)+",";
    }
    return llaves;
}

public ArrayList<String> getmulti()
{
    ArrayList<String> a= new ArrayList<String>();
    for (int i=0;i<atribmulti.size();i++)
    {
        a.add(atribmulti.get(i));
    }
    return a;
}

public String getllaves(int n)
{
    String llaves="";
    int i;
    for(i=0;i<atribllaves.size();i++)
    {
        llaves=llaves+"("+atribllaves.get(i)+")"+",";
    }
    return llaves;
}

public String getatributos()
{
    String atributos="";
    int i,q,x;
    for(i=0;i<atribsimples.size();i++)
    {
        atributos=atributos+atribsimples.get(i)+",";
    }
    for(q=0;q<atribcomp.size();q++)
    {
        for(x=1;x<atribcomp.get(q).size();x++)
        {
            atributos=atributos+atribcomp.get(q).get(x)+",";
        }
    }
    return atributos;
}
public String tipoentidad()
{
    return tipo;
}
public void añadiratribsim(String n)
{
    atribsimples.add(n);
}

public void añadiratribmulti(String n)
{
    atribmulti.add(n);
}

public void añadiratribcom(ArrayList a)
{
   atribcomp.add(a);
}
}
