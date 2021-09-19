package controller;

import java.io.File;
import model.structure.Arbol;
import model.structure.nodo.NodoArbol;
import model.system.Persona;
import view.Dialog;
import view.JoinView;
import view.main.MainView;

public class JoinController {

 
    private Arbol arbol;

    private boolean joined = false;

    private JoinView joinView;
    private MainView mainView;
    private FileController registro;

    public JoinController(Arbol arbol) {
        this.arbol = arbol;
        this.joinView = new JoinView(this);
        this.registro = new FileController(arbol);
    }

    public void join() {
        joinView.setVisible(true);
        joinView.signUpPanel.setVisible(false);
    }

    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    public boolean isJoined() {
        return joined;
    }

    public void setJoined(boolean joined, Persona p) {
        this.joined = joined;
        this.mainView = new MainView(arbol, p);
        System.out.println(arbol.getRoot());
        joinView.setVisible(false);
        mainView.setVisible(true);

    }

    /**
     *
     * @param userName
     * @param password //* @return 0: Login exitoso 1: usuario no existe 2:
     * contraseña incorrecta
     */
    public void login(String userName, String password) {
        Dialog dialog = new Dialog();
        File f = new File("C:\\Block-Pay\\registrosUsuarios.txt");
        registro.searchOrCreateFile(f, "registrosUsuarios.txt");
        if (registro.searchInFile(f, userName)) {
            if (registro.searchInFilePassword(f, password)) {
                Persona p = registro.searchInFilePersona(f, userName);
                System.out.println(arbol.getRoot().getInfo());
                this.setJoined(true, p);
            } else {
                dialog.setMessage("Contraseña incorrecta");
            }
        } else {
            dialog.setMessage("Usuario no encontrado");
        }
    }

    /**
     *
     * @param userName
     * @param names
     * @param lastNames
     * @param password
     * @return 0: SignUp Exitoso 1: nombre de usuario exite
     */
    public int signUp(String userName, String names, String lastNames, String password) {
        File f = new File("C:\\Block-Pay\\registrosUsuarios.txt");

        registro.searchOrCreateFile(f, "registrosUsuarios.txt");

        if (registro.searchInFile(f, userName)) {
            return 1;
        } else {
            int iD = (int) (Math.random() * (54321 - 1 + 1) + 1);

            while (registro.searchInFile(f, iD)) {
                iD = (int) (Math.random() * (54321 - 1 + 1) + 1);
            }

//            NodoArbol q = arbol.searchInfoP(arbol.getRoot(), "userFijo");
            Persona p = new Persona(userName, names, lastNames, iD, 50000);

            registro.writeFile(f, p, password);
            arbol.insert(arbol.getRoot(), p);
            registro.updateCash(f, -500000, "userFijo");
            arbol.searchUser(arbol.getRoot().getChildren().search(0), arbol.searchUser(arbol.getRoot().getChildren().search(0), "userFijo", 0), -50000, 0);
            
            registro.load();
            this.setJoined(true, p);

            return 0;
        }
    }
}
