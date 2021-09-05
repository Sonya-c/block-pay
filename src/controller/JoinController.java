package controller;

import model.structure.Arbol;

public class JoinController {
    private Arbol arbol;
    private boolean joined = false;

    public JoinController(Arbol arbol) {
        this.arbol = arbol;
    }

    public void join() {
        
        while (!joined) { }
    }

}