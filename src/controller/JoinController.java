package controller;

import model.structure.Arbol;
import view.JoinView;
import view.main.MainView;

public class JoinController {
    private Arbol arbol;
    
    private boolean joined = false;
    
    private JoinView joinView;
    private MainView mainView;
    
    public JoinController(Arbol arbol) {
        this.arbol = arbol;
        this.joinView = new JoinView(this);
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

    public void setJoined(boolean joined) {
        this.joined = joined;
        this.mainView = new MainView(arbol, null);
        
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
     * @param name
     * @param password
     * @return
     *  0: SignUp Exitoso
     *  1: nombre de usuario exite
     */
    public int signUp(String name, String password) {
        return 0;
    }
}