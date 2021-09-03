package model.structure;

public class NodoArbol {

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

    public void add(Object info) {
        this.children.add(info);
    }
}
