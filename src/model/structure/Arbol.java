
package model.structure;

import model.structure.nodo.NodoArbol;

public class Arbol {
    private NodoArbol root;

    public Arbol() {
        this.root = new NodoArbol();
    }

    public Arbol(int N) {
        this.root = new NodoArbol(N);
    }
    
    public void add() {
        root.addChild();
    }
    
    public void add(Object info) {
        root.addChild(info);
    }
    
    public NodoArbol getRoot() {
        return this.root;
    }
}
