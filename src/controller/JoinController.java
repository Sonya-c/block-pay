package controller;

import model.structure.Arbol;
import view.JoinView;

public class JoinController {
    private Arbol arbol;
    private boolean joined = false;

    public JoinController(Arbol arbol) {
        this.arbol = arbol;
    }

    public void join() {        
        JoinView joinView = new JoinView();
        joinView.setVisible(true);
        
        while (!joined) {
        
        }
        
        joinView.setVisible(false);
    }

}