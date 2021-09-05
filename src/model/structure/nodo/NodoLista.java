package model.structure.nodo;

public class NodoLista extends Nodo {
    private NodoLista next;
    private NodoLista prev;

    public NodoLista() {
        super();
    }

    public NodoLista(Object info) {
        super(info);
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
