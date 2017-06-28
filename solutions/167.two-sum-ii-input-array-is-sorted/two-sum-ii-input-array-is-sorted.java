public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Method 1: two pointers
        int[] res = new int[2];
        int p1 = 0, p2 = nums.length - 1;
        while (p1 < p2) {
            if (nums[p1] + nums[p2] == target) {
                res[0] = p1 + 1;
                res[1] = p2 + 1;
                return res;
            } else if (nums[p1] + nums[p2] < target) {
                p1++;
            } else {
                p2--;
            }
        }
        return res;
    }
    
    // Method 2: binary search O(nlgn)
    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = Arrays.binarySearch(nums, i + 1, n, target - nums[i]);
            if (j >= 0) {
                return new int[]{ i + 1, j + 1 };
            }
        }
        return new int[]{ -1, -1 };
    }

}