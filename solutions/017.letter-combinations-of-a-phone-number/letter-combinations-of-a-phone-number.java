class Solution {
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits == null || digits.length() == 0) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            while (ans.peek().length() == i){
                String tmp = ans.remove();
                for(char s : mapping[digits.charAt(i) - '0'].toCharArray()) {
                    ans.add(tmp + s);
                }
            }
        }
        return ans;
    }
    
    public List<String> letterCombinations3(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits == null || digits.length() == 0) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            LinkedList<String> level = new LinkedList<>();
            for (char s : mapping[digits.charAt(i) - '0'].toCharArray()) {
                for (int j = 0; j < ans.size(); j++) {
                    level.add(ans.get(j) + s);
                }
            }
            ans = level;
        }
        return ans;
    }
    
    // DFS
    String[] map = {"", "", "abc","def", "ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        int n = digits.length();
        if (n == 0) return res;
        char[] curr = new char[n];
        dfs(res, digits, 0, curr);
        return res;
    }
    void dfs(List<String> res, String s, int pos, char[] curr){
        if (pos == s.length()){ 
            res.add(new String(curr));
            return;
        }
        String dic = map[s.charAt(pos) - '0'];
        for (int i = 0; i < dic.length(); i++) {
            curr[pos] = dic.charAt(i);
            dfs(res, s, pos + 1, curr);
        }
    }
}