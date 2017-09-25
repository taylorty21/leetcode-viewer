class Solution {
    public List<String> removeInvalidParentheses2(String s) {
        // Use hashSet to avoid duplicate
        Set<String> res = new HashSet<>();
        int removeLeft = 0, removeRight = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') removeLeft++;
            else if (s.charAt(i) == ')') {
                if (removeLeft > 0) removeLeft--;
                else removeRight++;
            }
        }
        StringBuilder solution = new StringBuilder();
        dfs(s, res, removeLeft, removeRight, 0, 0, solution);
        return new ArrayList<String>(res);
    }
    // open: number of open Parentheses
    public void dfs(String s, Set<String> res, int removeLeft, int removeRight, int open, int currPos, StringBuilder solution) {
        if (removeLeft < 0 || removeRight < 0 || open < 0) {
            return;
        }
        if (s.length() == currPos) {
            if (open == 0 && removeLeft == 0 && removeRight == 0) {
                res.add(solution.toString());
            }
            return;
        }
        char c = s.charAt(currPos); 
        int len = solution.length();
        if (c == '(') {
            dfs(s, res, removeLeft - 1, removeRight, open, currPos + 1, solution); // not use (
            dfs(s, res, removeLeft, removeRight, open + 1, currPos + 1, solution.append(c)); // use (
        } else if (c == ')') {
            dfs(s, res, removeLeft, removeRight - 1, open, currPos + 1, solution); // not use )
            dfs(s, res, removeLeft, removeRight, open - 1, currPos + 1, solution.append(c)); // use )
        } else {
            dfs(s, res, removeLeft, removeRight, open, currPos + 1, solution.append(c));
        }
        solution.setLength(len);
    }
    
    // https://discuss.leetcode.com/topic/34875/easy-short-concise-and-fast-java-dfs-3-ms-solution?page=1
    public List<String> removeInvalidParentheses3(String s) {
        List<String>  res = new ArrayList<>();
        remove(s, res, 0, 0, new char[]{'(', ')'});
        return res;
    }
    
    private void remove(String s, List<String> res, int lastI, int lastJ, char[] pairs){
        int stack = 0;
        for (int i = lastI; i < s.length(); i++){
            if (s.charAt(i) == pairs[0]) stack++;
            if (s.charAt(i) == pairs[1]) stack--;
            if (stack >= 0) continue;
            for (int j = lastJ; j < s.length();j++){
                if (s.charAt(j) == pairs[1] && (j == 0 || s.charAt(j-1) != pairs[1]))
                   remove(s.substring(0, j) + s.substring(j+1), res, i, j, pairs); 
            }
            return;
        }
        s = new StringBuilder(s).reverse().toString();
        if (pairs[0] == '('){
            remove(s, res, 0, 0, new char[]{')', '('});
        } else {
            res.add(s);
        }
    }
    
    // BFS
    public List<String> removeInvalidParentheses(String s) {
        Deque<String> queue = new LinkedList<>();
        Set<String> hs = new HashSet<>();
        queue.push(s);
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            String curr = queue.peekFirst();
            queue.pollFirst();
            if (hs.contains(curr)) continue;
            hs.add(curr);
            if (isValid(curr)) res.add(curr);
            else if (res.isEmpty())
                for (int i = 0; i < curr.length(); i++)
                    if (curr.charAt(i) == ')' || curr.charAt(i) == '(')
                        queue.offerLast(curr.substring(0, i) + curr.substring(i + 1));
        }
        return res;
    }

    public static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') ++count;
            if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }
    
    // BFS without Set https://discuss.leetcode.com/topic/28855/java-bfs-solution-16ms-avoid-generating-duplicate-strings
}