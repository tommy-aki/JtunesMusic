/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jtunesperomejor;


import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Tommy Lee Pon
 */
public class ListaMusica {
    NodoCancion inicio;
    Files guardadas;
    Clip clip;
    boolean paused;
    
    
    public ListaMusica(){
        inicio=null;
        guardadas = new Files();
        clip=null;
    }
    
    public int getSize(){
        int i=0;
        NodoCancion actual = inicio;
        while(actual!=null){
            i++;
            actual=actual.siguiente;
        }
        return i;
    }
    
    public NodoCancion getElementAt(int i){
        int cont=0;
        NodoCancion actual = inicio;
        while (actual!=null && cont<=i){
            cont++;
            actual=actual.siguiente;
        }
        if (cont==i){
            return actual;
        }
        return null;
    }
    
    public boolean isEmpty(){
        return inicio==null;
    }
    
    //Agregar muscia a la lista:
    public void agregarMusica(File music){
        NodoCancion nodo = new NodoCancion(music);
        if(isEmpty()){
            inicio = nodo;
        } else {
            NodoCancion actual = inicio;
            while(actual.siguiente!=null){
                actual=actual.siguiente;
            }
            actual.siguiente = nodo;
        }
    }
    
    // Reproducir música utilizando javax.sound.sampled
    public void reproducirMusica(File archivo){
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(archivo));
            clip.start();
            
        } catch (Exception e) {
            System.out.println("Error al reproducir la música: " + e.getMessage());
        }
    }

    public void reproducirLista(){
        NodoCancion actual = inicio;
        while(actual != null){
            reproducirMusica(actual.archivo);
            actual = actual.siguiente;
            inicio=actual;
            
        }
    }
    
    public void pausarMusica() {
        if (clip != null && clip.isRunning()) {
            paused=true;
        }
    }

    public void vaciarYParar(){
        if (clip != null && clip.isRunning()) {
            clip.close(); // Parar la reproducción sin detener completamente el Clip
        }
        inicio=null;
    }

}
