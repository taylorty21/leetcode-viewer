class Solution {
    // Time: O(√N). When N is the square of a prime
    public int minSteps(int n) {
        // n的质因数之和
        // By the above argument, we can suppose g_1, g_2, ... is the prime factorization of N, and the answer is therefore the sum of these prime factors.
        if (n == 1) return 0;
        int ans = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
        // 100 -> 14 = 2 + 2 + 5 + 5
        // for (int i = 2; i < n + 1; i++) {
        //     if (n % i == 0) {
        //         return i + minSteps(n / i);
        //     }
        // }
        // return 0;
    }
}