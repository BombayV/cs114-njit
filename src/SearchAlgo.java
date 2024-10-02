public class SearchAlgo {
    public static <T extends Comparable<? super T>> int bsearch(T n, T[] arr) {
        return bsearch(n, arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<? super T>> int bsearch(T n, T[] arr, int l, int r) {
        if (l <= r) {
            int mid = (l+r) / 2;
            int compareR = n.compareTo(arr[mid]);
            if (compareR == 0) return mid;
            else if (compareR < 0) return bsearch(n, arr, l, mid - 1);
            else return bsearch(n, arr, mid + 1, r);
        }

        return -1;
    }

    public static  <T extends Comparable<? super T>> int ssearch(T key, T[] arr) {
        return ssearch(key, arr, 0);
    }

    private static  <T extends Comparable<? super T>> int ssearch(T key, T[] arr, int idx) {
        if (idx < arr.length) {
            if (key.compareTo(arr[idx]) == 0) {
                return idx;
            }

            return ssearch(key, arr, idx + 1);
        }

        return -1;
    }
}
