package com.leetcode.dynamic_programming.medium;

public class LeetCode3409 {
    public int longestSubsequence(int[] nums) {
        int n = nums.length, m = 300;
        int[][] dp = new int[m+1][m+1];
        int res = 0;
        for (int x : nums) {
            for (int j = 0; j <= m; ++j) {
                if (x + j <= m)
                    dp[x][j] = Math.max(dp[x][j], 1 + dp[x + j][j]);
                if (x - j >= 0)
                    dp[x][j] = Math.max(dp[x][j], 1 + dp[x - j][j]);
            }
            int curr = 0;
            for (int j = m; j >= 0; --j) {
                curr = Math.max(curr, dp[x][j]);
                dp[x][j] = curr;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
