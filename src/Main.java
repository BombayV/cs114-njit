import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SortedList<Integer> list = new SortedList<Integer>();
        Random random = new Random();
        list.retrieve(-1);
        for (int i = 0; i < 11; i++) {
            int data = random.nextInt(10);
            list.insert(data);
            System.out.print("idx: " + i + " - ");
            for (Integer value : list)
                System.out.print(value + " ");
            System.out.println();
        }

        System.out.println("Search for 1: " + list.search(9));
        System.out.println("Retrieve for 0: " + list.retrieve(3));
        while (list.head != null) {
            int data = list.retrieve(0);
            System.out.print("removing " + data + " - ");
            list.remove(data);
            for (Integer value : list)
                System.out.print(value + " ");
            System.out.println();
        }
    }
}