class Solution {
    // Two sum in essence
    // Corner case: k < 0, abs diff cannot be negative
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (k == 0) {
                // Count the number that appears more than twice
                if (entry.getValue() >= 2) count++;
            
            } else {
                if (map.containsKey(entry.getKey() - k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    // Two pointers
    public int findPairs2(int[] nums, int k) {
        Arrays.sort(nums);

        int start = 0, end = 1, result = 0;
        while (start < nums.length && end < nums.length) {
            if (start == end || nums[start] + k > nums[end]) {
                end++;
            } else if (nums[start] + k < nums[end]) {
                start++;
            } else {
                start++;
                result++;
                // start
                //  |
                // [1, 1, ...., 8, 8]
                //              |
                //             end
                while (start < nums.length && nums[start] == nums[start - 1]) start++;
                end = Math.max(end + 1, start + 1);
            }
        }
        return result;
    }
}