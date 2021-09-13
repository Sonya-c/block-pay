/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.structure;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author 57301
 */
public class Files {
    
    public Files(){
        
    }
    
     public void buscar_crearArchivo(File file, String fileName) {
        String sDir = "C:\\Block-Pay-registros";
        File f = new File(sDir);
        String ruta = "C:\\rochi-coins"; //Carpeta ruta
        file = new File(ruta, fileName);
        if (!file.exists()) { //No existe el archivo
            f.mkdir();
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error");
            }
        }
    }
    
}
