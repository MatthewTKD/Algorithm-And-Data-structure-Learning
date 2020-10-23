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

    // 查找 > target的最小值
    public static <E extends Comparable<E>> int upper(E[] arr, E target) {
        int l = 0, r = arr.length;
        // 在arr[l, r]中查找target
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) <= 0 ) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for(int i = 0; i <= 6; i ++)
            System.out.print(BinarySearch.upper(arr, i) + " ");
        System.out.println();
    }
}
