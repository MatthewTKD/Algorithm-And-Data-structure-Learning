import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Random random = new Random();
        return findKthLargest(nums, k, 0, nums.length - 1, random);
    }

    private int findKthLargest(int[] nums, int k, int l, int r, Random random) {
    }

    private int partition(int[] nums, int l, int r) {
        
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}