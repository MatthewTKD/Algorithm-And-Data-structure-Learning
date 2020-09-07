import java.util.Arrays;

public class MergeSort {
    private MergeSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;  // 本来可以写成(l + r) / 2 , 但(l + r)可能造成整型溢出
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    // 优化merge的执行次数
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        sort2(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;  // 本来可以写成(l + r) / 2 , 但(l + r)可能造成整型溢出
        sort2(arr, l, mid);
        sort2(arr, mid + 1, r);

        // 优化optimization
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    // 合并两个有序的区间 arr[l, mid] 和 arr[mid + 1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1); // copyOfRange是左闭右开的

        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args){

        int n = 1000000;

        System.out.println("Random Array : ");
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("MergeSort2", arr2);


        System.out.println("\nOrdered Array : ");
        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("MergeSort2", arr2);
    }
}
