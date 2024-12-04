package important;

public abstract class IStack<T> implements Iterable<T> {

    public static class Node<T> {

        protected Node(T data) {
            this.data = data;
        }

        protected T data;
        protected Node<T> next;
    }

    public abstract Node<T> push(T data);
    public abstract Node<T> pop();

    protected Node<T> head;
}