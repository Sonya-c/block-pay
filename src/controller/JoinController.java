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

        System.out.println("controller.JoinController.setJoined arbol" + arbol.getRoot());

        joinView.setVisible(false);
        mainView.setVisible(true);
    }

    /**
     *
     * @param userName
     * @param password
     */
    public void login(String userName, String password) {
        Dialog dialog = new Dialog();
        NodoArbol root = arbol.getRoot();

        NodoArbol rootUser = root.getChildren().search(0);
        System.out.println("controller.JoinCotronller.login root usuarios" + root != null ? root.getInfo() : "null");

        Persona user = arbol.searchUser(rootUser, userName, 0);
        System.out.println("controller.JoinCotronller.login user : " + user);

        if (user != null) {
            System.out.println(user.getPassword());
            System.out.println(password);
            if (user.getPassword().equals(password)) {
                this.setJoined(true, user);
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
     */
    public void signUp(String userName, String names, String lastNames, String password) {
        Dialog dialog = new Dialog();
        NodoArbol root = arbol.getRoot();

        NodoArbol rootUser = root.getChildren().search(0);
        System.out.println("controller.JoinCotronller.login root usuarios" + root != null ? root.getInfo() : "null");

        Persona user = arbol.searchUser(rootUser, userName, 0);
        System.out.println("controller.JoinCotronller.login user : " + user);

        if (user != null) {
            dialog.setMessage("Este usuario ya existe.");
        } else {
            File f = new File("C:\\Block-Pay\\registrosUsuarios.txt");
            registro.searchOrCreateFile(f, "registrosUsuarios.txt");

            System.out.println("controller.FileController.signUp: corregir busqueda de archivos!!");
            int iD = (int) (Math.random() * (54321 - 1 + 1) + 1);
            while (registro.searchInFile(f, iD)) {
                iD = (int) (Math.random() * (54321 - 1 + 1) + 1);
            }

            Persona p = new Persona(userName, names, lastNames, iD, 50000, password);
            registro.writeFile(f, p);
            arbol.insertPersona(arbol.getRoot(), p);
            Persona userFijo = arbol.searchUser(arbol.getRoot().getChildren().search(0), 0, 0);
            userFijo.setDinero(userFijo.getDinero() - 50000);
            registro.updateCash(f, userFijo.getDinero(), "userFijo");
//            arbol.searchUser(arbol.getRoot().getChildren().search(0), arbol.searchUser(arbol.getRoot().getChildren().search(0), "userFijo", 0), -50000, 0);

            this.setJoined(true, p);
        }
    }

    public void modifyDataUser(String userName, String names, String lastNames, String password, Persona userAct) {
//        Dialog dialog = new Dialog();
//        NodoArbol root = arbol.getRoot();
//
//        NodoArbol rootUser = root.getChildren().search(0);
//        System.out.println("controller.JoinCotronller.login root usuarios" + root != null ? root.getInfo() : "null");
//
//        if (userAct.getUserName().equals(userName) && names.equals(userAct.getNames()) && password.equals(userAct.getPassword())
//                && lastNames.equals(userAct.getLastNames())) {
//            dialog.setMessage("Los datos suministrados son iguales a los datos actuales. \n No hubo cambio en la información.");
//        } else {
//            Persona user = arbol.searchUser(rootUser, userName, 0);
//            System.out.println("controller.JoinCotronller.login user : " + user);
//            if (user != null) {
//                dialog.setMessage("Este usuario ya existe.");
//            } else {
//                File f = new File("C:\\Block-Pay\\registrosUsuarios.txt");
//                registro.searchOrCreateFile(f, "registrosUsuarios.txt");
//                userAct = new Persona (userName, names, lastNames, userAct.getId(), userAct.getDinero(), password);
//                arbol.searchUser(root.getChildren().search(0),userAct);
//                registro.writeFile(f, userAct);
////            arbol.searchUser(arbol.getRoot().getChildren().search(0), arbol.searchUser(arbol.getRoot().getChildren().search(0), "userFijo", 0), -50000, 0);
//
//            }
//        }
//    }
}
}

