public class BinarySearch {
    private BinarySearch() {
    }

    public static <E extends Comparable<E>> int search(E[] arr, E target) {
        int l = 0, r = arr.length - 1;

        // 循环不变量 在arr[l, r]中查找target
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            }
            if (arr[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> int searchR(E[] arr, E target) {
        return searchR(arr, 0, arr.length - 1, target);
    }

    private static <E extends Comparable<E>> int searchR(E[] arr, int l, int r, E target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;

        if (arr[mid].compareTo(target) == 0) {
            return mid;
        }
        if (arr[mid].compareTo(target) > 0 ){
            return searchR(arr, 0, mid - 1, target);
        }

        return searchR(arr, mid + 1, r, target);
    }
}
