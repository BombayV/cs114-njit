//import java.util.Iterator;
//
//interface Queue<E> extends Iterable<E> {
//    E dequeue();
//    void enqueue(E data);
//}
//
//public class AQueue<E> implements Queue<E> {
//    private class QueueIterator<E> implements Iterator<E> {
//        public boolean hasNext() {
//            return curr != tail;
//        }
//        public E next() {
//
//        }
//
//        private E curr;
//    }
//
//    private Object[] queue = new Object[10];
//    private int head;
//    private int tail;
//
//    public void enqueue(E data) {
//        boolean full = head != (tail + 1) % queue.length;
//
//        if (head != (tail + 1) % queue.length) {
//            queue[tail] = data;
//            tail = (tail + 1) % queue.length;
//        }
//    }
//
//    public E dequeue() {
//        if (queue.length > 10 && ((queue.length + tail - head) % queue.length) <= (queue.length / 3)) {
//            shrink();
//        }
//
//        E temp = null;
//        if (head != tail) {
//            temp = (E)queue[head];
//            head = (head + 1) % queue.length;
//        }
//
//        return null;
//    }
//
//    private void grow() {
//        Object[] temp = new Object[queue.length * 2];
//        for (int i = 0; i < queue.length; i++) {
//            temp[i] = queue[(head+i) % queue.length];
//        }
//        head = 0;
//        tail = queue.length - 1;
//        queue = temp;
//    }
//
//    private void shrink() {
//        Object[] temp = new Object[queue.length / 2];
//        for (int i = 0; i < temp.length; i++) {
//            temp[i] = queue[(head + 1) % queue.length;
//        }
//
//        head = 0;
//        tail = temp.length - 1;
//        queue = temp;
//    }
//
//    public Iterator<E> iterator() {
//        return new QueueIterator<E>();
//    }
//}
//
//public class RQueue <E> implements Queue<E> {
//    private class Node<T> {
//        private T data;
//        private Node<T> next;
//        private Node(T data) {
//            this.data = data;
//        }
//    }
//
//    public Iterator<E> iterator() {
//        return new Iterator<E>() {
//            public boolean hasNext() {
//                return curr != null;
//            }
//            public E next() {
//                E temp = curr.data;
//                curr = curr.next;
//                return temp;
//            }
//            private Node<E> curr = head;
//        };
//    }
//
//    private Node<E> head;
//    private Node<E> tail;
//
//    public void enqueue(E data) {
//        Node<E> temp = new Node<E>(data);
//        if (head == null) head = tail = temp;
//        else {
//            tail.next = temp;
//            tail = tail.next;
//        }
//    }
//
//    public E dequeue() {
//        E temp = null;
//        if (head != null) {
//            temp = head.data;
//            if (head.next == null) {
//                head = null;
//                tail = null;
//            } else
//                head = head.next;
//        }
//
//        return temp;
//    }
//}