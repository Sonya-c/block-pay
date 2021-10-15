package model.list;

import java.util.Iterator;

public class List<T> implements Iterable<T> {

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
        if (size < MAX_SIZE) {
            if (this.head == null) {
                this.head = this.tail = node;
            } else {
                tail.setNext(node);
                node.setPrev(tail);
                tail = node;
                
            }
            size++;
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

    public ListNode<T> getTail() {
        return this.tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ListNode<T> getNode(T info) {
        ListNode<T> h = this.head;
        while (h != null) {
            if (h.getInfo() == info) {
                return h;
            }
            h = h.getNext();
        }
        return null;
    }

}
