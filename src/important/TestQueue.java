package important;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        for (Integer i : queue) {
            System.out.println(i);
        }

        queue.pop();
        queue.pop();

        for (Integer i : queue) {
            System.out.println(i);
        }
    }
}
