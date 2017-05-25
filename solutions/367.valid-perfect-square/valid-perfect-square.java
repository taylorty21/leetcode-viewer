public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0 ) {
            return false;
        }
        int high = num, low = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid < num / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}