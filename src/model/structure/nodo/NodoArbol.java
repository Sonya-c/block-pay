package model.structure.nodo;

import model.structure.Lista;

public class NodoArbol extends Nodo {

    protected Lista children;
    protected NodoArbol prev;
    protected NodoArbol next;
    protected NodoArbol dad;
    

    public NodoArbol() {
        this.children = new Lista();
        
    }

    public NodoArbol(int MAX_CHILDREN) {
        this.children = new Lista(MAX_CHILDREN);
    }
    
    public NodoArbol(NodoArbol dad, int MAX_CHILDREN, Object info){
        this.children = new Lista(MAX_CHILDREN);
        this.next = null;
        this.prev = null;
        this.info = info;
    }

    @Override
    public Object getInfo() {
        return info;
    }

    @Override
    public void setInfo(Object info){
        this.info  = info;
    }
    
   public static int getN() {
        return N;
    }

    public void remove(Object info) {
        this.children.remove(info);
    }

    
    public void addChild(NodoArbol dad, Object info, int futureSize) {
        this.children.add(info, futureSize, dad);
    }
    
    public void addChild(NodoArbol dad, Object info) {
        this.children.add(info, dad);
    }

    public void addChild(NodoArbol dad) {
        this.children.add(dad);
    }
    public Lista getChildren() {
        return this.children;
    }

    public NodoArbol getNext() {
        return next;
    }

    public void setNext(NodoArbol next) {
        this.next = next;
    }

    public NodoArbol getDad() {
        return dad;
    }

    public void setDad(NodoArbol dad) {
        this.dad = dad;
    }

    public NodoArbol getPrev() {
        return prev;
    }

    public void setPrev(NodoArbol prev) {
        this.prev = prev;
    }
    
    

}
