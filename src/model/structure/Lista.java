
package model.structure;

public class Lista {
    private int size = 0;
    private final int MAX_SIZE;
    private NodoLista head;

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
     * 
     * Buscar un nodo
     * 
     * @param info el nodo a buscar
     * @return el nodo encontrado. Es un nodo lista si lo encuentra y es null si no lo encuentra
     */
    public NodoLista search(Object info) {
        NodoLista nodo = this.head;

        if (this.head != null) {
            while(nodo.getNext() != null & !nodo.equals(info)) {
                nodo = nodo.getNext();
            }
        }

        return nodo;
    }

    /**
     * Dado un elemento, lo busca (y si lo encuentra) lo elimina
     * @param info
     */
    public void remove(Object info) {
        NodoLista nodo = search(info);

        if (nodo != null) {
            NodoLista prev = nodo.getPrev();
            NodoLista next = nodo.getNext();
            
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
     */
    public void add(Object info) {
        NodoLista nodo = this.head;
        
        if (this.MAX_SIZE != -1 && this.size < this.MAX_SIZE) {
            if (nodo == null) {
                this.head = new NodoLista(info);
            } else {

                while (nodo.getNext() != null) {
                    nodo = nodo.getNext();
                }
                
                NodoLista newNodo = new NodoLista(info);
                nodo.setNext(newNodo);
                newNodo.setPrev(nodo);
            }
        }
        size++;
    }
}
