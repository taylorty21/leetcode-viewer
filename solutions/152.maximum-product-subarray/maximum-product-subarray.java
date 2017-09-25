class Solution {
    // Loop through the array, each time remember the max and min value for the previous product
    // the most important thing is to update the max and min value: 
    // we have to compare among max * A[i], min * A[i] as well as A[i], since this is product, a negative * negative could be positive.
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int localMin = nums[0];
        int localMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = localMax;
            localMax = Math.max(nums[i], Math.max(localMax * nums[i], localMin * nums[i]));
            localMin = Math.min(nums[i], Math.min(temp * nums[i], localMin * nums[i]));
            
            if (localMax > globalMax) globalMax = localMax;
        }
        return globalMax;
    }
}