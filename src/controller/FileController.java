package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import model.structure.Arbol;
import view.WelcomeView;

public class FileController {

    private final Arbol arbol;
    
    public FileController(Arbol arbol) {
        this.arbol = arbol;
    }

    public void load() {
        WelcomeView welcomeView = new WelcomeView();
        
        welcomeView.setMaxValue(6);
        welcomeView.setVisible(true);
        
        int i = 0; // Esto es solo temporal!!!!!
        while (i <= 6) {
            welcomeView.progress();
            i++;
        }
        
        welcomeView.setVisible(false);
    }

        public boolean searchInFile(File file, int id){
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split("#");
                String iD = data[3];
                if (iD.equals(id)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró");
        }
        return false;
    }
    
    public boolean searchInFile(File file, String user){
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split("#");
                String userDataB = data[0];
                if (userDataB.equals(user)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró");
        }
        return false;
    }
    
    public void writeFile(File file, String userName, String names, String lastNames, String password, int id, float cash){
         try (FileWriter fw = new FileWriter(file.getAbsoluteFile(), true)) {
             //casting
             try (BufferedWriter bw = new BufferedWriter(fw)) {
                 //casting
                 String user = userName;
                 String name = names;
                 String lastName = lastNames;
                 String pw = password;
                 String iD = String.valueOf(id);
                 String cash_ = String.valueOf(cash);
                
                 bw.write(user + "#" + name + "#" + lastName + "#" + pw + "#" + iD + "#" + cash_);
                 System.out.println(user + "#" + name + "#" + lastName +"#"  + pw + "#" + iD + "#" + cash_);
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

}

/*
    public void readFileId(String name, int Id) {
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

*/