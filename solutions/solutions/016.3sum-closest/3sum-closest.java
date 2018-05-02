class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int curr = nums[i] + nums[low] + nums[high];
                int diff = Math.abs(curr - target);
                if (diff < min) {
                    min = diff;
                    closest = curr;
                }
                if (curr < target) {
                    low++;
                } else if (curr > target) {
                    high--;
                } else {
                    return target;
                }
            }
        }
        return closest;
    }
}