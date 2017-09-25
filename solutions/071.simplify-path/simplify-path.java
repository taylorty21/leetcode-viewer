class Solution {
    // Time: O(n)
    // Space: O(n)
    // Input "/a/./b/../../c/" Expect: /c
    public String simplifyPath(String path) {
        // Stack
        Deque<String> stack = new LinkedList<>();
        String[] splitArray = path.split("/"); // a, ., .., b, c, ..
        
        for (String dir : splitArray) {
            if (dir.equals("..") && !stack.isEmpty()) 
                stack.pop();
            else if (!dir.equals(".") && !dir.isEmpty() && !dir.equals(".."))  // Not . or .. or empty
                stack.push(dir);
        }
        String res = "";
        if (stack.isEmpty()) return "/";
        while (!stack.isEmpty()) {
            String newPop = stack.pop();
            res = "/" + newPop + res;
        }
        return res;
    }
    // push to the stack every valid file name (not in {"",".",".."}), popping only if there's smth to pop and we met ".."
    public String simplifyPath2(String path) {
        // Stack
        Deque<String> stack = new LinkedList<>();
        String[] splitArray = path.split("/"); // a, ., b, ..
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : splitArray) {
            if (dir.equals("..") && !stack.isEmpty()) 
                stack.pop();
            else if (!skip.contains(dir)) 
                stack.push(dir);
        }
        String res = "";
        for (String dir: stack) {
            res = "/" + dir + res;
        }
        return res.isEmpty() ? "/" : res;
    }
}