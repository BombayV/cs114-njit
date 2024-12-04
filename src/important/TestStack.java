package important;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        for (Integer i : stack) {
            System.out.println(i);
        }

        stack.pop();
        stack.pop();

        for (Integer i : stack) {
            System.out.println(i);
        }
    }
}
