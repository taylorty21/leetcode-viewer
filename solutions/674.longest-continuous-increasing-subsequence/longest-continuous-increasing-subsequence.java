class Solution {
    public int findLengthOfLCIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 0, count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                if (maxLen < count) maxLen = count;
                count = 1;
            }
        }
        return maxLen < count? count : maxLen;
    }
    
    public int findLengthOfLCIS(int[] nums) {
        int res = 0, cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i-1] < nums[i]) {
                cnt++;
                res = Math.max(res, cnt);
            }
            else cnt = 1;
        }
        return res;
    }
}