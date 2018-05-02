class Solution {
    // remove 0 to length parenthesis and check if they are valid 
    // Time: O(2^(l+r))
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') l++;
            if (l == 0) {
                if (ch == ')') r++;
            } else {
                if (ch == ')') l--;
            }
        }
        dfs(s, 0, l, r, res);
        return res;
    }
    
    private boolean isValid(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') count++;
            if (string.charAt(i) == ')') count--;   
            if (count < 0) return false;
        }
        return count == 0;
    }
    
    private void dfs(String s, int index, int l, int r, List<String> res) {
        if (l == 0 && r == 0) {
            if (isValid(s)) res.add(s);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            // We only remove the first parenthes if there are consecutive ones to avoid duplications.
            char sChar = s.charAt(i);
            if (i != index && sChar == s.charAt(i - 1)) continue;
            
            if (sChar == '(' || sChar == ')') {
                String curr = s.substring(0, i) + s.substring(i + 1);
                if (r > 0 && sChar == ')') 
                    dfs(curr, i, l, r - 1, res);
                else if (l > 0 && sChar == '(')
                    dfs(curr, i, l - 1, r, res);
            }
        }
    }
}