package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import model.structure.Arbol;
import model.structure.nodo.NodoArbol;
import model.system.Bloque;
import model.system.Persona;
import model.system.Transaccion;
import view.WelcomeView;

public class FileController {

    private final Arbol arbol;
    private static String dir;
    private static String userFileName;
    private static String blockFileName;

    private File userFile;
    private File blockFile;

    /**
     *
     * @param arbol
     */
    public FileController(Arbol arbol) {
        this.arbol = arbol;
    }

    /**
     *
     * @param arbol
     * @param dir
     * @param userFileName
     * @param blockFileName
     */
    public FileController(Arbol arbol, String dir, String userFileName, String blockFileName) {
        this.arbol = arbol;
        FileController.dir = dir;
        FileController.userFileName = userFileName;
        FileController.blockFileName = blockFileName;
    }

    /**
     * Carga los archivos y con ello crea el arbol
     */
    public void init() {
        WelcomeView welcomeView = new WelcomeView();
        welcomeView.setMaxValue(6);
        welcomeView.setVisible(true);

        // Crea los archivos
        this.userFile = new File(FileController.dir + FileController.userFileName);
        this.blockFile = new File(FileController.dir + FileController.blockFileName);
        welcomeView.progress();

        // Confirmar que los archivos existan
        searchOrCreateFile(this.userFile, FileController.userFileName);
        searchOrCreateFile(this.blockFile, FileController.blockFileName);
        welcomeView.progress();

        if (!this.searchInFile(userFile, "userFijo")) {
            this.writeFile(userFile, new Persona("userFijo", "First", "User", 0, 1000000000, "***"));
        }

        // Carga los usuarios al arbol
        NodoArbol root = this.arbol.getRoot();
        root = uploadUsers(root);
        root = uploadBlock(root);
        this.arbol.setRoot(root);
        welcomeView.progress();

        // Confirmar que el usuario 0 exista
        welcomeView.setVisible(false);
    }

