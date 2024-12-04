package important;

import java.util.Iterator;

public class Stack<E> extends IStack<E> {
    private Node<E> top;
    @Override
    public Node<E> push(E data) {
        Node<E> newNode = new Node<>(data);
        if (top != null) {
            newNode.next = top;
        }

        top = newNode;
        return newNode;
    }

    @Override
    public Node<E> pop() {
        Node<E> temp;
        if (top == null) {
            return null;
        }

        temp = top;
        top = top.next;
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = top;
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
