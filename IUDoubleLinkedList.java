import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class IUDoubleLinkedList<T> implements IndexedUnsortedList<T> {
    private int size;
    private int modCount;
    private Node<T> head, tail;

    IUDoubleLinkedList() {
        size = 0;
        modCount = 0;
        head = tail = null;
    }

    
    @Override
    public void addToFront(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToFront'");
    }


    @Override
    public void addToRear(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToRear'");
    }


    @Override
    public void add(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }


    @Override
    public void addAfter(T element, T target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAfter'");
    }


    @Override
    public void add(int index, T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }


    @Override
    public T removeFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFirst'");
    }


    @Override
    public T removeLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
    }


    @Override
    public T remove(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }


    @Override
    public T remove(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }


    @Override
    public void set(int index, T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }


    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }


    @Override
    public int indexOf(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public T first() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getElement();
    }

    @Override
    public T last() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.getElement();
    }
    
    @Override
    public boolean contains(T target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new DLLIterator();
        return iterator;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new DLLIterator();
    }

    @Override
    public ListIterator<T> listIterator(int startingIndex) {
        return new DLLIterator(startingIndex);
    }
    
    private class DLLIterator implements ListIterator<T> {

        DLLIterator() {

        }
        DLLIterator(int startingIndex) {

        }
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'next'");
        }

        @Override
        public boolean hasPrevious() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'hasPrevious'");
        }

        @Override
        public T previous() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'previous'");
        }

        @Override
        public int nextIndex() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'nextIndex'");
        }

        @Override
        public int previousIndex() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'previousIndex'");
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'remove'");
        }

        @Override
        public void set(Object e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'set'");
        }

        @Override
        public void add(Object e) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'add'");
        }
        
    }
}