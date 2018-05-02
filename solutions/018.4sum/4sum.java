class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break; //first candidate too large, search finished
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) continue; //first candidate too small
            if (i > 0 && nums[i] == nums[i - 1]) continue; //prevents duplicate results in res list
            // if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break; //second candidate too large
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) continue; //second candidate too small
                if (j == i + 1 || nums[j] != nums[j - 1]) { //prevents duplicate results in res list
                    int low = j + 1, high = nums.length - 1;
                    while (low < high) {
                        if (nums[i] + nums[j] + nums[low] + nums[high] == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                            while (low < high && nums[low] == nums[low + 1]) low++; //skipping over duplicate on low
                            while (low < high && nums[high] == nums[high - 1]) high--;
                            low++;
                            high--;
                        } else if (nums[i] + nums[j] + nums[low] + nums[high] < target) {
                            low++;
                        } else {
                            high--;
                        }
                    }
                }
            }
        }
        return res;
    }
}