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
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) { // l and r are two seperate elements side by side, useful when there are only two elements
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[l] < nums[mid]) {
                if (target < nums[mid] && target >= nums[l]) { // nums[l] <= target < nums[mid], move r to the left
                    r = mid;
                } else {
                    l = mid;
                }
            } else { // nums[l] >= nums[mid]
                if (target > nums[mid] && target <= nums[r]) { // nums[mid] < target <= nums[r], move l to the right
                    l = mid;
                } else {
                    r = mid ;
                }
            }
            
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }
    
    public int search2(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return A[lo] == target ? lo : -1;
    }
}