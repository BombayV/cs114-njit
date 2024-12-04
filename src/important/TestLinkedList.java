package important;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);

        for (Integer i : list) {
            System.out.println(i);
        }

        System.out.println("Popped: " + list.pop().data);
        System.out.println("Popped: " + list.pop().data);

        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
