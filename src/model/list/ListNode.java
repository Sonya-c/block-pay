/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.list;

import model.system.Account;

/**
 *
 * @author sonya
 * @param <T>
 */
public class ListNode<T> extends List<T> {

    private ListNode<T> next;
    private ListNode<T> prev;
    private ListNode<T> down;
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

    public ListNode<T> getDown() {
        return this.down;
    }

    /**
     *
     * @param down
     */
    public void setDown(ListNode<T> down){
        this.down = down;
    }
    
    @Override
    public void add(T info){
        ListNode<T> node = new ListNode<>(info);
        if (info instanceof Account){
            ListNode<T> nTemp = this; 
            while (nTemp != null){
                nTemp = nTemp.getDown();
            }
            if (nTemp == null){
                nTemp = node;
                nTemp.setDown(null);
            }
        }
    }

}
