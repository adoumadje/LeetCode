package com.leetcode.dynamic_programming.medium.leetcode1641;

public class LeetCode1641DP {
    public int countVowelStrings(int n) {
        int W = 5;
        int[][] dp = new int[W+1][n+1];
        for(int i = 0; i < W; ++i) {
            dp[i][1] = 1;
        }
        dp[W][1] = 5;
        for(int nn = 2; nn <= n; ++nn) {
            int rem = 0;
            int total = 0;
            for(int i = 0; i < W; ++i) {
                dp[i][nn] = dp[W][nn-1] - rem;
                rem += dp[i][nn-1];
                total += dp[i][nn];
            }
            dp[W][nn] = total;
        }
        return dp[W][n];
    }
}
