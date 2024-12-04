package important;

import java.util.Iterator;

public class LinkedList<E> extends ILinkedList<E> {
    @Override
    public Node<E> push(E data) {
        if (head == null) {
            head = new Node<>(data);
            return head;
        }

        Node<E> node = new Node<>(data);
        node.next = head;
        head = node;
        return node;
    }

    @Override
    public Node<E> pop() {
        if (head == null) {
            return null;
        }

        Node<E> node = head;
        head = head.next;
        return node;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
