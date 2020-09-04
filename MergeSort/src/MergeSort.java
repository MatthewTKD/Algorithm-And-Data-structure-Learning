import javax.xml.stream.XMLInputFactory;
import java.util.Arrays;

public class MergeSort {
    private MergeSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {

    }

    // 合并两个有序的区间 arr[l, mid] 和 arr[mid + 1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1); // copyOfRange是左闭右开的

        int i = l, j = mid + 1;

        for (int k = l; k <= r; k ++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j ++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i ++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                    arr[k] = temp[i - l];
                    i ++;
            }else {
                arr[k] = temp[j - l];
                j ++;
            }
        }
    }
}
