class Solution {
    int result = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        dfs(nums, S, 0, 0);
        return result;
    }
    
    public void dfs(int[] nums, int S, int currPos, int val) {
        if (nums.length == currPos) {
            if (val == S) result++;
            return;
        }
        dfs(nums, S, currPos + 1, val + nums[currPos]);
        dfs(nums, S, currPos + 1, val - nums[currPos]);
    }
}