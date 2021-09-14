/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.system;

import model.structure.Lista;
import model.structure.nodo.NodoArbol;

/**
 *
 * @author 57301
 */
public class Usuario extends NodoArbol{
    
    private Persona user;
    
    
    public Usuario() {
        super();
    }

    public Persona getUser() {
        return user;
    }

    public void setUser(Persona user) {
        this.user = user;
    }

    @Override
    public Lista getChildren() {
        return children;
    }

    public void setChildren(Lista children) {
        this.children = children;
    }

    @Override
    public Object getInfo() {
        return info;
    }

    @Override
    public void setInfo(Object info) {
        this.info = info;
    }

   

    /**
     *
     * @param root
     * @param info
     */
    @Override
    public void addChild(NodoArbol root, Object info){
        
    }
    
}
