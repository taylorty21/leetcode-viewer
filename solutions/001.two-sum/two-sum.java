public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int[] result = new int[2];
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hm.containsKey(diff)) {
                return new int[]{hm.get(diff), i};
            }
            hm.put(nums[i], i);
        }
        return new int[]{};
    }
}