class Solution {
    // base case
    // dp[n]  = 1;
    // dp[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
    // induction rule
    // substring > 26 dp[i + 1]
    // substring <= 26 dp[i + 1] + dp[i + 2]
    public int numDecodings2(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n-1] = s.charAt(n-1) != '0' ? 1 : 0; // 0 -> 0, (1, 2) -> 1
        
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            else dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];
        }
        return dp[0];
    }
    
    public int numDecodings3(String s) {
        int len = s.length();
		char[] str = s.toCharArray();
		if (len == 0 || s.startsWith("0")) return 0;
		int[] dp = new int[len + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 1; i < len; i++) {
			dp[i + 1] = str[i] == '0' ? 0 : dp[i];
			int num = 10 * (str[i - 1] - '0') + str[i] - '0';
			dp[i + 1] += str[i - 1] != '0' && num <= 26 && num > 0 ? dp[i - 1] : 0;
		}
		return dp[len];
    }
    
    public int numDecodings(String s) {
        int len = s.length();
		char[] str = s.toCharArray();
		if (len == 0 || s.startsWith("0")) return 0;
		int[] dp = new int[len + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 1; i < len; i++) {
            if (str[i] == '0') {
                if (str[i - 1] >= '3' || str[i - 1] == '0') return 0; // 00, 30, 40...
                dp[i + 1] = dp[i - 1];
            } else {
                int num = 10 * (str[i - 1] - '0') + str[i] - '0';
                // if (str[i - 1] != '0' && (num <= 26 && num >= 21 || num >= 11 && num <= 19)) { // 11 - 19, 21 - 26
                //     dp[i + 1] = dp[i] + dp[i - 1];
                // } else { // 01 - 09, 27 - 99
                //     dp[i + 1] = dp[i];
                // }
                if (str[i - 1] == '0' || (num > 26)) { // 01 - 09, 27 - 99
                    dp[i + 1] = dp[i];
                } else { // 11 - 19, 21 - 26
                    dp[i + 1] = dp[i] + dp[i - 1];
                }
            }
		}
		return dp[len];
    }
    
    public int numDecodingsConstantSpace(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int num1 = 1;
        int num2 = 1;
        int num3 = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')
                    num3 = num1;
                else
                    return 0;
            } else {
                if (s.charAt(i - 1) == '0' || s.charAt(i - 1) >= '3')
                    num3 = num2;
                else {
                    if (s.charAt(i - 1) == '2' && s.charAt(i) >= '7' && s.charAt(i) <= '9')
                        num3 = num2;
                    else
                        num3 = num1 + num2;
                }
            }
            num1 = num2;
            num2 = num3;
        }
        return num2;
    }
}