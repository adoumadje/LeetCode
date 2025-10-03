package com.leetcode.dynamic_programming.medium;

public class LeetCode1690 {
    int[] dp;
    Integer[][] mem;

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        dp = new int[n+1];
        mem = new Integer[n+1][n+1];
        dp[0] = stones[0];
        for(int i= 1; i <= n; ++i) {
            dp[i] = stones[i-1] + dp[i-1];
        }
        return dfs(1, n);
    }

    private int dfs(int i, int j) {
        if(i==j) return 0;
        if(mem[i][j] != null) return mem[i][j];
        return mem[i][j] = Math.max((dp[j] - dp[i]) - dfs(i+1, j),
                (dp[j-1] - dp[i-1]) - dfs(i, j-1));
    }
}
