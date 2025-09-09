package com.leetcode.dynamic_programming.medium;

public class LeetCode1493 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][n+2];

        int res = 0;
        for(int i = 2; i < n+2; ++i) {
            int j = i-2;
            if(nums[j] == 1) {
                dp[0][i] = 1 + dp[0][i-1];
                dp[1][i] = 1 + (dp[1][i-1] == 0 ? dp[0][i-2] : dp[1][i-1]);
            }
            res = Math.max(res, Math.max(dp[0][i], dp[1][i]));
        }

        return res == n ? res - 1 : res;
    }
}
