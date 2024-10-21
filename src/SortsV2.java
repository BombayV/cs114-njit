import java.util.Random;

/* Big O Notation
TYPE       |   BEST    |   AVERAGE |   WORST
Insertion  |   O(n)    |   O(n^2)  |   O(n^2)
Selection  |   O(n^2)  |   O(n^2)  |   O(n^2)
Bubble     |   O(n)    |   O(n^2)  |   O(n^2)
Merge      |   O(nlogn)|   O(nlogn)|   O(nlogn)
Quick      |   O(nlogn)|   O(nlogn)|   O(n^2)

 */
public class SortsV2 {
    public static void main(String[] args) {
        Random rand = new Random();
        Integer[] arrInt = new Integer[50_000];
        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = rand.nextInt(50_000);
        }

        long startTime = System.nanoTime();
        bubbleSort(arrInt);
        long endTime = System.nanoTime();
        System.out.println("\nBubble Sort: " + nanoToSeconds(endTime - startTime) + " seconds");

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = rand.nextInt(50_000);
        }

        startTime = System.nanoTime();
        selectionSort(arrInt);
        endTime = System.nanoTime();
        System.out.println("\nSelection Sort: " + nanoToSeconds(endTime - startTime) + " seconds");

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = rand.nextInt(50_000);
        }

        startTime = System.nanoTime();
        insertionSort(arrInt);
        endTime = System.nanoTime();
        System.out.println("\nInsertion Sort: " + nanoToSeconds(endTime - startTime) + " seconds");

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = rand.nextInt(50_000);
        }

        startTime = System.nanoTime();
        mergeSort(arrInt);
        endTime = System.nanoTime();
        System.out.println("\nMerge Sort: " + nanoToSeconds(endTime - startTime) + " seconds");

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = rand.nextInt(50_000);
        }

        startTime = System.nanoTime();
        quickSort(arrInt, 0, arrInt.length - 1);
        endTime = System.nanoTime();
        System.out.println("\nQuick Sort: " + nanoToSeconds(endTime - startTime) + " seconds");
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1].compareTo(arr[j]) > 0) {
                    swap(arr, j, j-1);
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }

    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static <T extends Comparable<? super T>> int partition(T[] arr, int left, int right) {
        T pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, right);
        return i+1;
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private static <T extends Comparable<? super T>> void merge(T[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        T[] leftArr = (T[]) new Comparable[n1];
        T[] rightArr = (T[]) new Comparable[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static double nanoToSeconds(long nano) {
        return nano / 1000000000.0;
    }
}
