
package model.structure;

import model.structure.nodo.NodoArbol;
import model.structure.nodo.NodoLista;

public class Lista {
    private int size = 0;
    private int MAX_SIZE;
    private NodoArbol head;

    public Lista () {
        this.MAX_SIZE = -1;
    }

    public Lista(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    public int getSize(){
        return this.size;
    }
    
    public int getMAX_SIZE(){
        return this.MAX_SIZE;
    }
    
    /**
     * Dado un indice (indiciando en 0) lo busca en la lista
     * @param index
     * @return 
     */
    public NodoArbol search(int index) {
        NodoArbol nodo = this.head;
        int i = 0;
        
        while (nodo != null & i!= index) {
            nodo = nodo.getNext();
            i++;
        }
        
        if (i == index) return nodo;
        
        return null;
    }
    
    
    
    public int searchPos (Object info){
          NodoArbol nodo = this.head;
          int i = 0;
        if (this.head != null) {
            while(nodo.getNext() != null & !nodo.equals(info)) {
                nodo = nodo.getNext();
                i ++;
            }
            
            if (nodo.equals(info)) return i;
        }

        return 0;
    }
    
    /**
     * 
     * Buscar un nodo
     * 
     * @param info el nodo a buscar
     * @return el nodo encontrado. Es un nodo lista si lo encuentra y es null si no lo encuentra
     */
    public NodoArbol search(Object info) {
        NodoArbol nodo = this.head;

        if (this.head != null) {
            while(nodo.getNext() != null & !nodo.equals(info)) {
                nodo = nodo.getNext();
            }
            
            if (nodo.equals(info)) return nodo;
        }

        return null;
    }

    /**
     * Dado un elemento, lo busca (y si lo encuentra) lo elimina
     * @param info
     */
    public void remove(Object info) {
        NodoArbol nodo = search(info);

        if (nodo != null) {
            NodoArbol prev = nodo.getPrev();
            NodoArbol next = nodo.getNext();
            
            if (prev != null) {
                prev.setNext(next);
            }
            
            if (next != null) {
                next.setPrev(prev);
            }
        }
    }
    
    

    /**
     * Dado un elemento lo inserta
     * @param info
     * @param dad
     */
    public void add(Object info, NodoArbol dad) {
        NodoArbol nodo = this.head;
        
        if (this.MAX_SIZE != -1 && this.size < this.MAX_SIZE) {
            if (nodo == null) {
                this.head = new NodoArbol(dad,this.MAX_SIZE,info);
            } else {

                while (nodo.getNext() != null) {
                    nodo = nodo.getNext();
                }
                
                NodoArbol newNodo = new NodoArbol(dad,this.MAX_SIZE,info);
                nodo.setNext(newNodo);
                newNodo.setPrev(nodo);
            }
        }
        size++;
    }

    public void add(Object info, int maxSize, NodoArbol dad) {
        this.MAX_SIZE = maxSize;
        NodoArbol nodo = this.head;
        
        if (this.MAX_SIZE != -1 && this.size < this.MAX_SIZE) {
            if (nodo == null) {
                this.head = new NodoArbol(dad,this.MAX_SIZE,info);
            } else {

                while (nodo.getNext() != null) {
                    nodo = nodo.getNext();
                }
                
                NodoArbol newNodo = new NodoArbol(dad,this.MAX_SIZE,info);
                nodo.setNext(newNodo);
                newNodo.setPrev(nodo);
            }
        }
        size++;
    }
    
    public void add(NodoArbol dad) {
        add(null, dad);
    }
}
