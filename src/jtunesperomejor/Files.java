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
public class Files {
    private File miFile;
    
    public Files(){
        miFile = new File("music");
        
        if(!miFile.exists()){
            miFile.mkdir();
        }
    }
    
    public File[] returnAllSongs(){
        if (miFile.isDirectory()){
            return miFile.listFiles();
        }
        return null;
    }
}
