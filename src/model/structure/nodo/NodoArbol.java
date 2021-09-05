package model.structure.nodo;

import model.structure.Lista;

public class NodoArbol extends Nodo {

    private Lista children;

    public NodoArbol() {
        this.children = new Lista();    
    }

    public NodoArbol(int MAX_CHILDREN) {
        this.children = new Lista(MAX_CHILDREN);
    }

    public void remove(Object info) {
        this.children.remove(info);
    }

    public void addChild(Object info) {
        this.children.add(info);
    }

    public void addChild() {
        this.children.add();
    }
}
