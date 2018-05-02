class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0, min = prices[0];
        for (int num: prices) {
            if (num < min) min = num;
            int diff = num - min;
            if (diff > max) {
                max = diff;
            }
        }
        return max;
    }
}