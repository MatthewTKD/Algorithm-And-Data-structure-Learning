import java.util.Random;

// 非递归实现, 改变循环不变量
class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        Random random = new Random();
        return selectK(nums, nums.length - k, random);
    }

    private int selectK(int[] nums, int k, Random random) {
        int l = 0, r = nums.length;

        // nums[l, r)中寻找k
        while (l < r) {
            int mid = partition(nums, l, r, random);
            if (mid == k) {
                return nums[mid];
            }
            if (mid < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        throw new RuntimeException("No solution");
    }

    private int partition(int[] nums, int l, int r, Random random) {
        int p = l + random.nextInt(r - l);
        swap(nums, l, p);
        // nums[l + 1, i - 1] <= v, nums[j + 1, r) > v
        int i = l + 1, j = r - 1;
        while (true) {
            while (i <= j && nums[i] < nums[l]) {
                i++;
            }
            while (j >= i && nums[j] > nums[l]) {
                j--;
            }

            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}