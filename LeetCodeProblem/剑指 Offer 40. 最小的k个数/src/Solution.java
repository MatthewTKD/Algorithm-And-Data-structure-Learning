import java.util.Arrays;
import java.util.Random;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Random random = new Random();
        if (k == 0) {
            return new int[0];
        }
        selectK(arr, k - 1, 0, arr.length - 1, random);

        return Arrays.copyOf(arr, k);
    }

    private int selectK(int[] nums, int k, int l, int r, Random random) {
        int p = partition(nums, l, r, random);
        if (k == p) {
            return nums[p];
        }
        if (k < p) {
            return selectK(nums, k, l, p - 1, random);
        }

        return selectK(nums, k, p + 1, r, random);
    }

    private int partition(int[] nums, int l, int r, Random random) {
        int p = l + random.nextInt(r - l + 1);
        swap(nums, l, p);
        // nums[l + 1, i - 1] <= v, nums[j + 1, r] > v
        int i = l + 1, j = r;
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