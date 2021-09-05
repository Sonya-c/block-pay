
package model.structure.nodo;


public abstract class Nodo {
    protected Object info;
    
    public Nodo() {
        
    }
    public Nodo(Object info) {
        this.info = info;
    }
    
    // ==== Getters and setters
    public void setInfo(Object info) {
       this.info = info; 
    }

    public Object getInfo() {
        return this.info;
    }

}
