class Solution {
    // Time: O(2^n * k) k is the average length of the combination
    // Space: O(n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, target, 0, res, new ArrayList<>());
        return res;
    }
    
    public void dfs(int[] candidates, int target, int pos, List<List<Integer>> res, List<Integer> currSeq) {
        if (target == 0) {
            res.add(new ArrayList(currSeq));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (i > pos && candidates[i] == candidates[i - 1]) continue; // Avoid duplicate
            // if (i > 0 && candidates[i] == candidates[i - 1] && i != pos) continue;
            if (candidates[i] > target) break;
            currSeq.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, res, currSeq);
            currSeq.remove(currSeq.size() - 1);
        }
    }
}