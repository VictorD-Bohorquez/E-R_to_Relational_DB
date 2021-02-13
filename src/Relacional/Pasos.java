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
public class Pasos {
    private ArrayList<Entidad> entidades; 
    private ArrayList<Relacion> relaciones;
    private ArrayList<ModRe> modelore; 
    
public Pasos()
{
    entidades= new ArrayList<Entidad>();
    relaciones= new ArrayList<Relacion>();
    modelore= new ArrayList<ModRe>();
}

public void agregararrays(ArrayList<Entidad> e,ArrayList<Relacion> r)
{
    entidades=e;
    relaciones=r;
}

public void paso1()
{
    int i;
    for(i=0; i<entidades.size();i++)
    {
        if(entidades.get(i).getpadre().equals("")){
        if(entidades.get(i).tipoentidad().equals("F")||entidades.get(i).tipoentidad().equals("f"))
        {
            ModRe c;
            String n=entidades.get(i).getnombre();
            String ll=entidades.get(i).getllaves();
            String at=entidades.get(i).getatributos();
            c= new ModRe(n,ll,at);
            modelore.add(c);
        }
        }
    }
}

public void paso2()
{
    int i;
    for(i=0;i<relaciones.size();i++)
    { 
      if(relaciones.get(i).tamrelacion()==2)
      {
          if(relaciones.get(i).getentidad(0).getpadre().equals("") && relaciones.get(i).getentidad(1).getpadre().equals("")){
          if(relaciones.get(i).haydevil())
          {
              if(relaciones.get(i).getentidad(0).tipoentidad().equals("d")||relaciones.get(i).getentidad(0).tipoentidad().equals("D"))
              {
                  ModRe a;
                  String n=relaciones.get(i).getentidad(0).getnombre();
                  String pk=relaciones.get(i).getentidad(0).getllaves();
                  String at=relaciones.get(i).getentidad(0).getatributos();
                  String fora=relaciones.get(i).getentidad(1).getllaves(1);
                  pk=pk+fora;
                  a=new ModRe(n,pk,at);
                  modelore.add(a);
              }
              else
              {
                  ModRe a;
                  String n=relaciones.get(i).getentidad(1).getnombre();
                  String pk=relaciones.get(i).getentidad(1).getllaves();
                  String at=relaciones.get(i).getentidad(1).getatributos();
                  a=new ModRe(n,pk,at);
                  String fora=relaciones.get(i).getentidad(0).getllaves();
                  a.añadiratribllaveforaneo(fora);
                  modelore.add(a);
              }
          }
          }
      }
    }

}

public void paso2(int u)
{
    int i;
    for(i=0; i<entidades.size();i++)
    {
        if(((entidades.get(i)).getpadre()).equals("")){
        if(((entidades.get(i)).tipoentidad()).equals("D")||((entidades.get(i)).tipoentidad()).equals("d"))
        {
            ModRe c;
            String n=entidades.get(i).getnombre();
            String l=entidades.get(i).getllaves();
            String at=entidades.get(i).getatributos();
            String f="";
            c= new ModRe(n,l,at);
            for(int x=0;x<relaciones.size();x++)
            {
                if((relaciones.get(x)).tamrelacion()==2)
                {
                if((((relaciones.get(x)).getentidad(0)).getnombre()).equals(n) || (((relaciones.get(x)).getentidad(1)).getnombre()).equals(n))
                {
                    if(((relaciones.get(x).getentidad(0)).getnombre()).equals(n))
                    {
                        f=relaciones.get(x).getentidad(1).getllaves();
                    }
                    else
                    {
                       if(((relaciones.get(x).getentidad(1)).getnombre()).equals(n))
                    {
                        f=relaciones.get(x).getentidad(0).getllaves();
                    }
                    }
                }
                }
            }
            c.añadiratribllaveforaneo(f);
            modelore.add(c);
        }
        }
    }
}

public void paso3()
{
    int i;
    int q=0;
    int w=0;
    String con;
    String busqueda;
    for(i=0;i<relaciones.size();i++)
    {
        if(relaciones.get(i).tamrelacion()==2)
        {
            if((((relaciones.get(i)).getentidad(0)).getpadre()).equals("") && (((relaciones.get(i)).getentidad(1)).getpadre()).equals("")){
            if(relaciones.get(i).getcard().equals("1:1"))
            {
                if(relaciones.get(i).haydevil()==true)
                {
                    if((((relaciones.get(i)).getentidad(0)).tipoentidad()).equals("d")|| (((relaciones.get(i)).getentidad(0)).tipoentidad()).equals("D"))
                    {
                        busqueda=relaciones.get(i).getentidad(0).getnombre();
                        con=relaciones.get(i).getentidad(1).getnombre();
                    }
                    else{
                        busqueda=relaciones.get(i).getentidad(1).getnombre();
                        con=relaciones.get(i).getentidad(0).getnombre();
                    }
                    for(int x=0;x<modelore.size();x++)
                    {
                        if(((modelore.get(x)).getnombre()).equals(busqueda))
                        {
                            q=x;
                        }     
                    }
                    for(int x=0;x<entidades.size();x++)
                    {
                        if(((entidades.get(x)).getnombre()).equals(con))
                        {
                            w=x;
                        }    
                    }
                    modelore.get(q).añadiratrib(relaciones.get(i).getatribr());
                    modelore.get(q).añadiratribllaveforaneo(entidades.get(w).getllaves(1));
                }
                else
                {
                   if(((relaciones.get(i)).getcard()).equals("PT:PP")||((relaciones.get(i)).getcard()).equals("pt:pp")) 
                   {
                       busqueda=((relaciones.get(i)).getentidad(0)).getnombre();
                       con=((relaciones.get(i)).getentidad(1)).getnombre();
                   }
                   else 
                   {
                       busqueda=((relaciones.get(i)).getentidad(1)).getnombre();
                       con=((relaciones.get(i)).getentidad(0)).getnombre();
                   }
                   
                   for(int x=0;x<modelore.size();x++)
                    {
                        if(((modelore.get(x)).getnombre()).equals(busqueda))
                        {
                            q=x;
                        }
                    }
                   for(int x=0;x<entidades.size();x++)
                    {
                        if(((entidades.get(x)).getnombre()).equals(con))
                        {
                            w=x;
                        }    
                    }
                    modelore.get(q).añadiratrib(relaciones.get(i).getatribr());
                    modelore.get(q).añadiratribforaneo(entidades.get(i).getllaves());
                }
            }
            }
        }
    }
}

public void paso4()
{
     int i;
    for(i=0;i<relaciones.size();i++)
    {
      if(relaciones.get(i).tamrelacion()==2)
      {
          if(relaciones.get(i).getentidad(0).getpadre().equals("")&& relaciones.get(i).getentidad(1).getpadre().equals("")){
          if(((relaciones.get(i)).getentidad(0).tipoentidad()).equals("f") && ((relaciones.get(i)).getentidad(1).tipoentidad()).equals("f"))
          {
              if(relaciones.get(i).getcard().equals("1:N")||relaciones.get(i).getcard().equals("1:n"))
              {
                 String b=relaciones.get(i).getentidad(1).getnombre();
                 int x;
                 int q=0;
                 for(x=0;x<modelore.size();x++)
                 {
                     if(modelore.get(x).getnombre().equals(b))
                     {
                         q=x;
                     }
                 }
                 String atribre=relaciones.get(i).getatribr();
                 String atribforaneo=relaciones.get(i).getentidad(0).getllaves();
                 modelore.get(q).añadiratribforaneo(atribforaneo);
                 modelore.get(q).añadiratrib(atribre);
              }
              else
              {
               if(relaciones.get(i).getcard().equals("N:1")||relaciones.get(i).getcard().equals("n:1")){ 
               String b=relaciones.get(i).getentidad(0).getnombre();
                 int x;
                 int q=0;
                 for(x=0;x<modelore.size();x++)
                 {
                     if(modelore.get(x).getnombre().equals(b))
                     {
                         q=x;
                     }
                 }
                 String atribre=relaciones.get(i).getatribr();
                 String atribforaneo=relaciones.get(i).getentidad(1).getllaves();
                 modelore.get(q).añadiratribforaneo(atribforaneo);
                 modelore.get(q).añadiratrib(atribre);  
               }
              }
          }
          }
          if(!relaciones.get(i).getentidad(0).getpadre().equals(""))
          {
              if(relaciones.get(i).getcard().equals("1:N")||relaciones.get(i).getcard().equals("1:n")){
              String b= relaciones.get(i).getentidad(1).getnombre();
              String pap=relaciones.get(i).getentidad(0).getpadre();
              int w;
              int q=0;
              int z=0;
              for(w=0;w<entidades.size();w++)
              {
                  if(entidades.get(w).getnombre().equals(pap))
                  {
                      q=w;
                  }
              }
              String atribre=relaciones.get(i).getatribr();
              String atribforeneo=entidades.get(q).getllaves();
              for(w=0;w<modelore.size();w++)
              {
                  if(modelore.get(w).getnombre().equals(b))
                  {
                      z=w;
                  }
              }
              modelore.get(z).añadiratrib(atribre);
              modelore.get(z).añadiratribforaneo(atribforeneo);
              }
          }
          if(!relaciones.get(i).getentidad(1).getpadre().equals(""))
          {
              if(relaciones.get(i).getcard().equals("N:1")||relaciones.get(i).getcard().equals("n:1")){
              String b= relaciones.get(i).getentidad(0).getnombre();
              String pap=relaciones.get(i).getentidad(1).getpadre();
              int w;
              int q=0;
              int z=0;
              for(w=0;w<entidades.size();w++)
              {
                  if(entidades.get(w).getnombre().equals(pap))
                  {
                      q=w;
                  }
              }
              String atribre=relaciones.get(i).getatribr();
              String atribforeneo=entidades.get(q).getllaves();
              for(w=0;w<modelore.size();w++)
              {
                  if(modelore.get(w).getnombre().equals(b))
                  {
                      z=w;
                  }
              }
              modelore.get(z).añadiratrib(atribre);
              modelore.get(z).añadiratribforaneo(atribforeneo);
              }
          }
      }
}
}

public void paso5()
{
    int i;
    String n="";
    String llave="";
    String llave2;
    String llavef="";
    String atribr;
    for(i=0;i<relaciones.size();i++)
    {
        if(relaciones.get(i).tamrelacion()==2)
        {
        if(relaciones.get(i).getcard().equals("N:M")||relaciones.get(i).getcard().equals("n:m")||relaciones.get(i).getcard().equals("M:N") ||relaciones.get(i).getcard().equals("m:n"))
        {
            if(!relaciones.get(i).getentidad(0).getpadre().equals("") && relaciones.get(i).getentidad(1).getpadre().equals(""))
            {
                 n= relaciones.get(i).getnombre();
                 String padre=relaciones.get(i).getentidad(0).getpadre();
                 for(int x=0;x<entidades.size();x++)
                 {
                     if(entidades.get(x).getnombre().equals(padre))
                     {
                         llave=entidades.get(x).getllaves(1);
                     }
                 }
                 llave2=relaciones.get(i).getentidad(1).getllaves(1);
                 llavef=llave+llave2;
            }
            if(!relaciones.get(i).getentidad(1).getpadre().equals("") && relaciones.get(i).getentidad(0).getpadre().equals(""))
            {
              n= relaciones.get(i).getnombre();
                 String padre=relaciones.get(i).getentidad(1).getpadre();
                 for(int x=0;x<entidades.size();x++)
                 {
                     if(entidades.get(x).getnombre().equals(padre))
                     {
                         llave=entidades.get(x).getllaves(1);
                     }
                 }
                 llave2=relaciones.get(i).getentidad(1).getllaves(1);
                 llavef=llave+llave2;
            }
            if(!relaciones.get(i).getentidad(0).getpadre().equals("")&& !relaciones.get(i).getentidad(1).getpadre().equals(""))
            {
                n= relaciones.get(i).getnombre();
                 String padre=relaciones.get(i).getentidad(0).getpadre();
                 for(int x=0;x<entidades.size();x++)
                 {
                     if(entidades.get(x).getnombre().equals(padre))
                     {
                         llave=entidades.get(x).getllaves(1);
                     }
                 }
                 String padre2=relaciones.get(i).getentidad(1).getpadre();
                 for(int x=0;x<entidades.size();x++)
                 {
                     if(entidades.get(x).getnombre().equals(padre2))
                     {
                         llave2=entidades.get(x).getllaves(1);
                     }
                 }
                 llave2=relaciones.get(i).getentidad(1).getllaves(1);
                 llavef=llave+llave2;
            }
            if(relaciones.get(i).getentidad(0).getpadre().equals("") && relaciones.get(i).getentidad(1).getpadre().equals(""))
            {
             n= relaciones.get(i).getnombre();
             llave=relaciones.get(i).getentidad(0).getllaves(1);
             llave2=relaciones.get(i).getentidad(1).getllaves(1);
             llavef=llave+llave2;
            }
            atribr=relaciones.get(i).getatribr();
            ModRe c= new ModRe(n,llavef,atribr);
            modelore.add(c);
        }
        }
    } 
}

public void paso6()
{
  int i,x;
  for(i=0;i<entidades.size();i++)
  {
      if(!(entidades.get(i)).atribmultiestavacio())
      {
           ArrayList<String> a= entidades.get(i).getmulti();
           for(x=0;x<a.size();x++)
           {
               String nom=a.get(x)+"_"+entidades.get(i).getnombre();
               String llave=a.get(x)+","+entidades.get(i).getllaves(1);
               ModRe c= new ModRe (nom,llave,"");
               modelore.add(c);
           }
      }
  }
}

public void paso7()
{
    int i;
    for (i=0;i<relaciones.size();i++)
    {
        if(relaciones.get(i).tamrelacion()>2)
        {
            String n=relaciones.get(i).getnombre();
            String at=relaciones.get(i).getatribr();
            String llav="";
            for(int x=0;x<relaciones.get(i).tamrelacion();x++)
            {
                llav=llav+relaciones.get(i).getentidad(x).getllaves(1);
            }
            ModRe c= new ModRe(n,llav,at);
            modelore.add(c);
        }
    }
}

public void paso8a()
{
    String busqueda;
    String llaves;
    String atribt;
    String nomb;
    int i;
    int q=0;
    for(i=0;i<entidades.size();i++)
    {
        if(!((entidades.get(i)).getpadre()).equals(""))
        {
            busqueda=entidades.get(i).getpadre();
            for(int x=0;x<entidades.size();x++)
            {
                if(((entidades.get(x)).getnombre()).equals(busqueda))
                {
                    q=x;
                }
            }
            llaves=entidades.get(q).getllaves(1);
            atribt=entidades.get(i).getatributos();
            nomb=entidades.get(i).getnombre();
            ModRe c= new ModRe(nomb,llaves,atribt);
            modelore.add(c);
        }
    }
}

public void paso8b()
{
    String busqueda;
    ArrayList<String> disy= new ArrayList<String>();
    String atribt;
    String atribt2;
    String tipo="tipo_disyuncion";
    String nomb;
    int i;
    String q;
    for(i=0;i<entidades.size();i++)
    {
        if(!entidades.get(i).getpadre().equals(""))
        {
           if(entidades.get(i).getdt().equals("D")||entidades.get(i).getdt().equals("d"))
           {
               busqueda=entidades.get(i).getpadre();
               atribt=entidades.get(i).getatributos();
           for(int x=0;x<modelore.size();x++)
           {
               if(modelore.get(x).getnombre().equals(busqueda))
               {
                   q=Integer.toString(x);
                   modelore.get(x).añadiratrib(atribt);
                   if(!disy.contains(q))
                   {
                       disy.add(q);
                   }
               }
           }
           }
           else
           {
               busqueda=entidades.get(i).getpadre();
               atribt=entidades.get(i).getatributos();
               nomb=entidades.get(i).getnombre();
             for(int x=0;x<modelore.size();x++)
             {
                if(modelore.get(x).getnombre().equals(busqueda))
                {
                   atribt2=nomb+atribt;
                   modelore.get(x).añadiratrib(atribt2);
                }
              }
           }

        }
    }
    
   if(!disy.isEmpty())
   {
       for(i=0;i<modelore.size();i++)
       {
           if(disy.contains(Integer.toString(i)))
           {
               modelore.get(i).añadiratrib(tipo);
           }
       }
   }
}

public String imprimefinal()
{
    String fin="";
    for(int i=0;i<modelore.size();i++)
    {
        fin=fin+modelore.get(i).getnombre()+"= {"+"<"+modelore.get(i).getllaves()+">"+modelore.get(i).getatrib()+"}"+"\n";
    }
  
    return fin;
}

public void limpiar()
{
    entidades.clear();
    relaciones.clear();
    modelore.clear();
}
}
