class Solution {
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int low = 0, high = 0;
        while (high < nums.length) {
            if (high == 0 || nums[high] != nums[high - 1]) {
                nums[low] = nums[high];
                low++;
            }
            high++;
        }
        return low;
    }
    
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}