package other;

import other.List;

import java.util.Iterator;

public class SortedListIterative <E extends Comparable<E>> extends List<E> {
    public void insert(E data) {
        Node<E> newNode = new Node<E>(data);
        if (head == null)
            head = newNode;
        else if (head.data.compareTo(data) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null && current.next.data.compareTo(data) < 0)
                current = current.next;
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void remove(E data) {

    }

    public E retrieve(int index) {
        Node<E> current = head;
        if (current == null || index < 0)
            return null;

        while (index-- > 0 && current != null)
            current = current.next;

        if (current == null)
            return null;

        return current.data;
    }

    public boolean search(E data) {
        Node<E> current = head;
        while (current != null && !current.data.equals(data))
            current = current.next;
        return current != null;
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
}
