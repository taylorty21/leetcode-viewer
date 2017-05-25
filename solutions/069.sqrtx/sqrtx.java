public class Solution {
    public int mySqrt(int x) {
        // if (x == 0 || x == 1) {
        //     return x;
        // }
        long low = 0, high = x / 2 + 1;
        int res = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                low = mid + 1;
                res = (int) mid;
                // res stores the lower bound result
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}