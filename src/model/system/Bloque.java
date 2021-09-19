/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.system;

import model.structure.nodo.NodoArbol;

/**
 *
 * @author 57301
 */
public class Bloque extends NodoArbol{

    private final int TRANSACCIONES_MAXIMAS;
    private int transaccionesAct;
    public Bloque(int numBloque) {
        super();
        this.TRANSACCIONES_MAXIMAS = 3;
        this.transaccionesAct = 0;
        this.info = numBloque;
    }

    @Override
    public Object getInfo() {
        return info;
    }
    
    public int getTRANSACCIONES_MAXIMAS() {
        return TRANSACCIONES_MAXIMAS;
    }

    public int getTransaccionesAct() {
        return transaccionesAct;
    }

    public void setTransaccionesAct() {
        this.transaccionesAct ++;
    }

    @Override
    public NodoArbol getPrev() {
        return prev;
    }

    @Override
    public void setPrev(NodoArbol prev) {
        this.prev = prev;
    }

    @Override
    public NodoArbol getNext() {
        return next;
    }

    @Override
    public void setNext(NodoArbol next) {
        this.next = next;
    }

    
    
    /**
     *
     * @param b
     * @param info
     */
    @Override
    public void addChild(NodoArbol b, Object info){
        if (this.confAvaibleTrans(b)){
            this.children.add(info,b);
            this.setTransaccionesAct();
        } 
    }
    
    public boolean confAvaibleTrans(NodoArbol b) {
        return this.transaccionesAct != 3;
    }

}
