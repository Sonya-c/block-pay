package model.dynamic.list;

import java.util.Iterator;

public class List <T> implements  Iterable<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    
    private int size = 0;
    private final int MAX_SIZE;
    
    public List() {
        this.MAX_SIZE = -1;
    }
    
    public List(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }
    
    public void add(T info) {
        ListNode<T> node = new ListNode<>(info);
        if (this.head == null)
            this.head = this.tail = node;
        else {
            tail.setNext(node);
            tail = node;
        }
    }
    
    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(this);
    }
    
    /* ======= GETTERS AND SETTERS =======*/
    
    public ListNode<T> getHead() {
        return this.head;
    }
    
}
