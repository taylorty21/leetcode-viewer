class Solution {
    public void rotate(int[] nums, int k) {
        // What if k could be negative -> newK = length - k
        // 1,2,3,4,5,6,7 -> 4,3,2,1,7,6,5 -> 5,6,7,1,2,3,4
        if (nums == null || nums.length == 0) return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    public void reverse(int[] nums, int low, int high) {
        while (low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }
    
    public void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}