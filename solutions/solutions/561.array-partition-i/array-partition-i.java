class Solution {
    // O(nlogn)
    public int arrayPairSum2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
    // O(n)
    public int arrayPairSum(int[] nums) {
        int kMaxValue = 10000;
        int[] arr = new int[2 * kMaxValue + 1];
        for (int num: nums) arr[num + kMaxValue]++;
        
        int res = 0;
        int n = -kMaxValue;
        boolean first = true;

        while (n < kMaxValue) {
            if (arr[n + kMaxValue] == 0) {
                n++;
                continue;
            }
            if (first) {
                res += n;
                first = false;
            } else {
                // skip the element
                first = true;
            }
            arr[n + kMaxValue]--;
        }
        return res;
    }
}