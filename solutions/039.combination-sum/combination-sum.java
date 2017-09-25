class Solution {
    // I和II不同的是，I数组里没有重复的数，但一个数可以用多次；II数组里有重复，一个数只能用一次。
    // I和II都要求返回结果中没有重复的解，且每个解中的数都按非递减排好序 
    // Reason for sorting: the answer should be monotonically increasing, 而且对于II，排序后方便判断回溯的结果是否已经存在
    // 注意第24行代码，当加入candidates[i]后，下一次还是从i开始，因为一个数可以用多次
    // Time: O(2^n * k) k is the average length of the combination
    // Space: O(n)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (candidates[i] > target) break;
            currSeq.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, res, currSeq); // i here, not i + 1
            currSeq.remove(currSeq.size() - 1);
        }
    }
}