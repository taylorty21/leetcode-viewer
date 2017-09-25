class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false; 
        int pLen = p.length(), sLen = s.length();
        boolean[][] dp = new boolean [pLen + 1][sLen + 1];
        dp[0][0] = true;
        // * is not the first element
        for (int i = 0; i < pLen; i++) {
            if (p.charAt(i) == '*') dp[i + 1][0] = dp[i - 1][0]; 
            // if (p.charAt(i) == '.') dp[i + 1][0] = true;
            // else {
            //     dp[i + 1][0] = false;
            //     dp[0][j + 1] = false;
            // }
        }
        for (int i = 0; i < pLen; i++) {
            for (int j = 0; j < sLen; j++) {
                if (s.charAt(j) == p.charAt(i)) dp[i + 1][j + 1] = dp[i][j]; // From its upper-left element
                if (p.charAt(i) == '.') dp[i + 1][j + 1] = dp[i][j]; // From its upper-left element
                if (p.charAt(i) == '*') {
                    
                    if (i > 0 && s.charAt(j) == p.charAt(i - 1) || p.charAt(i - 1) == '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i - 1][j + 1]; /// From same its left element
                    } else {
                        dp[i + 1][j + 1] = dp[i - 1][j + 1]; // From its upper two element on the same col, if * match 0 preceding element
                    }
                }
            }
        }
        return dp[pLen][sLen];
    }
}