public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<>();
        subsets(nums, 0, res, sol);
        return res;
    }
    
    public void subsets(int[] nums, int index, List<List<Integer>> res, List<Integer> sol) {
        if (index == nums.length) {
            if (sol.size() == 0) {
                res.add(new ArrayList<Integer>());
                return;
            } else {
                // Arraylist passed by reference
                res.add(new ArrayList<Integer>(sol));
                return;
            }
        }
        // add one num
        sol.add(nums[index]);
        subsets(nums, index + 1, res, sol);
        sol.remove(sol.size() - 1);
        // not add the num
        subsets(nums, index + 1, res, sol);
    }
}