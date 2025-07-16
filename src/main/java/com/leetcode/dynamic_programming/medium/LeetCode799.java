package com.leetcode.dynamic_programming.medium;

public class LeetCode799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        int n = query_row + 1;
        double[][] dp = new double[n][n];
        dp[0][0] = poured;

        for(int i = 0; i < query_row; ++i) {
            for(int j = 0; j <= i; ++j) {
                double excess = Math.max(0, (dp[i][j] - 1) / 2);
                dp[i+1][j] += excess;
                dp[i+1][j+1] += excess;
            }
        }

        return Math.min(1, dp[query_row][query_glass]);
    }
}
