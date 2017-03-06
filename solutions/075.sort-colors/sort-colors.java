public class Solution {
    public void sortColors(int[] nums) {
        int one = 0, two = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 2 && i < two) {
                swap(nums, i, two);
                two--;
            }
            while (nums[i] == 0 && i > one) {
                swap(nums, i, one);
                one++;
            }

        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}