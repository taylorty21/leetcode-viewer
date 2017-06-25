public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, res, sol);
        return res;
    }
    
    public void subsets(int[] nums, int index, List<List<Integer>> res, List<Integer> sol) {
        if (sol.size() == 0) {
            res.add(new ArrayList<Integer>());
        } else {
            // Arraylist passed by reference
            res.add(new ArrayList<Integer>(sol));
        }
        // Maintains ascending order of the indices of picked characters
        // Choose the next picked index (the smallest one can be picked is index)
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            // add one num
            sol.add(nums[i]);
            subsets(nums, i + 1, res, sol);
            sol.remove(sol.size() - 1);
            
        }
    }
}