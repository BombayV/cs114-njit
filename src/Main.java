import after.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i = 0; i < 10; i++) {
            tree.insert(i);
        }

        System.out.println("Tree:");
        for (Integer i : tree) {
            System.out.println(i);
        }

        System.out.println("Removing 5:");
        tree.remove(5);
        for (Integer i : tree) {
            System.out.println(i);
        }
    }
}