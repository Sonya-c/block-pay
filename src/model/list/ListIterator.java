package model.list;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<T> {
    ListNode<T> current;
      
    public ListIterator(List<T> list) {
        current = list.getHead();
    }
    
    @Override
    public boolean hasNext() {
        return current != null;
    }
      
    @Override
    public T next() {
        T data = current.getInfo();
        current = current.getNext();
        return data;
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}