package controller;

import java.io.File;
import model.structure.Arbol;
import model.system.Persona;
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
        joinView.signUpPanel2.setVisible(false);
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
        
        joinView.setVisible(false);
        mainView.setVisible(true);
        
    }
    
    
    /**
     * 
     * @param name
     * @param password
     * @return
     *  0: Login exitoso
     *  1: usuario no existe
     *  2: contraseña incorrecta
     */
    public int login(String name, String password) {
      return 0;
    }
    
    /**
     * 
     * @param userName
     * @param names
     * @param lastNames
     * @param password
     * @return
     *  0: SignUp Exitoso
     *  1: nombre de usuario exite
     */
    public int signUp(String userName, String names, String lastNames, String password) {
        File f = new File("C:\\Block-Pay\\registros.txt");
        registro.searchOrCreateFile(f, "registros.txt");
        if (registro.searchInFile(f,userName)){
            System.out.println("1");
            return 1;
        } else {
            System.out.println("0");
            int iD = (int) (Math.random()*(54321-1+1)+1);
            while (registro.searchInFile(f, iD)){
                iD = (int) (Math.random()*(54321-1+1)+1);
            }
            Persona p = new Persona(userName, names, lastNames,iD,0f);
            registro.writeFile(f, userName, names, lastNames,password, iD, 0);
            this.setJoined(true, p);
            return 0;
        }
    }
}