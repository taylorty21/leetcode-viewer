class Solution {
    // Induction Rule: dp[i] = true if [0, i - j] is true and [i - j, i] in dict. j (0, i)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String str: wordDict) {
            dict.add(str);
        }
        // State: dp[i] true
        boolean[] dp = new boolean[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            // if the word is in the dict, done
            if (dict.contains(s.substring(0, i))) {
                dp[i] = true;
                continue;
            }
            for (int j = 1; j < i; j++) {
                // check subproblem and check the rest of the word
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}