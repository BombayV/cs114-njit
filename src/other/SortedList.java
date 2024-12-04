package other;

import other.List;

import java.util.Iterator;

/*
 *
 *  other.SortedList.java
 *
 */

public class SortedList<E extends Comparable<? super E>> extends List<E> {
    public void insert(E data) {
        head = insert(data, head);
    }

    public void remove(E data) {
        head = remove(data, head);
    }

    public E retrieve(int index) {
        return retrieve(index, head);
    }

    public boolean search(E data) {
        return search(data, head);
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;
            public boolean hasNext() {
                return current != null;
            }
            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    // Recursive methods
    private Node<E> insert(E data, Node<E> current) {
        Node<E> newNode = new Node<E>(data);
        if (current == null)
            return newNode;
        if (current.data.compareTo(data) > 0) {
            newNode.next = current;
            return newNode;
        }

        current.next = insert(data, current.next);
        return current;
    }

    private Node<E> remove(E data, Node<E> current) {
        if (current == null)
            return null;
        if (current.data.equals(data))
            return current.next;

        current.next = remove(data, current.next);
        return current;
    }

    private E retrieve(int index, Node<E> current) {
        if (current == null || index < 0)
            return null;

        if (index == 0)
            return current.data;

        return retrieve(index - 1, current.next);
    }

    private boolean search(E data, Node<E> current) {
        if (current == null)
            return false;
        if (current.data.equals(data))
            return true;

        return search(data, current.next);
    }
}