package important;

import java.util.Iterator;

public class Queue<E> extends IQueue<E> {

    @Override
    public Node<E> push(E data) {
        if (head == null) {
            head = new Node<E>(data);
            tail = head;
        } else {
            tail.next = new Node<E>(data);
            tail = tail.next;
        }

        return tail;
    }

    @Override
    public Node<E> pop() {
        if (head == null) {
            return null;
        }

        Node<E> temp = head;
        head = head.next;
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> head = Queue.this.head;
            @Override
            public boolean hasNext() {
                return head != null;
            }

            @Override
            public E next() {
                E data = head.data;
                head = head.next;
                return data;
            }
        };
    }
}
