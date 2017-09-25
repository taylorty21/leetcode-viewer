class Solution {
    // 0 1 2 4 5 6 7  left < mid < right       go to the left
    // 1 2 4 5 6 7 0  left < mid, mid > right  to the right
    // 2 4 5 6 7 0 1  left < mid, mid > right
    // 4 5 6 7 0 1 2  left < mid, mid > right
    // 5 6 7 0 1 2 4  left > mid, mid < right  to the left
    // 6 7 0 1 2 4 5  left > mid, mid < right
    // 7 0 1 2 4 5 6  left > mid, mid < right
    // mid > right  to the right
    // mid < right  non-right
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) { // to the right
                l = mid + 1;
            } else { //  to the left
                r = mid;
            }
        }
        return nums[l];
    }
    
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left<right && nums[left]>nums[right]) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[left]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}