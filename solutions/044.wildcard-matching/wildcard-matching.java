class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false; 
        int pLen = p.length(), sLen = s.length();
        boolean[][] dp = new boolean [pLen + 1][sLen + 1];
        dp[0][0] = true;
        // * is not the first element
        for (int i = 0; i < pLen; i++) {
            if (p.charAt(i) == '*') dp[i + 1][0] = dp[i][0];
        }
        for (int i = 0; i < pLen; i++) {
            for (int j = 0; j < sLen; j++) {
                if (s.charAt(j) == p.charAt(i)) dp[i + 1][j + 1] = dp[i][j]; // From its upper-left element
                if (p.charAt(i) == '?') dp[i + 1][j + 1] = dp[i][j]; // From its upper-left element
                if (p.charAt(i) == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j]; 
                    // Case 1: From its upper element (* is an empty string)
                    // Case 2: From its left element (same row), if * match any sequence
                    // if abc match ab* then so does abcd
                }
            }
        }
        return dp[pLen][sLen];
    }
}