import java.util.Iterator;
import java.util.Random;

//Random rand = new Random();
//Stack<Integer> stack = Math.random() < 0.5 ? new AStack<Integer>() : new RStack<Integer>();
//
//int num = 2;
//
//        System.out.println("Pushing...");
//        for (int i = 0; i < num; i++) {
//int n = rand.nextInt(num);
//            stack.push(n);
//            System.out.println(n);
//            for (Integer k: stack) {
//        System.out.print(k + " ");
//            }
//                    System.out.println(" ");
//        }
//
//                System.out.println("Popping");
//Integer j;
//        while ((j = stack.pop()) != null) {
//        System.out.println(j);
//            for (Integer k: stack) {
//        System.out.print(k + " ");
//            }
//                    System.out.println(" ");
//        }

interface Stack<E> extends Iterable<E> {
    E pop();
    void push(E data);
}

class AStack<E> implements Stack<E> {
    private Object[] stack = new Object[10];
    private int top;

    private class StackIterator<E> implements Iterator<E> {
        private int curr = top;
        public boolean hasNext() {
            return curr > 0;
        }
        public E next() {
            return (E)stack[--curr];
        }
    }

    public Iterator<E> iterator() {
        return new StackIterator<E>();
    }

    private void grow() {
        Object[] temp = new Object[stack.length * 2];
        System.arraycopy(stack, 0, temp, 0, stack.length);
        stack = temp;
    }

    private void shrink() {
        Object[] temp = new Object[stack.length / 2];
        System.arraycopy(stack, 0, temp, 0, temp.length);
        stack = temp;
    }

    public void push(E data) {
        if (top >= stack.length) {
            grow();
        }

        if (top < stack.length) {
            stack[top++] = data;
        }
    }

    public E pop() {
        E temp = null;
        if (top <= stack.length / 3) {
            shrink();
        }

        if (top > 0) {
            temp = (E)stack[--top];
        }

        return temp;
    }
}

class RStack<E> implements Stack<E> {
    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node(T data) {
            this.data = data;
        }
    }

    private Node<E> head;

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public boolean hasNext() {
                return curr.next != null;
            }
            public E next() {
                return curr.next.data;
            }
            private final Node<E> curr = head;
        };
    }

    public void push(E data) {
        Node<E> temp = new Node<E>(data);
        temp.next = head;
        head = temp;
    }

    public E pop() {
        E temp = null;
        if (head != null) {
            temp = head.data;
            head = head.next;
        }

        return temp;
    }
}