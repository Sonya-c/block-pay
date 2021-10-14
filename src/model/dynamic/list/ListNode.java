/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dynamic.list;

/**
 *
 * @author sonya
 * @param <T>
 */
public class ListNode<T> extends List<T>{
    private ListNode<T> next;
    private ListNode<T> prev;
    private T info;
    
    /**
     * 
     * @param info 
     */
    public ListNode(T info) {
        this.info = info;
    }
    
    public T getInfo() {
        return this.info;
    }
    
    /**
     * 
     * @param info 
     */
    public void setInfo(T info) {
        this.info = info;
    }
    
    /* ======= GETTERS AND SETTERS =======*/
    
    public ListNode<T> getNext() {
        return this.next;
    }
    
    /**
     * 
     * @param next 
     */
    public void setNext(ListNode<T> next) {
        this.next = next;
    }
    
    public ListNode<T> getPrev() {
        return this.prev;
    }
    
    /**
     * 
     * @param prev 
     */
    public void setPrev(ListNode<T> prev) {
        this.prev = prev;
    }
}
