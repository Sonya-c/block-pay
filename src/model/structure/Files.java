/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 57301
 */
public class Files {

    public Files() {

    }

    public boolean searchInFile(File file, int id){
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split("#");
                String iD = data[3];
                if (iD.equals(id)) {
                    return false;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró");
        }
        return true;
    }
    
    public boolean searchInFile(File file, String user){
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split("#");
                String userDataB = data[0];
                if (userDataB.equals(user)) {
                    return false;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró");
        }
        return true;
    }
    
    public void writeFile(File file, String userName, String names, String lastNames, int id, float cash){
         try (FileWriter fw = new FileWriter(file.getAbsoluteFile(), true)) {
             //casting
             try (BufferedWriter bw = new BufferedWriter(fw)) {
                 //casting
                 String user = userName;
                 String name = names;
                 String lastName = lastNames;
                 String iD = String.valueOf(id);
                 String cash_ = String.valueOf(cash);
                
                 bw.write(user + "#" + name + "#" + lastName + "#" + iD + "#" + cash_);
                 System.out.println(user + "#" + name + "#" + lastName + "#" + iD + "#" + cash_);
                 bw.newLine();
                 
                 bw.flush();
             }
                    fw.close();
            } catch (IOException e) {
                System.out.println("Error al crear archivo");
            }
    }

    public void searchOrCreateFile(File file, String fileName) {
        String sDir = "C:\\Block-Pay";
        File f = new File(sDir);
        String ruta = "C:\\Block-Pay"; //Carpeta ruta
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
//    
//        public void readFileId(String name, int Id) {
//
//        File file = new File("C:\\Block-Pay\\"+name);
//
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//
//            String currentLine;
//
//            while ((currentLine = reader.readLine()) != null) {
//                if (currentLine.trim().equals(lineToRemove)) {
//                    continue;
//                }
//                writer.write(currentLine + System.getProperty("line.separator"));
//            }
//
//            reader.close();
//
//        } catch (IOException e) {
//            //e.printStackTrace();
//        }
//    }

}
