class Solution {
    public int removeElement(int[] nums, int val) {
        int low = 0, high = 0;
        while (high < nums.length) {
            if (nums[high] != val) {
                nums[low] = nums[high];
                low++;
            }
            high++;
        }
        
        // for (int j = 0; j < nums.length; j++) {
        //     if (nums[j] != val) {
        //         nums[i] = nums[j];
        //         i++;
        //     }
        // }
        // return i;
        return low;
    }
    
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}