class Solution {
    public void moveZeroes(int[] nums) {
        int num = 0;
        int low = 0, high = 0;
        while (high < nums.length) {
            if (nums[high] != 0) {
                nums[low] = nums[high];
                low++;
            } else {
                num++;
            }
            high++;
        }
        while (num > 0) {
            nums[num + low - 1] = 0;
            num--;
        }
    }
}