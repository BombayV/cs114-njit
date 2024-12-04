/*
 *
 *  BinarySearchTree.java
 *
 */

import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {

    public void insert(E data) {
        root = insert(root, data);
    }

    private Node<E> insert(Node<E> current, E data) {
        if (current == null) return new Node<E>(data);

        int comparison = data.compareTo(current.data);
        if (comparison < 0) current.left = insert(current.left, data);
        else if (comparison > 0) current.right = insert(current.right, data);

        return current;
    }

    public void remove(E data) {
        root = remove(root, data);
    }

    private Node<E> remove(Node<E> current, E data) {
        if (current == null) return null;

        int comparison = data.compareTo(current.data);
        if (comparison < 0) current.left = remove(current.left, data);
        else if (comparison > 0) current.right = remove(current.right, data);
        else {
            if (current.left == null) return current.right;
            else if (current.right == null) return current.left;
            else {
                Node<E> min = current.right;
                while (min.left != null) {
                    min = min.left;
                }

                current.data = min.data;
                current.right = remove(current.right, min.data);
            }
        }

        return current;
    }

    public boolean search(E data) {
        return search(root, data) != null;
    }

    private Node<E> search(Node<E> current, E data) {
        if (current == null) return null;

        int comparison = data.compareTo(current.data);
        if (comparison == 0) return current;
        else if (comparison < 0) return search(current.left, data);
        else return search(current.right, data);
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = root;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                while (current != null) {
                    if (current.left == null) {
                        E data = current.data;
                        current = current.right;
                        return data;
                    } else {
                        Node<E> previous = current.left;
                        while (previous.right != null && previous.right != current) {
                            previous = previous.right;
                        }

                        if (previous.right == null) {
                            previous.right = current;
                            current = current.left;
                        } else {
                            previous.right = null;
                            E data = current.data;
                            current = current.right;
                            return data;
                        }
                    }
                }

                return null;
            }
        };
    }
}