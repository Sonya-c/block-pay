package model.structure.nodo;
import model.structure.Lista;

public class NodoLista extends Nodo {
    private NodoLista next;
    private NodoLista prev;
    private Lista children;
    private NodoLista dad;
    private NodoArbol dadRoot;

    public NodoLista(int MAX_CHILDREN){
        super();
        children = new Lista(MAX_CHILDREN);
    }
    
    public NodoLista(NodoArbol dad, int MAX_CHILDREN, Object info) {
        super();
        this.next = null;
        this.prev = null;
        this.dadRoot = dad;
        this.info = info;
        children = new Lista(MAX_CHILDREN);
    }
    
     public NodoLista(NodoArbol dad, NodoLista prev,int MAX_CHILDREN, Object info) {
        super();
        this.next = null;
        this.prev = prev;
        this.dadRoot = dad;
        this.info = info;
        children = new Lista(MAX_CHILDREN);
    }
    
    public NodoLista(NodoLista dad, NodoLista prev, int MAX_CHILDREN) {
        super();
        this.next = null;
        this.prev = prev;
        this.dad = dad;
        children = new Lista(MAX_CHILDREN);
    }

    public NodoLista(NodoLista dad, Object info, int MAX_CHILDREN) {
        super(info);
        this.dad = dad;
        children = new Lista(MAX_CHILDREN);
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
    
    public void setDad(NodoLista dad){
        this.dad = dad;
    }
    
    public NodoLista getDad(){
        return this.dad;
    }

    public NodoArbol getDadRoot() {
        return dadRoot;
    }

    public void setDadRoot(NodoArbol dadRoot) {
        this.dadRoot = dadRoot;
    }
    
    @Override
    public Object getInfo(){
        return this.info;
    }
    
    @Override
   public void setInfo (Object info){
       this.info = info;
   }
   
      public void remove(Object info) {
        this.children.remove(info);
    }

//    public void addChild(Object info) {
//        this.children.add(info);
//    }
//
//    public void addChild() {
//        this.children.add();
//    }
    public Lista getChildren() {
        return this.children;
    }
     
   
}
