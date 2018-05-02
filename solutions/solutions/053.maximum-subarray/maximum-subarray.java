class Solution {
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] mem = new int[nums.length];
        mem[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (mem[i - 1] < 0) {
                mem[i] = nums[i];
            } else {
                mem[i] = nums[i] + mem[i - 1];
            }
            
            max = Math.max(mem[i], max); // if (mem[i] > max) max = mem[i];
        }
        return max;
    }
    
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int prev = nums[0];
        int curr = prev;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev < 0) {
                curr = nums[i];
            } else {
                curr = nums[i] + prev;
            }
            prev = curr; // update prev
            max = Math.max(curr, max);
        }
        return max;
    }
}