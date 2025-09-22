package com.leetcode.dynamic_programming.medium.leetcode1621;

public class LeetCode1621BruteForce {
    public int numberOfSets(int n, int k) {
        long[][] dp = new long[k+1][n];
        long MOD = (long) (1e9 + 7);
        for(int i = 0; i < n; ++i) dp[0][i] = 1;
        for(int nn = 1; nn < n; ++nn) {
            for(int kk = 1; kk <= k; ++kk) {
                for(int i = 1; i <= nn; ++i) {
                    dp[kk][nn] += dp[kk-1][nn-i];
                }
                dp[kk][nn] += dp[kk][nn-1];
                dp[kk][nn] %= MOD;
            }
        }
        return (int) (dp[k][n-1] % MOD);
    }
}
