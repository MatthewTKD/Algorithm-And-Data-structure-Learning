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

    // 如果数组中存在target,返回所有相同的target中的最大索引
    // 如果在数组中不存在target, 返回upper
    // ceil[5.0] = 5 , ceil[5.5] = 6
    public static <E extends Comparable<E>> int ceil(E[] arr, E target) {
            int u = upper(arr, target);
            if (u - 1 >= 0 && arr[u - 1].compareTo(target) == 0) {
                return u - 1;
            }
            return u;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};
        for(int i = 0; i <= 6; i ++)
            System.out.print(BinarySearch.ceil(arr, i) + " ");
        System.out.println();
    }
}
