public class LinearSearch<E> {

    private LinearSearch() {}

    // 线性查找，放回所在索引
    public static <E> int search(E[] arr, E target){
        for (int i = 0;i < arr.length; i ++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }
}
