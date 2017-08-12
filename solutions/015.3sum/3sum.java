public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int slow = i + 1, fast = nums.length - 1;
                while (slow < fast) {
                    if (nums[slow] + nums[fast] == -nums[i]) {
                        List<Integer> lvl = new ArrayList<>();
                        res.add(Arrays.asList(nums[i], nums[slow], nums[fast]));
                        while (slow < fast && nums[slow] == nums[slow + 1]) slow++;
                        while (slow < fast && nums[fast] == nums[fast - 1]) fast--;
                        slow++;
                        fast--;
                    } else if (nums[slow] + nums[fast] < -nums[i]) {
                        slow++;
                    } else {
                        fast--;
                    }
                }
            }
        }
        return res;
    }
}