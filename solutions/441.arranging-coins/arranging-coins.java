public class Solution {
    public int arrangeCoins(int n) {
        // Convert int to long to prevent integer overflow
        long nLong = (long) n;
        long low = 0, high = nLong;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * (mid + 1) / 2 <= nLong) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) low - 1;
    }
}