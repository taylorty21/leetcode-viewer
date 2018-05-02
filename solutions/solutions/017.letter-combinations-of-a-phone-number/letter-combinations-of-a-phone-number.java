class Solution {
    // Time: O(4^n)
    // Space: O(n)
    private String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        dfs2(digits, res, 0, new char[digits.length()]);
        return res;
    }
    
    public void dfs2(String digits, List<String> res, int index, char[] level) {
        // CharArray
        if (index == digits.length()){
            res.add(new String(level));
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            level[index] = letters.charAt(i);
            dfs2(digits, res, index + 1, level);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        dfs(digits, res, 0, new StringBuilder());
        return res;
    }
    
    public void dfs(String digits, List<String> res, int index, StringBuilder level) {
        // StringBuilder
        if (index == digits.length()){
            res.add(level.toString());
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            level.append(letters.charAt(i));
            dfs(digits, res, index + 1, level);
            level.deleteCharAt(level.length() - 1);
        }
    }
    
    // BFS
    public List<String> letterCombinations3(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}