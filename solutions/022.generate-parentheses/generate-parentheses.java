class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // if (digits.length() == 0) return res;
        dfs(n, res, 0, 0, new StringBuilder());
        return res;
    }

    public void dfs(int n, List<String> res, int open, int close, StringBuilder level) {
        if (level.length() == n * 2){
            res.add(level.toString());
            return;
        }
        
        if (open < n) {
            level.append("(");
            dfs(n, res, open + 1, close, level);
            level.deleteCharAt(level.length() - 1);
            // backtrack(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            level.append(")");
            dfs(n, res, open, close + 1, level);
            level.deleteCharAt(level.length() - 1);
            // backtrack(list, str + ")", open, close + 1, max);
        }
    }
}