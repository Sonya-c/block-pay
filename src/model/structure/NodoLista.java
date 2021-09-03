package model.structure;

public class NodoLista {
    private Object info;
    private NodoLista next;
    private NodoLista prev;

    public NodoLista() {}

    public NodoLista(Object info) {
        this.info = info;
    }

    // ==== Getters and setters
    public void setInfo(Object info) {
       this.info = info; 
    }

    public Object getInfo() {
        return this.info;
    }

    public void setNext(NodoLista next) {
        this.next = next;
    }

    public NodoLista getNext() {
        return this.next;
    }

    public void setPrev(NodoLista prev) {
        this.prev = prev;
    }

    public NodoLista getPrev() {
        return this.prev;
    }
    
}
