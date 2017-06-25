public class Solution {
    public void nextPermutation(int[] nums) {
        int k = Integer.MIN_VALUE;
        // Find the largest index k such that nums[k] < nums[k + 1]
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }
        // array is in descending order
        if (k == Integer.MIN_VALUE) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // Find the largest index l greater than k such that nums[k] < nums[l].
        int l = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i > k; i--) {
            if (nums[k] < nums[i]) {
                l = i;
                break;
            }
        }
        swap(nums, k, l);
        reverse(nums, k + 1, nums.length - 1);
    }
    
    public void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public void reverse(int[] num, int start, int end) {   
        if (start > end)
            return;
        for (int i = start; i <= (end + start) / 2; i++)
            swap(num, i, start + end - i);
    }
}