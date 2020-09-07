public class InsertionSort<E> {

    private InsertionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        // l和r是左闭右闭的
        for (int i = l; i <= r; i ++) {
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= l && t.compareTo(arr[j - 1]) < 0; j --) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }
}

