import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Single-linked node implementation of IndexedUnsortedList.
 * An Iterator with working remove() method is implemented, but
 * ListIterator is unsupported.
 * 
 * @author Michael Rangel 
 * 
 * @param <T> type to store
 */
public class IUSingleLinkedList<T> implements IndexedUnsortedList<T> {
	private Node<T> head, tail;
	private int size;
	private int modCount;

    /** 
     * Iterates through the nodes until the specified index and return the node
     * @param index of the node to be returned
     * @return the node at the specified index
     */
    private Node<T> getNode(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> foundNode = head;
        for (int i = 0; i < index; i++) {
            foundNode = foundNode.getNext();
        }
        return foundNode;
    }

	/** Creates an empty list */
	public IUSingleLinkedList() {
		head = tail = null;
		size = 0;
		modCount = 0;
	}

	@Override
	public void addToFront(T element) {
		Node<T> newNode = new Node<T>(element);
        newNode.setNext(head);
        if(isEmpty()) {
            tail = newNode;
        }
        head = newNode;
        size++;
        modCount++;
	}

	@Override
	public void addToRear(T element) {
		add(element);
	}

	@Override
	public void add(T element) {
        Node<T> newNode = new Node<T>(element);
        if(isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
		size++;
        modCount++;
	}

	@Override
	public void addAfter(T element, T target) {
		boolean found = false;
		Node<T> current = head;

		while (current != null && !found) {
			if (target.equals(current.getElement())) {
				found = true;
			} else {
				current = current.getNext();
			}
		}

		if (!found) {
			throw new NoSuchElementException();
		}

        if(current == head) {
            add(1, element);
        } else if(current == tail) {
            addToRear(element);
        } else {
            Node<T> newNode = new Node<T>(element);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            size++;
            modCount++;
        }
	}

	@Override
	public void add(int index, T element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
		Node<T> newNode = new Node<T>(element);
        if(index == 0) {
            addToFront(element);
        } else if (index == size) {
            addToRear(element);
        } else {
            Node<T> previousNode = getNode(index - 1);
            Node<T> currentNode = previousNode.getNext();   
            previousNode.setNext(newNode);
            newNode.setNext(currentNode);
            size++;
            modCount++;
        }
	}

	@Override
	public T removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(0);
	}

	@Override
	public T removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(size - 1);
	}

	@Override
	public T remove(T element) {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		boolean found = false;
		Node<T> previous = null;
		Node<T> current = head;
		
		while (current != null && !found) {
			if (element.equals(current.getElement())) {
				found = true;
			} else {
				previous = current;
				current = current.getNext();
			}
		}
		
		if (!found) {
			throw new NoSuchElementException();
		}
		
		if (size() == 1) { //only node
			head = tail = null;
		} else if (current == head) { //first node
			head = current.getNext();
		} else if (current == tail) { //last node
			tail = previous;
			tail.setNext(null);
		} else { //somewhere in the middle
			previous.setNext(current.getNext());
		}
		
		size--;
		modCount++;
		
		return current.getElement();
	}

	@Override
	public T remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
		
		Node<T> previous = null;
		Node<T> current = head;
		
		for(int i = 0; i < index; i++) {
			previous = current;
			current = current.getNext();
		}
	
		if (size() == 1) { //only node
			head = tail = null;
		} else if (current == head) { //first node
			head = current.getNext();
		} else if (current == tail) { //last node
			tail = previous;
			tail.setNext(null);
		} else { //somewhere in the middle
			previous.setNext(current.getNext());
		}
		
		size--;
		modCount++;
		
		return current.getElement();
	}

	@Override
	public void set(int index, T element) {
		getNode(index).setElement(element);
        modCount++;
	}

	@Override
	public T get(int index) {
		return getNode(index).getElement();
	}

	@Override
	public int indexOf(T element) {
		boolean found = false;
		Node<T> current = head;
        int index = 0;
		
		while (current != null && !found) {
			if (element.equals(current.getElement())) {
				found = true;
			} else {
                index++;
				current = current.getNext();
			}
		}
		
		if (!found) {
			index = -1;
		}
		
		return index;
	}

	@Override
	public T first() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
		return head.getElement();
	}

	@Override
	public T last() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
		return tail.getElement();
	}

	@Override
	public boolean contains(T target) {
		boolean found = false;
		Node<T> current = head;
		
		while (current != null && !found) {
			if (target.equals(current.getElement())) {
				found = true;
			} else {
				current = current.getNext();
			}
		}
	
		return found;
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
        Node<T> currentNode = head;
		sb.append("[");
		for(int i = 0; i < size; i++){
			sb.append(currentNode.getElement().toString());
			sb.append(", ");
            currentNode = currentNode.getNext();
		}
		if(size > 0) {
			sb.delete(sb.length()-2, sb.length());
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new SLLIterator();
	}

	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<T> listIterator(int startingIndex) {
		throw new UnsupportedOperationException();
	}

	/** Iterator for IUSingleLinkedList */
	private class SLLIterator implements Iterator<T> {
        private Node<T> previousNode;
        private Node<T> currentNode;
        private Node<T> nextNode;
		private int iterModCount;
        private boolean canRemove;
		
		/** Creates a new iterator for the list */
		public SLLIterator() {
            previousNode = null;
            currentNode = null;
            nextNode = head;
			iterModCount = modCount;
            canRemove = false;
		}

		@Override
		public boolean hasNext() {
            if(iterModCount != modCount) {
                throw new ConcurrentModificationException();
            }
			return nextNode != null;
		}

		@Override
		public T next() {
			if(iterModCount != modCount) {
				throw new ConcurrentModificationException();
			}
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            previousNode = currentNode;
            currentNode = nextNode; 
            nextNode = nextNode.getNext();

            canRemove = true;
			return currentNode.getElement();
		}
		
		@Override
		public void remove() {
            if(iterModCount != modCount) {
				throw new ConcurrentModificationException();
			}
            if(!canRemove) {
				throw new IllegalStateException();
			}
            if(currentNode == head) {
                head = nextNode;
            } else {
                previousNode.setNext(nextNode);            
            }
            if (currentNode == tail) {
                tail = previousNode;
            }

            size--;
            modCount++;
            iterModCount++;
            canRemove = false;
        }
    }
}
