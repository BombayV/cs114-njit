public class RecursionExamples {
    public static void main(String[] args) {
        //        System.out.println("Factorial 5" + RecursionExamples.factorial(5));
        Integer[] a = {12, 23, 34, 45, 56, 67, 78, 89, 90};
//        System.out.println("Bsearch f " + SearchAlgo.bsearch(45, a));
//        System.out.println("Bsearch nf " + SearchAlgo.bsearch(46, a));
//        System.out.println("Reverse " + RecursionExamples.backwardsStr("redivider"));
//        System.out.println("SSearch f " + SearchAlgo.ssearch(45, a));
//        System.out.println("Fibonacci " + RecursionExamples.fibonacci(9));
//        System.out.println("Choose " + RecursionExamples.choose(4, 2));
//        System.out.println("Choose 2 " + RecursionExamples.choose(52, 2));
//        RecursionExamples.tower(2, 'A', 'C', 'B');
        long tick, tock;

        tick = System.nanoTime();
        System.out.println(powi(2, 100000000));
        tock = System.nanoTime();
        System.out.println(tock - tick);

        tick = System.nanoTime();
        System.out.println(powr(2, 100000000));
        tock = System.nanoTime();
        System.out.println(tock - tick);

        tick = System.nanoTime();
        System.out.println(Math.pow(2, 100000000));
        tock = System.nanoTime();
        System.out.println(tock - tick);
    }

    public static int factorial(int n) {
        if (n <= 0) return 1;

        return n * factorial(n - 1);
    }

    public static String backwardsStr(String str) {
        if (str.length() <= 1) return str;
        return str.charAt(str.length() - 1) + backwardsStr(str.substring(0, str.length() - 1));
    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int choose(int n, int k) {
        if (k > n) return 0;
        if (k == 0) return 1;
        if (k == n) return 1;

        return choose(n - 1, k - 1) + choose(n -1 , k);
    }

    public static void tower(int n, char src, char dst, char use) {
        if (n > 0) {
            tower(n-1, src, use, dst);
            System.out.println("Moved disk " + n + " from " + src + " to " + dst);
            tower(n-1,  use, dst, src);
        }
    }

    public static int powi(int x, int n) {
        int prod = 1;
        while (n-- > 0) {
            prod *= x;
        }

        return prod;
    }
    public static int powr(int x, int n) {
        if (n == 0) return 1;

        if (n % 2 == 0) {
            return powr(x*x, n/2);
        }

        return x * powr(x*x, n/2);
    }
}
