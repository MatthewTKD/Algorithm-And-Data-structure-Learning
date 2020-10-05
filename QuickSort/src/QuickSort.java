import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r, random);
        sort(arr, l, p - 1, random);
        sort(arr, p + 1, r, random);
    }

//    public static <E extends Comparable<E>> void sort2(E[] arr) {
//        sort2(arr, 0, arr.length - 1);
//    }

    // 使用InsertionSort进行"优化"
//    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
//        if (r - l <= 15) {
//            InsertionSort.sort(arr, l, r);
//            return;
//        }
//        int p = partition(arr, l, r);
//        sort2(arr, l , p - 1);
//        sort2(arr, p + 1, r);
//    }

    public static <E extends Comparable<E>> void sort2twoWay(E[] arr) {
        Random random = new Random();
        sort2twoWay(arr, 0, arr.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort2twoWay(E[] arr, int l, int r,
                                                              Random random) {
        if (l >= r) {
            return;
        }
        int p = partition2(arr, l, r, random);
        sort2twoWay(arr, l, p - 1, random);
        sort2twoWay(arr, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r,
                                                            Random random) {
        // 生成[l, r]之间的随机索引
        int p = l + random.nextInt(r - l + 1);

        swap(arr, l, p);

        // arr[l+1...i-1] <= v, arr[j + 1...r] >= v
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[l].compareTo(arr[i]) > 0 ) {
                i ++;
            }
            while (j >= i && arr[l].compareTo(arr[j]) < 0) {
                j ++;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i ++;
            j ++;
        }

        swap(arr, l , j);
        return j;
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random random) {
        // 生成[l, r]之间的随机索引
        int p = l + random.nextInt(r - l + 1);
        swap(arr, l, p);

        int j = l;

        // arr[l + 1, j] < v , arr[j + 1, i] > v
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateOrderedArray(n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
//        Integer[] arr3 = ArrayGenerator.generateSpecialArray(n);
//        Integer[] arr4 = Arrays.copyOf(arr3, arr3.length);

//        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2", arr2);
    }
}

