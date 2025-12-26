package com.leetcode.dynamic_programming.medium.leetcode3290;

public class LeetCode3290DP {
    public long maxScore(int[] a, int[] b) {
        int m = a.length, n = b.length;
        long INF = Long.MIN_VALUE + (long) 1e10;
        long[][] dp = new long[m+1][n+1];
        for(int i = 0; i < m; ++i) dp[i][n] = INF;
        for(int i = m-1; i >= 0; --i) {
            for(int j = n-1; j >= 0; --j) {
                long accept = (long) a[i] * b[j] + dp[i+1][j+1];
                long refuse = dp[i][j+1];
                dp[i][j] = Math.max(accept, refuse);
            }
        }
        return dp[0][0];
    }
}
