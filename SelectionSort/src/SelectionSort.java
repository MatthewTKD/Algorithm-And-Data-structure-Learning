public class SelectionSort<E> {

    private SelectionSort() {
    }

    // 升序
    public static <E extends Comparable<E>> void sort(E[] arr) {

        // arr[0..i]有序, arr[i...n]无序
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    // 从最后一个元素开始排序, 升序
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        // arr[i..arr.length]有序, arr[0...i]无序
        for (int i = arr.length - 1; i >= 0; i --) {
            int maxIndex = i;
            for (int j = i; j >=0; j --) {
                if (arr[maxIndex].compareTo(arr[j]) < 0) {
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        Integer[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort.sort2(arr);
        for (int e : arr)
            System.out.print(e + " ");
        System.out.println();

    }
}




