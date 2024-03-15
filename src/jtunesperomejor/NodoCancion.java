/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jtunesperomejor;

import java.io.*;

/**
 *
 * @author Tommy Lee Pon
 */
public class NodoCancion {
    File archivo;
    NodoCancion siguiente;
    
    public NodoCancion(File dir){
        archivo=dir;
        siguiente=null;
    }
}
