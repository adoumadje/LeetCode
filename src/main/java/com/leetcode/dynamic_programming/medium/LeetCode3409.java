package com.leetcode.dynamic_programming.medium;

public class LeetCode3409 {
    public int longestSubsequence(int[] nums) {
        int M = 300, n = nums.length;
        int[][] dp = new int[M+1][M+1];
        for(int i = 0; i <= M; ++i)
            dp[nums[0]][i] = 1;
        int res = 0;
        for(int i = 1; i < n; ++i) {
            int g = nums[i];
            for(int d = 0; d <= M; ++d) {
                int curr = 0;
                if(g-d > 0) {
                    curr = Math.max(curr, 1 + dp[g-d][d]);
                }
                if(g+d <= M) {
                    curr = Math.max(curr, 1 + dp[g+d][d]);
                }
                dp[g][d] = Math.max(dp[g][d], curr);
            }

            for(int d = M-1; d >= 0; --d) {
                dp[g][d] = Math.max(dp[g][d], dp[g][d+1]);
                res = Math.max(res, dp[g][d]);
            }
        }
        return res;
    }
}
