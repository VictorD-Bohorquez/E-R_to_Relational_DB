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
public class ModRe {
    private String nombre;
    private String atribllave;
    private String atrib;
    
public ModRe(String n,String av, String at)
        {
            nombre=n;
            atribllave=av;
            atrib=at;
        }

public void añadiratribllaveforaneo(String a)
{
    atribllave=atribllave+"("+a+")"+",";
}
public void añadiratribforaneo(String a )
{
    atrib=atrib+"("+a+")"+",";
}

public void añadiratrib(String a )
{
    atrib=atrib+a+",";
}

public String getnombre()
{
    return nombre;
}

public String getllaves()
{
    return atribllave;
}

public String getatrib()
{
    return atrib;
}
}
