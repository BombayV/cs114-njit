package midterm;

public class Midterm2012 {
    public static int ackermann(int m, int n) {
        if (m == 0) {
            return n + 1;
        }
        if (m > 0 && n == 0) {
            return ackermann(m - 1, 1);
        }

        return ackermann(m - 1, ackermann(m, n - 1));
    }

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        return isPalindrome(str.substring(1, str.length() - 1));
    }

//    public static Node<E> reverse(Node<E> curr, Node<E> prev) {
//        if (curr == null) {
//            return prev;
//        }
//
//        Node<E> temp = reverse(curr.next, curr);
//        curr.next = prev;
//        return temp;
//    }
}
