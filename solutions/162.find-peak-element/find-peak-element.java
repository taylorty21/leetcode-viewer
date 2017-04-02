public class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int mid2 = mid + 1;
            if (nums[mid] < nums[mid2]) {
                low = mid2;
            } else {
                high = mid;
            }
        }
        return low;
    }
}