package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import model.structure.Arbol;
import model.structure.nodo.NodoArbol;
import model.system.Persona;
import model.system.Transaccion;
import view.WelcomeView;

public class FileController {

     private final Arbol arbol;

    public FileController(Arbol arbol) {
        this.arbol = arbol;
    }

    public NodoArbol uploadUsers(File file, File file2, NodoArbol root) {
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split("#");
                Persona p = new Persona(data[0], data[1], data[2], Integer.parseInt(data[4]), Float.parseFloat(data[5]));
                root = arbol.insert(root, p);
                System.out.println("logrado");
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo de Usuarios no se encontró");
        }
        try(Scanner sc=new Scanner(file2)){
            
        }catch(FileNotFoundException e){
            System.out.println("El archivo de Transacciones no se encontró");
        }
        return root;
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

    public boolean searchInFile(File file, int id) {
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

    public boolean searchInFilePassword(File file, String password) {
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split("#");
                String pw = data[3];
                if (pw.equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró");
        }
        return false;
    }

    public boolean searchInFile(File file, String user) {
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

    public void deleteFile(File file) {
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception ex) {
            System.out.println("Archivo no encontrado");
        }
    }

    public void writeFile(File file, String line) {
        try (FileWriter fw = new FileWriter(file.getAbsoluteFile(), true)) {
            //casting
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                //casting
                bw.write(line);
                System.out.println(line);
                bw.newLine();

                bw.flush();
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al cargar archivo");
        }
    }

    public void updateCash(File file, float cash, String user) {
        File newFile = new File(file.getAbsolutePath() + ".tmp");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println("entró");
            String linea;
            while ((linea = br.readLine()) != null) {
                String data[] = linea.split("#");
                String cash_ = data[5];
                String dataUser = data[0];
                if (dataUser.equals(user)) {
                    String userName = user;
                    String name = data[1];
                    String lastName = data[2];
                    String pw = data[3];
                    String iD = data[4];
                    float cashData = Float.parseFloat(cash_) + cash;
                    String line = userName + "#" + name + "#" + lastName + "#" + pw + "#" + iD + "#" + String.valueOf(cashData);
                    this.writeFile(newFile, line);
                } else {
                    this.writeFile(newFile, linea);
                }
            }
            br.close();
            if (!file.delete()) {
                System.out.println("No se pudo borrar el archivo antiguo");
            }
            if (!newFile.renameTo(file)) {
                System.out.println("No se pudo renombrar el archivo");
            }
        } catch (IOException ex) {
            System.out.println("Archivo no encontrado");
        }
    }

    public void wirteFile(File file,Transaccion t){
         try (FileWriter fw = new FileWriter(file.getAbsoluteFile(), true)) {
            //casting
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                //casting
                String identificador = String.valueOf(t.getId());
                String userRemitente = t.getRemitente().getUserName() + "_" + String.valueOf(t.getRemitente().getId());
                String userDestinatario = t.getDestinatario().getUserName() + "_" + String.valueOf(t.getDestinatario().getId());
                String monto_ = String.valueOf(t.getMonto());

                bw.write(identificador + "#" + userRemitente + "#" + userDestinatario + "#" + monto_);
                System.out.println(identificador + "#" + userRemitente + "#" + userDestinatario + "#" + monto_ );
                bw.newLine();

                bw.flush();
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al cargar archivo");
        }
    }
    
    public void writeFile(File file, Persona p, String password) {
        try (FileWriter fw = new FileWriter(file.getAbsoluteFile(), true)) {
            //casting
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                //casting
                String user = p.getUserName();
                String name = p.getNames();
                String lastName = p.getLastNames();
                String pw = password;
                String iD = String.valueOf(p.getId());
                String cash_ = String.valueOf(p.getDinero());

                bw.write(user + "#" + name + "#" + lastName + "#" + pw + "#" + iD + "#" + cash_);
                System.out.println(user + "#" + name + "#" + lastName + "#" + pw + "#" + iD + "#" + cash_);
                bw.newLine();

                bw.flush();
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al cargar archivo");
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

    public Persona searchInFilePersona(File file, String userName) {
        Persona p;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split("#");
                String userDataB = data[0];
                if (userDataB.equals(userName)) {
                    p = new Persona(userName, data[1], data[2], Integer.parseInt(data[4]), Float.parseFloat(data[5]));
                    return p;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró");
        }
        return null;
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