    /**
     * Dado un archivo y el nombre del mismo, si no lo encunetre lo crea
     *
     * @param file archivo
     * @param fileName nombre del archivo
     */
    public void searchOrCreateFile(File file, String fileName) {
        File f = new File(dir);
        file = new File(FileController.dir, fileName);

        if (!file.exists()) {
            //No existe el archivo
            f.mkdir();

            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Controller.FileControoler.searchOrCreteFile Error: " + e.toString());
            }
        }
    }

    /**
     * Carga en el arbol la información de los usuarios
     *
     * @param root raíz del arbol
     * @return
     */
    public NodoArbol uploadUsers(NodoArbol root) {
        try (Scanner sc = new Scanner(userFile)) {

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split("#");

                Persona p = new Persona(data[0], data[1], data[2], Integer.parseInt(data[4]), Float.parseFloat(data[5]), data[3]);

                System.out.println(Arrays.toString(data));

                if (data[0].equals("userFijo")) {
                    root = arbol.insertRoot(root, p);
                    System.out.println("controller.FileController.uploadUser Raíz dentro");
                } else {
                    root = arbol.insertPersona(root, p);
                    System.out.println("controller.FileController.uploadUser logrado");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("controller.FileController.uploadUser El archivo de Usuarios no se encontró");
        }
        return root;
    }

    /**
     * Carga en el arbol la información de las transacciones
     *
     * @param root
     * @return
     */
    public NodoArbol uploadBlock(NodoArbol root) {
        try (Scanner sc = new Scanner(blockFile)) {

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String data[] = linea.split("#");

                Transaccion t = new Transaccion(
                        Integer.parseInt(data[0]),
                        Integer.parseInt(data[1]),
                        Integer.parseInt(data[2]),
                        Float.parseFloat(data[3]),
                        Float.parseFloat(data[4]),
                        Float.parseFloat(data[5]),
                        Float.parseFloat(data[6]),
                        Float.parseFloat(data[7])
                );
//                root = arbol.insert(root, t);
//                System.out.println(root.getChildren().search(1));
                       
                    System.out.println("root.getChildren().search(1) = " + root.getChildren().search(1));
                    root = arbol.insertTrans(root, t,0);
                    System.out.println(root);
                    System.out.println("controller.FileController.uploadBlock transacción en el arbol");
                
            }

        } catch (FileNotFoundException e) {
            System.out.println("controller.FileController.uploadBlock El archivo de Transacciones no se encontró");
        }

        return root;
    }

    /**
     * Dado un archivo y un identificador, busca en el archivo si esa linea
     * existe
     *
     * @param file
     * @param id
     * @return
     */
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
            System.out.println("controller.FileController.searchInFile El archivo no se encontró");
        }
        return false;
    }

    // MARK
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
    
    public void updateDataUser(File file, Persona user){
        File newFile = new File(file.getAbsolutePath() + ".tmp");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String data[] = linea.split("#");
                String idUser = data[4];
                if (user.getId() == Integer.parseInt(idUser)) {
                    String userName = user.getUserName();
                    String name = user.getNames();
                    String lastName = user.getLastNames();
                    String pw = user.getPassword();
                    String iD = idUser;
                    String cash_ = String.valueOf(user.getDinero());
                    String line = userName + "#" + name + "#" + lastName + "#" + pw + "#" + iD + "#" + cash_;
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

    public void updateCash(File file, float cash, String user) {
        File newFile = new File(file.getAbsolutePath() + ".tmp");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println("entró");
            String linea;
            while ((linea = br.readLine()) != null) {
                String data[] = linea.split("#");
                String dataUser = data[0];
                if (dataUser.equals(user)) {
                    String userName = user;
                    String name = data[1];
                    String lastName = data[2];
                    String pw = data[3];
                    String iD = data[4];
                    String cash_ = String.valueOf(cash);
                    String line = userName + "#" + name + "#" + lastName + "#" + pw + "#" + iD + "#" + cash_;
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

    /**
     * Escribelas trasacciones
     *
     * @param file
     * @param t
     */
    public void writeFile(File file, Transaccion t) {
        Persona remitente = arbol.searchUser(arbol.getRoot().getChildren().search(0), t.getRemitenteId(), 0);
        Persona destinatario = arbol.searchUser(arbol.getRoot().getChildren().search(0), t.getDestinatarioId(), 0);

        if (remitente != null && destinatario != null) {
            try (FileWriter fw = new FileWriter(file.getAbsoluteFile(), true)) {
                try (BufferedWriter bw = new BufferedWriter(fw)) {

                    String line = t.getId()
                            + "#" + t.getRemitenteId()
                            + "#" + t.getDestinatarioId()
                            + "#" + t.getMonto()
                            + "#" + t.getRemitenteAntes()
                            + "#" + t.getRemitenteDespues()
                            + "#" + t.getDestinatarioAntes()
                            + "#" + t.getDestinatarioDespues();

                    System.out.println("controller.FileController.writeFile: " + line);
                    bw.write(line);

                    bw.newLine();
                    bw.flush();
                }

                fw.close();

            } catch (IOException e) {
                System.out.println("controller.FilleController.writeFile Error al cargar archivo: " + e.toString());
            }
        }
    }

    public void writeFile(File file, Persona p) {
        try (FileWriter fw = new FileWriter(file.getAbsoluteFile(), true)) {
            //casting
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                //casting
                String user = p.getUserName();
                String name = p.getNames();
                String lastName = p.getLastNames();
                String pw = p.getPassword();
                String iD = String.valueOf(p.getId());
                String cash_ = String.valueOf(p.getDinero());

                bw.write(user + "#" + name + "#" + lastName + "#" + pw + "#" + iD + "#" + cash_);
                System.out.println("controller.FileController.writeFile " + user + "#" + name + "#" + lastName + "#" + pw + "#" + iD + "#" + cash_);
                bw.newLine();

                bw.flush();
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("controller.FileController.writeFile Error al cargar archivo");
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
                    p = new Persona(userName, data[1], data[2], Integer.parseInt(data[4]), Float.parseFloat(data[5]), data[3]);
                    return p;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró");
        }
        return null;
    }
}
