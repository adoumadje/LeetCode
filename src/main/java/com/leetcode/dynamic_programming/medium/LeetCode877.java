package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LeetCode877 {
    int[] piles;
    Integer[][] dp;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        this.piles = piles;
        int total = Arrays.stream(piles).sum();
        dp = new Integer[n][n];
        return dfs(0, n-1) > 0;
    }

    public int dfs(int i, int j) {
        if(i == j) return piles[i];
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        int res = Math.max(
                piles[i] - dfs(i+1, j),
                piles[j] - dfs(i, j-1)
        );
        return dp[i][j] = res;
    }
}
