public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // Calculate the maximum duration
        int res = duration * timeSeries.length;
        for (int i = 1; i < timeSeries.length; i++) {
            // Minus the duration that overlaps
            res -= Math.max(0, duration - (timeSeries[i] - timeSeries[i-1]));
        }
        return res;
    }
}