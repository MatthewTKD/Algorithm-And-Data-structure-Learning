class Solution {
    public void sortColors(int[] nums) {
        // 以1作为标定点
        // nums[0, lt] == 0, nums[lt + 1, i - 1] == 1, nums[gt, nums.length - 1] == 2
        int lt = -1, i = 0, gt = nums.length;
        while (i < gt) {
            if (nums[i] < 1) {
                lt ++;
                swap(nums, lt, i);
                i ++;
            } else if (nums[i] > 1) {
                gt --;
                swap(nums, gt, i);
            } else {
                i ++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}