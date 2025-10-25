package com.leetcode.dynamic_programming.medium;

public class LeetCode2266 {
    public int countTexts(String pressedKeys) {
        int[] limit = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        char[] sa = pressedKeys.toCharArray();
        int n = sa.length;
        long[] dp = new long[n+1];
        long MOD = (long) (1e9 + 7);
        dp[n] = 1;
        for(int i = n-1; i >= 0; --i) {
            int p = sa[i] - '0';
            int r = 0;
            while(r < limit[p] && i+r < n && sa[i] == sa[i+r]) {
                dp[i] += dp[i+r+1];
                dp[i] %= MOD;
                ++r;
            }
        }
        return (int) (dp[0] % MOD);
    }
}
