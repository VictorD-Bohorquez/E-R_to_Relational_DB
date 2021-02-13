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
public class separadortexo {

public separadortexo()
{
    
}

public ArrayList<String> separarllavespyatrib(String llavesp)
{
String[] parts = llavesp.split(",");
ArrayList<String> llaves= new ArrayList<String>();
for(int i=0;i<parts.length;i++)
{
    llaves.add(parts[i]);
}
return llaves;
}

public ArrayList<String> separaratribcompuestos(String comp)
{
String[] parts = comp.split("-");
ArrayList<String> llaves= new ArrayList<String>();
for(int i=0;i<parts.length;i++)
{
    llaves.add(parts[i]);
}
return llaves;
}


}
